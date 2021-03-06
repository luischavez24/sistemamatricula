package com.virgenmilagrosa.logicanegocio.gestionsecciones;

import com.virgenmilagrosa.accesodatos.FactoryADOracle;
import java.util.List;

import com.virgenmilagrosa.accesodatos.gestionsecciones.*;
import com.virgenmilagrosa.tranversal.entidades.Seccion;

public class Seccion_LN {

    private static final Seccion_LN instance = new Seccion_LN();

    private Seccion_LN() {
    }

    public static Seccion_LN getInstance() {
        return instance;
    }

    private SeccionAD seccionAD = FactoryADOracle.getFactory().getSeccionAD();

    public List<Seccion> listarSecciones() {
        return seccionAD.listarSecciones();
    }

    public String registrarSeccion(Seccion seccion) {
        return seccionAD.registrarSeccion(seccion);
    }

    public String modificarSeccion(Seccion seccion) {
        return seccionAD.modificarSeccion(seccion);
    }

    public String eliminarSeccion(int codSeccion, int codGrado) {
        return seccionAD.eliminarSeccion(codSeccion, codGrado);
    }

    public Seccion buscarSeccion(int codSeccion, int codGrado) {
        return seccionAD.buscarSeccion(codSeccion, codGrado);
    }

    public String ampliarVacantes(Seccion seccion, int vacantes) {
        return seccionAD.ampliarVacantes(seccion, vacantes);
    }
}
