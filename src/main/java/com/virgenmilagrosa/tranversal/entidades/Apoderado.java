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
public class Apoderado {
    private int codApoderado;
    private String nombreAp;
    private String aPaternoAp;
    private String aMaternoAp;
    private String dniAp;
    private String emailAp;
    private String telefonoAp;
    private String ocupacion;

    public Apoderado() {
    }

    public Apoderado(int codApoderado, String nombreAp, String aPaternoAp, String aMaternoAp, String dniAp, String emailAp, String telefonoAp, String ocupacion) {
        this.codApoderado = codApoderado;
        this.nombreAp = nombreAp;
        this.aPaternoAp = aPaternoAp;
        this.aMaternoAp = aMaternoAp;
        this.dniAp = dniAp;
        this.emailAp = emailAp;
        this.telefonoAp = telefonoAp;
        this.ocupacion = ocupacion;
    }

    public int getCodApoderado() {
        return codApoderado;
    }

    public void setCodApoderado(int codApoderado) {
        this.codApoderado = codApoderado;
    }

    public String getNombreAp() {
        return nombreAp;
    }

    public void setNombreAp(String nombreAp) {
        this.nombreAp = nombreAp;
    }

    public String getaPaternoAp() {
        return aPaternoAp;
    }

    public void setaPaternoAp(String aPaternoAp) {
        this.aPaternoAp = aPaternoAp;
    }

    public String getaMaternoAp() {
        return aMaternoAp;
    }

    public void setaMaternoAp(String aMaternoAp) {
        this.aMaternoAp = aMaternoAp;
    }

    public String getDniAp() {
        return dniAp;
    }

    public void setDniAp(String dniAp) {
        this.dniAp = dniAp;
    }

    public String getEmailAp() {
        return emailAp;
    }

    public void setEmailAp(String emailAp) {
        this.emailAp = emailAp;
    }

    public String getTelefonoAp() {
        return telefonoAp;
    }

    public void setTelefonoAp(String telefonoAp) {
        this.telefonoAp = telefonoAp;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
}
