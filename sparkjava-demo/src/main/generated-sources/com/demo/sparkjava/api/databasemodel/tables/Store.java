/*
 * This file is generated by jOOQ.
*/
package com.demo.sparkjava.api.databasemodel.tables;


import com.demo.sparkjava.api.databasemodel.Public;
import com.demo.sparkjava.api.databasemodel.tables.records.StoreRecord;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class Store extends TableImpl<StoreRecord> {

    private static final long serialVersionUID = -1528411937;

    /**
     * The reference instance of <code>public.store</code>
     */
    public static final Store STORE = new Store();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<StoreRecord> getRecordType() {
        return StoreRecord.class;
    }

    /**
     * The column <code>public.store.uuid</code>.
     */
    public final TableField<StoreRecord, String> UUID = createField("uuid", org.jooq.impl.SQLDataType.VARCHAR(36), this, "");

    /**
     * The column <code>public.store.name</code>.
     */
    public final TableField<StoreRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(200), this, "");

    /**
     * Create a <code>public.store</code> table reference
     */
    public Store() {
        this(DSL.name("store"), null);
    }

    /**
     * Create an aliased <code>public.store</code> table reference
     */
    public Store(String alias) {
        this(DSL.name(alias), STORE);
    }

    /**
     * Create an aliased <code>public.store</code> table reference
     */
    public Store(Name alias) {
        this(alias, STORE);
    }

    private Store(Name alias, Table<StoreRecord> aliased) {
        this(alias, aliased, null);
    }

    private Store(Name alias, Table<StoreRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Store as(String alias) {
        return new Store(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Store as(Name alias) {
        return new Store(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Store rename(String name) {
        return new Store(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Store rename(Name name) {
        return new Store(name, null);
    }
}
