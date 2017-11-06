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
public class Grado_AD {

    private AccesoBD acceso = AccesoBD.getInstance();
    
    private static final Grado_AD instance = new Grado_AD();

	private Grado_AD() {
	}

	public static Grado_AD getInstance() {
		return instance;
	}

    public List<Grado> listarGrados() {

        List<Grado> lista = new ArrayList<>();

        try {
            Connection conexion = acceso.getConexion();
            try (CallableStatement consulta = conexion.prepareCall("{ CALL SP_LISTAR_GRADOS (?) }")) {
                consulta.registerOutParameter(1, OracleTypes.CURSOR);
                consulta.execute();
                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(1)) {
                    Grado temp;
                    int codGrado, nivel;
                    String nombreGrado;
                    while (resultado.next()) {
                        codGrado = resultado.getInt(1);
                        nombreGrado = resultado.getString(2);
                        nivel = resultado.getInt(3);
                        temp = new Grado(codGrado, nombreGrado, nivel);

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

    public Grado buscarGrado(int codGrado) {

        Grado grado = null;

        try {
            Connection conexion = acceso.getConexion();
            try (CallableStatement consulta = conexion.prepareCall("{ CALL SP_BUSCAR_GRADO (?) }")) {
                consulta.registerOutParameter(1, OracleTypes.CURSOR);
                consulta.setInt(1, codGrado);
                consulta.execute();
                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(1)) {

                    String nombreGrado;
                    int nivel;
                    codGrado = resultado.getInt(1);
                    nombreGrado = resultado.getString(2);
                    nivel = resultado.getInt(3);
                    grado = new Grado(codGrado, nombreGrado, nivel);
                }
            }
        } catch (SQLException ex) {

        } finally {
            acceso.close();
        }
        return grado;

    }

}
