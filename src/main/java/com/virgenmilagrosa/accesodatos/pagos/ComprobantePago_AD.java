/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virgenmilagrosa.accesodatos.pagos;

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
public class ComprobantePago_AD {

    AccesoBD acceso = AccesoBD.getInstance();

    public List<Comprobante> listarComprobantes() {

        List<Comprobante> lista = new ArrayList<>();

        try {
            Connection conexion = acceso.getConexion();
            try (CallableStatement consulta = conexion.prepareCall("{ CALL SP_LISTAR_COMPROBANTES (?) }")) {
                consulta.registerOutParameter(1, OracleTypes.CURSOR);
                consulta.execute();
                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(1)) {
                    Comprobante temp;
                    int codSeccion, codGrado, codAlu;
                    String nroComprobante, fechaEmision;
                    double monto;
                    while (resultado.next()) {
                        nroComprobante = resultado.getString(1);
                        monto = resultado.getDouble(2);
                        fechaEmision = resultado.getString(3);
                        codSeccion = resultado.getInt(4);
                        codGrado = resultado.getInt(5);
                        codAlu = resultado.getInt(6);
                        temp = new Comprobante(nroComprobante, monto, fechaEmision, codSeccion, codGrado, codAlu);

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

    public String registrarComprobante(Comprobante comprobante) {

        String respuesta = "Insercion Completada";

        try {
            Connection conexion = acceso.getConexion();
            conexion.setAutoCommit(false);
            try (CallableStatement consulta = conexion.prepareCall("{CALL SP_REGISTRAR_COMPROBANTE (?,?,?,?,?,?)}")) {
                consulta.setString(1, comprobante.getNumero());
                consulta.setDouble(2, comprobante.getMonto());
                consulta.setString(3, comprobante.getFechaEmision());
                consulta.setInt(4, comprobante.getCodSeccion());
                consulta.setInt(5, comprobante.getCodGrado());
                consulta.setInt(6, comprobante.getCodAlu());

                respuesta = (consulta.executeUpdate() == 0) ? "No se pudo ejecutar la inserción" : "Correcto";
            }
            conexion.commit();
            acceso.close();
        } catch (SQLException ex) {
            respuesta = ex.getMessage();
        }
        return respuesta;

    }

    public String modificarComprobante(Comprobante comprobante) {

        String respuesta = "Actualizacion Completada";

        try {
            Connection conexion = acceso.getConexion();
            conexion.setAutoCommit(false);
            try (CallableStatement consulta = conexion.prepareCall("{CALL SP_MODIFICAR_COMPROBANTE (?, ?) }")) {
                consulta.setString(1, comprobante.getNumero());
                consulta.setDouble(2, comprobante.getMonto());

                respuesta = (consulta.executeUpdate() == 0) ? "No se pudo ejecutar la actualizaron de datos" : "Correcto";

            }
            conexion.commit();
            acceso.close();
        } catch (SQLException ex) {
            respuesta = ex.getMessage();
        }
        return respuesta;

    }

    public String eliminarComprobante(String nroComprobante) {

        String respuesta = "Eliminacion Completada";

        try {
            Connection conn = acceso.getConexion();
            conn.setAutoCommit(false);
            try (CallableStatement consulta = conn.prepareCall("{ CALL SP_ELIMINAR_COMPROBANTE (?)}")) {
                consulta.setString(1, nroComprobante);
                respuesta = (consulta.executeUpdate() == 0) ? "No se pudo ejecutar la eliminación de datos" : "Correcto";
            }
            conn.commit();
            acceso.close();
        } catch (SQLException ex) {
            respuesta = ex.getMessage();
        }
        return respuesta;

    }

    public Comprobante buscarActa(String nroComprobante) {

        Comprobante comprobante = null;

        try {
            Connection conexion = acceso.getConexion();
            try (CallableStatement consulta = conexion.prepareCall("{ CALL SP_BUSCAR_USUARIO (?,?) }")) {
                consulta.registerOutParameter(1, OracleTypes.CURSOR);
                consulta.setString(1, nroComprobante);
                consulta.execute();
                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(1)) {

                    int codSeccion, codGrado, codAlu;
                    String fechaEmision;
                    double monto;

                    nroComprobante = resultado.getString(1);
                    monto = resultado.getDouble(2);
                    fechaEmision = resultado.getString(3);
                    codSeccion = resultado.getInt(4);
                    codGrado = resultado.getInt(5);
                    codAlu = resultado.getInt(6);
                    comprobante = new Comprobante(nroComprobante, monto, fechaEmision, codSeccion, codGrado, codAlu);
                }
            }
        } catch (SQLException ex) {

        } finally {
            acceso.close();
        }
        return comprobante;

    }

}
