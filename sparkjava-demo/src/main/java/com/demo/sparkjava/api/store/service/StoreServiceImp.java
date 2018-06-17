package com.demo.sparkjava.api.store.service;

import java.util.List;

import com.demo.sparkjava.api.databasemodel.tables.pojos.Store;
import com.demo.sparkjava.api.store.dao.StoreDAO;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * 
 * @author Vinicius Falcão
 *
 */
@Singleton
public class StoreServiceImp implements StoreService {

	@Inject
	private StoreDAO storeDAO;

	@Override
	public List<Store> findAll() {
		return storeDAO.findAll();
	}

	@Override
	public List<Store> findByName(String name) {
		return storeDAO.findByName(name);
	}

	@Override
	public Store findByUuid(String uuid) {
		return storeDAO.findByUuid(uuid);
	}

	@Override
	public Store save(Store store) {
		return storeDAO.save(store);
	}

	@Override
	public void delete(String uuid) {
		storeDAO.delete(uuid);
	}

}
