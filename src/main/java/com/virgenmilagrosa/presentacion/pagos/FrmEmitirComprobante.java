/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virgenmilagrosa.presentacion.pagos;

import com.virgenmilagrosa.logicanegocio.gestionalumnos.Alumno_LN;
import com.virgenmilagrosa.logicanegocio.gestionalumnos.Apoderado_LN;
import com.virgenmilagrosa.logicanegocio.pagos.ComprobantePago_LN;
import com.virgenmilagrosa.presentacion.FrmInterfazPrincipal;
import com.virgenmilagrosa.presentacion.generarmatricula.FrmGenerarMatricula;
import com.virgenmilagrosa.presentacion.gestionusuarios.FrmInicioSesion;
import com.virgenmilagrosa.tranversal.control.Credencial;
import com.virgenmilagrosa.tranversal.entidades.Alumnos;
import com.virgenmilagrosa.tranversal.entidades.Apoderado;
import com.virgenmilagrosa.tranversal.entidades.Comprobante;
import com.virgenmilagrosa.tranversal.entidades.Matricula;

import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author lucho
 */
public class FrmEmitirComprobante extends javax.swing.JFrame {

    /**
     * Creates new form FrmEmitirComprobante
     */
    private Matricula matricula;
    private Comprobante comprobante;
    private ComprobantePago_LN comprobanteLN = ComprobantePago_LN.getInstance();
    private Alumno_LN alumnoLN = Alumno_LN.getInstance();
    private Apoderado_LN apoderadoLN = Apoderado_LN.getInstance();
    private static final SimpleDateFormat FORMATO = new SimpleDateFormat("dd/MM/yy hh:mm:ss");

    public FrmEmitirComprobante(Matricula matricula) {
        this.matricula = matricula;
        initComponents();
        MetodoInicio();
    }

    private void MetodoInicio() {

        setLocationRelativeTo(null);
        int monto = 120;

        comprobante = new Comprobante();

        comprobante.setMonto(monto);
        comprobante.setCodAlu(matricula.getCodAlu());
        comprobante.setCodGrado(matricula.getCodGrado());
        comprobante.setCodSeccion(matricula.getCodSeccion());

        int codComprobante = comprobanteLN.registrarComprobante(comprobante);

        comprobante = comprobanteLN.buscarComprobante(codComprobante);

        if (comprobante != null) {

            Alumnos alumno = alumnoLN.buscarAlumno(comprobante.getCodAlu());

            Apoderado apoderado = apoderadoLN.buscarApoderado(alumno.getCodApoderado());

            if (codComprobante > 0) {
                String format = "########### INSTITUCION EDUCATIVA VIRGEN MILAGROSA ############\n"
                        + "CODIGO: %s\n"
                        + "APELLIDOS Y NOMBRES: %s\n"
                        + "APODERADO: %s     DNI: %s\n"
                        + "\n"
                        + "CONCEPTO  | DETALLE                      | MONTO   \n"
                        + "---------------------------------------------------\n"
                        + "       01 |                    MATRICULA |  %.2f   \n"
                        + "---------------------------------------------------\n"
                        + "FECHA: %s		          TOTAL:S./%.2f ";

                String salida = String.format(format,
                        alumno.getCodAlu(),
                        alumno.getNombreAlu() + " " + alumno.getaPaternoAlu() + " " + alumno.getaMaternoAlu(),
                        apoderado.getNombreAp() + " " + apoderado.getaPaternoAp() + " " + apoderado.getaMaternoAp(),
                        apoderado.getDniAp(),
                        comprobante.getMonto(),
                        FORMATO.format(comprobante.getFechaEmision()),
                        comprobante.getMonto()
                );

                txtAreaComprobante.setText(salida);
            } else {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un problema", "Error", JOptionPane.ERROR_MESSAGE);
            }
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
        jLabel1 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaComprobante = new javax.swing.JTextArea();
        btnImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Emitir Comprobante");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Emitir comprobante");

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        txtAreaComprobante.setColumns(20);
        txtAreaComprobante.setRows(5);
        txtAreaComprobante.setText("########### INSTITUCION EDUCATIVA VIRGEN MILAGROSA ############\nCODIGO: 15200138\nAPELLIDOS Y NOMBRES: PALPAN FLORES, YUDELY GUADALUPE\nAPODERADO: CHAVEZ ALIAGA, LUIS RICARDO     DNI: 73332125\n\nCONCEPTO  | DETALLE                      | MONTO\n---------------------------------------------------------------\n\n\n\n---------------------------------------------------------------\nFECHA: 16/10/2017\t\t          TOTAL: S/.   ");
        txtAreaComprobante.setEnabled(false);
        jScrollPane1.setViewportView(txtAreaComprobante);

        btnImprimir.setText("Imprimir Comprobante");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
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
            FrmInterfazPrincipal principal = new FrmInterfazPrincipal(Credencial.getInstance().getRol());
            principal.setVisible(true);
        });

    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // Impprimir comprobante, levantar impresora.
    }//GEN-LAST:event_btnImprimirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAreaComprobante;
    // End of variables declaration//GEN-END:variables
}
