package com.virgenmilagrosa;

import com.virgenmilagrosa.presentacion.gestionusuarios.FrmInicioSesion;

public class GestionMatriculaApplication {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new FrmInicioSesion().setVisible(true);
        });
    }
}
