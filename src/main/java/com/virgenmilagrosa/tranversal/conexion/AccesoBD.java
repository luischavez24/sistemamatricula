/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virgenmilagrosa.tranversal.conexion;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author Jose Carlos
 */
public class AccesoBD {
    
    private final static AccesoBD CONNECTION = new AccesoBD();
    private OracleDataSource datasource;
    private Connection miConexion;

    private AccesoBD() {
        try {
            miConexion = null;
            datasource = new OracleDataSource();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static AccesoBD getInstance() {
        return CONNECTION;
    }

    public Connection getConexion(DataSource source) {
        try {
            miConexion = source.getConnection();
        } catch (SQLException e) {
            System.err.printf("A ocurrido el siguiente error en la aplicacion: %s\n", e.getMessage());
        }
        return miConexion;
    }


    public Connection getConexion() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            datasource.setURL("jdbc:oracle:thin:@HOST1:1521:xe");
            datasource.setUser("sistema_matricula");
            datasource.setPassword("Prueba$1");
            datasource.setLoginTimeout(5000);
            miConexion = datasource.getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return miConexion;
    }

    public int close() {
        int error = 0;
        try {
            miConexion.close();
        } catch (SQLException e) {
            error = 1;
        }

        return error;
    }
}
