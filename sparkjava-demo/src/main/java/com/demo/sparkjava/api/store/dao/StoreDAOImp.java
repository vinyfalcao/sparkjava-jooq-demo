package com.demo.sparkjava.api.store.dao;

import static com.demo.sparkjava.api.databasemodel.Tables.STORE;

import java.util.List;

import org.jooq.DSLContext;

import com.demo.sparkjava.api.databasemodel.tables.pojos.Store;
import com.demo.sparkjava.api.databasemodel.tables.records.StoreRecord;
import com.google.inject.Inject;

public class StoreDAOImp implements StoreDAO {

	private DSLContext dslContext;

	@Inject
	public StoreDAOImp(DSLContext dslContext) {
		this.dslContext = dslContext;
	}

	@Override
	public List<Store> findAll() {
		return dslContext.selectFrom(STORE).fetch().into(Store.class);
	}

	@Override
	public List<Store> findByName(String name) {
		return dslContext.selectFrom(STORE).where(STORE.NAME.likeIgnoreCase(name)).fetch().into(Store.class);
	}

	@Override
	public Store findByUuid(String uuid) {
		return dslContext.fetchOne(STORE, STORE.UUID.eq(uuid)).into(Store.class);
	}

	@Override
	public Store save(Store store) {
		StoreRecord newStore =  dslContext.newRecord(STORE, store);
		newStore.store();
		return newStore.into(Store.class);
	}

	@Override
	public void delete(String uuid) {
		dslContext.fetchOne(STORE, STORE.UUID.eq(uuid)).delete();
	}

}
