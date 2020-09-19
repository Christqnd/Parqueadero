/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.CampusNoExisteException;
import DAO.CodigodeCampusNoExisteException;
import DAO.PuertasDAO;
import MODELO.Campus;
import SERVICIO.CampusSERVICIO;
import SERVICIO.PuertasSERVICIO;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.josql.QueryExecutionException;
import org.josql.QueryParseException;

/**
 *
 * @author pablopc
 */
public class ListaCampusGUI extends javax.swing.JFrame {

    CampusSERVICIO cs = CampusSERVICIO.getInstancia();
    private DefaultTableModel model1;
    int con = 0;

    /**
     * Creates new form ListaCampusGUI
     */
    public ListaCampusGUI() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/IMG/parking.png")).getImage());
        mostrarDatos();
        alinearDatos(listacampus, listacampus.getColumnCount());
        this.con = 0;
    }

    public void insertarDatos(Campus c) {
        model1.insertRow(con, new Object[]{});
        model1.setValueAt(c.getCodigo(), con, 0);
        model1.setValueAt(c.getNombre(), con, 1);
        try {
            model1.setValueAt(PuertasSERVICIO.getInstancia().verCantidadPuertas(c.getCodigo()), con, 2);
        } catch (CodigodeCampusNoExisteException ex) {
            System.out.println("Codigo de Campus no existe");
        }
        model1.setValueAt(c.getParqueaderos().size(), con, 3);
        this.con++;
    }

    public void interfazTabla() {
        String data[][] = {};
        String col[] = {"Código", "Nombre", "Cant. Puertas", "Cant. parqueaderos"};
        model1 = new DefaultTableModel(data, col) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.listacampus.setModel(model1);
        listacampus.getColumnModel().getColumn(0).setResizable(false);
        listacampus.getColumnModel().getColumn(1).setResizable(false);
        listacampus.getColumnModel().getColumn(2).setResizable(false);
        listacampus.getColumnModel().getColumn(3).setResizable(false);

    }

    public void mostrarDatos() {
        try {
            this.interfazTabla();
            List<Campus> lista = new ArrayList();
            lista = cs.obtenerlistaCampus();
            for (int i = 0; i < lista.size(); i++) {
                this.insertarDatos(lista.get(i));
            }
        } catch (QueryExecutionException ex) {
            Logger.getLogger(ListaCampusGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (QueryParseException ex) {
            Logger.getLogger(ListaCampusGUI.class.getName()).log(Level.SEVERE, null, ex);
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
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listacampus = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(430, 460));
        setMinimumSize(new java.awt.Dimension(430, 460));
        setPreferredSize(new java.awt.Dimension(430, 460));
        setSize(new java.awt.Dimension(430, 460));
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Listado de Campus", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setOpaque(false);

        jButton5.setText("Agregar +");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setText("Modificar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setText("Quitar -");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        listacampus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Puertas", "Parqueaderos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(listacampus);
        if (listacampus.getColumnModel().getColumnCount() > 0) {
            listacampus.getColumnModel().getColumn(0).setResizable(false);
            listacampus.getColumnModel().getColumn(1).setResizable(false);
            listacampus.getColumnModel().getColumn(2).setResizable(false);
            listacampus.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Campus");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jButton5)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addComponent(jButton3)
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(304, 304, 304)
                            .addComponent(jButton2)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 308, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 39, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(11, 11, 11)
                    .addComponent(jButton2)
                    .addGap(0, 11, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 390, 380);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/fondo3.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(-270, -130, 740, 610);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        DatosCampusGUI dcgui = new DatosCampusGUI();
        this.setVisible(false);
        dcgui.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        ParqueaderoMAINGUI pmg = new ParqueaderoMAINGUI();
        pmg.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int index = this.listacampus.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un Campus");
        } else {
            try {
                String codigo = (String) this.listacampus.getValueAt(index, 0);
                cs.setModificar(true);
                cs.cargarCampus(codigo);

                PuertasDAO.getInstancia().mostrar();
                PuertasSERVICIO.getInstancia().CargarPuertas(codigo);
                this.setVisible(false);
                DatosCampusGUI dcg = new DatosCampusGUI();
                dcg.setVisible(true);
            } catch (CampusNoExisteException ex) {
                JOptionPane.showMessageDialog(this, "Campus no Existe");
            } catch (CodigodeCampusNoExisteException ex) {
                JOptionPane.showMessageDialog(this, "Campus codigo no Existe");
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            int index = this.listacampus.getSelectedRow();
            if (index < 0) {
                JOptionPane.showMessageDialog(this, "Seleccione un campus");
            } else {
                String codigo = (String) this.listacampus.getValueAt(index, 0);
                CampusSERVICIO.getInstancia().eliminarCampus(codigo);
                this.mostrarDatos();
                this.con = 0;
            }
        } catch (CampusNoExisteException ex) {
            JOptionPane.showMessageDialog(this, "El Campus se ha Eliminado");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(ListaCampusGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaCampusGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaCampusGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaCampusGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaCampusGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listacampus;
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
