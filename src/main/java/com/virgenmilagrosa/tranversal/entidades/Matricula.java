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
    public int COD_SECCION;
    public int COD_GRADO;
    public int COD_ALU;
    
    public String COD_MATRICULA;
    public Date FECHA_EJECUCION;

    public Matricula(int COD_SECCION, int COD_GRADO, int COD_ALU, String COD_MATRICULA, Date FECHA_EJECUCION) {
        this.COD_SECCION = COD_SECCION;
        this.COD_GRADO = COD_GRADO;
        this.COD_ALU = COD_ALU;
        this.COD_MATRICULA = COD_MATRICULA;
        this.FECHA_EJECUCION = FECHA_EJECUCION;
    }

    public int getCOD_SECCION() {
        return COD_SECCION;
    }

    public void setCOD_SECCION(int COD_SECCION) {
        this.COD_SECCION = COD_SECCION;
    }

    public int getCOD_GRADO() {
        return COD_GRADO;
    }

    public void setCOD_GRADO(int COD_GRADO) {
        this.COD_GRADO = COD_GRADO;
    }

    public int getCOD_ALU() {
        return COD_ALU;
    }

    public void setCOD_ALU(int COD_ALU) {
        this.COD_ALU = COD_ALU;
    }

    public String getCOD_MATRICULA() {
        return COD_MATRICULA;
    }

    public void setCOD_MATRICULA(String COD_MATRICULA) {
        this.COD_MATRICULA = COD_MATRICULA;
    }

    public Date getFECHA_EJECUCION() {
        return FECHA_EJECUCION;
    }

    public void setFECHA_EJECUCION(Date FECHA_EJECUCION) {
        this.FECHA_EJECUCION = FECHA_EJECUCION;
    }

}
