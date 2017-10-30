/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virgenmilagrosa.tranversal.entidades;
import java.util.Date;
/**
 *
 * @author juanmanuel
 */
public class Acta {
    public Documentos DocActa;
    public Alumnos AlumActa;
    
    public Date fecha_entrega;
    public Usuario UsuarioActa;
    public int estado;

    public Acta(Documentos DocActa, Alumnos AlumActa, Date fecha_entrega, Usuario UsuarioActa, int estado) {
        this.DocActa = DocActa;
        this.AlumActa = AlumActa;
        this.fecha_entrega = fecha_entrega;
        this.UsuarioActa = UsuarioActa;
        this.estado = estado;
    }

    public Documentos getDocActa() {
        return DocActa;
    }

    public void setDocActa(Documentos DocActa) {
        this.DocActa = DocActa;
    }

    public Alumnos getAlumActa() {
        return AlumActa;
    }

    public void setAlumActa(Alumnos AlumActa) {
        this.AlumActa = AlumActa;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public Usuario getUsuarioActa() {
        return UsuarioActa;
    }

    public void setUsuarioActa(Usuario UsuarioActa) {
        this.UsuarioActa = UsuarioActa;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}
