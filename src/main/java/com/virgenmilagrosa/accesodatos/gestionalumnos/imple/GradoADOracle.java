/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virgenmilagrosa.accesodatos.gestionalumnos.imple;

import com.virgenmilagrosa.accesodatos.gestionalumnos.GradoAD;
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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 *
 * @author Jose Carlos
 */
public class GradoADOracle implements GradoAD {
    
    private AccesoBD acceso = AccesoBD.getInstance();
 
    private static final Log LOG = LogFactory.getLog(GradoADOracle.class);

    @Override
    public List<Grado> listarGrados() {

        List<Grado> lista = new ArrayList<>();

        try {
            
            LOG.info("Accediendo a la base de datos");
            
            Connection conexion = acceso.getConexion();
            
            LOG.info("Llamando a SP_LISTAR_GRADO");
            
            try (CallableStatement consulta = conexion.prepareCall("{ CALL SP_LISTAR_GRADO (?) }")) {
                consulta.registerOutParameter(1, OracleTypes.CURSOR);
                consulta.execute();
                
                LOG.info("Llamando a recibiendo el resultado");
                
                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(1)) {
                    
                    Grado temp;
                    int codGrado, nivel;
                    String nombreGrado;
                    
                    while (resultado.next()) {
                        
                        codGrado = resultado.getInt(1);
                        nombreGrado = resultado.getString(2);
                        nivel = resultado.getInt(3);
                        temp = new Grado(codGrado, nombreGrado, nivel);
                        
                        LOG.info("Añadiendo a la lista el objeto grado=" + temp);
                        lista.add(temp);
                    }
                }
            }
        } catch (SQLException ex) {
            LOG.error("Ha ocurrido el siguiente error: " + ex);
            lista = null;
        } finally {
            LOG.info("Cerrado conexion");
            acceso.close();
        }
        return lista;

    }

    @Override
    public String registrarGrado(Grado grado) {

        String respuesta = "Insercion Completada";

        try {
            Connection conexion = acceso.getConexion();
            conexion.setAutoCommit(false);
            try (CallableStatement consulta = conexion.prepareCall("{CALL SP_REGISTRAR_GRADO (?,?,?,?,?,?,?)}")) {
                consulta.setInt(1, grado.getCodGrado());
                consulta.setString(2, grado.getNomGrado());
                consulta.setInt(3, grado.getNivel());

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
    public String modificarGrado(Grado grado) {

        String respuesta = "Actualizacion Completada";

        try {
            Connection conexion = acceso.getConexion();
            conexion.setAutoCommit(false);
            try (CallableStatement consulta = conexion.prepareCall("{CALL SP_MODIFICAR_GRADO (?,?) }")) {
                consulta.setInt(1, grado.getCodGrado());
                consulta.setInt(2, grado.getNivel());

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
    public String eliminarGrado(int codGrado) {

        String respuesta = "Eliminacion Completada";

        try {
            Connection conn = acceso.getConexion();
            conn.setAutoCommit(false);
            try (CallableStatement consulta = conn.prepareCall("{ CALL SP_ELIMINAR_GRADO (?)}")) {
                consulta.setInt(1, codGrado);
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
    public Grado buscarGrado(int codGrado) {

        Grado grado = null;

        try {
            Connection conexion = acceso.getConexion();
            try (CallableStatement consulta = conexion.prepareCall("{ CALL SP_BUSCAR_GRADO (?, ?) }")) {
                consulta.registerOutParameter(1, OracleTypes.CURSOR);
                consulta.setInt(2, codGrado);
                consulta.execute();

                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(1)) {
                    if (resultado.next()) {
                        String nombreGrado;
                        int nivel;
                        codGrado = resultado.getInt(1);
                        nombreGrado = resultado.getString(2);
                        nivel = resultado.getInt(3);
                        grado = new Grado(codGrado, nombreGrado, nivel);
                    } 
                }
            }
        } catch (SQLException ex) {
            
        } finally {
            acceso.close();
        }
        return grado;
    }
}
