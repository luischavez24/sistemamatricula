package com.virgenmilagrosa.tranversal.entidades;

public class Seccion {
    private int codSeccion;
    private int codGrado;
    private String nombreSeccion;
    private int nroVacantes;
    private int nroSalon;   

    public Seccion() {
    }

    public Seccion(int codSeccion, int codGrado, String nombreSeccion, int nroVacantes, int nroSalon) {
        this.codSeccion = codSeccion;
        this.codGrado = codGrado;
        this.nombreSeccion = nombreSeccion;
        this.nroVacantes = nroVacantes;
        this.nroSalon = nroSalon;
    }

    public int getCodSeccion() {
        return codSeccion;
    }

    public void setCodSeccion(int codSeccion) {
        this.codSeccion = codSeccion;
    }

    public int getCodGrado() {
        return codGrado;
    }

    public void setCodGrado(int codGrado) {
        this.codGrado = codGrado;
    }

    public String getNombreSeccion() {
        return nombreSeccion;
    }

    public void setNombreSeccion(String nombreSeccion) {
        this.nombreSeccion = nombreSeccion;
    }

    public int getNroVacantes() {
        return nroVacantes;
    }

    public void setNroVacantes(int nroVacantes) {
        this.nroVacantes = nroVacantes;
    }

    public int getNroSalon() {
        return nroSalon;
    }

    public void setNroSalon(int nroSalon) {
        this.nroSalon = nroSalon;
    }

}
