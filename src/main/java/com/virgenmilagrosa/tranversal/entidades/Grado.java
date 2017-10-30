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
public class Grado {
    public int COD_GRADO;
    public String NOM_GRADO;
    public int NIVEL;

    public Grado(int COD_GRADO, String NOM_GRADO, int NIVEL) {
        this.COD_GRADO = COD_GRADO;
        this.NOM_GRADO = NOM_GRADO;
        this.NIVEL = NIVEL;
    }

    public int getCOD_GRADO() {
        return COD_GRADO;
    }

    public void setCOD_GRADO(int COD_GRADO) {
        this.COD_GRADO = COD_GRADO;
    }

    public String getNOM_GRADO() {
        return NOM_GRADO;
    }

    public void setNOM_GRADO(String NOM_GRADO) {
        this.NOM_GRADO = NOM_GRADO;
    }

    public int getNIVEL() {
        return NIVEL;
    }

    public void setNIVEL(int NIVEL) {
        this.NIVEL = NIVEL;
    }

}
