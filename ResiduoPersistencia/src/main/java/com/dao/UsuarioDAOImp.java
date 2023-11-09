/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.dto.DTOUsuario;
import com.mysql.ConexionSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author PRIDE ANACONDA
 */
public class UsuarioDAOImp implements IUsuarioDAO {

    ConexionSQL conexionSQL = new ConexionSQL();
    Connection conexion = conexionSQL.crearConexion();

    @Override
    public DTOUsuario consultaCredenciales(String usuario, String password) {

        //Connection conexionDBUsuario = conexion.crearConexion();
        try {

            Statement st = conexion.createStatement();
            String query = "SELECT * FROM usuario WHERE USUARIO = ? AND PASSWORD_USER = ?";
            try ( PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setString(1, usuario);
                preparedStatement.setString(2, password);
                System.out.println("Dentro de la asignacion de valores 1");
                System.out.println(preparedStatement.toString());
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {

                    int id = rs.getInt("id");

                    String tipo = (String) rs.getString("tipo");

                    String nombre = (String) rs.getString("nombre");

                    String usuario_cuenta = (String) rs.getString("Usuario");

                    String password_usuario = (String) rs.getString("Password_user");

                    DTOUsuario user=  new DTOUsuario((long)id, tipo, nombre, usuario_cuenta, password_usuario);
                    if(user!=null){
                        return user;
                    }else{
                        return null;
                    }
                   
                }

                rs.close();
                preparedStatement.close();
                // Resto del código para manejar el ResultSet
            } catch (SQLException e) {
                // Manejar la excepción

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
