/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virgenmilagrosa;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author lucho
 */
public class GestionMatriculaConfig {

    public static final String URL = "jdbc:oracle:thin:@localhost:1521:basedatos1";
    public static final String USER = "sistema_matricula";
    public static final String PASS = "Prueba$1";

    public static void icon(JFrame frame) {
        ImageIcon image = new ImageIcon(frame.getClass().getResource("/logovm.png"));
        frame.setIconImage(image.getImage());
    }
}
