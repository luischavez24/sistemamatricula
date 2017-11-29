/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virgenmilagrosa.accesodatos.ejecucionmatricula;

import com.virgenmilagrosa.tranversal.entidades.Alumnos;
import com.virgenmilagrosa.tranversal.entidades.Matricula;
import com.virgenmilagrosa.tranversal.entidades.Seccion;


/**
 *
 * @author lucho
 */
public interface MatriculaAD {

    public String ejecutarMatricula(Alumnos alumno, Seccion seccion) ;

    public Matricula buscarMatricula(String codMatricula) ;

    public int verificarMatricula(String dniAlu);
}
