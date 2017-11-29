package com.virgenmilagrosa.logicanegocio.ejecucionmatricula;

import com.virgenmilagrosa.accesodatos.FactoryADOracle;
import java.util.List;

import com.virgenmilagrosa.accesodatos.ejecucionmatricula.*;
import com.virgenmilagrosa.tranversal.entidades.Documentos;

public class Documento_LN {

    private static final Documento_LN instance = new Documento_LN();

    private Documento_LN() {
    }

    public static Documento_LN getInstance() {
        return instance;
    }

    private DocumentoAD documentoAD = FactoryADOracle.getFactory().getDocumentoAD();

    public List<Documentos> listaActas() {
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

}
