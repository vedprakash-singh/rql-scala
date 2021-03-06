package com.esyfur.rql.test

import org.scalatest.ConfigMap
import com.esyfur.{rql => r}
import r.Connection

trait ConnectionAndDatabase extends SuppliedConfig {

    protected var connection: Connection = _

    protected override def beforeAll(configMap: ConfigMap): Unit = {
        super.beforeAll(configMap)

        connection = r.connect(dbHost, dbPort, dbName).repl()
        connection.db.create.run
    }

    protected override def afterAll(): Unit = {
        connection.db.drop.run
        connection.close()
    }

}
