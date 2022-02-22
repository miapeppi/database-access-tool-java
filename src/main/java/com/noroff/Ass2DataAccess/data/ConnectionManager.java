package com.noroff.Ass2DataAccess.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager implements AutoCloseable{
    static {
        try {
            DriverManager.registerDriver(new org.sqlite.JDBC());
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    static final String URL="jdbc:sqlite::resource:Chinook_Sqlite.sqlite";
    static private ConnectionManager instance; // singleton instance
    private Connection connection;

    static ConnectionManager getInstance() {
        if(instance == null)
            instance = new ConnectionManager();

        return instance;
    }

    private ConnectionManager() {}

    public Connection getConnection() throws SQLException{
        if(connection == null) {
            connection = DriverManager.getConnection(URL);
        }
        return connection;
    }

    @Override
    public void close() throws SQLException {
        this.connection.close();
        this.connection = null;
    }
}
