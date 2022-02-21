package com.noroff.Ass2DataAccess.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    static final String URL="jdbc:sqlite::resource:Northwind_small.sqlite";
    static private ConnectionManager instance; // singleton instance
    private Connection connection;

    static ConnectionManager getInstance() {
        if(instance == null)
            instance = new ConnectionManager();

        return instance;
    }

    private ConnectionManager() {
        try {
            connection = DriverManager.getConnection(URL);
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            System.exit(-1);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
