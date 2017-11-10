/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virgenmilagrosa.tranversal.control;

/**
 *
 * @author lucho
 */
public class Credencial {
    private static final Credencial CREDENCIAL = new Credencial();
    
    private String username;
    private int rol;

    private Credencial() { }
    
    public static Credencial getInstance() {
        return CREDENCIAL;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
    
    
}
