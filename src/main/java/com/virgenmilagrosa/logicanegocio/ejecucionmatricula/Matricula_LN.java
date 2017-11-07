package com.virgenmilagrosa.logicanegocio.ejecucionmatricula;

import com.virgenmilagrosa.accesodatos.ejecucionmatricula.Matricula_AD;
import com.virgenmilagrosa.tranversal.entidades.Alumnos;
import com.virgenmilagrosa.tranversal.entidades.Seccion;

public class Matricula_LN {

    private static final Matricula_LN instance = new Matricula_LN();

    private Matricula_LN() {
    }

    public static Matricula_LN getInstance() {
        return instance;
    }

    private Matricula_AD matriculaAD = Matricula_AD.getInstance();

    public String ejecutarMatricula(Alumnos alumno, Seccion seccion) {
        return matriculaAD.ejecutarMatricula(alumno, seccion);
    }

}
