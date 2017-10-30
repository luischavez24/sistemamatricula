package com.virgenmilagrosa.tranversal.entidades;

public class Seccion {
    public int cod_seccion;
    public Grado GradoSeccion;
    public String nom_seccion;
    public int nro_vacantes;
    public int nro_salon;   

    public Seccion(int cod_seccion, Grado GradoSeccion, String nom_seccion, int nro_vacantes, int nro_salon) {
        this.cod_seccion = cod_seccion;
        this.GradoSeccion = GradoSeccion;
        this.nom_seccion = nom_seccion;
        this.nro_vacantes = nro_vacantes;
        this.nro_salon = nro_salon;
    }

    public int getCod_seccion() {
        return cod_seccion;
    }

    public void setCod_seccion(int cod_seccion) {
        this.cod_seccion = cod_seccion;
    }

    public Grado getGradoSeccion() {
        return GradoSeccion;
    }

    public void setGradoSeccion(Grado GradoSeccion) {
        this.GradoSeccion = GradoSeccion;
    }

    public String getNom_seccion() {
        return nom_seccion;
    }

    public void setNom_seccion(String nom_seccion) {
        this.nom_seccion = nom_seccion;
    }

    public int getNro_vacantes() {
        return nro_vacantes;
    }

    public void setNro_vacantes(int nro_vacantes) {
        this.nro_vacantes = nro_vacantes;
    }

    public int getNro_salon() {
        return nro_salon;
    }

    public void setNro_salon(int nro_salon) {
        this.nro_salon = nro_salon;
    }

}
