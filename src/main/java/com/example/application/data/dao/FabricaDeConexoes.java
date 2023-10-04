package com.example.application.data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
class FabricaDeConexoes {
    private final static String URL = "jdbc:sqlite:locadora.db";

    public static Connection get() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
