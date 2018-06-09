package com.demo.sparkjava.api.controller.store;

import com.demo.sparkjava.api.store.service.StoreService;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import static spark.Spark.get;

@Singleton
public class StoreController {

	@Inject
	private StoreService storeService;

	public void registry() {
		get("/stores", "application/json", (req, res) -> {
			return storeService.findAll();
		}, new JsonTransformer());
	}

}
