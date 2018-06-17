package com.demo.sparkjava.api.util;

import java.util.UUID;

import com.demo.sparkjava.api.databasemodel.tables.pojos.Store;


public class StoreUtil {

	public static Store newInstance(String name) {
		return new Store(UUID.randomUUID().toString(), name);
	}
	
	
}
