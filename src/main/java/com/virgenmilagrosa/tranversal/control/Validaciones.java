/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virgenmilagrosa.tranversal.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author 123
 */
public class Validaciones {

    public void ValidarSoloLetras(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                int k = (int) e.getKeyChar();
                if (Character.isDigit(c) || k == 64 || (!Character.isLetter(c) && k != 32)) {
                    //si es un digito
                    e.consume();//no lo digita
                }
            }

        });

    }

    public void ValidarSoloNumeros(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                //int k = (int) e.getKeyChar();
                if (!Character.isDigit(c) || Character.isLetter(c)) {
                    //si es un digito
                    e.consume();//no lo digita
                }
            }

        });

    }

    public void LimitarCaracter(JTextField campo, int cantidad) {
        campo.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                //contar acracteres en un txtfield
                int tam = campo.getText().length();

                if (tam >= cantidad) {
                    //si es un digito
                    e.consume();//no lo digita
                }
            }
        });

    }

}
