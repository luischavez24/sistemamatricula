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
public class Alumnos {
    public int cod_alu;
    public String apaterno_alu;
    public String nombre_alu;
    public String amaterno_alu;
    public String telefono_alu;
    public String email_alu;
    public String direccion_alu;
    public Apoderado apodAlumn;

    public Alumnos(int cod_alu, String apaterno_alu, String nombre_alu, String amaterno_alu, String telefono_alu, String email_alu, String direccion_alu, Apoderado apodAlumn) {
        this.cod_alu = cod_alu;
        this.apaterno_alu = apaterno_alu;
        this.nombre_alu = nombre_alu;
        this.amaterno_alu = amaterno_alu;
        this.telefono_alu = telefono_alu;
        this.email_alu = email_alu;
        this.direccion_alu = direccion_alu;
        this.apodAlumn = apodAlumn;
    }

    public int getCod_alu() {
        return cod_alu;
    }

    public void setCod_alu(int cod_alu) {
        this.cod_alu = cod_alu;
    }

    public String getApaterno_alu() {
        return apaterno_alu;
    }

    public void setApaterno_alu(String apaterno_alu) {
        this.apaterno_alu = apaterno_alu;
    }

    public String getNombre_alu() {
        return nombre_alu;
    }

    public void setNombre_alu(String nombre_alu) {
        this.nombre_alu = nombre_alu;
    }

    public String getAmaterno_alu() {
        return amaterno_alu;
    }

    public void setAmaterno_alu(String amaterno_alu) {
        this.amaterno_alu = amaterno_alu;
    }

    public String getTelefono_alu() {
        return telefono_alu;
    }

    public void setTelefono_alu(String telefono_alu) {
        this.telefono_alu = telefono_alu;
    }

    public String getEmail_alu() {
        return email_alu;
    }

    public void setEmail_alu(String email_alu) {
        this.email_alu = email_alu;
    }

    public String getDireccion_alu() {
        return direccion_alu;
    }

    public void setDireccion_alu(String direccion_alu) {
        this.direccion_alu = direccion_alu;
    }

    public Apoderado getApodAlumn() {
        return apodAlumn;
    }

    public void setApodAlumn(Apoderado apodAlumn) {
        this.apodAlumn = apodAlumn;
    }

    
}
