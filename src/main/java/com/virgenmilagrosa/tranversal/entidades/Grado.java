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
    public int cod_grado;
    public String nom_grado;
    public int nivel;

    public Grado(int cod_grado, String nom_grado, int nivel) {
        this.cod_grado = cod_grado;
        this.nom_grado = nom_grado;
        this.nivel = nivel;
    }

    public int getCod_grado() {
        return cod_grado;
    }

    public void setCod_grado(int cod_grado) {
        this.cod_grado = cod_grado;
    }

    public String getNom_grado() {
        return nom_grado;
    }

    public void setNom_grado(String nom_grado) {
        this.nom_grado = nom_grado;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
}
