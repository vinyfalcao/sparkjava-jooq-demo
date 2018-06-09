package com.demo.sparkjava.api.config;

import javax.sql.DataSource;

import org.aopalliance.intercept.MethodInterceptor;
import org.jooq.DSLContext;

import com.google.inject.persist.PersistModule;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.UnitOfWork;

/**
 * 
 * @author Vinicius Falcão
 *
 */
public class JooqPersistenceModule extends PersistModule {

	private MethodInterceptor transactionInterceptor;

	@Override
	protected void configurePersistence() {
		bind(DSLContext.class).toProvider(JooqPersistService.class);
		bind(DataSource.class).toProvider(DataSourceProvider.class);
		bind(PersistService.class).to(JooqPersistService.class);
		bind(UnitOfWork.class).to(JooqPersistService.class);
		transactionInterceptor = new JdbcLocalTxnInterceptor(getProvider(JooqPersistService.class),
				getProvider(UnitOfWork.class));
		requestInjection(transactionInterceptor);
	}

	@Override
	protected MethodInterceptor getTransactionInterceptor() {
		return transactionInterceptor;
	}

}
