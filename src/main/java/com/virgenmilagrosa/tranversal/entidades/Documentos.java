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
public class Documentos {
    public int COD_DOCUMENTO;
    public String  DESCRIPCION_DOC;
    public int GRADO_IMPORTANCIA;

    public Documentos(int COD_DOCUMENTO, String DESCRIPCION_DOC, int GRADO_IMPORTANCIA) {
        this.COD_DOCUMENTO = COD_DOCUMENTO;
        this.DESCRIPCION_DOC = DESCRIPCION_DOC;
        this.GRADO_IMPORTANCIA = GRADO_IMPORTANCIA;
    }

    public int getCOD_DOCUMENTO() {
        return COD_DOCUMENTO;
    }

    public void setCOD_DOCUMENTO(int COD_DOCUMENTO) {
        this.COD_DOCUMENTO = COD_DOCUMENTO;
    }

    public String getDESCRIPCION_DOC() {
        return DESCRIPCION_DOC;
    }

    public void setDESCRIPCION_DOC(String DESCRIPCION_DOC) {
        this.DESCRIPCION_DOC = DESCRIPCION_DOC;
    }

    public int getGRADO_IMPORTANCIA() {
        return GRADO_IMPORTANCIA;
    }

    public void setGRADO_IMPORTANCIA(int GRADO_IMPORTANCIA) {
        this.GRADO_IMPORTANCIA = GRADO_IMPORTANCIA;
    }


    
}
