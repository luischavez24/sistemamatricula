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
    public int cod_usuario;
    public String apaterno_usuario;
    public String nombre;
    public String amaterno_usuario;
    public String dni_usuario;
    public String telf_usuario;
    public String username;
    public String pasword;

    public Usuario(int cod_usuario, String apaterno_usuario, String nombre, String amaterno_usuario, String dni_usuario, String telf_usuario, String username, String pasword) {
        this.cod_usuario = cod_usuario;
        this.apaterno_usuario = apaterno_usuario;
        this.nombre = nombre;
        this.amaterno_usuario = amaterno_usuario;
        this.dni_usuario = dni_usuario;
        this.telf_usuario = telf_usuario;
        this.username = username;
        this.pasword = pasword;
    }

    public int getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public String getApaterno_usuario() {
        return apaterno_usuario;
    }

    public void setApaterno_usuario(String apaterno_usuario) {
        this.apaterno_usuario = apaterno_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAmaterno_usuario() {
        return amaterno_usuario;
    }

    public void setAmaterno_usuario(String amaterno_usuario) {
        this.amaterno_usuario = amaterno_usuario;
    }

    public String getDni_usuario() {
        return dni_usuario;
    }

    public void setDni_usuario(String dni_usuario) {
        this.dni_usuario = dni_usuario;
    }

    public String getTelf_usuario() {
        return telf_usuario;
    }

    public void setTelf_usuario(String telf_usuario) {
        this.telf_usuario = telf_usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }
    
}
