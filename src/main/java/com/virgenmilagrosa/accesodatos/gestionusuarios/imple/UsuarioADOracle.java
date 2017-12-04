/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virgenmilagrosa.accesodatos.gestionusuarios.imple;

import com.virgenmilagrosa.accesodatos.gestionusuarios.UsuarioAD;
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
public class UsuarioADOracle implements UsuarioAD{

    private static final Log LOG = LogFactory.getLog(UsuarioADOracle.class);
    
    private AccesoBD acceso = AccesoBD.getInstance();

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
    public Usuario buscarUsuario(String codUsuario) {

        Usuario usuario = null;

        try {
            LOG.info("Abriendo conexion");
            Connection conexion = acceso.getConexion();
            LOG.info("Llamando procedimiento 'SP_BUSCAR_USUARIO'");
            
            try (CallableStatement consulta = conexion.prepareCall("{ CALL SP_BUSCAR_USUARIO (?,?) }")) {

                consulta.setString(1, codUsuario);
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
                        
                        LOG.info("Listando el objeto=" + usuario);
                    }

                }
            }
        } catch (SQLException ex) {
            LOG.error("Ha ocurrido una excepcion=" + ex);
        } finally {
            LOG.info("Cerrando conexion");
            acceso.close();
        }
        return usuario;

    }

    @Override
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
