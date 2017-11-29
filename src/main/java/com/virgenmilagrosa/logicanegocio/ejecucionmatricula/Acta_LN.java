package com.virgenmilagrosa.logicanegocio.ejecucionmatricula;

import com.virgenmilagrosa.accesodatos.FactoryADOracle;
import java.util.List;

import com.virgenmilagrosa.accesodatos.ejecucionmatricula.*;
import com.virgenmilagrosa.tranversal.entidades.Acta;

public class Acta_LN {

    private static final Acta_LN instance = new Acta_LN();

    private ActaAD actaAD = FactoryADOracle.getFactory().getActaAD();

    private Acta_LN() {
    }

    public static Acta_LN getInstance() {
        return instance;
    }

    public List<Acta> listaActas() {
        try {

            return actaAD.listarActas();

        } catch (Exception e) {

            return null;

        }
    }

    public String registrarActa(Acta acta) {
        return actaAD.registrarActa(acta);
    }

    public String modificarActa(Acta acta) {
        return actaAD.modificarActa(acta);
    }

    public String eliminarActa(int codDocumento, int codAlumno) {
        return actaAD.eliminarActa(codDocumento, codAlumno);
    }
   
}
