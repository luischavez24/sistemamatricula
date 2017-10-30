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
    public int COD_DOCUMENTO;
    public int COD_ALU;
    
    public Date FECHA_ENTREGA;
    public int COD_USUARIO;
    public int ESTADO;

    public Acta(int COD_DOCUMENTO, int COD_ALU, Date FECHA_ENTREGA, int COD_USUARIO, int ESTADO) {
        this.COD_DOCUMENTO = COD_DOCUMENTO;
        this.COD_ALU = COD_ALU;
        this.FECHA_ENTREGA = FECHA_ENTREGA;
        this.COD_USUARIO = COD_USUARIO;
        this.ESTADO = ESTADO;
    }

    public int getCOD_DOCUMENTO() {
        return COD_DOCUMENTO;
    }

    public void setCOD_DOCUMENTO(int COD_DOCUMENTO) {
        this.COD_DOCUMENTO = COD_DOCUMENTO;
    }

    public int getCOD_ALU() {
        return COD_ALU;
    }

    public void setCOD_ALU(int COD_ALU) {
        this.COD_ALU = COD_ALU;
    }

    public Date getFECHA_ENTREGA() {
        return FECHA_ENTREGA;
    }

    public void setFECHA_ENTREGA(Date FECHA_ENTREGA) {
        this.FECHA_ENTREGA = FECHA_ENTREGA;
    }

    public int getCOD_USUARIO() {
        return COD_USUARIO;
    }

    public void setCOD_USUARIO(int COD_USUARIO) {
        this.COD_USUARIO = COD_USUARIO;
    }

    public int getESTADO() {
        return ESTADO;
    }

    public void setESTADO(int ESTADO) {
        this.ESTADO = ESTADO;
    }

   
}
