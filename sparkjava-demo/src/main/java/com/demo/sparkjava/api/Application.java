package com.demo.sparkjava.api;

import com.demo.sparkjava.api.config.GuiceModule;
import com.demo.sparkjava.api.config.JooqPersistenceModule;
import com.demo.sparkjava.api.controller.store.StoreController;
import com.google.inject.Guice;
import com.google.inject.Inject;

import static spark.Spark.port;

public class Application {

	@Inject
	private StoreController storeController;

	void run(final int port) {
		port(port);
		storeController.registry();
	}

	public static void main(String[] args) {
		Guice.createInjector(new GuiceModule(), new JooqPersistenceModule()).getInstance(Application.class).run(9999);
	}

}
