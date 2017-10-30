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
    
    AccesoBD acceso = AccesoBD.getInstance();
    
    public String ejecutarMatricula(Alumnos alumno, Seccion seccion, Grado grado) {
        
        String respuesta = "Matricula Exitosa";

        try {
            Connection conexion = acceso.getConexion();
            conexion.setAutoCommit(false);
            try (CallableStatement consulta = conexion.prepareCall("{CALL SP_EJECUTAR_MATRICULA (?,?,?)}")) {
                consulta.setInt(1, alumno.getCodigo());
                consulta.setInt(2, seccion.getCodigo());
                consulta.setInt(3, grado.getCodigo());

                respuesta = (consulta.executeUpdate() == 0) ? "No se pudo ejecutar la matrícula" : "Correcto";
            }
            conexion.commit();
            acceso.close();
        } catch (SQLException ex) {
            respuesta = ex.getMessage();
        }
        return respuesta;
        
    }
}
