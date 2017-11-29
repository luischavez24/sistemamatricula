package com.virgenmilagrosa.accesodatos.gestionalumnos;

import com.virgenmilagrosa.tranversal.entidades.Alumnos;
import java.util.List;

public interface AlumnoAD {

    public List<Alumnos> listarAlumnos();

    public String registrarAlumno(Alumnos alumno);

    public String modificarAlumno(Alumnos alumno);

    public String eliminarAlumno(int codAlumno);

    public Alumnos buscarAlumno(String dniAlu);

    public Alumnos buscarAlumno(int codAlu);
}
