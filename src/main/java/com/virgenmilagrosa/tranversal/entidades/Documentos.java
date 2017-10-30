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
    public int cod_documento;
    public String  descripcion_doc;
    public int grado_importancia;

    public Documentos(int cod_documento, String descripcion_doc, int grado_importancia) {
        this.cod_documento = cod_documento;
        this.descripcion_doc = descripcion_doc;
        this.grado_importancia = grado_importancia;
    }

    public int getCod_documento() {
        return cod_documento;
    }

    public void setCod_documento(int cod_documento) {
        this.cod_documento = cod_documento;
    }

    public String getDescripcion_doc() {
        return descripcion_doc;
    }

    public void setDescripcion_doc(String descripcion_doc) {
        this.descripcion_doc = descripcion_doc;
    }

    public int getGrado_importancia() {
        return grado_importancia;
    }

    public void setGrado_importancia(int grado_importancia) {
        this.grado_importancia = grado_importancia;
    }

    
}
