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
    public int codUsuario;
    public String aPaternoUsuario;
    public String nombre;
    public String aMaternoUsuario;
    public String dniUsuario;
    public String telfUsuario;
    public String username;
    public String password;
    public int rol;
    
    public Usuario() {
    }
    
    public Usuario(int codUsuario, String aPaternoUsuario, String nombre, 
            String aMaternoUsuario, String dniUsuario, String telfUsuario, 
            String username, int rol) {
        this.codUsuario = codUsuario;
        this.aPaternoUsuario = aPaternoUsuario;
        this.nombre = nombre;
        this.aMaternoUsuario = aMaternoUsuario;
        this.dniUsuario = dniUsuario;
        this.telfUsuario = telfUsuario;
        this.username = username;
        this.rol = rol;
    }
    
    public Usuario(int codUsuario, String aPaternoUsuario, String nombre, 
            String aMaternoUsuario, String dniUsuario, String telfUsuario, 
            String username, String password, int rol) {
        this.codUsuario = codUsuario;
        this.aPaternoUsuario = aPaternoUsuario;
        this.nombre = nombre;
        this.aMaternoUsuario = aMaternoUsuario;
        this.dniUsuario = dniUsuario;
        this.telfUsuario = telfUsuario;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getaPaternoUsuario() {
        return aPaternoUsuario;
    }

    public void setaPaternoUsuario(String aPaternoUsuario) {
        this.aPaternoUsuario = aPaternoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getaMaternoUsuario() {
        return aMaternoUsuario;
    }

    public void setaMaternoUsuario(String aMaternoUsuario) {
        this.aMaternoUsuario = aMaternoUsuario;
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public String getTelfUsuario() {
        return telfUsuario;
    }

    public void setTelfUsuario(String telfUsuario) {
        this.telfUsuario = telfUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }    

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
}
