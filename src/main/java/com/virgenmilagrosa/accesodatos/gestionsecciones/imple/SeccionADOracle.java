/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virgenmilagrosa.accesodatos.gestionsecciones.imple;

import com.virgenmilagrosa.accesodatos.gestionsecciones.SeccionAD;
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
public class SeccionADOracle implements SeccionAD{

    private AccesoBD acceso = AccesoBD.getInstance();

    public List<Seccion> listarSecciones() {

        List<Seccion> lista = new ArrayList<>();

        try {
            Connection conexion = acceso.getConexion();
            try (CallableStatement consulta = conexion.prepareCall("{ CALL SP_LISTAR_SECCIONES (?) }")) {
                consulta.registerOutParameter(1, OracleTypes.CURSOR);
                consulta.execute();
                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(1)) {
                    Seccion temp;
                    int codSeccion, codGrado, nroVacantes, nroSalon;
                    String nombreSeccion;
                    while (resultado.next()) {
                        codSeccion = resultado.getInt(1);
                        codGrado = resultado.getInt(2);
                        nombreSeccion = resultado.getString(3);
                        nroVacantes = resultado.getInt(4);
                        nroSalon = resultado.getInt(5);
                        temp = new Seccion(codSeccion, codGrado, nombreSeccion, nroVacantes, nroSalon);
                        temp.setNombreGrado(resultado.getString("NOMBRE_GRADO"));
                        lista.add(temp);
                    }
                }
            }
        } catch (SQLException ex) {
            return null;
        } finally {
            acceso.close();
        }
        return lista;

    }

    public String registrarSeccion(Seccion seccion) {

        String respuesta = "Insercion Completada";
        try {
            Connection conexion = acceso.getConexion();
            conexion.setAutoCommit(false);
            try (CallableStatement consulta = conexion.prepareCall("{CALL SP_REGISTRAR_SECCIONES (?,?,?,?)}")) {
                
                consulta.setInt(1, seccion.getCodGrado());
                consulta.setString(2, seccion.getNombreSeccion());
                consulta.setInt(3, seccion.getNroVacantes());
                consulta.setInt(4, seccion.getNroSalon());

                consulta.execute();
            }
            conexion.commit();
            acceso.close();
        } catch (SQLException ex) {
            respuesta = ex.getMessage();
        }
        return respuesta;

    }

    public String modificarSeccion(Seccion seccion) {

        String respuesta = "Actualizacion Completada";
       
        try {
            Connection conexion = acceso.getConexion();
            conexion.setAutoCommit(false);
            try (CallableStatement consulta = conexion.prepareCall("{CALL SP_MODIFICAR_SECCION (?,?,?,?) }")) {
                consulta.setInt(1, seccion.getCodSeccion());
                consulta.setInt(2, seccion.getCodGrado());
                consulta.setString(3, seccion.getNombreSeccion());
                consulta.setInt(4, seccion.getNroSalon());
                consulta.executeUpdate();

            }
            conexion.commit();
            acceso.close();
        } catch (SQLException ex) {
            respuesta = ex.getMessage();
        }
        return respuesta;

    }

    public String eliminarSeccion(int codSeccion, int codGrado) {

        String respuesta = "Eliminacion Completada";

        try {
            Connection conn = acceso.getConexion();
            conn.setAutoCommit(false);
            try (CallableStatement consulta = conn.prepareCall("{ CALL SP_ELIMINAR_SECCION (?,?)}")) {
                consulta.setInt(1, codSeccion);
                consulta.setInt(2, codGrado);
                consulta.execute();
            }
            conn.commit();
            acceso.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            respuesta = ex.getMessage();
        }
        return respuesta;

    }

    public Seccion buscarSeccion(int codSeccion, int codGrado) {

        Seccion seccion = null;

        try {
            Connection conexion = acceso.getConexion();
            try (CallableStatement consulta = conexion.prepareCall("{ CALL SP_BUSCAR_SECCION (?,?,?) }")) {

                consulta.setInt(1, codSeccion);
                consulta.setInt(2, codGrado);
                consulta.registerOutParameter(3, OracleTypes.CURSOR);

                consulta.execute();

                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(3)) {
                    if (resultado.next()) {
                        int nroVacantes, nroSalon;
                        String nombreSeccion;
                        codSeccion = resultado.getInt(1);
                        codGrado = resultado.getInt(2);
                        nombreSeccion = resultado.getString(3);
                        nroVacantes = resultado.getInt(4);
                        nroSalon = resultado.getInt(5);
                        seccion = new Seccion(codSeccion, codGrado, nombreSeccion, nroVacantes, nroSalon);
                        seccion.setNombreGrado(resultado.getString("NOMBRE_GRADO"));
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            acceso.close();
        }
        return seccion;

    }

    public String ampliarVacantes(Seccion seccion, int vacantes) {

        String respuesta = "Ampliacion Completada";

        try {
            Connection conexion = acceso.getConexion();
            conexion.setAutoCommit(false);
            try (CallableStatement consulta = conexion.prepareCall("{CALL SP_AMPLIAR_VACANTE (?,?,?) }")) {
                consulta.setInt(1, seccion.getCodSeccion());
                consulta.setInt(2, seccion.getCodGrado());
                consulta.setInt(3, vacantes);

                consulta.execute();

            }
            conexion.commit();
            acceso.close();
        } catch (SQLException ex) {
            respuesta = ex.getMessage();
            System.out.println(ex);
        }
        return respuesta;

    }

}
