/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virgenmilagrosa.presentacion.generarmatricula;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.virgenmilagrosa.logicanegocio.ejecucionmatricula.Acta_LN;
import com.virgenmilagrosa.logicanegocio.ejecucionmatricula.Documento_LN;
import com.virgenmilagrosa.logicanegocio.gestionalumnos.Alumno_LN;
import com.virgenmilagrosa.logicanegocio.gestionusuarios.Usuario_LN;
import com.virgenmilagrosa.tranversal.control.Credencial;
import com.virgenmilagrosa.tranversal.control.Validaciones;
import com.virgenmilagrosa.tranversal.entidades.Acta;
import com.virgenmilagrosa.tranversal.entidades.Alumnos;
import com.virgenmilagrosa.tranversal.entidades.Documentos;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lucho
 */
public class FrmGenerarActaCompromiso extends javax.swing.JFrame {

    private DefaultTableModel modelo;
    private Alumno_LN alumnoLN = Alumno_LN.getInstance();
    private Documento_LN documentoLN = Documento_LN.getInstance();
    private Acta_LN actaLN = Acta_LN.getInstance();
    private Usuario_LN usuarioLN = Usuario_LN.getInstance();
    private Alumnos aluSelect;
    private static final String LOGO_COLE = "logovm.jpg";
    private List<Documentos> lDocs;

    public FrmGenerarActaCompromiso() {
        initComponents();

        modelo = new DefaultTableModel() {
            //para que las columnas y filas no se editen
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        MetodoInicio();
        tblactas.getTableHeader().setReorderingAllowed(false);
    }

    private void MetodoInicio() {
        Validaciones v = new Validaciones();
        v.LimitarCaracter(txtCodigo, 8);
        v.ValidarSoloNumeros(txtCodigo);
        llenarCombos();
        lDocs = new ArrayList<>();
        modelo.setColumnIdentifiers(new String[]{"Codigo", "Descripcion", "Importacia"});
        tblactas.setModel(modelo);
        setLocationRelativeTo(null);
        configurarSpinners(jSpinner1, "dd/MM/yy");
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
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblactas = new javax.swing.JTable();
        cmbDocumentos = new javax.swing.JComboBox<>();
        jSpinner1 = new javax.swing.JSpinner();
        btnVolver = new javax.swing.JLabel();
        btnAdd = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JLabel();
        btnGenerar = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(" Generar Acta de Compromiso");

        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanel1.setMinimumSize(new java.awt.Dimension(690, 505));
        jPanel1.setPreferredSize(new java.awt.Dimension(690, 505));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigo.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtCodigoCaretUpdate(evt);
            }
        });
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 180, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Codigo de Alumno:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, 32));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información del Alumno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nombres del Alumno :");

        txtNombre.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        txtNombre.setEnabled(false);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Apellidos del Alumno :");

        txtApellido.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        txtApellido.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                    .addComponent(txtNombre))
                .addGap(56, 56, 56))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 640, 140));

        tblactas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre del documento", "Ruta", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblactas);
        if (tblactas.getColumnModel().getColumnCount() > 0) {
            tblactas.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 640, 100));

        jPanel1.add(cmbDocumentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 270, 30));
        jPanel1.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 170, 30));

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Generar Acta/Volver-Buttom.png"))); // NOI18N
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Generar Acta/SubirdDoc-Buttom.png"))); // NOI18N
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, -1, -1));

        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Generar Acta/Mostrar-Buttom.png"))); // NOI18N
        btnConsultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConsultarMouseClicked(evt);
            }
        });
        jPanel1.add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, -1, -1));

        btnGenerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Generar Acta/Generar-Buttom.png"))); // NOI18N
        btnGenerar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGenerarMouseClicked(evt);
            }
        });
        jPanel1.add(btnGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 460, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Generar Acta/GenerarActa-Panel.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -5, 690, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVolverMouseClicked

    private void btnConsultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarMouseClicked
        // TODO add your handling code here:
        aluSelect = alumnoLN.buscarAlumno(txtCodigo.getText());
        if (aluSelect != null) {
            txtNombre.setText(aluSelect.getNombreAlu());
            txtApellido.setText(aluSelect.getaPaternoAlu() + " " + aluSelect.getaMaternoAlu());
        } else {
            JOptionPane.showMessageDialog(rootPane, "No existe el alumno con DNI = " + txtCodigo.getText(), "Alumno no encontrado", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConsultarMouseClicked

    private void txtCodigoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtCodigoCaretUpdate
        // TODO add your handling code herrrre:
    }//GEN-LAST:event_txtCodigoCaretUpdate

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        Documentos docSelect = (Documentos) cmbDocumentos.getSelectedItem();
        System.out.println(docSelect);
        if (!lDocs.contains(docSelect)) {
            lDocs.add(docSelect);
            agregarTabla(docSelect);
        }
    }//GEN-LAST:event_btnAddMouseClicked

    private void configurarSpinners(JSpinner timeSpinner, String dateFormat) {
        timeSpinner.setModel(new SpinnerDateModel());
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, dateFormat);
        timeSpinner.setEditor(timeEditor);
        timeSpinner.setValue(new Date()); // will only show the current time
    }
    private void btnGenerarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarMouseClicked

        if (aluSelect != null) {
            int codUsuario = usuarioLN.buscarUsuario(Credencial.getInstance().getUsername()).getCodUsuario();
            String msj = "";
            for (Documentos docs : lDocs) {
                Acta nuevaActa = new Acta();
                nuevaActa.setCodAlu(aluSelect.getCodAlu());
                nuevaActa.setCodDocumento(docs.getCodDocumento());
                nuevaActa.setCodUsuario(codUsuario);
                nuevaActa.setFechaEntrega((Date) jSpinner1.getValue());
                msj += actaLN.registrarActa(nuevaActa) + "\ns";
            }

            JOptionPane.showMessageDialog(rootPane, msj);

            //generar pdf
            // el de matricula bbita :*
            try {
                crearPdf(new File("C:\\Users\\lucho\\Documents\\Ing. de Sistemas\\Comprobantes\\AC_" + aluSelect.getCodAlu() + ".pdf"));
            } catch (IOException ex) {
                System.out.println(ex);
            }
            //levantar pdf
            try {
                File path = new File("C:\\Users\\lucho\\Documents\\Ing. de Sistemas\\Comprobantes\\AC_" + aluSelect.getCodAlu() + ".pdf");
                Desktop.getDesktop().open(path);
            } catch (Exception ex) {
                System.out.println(ex);
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "No ha buscado un alumno", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGenerarMouseClicked

    private void agregarTabla(Documentos doc) {
        Object[] rowData = new Object[3];
        rowData[0] = doc.getCodDocumento();
        rowData[1] = doc.getDescripcionDoc();
        rowData[2] = doc.getGradoImportancia();
        modelo.addRow(rowData);
        tblactas.setModel(modelo);
    }

    private void llenarCombos() {
        documentoLN.listaActas().forEach((item) -> cmbDocumentos.addItem(item));
    }

    public void crearPdf(File nuevoPdf) throws IOException {

        try {
            Document documento = new Document(PageSize.A5.rotate());

            try {
                PdfWriter.getInstance(documento, new FileOutputStream(nuevoPdf)).setInitialLeading(20);
            } catch (FileNotFoundException ex) {
                System.out.println("error 1 " + ex);
            }
            documento.open();

            //añadiendo metadatos
            //añadiendo contenido al pdf
            Image image = null;
            try {
                image = Image.getInstance(LOGO_COLE);
                //  image.setAbsolutePosition(30, 560);
                image.scaleAbsoluteWidth(60f);
                image.scaleAbsoluteHeight(60f);

            } catch (BadElementException ex) {
                System.out.println("error al cargar la imagen" + ex);
            }
            documento.add(image);

            documento.add(new Paragraph("\n\n Acta de Compromiso - I.E.P VIRGEN MILAGROSA ", FontFactory.getFont("Arial", 18, Font.BOLD)));
            documento.add(new Paragraph("Código : " + aluSelect.getCodAlu(), FontFactory.getFont("Arial", 14, Font.BOLD)));
            documento.add(new Paragraph("Nombres y Apellidos: " + aluSelect.getNombreAlu() + " " + aluSelect.getaPaternoAlu() + " " + aluSelect.getaMaternoAlu(), FontFactory.getFont("Arial", 14, Font.BOLD)));
            documento.add(new Paragraph("Usuario: " + Credencial.getInstance().getUsername(), FontFactory.getFont("Arial", 14, Font.BOLD)));
            documento.add(new Paragraph("Docuementos", FontFactory.getFont("Arial", 14, Font.BOLD)));

            for (Documentos lDoc : lDocs) {
                documento.add(new Paragraph("\t- " + lDoc, FontFactory.getFont("Arial", 12, Font.PLAIN)));
            }

            documento.close();
            
            System.out.println("Archivo generado correctamente");

        } catch (DocumentException ex) {
            System.out.println("error2 " + ex);
            JOptionPane.showMessageDialog(null, "No se puede abrir el archivo, probablemente fue borrado", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAdd;
    private javax.swing.JLabel btnConsultar;
    private javax.swing.JLabel btnGenerar;
    private javax.swing.JLabel btnVolver;
    private javax.swing.JComboBox<Documentos> cmbDocumentos;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable tblactas;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
