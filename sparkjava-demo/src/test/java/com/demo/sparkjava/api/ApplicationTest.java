package com.demo.sparkjava.api;

import com.demo.sparkjava.api.config.GuiceModuleTest;
import com.demo.sparkjava.api.store.controller.StoreController;
import com.google.inject.Guice;
import com.google.inject.Inject;

import static spark.Spark.port;
import static spark.Spark.stop;

public class ApplicationTest {

	@Inject
	private StoreController storeController;
	
	ApplicationTest run(final int port) {
		port(port);
		storeController.registry();
		return this;
	}
	
	public void stopServer(){
		stop();
	}

	public static ApplicationTest init() {
		return Guice.createInjector(new GuiceModuleTest()).getInstance(ApplicationTest.class).run(9999);
	}

	public StoreController getStoreController() {
		return storeController;
	}

}
