/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author PRIDE ANACONDA
 */
public class ConexionSQL {
    Connection conexion;
    public Connection crearConexion() {
        
        String user = "root";
        String password = "";
        String jdbc = "jdbc:mysql://127.0.0.1:3306/residuostoxicos";
        try {
            conexion = DriverManager.getConnection(jdbc, user, password);
            return conexion; 
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null; 
    }
  


}
