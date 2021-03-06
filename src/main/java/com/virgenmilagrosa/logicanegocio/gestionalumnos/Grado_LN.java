package com.virgenmilagrosa.logicanegocio.gestionalumnos;

import com.virgenmilagrosa.accesodatos.FactoryADOracle;
import java.util.List;

import com.virgenmilagrosa.accesodatos.gestionalumnos.*;
import com.virgenmilagrosa.tranversal.entidades.Grado;

public class Grado_LN {

    private static final Grado_LN instance = new Grado_LN();

    private Grado_LN() {
    }

    public static Grado_LN getInstance() {
        return instance;
    }

    private GradoAD gradoAD = FactoryADOracle.getFactory().getGradoAD();

    public List<Grado> listarGrados() {
        return gradoAD.listarGrados();
    }

    public String registrarGrado(Grado grado) {
        return gradoAD.registrarGrado(grado);
    }

    public String modificarGrado(Grado grado) {
        return gradoAD.modificarGrado(grado);
    }

    public String eliminarGrado(int codGrado) {
        return gradoAD.eliminarGrado(codGrado);
    }

    public Grado buscarGrado(int codGrado) {
        return gradoAD.buscarGrado(codGrado);
    }
}
