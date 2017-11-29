package com.virgenmilagrosa.logicanegocio.gestionalumnos;

import com.virgenmilagrosa.accesodatos.FactoryADOracle;
import java.util.List;

import com.virgenmilagrosa.accesodatos.gestionalumnos.*;
import com.virgenmilagrosa.tranversal.entidades.Apoderado;

public class Apoderado_LN {

    private static final Apoderado_LN instance = new Apoderado_LN();

    private Apoderado_LN() { }

    public static Apoderado_LN getInstance() {
        return instance;
    }

    private ApoderadoAD apoderadoAD = FactoryADOracle.getFactory().getApoderadoAD();

    public List<Apoderado> listarApoderados() {
        try {
            return apoderadoAD.listarApoderados();
        } catch (Exception e) {
            return null;
        }
    }

    public String registrarApoderado(Apoderado apoderado) {
        return apoderadoAD.registrarApoderado(apoderado);
    }

    public String modificarApoderado(Apoderado apoderado) {
        return apoderadoAD.modificarApoderado(apoderado);
    }

    public String eliminarApoderado(int codApoderado) {
        return apoderadoAD.eliminarApoderado(codApoderado);
    }
    
    public Apoderado buscarApoderado(int codApoderado) {
        return apoderadoAD.buscarApoderado(codApoderado);
    }
}
