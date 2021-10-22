package io.github.gilbertodamim.essentials.database

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.github.gilbertodamim.essentials.config.configs.DatabaseConfig.sqlDatabase
import io.github.gilbertodamim.essentials.config.configs.DatabaseConfig.sqlIp
import io.github.gilbertodamim.essentials.config.configs.DatabaseConfig.sqlPassword
import io.github.gilbertodamim.essentials.config.configs.DatabaseConfig.sqlPort
import io.github.gilbertodamim.essentials.config.configs.DatabaseConfig.sqlType
import io.github.gilbertodamim.essentials.config.configs.DatabaseConfig.sqlUsername
import io.github.gilbertodamim.essentials.config.langs.StartLang.*
import io.github.gilbertodamim.essentials.management.Manager.consoleMessage
import io.github.gilbertodamim.essentials.management.Manager.pluginPasteDir
import org.jetbrains.exposed.sql.Database

class SqlSelector {
    init {
        consoleMessage(connectDatabase)
        try {
            when (sqlType.lowercase()) {
                "sqlite" -> {
                    SqlInstance.SQL =
                        Database.connect("jdbc:sqlite:${pluginPasteDir()}/EssentialsGD.db", "org.sqlite.JDBC")
                }
                "h2" -> {
                    SqlInstance.SQL = Database.connect("jdbc:h2:./${pluginPasteDir()}/EssentialsGD", "org.h2.Driver")
                }
                "mysql" -> {
                    val config = HikariConfig().apply {
                        jdbcUrl = "jdbc:mysql://$sqlIp:$sqlPort/$sqlDatabase"
                        driverClassName = "com.mysql.cj.jdbc.Driver"
                        username = sqlUsername
                        password = sqlPassword
                        maximumPoolSize = 40
                    }
                    val dataSource = HikariDataSource(config)
                    SqlInstance.SQL = Database.connect(dataSource)
                }
                else -> {
                    consoleMessage(databaseValid)
                }
            }
            consoleMessage(connectDatabaseSuccess.replace("%db%", sqlType.lowercase()))
        } catch (ex: Exception) {
            consoleMessage(connectDatabaseError)
        }
    }
}