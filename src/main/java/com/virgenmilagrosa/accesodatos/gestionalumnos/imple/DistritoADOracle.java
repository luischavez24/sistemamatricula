/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virgenmilagrosa.accesodatos.gestionalumnos.imple;

import com.virgenmilagrosa.accesodatos.gestionalumnos.DistritoAD;
import com.virgenmilagrosa.tranversal.conexion.AccesoBD;
import com.virgenmilagrosa.tranversal.entidades.Distrito;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author lucho
 */
public class DistritoADOracle implements DistritoAD{

    private AccesoBD acceso = AccesoBD.getInstance();

    @Override
    public List<Distrito> listarDistritos() {
        List<Distrito> distritos = new ArrayList<>();
        try {
            Connection conexion = acceso.getConexion();
            try (CallableStatement consulta
                    = conexion.prepareCall("{ CALL SP_LISTAR_DISTRITOS (?) }")) {
                consulta.registerOutParameter(1, OracleTypes.CURSOR);
                consulta.execute();
                try (ResultSet resultado = ((OracleCallableStatement) consulta).getCursor(1)) {
                    
                    while (resultado.next()) {
                        Distrito dist = new Distrito();
                        dist.setCodDistrito(resultado.getInt("COD_DISTRITO"));
                        dist.setNomDistrito(resultado.getString("NOM_DISTRITO"));
                        distritos.add(dist);
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            distritos = null;
        } finally {
            acceso.close();
        }

        return distritos;
    }
}
