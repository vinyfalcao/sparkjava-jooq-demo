package com.demo.sparkjava.api.config;

import static org.mockito.Mockito.mock;

import org.jooq.DSLContext;

import com.demo.sparkjava.api.store.dao.StoreDAO;
import com.google.inject.AbstractModule;


public class GuiceModuleTest extends AbstractModule{

	@Override
	protected void configure() {
		bind(StoreDAO.class).toInstance(mock(StoreDAO.class));
		bind(DSLContext.class).toInstance(mock(DSLContext.class));
	}

}
