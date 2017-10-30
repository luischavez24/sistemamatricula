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
    public int COD_ALU;
    public String APATERNO_ALU;
    public String NOMBRE_ALU;
    public String AMATERNO_ALU;
    public String TELEFONO_ALU;
    public String EMAIL_ALU;
    public String DIRECCION_ALU;
    public int COD_APODERADO;

    public Alumnos(int COD_ALU, String APATERNO_ALU, String NOMBRE_ALU, String AMATERNO_ALU, String TELEFONO_ALU, String EMAIL_ALU, String DIRECCION_ALU, int COD_APODERADO) {
        this.COD_ALU = COD_ALU;
        this.APATERNO_ALU = APATERNO_ALU;
        this.NOMBRE_ALU = NOMBRE_ALU;
        this.AMATERNO_ALU = AMATERNO_ALU;
        this.TELEFONO_ALU = TELEFONO_ALU;
        this.EMAIL_ALU = EMAIL_ALU;
        this.DIRECCION_ALU = DIRECCION_ALU;
        this.COD_APODERADO = COD_APODERADO;
    }

    public int getCOD_ALU() {
        return COD_ALU;
    }

    public void setCOD_ALU(int COD_ALU) {
        this.COD_ALU = COD_ALU;
    }

    public String getAPATERNO_ALU() {
        return APATERNO_ALU;
    }

    public void setAPATERNO_ALU(String APATERNO_ALU) {
        this.APATERNO_ALU = APATERNO_ALU;
    }

    public String getNOMBRE_ALU() {
        return NOMBRE_ALU;
    }

    public void setNOMBRE_ALU(String NOMBRE_ALU) {
        this.NOMBRE_ALU = NOMBRE_ALU;
    }

    public String getAMATERNO_ALU() {
        return AMATERNO_ALU;
    }

    public void setAMATERNO_ALU(String AMATERNO_ALU) {
        this.AMATERNO_ALU = AMATERNO_ALU;
    }

    public String getTELEFONO_ALU() {
        return TELEFONO_ALU;
    }

    public void setTELEFONO_ALU(String TELEFONO_ALU) {
        this.TELEFONO_ALU = TELEFONO_ALU;
    }

    public String getEMAIL_ALU() {
        return EMAIL_ALU;
    }

    public void setEMAIL_ALU(String EMAIL_ALU) {
        this.EMAIL_ALU = EMAIL_ALU;
    }

    public String getDIRECCION_ALU() {
        return DIRECCION_ALU;
    }

    public void setDIRECCION_ALU(String DIRECCION_ALU) {
        this.DIRECCION_ALU = DIRECCION_ALU;
    }

    public int getCOD_APODERADO() {
        return COD_APODERADO;
    }

    public void setCOD_APODERADO(int COD_APODERADO) {
        this.COD_APODERADO = COD_APODERADO;
    }

    
}
