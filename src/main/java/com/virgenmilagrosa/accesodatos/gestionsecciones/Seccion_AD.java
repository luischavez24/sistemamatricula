/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virgenmilagrosa.accesodatos.gestionsecciones;

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
public class Seccion_AD {

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

    public String registrarSeccion(Seccion seccion) {

        String respuesta = "Insercion Completada";

        try {
            Connection conexion = acceso.getConexion();
            conexion.setAutoCommit(false);
            try (CallableStatement consulta = conexion.prepareCall("{CALL SP_REGISTRAR_SECCION (?,?,?,?,?)}")) {
                consulta.setInt(1, seccion.getCodSeccion());
                consulta.setInt(2, seccion.getCodGrado());
                consulta.setString(3, seccion.getNombreSeccion());
                consulta.setInt(4, seccion.getNroVacantes());
                consulta.setInt(5, seccion.getNroSalon());

                respuesta = (consulta.executeUpdate() == 0) ? "No se pudo ejecutar la inserción" : "Correcto";
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
            try (CallableStatement consulta = conexion.prepareCall("{CALL SP_MODIFICAR_SECCION (?,?,?) }")) {
                consulta.setInt(1, seccion.getCodSeccion());
                consulta.setInt(2, seccion.getCodGrado());
                consulta.setInt(3, seccion.getNroSalon());

                respuesta = (consulta.executeUpdate() == 0) ? "No se pudo ejecutar la actualizaron de datos" : "Correcto";

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
                consulta.setInt(1, codGrado);
                respuesta = (consulta.executeUpdate() == 0) ? "No se pudo ejecutar la eliminación de datos" : "Correcto";
            }
            conn.commit();
            acceso.close();
        } catch (SQLException ex) {
            respuesta = ex.getMessage();
        }
        return respuesta;

    }

    public Seccion buscarActa(int codSeccion, int codGrado) {

        Seccion seccion = null;

        try {
            Connection conexion = acceso.getConexion();
            try (CallableStatement consulta = conexion.prepareCall("{ CALL SP_BUSCAR_SECCION (?,?) }")) {
                consulta.registerOutParameter(1, OracleTypes.CURSOR);
                consulta.setInt(1, codSeccion);
                consulta.setInt(1, codGrado);
                consulta.execute();
                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(1)) {

                    int nroVacantes, nroSalon;
                    String nombreSeccion;
                    codSeccion = resultado.getInt(1);
                    codGrado = resultado.getInt(2);
                    nombreSeccion = resultado.getString(3);
                    nroVacantes = resultado.getInt(4);
                    nroSalon = resultado.getInt(5);
                    seccion = new Seccion(codSeccion, codGrado, nombreSeccion, nroVacantes, nroSalon);
                }
            }
        } catch (SQLException ex) {

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
            try (CallableStatement consulta = conexion.prepareCall("{CALL SP_AMPLIAR_VACANTES (?,?,?) }")) {
                consulta.setInt(1, seccion.getCodSeccion());
                consulta.setInt(2, seccion.getCodGrado());
                consulta.setInt(3, vacantes);

                respuesta = (consulta.executeUpdate() == 0) ? "No se pudo ejecutar la ampliacion de vacantes" : "Correcto";

            }
            conexion.commit();
            acceso.close();
        } catch (SQLException ex) {
            respuesta = ex.getMessage();
        }
        return respuesta;

    }

}
