package com.virgenmilagrosa;
import com.virgenmilagrosa.presentacion.generarmatricula.FrmGenerarMatricula;
import com.virgenmilagrosa.presentacion.gestionusuarios.FrmInicioSesion;

public class GestionMatriculaApplication {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
             */
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
            new FrmInicioSesion().setVisible(true);
        });
    }
}
