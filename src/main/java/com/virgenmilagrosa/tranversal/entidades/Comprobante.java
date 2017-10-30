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
    public String nroComprobante;
    public int monto;
    public Date fechaEmision;
    public Matricula MatriculaComprobante;

    public Comprobante(String nroComprobante, int monto, Date fechaEmision, Matricula MatriculaComprobante) {
        this.nroComprobante = nroComprobante;
        this.monto = monto;
        this.fechaEmision = fechaEmision;
        this.MatriculaComprobante = MatriculaComprobante;
    }

    public String getNroComprobante() {
        return nroComprobante;
    }

    public void setNroComprobante(String nroComprobante) {
        this.nroComprobante = nroComprobante;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Matricula getMatriculaComprobante() {
        return MatriculaComprobante;
    }

    public void setMatriculaComprobante(Matricula MatriculaComprobante) {
        this.MatriculaComprobante = MatriculaComprobante;
    }
    

    
}
