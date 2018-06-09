package com.demo.sparkjava.api.store.dao;

import static com.demo.sparkjava.api.databasemodel.Tables.STORE;

import java.util.List;

import org.jooq.DSLContext;

import com.demo.sparkjava.api.databasemodel.tables.pojos.Store;
import com.google.inject.Inject;

public class StoreDAOImp implements StoreDAO {

	private DSLContext dslCOntext;

	@Inject
	public StoreDAOImp(DSLContext dslCOntext) {
		this.dslCOntext = dslCOntext;
	}

	@Override
	public List<Store> findAll() {
		List<Store> result = dslCOntext.selectFrom(STORE).fetch().into(Store.class);
		return result;
	}

}
