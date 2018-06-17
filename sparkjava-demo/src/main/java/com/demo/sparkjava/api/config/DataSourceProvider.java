package com.demo.sparkjava.api.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import com.google.inject.Provider;
import com.jolbox.bonecp.BoneCPDataSource;
public class DataSourceProvider implements Provider<DataSource> {

	@Override
	public DataSource get() {
		Properties p = new Properties();
        try {
			p.load(DataSourceProvider.class.getResourceAsStream("/application_test.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BoneCPDataSource dataSource = new BoneCPDataSource();
		dataSource.setDriverClass(p.getProperty("jdbc.driver"));
		dataSource.setJdbcUrl(p.getProperty("jdbc.url"));
		dataSource.setUsername(p.getProperty("jdbc.username"));
		dataSource.setPassword(p.getProperty("jdbc.password"));
		dataSource.setDefaultAutoCommit(false);
        return dataSource;
	}

}
