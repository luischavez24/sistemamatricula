/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virgenmilagrosa.accesodatos.ejecucionmatricula.imple;

import com.virgenmilagrosa.accesodatos.ejecucionmatricula.ActaAD;
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
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Jose Carlos
 */
public class ActaADOracle implements ActaAD {

    private AccesoBD acceso = AccesoBD.getInstance();

    private static final SimpleDateFormat FORMATO = new SimpleDateFormat("dd/MM/yy hh:mm:ss");

    @Override
    public List<Acta> listarActas() {

        List<Acta> lista = new ArrayList<>();

        try {
            Connection conexion = acceso.getConexion();
            try (CallableStatement consulta = conexion.prepareCall("{ CALL SP_LISTAR_ACTAS (?) }")) {
                consulta.registerOutParameter(1, OracleTypes.CURSOR);
                consulta.execute();
                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(1)) {
                    Acta temp;
                    int codDocumento, codAlu, codUsuario, estado;
                    String fechaEntrega;
                    while (resultado.next()) {
                        codDocumento = resultado.getInt(1);
                        codAlu = resultado.getInt(2);
                        fechaEntrega = resultado.getString(3);
                        codUsuario = resultado.getInt(4);
                        estado = resultado.getInt(5);
                        temp = new Acta(codDocumento, codAlu, Date.valueOf(fechaEntrega), codUsuario, estado);

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

    @Override
    public String registrarActa(Acta acta) {

        String respuesta = "Insercion Completada";

        try {
            Connection conexion = acceso.getConexion();
            conexion.setAutoCommit(false);
            try (CallableStatement consulta = conexion.prepareCall("{CALL SP_REGISTRAR_ACTAS (?,?,?,?,?)}")) {
                consulta.setInt(1, acta.getCodDocumento());
                consulta.setInt(2, acta.getCodAlu());
                consulta.setString(3, FORMATO.format(acta.getFechaEntrega()));
                consulta.setInt(4, acta.getCodUsuario());
                consulta.setInt(5, acta.getEstado());
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
    public String modificarActa(Acta acta) {

        String respuesta = "Actualizacion Completada";

        try {
            Connection conexion = acceso.getConexion();
            conexion.setAutoCommit(false);
            try (CallableStatement consulta = conexion.prepareCall("{CALL SP_MODIFICAR_ACTA (?,?,?) }")) {
                consulta.setInt(1, acta.getCodDocumento());
                consulta.setInt(2, acta.getCodAlu());
                consulta.setInt(3, acta.getEstado());
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
    public String eliminarActa(int codDocumento, int codAlumno) {

        String respuesta = "Eliminacion Completada";

        try {
            Connection conn = acceso.getConexion();
            conn.setAutoCommit(false);
            try (CallableStatement consulta = conn.prepareCall("{ CALL SP_ELIMINAR_ACTA (?,?)}")) {
                consulta.setInt(1, codDocumento);
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

    @Deprecated
    public Acta buscarActa(int codDoc, int codAlu) {

        Acta acta = null;

        try {
            Connection conexion = acceso.getConexion();
            try (CallableStatement consulta = conexion.prepareCall("{ CALL SP_BUSCAR_ACTA (?,?) }")) {
                consulta.registerOutParameter(1, OracleTypes.CURSOR);
                consulta.setInt(1, codDoc);
                consulta.setInt(1, codAlu);
                consulta.execute();
                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(1)) {

                    int codDocumento, codAlumno, codUsuario, estado;
                    String fechaEntrega;
                    codDocumento = resultado.getInt(1);
                    codAlumno = resultado.getInt(2);
                    fechaEntrega = resultado.getString(3);
                    codUsuario = resultado.getInt(4);
                    estado = resultado.getInt(5);
                    acta = new Acta(codDocumento, codAlumno, Date.valueOf(fechaEntrega), codUsuario, estado);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            acceso.close();
        }
        return acta;

    }

}
