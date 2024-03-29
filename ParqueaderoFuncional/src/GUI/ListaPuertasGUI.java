/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DATO.CodigodeCampusNoExisteException;
import DATO.PuertaNoexisteException;
import MODELO.Puerta;
import SERVICIO.EmpresaSERVICIO;
import SERVICIO.PuertaAsignadaException;
import SERVICIO.PuertasSERVICIO;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author gube
 */
public class ListaPuertasGUI extends javax.swing.JFrame {

    PuertasSERVICIO ps = PuertasSERVICIO.getInstancia();
    EmpresaSERVICIO cs = EmpresaSERVICIO.getInstancia();
    private DefaultTableModel model1;
    int con = 0;

    /**
     * Creates new form ListaPuertasGUI
     */
    public ListaPuertasGUI() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/IMG/parking.png")).getImage());
        this.mostrarDatos();
        this.con = 0;
        this.nombrecampuslbl.setText("Puertas de Campus: " + EmpresaSERVICIO.getInstancia().getEmpresa().getNombre());
        alinearDatos(listapuertas, listapuertas.getColumnCount());
    }

    public void insertarDatos(Puerta c) {
        model1.insertRow(con, new Object[]{});
        model1.setValueAt(c.getIdPuerta(), con, 0);
        model1.setValueAt(c.getNumero(), con, 1);
        model1.setValueAt(c.getDescripcion(), con, 2);
        model1.setValueAt(c.getTipo(), con, 3);
//        if (c.getPortero() == null) {
            model1.setValueAt("-", con, 4);
//        } else {
//            model1.setValueAt(c.getPortero().getCedula(), con, 4);
//        }
        this.con++;
    }

    public void interfazTabla() {
        String data[][] = {};
        String col[] = {"Código", "Numero", "Ubicacion", "Tipo", "Portero"};
        model1 = new DefaultTableModel(data, col) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.listapuertas.setModel(model1);
        listapuertas.getColumnModel().getColumn(0).setResizable(false);
        listapuertas.getColumnModel().getColumn(1).setResizable(false);
        listapuertas.getColumnModel().getColumn(2).setResizable(false);
        listapuertas.getColumnModel().getColumn(3).setResizable(false);
        listapuertas.getColumnModel().getColumn(4).setResizable(false);

    }

    public void mostrarDatos() {
        this.interfazTabla();
        List<Puerta> lista = new ArrayList();
        lista = ps.getListapuertas();
        for (Puerta lista1 : lista) {
            this.insertarDatos(lista1);
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
        nombrecampuslbl = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listapuertas = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(450, 385));
        setSize(new java.awt.Dimension(450, 385));
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Listado de Puertas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setOpaque(false);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Puertas");

        nombrecampuslbl.setForeground(new java.awt.Color(255, 255, 255));
        nombrecampuslbl.setText("Campus:");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Quitar (-)");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Agregar (+)");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        listapuertas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Numero", "Ubicacion", "Tipo", "Portero"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(listapuertas);
        if (listapuertas.getColumnModel().getColumnCount() > 0) {
            listapuertas.getColumnModel().getColumn(0).setResizable(false);
            listapuertas.getColumnModel().getColumn(1).setResizable(false);
            listapuertas.getColumnModel().getColumn(2).setResizable(false);
            listapuertas.getColumnModel().getColumn(3).setResizable(false);
            listapuertas.getColumnModel().getColumn(4).setResizable(false);
        }

        jButton5.setText("Aceptar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 402, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(184, 184, 184)
                            .addComponent(jLabel1))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(103, 103, 103)
                            .addComponent(nombrecampuslbl))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(130, 130, 130)
                            .addComponent(jButton3)
                            .addGap(6, 6, 6)
                            .addComponent(jButton2)
                            .addGap(6, 6, 6)
                            .addComponent(jButton1))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(314, 314, 314)
                            .addComponent(jButton5)))
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 319, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(6, 6, 6)
                    .addComponent(nombrecampuslbl)
                    .addGap(6, 6, 6)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(6, 6, 6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton3)
                        .addComponent(jButton2)
                        .addComponent(jButton1))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(11, 11, 11)
                    .addComponent(jButton5)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 0, 410, 340);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/fondo3.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 440, 360);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int index = this.listapuertas.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione una Puerta");
        } else {
            try {
                String codigocampus = cs.getEmpresa().getCodigo();
                String codigopuerta = (String) this.listapuertas.getValueAt(index, 0);
                ps.setModificar(true);
                ps.cargarPuerta(codigopuerta);
                this.setVisible(false);
                DatosPuertasGUI dpg = new DatosPuertasGUI();
                dpg.setVisible(true);
            } catch (CodigodeCampusNoExisteException ex) {
                JOptionPane.showMessageDialog(this, "Campus no existe");
            } catch (PuertaNoexisteException ex) {
                JOptionPane.showMessageDialog(this, "Puerta no Existe");
            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DatosPuertasGUI datosPuertasGUI = new DatosPuertasGUI();
        this.setVisible(false);
        datosPuertasGUI.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        DatosCampusGUI dcg = new DatosCampusGUI();
        dcg.nombreExistente(0);
        dcg.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int index = this.listapuertas.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione una puerta");
        } else {
            try {
                String codigo = (String) this.listapuertas.getValueAt(index, 0);
                ps.eliminarPuerta(codigo);
                JOptionPane.showMessageDialog(this, "Puerta Eliminada");
                this.mostrarDatos();
            } catch (PuertaAsignadaException ex) {
                JOptionPane.showMessageDialog(this, "Esta Puerta esta asignada a Un Parqueadero");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ListaPuertasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaPuertasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaPuertasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaPuertasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaPuertasGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable listapuertas;
    private javax.swing.JLabel nombrecampuslbl;
    // End of variables declaration//GEN-END:variables

    private void alinearDatos(JTable tabla, int numeroColumnas) {
        DefaultTableCellRenderer AlinearDatos = new DefaultTableCellRenderer();
        AlinearDatos.setHorizontalAlignment(SwingConstants.CENTER);//.LEFT .RIGHT .CENTER

        DefaultTableCellRenderer AlinearHeader = new DefaultTableCellRenderer();
        AlinearHeader.setHorizontalAlignment(SwingConstants.CENTER);//.LEFT .RIGHT .CENTER
        AlinearHeader.setVerticalAlignment(SwingConstants.CENTER);
        AlinearHeader.setBackground(Color.LIGHT_GRAY);
        AlinearHeader.setForeground(Color.white);
        JTableHeader header = tabla.getTableHeader();
        header.setDefaultRenderer(AlinearHeader);
        tabla.setTableHeader(header);
        for (int i = 0; i < numeroColumnas; i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(AlinearDatos);
        }
    }
}
