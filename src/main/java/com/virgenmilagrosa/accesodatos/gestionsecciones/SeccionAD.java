package com.virgenmilagrosa.accesodatos.gestionsecciones;

import com.virgenmilagrosa.tranversal.entidades.Seccion;

import java.util.List;


public interface SeccionAD {

    public List<Seccion> listarSecciones();

    public String registrarSeccion(Seccion seccion);

    public String modificarSeccion(Seccion seccion);

    public String eliminarSeccion(int codSeccion, int codGrado);

    public Seccion buscarSeccion(int codSeccion, int codGrado);

    public String ampliarVacantes(Seccion seccion, int vacantes);
}
