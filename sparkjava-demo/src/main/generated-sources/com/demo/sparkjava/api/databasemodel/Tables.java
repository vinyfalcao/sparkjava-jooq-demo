/*
 * This file is generated by jOOQ.
*/
package com.demo.sparkjava.api.databasemodel;


import com.demo.sparkjava.api.databasemodel.tables.SchemaVersion;
import com.demo.sparkjava.api.databasemodel.tables.Store;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in store
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>store.schema_version</code>.
     */
    public static final SchemaVersion SCHEMA_VERSION = com.demo.sparkjava.api.databasemodel.tables.SchemaVersion.SCHEMA_VERSION;

    /**
     * The table <code>store.store</code>.
     */
    public static final Store STORE_ = com.demo.sparkjava.api.databasemodel.tables.Store.STORE_;
}
