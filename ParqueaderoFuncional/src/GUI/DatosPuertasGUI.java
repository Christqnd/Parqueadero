/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import MODELO.Portero;
import SERVICIO.ApellidoInvalidoException;
import SERVICIO.CedulaInvalidaException;
import SERVICIO.CodigoInvalidoException;
import SERVICIO.CodigosSERVICIO;
import SERVICIO.NombreIvalidoException;
import SERVICIO.NumeroPuertaInvalidoException;
import SERVICIO.PorteroSERVICIO;
import SERVICIO.PuertaInvalidaException;
import SERVICIO.PuertasSERVICIO;
import SERVICIO.UbicacionInvalidoException;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

/**
 *
 * @author gube
 */
public class DatosPuertasGUI extends javax.swing.JFrame {

    PuertasSERVICIO ps = PuertasSERVICIO.getInstancia();
    PorteroSERVICIO pos = new PorteroSERVICIO();

    /**
     * Creates new form DatosPuertasGUI
     */
    public DatosPuertasGUI() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/IMG/parking.png")).getImage());
        if (!ps.isModificar()) {
            this.codigopuertalbl.setText(CodigosSERVICIO.getInstancia().generarCodigo("PU"));
            this.EntradaRB.setSelected(true);
            this.checkportero.setSelected(false);
//            this.activarportero(false);
        } else {
            this.codigopuertalbl.setText(ps.getPuerta().getIdPuerta().toString());
            this.ubicaciontxt.setText(ps.getPuerta().getDescripcion());
            String estado = ps.getPuerta().getTipo();
            if (estado.equalsIgnoreCase("entrada")) {
                this.EntradaRB.setSelected(true);
                this.SalidaRB.setSelected(false);
                this.ESRB.setSelected(false);
            } else if (estado.equalsIgnoreCase("salida")) {
                this.EntradaRB.setSelected(false);
                this.SalidaRB.setSelected(true);
                this.ESRB.setSelected(false);
            } else if (estado.equalsIgnoreCase("entrada/salida")) {
                this.EntradaRB.setSelected(false);
                this.SalidaRB.setSelected(false);
                this.ESRB.setSelected(true);
            }
//            if (ps.getPuerta().getPortero() != null) {
//                this.checkportero.setSelected(true);
//                this.activarportero(true);
//                this.cargarPortero(ps.getPuerta().getPortero());
//            } else {
                this.checkportero.setSelected(false);
//                this.activarportero(false);
//            }
        }
    }

//    public void activarportero(boolean b) {
//        this.nombrelbl.setEnabled(b);
//        this.apellidolbl.setEnabled(b);
//        this.cedulalbl.setEnabled(b);
//        this.nombreTXT.setEnabled(b);
//        this.ApellidoTXT.setEnabled(b);
//        this.cedulaTXT.setEnabled(b);
//
//    }
//    private void cargarPortero(Portero p) {
//        this.nombreTXT.setText(p.getPrimerNombre());
//        this.ApellidoTXT.setText(p.getPrimerApellido());
//        this.cedulaTXT.setText(p.getCedula());
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        codigopuertalbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ubicaciontxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        EntradaRB = new javax.swing.JRadioButton();
        SalidaRB = new javax.swing.JRadioButton();
        ESRB = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        checkportero = new javax.swing.JCheckBox();
        nombrelbl = new javax.swing.JLabel();
        nombreTXT = new javax.swing.JTextField();
        apellidolbl = new javax.swing.JLabel();
        ApellidoTXT = new javax.swing.JTextField();
        cedulalbl = new javax.swing.JLabel();
        cedulaTXT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(335, 490));
        setSize(new java.awt.Dimension(335, 490));
        getContentPane().setLayout(null);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(10, 118, 296, 10);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(10, 270, 296, 10);

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(210, 420, 76, 22);

        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(140, 420, 72, 22);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.setOpaque(false);

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ubicacion:");
        jLabel3.setOpaque(true);

        codigopuertalbl.setBackground(new java.awt.Color(204, 204, 204));
        codigopuertalbl.setForeground(new java.awt.Color(255, 255, 255));
        codigopuertalbl.setText("Pue001");

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nueva Puerta");
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Codigo:");
        jLabel2.setOpaque(true);

        ubicaciontxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ubicaciontxtMouseClicked(evt);
            }
        });
        ubicaciontxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubicaciontxtActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText(" Ejm: Ave 12 de abril");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ubicaciontxt, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codigopuertalbl, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(codigopuertalbl))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addComponent(ubicaciontxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 300, 100);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel2.setOpaque(false);

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Tipo:");
        jLabel4.setOpaque(true);

        EntradaRB.setForeground(new java.awt.Color(255, 255, 255));
        EntradaRB.setText("Entrada");
        EntradaRB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                EntradaRBItemStateChanged(evt);
            }
        });
        EntradaRB.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                EntradaRBStateChanged(evt);
            }
        });
        EntradaRB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EntradaRBMouseClicked(evt);
            }
        });
        EntradaRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntradaRBActionPerformed(evt);
            }
        });

        SalidaRB.setForeground(new java.awt.Color(255, 255, 255));
        SalidaRB.setText("Salida");
        SalidaRB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SalidaRBItemStateChanged(evt);
            }
        });
        SalidaRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalidaRBActionPerformed(evt);
            }
        });

        ESRB.setForeground(new java.awt.Color(255, 255, 255));
        ESRB.setText("Entrada / Salida");
        ESRB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ESRBItemStateChanged(evt);
            }
        });
        ESRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ESRBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ESRB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EntradaRB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SalidaRB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(97, 97, 97))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EntradaRB)
                .addGap(6, 6, 6)
                .addComponent(SalidaRB)
                .addGap(7, 7, 7)
                .addComponent(ESRB)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 130, 300, 130);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel3.setOpaque(false);

        checkportero.setBackground(new java.awt.Color(204, 204, 204));
        checkportero.setText("Portero");
        checkportero.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkporteroItemStateChanged(evt);
            }
        });
        checkportero.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                checkporteroStateChanged(evt);
            }
        });
        checkportero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkporteroActionPerformed(evt);
            }
        });

        nombrelbl.setBackground(new java.awt.Color(204, 204, 204));
        nombrelbl.setForeground(new java.awt.Color(255, 255, 255));
        nombrelbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombrelbl.setText("Nombre:");
        nombrelbl.setOpaque(true);

        apellidolbl.setBackground(new java.awt.Color(204, 204, 204));
        apellidolbl.setForeground(new java.awt.Color(255, 255, 255));
        apellidolbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        apellidolbl.setText("Apellido:");
        apellidolbl.setOpaque(true);

        ApellidoTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApellidoTXTActionPerformed(evt);
            }
        });

        cedulalbl.setBackground(new java.awt.Color(204, 204, 204));
        cedulalbl.setForeground(new java.awt.Color(255, 255, 255));
        cedulalbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cedulalbl.setText("Cedula:");
        cedulalbl.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(checkportero)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombrelbl, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(cedulalbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(apellidolbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ApellidoTXT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cedulaTXT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreTXT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkportero)
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(nombreTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombrelbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(apellidolbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ApellidoTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cedulalbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cedulaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(10, 280, 300, 130);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/fondo3.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 330, 470);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ubicaciontxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubicaciontxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ubicaciontxtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ListaPuertasGUI listaPuertasGUI = new ListaPuertasGUI();
        this.setVisible(false);
        listaPuertasGUI.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ubicaciontxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ubicaciontxtMouseClicked
        // TODO add your handling code here:
        this.ubicaciontxt.setText("");
    }//GEN-LAST:event_ubicaciontxtMouseClicked

    private void EntradaRBStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_EntradaRBStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_EntradaRBStateChanged

    private void EntradaRBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EntradaRBMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_EntradaRBMouseClicked

    private void EntradaRBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_EntradaRBItemStateChanged


    }//GEN-LAST:event_EntradaRBItemStateChanged

    private void SalidaRBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SalidaRBItemStateChanged

    }//GEN-LAST:event_SalidaRBItemStateChanged

    private void ESRBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ESRBItemStateChanged

    }//GEN-LAST:event_ESRBItemStateChanged

    private void EntradaRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntradaRBActionPerformed
        // TODO add your handling code here:
        this.ESRB.setSelected(false);
        this.SalidaRB.setSelected(false);
        if (!this.EntradaRB.isSelected()) {
            this.EntradaRB.setSelected(true);
        }
    }//GEN-LAST:event_EntradaRBActionPerformed

    private void SalidaRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalidaRBActionPerformed
        // TODO add your handling code here:
        this.EntradaRB.setSelected(false);
        this.ESRB.setSelected(false);
        if (!this.SalidaRB.isSelected()) {
            this.SalidaRB.setSelected(true);
        }
    }//GEN-LAST:event_SalidaRBActionPerformed

    private void ESRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ESRBActionPerformed
        // TODO add your handling code here:
        this.EntradaRB.setSelected(false);
        this.SalidaRB.setSelected(false);
        if (!this.ESRB.isSelected()) {
            this.ESRB.setSelected(true);
        }
    }//GEN-LAST:event_ESRBActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (this.ps.isModificar()) {
            ps.setModificar(false);

            this.modificarPuerta();
            this.setVisible(false);
            ListaPuertasGUI lpg = new ListaPuertasGUI();
            lpg.setVisible(true);
            JOptionPane.showMessageDialog(this, "Puerta Modificada Correctamente");
        } else {
            this.crearPuerta();
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void ApellidoTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApellidoTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ApellidoTXTActionPerformed

    private void checkporteroStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_checkporteroStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_checkporteroStateChanged

    private void checkporteroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkporteroItemStateChanged
        // TODO add your handling code here:
        if (checkportero.isSelected()) {
            this.nombrelbl.setEnabled(true);
            this.apellidolbl.setEnabled(true);
            this.cedulalbl.setEnabled(true);
            this.nombreTXT.setEnabled(true);
            this.ApellidoTXT.setEnabled(true);
            this.cedulaTXT.setEnabled(true);
        } else {
            this.nombrelbl.setEnabled(false);
            this.apellidolbl.setEnabled(false);
            this.cedulalbl.setEnabled(false);
            this.nombreTXT.setEnabled(false);
            this.ApellidoTXT.setEnabled(false);
            this.cedulaTXT.setEnabled(false);

        }
    }//GEN-LAST:event_checkporteroItemStateChanged

    private void checkporteroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkporteroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkporteroActionPerformed

    public void modificarPuerta() {
        try {
            String codigo = this.codigopuertalbl.getText();
            String ubicacion = this.ubicaciontxt.getText();
            int valor = 0;
            if (this.EntradaRB.isSelected()) {
                valor = 1;
            } else if (this.SalidaRB.isSelected()) {
                valor = 2;
            } else if (this.ESRB.isSelected()) {
                valor = 3;
            }

            Portero portero = null;
            if (this.checkportero.isSelected()) {
                try {
                    String nombre = this.nombreTXT.getText();
                    String apellido = this.ApellidoTXT.getText();
                    String cedula = this.cedulaTXT.getText();

                    portero = pos.crearPortero(nombre, apellido, cedula, ps.getPuerta());
                } catch (NombreIvalidoException ex) {
                    JOptionPane.showMessageDialog(this, "Nombre de Portero Invalido");
                } catch (ApellidoInvalidoException ex) {
                    JOptionPane.showMessageDialog(this, "Apellido de portero Invalido");
                } catch (CedulaInvalidaException ex) {
                    JOptionPane.showMessageDialog(this, "Cedula de Portero Invalido");
                } catch (PuertaInvalidaException ex) {
                    JOptionPane.showMessageDialog(this, "Puerta Invalida");
                }

            }

            ps.modificarPuerta(codigo, ubicacion, valor, portero);
        } catch (UbicacionInvalidoException ex) {
            JOptionPane.showMessageDialog(this, "Ubicacion invalida");
        }

    }

    public void crearPuerta() {
        try {
            String codigo = this.codigopuertalbl.getText();
            String ubicacion = this.ubicaciontxt.getText();
            int valor = 0;
            if (this.EntradaRB.isSelected()) {
                valor = 1;
            } else if (this.SalidaRB.isSelected()) {
                valor = 2;
            } else if (this.ESRB.isSelected()) {
                valor = 3;
            }

            String numero = Integer.toString(this.ps.getListapuertas().size() + 1);

            System.out.println("Datos de puerta: " + codigo + " " + ubicacion + " " + valor + " " + numero);
            ps.crearPuerta(numero, codigo, ubicacion);
            ps.EstadoPuerta(valor);

            Portero portero = null;
            if (this.checkportero.isSelected()) {
                String nombre = this.nombreTXT.getText();
                String apellido = this.ApellidoTXT.getText();
                String cedula = this.cedulaTXT.getText();

                portero = pos.crearPortero(nombre, apellido, cedula, ps.getPuerta());

            }

//            ps.getPuerta().setPortero(portero);
            ps.agregarPuerta();
            this.setVisible(false);
            ListaPuertasGUI lpg = new ListaPuertasGUI();
            lpg.setVisible(true);
            JOptionPane.showMessageDialog(this, "Puerta Creada Correctamente");

        } catch (CodigoInvalidoException ex) {
            JOptionPane.showMessageDialog(this, "Codigo Invalido");
        } catch (NumeroPuertaInvalidoException ex) {
            JOptionPane.showMessageDialog(this, "Numero de Puerta invalido");
        } catch (UbicacionInvalidoException ex) {
            JOptionPane.showMessageDialog(this, "Ubicacion Invalida");
        } catch (NombreIvalidoException ex) {
            JOptionPane.showMessageDialog(this, "Nombre de Portero Invalido");
        } catch (ApellidoInvalidoException ex) {
            JOptionPane.showMessageDialog(this, "Apellido de portero Invalido");
        } catch (CedulaInvalidaException ex) {
            JOptionPane.showMessageDialog(this, "Cedula de Portero Invalido");
        } catch (PuertaInvalidaException ex) {
            JOptionPane.showMessageDialog(this, "Puerta Invalida");
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DatosPuertasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatosPuertasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatosPuertasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatosPuertasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatosPuertasGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ApellidoTXT;
    private javax.swing.JRadioButton ESRB;
    private javax.swing.JRadioButton EntradaRB;
    private javax.swing.JRadioButton SalidaRB;
    private javax.swing.JLabel apellidolbl;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cedulaTXT;
    private javax.swing.JLabel cedulalbl;
    private javax.swing.JCheckBox checkportero;
    private javax.swing.JLabel codigopuertalbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField nombreTXT;
    private javax.swing.JLabel nombrelbl;
    private javax.swing.JTextField ubicaciontxt;
    // End of variables declaration//GEN-END:variables
}
