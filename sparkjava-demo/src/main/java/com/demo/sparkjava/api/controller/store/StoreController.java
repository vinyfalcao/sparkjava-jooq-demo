package com.demo.sparkjava.api.controller.store;

import com.google.inject.Singleton;

import static spark.Spark.get;

@Singleton
public class StoreController {

	
	public void registry() {
		get("/hello", (req, res) -> "Hello World");
	}

}
