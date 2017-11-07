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
public class Alumno_AD {

    private AccesoBD acceso = AccesoBD.getInstance();

    private static final Alumno_AD instance = new Alumno_AD();

    private Alumno_AD() {
    }

    public static Alumno_AD getInstance() {
        return instance;
    }

    public List<Alumnos> listarAlumnos() {

        List<Alumnos> lista = new ArrayList<>();

        try {
            Connection conexion = acceso.getConexion();
            try (CallableStatement consulta = conexion.prepareCall("{ CALL SP_LISTAR_ALUMNOS (?) }")) {
                consulta.registerOutParameter(1, OracleTypes.CURSOR);
                consulta.execute();
                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(1)) {
                    Alumnos temp;
                    int codAlu, codApoderado;
                    String apaternoAlu, nombreAlu, amaternoAlu, telefonoAlu, emailAlu, direccionAlu;
                    while (resultado.next()) {
                        codAlu = resultado.getInt(1);
                        apaternoAlu = resultado.getString(2);
                        nombreAlu = resultado.getString(3);
                        amaternoAlu = resultado.getString(4);
                        telefonoAlu = resultado.getString(5);
                        emailAlu = resultado.getString(6);
                        direccionAlu = resultado.getString(7);
                        codApoderado = resultado.getInt(8);
                        temp = new Alumnos(codAlu, apaternoAlu, nombreAlu, amaternoAlu, telefonoAlu, emailAlu, direccionAlu, codApoderado);

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

    public String registrarAlumno(Alumnos alumno) {

        String respuesta = "Insercion Completada";

        try {
            Connection conexion = acceso.getConexion();
            conexion.setAutoCommit(false);
            try (CallableStatement consulta = conexion.prepareCall("{CALL SP_REGISTRAR_ALUMNO (?,?,?,?,?,?,?,?)}")) {
                consulta.setInt(1, alumno.getCodAlu());
                consulta.setString(2, alumno.getaPaternoAlu());
                consulta.setString(3, alumno.getNombreAlu());
                consulta.setString(4, alumno.getaMaternoAlu());
                consulta.setString(5, alumno.getTelefonoAlu());
                consulta.setString(6, alumno.getEmailAlu());
                consulta.setString(7, alumno.getDireccionAlu());
                consulta.setInt(8, alumno.getCodApoderado());

                consulta.execute();
            }
            conexion.commit();
            acceso.close();
        } catch (SQLException ex) {
            respuesta = ex.getMessage();
        }
        return respuesta;

    }

    public String modificarAlumno(Alumnos alumno) {

        String respuesta = "Actualizacion Completada";

        try {
            Connection conexion = acceso.getConexion();
            conexion.setAutoCommit(false);
            try (CallableStatement consulta = conexion.prepareCall("{CALL SP_MODIFICAR_ALUMNO (?,?,?,?) }")) {
                consulta.setInt(1, alumno.getCodAlu());
                consulta.setString(2, alumno.getTelefonoAlu());
                consulta.setString(3, alumno.getEmailAlu());
                consulta.setString(4, alumno.getDireccionAlu());

                consulta.execute();
            }
            conexion.commit();
            acceso.close();
        } catch (SQLException ex) {
            respuesta = ex.getMessage();
        }
        return respuesta;

    }

    public String eliminarAlumno(int codAlumno) {

        String respuesta = "Eliminacion Completada";

        try {
            Connection conn = acceso.getConexion();
            conn.setAutoCommit(false);
            try (CallableStatement consulta = conn.prepareCall("{ CALL SP_ELIMINAR_ALUMNO (?)}")) {
                consulta.setInt(1, codAlumno);
                consulta.execute();
            }
            conn.commit();
            acceso.close();
        } catch (SQLException ex) {
            respuesta = ex.getMessage();
        }
        return respuesta;

    }

    public Alumnos buscarAlumno(int codAlumno) {

        Alumnos alumno = null;

        try {
            Connection conexion = acceso.getConexion();
            try (CallableStatement consulta = conexion.prepareCall("{ CALL SP_BUSCAR_ALUMNO (?, ?) }")) {
                consulta.registerOutParameter(2, OracleTypes.CURSOR);
                consulta.setInt(1, codAlumno);
                consulta.execute();
                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(2)) {
                    if (resultado.next()) {
                        int codApoderado;
                        String apaternoAlu, nombreAlu, amaternoAlu, telefonoAlu, emailAlu, direccionAlu;
                        codAlumno = resultado.getInt(1);
                        apaternoAlu = resultado.getString(2);
                        nombreAlu = resultado.getString(3);
                        amaternoAlu = resultado.getString(4);
                        telefonoAlu = resultado.getString(5);
                        emailAlu = resultado.getString(6);
                        direccionAlu = resultado.getString(7);
                        codApoderado = resultado.getInt(8);
                        alumno = new Alumnos(codAlumno, apaternoAlu, nombreAlu, amaternoAlu, telefonoAlu, emailAlu, direccionAlu, codApoderado);
                    } 

                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            acceso.close();
        }
        return alumno;

    }

}
