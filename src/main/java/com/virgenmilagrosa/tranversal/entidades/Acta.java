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
public class Acta {
    
    private int codDocumento;
    private int codAlu;
    private Date fechaEntrega;
    private int codUsuario;
    private int estado;

    public Acta() {
    }

    public Acta(int codDocumento, int codAlu, Date fechaEntrega, int codUsuario, int estado) {
        this.codDocumento = codDocumento;
        this.codAlu = codAlu;
        this.fechaEntrega = fechaEntrega;
        this.codUsuario = codUsuario;
        this.estado = estado;
    }

    public int getCodDocumento() {
        return codDocumento;
    }

    public void setCodDocumento(int codDocumento) {
        this.codDocumento = codDocumento;
    }

    public int getCodAlu() {
        return codAlu;
    }

    public void setCodAlu(int codAlu) {
        this.codAlu = codAlu;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
   
}
