package com.virgenmilagrosa.accesodatos;

import com.virgenmilagrosa.accesodatos.ejecucionmatricula.*;
import com.virgenmilagrosa.accesodatos.ejecucionmatricula.imple.*;
import com.virgenmilagrosa.accesodatos.gestionalumnos.*;
import com.virgenmilagrosa.accesodatos.gestionalumnos.imple.*;
import com.virgenmilagrosa.accesodatos.gestionsecciones.SeccionAD;
import com.virgenmilagrosa.accesodatos.gestionsecciones.imple.SeccionADOracle;
import com.virgenmilagrosa.accesodatos.gestionusuarios.UsuarioAD;
import com.virgenmilagrosa.accesodatos.gestionusuarios.imple.UsuarioADOracle;
import com.virgenmilagrosa.accesodatos.pagos.ComprobantePagoAD;
import com.virgenmilagrosa.accesodatos.pagos.imple.ComprobantePagoADOracle;

public class FactoryADOracle {
    private static final FactoryADOracle FACTORY = new FactoryADOracle();
    
    private FactoryADOracle() {
    }
    
    public static FactoryADOracle getFactory() {
        return FACTORY;
    }
    
    public ActaAD getActaAD() {
        return new ActaADOracle();
    }
    
    public DocumentoAD getDocumentoAD() {
        return new DocumentoADOracle();
    }
    
    public MatriculaAD getMatriculaAD() {
        return new MatriculaADOracle();
    }
    
    public AlumnoAD getAlumnoAD(){
        return new AlumnoADOracle();
    }
    
    public ApoderadoAD getApoderadoAD() {
        return new ApoderadoADOracle();
    }
    
    public DistritoAD getDistritoAD() {
        return new DistritoADOracle();
    }
    
    public GradoAD getGradoAD() {
        return new GradoADOracle();
    }
    
    public SeccionAD getSeccionAD() {
        return new SeccionADOracle();
    }
    
    public UsuarioAD getUsuarioAD() {
        return new UsuarioADOracle();
    }
    
    public ComprobantePagoAD getComprobantePagoAD() {
        return new ComprobantePagoADOracle();
    }
}
