package com.demo.sparkjava.api.store.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.demo.sparkjava.api.GuiceClassRule;
import com.demo.sparkjava.api.config.GuiceModuleTest;
import com.demo.sparkjava.api.databasemodel.tables.pojos.Store;
import com.demo.sparkjava.api.store.dao.StoreDAO;
import com.demo.sparkjava.api.util.RequestsUtil;
import com.demo.sparkjava.api.util.StoreUtil;
import com.google.gson.reflect.TypeToken;

@RunWith(MockitoJUnitRunner.class)
public class StoreControllerTest {

    private static final String BASE_URL = "http://localhost:9999/";

    @ClassRule
    public static GuiceClassRule server = new GuiceClassRule(new GuiceModuleTest());

    @Test
    public void test_findAllStores() {
	when(server.getInstance(StoreDAO.class).findAll())
		.thenReturn(Arrays.asList(new Store(UUID.randomUUID().toString(), "Teste Store")));

	HttpResponse response = RequestsUtil.GET(BASE_URL + "stores");
	assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
	List<Store> stores = RequestsUtil.jsonToObject(response, getStoreListType());
	assertThat(stores.size(), equalTo(1));
    }

    @Test
    public void test_findStoresByName() {
	String storeName = "Store";
	when(server.getInstance(StoreDAO.class).findByName(any(String.class)))
		.thenReturn(Arrays.asList(StoreUtil.newInstance("My Store"), StoreUtil.newInstance("My Store 2")));

	HttpResponse response = RequestsUtil.GET(BASE_URL + "/storesByName/" + storeName);
	assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
	List<Store> stores = RequestsUtil.jsonToObject(response, getStoreListType());
	assertThat(stores.size(), equalTo(2));
	for (Store store : stores) {
	    assertThat(store.getName(), containsString(storeName));
	}
    }

    @Test
    public void test_insertStore() {
	Store store = new Store(UUID.randomUUID().toString(), "Store Insert Test");
	when(server.getInstance(StoreDAO.class).save(any())).thenReturn(store);
	HttpResponse response = RequestsUtil.POST(BASE_URL + "stores", store);
	assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
	Store storeResponse = RequestsUtil.jsonToObject(response, Store.class);
	assertThat(store.getUuid(), equalTo(storeResponse.getUuid()));
    }

    @Test
    public void test_deleteStore() {
	HttpResponse response = RequestsUtil.DELETE(BASE_URL + "stores/" + UUID.randomUUID().toString());
	assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    private Type getStoreListType() {
	return new TypeToken<List<Store>>() {
	}.getType();
    }

}
