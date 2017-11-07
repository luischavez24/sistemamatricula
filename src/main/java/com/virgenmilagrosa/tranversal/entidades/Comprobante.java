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
    private int nroComprobante;
    private double monto;
    private Date fechaEmision;
    private int codSeccion;
    private int codGrado;
    private int codAlu;

    public Comprobante() {
    }

    public Comprobante(int nroComprobante, double monto, Date fechaEmision, int codSeccion, int codGrado, int codAlu) {
        this.nroComprobante = nroComprobante;
        this.monto = monto;
        this.fechaEmision = fechaEmision;
        this.codSeccion = codSeccion;
        this.codGrado = codGrado;
        this.codAlu = codAlu;
    }

    public int getNroComprobante() {
        return nroComprobante;
    }

    public void setNroComprobante(int nroComprobante) {
        this.nroComprobante = nroComprobante;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
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
}
