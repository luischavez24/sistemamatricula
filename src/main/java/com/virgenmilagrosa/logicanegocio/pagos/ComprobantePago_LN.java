package com.virgenmilagrosa.logicanegocio.pagos;

import java.util.List;

import com.virgenmilagrosa.accesodatos.pagos.ComprobantePago_AD;
import com.virgenmilagrosa.tranversal.entidades.Comprobante;

public class ComprobantePago_LN {
	
	private static final ComprobantePago_LN instance = new ComprobantePago_LN();

	private ComprobantePago_LN() {
	}

	public static ComprobantePago_LN getInstance() {
		return instance;
	}

	private ComprobantePago_AD comprobantePagoAD = ComprobantePago_AD.getInstance();
	
	public List<Comprobante> listarComprobantes() {
		return comprobantePagoAD.listarComprobantes();
	}

	public String registrarComprobante(Comprobante comprobante) {
		return comprobantePagoAD.registrarComprobante(comprobante);
	}

	public String modificarComprobante(Comprobante comprobante) {
		return comprobantePagoAD.modificarComprobante(comprobante);
	}

	public String eliminarComprobante(String nroComprobante) {
		return comprobantePagoAD.eliminarComprobante(nroComprobante);
	}

	public Comprobante buscarComprobante(String nroComprobante) {
		return comprobantePagoAD.buscarComprobante(nroComprobante);
	}

}
