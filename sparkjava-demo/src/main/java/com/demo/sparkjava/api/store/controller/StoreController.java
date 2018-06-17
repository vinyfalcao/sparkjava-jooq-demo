package com.demo.sparkjava.api.store.controller;

import com.demo.sparkjava.api.commom.controller.JsonTransformer;
import com.demo.sparkjava.api.databasemodel.tables.pojos.Store;
import com.demo.sparkjava.api.store.service.StoreService;
import com.google.gson.Gson;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import static spark.Spark.*;

@Singleton
public class StoreController {

	@Inject
	private StoreService storeService;

	public void registry() {
		get("/stores", "application/json", (req, res) -> {
			return storeService.findAll();
		}, new JsonTransformer());

		get("/stores/:uuid", (req, res) -> {
			return storeService.findByUuid(req.params("uuid"));
		}, new JsonTransformer());

		get("/storesByName/:name", (req, res) -> {
			return storeService.findByName(req.params("name"));
		}, new JsonTransformer());

		post("/stores", (req, res) -> {
			return storeService.save(new Gson().fromJson(req.body(), Store.class));
		}, new JsonTransformer());

		put("/stores", (req, res) -> {
			return storeService.save(new Gson().fromJson(req.body(), Store.class));
		}, new JsonTransformer());

		delete("/stores/:uuid", (req, res) -> {
			storeService.delete(req.params("uuid"));
			return "deleted";
		});

	}

}
