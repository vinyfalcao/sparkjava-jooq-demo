package com.demo.sparkjava.api.config;

import static org.mockito.Mockito.mock;

import javax.sql.DataSource;

import org.aopalliance.intercept.MethodInterceptor;
import org.jooq.DSLContext;

import com.google.inject.persist.PersistModule;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.UnitOfWork;


public class JooqPersistenceModuleTest extends PersistModule{

	@Override
	protected void configurePersistence() {
		//bind(DSLContext.class).toInstance(mock(DSLContext.class));
		//bind(DataSource.class).toInstance(mock(DataSource.class));
		//bind(PersistService.class).toInstance(mock(JooqPersistService.class));
		//bind(UnitOfWork.class).toInstance(mock(JooqPersistService.class));
	}

	@Override
	protected MethodInterceptor getTransactionInterceptor() {
		return null;
	}

}
