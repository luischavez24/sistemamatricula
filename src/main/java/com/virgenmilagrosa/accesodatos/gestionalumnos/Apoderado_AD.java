/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virgenmilagrosa.accesodatos.gestionalumnos;

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
public class Apoderado_AD {

    private AccesoBD acceso = AccesoBD.getInstance();

    public List<Apoderado> listarApoderados() {

        List<Apoderado> lista = new ArrayList<>();

        try {
            Connection conexion = acceso.getConexion();
            try (CallableStatement consulta = conexion.prepareCall("{ CALL SP_LISTAR_APODERADOS (?) }")) {
                consulta.registerOutParameter(1, OracleTypes.CURSOR);
                consulta.execute();
                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(1)) {
                    Apoderado temp;
                    int codApoderado;
                    String nombreAp, apaternoAp, amaternoAp, dniAp, emailAp, telefonoAp, ocupacion;

                    while (resultado.next()) {

                        codApoderado = resultado.getInt(1);
                        nombreAp = resultado.getString(2);
                        apaternoAp = resultado.getString(3);
                        amaternoAp = resultado.getString(4);
                        dniAp = resultado.getString(5);
                        emailAp = resultado.getString(6);
                        telefonoAp = resultado.getString(7);
                        ocupacion = resultado.getString(8);
                        temp = new Apoderado(codApoderado, nombreAp, apaternoAp, amaternoAp, dniAp, emailAp, telefonoAp, ocupacion);

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

    public String registrarApoderado(Apoderado apoderado) {

        String respuesta = "Insercion Completada";

        try {
            Connection conexion = acceso.getConexion();
            conexion.setAutoCommit(false);
            try (CallableStatement consulta = conexion.prepareCall("{CALL SP_REGISTRAR_APODERADO (?,?,?,?,?,?,?)}")) {
                consulta.setString(1, apoderado.getNombreAp());
                consulta.setString(2, apoderado.getaPaternoAp());
                consulta.setString(3, apoderado.getaMaternoAp());
                consulta.setString(4, apoderado.getDniAp());
                consulta.setString(5, apoderado.getEmailAp());
                consulta.setString(6, apoderado.getTelefonoAp());
                consulta.setString(7, apoderado.getOcupacion());

                consulta.execute();
            }
            conexion.commit();
            acceso.close();
        } catch (SQLException ex) {
            respuesta = ex.getMessage();
        }
        return respuesta;

    }

    public String modificarApoderado(Apoderado apoderado) {

        String respuesta = "Actualizacion Completada";

        try {
            Connection conexion = acceso.getConexion();
            conexion.setAutoCommit(false);
            try (CallableStatement consulta = conexion.prepareCall("{CALL SP_MODIFICAR_APODERADO (?,?,?,?) }")) {
                consulta.setInt(1, apoderado.getCodApoderado());
                consulta.setString(2, apoderado.getEmailAp());
                consulta.setString(3, apoderado.getTelefonoAp());
                consulta.setString(4, apoderado.getOcupacion());

                consulta.execute();
            }

            conexion.commit();
            acceso.close();
        } catch (SQLException ex) {
            respuesta = ex.getMessage();
        }
        return respuesta;

    }

    public String eliminarApoderado(int codApoderado) {

        String respuesta = "Eliminacion Completada";

        try {
            Connection conn = acceso.getConexion();
            conn.setAutoCommit(false);
            try (CallableStatement consulta = conn.prepareCall("{ CALL SP_ELIMINAR_APODERADO (?)}")) {
                consulta.setInt(1, codApoderado);
                consulta.execute();
            }
            conn.commit();
            acceso.close();
        } catch (SQLException ex) {
            respuesta = ex.getMessage();
        }
        return respuesta;

    }

}
