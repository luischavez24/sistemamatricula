/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virgenmilagrosa.accesodatos.ejecucionmatricula;

import com.virgenmilagrosa.tranversal.entidades.Acta;
import java.util.List;


/**
 *
 * @author lucho
 */
public interface ActaAD {
    
    public List<Acta> listarActas();

    public String registrarActa(Acta acta) ;

    public String modificarActa(Acta acta);

    public String eliminarActa(int codDocumento, int codAlumno);
}
