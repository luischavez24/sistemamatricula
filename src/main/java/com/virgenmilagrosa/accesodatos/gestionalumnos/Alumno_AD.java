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

    AccesoBD acceso = AccesoBD.getInstance();

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
                consulta.setInt(1, alumno.getCodigo());
                consulta.setString(2, alumno.getAPaterno());
                consulta.setString(3, alumno.getNombre());
                consulta.setString(4, alumno.getAMaterno());
                consulta.setString(5, alumno.getTelefono());
                consulta.setString(6, alumno.getEmail());
                consulta.setString(7, alumno.getDireccion());
                consulta.setInt(8, alumno.getCodigoApoderado());

                respuesta = (consulta.executeUpdate() == 0) ? "No se pudo ejecutar la inserción" : "Correcto";
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
            try (CallableStatement consulta = conexion.prepareCall("{CALL SP_MODIFICAR_ACTA (?,?,?,?) }")) {
                consulta.setInt(1, alumno.getCodigo());
                consulta.setString(2, alumno.getTelefono());
                consulta.setString(3, alumno.getEmail());
                consulta.setString(4, alumno.getDireccion());

                respuesta = (consulta.executeUpdate() == 0) ? "No se pudo ejecutar la actualizaron de datos" : "Correcto";

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
            try (CallableStatement consulta = conn.prepareCall("{ CALL SP_ELIMINAR_ACTA (?)}")) {
                consulta.setInt(1, codAlumno);
                respuesta = (consulta.executeUpdate() == 0) ? "No se pudo ejecutar la eliminación de datos" : "Correcto";
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
            try (CallableStatement consulta = conexion.prepareCall("{ CALL SP_BUSCAR_ALUMNO (?) }")) {
                consulta.registerOutParameter(1, OracleTypes.CURSOR);
                consulta.setInt(1, codAlumno);
                consulta.execute();
                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(1)) {

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
        } catch (SQLException ex) {

        } finally {
            acceso.close();
        }
        return alumno;

    }

}
