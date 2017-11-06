/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virgenmilagrosa.presentacion.gestionusuarios;

import com.virgenmilagrosa.logicanegocio.gestionusuarios.Usuario_LN;
import com.virgenmilagrosa.presentacion.FrmInterfazPrincipal;
import com.virgenmilagrosa.tranversal.control.Validaciones;
import java.awt.EventQueue;
import javax.swing.JOptionPane;

/**
 *
 * @author lucho
 */
public class FrmInicioSesion extends javax.swing.JFrame {

    /**
     * Creates new form FrmInicioSesion
     */
    private Usuario_LN usuarioLN = Usuario_LN.getInstance();

    public FrmInicioSesion() {
        initComponents();
        MetodoInicio();
    }

    private void MetodoInicio() {
        setLocationRelativeTo(null);
        Validaciones v = new Validaciones();
        v.LimitarCaracter(txtUsuario, 15);
        v.LimitarCaracter(txtContra, 15);

    }

    public void ValidarIngreso() {
        String usuario = txtUsuario.getText().trim();
        String password = new String(txtContra.getPassword()).trim();

        if (usuario.isEmpty() || password.isEmpty()) {
            btnIngresar.setEnabled(false);
        } else {
            btnIngresar.setEnabled(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        usuario = new javax.swing.JLabel();
        contrasena = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContra = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gestion de Matricula");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        usuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        usuario.setText("Usuario");

        contrasena.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        contrasena.setText("Contraseña");

        txtUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUsuario.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtUsuarioCaretUpdate(evt);
            }
        });

        txtContra.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtContra.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtContraCaretUpdate(evt);
            }
        });

        btnIngresar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.setEnabled(false);
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/escudo.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(contrasena)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtContra))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(btnIngresar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usuario))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(contrasena)
                            .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(btnIngresar)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
        String user = txtUsuario.getText();
        String pass = new String(txtContra.getPassword());
        String mensaje;
        int iconBox;
        
        int verificacion = usuarioLN.verificarUsuario(user, pass);
        switch (verificacion) {
            case 0:
                mensaje = "El usuario o la contraseña no son correctos";
                iconBox = JOptionPane.WARNING_MESSAGE;
                break;
            case 1:
            case 2:
                mensaje = "Bienvenido!";
                iconBox = JOptionPane.INFORMATION_MESSAGE;
                break;
            default:
                mensaje = "Ups! Esto es vergonzoso, ha ocurrido un error grave.\n"
                        + "Contacte con su proveedor de software";
                iconBox = JOptionPane.ERROR_MESSAGE;
                break;
        }
        
        JOptionPane.showMessageDialog(rootPane, mensaje, "Mensaje", iconBox);
        if(verificacion > 0) {
            abrirVentanaPrincipal(verificacion);
        }
        
        
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void abrirVentanaPrincipal(int rol) {
        this.dispose();
        EventQueue.invokeLater(() -> {
            new FrmInterfazPrincipal(rol).setVisible(true);
        });
    }
    private void txtUsuarioCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtUsuarioCaretUpdate
        // TODO add your handling code here:
        this.ValidarIngreso();
    }//GEN-LAST:event_txtUsuarioCaretUpdate

    private void txtContraCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtContraCaretUpdate
        // TODO add your handling code here:
        this.ValidarIngreso();
    }//GEN-LAST:event_txtContraCaretUpdate

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel contrasena;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtContra;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}
