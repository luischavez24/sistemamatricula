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
public class Comprobante {
    public String NRO_COMPROBANTE;
    public int MONTO;
    public Date FECHA_EMISION;
    public int COD_SECCION;
    public int COD_GRADO;
    public int COD_ALU;

    public Comprobante(String NRO_COMPROBANTE, int MONTO, Date FECHA_EMISION, int COD_SECCION, int COD_GRADO, int COD_ALU) {
        this.NRO_COMPROBANTE = NRO_COMPROBANTE;
        this.MONTO = MONTO;
        this.FECHA_EMISION = FECHA_EMISION;
        this.COD_SECCION = COD_SECCION;
        this.COD_GRADO = COD_GRADO;
        this.COD_ALU = COD_ALU;
    }

    public String getNRO_COMPROBANTE() {
        return NRO_COMPROBANTE;
    }

    public void setNRO_COMPROBANTE(String NRO_COMPROBANTE) {
        this.NRO_COMPROBANTE = NRO_COMPROBANTE;
    }

    public int getMONTO() {
        return MONTO;
    }

    public void setMONTO(int MONTO) {
        this.MONTO = MONTO;
    }

    public Date getFECHA_EMISION() {
        return FECHA_EMISION;
    }

    public void setFECHA_EMISION(Date FECHA_EMISION) {
        this.FECHA_EMISION = FECHA_EMISION;
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

}
