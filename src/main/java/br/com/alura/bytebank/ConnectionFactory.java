package br.com.alura.bytebank;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection recuperarConexao(){
        try {
            return createDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private HikariDataSource createDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:sqlserver://${DB_HOST};databaseName=${DB_NAME};encrypt=false;");
        config.setUsername("${DB_USER}");
        config.setPassword("DB_PASSWORD");
        config.setMaximumPoolSize(10);

        return new HikariDataSource(config);
    }

}
