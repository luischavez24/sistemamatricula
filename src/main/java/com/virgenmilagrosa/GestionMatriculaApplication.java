package com.virgenmilagrosa;

import com.virgenmilagrosa.presentacion.generarmatricula.FrmGenerarMatricula;
import com.virgenmilagrosa.presentacion.gestionusuarios.FrmInicioSesion;
import com.virgenmilagrosa.tranversal.conexion.AccesoBD;
import javax.swing.JOptionPane;

public class GestionMatriculaApplication {

    public static void main(String[] args) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGenerarMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        if (AccesoBD.getInstance().getConexion() != null) {
            java.awt.EventQueue.invokeLater(() -> {

                new FrmInicioSesion().setVisible(true);
            });
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "No se puede conectar a la base de datos,\n revise su conexión y vuelva a intentarlo",
                    "Servidor No Encontrado",
                    JOptionPane.ERROR_MESSAGE
            );
        }

    }
}
