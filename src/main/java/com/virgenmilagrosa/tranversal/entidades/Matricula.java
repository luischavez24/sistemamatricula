/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virgenmilagrosa.tranversal.entidades;

import java.util.Date;

/**
 *
 * @author juanmanuel
 */
public class Matricula {
    public Seccion SeccionMatricula;
    public Grado GradoMatricula;
    public Alumnos AlumMatricula;
    
    public String cod_matricula;
    public Date fecha_ejecucion;

    public Matricula(Seccion SeccionMatricula, Grado GradoMatricula, Alumnos AlumMatricula, String cod_matricula, Date fecha_ejecucion) {
        this.SeccionMatricula = SeccionMatricula;
        this.GradoMatricula = GradoMatricula;
        this.AlumMatricula = AlumMatricula;
        this.cod_matricula = cod_matricula;
        this.fecha_ejecucion = fecha_ejecucion;
    }

    public Seccion getSeccionMatricula() {
        return SeccionMatricula;
    }

    public void setSeccionMatricula(Seccion SeccionMatricula) {
        this.SeccionMatricula = SeccionMatricula;
    }

    public Grado getGradoMatricula() {
        return GradoMatricula;
    }

    public void setGradoMatricula(Grado GradoMatricula) {
        this.GradoMatricula = GradoMatricula;
    }

    public Alumnos getAlumMatricula() {
        return AlumMatricula;
    }

    public void setAlumMatricula(Alumnos AlumMatricula) {
        this.AlumMatricula = AlumMatricula;
    }

    public String getCod_matricula() {
        return cod_matricula;
    }

    public void setCod_matricula(String cod_matricula) {
        this.cod_matricula = cod_matricula;
    }

    public Date getFecha_ejecucion() {
        return fecha_ejecucion;
    }

    public void setFecha_ejecucion(Date fecha_ejecucion) {
        this.fecha_ejecucion = fecha_ejecucion;
    }
    
}
