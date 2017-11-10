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
import java.sql.ResultSet;
import java.sql.Types;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import org.apache.commons.logging.*;

/**
 *
 * @author Jose Carlos
 */
public class Matricula_AD {

    private AccesoBD acceso = AccesoBD.getInstance();

    private static final Log LOG = LogFactory.getLog(Matricula_AD.class);

    private static final Matricula_AD instance = new Matricula_AD();

    private Matricula_AD() {
    }

    public static Matricula_AD getInstance() {
        return instance;
    }

    public String ejecutarMatricula(Alumnos alumno, Seccion seccion) {

        LOG.info("Iniciando la ejecucion de la matricula");

        String codMatricula;

        try {

            LOG.info("Abriendo la conexion...");

            Connection conexion = acceso.getConexion();

            LOG.info("Llamando a la función='SF_EJECUTAR_MATRICULA'");

            try (CallableStatement consulta = 
                    conexion.prepareCall("{?=call SF_EJECUTAR_MATRICULA (?,?,?)}")) {

                consulta.registerOutParameter(1, Types.CHAR);
                
                consulta.setInt(2, seccion.getCodSeccion());
                consulta.setInt(3, seccion.getCodGrado());
                consulta.setInt(4, alumno.getCodAlu());
                
                consulta.execute();
                codMatricula = consulta.getString(1);
                
                LOG.info("Funcion ejecuda, codMatricula=" + codMatricula);
            }

            acceso.close();

        } catch (SQLException ex) {

            LOG.error("A ocurrido el siguiente problema " + ex);

            codMatricula = null;
        }
        
        return codMatricula;
    }

    public Matricula buscarMatricula(String codMatricula) {

        Matricula miMatricula = null;

        try {
            LOG.info("Abriendo la conexion...");

            Connection conexion = acceso.getConexion();

            LOG.info("Llamando al procedimiento='SP_BUSCAR_MATRICULA'");

            try (CallableStatement consulta = 
                    conexion.prepareCall("{CALL SP_BUSCAR_MATRICULA (?,?)}")) {
                
                consulta.setString(1, codMatricula);
                
                consulta.registerOutParameter(2, OracleTypes.CURSOR);
                
                consulta.execute();
                
                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(2)) {
                    
                    if(resultado.next()) {
                        
                        miMatricula = new Matricula();
                        
                        miMatricula.setCodAlu(resultado.getInt("COD_ALU"));
                        miMatricula.setCodGrado(resultado.getInt("COD_GRADO"));
                        miMatricula.setCodSeccion(resultado.getInt("COD_SECCION"));
                        miMatricula.setCodMatricula(resultado.getString("COD_MATRICULA"));
                        miMatricula.setFechaEjecucion(resultado.getDate("FECHA_EJECUCUCION"));
                        miMatricula.setpAcademico(resultado.getInt("P_ACADEMICO"));
                    }
                }
            }
            
            acceso.close();

        } catch (SQLException e) {
            LOG.error("Ha ocurrido el siguiente error: " + e);
        }
        
        LOG.info("Devolviendo objeto matricula=" + miMatricula);
        
        return miMatricula;
    }
    
    public int verificarMatricula(String dniAlu) {

        LOG.info("Iniciando la ejecucion de la matricula");

        int verif;

        try {

            LOG.info("Abriendo la conexion...");

            Connection conexion = acceso.getConexion();

            LOG.info("Llamando a la función='SF_EJECUTAR_MATRICULA'");

            try (CallableStatement consulta = 
                    conexion.prepareCall("{?=call SF_VERIFICAR_MATRICULA (?)}")) {

                consulta.registerOutParameter(1, Types.NUMERIC);
                
                consulta.setString(2, dniAlu);
  
                
                consulta.execute();
                verif = consulta.getInt(1);
                
                LOG.info("Funcion ejecuda, verif=" + verif);
            }

            acceso.close();

        } catch (SQLException ex) {

            LOG.error("A ocurrido el siguiente problema " + ex);

            verif = -1;
        }
        
        return verif;
    }

}
