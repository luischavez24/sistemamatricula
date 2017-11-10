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
    
    private int codSeccion;
    private int codGrado;
    private int codAlu;
    private String codMatricula;
    private Date fechaEjecucion;
    private int pAcademico;
    public Matricula() { }

    public Matricula(int codSeccion, int codGrado, int codAlu, String codMatricula, Date fechaEjecucion, int pAcademico) {
        this.codSeccion = codSeccion;
        this.codGrado = codGrado;
        this.codAlu = codAlu;
        this.codMatricula = codMatricula;
        this.fechaEjecucion = fechaEjecucion;
        this.pAcademico = pAcademico;
    }

    public int getCodSeccion() {
        return codSeccion;
    }

    public void setCodSeccion(int codSeccion) {
        this.codSeccion = codSeccion;
    }

    public int getCodGrado() {
        return codGrado;
    }

    public void setCodGrado(int codGrado) {
        this.codGrado = codGrado;
    }

    public int getCodAlu() {
        return codAlu;
    }

    public void setCodAlu(int codAlu) {
        this.codAlu = codAlu;
    }

    public String getCodMatricula() {
        return codMatricula;
    }

    public void setCodMatricula(String codMatricula) {
        this.codMatricula = codMatricula;
    }

    public Date getFechaEjecucion() {
        return fechaEjecucion;
    }

    public void setFechaEjecucion(Date fechaEjecucion) {
        this.fechaEjecucion = fechaEjecucion;
    }

    public int getpAcademico() {
        return pAcademico;
    }

    public void setpAcademico(int pAcademico) {
        this.pAcademico = pAcademico;
    }
}
