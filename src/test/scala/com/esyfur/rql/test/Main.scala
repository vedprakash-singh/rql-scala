package com.esyfur.rql.test

import com.esyfur.{rql => r}

object Main {

    val host = "devroom"
    val db   = "lalala"

    def main(args: Array[String]) {
        val conn = r.connect(host).repl()
        conn.use(db)

        r.dbList.run
        r.db(db).tableList.run(conn)
        conn.db.tableList.run
        //r.db(db).tableCreate("lalala").run()
        r.db(db).table("lalala").count().run()

        println("Yay")

        conn.close()
    }

}
