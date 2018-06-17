package com.demo.sparkjava.api;

import com.demo.sparkjava.api.store.controller.StoreController;
import com.google.inject.Inject;

import static spark.Spark.port;
import static spark.Spark.stop;


public class SparkServer {

	@Inject
	private StoreController storeController;
	
	
	public void startServer(int port) {
		port(port);
		storeController.registry();
	}
	
	public void stopServer() {
		stop();
	}
	
}
