package com.virgenmilagrosa.logicanegocio.gestionalumnos;

import java.util.List;

import com.virgenmilagrosa.accesodatos.gestionalumnos.Apoderado_AD;
import com.virgenmilagrosa.tranversal.entidades.Apoderado;

public class Apoderado_LN {

    private static final Apoderado_LN instance = new Apoderado_LN();

    private Apoderado_LN() {
    }

    public static Apoderado_LN getInstance() {
        return instance;
    }

    private Apoderado_AD apoderadoAD = Apoderado_AD.getInstance();

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
