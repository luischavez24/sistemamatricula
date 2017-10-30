package com.virgenmilagrosa.tranversal.entidades;

public class Seccion {
    public int COD_SECCION;
    public int COD_GRADO;
    public String NOMBRE_SECCION;
    public int NRO_VACANTES;
    public int NRO_SALON;   

    public Seccion(int COD_SECCION, int COD_GRADO, String NOMBRE_SECCION, int NRO_VACANTES, int NRO_SALON) {
        this.COD_SECCION = COD_SECCION;
        this.COD_GRADO = COD_GRADO;
        this.NOMBRE_SECCION = NOMBRE_SECCION;
        this.NRO_VACANTES = NRO_VACANTES;
        this.NRO_SALON = NRO_SALON;
    }

    public int getCOD_SECCION() {
        return COD_SECCION;
    }

    public void setCOD_SECCION(int COD_SECCION) {
        this.COD_SECCION = COD_SECCION;
    }

    public int getCOD_GRADO() {
        return COD_GRADO;
    }

    public void setCOD_GRADO(int COD_GRADO) {
        this.COD_GRADO = COD_GRADO;
    }

    public String getNOMBRE_SECCION() {
        return NOMBRE_SECCION;
    }

    public void setNOMBRE_SECCION(String NOMBRE_SECCION) {
        this.NOMBRE_SECCION = NOMBRE_SECCION;
    }

    public int getNRO_VACANTES() {
        return NRO_VACANTES;
    }

    public void setNRO_VACANTES(int NRO_VACANTES) {
        this.NRO_VACANTES = NRO_VACANTES;
    }

    public int getNRO_SALON() {
        return NRO_SALON;
    }

    public void setNRO_SALON(int NRO_SALON) {
        this.NRO_SALON = NRO_SALON;
    }

}
