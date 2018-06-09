package com.demo.sparkjava.api.store.service;

import java.util.List;

import com.demo.sparkjava.api.databasemodel.tables.pojos.Store;
import com.google.inject.ImplementedBy;

@ImplementedBy(StoreServiceImp.class)
public interface StoreService {

	List<Store> findAll();
}
