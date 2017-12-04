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
    private int codDocumento;
    private String  descripcionDoc;
    private int gradoImportancia;

    public Documentos() {
    }

    public Documentos(int codDocumento, String descripcionDoc, int gradoImportancia) {
        this.codDocumento = codDocumento;
        this.descripcionDoc = descripcionDoc;
        this.gradoImportancia = gradoImportancia;
    }

    public int getCodDocumento() {
        return codDocumento;
    }

    public void setCodDocumento(int codDocumento) {
        this.codDocumento = codDocumento;
    }

    public String getDescripcionDoc() {
        return descripcionDoc;
    }

    public void setDescripcionDoc(String descripcionDoc) {
        this.descripcionDoc = descripcionDoc;
    }

    public int getGradoImportancia() {
        return gradoImportancia;
    }

    public void setGradoImportancia(int gradoImportancia) {
        this.gradoImportancia = gradoImportancia;
    }
    
    @Override
    public String toString() {
        return descripcionDoc;
    }
}
