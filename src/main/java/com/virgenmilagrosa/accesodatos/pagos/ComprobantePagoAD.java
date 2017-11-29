/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virgenmilagrosa.accesodatos.pagos;

import com.virgenmilagrosa.tranversal.entidades.Comprobante;
import java.util.List;

public interface ComprobantePagoAD {

    public List<Comprobante> listarComprobantes();

    public int registrarComprobante(Comprobante comprobante) ;

    public String modificarComprobante(Comprobante comprobante);

    public String eliminarComprobante(int nroComprobante);

    public Comprobante buscarComprobante(int nroComprobante);
}
