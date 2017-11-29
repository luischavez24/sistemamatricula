/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virgenmilagrosa.logicanegocio.gestionalumnos;
import com.virgenmilagrosa.accesodatos.FactoryADOracle;
import com.virgenmilagrosa.tranversal.entidades.*;
import java.util.List;

/**
 *
 * @author lucho
 */
public class Distrito_LN {
    private static final Distrito_LN INSTANCE = new Distrito_LN();
    
    private Distrito_LN() {
        
    }
    
    public static Distrito_LN getInstance() {
        return INSTANCE;
    }
    
    public List<Distrito> listarDistritos() {
        return FactoryADOracle.getFactory().getDistritoAD().listarDistritos();
    }
}
