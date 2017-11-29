package com.virgenmilagrosa.logicanegocio.pagos;

import com.virgenmilagrosa.accesodatos.FactoryADOracle;
import java.util.List;

import com.virgenmilagrosa.accesodatos.pagos.*;
import com.virgenmilagrosa.tranversal.entidades.Comprobante;

public class ComprobantePago_LN {

    private static final ComprobantePago_LN instance = new ComprobantePago_LN();

    private ComprobantePago_LN() {
    }

    public static ComprobantePago_LN getInstance() {
        return instance;
    }

    private ComprobantePagoAD comprobantePagoAD = FactoryADOracle.getFactory().getComprobantePagoAD();

    public List<Comprobante> listarComprobantes() {
        return comprobantePagoAD.listarComprobantes();
    }

    public int registrarComprobante(Comprobante comprobante) {
        return comprobantePagoAD.registrarComprobante(comprobante);
    }

    public String modificarComprobante(Comprobante comprobante) {
        return comprobantePagoAD.modificarComprobante(comprobante);
    }

    public String eliminarComprobante(int nroComprobante) {
        return comprobantePagoAD.eliminarComprobante(nroComprobante);
    }

    public Comprobante buscarComprobante(int nroComprobante) {
        return comprobantePagoAD.buscarComprobante(nroComprobante);
    }

}
