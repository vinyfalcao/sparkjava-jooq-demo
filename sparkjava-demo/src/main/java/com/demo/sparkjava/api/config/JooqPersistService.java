package com.demo.sparkjava.api.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConnectionProvider;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.UnitOfWork;

@Singleton
public class JooqPersistService implements Provider<DSLContext>, UnitOfWork, PersistService {

	private final ThreadLocal<DSLContext> threadFactory = new ThreadLocal<DSLContext>();
	private final ThreadLocal<DefaultConnectionProvider> threadConnection = new ThreadLocal<DefaultConnectionProvider>();
	private final DataSource jdbcSource;
	private final SQLDialect sqlDialect;

	@Inject(optional = true)
	private Settings jooqSettings = null;

	@Inject(optional = true)
	private Configuration configuration = null;

	@Inject
	public JooqPersistService(final DataSource jdbcSource) {
		this.jdbcSource = jdbcSource;
		this.sqlDialect = SQLDialect.POSTGRES_9_3;
	}

	public DSLContext get() {
		begin();
		DSLContext factory = threadFactory.get();
		if (null == factory) {
			throw new IllegalStateException("Requested Factory outside work unit. "
					+ "Try calling UnitOfWork.begin() first, use @Transactional annotation"
					+ "or use a PersistFilter if you are inside a servlet environment.");
		}

		return factory;
	}

	public DefaultConnectionProvider getConnectionWrapper() {
		return threadConnection.get();
	}

	public boolean isWorking() {
		return threadFactory.get() != null;
	}

	public void begin() {
		if (null != threadFactory.get()) {
			throw new IllegalStateException(
					"Work already begun on this thread. " + "It looks like you have called UnitOfWork.begin() twice"
							+ " without a balancing call to end() in between.");
		}

		DefaultConnectionProvider conn;
		try {
			conn = new DefaultConnectionProvider(jdbcSource.getConnection());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		DSLContext jooqFactory;

		if (configuration != null) {
			jooqFactory = DSL.using(configuration);
		} else {
			if (jooqSettings == null) {
				jooqFactory = DSL.using(conn, sqlDialect);
			} else {
				jooqFactory = DSL.using(conn, sqlDialect, jooqSettings);
			}
		}
		threadConnection.set(conn);
		threadFactory.set(jooqFactory);
	}

	public void end() {
		DSLContext jooqFactory = threadFactory.get();
		DefaultConnectionProvider conn = threadConnection.get();
		// Let's not penalize users for calling end() multiple times.
		if (null == jooqFactory) {
			return;
		}

		try {
			conn.acquire().close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		threadFactory.remove();
		threadConnection.remove();
	}

	public synchronized void start() {
		// nothing to do on start
	}

	public synchronized void stop() {
		// nothing to do on stop
	}

}
