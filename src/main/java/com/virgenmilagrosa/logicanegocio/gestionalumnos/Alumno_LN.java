package com.virgenmilagrosa.logicanegocio.gestionalumnos;

import java.util.List;

import com.virgenmilagrosa.accesodatos.gestionalumnos.Alumno_AD;
import com.virgenmilagrosa.tranversal.entidades.Alumnos;

public class Alumno_LN {

    private static final Alumno_LN instance = new Alumno_LN();

    private Alumno_LN() {
    }

    public static Alumno_LN getInstance() {
        return instance;
    }

    private Alumno_AD alumnoAD = Alumno_AD.getInstance();

    public List<Alumnos> listarAlumnos() {
        try {
            return alumnoAD.listarAlumnos();
        } catch (Exception e) {
            return null;
        }
    }

    public String registrarAlumno(Alumnos alumno) {
        return alumnoAD.registrarAlumno(alumno);
    }

    public String modificarAlumno(Alumnos alumno) {
        return alumnoAD.modificarAlumno(alumno);
    }

    public String eliminarAlumno(int codAlumno) {
        return alumnoAD.eliminarAlumno(codAlumno);
    }

    public Alumnos buscarAlumno(String dniAlumno) {
        return alumnoAD.buscarAlumno(dniAlumno);
    }
    
    public Alumnos buscarAlumno(int codAlu) {
        return alumnoAD.buscarAlumno(codAlu);
    }

}
