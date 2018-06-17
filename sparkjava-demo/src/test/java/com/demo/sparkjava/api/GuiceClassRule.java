package com.demo.sparkjava.api;

import org.junit.rules.ExternalResource;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceClassRule extends ExternalResource {

	private Injector injector;

	public GuiceClassRule(AbstractModule module) {
		super();
		injector = Guice.createInjector(module);
	}

	@Override
	protected void before() {
		injector.getInstance(SparkServer.class).startServer(9999);
	}

	@Override
	protected void after() {
		injector.getInstance(SparkServer.class).stopServer();
	}

	public <T> T getInstance(Class<T> clazz) {
		return injector.getInstance(clazz);
	}

}
