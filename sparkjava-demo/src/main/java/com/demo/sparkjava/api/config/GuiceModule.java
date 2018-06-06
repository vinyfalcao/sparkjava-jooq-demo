package com.demo.sparkjava.api.config;

import com.demo.sparkjava.api.Application;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class GuiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Application.class).in(Singleton.class);
	}

	@Provides
	@Singleton
	private ObjectMapper provideObjectMapper() {
		return new ObjectMapper();
	}
}