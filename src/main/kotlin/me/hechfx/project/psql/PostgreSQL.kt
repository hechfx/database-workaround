package me.hechfx.project.psql

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import me.hechfx.project.psql.table.Users
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

class PostgreSQL {
    companion object {
        fun start() {
            val config = HikariConfig().apply {
                jdbcUrl = "jdbc:postgresql://127.0.0.1:5432/senichi"
                driverClassName = "org.postgresql.Driver"
                username = "postgres"
                password = "fxhech2446"
            }

            Database.connect(HikariDataSource(config))

            transaction {
                SchemaUtils.create(Users)
            }
        }
    }
}