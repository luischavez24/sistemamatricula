package com.virgenmilagrosa.accesodatos.gestionalumnos;

import com.virgenmilagrosa.tranversal.entidades.Grado;
import java.util.List;

public interface GradoAD {

    public List<Grado> listarGrados();

    public String registrarGrado(Grado grado);

    public String modificarGrado(Grado grado);

    public String eliminarGrado(int codGrado);

    public Grado buscarGrado(int codGrado);
}
