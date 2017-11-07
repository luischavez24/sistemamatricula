/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virgenmilagrosa.accesodatos.gestionusuarios;

import com.virgenmilagrosa.accesodatos.gestionalumnos.Grado_AD;
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
import java.sql.Types;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Jose Carlos
 */
public class Usuario_AD {

    private static final Log LOG = LogFactory.getLog(Usuario_AD.class);
    
    private static final Usuario_AD INSTANCE = new Usuario_AD();

    private Usuario_AD() {
    }

    public static Usuario_AD getInstance() {
        return INSTANCE;
    }

    private AccesoBD acceso = AccesoBD.getInstance();

    public List<Usuario> listarUsuarios() {

        List<Usuario> lista = new ArrayList<>();

        try {
            Connection conexion = acceso.getConexion();

            try (CallableStatement consulta = conexion.prepareCall("{ CALL SP_LISTAR_USUARIO (?) }")) {

                consulta.registerOutParameter(1, OracleTypes.CURSOR);
                consulta.execute();

                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(1)) {

                    Usuario temp;
                    int codUsuario, rol;
                    String apaternoUsuario, nombre, amaternoUsuario, dniUsuario, telfUsuario, username;
                    while (resultado.next()) {
                        codUsuario = resultado.getInt(1);
                        apaternoUsuario = resultado.getString(2);
                        nombre = resultado.getString(3);
                        amaternoUsuario = resultado.getString(4);
                        dniUsuario = resultado.getString(5);
                        telfUsuario = resultado.getString(6);
                        username = resultado.getString(7);
                        rol = resultado.getInt(8);
                        temp = new Usuario(codUsuario, apaternoUsuario, nombre,
                                amaternoUsuario, dniUsuario, telfUsuario,
                                username, rol);

                        lista.add(temp);
                    }
                }
            }
        } catch (SQLException ex) {
            lista = null;
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
                consulta.setInt(1, usuario.getCodUsuario());
                consulta.setString(2, usuario.getaPaternoUsuario());
                consulta.setString(3, usuario.getNombre());
                consulta.setString(4, usuario.getaMaternoUsuario());
                consulta.setString(5, usuario.getDniUsuario());
                consulta.setString(6, usuario.getTelfUsuario());
                consulta.setString(7, usuario.getUsername());
                consulta.setString(8, usuario.getPassword());
                consulta.setInt(9, usuario.getRol());
                consulta.execute();
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
                consulta.setInt(1, usuario.getCodUsuario());
                consulta.setString(2, usuario.getTelfUsuario());

                consulta.execute();

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
                consulta.setInt(1, usuario.getCodUsuario());
                consulta.setString(2, usuario.getPassword());
                consulta.setString(3, password);

                consulta.execute();

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
                consulta.execute();
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
            LOG.info("Abriendo conexion");
            Connection conexion = acceso.getConexion();
            LOG.info("Llamando procedimiento 'SP_BUSCAR_USUARIO'");
            
            try (CallableStatement consulta = conexion.prepareCall("{ CALL SP_BUSCAR_USUARIO (?,?) }")) {

                consulta.setInt(1, codUsuario);
                consulta.registerOutParameter(2, OracleTypes.CURSOR);
                
                LOG.info("Ejecuntado procedimiento");
                consulta.execute();
                
                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(2)) {
                    
                    
                    if (resultado.next()) {
                        String apaternoUsuario, nombre, amaternoUsuario, dniUsuario, telfUsuario, username;
                        int codU, rol;
                        codU = resultado.getInt(1);
                        apaternoUsuario = resultado.getString(2);
                        nombre = resultado.getString(3);
                        amaternoUsuario = resultado.getString(4);
                        dniUsuario = resultado.getString(5);
                        telfUsuario = resultado.getString(6);
                        username = resultado.getString(7);
                        rol = resultado.getInt(8);
                        usuario = new Usuario(codU, apaternoUsuario, nombre,
                                amaternoUsuario, dniUsuario, telfUsuario,
                                username, rol);
                        
                        LOG.info("Añadiendo el objeto=" + usuario);
                    }

                }
            }
        } catch (SQLException ex) {
            LOG.info("Ha ocurrido una excepcion=" + ex);
        } finally {
            LOG.info("Cerrando conexion");
            acceso.close();
        }
        return usuario;

    }

    public int verificarUsuario(String username, String password) {

        int verificacion = 0;

        try {
            Connection conexion = acceso.getConexion();
            try (CallableStatement consulta = conexion.prepareCall("{ ? = call FN_VERIFICAR_USUARIO (?,?) }")) {

                consulta.registerOutParameter(1, Types.NUMERIC);
                consulta.setString(2, username);
                consulta.setString(3, password);
                consulta.execute();

                verificacion = consulta.getInt(1);
            }
        } catch (SQLException ex) {
            verificacion = -1;
        } finally {
            acceso.close();
        }
        return verificacion;

    }

}
