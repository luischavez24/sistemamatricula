package com.virgenmilagrosa.logicanegocio.ejecucionmatricula;

import java.util.List;

import com.virgenmilagrosa.accesodatos.ejecucionmatricula.Documento_AD;
import com.virgenmilagrosa.tranversal.entidades.Documentos;

public class Documento_LN {
	private static final Documento_LN instance = new Documento_LN();

	private Documento_LN() {
	}

	public static Documento_LN getInstance() {
		return instance;
	}
	
	private Documento_AD documentoAD = Documento_AD.getInstance();
	
	public List<Documentos> listaActas () {
		try {
			
			return documentoAD.listarDocumentos();
			
		} catch (Exception e) {
			
			return null;
			
		}
	}
	
	public String registrarActa(Documentos documento) {
		return documentoAD.registrarDocumento(documento);
	}

	public String modificarActa(Documentos documento) {
		return documentoAD.modificarDocumento(documento);
	}

	public String eliminarActa(int codDocumento) {
		return documentoAD.eliminarDocumento(codDocumento);
	}
	
	public Documentos buscarActa(int codDocumento) {
		return documentoAD.buscarDocumento(codDocumento);
	}
}
