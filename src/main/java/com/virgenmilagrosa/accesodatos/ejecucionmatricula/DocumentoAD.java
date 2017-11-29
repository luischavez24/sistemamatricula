/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virgenmilagrosa.accesodatos.ejecucionmatricula;

import com.virgenmilagrosa.tranversal.entidades.Documentos;
import java.util.List;

/**
 *
 * @author lucho
 */
public interface DocumentoAD {
    
    public List<Documentos> listarDocumentos() ;

    public String registrarDocumento(Documentos documento);

    public String modificarDocumento(Documentos documento) ;

    public String eliminarDocumento(int codDocumento) ;
}
