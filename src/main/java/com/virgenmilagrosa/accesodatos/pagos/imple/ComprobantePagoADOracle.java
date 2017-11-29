/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virgenmilagrosa.accesodatos.pagos.imple;

import com.virgenmilagrosa.accesodatos.pagos.ComprobantePagoAD;
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
import java.sql.Date;
import java.sql.Types;

/**
 *
 * @author Jose Carlos
 */
public class ComprobantePagoADOracle implements ComprobantePagoAD {
    private AccesoBD acceso = AccesoBD.getInstance();

    private static final SimpleDateFormat FORMATO = new SimpleDateFormat("dd/MM/yy hh:mm:ss");

    @Override
    public List<Comprobante> listarComprobantes() {

        List<Comprobante> lista = new ArrayList<>();

        try {
            Connection conexion = acceso.getConexion();

            try (CallableStatement consulta = conexion.prepareCall("{ CALL SP_LISTAR_COMPROBANTES (?) }")) {
                consulta.registerOutParameter(1, OracleTypes.CURSOR);
                consulta.execute();
                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(1)) {

                    Comprobante temp;
                    int codSeccion, codGrado, codAlu, nroComprobante;
                    String fechaEmision;
                    double monto;

                    while (resultado.next()) {
                        nroComprobante = resultado.getInt(1);
                        monto = resultado.getDouble(2);
                        fechaEmision = resultado.getString(3);
                        codSeccion = resultado.getInt(4);
                        codGrado = resultado.getInt(5);
                        codAlu = resultado.getInt(6);

                        temp = new Comprobante(nroComprobante, monto, Date.valueOf(fechaEmision), codSeccion, codGrado, codAlu);
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

    @Override
    public int registrarComprobante(Comprobante comprobante) {

        int respuesta;

        try {
            Connection conexion = acceso.getConexion();
            conexion.setAutoCommit(false);
            try (CallableStatement consulta = conexion.prepareCall("{?=call SF_REGISTRAR_COMPROBANTE (?,?,?,?)}")) {
                consulta.registerOutParameter(1, Types.NUMERIC);
                consulta.setDouble(2, comprobante.getMonto());
                consulta.setInt(3, comprobante.getCodSeccion());
                consulta.setInt(4, comprobante.getCodGrado());
                consulta.setInt(5, comprobante.getCodAlu());

                consulta.execute();
                respuesta = consulta.getInt(1);
            }
            conexion.commit();

            acceso.close();
        } catch (SQLException ex) {
            System.out.println("Error registrando");
            System.out.println(ex);
            respuesta = -1;
        }
        return respuesta;

    }

    @Override
    public String modificarComprobante(Comprobante comprobante) {

        String respuesta = "Actualizacion Completada";

        try {
            Connection conexion = acceso.getConexion();
            conexion.setAutoCommit(false);
            try (CallableStatement consulta = conexion.prepareCall("{CALL SP_MODIFICAR_COMPROBANTE (?, ?) }")) {
                consulta.setInt(1, comprobante.getNroComprobante());
                consulta.setDouble(2, comprobante.getMonto());

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
    public String eliminarComprobante(int nroComprobante) {

        String respuesta = "Eliminacion Completada";

        try {
            Connection conn = acceso.getConexion();
            conn.setAutoCommit(false);
            try (CallableStatement consulta = conn.prepareCall("{ CALL SP_ELIMINAR_COMPROBANTE (?)}")) {
                consulta.setInt(1, nroComprobante);
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
    public Comprobante buscarComprobante(int nroComprobante) {

        Comprobante comprobante = null;

        try {
            Connection conexion = acceso.getConexion();
            try (CallableStatement consulta = conexion.prepareCall("{ CALL SP_BUSCAR_COMPROBANTE (?,?) }")) {
                consulta.setInt(1, nroComprobante);
                consulta.registerOutParameter(2, OracleTypes.CURSOR);

                consulta.execute();
                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(2)) {
                    if (resultado.next()) {
                        int codSeccion, codGrado, codAlu;
                        Date fechaEmision;
                        double monto;

                        nroComprobante = resultado.getInt(1);
                        monto = resultado.getDouble(2);
                        fechaEmision = new Date(resultado.getDate(3).getTime());
                        codSeccion = resultado.getInt(4);
                        codGrado = resultado.getInt(5);
                        codAlu = resultado.getInt(6);
                        comprobante = new Comprobante(nroComprobante, monto, fechaEmision, codSeccion, codGrado, codAlu);
                    }

                }
            }
        } catch (SQLException ex) {
            System.out.println("Error buscando comprobante");
            System.out.println(ex);
        } finally {
            acceso.close();
        }
        return comprobante;
    }

}
