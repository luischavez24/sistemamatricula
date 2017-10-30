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
public class Usuario {
    public int COD_USUARIO;
    public String APATERNO_USUARIO;
    public String NOMBRE;
    public String AMATERNO_USUARIO;
    public String DNI_USUARIO;
    public String TELF_USUARIO;
    public String USERNAME;
    public String PASSWORD;

    public Usuario(int COD_USUARIO, String APATERNO_USUARIO, String NOMBRE, String AMATERNO_USUARIO, String DNI_USUARIO, String TELF_USUARIO, String USERNAME, String PASSWORD) {
        this.COD_USUARIO = COD_USUARIO;
        this.APATERNO_USUARIO = APATERNO_USUARIO;
        this.NOMBRE = NOMBRE;
        this.AMATERNO_USUARIO = AMATERNO_USUARIO;
        this.DNI_USUARIO = DNI_USUARIO;
        this.TELF_USUARIO = TELF_USUARIO;
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
    }

    public int getCOD_USUARIO() {
        return COD_USUARIO;
    }

    public void setCOD_USUARIO(int COD_USUARIO) {
        this.COD_USUARIO = COD_USUARIO;
    }

    public String getAPATERNO_USUARIO() {
        return APATERNO_USUARIO;
    }

    public void setAPATERNO_USUARIO(String APATERNO_USUARIO) {
        this.APATERNO_USUARIO = APATERNO_USUARIO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getAMATERNO_USUARIO() {
        return AMATERNO_USUARIO;
    }

    public void setAMATERNO_USUARIO(String AMATERNO_USUARIO) {
        this.AMATERNO_USUARIO = AMATERNO_USUARIO;
    }

    public String getDNI_USUARIO() {
        return DNI_USUARIO;
    }

    public void setDNI_USUARIO(String DNI_USUARIO) {
        this.DNI_USUARIO = DNI_USUARIO;
    }

    public String getTELF_USUARIO() {
        return TELF_USUARIO;
    }

    public void setTELF_USUARIO(String TELF_USUARIO) {
        this.TELF_USUARIO = TELF_USUARIO;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

}
