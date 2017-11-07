/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virgenmilagrosa.presentacion.gestionalumnos;

import com.virgenmilagrosa.logicanegocio.gestionalumnos.*;
import com.virgenmilagrosa.tranversal.control.Validaciones;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.virgenmilagrosa.tranversal.entidades.*;
/**
 *
 * @author lucho
 */
public class FrmModificarAlumno extends javax.swing.JFrame {

    /**
     * Creates new form FrmModificarInformación
     * @param alumno
     */
    public FrmModificarAlumno(Alumnos alumno) {
        initComponents();
        MetodoInicio();
        this.alumno = alumno;
        llenarDatos(alumno);
    }
    
    private Alumnos alumno;
    private Apoderado apoderado;
    private Seccion seccion;
    
    
    public void MetodoInicio() {
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbxLugar = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        spnFecha = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNomApod = new javax.swing.JTextField();
        txtApellApod = new javax.swing.JTextField();
        txtDNIApod = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        spnFechaApod = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtCorreoApod = new javax.swing.JTextField();
        txtTelefonoApod = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtOcupApod = new javax.swing.JTextField();
        btnVolver = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Modificar Información");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de alumnos"));

        jLabel2.setText("Nombres del Alumno");

        txtNombre.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNombreCaretUpdate(evt);
            }
        });

        jLabel3.setText("Apellidos del Alumno");

        txtApellido.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtApellidoCaretUpdate(evt);
            }
        });

        jLabel4.setText("DNI del Alumno");

        txtDNI.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtDNICaretUpdate(evt);
            }
        });

        jLabel5.setText("Lugar de Nacimiento");

        cbxLugar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione Lugar --", "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxLugar.setToolTipText("");

        jLabel6.setText("Fecha de Nacimiento");

        jLabel13.setText("Correo Electronico");

        txtCorreo.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtCorreoCaretUpdate(evt);
            }
        });

        jLabel14.setText("Telefono");

        txtTelefono.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTelefonoCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDNI, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbxLugar, 0, 506, Short.MAX_VALUE)
                    .addComponent(spnFecha)
                    .addComponent(txtApellido)
                    .addComponent(txtNombre)
                    .addComponent(txtCorreo)
                    .addComponent(txtTelefono))
                .addGap(48, 48, 48))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtApellido)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDNI)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spnFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTelefono))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de apoderado"));

        jLabel7.setText("Nombres del Apoderado");

        jLabel8.setText("Apellidos del Apoderado");

        jLabel9.setText("DNI del Apoderado");

        txtNomApod.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNomApodCaretUpdate(evt);
            }
        });

        txtApellApod.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtApellApodCaretUpdate(evt);
            }
        });

        txtDNIApod.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtDNIApodCaretUpdate(evt);
            }
        });

        jLabel15.setText("Fecha de Nacimiento");

        jLabel16.setText("Correo Electronico");

        jLabel17.setText("Telefono");

        txtCorreoApod.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtCorreoApodCaretUpdate(evt);
            }
        });

        txtTelefonoApod.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTelefonoApodCaretUpdate(evt);
            }
        });

        jLabel18.setText("Ocupacion");

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
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtApellApod, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                    .addComponent(txtNomApod, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                    .addComponent(txtDNIApod, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                    .addComponent(spnFechaApod)
                    .addComponent(txtCorreoApod)
                    .addComponent(txtTelefonoApod)
                    .addComponent(txtOcupApod))
                .addGap(43, 43, 43))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomApod))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellApod))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDNIApod))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(spnFechaApod))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreoApod))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtTelefonoApod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOcupApod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)))
        );

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar Cambios");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(btnGuardar))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void ValidarIngreso() {
        String nombre = txtNombre.getText().trim();
        String apellidos = txtApellido.getText().trim();
        String dni = txtDNI.getText().trim();
        int Dni = dni.length();
        String fechanac = spnFecha.getValue().toString();
        String lugar = cbxLugar.getSelectedItem().toString();
        String correo = txtCorreo.getText().trim();
        boolean estado = Validarformatocorreo(correo);
        String telf = txtTelefono.getText().trim();
        int telef = telf.length();

        String nombapod = txtNomApod.getText().trim();
        String apellapod = txtApellApod.getText().trim();
        String dniapod = txtDNIApod.getText().trim();
        String telfapod = txtTelefonoApod.getText().trim();
        String fechanacapod = spnFechaApod.getValue().toString();
        int tlfapod = telfapod.length();
        String correoapod = txtCorreoApod.getText().trim();
        boolean estcorreoapod = Validarformatocorreo(correoapod);
        String ocup = txtOcupApod.getText().trim();

        if (nombre.isEmpty() || apellidos.isEmpty() || Dni != 8 || fechanac.isEmpty() || lugar.isEmpty()
                || nombapod.isEmpty() || apellapod.isEmpty() || dniapod.isEmpty() || tlfapod != 9 || estcorreoapod == false
                || ocup.isEmpty()  || estado == false || telef != 9) {
            btnGuardar.setEnabled(false);
        } else {
            btnGuardar.setEnabled(true);
        }
    }

    public boolean Validarformatocorreo(String correo) {
        Pattern pat;
        Matcher mat;
        
        //formato del correo electronico
        pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        mat = pat.matcher(correo);

        return mat.find();
    }
    
    public void llenarDatos(Alumnos alumno)
    {
        txtNombre.setText(alumno.getNombreAlu());
        txtApellido.setText(alumno.getaPaternoAlu() + alumno.getaMaternoAlu());
        txtDNI.setText("Aun no tiene DNI");
        txtCorreo.setText(alumno.getEmailAlu());
        txtTelefono.setText(alumno.getTelefonoAlu());
        
        apoderado = Apoderado_LN.getInstance().buscarApoderado(alumno.getCodApoderado());
        
        txtNomApod.setText(apoderado.getNombreAp());
        txtApellApod.setText(apoderado.getaPaternoAp() + apoderado.getaMaternoAp());
        txtDNIApod.setText(apoderado.getDniAp());
        txtCorreoApod.setText(apoderado.getEmailAp());
        txtTelefonoApod.setText(apoderado.getTelefonoAp());
        txtOcupApod.setText(apoderado.getOcupacion());
    
    }
    
    public void actualizarDatos()
    {
        String[] apellidos;
        
        alumno.setNombreAlu(txtNombre.getText());
        apellidos = txtApellido.getText().split(" ");
        alumno.setaPaternoAlu(apellidos[0]);
        alumno.setaMaternoAlu(apellidos[1]);
        alumno.setDireccionAlu("");
        alumno.setEmailAlu(txtCorreo.getText());
        alumno.setTelefonoAlu(txtTelefono.getText());
        
        apoderado.setNombreAp(txtNomApod.getText());
        apellidos = txtApellApod.getText().split(" ");
        apoderado.setaPaternoAp(apellidos[0]);
        apoderado.setaMaternoAp(apellidos[1]);
        apoderado.setDniAp(txtDNIApod.getText());
        apoderado.setEmailAp(txtCorreoApod.getText());
        apoderado.setTelefonoAp(txtTelefonoApod.getText());
        apoderado.setOcupacion(txtOcupApod.getText());
        
    }

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        actualizarDatos();
        Alumno_LN.getInstance().modificarAlumno(alumno);
        Apoderado_LN.getInstance().modificarApoderado(apoderado);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtNombreCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNombreCaretUpdate
        // TODO add your handling code here:
        this.ValidarIngreso();
    }//GEN-LAST:event_txtNombreCaretUpdate

    private void txtApellidoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtApellidoCaretUpdate
        // TODO add your handling code here:
        this.ValidarIngreso();
    }//GEN-LAST:event_txtApellidoCaretUpdate

    private void txtDNICaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtDNICaretUpdate
        // TODO add your handling code here:
        this.ValidarIngreso();
    }//GEN-LAST:event_txtDNICaretUpdate

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

    private void txtCorreoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtCorreoCaretUpdate
        // TODO add your handling code here:
        this.ValidarIngreso();
    }//GEN-LAST:event_txtCorreoCaretUpdate

    private void txtTelefonoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTelefonoCaretUpdate
        // TODO add your handling code here:
        this.ValidarIngreso();
    }//GEN-LAST:event_txtTelefonoCaretUpdate

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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cbxLugar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JSpinner spnFecha;
    private javax.swing.JSpinner spnFechaApod;
    private javax.swing.JTextField txtApellApod;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtCorreoApod;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDNIApod;
    private javax.swing.JTextField txtNomApod;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtOcupApod;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefonoApod;
    // End of variables declaration//GEN-END:variables
}
