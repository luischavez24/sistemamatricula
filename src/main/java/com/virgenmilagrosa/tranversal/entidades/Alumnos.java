/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virgenmilagrosa.tranversal.entidades;
/**
 *
 * @author juanmanuel
 */
public class Alumnos {
    private int codAlu;
    private String aPaternoAlu;
    private String nombreAlu;
    private String aMaternoAlu;
    private String telefonoAlu;
    private String emailAlu;
    private String direccionAlu;
    private int codApoderado;
    private String dniAlumno;

    public Alumnos() {
    }

    public Alumnos(int codAlu, String aPaternoAlu, String nombreAlu, String aMaternoAlu, String telefonoAlu, String emailAlu, String direccionAlu, int codApoderado, String dniAlumno) {
        this.codAlu = codAlu;
        this.aPaternoAlu = aPaternoAlu;
        this.nombreAlu = nombreAlu;
        this.aMaternoAlu = aMaternoAlu;
        this.telefonoAlu = telefonoAlu;
        this.emailAlu = emailAlu;
        this.direccionAlu = direccionAlu;
        this.codApoderado = codApoderado;
        this.dniAlumno = dniAlumno;
    }

    public int getCodAlu() {
        return codAlu;
    }

    public void setCodAlu(int codAlu) {
        this.codAlu = codAlu;
    }

    public String getaPaternoAlu() {
        return aPaternoAlu;
    }

    public void setaPaternoAlu(String aPaternoAlu) {
        this.aPaternoAlu = aPaternoAlu;
    }

    public String getNombreAlu() {
        return nombreAlu;
    }

    public void setNombreAlu(String nombreAlu) {
        this.nombreAlu = nombreAlu;
    }

    public String getaMaternoAlu() {
        return aMaternoAlu;
    }

    public void setaMaternoAlu(String aMaternoAlu) {
        this.aMaternoAlu = aMaternoAlu;
    }

    public String getTelefonoAlu() {
        return telefonoAlu;
    }

    public void setTelefonoAlu(String telefonoAlu) {
        this.telefonoAlu = telefonoAlu;
    }

    public String getEmailAlu() {
        return emailAlu;
    }

    public void setEmailAlu(String emailAlu) {
        this.emailAlu = emailAlu;
    }

    public String getDireccionAlu() {
        return direccionAlu;
    }

    public void setDireccionAlu(String direccionAlu) {
        this.direccionAlu = direccionAlu;
    }

    public int getCodApoderado() {
        return codApoderado;
    }

    public void setCodApoderado(int codApoderado) {
        this.codApoderado = codApoderado;
    }

    public String getDniAlumno() {
        return dniAlumno;
    }

    public void setDniAlumno(String dniAlumno) {
        this.dniAlumno = dniAlumno;
    }
}
