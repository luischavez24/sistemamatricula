/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virgenmilagrosa.accesodatos.gestionalumnos.imple;

import com.virgenmilagrosa.accesodatos.gestionalumnos.AlumnoAD;
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
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jose Carlos
 */
public class AlumnoADOracle implements AlumnoAD {

    private AccesoBD acceso = AccesoBD.getInstance();
    private final static SimpleDateFormat FORMATO = new SimpleDateFormat("dd/MM/yy");

    @Override
    public List<Alumnos> listarAlumnos() {

        List<Alumnos> lista = new ArrayList<>();

        try {
            Connection conexion = acceso.getConexion();
            try (CallableStatement consulta
                    = conexion.prepareCall("{ CALL SP_LISTAR_ALUMNOS (?) }")) {
                consulta.registerOutParameter(1, OracleTypes.CURSOR);
                consulta.execute();
                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(1)) {
                    Alumnos temp;
                    int codAlu, codApoderado;
                    String apaternoAlu, nombreAlu, amaternoAlu,
                            telefonoAlu, emailAlu, direccionAlu, dniAlumno;
                    while (resultado.next()) {
                        codAlu = resultado.getInt("COD_ALU");
                        apaternoAlu = resultado.getString("APATERNO_ALU");
                        amaternoAlu = resultado.getString("AMATERNO_ALU");
                        nombreAlu = resultado.getString("NOMBRE_ALU");
                        telefonoAlu = resultado.getString("TELEFONO_ALU");
                        emailAlu = resultado.getString("EMAIL_ALU");
                        direccionAlu = resultado.getString("DIRECCION_ALU");
                        codApoderado = resultado.getInt("COD_APODERADO");
                        dniAlumno = resultado.getString("DNI_ALUMNO");

                        temp = new Alumnos(codAlu, apaternoAlu, nombreAlu,
                                amaternoAlu, telefonoAlu, emailAlu,
                                direccionAlu, codApoderado, dniAlumno);

                        lista.add(temp);
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            lista = null;
        } finally {
            acceso.close();
        }
        return lista;

    }

    @Override
    public String registrarAlumno(Alumnos alumno) {

        String respuesta = "Insercion Completada";

        try {
            Connection conexion = acceso.getConexion();
            conexion.setAutoCommit(false);
            try (CallableStatement consulta = conexion.prepareCall("{CALL SP_REGISTRAR_ALUMNO (?,?,?,?,?,?,?,?,?,?)}")) {
                consulta.setString(1, alumno.getaPaternoAlu());
                consulta.setString(2, alumno.getaMaternoAlu());
                consulta.setString(3, alumno.getNombreAlu());
                consulta.setString(4, alumno.getTelefonoAlu());
                consulta.setString(5, alumno.getEmailAlu());
                consulta.setString(6, alumno.getDireccionAlu());

                consulta.setString(7, alumno.getFechaNac());
                consulta.setInt(8, alumno.getCodApoderado());
                consulta.setInt(9, alumno.getCodDistrito());
                consulta.setString(10, alumno.getDniAlumno());

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

    @Override
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

    @Override
    public Alumnos buscarAlumno(String dniAlu) {

        Alumnos alumno = null;

        try {
            Connection conexion = acceso.getConexion();
            try (CallableStatement consulta = conexion.prepareCall("{ CALL SP_BUSCAR_ALUMNO (?, ?) }")) {
                consulta.setString(1, dniAlu);
                consulta.registerOutParameter(2, OracleTypes.CURSOR);
                consulta.execute();
                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(2)) {
                    if (resultado.next()) {

                        alumno = new Alumnos();
                        alumno.setCodAlu(resultado.getInt("COD_ALU"));
                        alumno.setaPaternoAlu(resultado.getString("APATERNO_ALU"));
                        alumno.setaMaternoAlu(resultado.getString("AMATERNO_ALU"));
                        alumno.setNombreAlu(resultado.getString("NOMBRE_ALU"));
                        alumno.setTelefonoAlu(resultado.getString("TELEFONO_ALU"));
                        alumno.setEmailAlu(resultado.getString("EMAIL_ALU"));
                        alumno.setDireccionAlu(resultado.getString("DIRECCION_ALU"));
                        Date fechaNac = new Date(resultado.getDate("FECHA_NAC").getTime());
                        alumno.setFechaNac(FORMATO.format(fechaNac));
                        alumno.setCodApoderado(resultado.getInt("COD_APODERADO"));
                        alumno.setCodDistrito(resultado.getInt("COD_DISTRITO"));
                        alumno.setDniAlumno(resultado.getString("DNI_ALUMNO"));
                        System.out.println(alumno);
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

    @Override
    public Alumnos buscarAlumno(int codAlu) {

        Alumnos alumno = null;

        try {
            Connection conexion = acceso.getConexion();
            try (CallableStatement consulta = conexion.prepareCall("{ CALL SP_BUSCAR_ALUMNO_COD (?, ?) }")) {
                consulta.setInt(1, codAlu);
                consulta.registerOutParameter(2, OracleTypes.CURSOR);
                consulta.execute();
                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(2)) {
                    if (resultado.next()) {
                        alumno = new Alumnos();
                        alumno.setCodAlu(resultado.getInt("COD_ALU"));
                        alumno.setaPaternoAlu(resultado.getString("APATERNO_ALU"));
                        alumno.setaMaternoAlu(resultado.getString("AMATERNO_ALU"));
                        alumno.setNombreAlu(resultado.getString("NOMBRE_ALU"));
                        alumno.setTelefonoAlu(resultado.getString("TELEFONO_ALU"));
                        alumno.setEmailAlu(resultado.getString("EMAIL_ALU"));
                        alumno.setDireccionAlu(resultado.getString("DIRECCION_ALU"));
                        Date fechaNac = new Date(resultado.getDate("FECHA_NAC").getTime());
                        alumno.setFechaNac(FORMATO.format(fechaNac));
                        alumno.setCodApoderado(resultado.getInt("COD_APODERADO"));
                        alumno.setCodDistrito(resultado.getInt("COD_DISTRITO"));
                        alumno.setDniAlumno(resultado.getString("DNI_ALUMNO"));
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
