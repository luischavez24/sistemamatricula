package com.virgenmilagrosa.accesodatos.gestionalumnos;

import com.virgenmilagrosa.tranversal.entidades.Apoderado;
import java.util.List;

public interface ApoderadoAD {

    public List<Apoderado> listarApoderados();

    public String registrarApoderado(Apoderado apoderado);

    public String modificarApoderado(Apoderado apoderado);

    public String eliminarApoderado(int codApoderado);

    public Apoderado buscarApoderado(int codApoderado);
}
