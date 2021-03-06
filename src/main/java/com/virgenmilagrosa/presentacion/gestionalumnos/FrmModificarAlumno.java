/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virgenmilagrosa.presentacion.gestionalumnos;

import com.virgenmilagrosa.GestionMatriculaConfig;
import com.virgenmilagrosa.logicanegocio.gestionalumnos.*;
import com.virgenmilagrosa.presentacion.FrmInterfazPrincipal;
import com.virgenmilagrosa.tranversal.control.Validaciones;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.virgenmilagrosa.tranversal.entidades.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author Lupita
 */
public class FrmModificarAlumno extends javax.swing.JFrame {

    /**
     * Creates new form FrmModificarInformación
     */
    private final static SimpleDateFormat FORMATO = new SimpleDateFormat("dd/MM/yy");

    private FrmInterfazPrincipal interfazP;
    private Alumnos alumno;
    private Apoderado apoderado;

    public FrmModificarAlumno(FrmInterfazPrincipal interfazP, Alumnos alumno) {
        initComponents();
        MetodoInicio();
        this.interfazP = interfazP;
        this.alumno = alumno;
        llenarDatos(alumno);
    }

    private void MetodoInicio() {
        Validaciones v = new Validaciones();
        v.LimitarCaracter(txtNombre, 30);
        v.ValidarSoloLetras(txtNombre);
        v.LimitarCaracter(txtApellido, 30);
        v.ValidarSoloLetras(txtApellido);
        v.LimitarCaracter(txtDNI, 8);
        v.ValidarSoloNumeros(txtDNI);
        v.LimitarCaracter(txtNomApod, 30);
        v.ValidarSoloLetras(txtNomApod);
        v.LimitarCaracter(txtApellApod, 30);
        v.ValidarSoloLetras(txtApellApod);
        v.LimitarCaracter(txtDNIApod, 8);
        v.ValidarSoloNumeros(txtDNIApod);
        v.LimitarCaracter(txtTelefono, 9);
        v.ValidarSoloNumeros(txtTelefono);
        v.LimitarCaracter(txtTelefonoApod, 9);
        v.ValidarSoloNumeros(txtTelefonoApod);
        v.ValidarSoloLetras(txtOcupApod);
        configurarSpinners(spnFechaAlu, "dd/MM/yy");
        GestionMatriculaConfig.icon(this);
        llenarCombo();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbxDistrito = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        spnFechaAlu = new javax.swing.JSpinner();
        jLabel15 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNomApod = new javax.swing.JTextField();
        txtApellApod = new javax.swing.JTextField();
        txtDNIApod = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtCorreoApod = new javax.swing.JTextField();
        txtTelefonoApod = new javax.swing.JTextField();
        txtOcupApod = new javax.swing.JTextField();
        btnVolver = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificar Alumno");
        setBackground(new java.awt.Color(102, 102, 255));

        jPanel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información del alumno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Nombres del Alumno");

        txtNombre.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        txtNombre.setEnabled(false);
        txtNombre.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNombreCaretUpdate(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("Apellidos del Alumno");

        txtApellido.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        txtApellido.setEnabled(false);
        txtApellido.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtApellidoCaretUpdate(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("DNI del Alumno");

        txtDNI.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        txtDNI.setEnabled(false);
        txtDNI.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtDNICaretUpdate(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setText("Distrito");

        cbxDistrito.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cbxDistrito.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel6.setText("Fecha de Nacimiento");

        spnFechaAlu.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        spnFechaAlu.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel15.setText("Correo Electronico");

        txtCorreo.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        txtCorreo.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtCorreoCaretUpdate(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel16.setText("Telefono");

        txtTelefono.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        txtTelefono.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTelefonoCaretUpdate(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel17.setText("Direccion");

        txtDireccion.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        txtDireccion.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtDireccionCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbxDistrito, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDNI, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnFechaAlu, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnFechaAlu, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 680, 210));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información del apoderado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel3.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel7.setText("Nombres del Apoderado");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel8.setText("Apellidos del Apoderado");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel9.setText("DNI del Apoderado");

        txtNomApod.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtNomApod.setEnabled(false);
        txtNomApod.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNomApodCaretUpdate(evt);
            }
        });

        txtApellApod.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtApellApod.setEnabled(false);
        txtApellApod.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtApellApodCaretUpdate(evt);
            }
        });

        txtDNIApod.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtDNIApod.setEnabled(false);
        txtDNIApod.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtDNIApodCaretUpdate(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel18.setText("Correo Electronico");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel19.setText("Telefono");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel20.setText("Ocupacion");

        txtCorreoApod.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtCorreoApod.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtCorreoApodCaretUpdate(evt);
            }
        });

        txtTelefonoApod.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtTelefonoApod.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTelefonoApodCaretUpdate(evt);
            }
        });

        txtOcupApod.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtOcupApod.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtOcupApodCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDNIApod, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefonoApod, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtOcupApod, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCorreoApod, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNomApod, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtApellApod, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(199, 523, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomApod, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellApod, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDNIApod, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTelefonoApod, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreoApod))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOcupApod, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 680, 200));

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modificar-Alumno/Volver-Buttom.png"))); // NOI18N
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modificar-Alumno/ModificarInfo-Panel.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modificar-Alumno/Cancelar-Buttom.png"))); // NOI18N
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modificar-Alumno/GuardarC-Buttom.png"))); // NOI18N
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(117, 117, 117))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ValidarIngreso() {
        String nombre = txtNombre.getText().trim();
        String apellidos = txtApellido.getText().trim();
        String dni = txtDNI.getText().trim();
        int Dni = dni.length();
        String fechanac = spnFechaAlu.getValue().toString();
        String lugar = cbxDistrito.getSelectedItem().toString();
        String correo = txtCorreo.getText().trim();

        String telf = txtTelefono.getText().trim();
        int telef = telf.length();

        String nombapod = txtNomApod.getText().trim();
        String apellapod = txtApellApod.getText().trim();
        String dniapod = txtDNIApod.getText().trim();
        String telfapod = txtTelefonoApod.getText().trim();
        int tlfapod = telfapod.length();
        String correoapod = txtCorreoApod.getText().trim();
        boolean estcorreoapod = Validarformatocorreo(correoapod);
        String ocup = txtOcupApod.getText().trim();

        if (nombre.isEmpty() || apellidos.isEmpty() || Dni != 8 || fechanac.isEmpty() || lugar.isEmpty()
                || nombapod.isEmpty() || apellapod.isEmpty() || dniapod.isEmpty() || tlfapod != 9
                || estcorreoapod == false
                || ocup.isEmpty()
                || telef != 9) {
            btnGuardar.setEnabled(false);
        } else {
            btnGuardar.setEnabled(true);
        }
    }

    private boolean Validarformatocorreo(String correo) {
        //formato del correo electronico
        Pattern pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        Matcher mat = pat.matcher(correo);

        return mat.find();
    }

    private void llenarDatos(Alumnos alumno) {
        int selectItem = buscarItem(alumno.getCodDistrito());
        if (selectItem != -1) {
            try {
                txtNombre.setText(alumno.getNombreAlu());
                txtApellido.setText(alumno.getaPaternoAlu() + " " + alumno.getaMaternoAlu());
                txtDNI.setText(alumno.getDniAlumno());
                txtCorreo.setText(alumno.getEmailAlu());
                txtTelefono.setText(alumno.getTelefonoAlu());
                txtDireccion.setText(alumno.getDireccionAlu());
                spnFechaAlu.setValue(FORMATO.parse(alumno.getFechaNac()));
                cbxDistrito.setSelectedIndex(selectItem);

                apoderado = Apoderado_LN.getInstance().buscarApoderado(alumno.getCodApoderado());

                txtNomApod.setText(apoderado.getNombreAp());
                txtApellApod.setText(apoderado.getaPaternoAp() + " " + apoderado.getaMaternoAp());
                txtDNIApod.setText(apoderado.getDniAp());
                txtCorreoApod.setText(apoderado.getEmailAp());
                txtTelefonoApod.setText(apoderado.getTelefonoAp());
                txtOcupApod.setText(apoderado.getOcupacion());
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    private int buscarItem(int codDistrito) {
        for (int i = 0; i < cbxDistrito.getItemCount(); i++) {
            Distrito dist = (Distrito) cbxDistrito.getItemAt(i);
            if (dist.getCodDistrito() == codDistrito) {
                return i;
            }
        }

        return -1;
    }

    public void actualizarDatos() {
        Distrito dist = (Distrito) cbxDistrito.getSelectedItem();

        alumno.setDireccionAlu(txtDireccion.getText());
        alumno.setEmailAlu(txtCorreo.getText());
        alumno.setTelefonoAlu(txtTelefono.getText());
        alumno.setCodDistrito(dist.getCodDistrito());
        
        apoderado.setEmailAp(txtCorreoApod.getText());
        apoderado.setTelefonoAp(txtTelefonoApod.getText());
        apoderado.setOcupacion(txtOcupApod.getText());
       

    }

    private void txtNomApodCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNomApodCaretUpdate
        // TODO add your handling code here:
        this.ValidarIngreso();
    }//GEN-LAST:event_txtNomApodCaretUpdate

    private void txtApellApodCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtApellApodCaretUpdate
        // TODO add your handling code here:
        this.ValidarIngreso();
    }//GEN-LAST:event_txtApellApodCaretUpdate

    private void txtDNIApodCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtDNIApodCaretUpdate
        // TODO add your handling code here:
        this.ValidarIngreso();
    }//GEN-LAST:event_txtDNIApodCaretUpdate

    private void btnVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseClicked
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_btnVolverMouseClicked

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        // TODO add your handling code here:
        actualizarDatos();

        String respuestaAlumno = Alumno_LN.getInstance().modificarAlumno(alumno);
        JOptionPane.showMessageDialog(null, respuestaAlumno, "Actualizacion", JOptionPane.INFORMATION_MESSAGE);

        String respuestaApoderado = Apoderado_LN.getInstance().modificarApoderado(apoderado);
        JOptionPane.showMessageDialog(null, respuestaApoderado, "Actualizacion", JOptionPane.INFORMATION_MESSAGE);

        interfazP.actualizarTablaAlumnos();
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void txtCorreoApodCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtCorreoApodCaretUpdate
        // TODO add your handling code here:
        this.ValidarIngreso();
    }//GEN-LAST:event_txtCorreoApodCaretUpdate

    private void txtTelefonoApodCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTelefonoApodCaretUpdate
        // TODO add your handling code here:
        this.ValidarIngreso();
    }//GEN-LAST:event_txtTelefonoApodCaretUpdate

    private void txtOcupApodCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtOcupApodCaretUpdate
        // TODO add your handling code here:
        this.ValidarIngreso();
    }//GEN-LAST:event_txtOcupApodCaretUpdate

    private void txtTelefonoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTelefonoCaretUpdate
        // TODO add your handling code here:
        this.ValidarIngreso();
    }//GEN-LAST:event_txtTelefonoCaretUpdate

    private void txtCorreoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtCorreoCaretUpdate
        // TODO add your handling code here:
        this.ValidarIngreso();
    }//GEN-LAST:event_txtCorreoCaretUpdate

    private void txtDNICaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtDNICaretUpdate
        // TODO add your handling code here:
        this.ValidarIngreso();
    }//GEN-LAST:event_txtDNICaretUpdate

    private void txtApellidoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtApellidoCaretUpdate
        // TODO add your handling code here:
        this.ValidarIngreso();
    }//GEN-LAST:event_txtApellidoCaretUpdate

    private void txtNombreCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNombreCaretUpdate
        // TODO add your handling code here:
        this.ValidarIngreso();
    }//GEN-LAST:event_txtNombreCaretUpdate

    private void txtDireccionCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtDireccionCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionCaretUpdate

    private void configurarSpinners(JSpinner timeSpinner, String dateFormat) {
        timeSpinner.setModel(new SpinnerDateModel());
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, dateFormat);
        timeSpinner.setEditor(timeEditor);
        timeSpinner.setValue(new Date()); // will only show the current time
    }

    private void llenarCombo() {
        List<Distrito> listaDistritos = Distrito_LN.getInstance().listarDistritos();
        listaDistritos.forEach((item) -> cbxDistrito.addItem(item));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCancelar;
    private javax.swing.JLabel btnGuardar;
    private javax.swing.JLabel btnVolver;
    private javax.swing.JComboBox<Distrito> cbxDistrito;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSpinner spnFechaAlu;
    private javax.swing.JTextField txtApellApod;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtCorreoApod;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDNIApod;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNomApod;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtOcupApod;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefonoApod;
    // End of variables declaration//GEN-END:variables
}
