/*
 * This file is generated by jOOQ.
*/
package com.demo.sparkjava.api.databasemodel.tables.records;


import com.demo.sparkjava.api.databasemodel.tables.Store;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class StoreRecord extends TableRecordImpl<StoreRecord> implements Record2<String, String> {

    private static final long serialVersionUID = -2134734974;

    /**
     * Setter for <code>store.store.uuid</code>.
     */
    public StoreRecord setUuid(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>store.store.uuid</code>.
     */
    public String getUuid() {
        return (String) get(0);
    }

    /**
     * Setter for <code>store.store.name</code>.
     */
    public StoreRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>store.store.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Store.STORE_.UUID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Store.STORE_.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getUuid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getUuid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StoreRecord value1(String value) {
        setUuid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StoreRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StoreRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached StoreRecord
     */
    public StoreRecord() {
        super(Store.STORE_);
    }

    /**
     * Create a detached, initialised StoreRecord
     */
    public StoreRecord(String uuid, String name) {
        super(Store.STORE_);

        set(0, uuid);
        set(1, name);
    }
}
