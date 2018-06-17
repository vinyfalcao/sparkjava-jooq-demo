package com.demo.sparkjava.api.util;

import java.io.IOException;
import java.lang.reflect.Type;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

public class RequestsUtil {

    public static HttpResponse GET(String URL) {
	HttpUriRequest request = new HttpGet(URL);
	return sendRequest(request);
    }

    public static HttpResponse POST(String URL, Object body) {
	HttpPost request = new HttpPost(URL);
	request.setEntity(new ByteArrayEntity(new Gson().toJson(body).getBytes()));
	return sendRequest(request);
    }
    
    public static HttpResponse DELETE(String URL) {
	HttpUriRequest request = new HttpDelete(URL);
	return sendRequest(request);
    }

    public static <T> T jsonToObject(HttpResponse response, Type type) {
	String jsonFromResponse;
	try {
	    jsonFromResponse = EntityUtils.toString(response.getEntity());
	} catch (ParseException | IOException e) {
	    throw new RuntimeException("Error parsing response", e);
	}
	return new Gson().fromJson(jsonFromResponse, type);
    }

    private static HttpResponse sendRequest(HttpUriRequest request) {
	try {
	    return HttpClientBuilder.create().build().execute(request);
	} catch (IOException e) {
	    throw new RuntimeException("Error on GET Request", e);
	}
    }

}
