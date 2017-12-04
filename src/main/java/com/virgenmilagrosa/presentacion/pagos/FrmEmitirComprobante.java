/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virgenmilagrosa.presentacion.pagos;

import com.virgenmilagrosa.logicanegocio.gestionalumnos.Alumno_LN;
import com.virgenmilagrosa.logicanegocio.gestionalumnos.Apoderado_LN;
import com.virgenmilagrosa.logicanegocio.pagos.ComprobantePago_LN;
import com.virgenmilagrosa.tranversal.entidades.Alumnos;
import com.virgenmilagrosa.tranversal.entidades.Apoderado;
import com.virgenmilagrosa.tranversal.entidades.Comprobante;
import com.virgenmilagrosa.tranversal.entidades.Matricula;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import com.virgenmilagrosa.GestionMatriculaConfig;

import java.awt.Font;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

import java.io.FileOutputStream;

/**
 *
 * @author lucho
 */
public class FrmEmitirComprobante extends javax.swing.JFrame {

    private Matricula matricula;
    private Comprobante comprobante;
    private Alumnos alumno;
    private Apoderado apoderado;
    private ComprobantePago_LN comprobanteLN = ComprobantePago_LN.getInstance();
    private Alumno_LN alumnoLN = Alumno_LN.getInstance();
    private Apoderado_LN apoderadoLN = Apoderado_LN.getInstance();
    private static final SimpleDateFormat FORMATO = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
    private static final String LOGO_COLE = "logovm.jpg";

    public FrmEmitirComprobante(Matricula matricula) {
        this.matricula = matricula;
        initComponents();
        MetodoInicio();
    }

    private void MetodoInicio() {

        setLocationRelativeTo(null);
        GestionMatriculaConfig.icon(this);
        int monto = 120;

        comprobante = new Comprobante();

        comprobante.setMonto(monto);
        comprobante.setCodAlu(matricula.getCodAlu());
        comprobante.setCodGrado(matricula.getCodGrado());
        comprobante.setCodSeccion(matricula.getCodSeccion());

        int codComprobante = comprobanteLN.registrarComprobante(comprobante);

        comprobante = comprobanteLN.buscarComprobante(codComprobante);

        if (comprobante != null) {

            // Estos dos objetos bb :3
            alumno = alumnoLN.buscarAlumno(comprobante.getCodAlu());

            apoderado = apoderadoLN.buscarApoderado(alumno.getCodApoderado());

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
                        + "FECHA: %s		   TOTAL:S./%.2f ";

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

            documento.add(new Paragraph("\n\n COMPROBANTE DE MATRICULA - I.E.P VIRGEN MILAGROSA ", FontFactory.getFont("Arial", 18, Font.BOLD)));
            documento.add(new Paragraph("CÓDIGO : " + alumno.getCodAlu(), FontFactory.getFont("Arial", 14, Font.BOLD)));
            documento.add(new Paragraph("NOMBRES Y APELLIDOS : " + alumno.getNombreAlu() + " "
                    + alumno.getaPaternoAlu() + " "
                    + alumno.getaMaternoAlu() + " ",
                    FontFactory.getFont("Arial", 14, Font.BOLD)));
            documento.add(new Paragraph("APODERADO : " + apoderado.getNombreAp() + " "
                    + apoderado.getaPaternoAp() + " "
                    + apoderado.getaMaternoAp() + " "
                    + "     DNI : " + apoderado.getDniAp(),
                    FontFactory.getFont("Arial", 14, Font.BOLD)));

            /*
             documento.add(new Paragraph("texto con estilo :c ",
             FontFactory.getFont("arial", // fuente
             22, // tamaño
             Font.ITALIC, // estilo
             BaseColor.CYAN))); // color
             */
            documento.addAuthor("guis");  //no sé donde se ve xd

            documento.add(new Paragraph("\n"));
            PdfPTable tabla1 = new PdfPTable(3);
            tabla1.addCell("CONCEPTO");
            tabla1.addCell("DETALLE");
            tabla1.addCell("MONTO");

            PdfPTable tabla2 = new PdfPTable(3);
            tabla1.addCell("01");
            tabla1.addCell("Matricula");
            tabla1.addCell("" + comprobante.getMonto());

            PdfPTable tabla3 = new PdfPTable(3);
            tabla1.addCell("Fecha: " + FORMATO.format(comprobante.getFechaEmision()));
            tabla1.addCell("");
            tabla1.addCell("Total: " + comprobante.getMonto());

            // } No sé como llenar los datos y me sale error en el prier metodo el que esta comentado :c
            documento.add(tabla1);
            documento.add(tabla2);
            documento.add(tabla3);
            documento.close();
            System.out.println("Archivo generado correctamente");

        } catch (DocumentException ex) {
            System.out.println("error2 " + ex);
            JOptionPane.showMessageDialog(null, "No se puede abrir el archivo, probablemente fue borrado", "ERROR", JOptionPane.ERROR_MESSAGE);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaComprobante = new javax.swing.JTextArea();
        btnImprimir = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Emitit Comprobante");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAreaComprobante.setColumns(20);
        txtAreaComprobante.setRows(5);
        txtAreaComprobante.setText("########### INSTITUCION EDUCATIVA VIRGEN MILAGROSA ############\nCODIGO: 15200138\nAPELLIDOS Y NOMBRES: PALPAN FLORES, YUDELY GUADALUPE\nAPODERADO: CHAVEZ ALIAGA, LUIS RICARDO     DNI: 73332125\n\nCONCEPTO  | DETALLE                      | MONTO\n---------------------------------------------------------------\n\n\n\n---------------------------------------------------------------\nFECHA: 16/10/2017\t\t          TOTAL: S/.   ");
        txtAreaComprobante.setEnabled(false);
        jScrollPane1.setViewportView(txtAreaComprobante);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 610, 300));

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Emitir Comprobante/ImprimirComp-Buttom.png"))); // NOI18N
        btnImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImprimirMouseClicked(evt);
            }
        });
        jPanel1.add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Emitir Comprobante/Volver-Buttom.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Emitir Comprobante/EmitirComp-Panel.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void btnImprimirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImprimirMouseClicked
        //generar pdf
        // el de matricula bbita :*
        try {
            crearPdf(new File("C:\\Users\\lucho\\Documents\\Ing. de Sistemas\\Comprobantes\\C_" + matricula.getCodMatricula() + ".pdf"));
        } catch (IOException ex) {
            System.out.println(ex);
        }
        //levantar pdf
        try {
            File path = new File("C:\\Users\\lucho\\Documents\\Ing. de Sistemas\\Comprobantes\\C_" + matricula.getCodMatricula() + ".pdf");
            Desktop.getDesktop().open(path);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnImprimirMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnImprimir;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAreaComprobante;
    // End of variables declaration//GEN-END:variables
}
