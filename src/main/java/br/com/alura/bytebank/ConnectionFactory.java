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
        config.setJdbcUrl("jdbc:sqlserver://192.100.100.132;databaseName=treinamento_java;encrypt=false;");
        config.setUsername("java");
        config.setPassword("Java@123");
        config.setMaximumPoolSize(10);

        return new HikariDataSource(config);
    }

}
