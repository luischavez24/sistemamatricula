/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virgenmilagrosa.accesodatos.ejecucionmatricula;

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
public class Documento_AD {
    
    AccesoBD acceso = AccesoBD.getInstance();

    public List<Documentos> listarDocumentos() {

        List<Documentos> lista = new ArrayList<>();

        try {
            Connection conexion = acceso.getConexion();
            try (CallableStatement consulta = conexion.prepareCall("{ CALL SP_LISTAR_DOCUMENTOS (?) }")) {
                consulta.registerOutParameter(1, OracleTypes.CURSOR);
                consulta.execute();
                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(1)) {
                    Documentos temp;
                    int codDocumento, gradoImportancia;
                    String descripcionDoc;
                    while (resultado.next()) {
                        codDocumento = resultado.getInt(1);
                        descripcionDoc = resultado.getString(2);
                        gradoImportancia = resultado.getInt(3);
                        temp = new Documentos(codDocumento, descripcionDoc, gradoImportancia);

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

    public String registrarDocumento(Documentos documento) {

        String respuesta = "Insercion Completada";

        try {
            Connection conexion = acceso.getConexion();
            conexion.setAutoCommit(false);
            try (CallableStatement consulta = conexion.prepareCall("{CALL SP_REGISTRAR_DOCUMENTO (?,?,?)}")) {
                consulta.setInt(1, documento.getCodDocumento());
                consulta.setString(2, documento.getDescripcionDoc());
                consulta.setInt(3, documento.getGradoImportancia());
                respuesta = (consulta.executeUpdate() == 0) ? "No se pudo ejecutar la inserción" : "Correcto";
            }
            conexion.commit();
            acceso.close();
        } catch (SQLException ex) {
            respuesta = ex.getMessage();
        }
        return respuesta;

    }

    public String modificarDocumento(Documentos documento) {

        String respuesta = "Actualizacion Completada";

        try {
            Connection conexion = acceso.getConexion();
            conexion.setAutoCommit(false);
            try (CallableStatement consulta = conexion.prepareCall("{CALL SP_MODIFICAR_DOCUMENTO (?,?) }")) {
                consulta.setInt(1, documento.getCodDocumento());
                consulta.setInt(2, documento.getGradoImportancia());

                respuesta = (consulta.executeUpdate() == 0) ? "No se pudo ejecutar la actualizaron de datos" : "Correcto";

            }
            conexion.commit();
            acceso.close();
        } catch (SQLException ex) {
            respuesta = ex.getMessage();
        }
        return respuesta;

    }

    public String eliminarDocumento(int codDocumento) {

        String respuesta = "Eliminacion Completada";

        try {
            Connection conn = acceso.getConexion();
            conn.setAutoCommit(false);
            try (CallableStatement consulta = conn.prepareCall("{ CALL SP_ELIMINAR_DOCUMENTO (?)}")) {
                consulta.setInt(1, codDocumento);
                respuesta = (consulta.executeUpdate() == 0) ? "No se pudo ejecutar la eliminación de datos" : "Correcto";
            }
            conn.commit();
            acceso.close();
        } catch (SQLException ex) {
            respuesta = ex.getMessage();
        }
        return respuesta;

    }

    public Documentos buscarDocumento(int codDocumento) {

        Documentos documento = null;

        try {
            Connection conexion = acceso.getConexion();
            try (CallableStatement consulta = conexion.prepareCall("{ CALL SP_BUSCAR_DOCUMENTO (?) }")) {
                consulta.registerOutParameter(1, OracleTypes.CURSOR);
                consulta.setInt(1, codDocumento);
                consulta.execute();
                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(1)) {

                    int gradoImportancia;
                    String descripcionDoc;
                    codDocumento = resultado.getInt(1);
                    descripcionDoc = resultado.getString(2);
                    gradoImportancia = resultado.getInt(3);
                    documento = new Documentos(codDocumento, descripcionDoc, gradoImportancia);
                }
            }
        } catch (SQLException ex) {

        } finally {
            acceso.close();
        }
        return documento;

    }
}
