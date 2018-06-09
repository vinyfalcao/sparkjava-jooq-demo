package com.demo.sparkjava.api.store.dao;

import java.util.List;

import com.demo.sparkjava.api.databasemodel.tables.pojos.Store;
import com.google.inject.ImplementedBy;

@ImplementedBy(StoreDAOImp.class)
public interface StoreDAO {

	List<Store> findAll();

}
