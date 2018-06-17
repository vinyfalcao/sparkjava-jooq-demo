package com.demo.sparkjava.api.store.controller;

import com.demo.sparkjava.api.config.GuiceModuleTest;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class StoreControllerTestInjector{

	public static Injector init() {
		return Guice.createInjector(new GuiceModuleTest());
	}
}
