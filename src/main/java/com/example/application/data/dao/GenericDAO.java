package com.example.application.data.dao;
import java.sql.Connection;
import java.sql.SQLException;

public class GenericDAO {
    protected static Connection conn() throws SQLException{
        return FabricaDeConexoes.get();
    }
}
