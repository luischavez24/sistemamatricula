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
public class Apoderado {
    public int cod_apoderado;
    public String nombre_ap;
    public String apaterno_ap;
    public String amaterno_ap;
    public String dni_ap;
    public String email_ap;
    public String telefono_ap;
    public String ocupacion;

    public Apoderado(int cod_apoderado, String nombre_ap, String apaterno_ap, String amaterno_ap, String dni_ap, String email_ap, String telefono_ap, String ocupacion) {
        this.cod_apoderado = cod_apoderado;
        this.nombre_ap = nombre_ap;
        this.apaterno_ap = apaterno_ap;
        this.amaterno_ap = amaterno_ap;
        this.dni_ap = dni_ap;
        this.email_ap = email_ap;
        this.telefono_ap = telefono_ap;
        this.ocupacion = ocupacion;
    }

    public int getCod_apoderado() {
        return cod_apoderado;
    }

    public void setCod_apoderado(int cod_apoderado) {
        this.cod_apoderado = cod_apoderado;
    }

    public String getNombre_ap() {
        return nombre_ap;
    }

    public void setNombre_ap(String nombre_ap) {
        this.nombre_ap = nombre_ap;
    }

    public String getApaterno_ap() {
        return apaterno_ap;
    }

    public void setApaterno_ap(String apaterno_ap) {
        this.apaterno_ap = apaterno_ap;
    }

    public String getAmaterno_ap() {
        return amaterno_ap;
    }

    public void setAmaterno_ap(String amaterno_ap) {
        this.amaterno_ap = amaterno_ap;
    }

    public String getDni_ap() {
        return dni_ap;
    }

    public void setDni_ap(String dni_ap) {
        this.dni_ap = dni_ap;
    }

    public String getEmail_ap() {
        return email_ap;
    }

    public void setEmail_ap(String email_ap) {
        this.email_ap = email_ap;
    }

    public String getTelefono_ap() {
        return telefono_ap;
    }

    public void setTelefono_ap(String telefono_ap) {
        this.telefono_ap = telefono_ap;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    
}
