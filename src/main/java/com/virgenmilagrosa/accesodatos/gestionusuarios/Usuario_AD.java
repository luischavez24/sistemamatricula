/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virgenmilagrosa.accesodatos.gestionusuarios;

import com.virgenmilagrosa.tranversal.conexion.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import com.virgenmilagrosa.tranversal.entidades.*;

/**
 *
 * @author Jose Carlos
 */
public class Usuario_AD {

    AccesoBD acceso = AccesoBD.getInstance();

    public List<Usuario> listarUsuarios() {

        List<Usuario> lista = new ArrayList<>();

        try {
            Connection conexion = acceso.getConexion();
            try (CallableStatement consulta = conexion.prepareCall("{ CALL SP_LISTAR_USUARIO (?) }")) {
                consulta.registerOutParameter(1, OracleTypes.CURSOR);
                consulta.execute();
                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(1)) {
                    Usuario temp;
                    int codUsuario;
                    String apaternoUsuario, nombre, amaternoUsuario, dniUsuario, telfUsuario, username;
                    while (resultado.next()) {
                        codUsuario = resultado.getInt(1);
                        apaternoUsuario = resultado.getString(2);
                        nombre = resultado.getString(3);
                        amaternoUsuario = resultado.getString(4);
                        dniUsuario = resultado.getString(5);
                        telfUsuario = resultado.getString(6);
                        username = resultado.getString(7);
                        temp = new Usuario(codUsuario, apaternoUsuario, nombre, amaternoUsuario, dniUsuario, telfUsuario, username);

                        lista.add(temp);
                    }
                }
            }
        } catch (SQLException ex) {

        } finally {
            acceso.close();
        }
        return lista;

    }

    public String registrarUsuario(Usuario usuario) {

        String respuesta = "Insercion Completada";

        try {
            Connection conexion = acceso.getConexion();
            conexion.setAutoCommit(false);
            try (CallableStatement consulta = conexion.prepareCall("{CALL SP_REGISTRAR_USUARIO (?,?,?,?,?,?,?,?)}")) {
                consulta.setInt(1, usuario.getCodigo());
                consulta.setString(2, usuario.getAPaterno());
                consulta.setString(3, usuario.getNombre());
                consulta.setString(4, usuario.getAMaterno());
                consulta.setString(5, usuario.getDni());
                consulta.setString(6, usuario.getTelefono());
                consulta.setString(7, usuario.getUsername());
                consulta.setString(8, usuario.getPassword());

                respuesta = (consulta.executeUpdate() == 0) ? "No se pudo ejecutar la inserción" : "Correcto";
            }
            conexion.commit();
            acceso.close();
        } catch (SQLException ex) {
            respuesta = ex.getMessage();
        }
        return respuesta;

    }

    public String modificarUsuario(Usuario usuario) {

        String respuesta = "Actualizacion Completada";

        try {
            Connection conexion = acceso.getConexion();
            conexion.setAutoCommit(false);
            try (CallableStatement consulta = conexion.prepareCall("{CALL SP_MODIFICAR_USUARIO (?,?) }")) {
                consulta.setInt(1, usuario.getCodigo());
                consulta.setString(2, usuario.getTelefono());

                respuesta = (consulta.executeUpdate() == 0) ? "No se pudo ejecutar la actualizaron de datos" : "Correcto";

            }
            conexion.commit();
            acceso.close();
        } catch (SQLException ex) {
            respuesta = ex.getMessage();
        }
        return respuesta;

    }

    public String modificarPassword(Usuario usuario, String password) {

        String respuesta = "Actualizacion de Contraseña Completada";

        try {
            Connection conexion = acceso.getConexion();
            conexion.setAutoCommit(false);
            try (CallableStatement consulta = conexion.prepareCall("{CALL SP_MODIFICAR_PASSWORD (?,?,?) }")) {
                consulta.setInt(1, usuario.getCodigo());
                consulta.setString(2, usuario.getPassword());
                consulta.setString(3, password);

                respuesta = (consulta.executeUpdate() == 0) ? "No se pudo ejecutar la actualizaron de datos" : "Correcto";

            }
            conexion.commit();
            acceso.close();
        } catch (SQLException ex) {
            respuesta = ex.getMessage();
        }
        return respuesta;

    }

    public String eliminarUsuario(int codUsuario) {

        String respuesta = "Eliminacion Completada";

        try {
            Connection conn = acceso.getConexion();
            conn.setAutoCommit(false);
            try (CallableStatement consulta = conn.prepareCall("{ CALL SP_ELIMINAR_USUARIO (?)}")) {
                consulta.setInt(1, codUsuario);
                respuesta = (consulta.executeUpdate() == 0) ? "No se pudo ejecutar la eliminación de datos" : "Correcto";
            }
            conn.commit();
            acceso.close();
        } catch (SQLException ex) {
            respuesta = ex.getMessage();
        }
        return respuesta;

    }

    public Usuario buscarUsuario(int codUsuario) {

        Usuario usuario = null;

        try {
            Connection conexion = acceso.getConexion();
            try (CallableStatement consulta = conexion.prepareCall("{ CALL SP_BUSCAR_USUARIO (?) }")) {
                consulta.registerOutParameter(1, OracleTypes.CURSOR);
                consulta.setInt(1, codUsuario);
                consulta.execute();
                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(1)) {

                    String apaternoUsuario, nombre, amaternoUsuario, dniUsuario, telfUsuario, username;
                    codUsuario = resultado.getInt(1);
                    apaternoUsuario = resultado.getString(2);
                    nombre = resultado.getString(3);
                    amaternoUsuario = resultado.getString(4);
                    dniUsuario = resultado.getString(5);
                    telfUsuario = resultado.getString(6);
                    username = resultado.getString(7);
                    usuario = new Usuario(codUsuario, apaternoUsuario, nombre, amaternoUsuario, dniUsuario, telfUsuario, username);
                }
            }
        } catch (SQLException ex) {

        } finally {
            acceso.close();
        }
        return usuario;

    }
    
     public Usuario verificarUsuario (String username, String password) {

        Usuario usuario = null;

        try {
            Connection conexion = acceso.getConexion();
            try (CallableStatement consulta = conexion.prepareCall("{ CALL SP_VERIFICAR_USUARIO (?,?) }")) {
                consulta.registerOutParameter(1, OracleTypes.CURSOR);
                consulta.setString(1, username);
                consulta.setString(2, password);
                consulta.execute();
                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(1)) {

                    int codUsuario;
                    String apaternoUsuario, nombre, amaternoUsuario, dniUsuario, telfUsuario;
                    codUsuario = resultado.getInt(1);
                    apaternoUsuario = resultado.getString(2);
                    nombre = resultado.getString(3);
                    amaternoUsuario = resultado.getString(4);
                    dniUsuario = resultado.getString(5);
                    telfUsuario = resultado.getString(6);
                    usuario = new Usuario(codUsuario, apaternoUsuario, nombre, amaternoUsuario, dniUsuario, telfUsuario, username);
                }
            }
        } catch (SQLException ex) {

        } finally {
            acceso.close();
        }
        return usuario;

    }
    
}
