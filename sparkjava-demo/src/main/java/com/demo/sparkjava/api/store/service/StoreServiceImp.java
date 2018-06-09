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

}
