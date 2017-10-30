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
    public int COD_APODERADO;
    public String NOMBRE_AP;
    public String APATERNO_AP;
    public String AMATERNO_AP;
    public String DNI_AP;
    public String EMAIL_AP;
    public String TELEFONO_AP;
    public String OCUPACION;

    public Apoderado(int COD_APODERADO, String NOMBRE_AP, String APATERNO_AP, String AMATERNO_AP, String DNI_AP, String EMAIL_AP, String TELEFONO_AP, String OCUPACION) {
        this.COD_APODERADO = COD_APODERADO;
        this.NOMBRE_AP = NOMBRE_AP;
        this.APATERNO_AP = APATERNO_AP;
        this.AMATERNO_AP = AMATERNO_AP;
        this.DNI_AP = DNI_AP;
        this.EMAIL_AP = EMAIL_AP;
        this.TELEFONO_AP = TELEFONO_AP;
        this.OCUPACION = OCUPACION;
    }

    public int getCOD_APODERADO() {
        return COD_APODERADO;
    }

    public void setCOD_APODERADO(int COD_APODERADO) {
        this.COD_APODERADO = COD_APODERADO;
    }

    public String getNOMBRE_AP() {
        return NOMBRE_AP;
    }

    public void setNOMBRE_AP(String NOMBRE_AP) {
        this.NOMBRE_AP = NOMBRE_AP;
    }

    public String getAPATERNO_AP() {
        return APATERNO_AP;
    }

    public void setAPATERNO_AP(String APATERNO_AP) {
        this.APATERNO_AP = APATERNO_AP;
    }

    public String getAMATERNO_AP() {
        return AMATERNO_AP;
    }

    public void setAMATERNO_AP(String AMATERNO_AP) {
        this.AMATERNO_AP = AMATERNO_AP;
    }

    public String getDNI_AP() {
        return DNI_AP;
    }

    public void setDNI_AP(String DNI_AP) {
        this.DNI_AP = DNI_AP;
    }

    public String getEMAIL_AP() {
        return EMAIL_AP;
    }

    public void setEMAIL_AP(String EMAIL_AP) {
        this.EMAIL_AP = EMAIL_AP;
    }

    public String getTELEFONO_AP() {
        return TELEFONO_AP;
    }

    public void setTELEFONO_AP(String TELEFONO_AP) {
        this.TELEFONO_AP = TELEFONO_AP;
    }

    public String getOCUPACION() {
        return OCUPACION;
    }

    public void setOCUPACION(String OCUPACION) {
        this.OCUPACION = OCUPACION;
    }

}
