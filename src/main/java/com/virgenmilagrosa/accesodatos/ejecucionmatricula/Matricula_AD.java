/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virgenmilagrosa.accesodatos.ejecucionmatricula;

import com.virgenmilagrosa.tranversal.conexion.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import com.virgenmilagrosa.tranversal.entidades.*;
/**
 *
 * @author Jose Carlos
 */
public class Matricula_AD {
    
    private AccesoBD acceso = AccesoBD.getInstance();
    
    private static final Matricula_AD instance = new Matricula_AD();

	private Matricula_AD() {
	}

	public static Matricula_AD getInstance() {
		return instance;
	}

    public String ejecutarMatricula(Alumnos alumno, Seccion seccion) {
        
        String respuesta = "Matricula Exitosa";

        try {
            Connection conexion = acceso.getConexion();
            conexion.setAutoCommit(false);
            try (CallableStatement consulta = conexion.prepareCall("{CALL SP_EJECUTAR_MATRICULA (?,?,?)}")) {
                consulta.setInt(1, alumno.getCodAlu());
                consulta.setInt(2, seccion.getCodSeccion());
                consulta.setInt(3, seccion.getCodGrado());

                consulta.execute();
            }
            conexion.commit();
            acceso.close();
        } catch (SQLException ex) {
            respuesta = ex.getMessage();
        }
        return respuesta;
        
    }
}
