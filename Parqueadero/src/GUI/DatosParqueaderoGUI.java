/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import MODELO.Parqueadero;
import MODELO.Puerta;
import SERVICIO.CampusSERVICIO;
import SERVICIO.CapacidadInvalidaException;
import SERVICIO.CodigoInvalidoExcetion;
import SERVICIO.CodigosSERVICIO;
import SERVICIO.NumeroParqueaderoInvalido;
import SERVICIO.ParqueaderoVacioException;
import SERVICIO.ParqueaderosSERVICIO;
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
public class DatosParqueaderoGUI extends javax.swing.JFrame {

    private final DefaultTableModel modeltablaentradadisp;
    private final DefaultTableModel modeltablaentradaparq;
    private final DefaultTableModel modeltablasalidadisp;
    private final DefaultTableModel modeltablasalidaparq;
    int con = 0;
    CampusSERVICIO cs = CampusSERVICIO.getInstancia();
    ParqueaderosSERVICIO ps = ParqueaderosSERVICIO.getInstancia();
    PuertasSERVICIO pus = PuertasSERVICIO.getInstancia();

    /**
     * Creates new form DatosParqueaderoGUI
     */
    public DatosParqueaderoGUI() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/IMG/parking.png")).getImage());
        if (ps.isModificar()) {
            this.codparqlbl.setText(ps.getParqueadero().getCodigo());
            this.numparqlbl.setText(Integer.toString(ps.getParqueadero().getNumero()));
            this.capacidad.setText("Capacidad:  " + ps.getParqueadero().getCapacidad() + "  Vehiculos");
            this.capsilder.setValue(ps.getParqueadero().getCapacidad());
        } else {
            this.codparqlbl.setText(CodigosSERVICIO.getInstancia().generarCodigo("PA"));
            this.numparqlbl.setText(Integer.toString(cs.getCampus().getParqueaderos().size() + 1));
            pus.separarListas();
        }

        modeltablaentradadisp = (DefaultTableModel) this.listapuertasnetradadisp.getModel();
        modeltablaentradaparq = (DefaultTableModel) this.listapuertasentradaparq.getModel();
        modeltablasalidadisp = (DefaultTableModel) this.listapuertassalidadisp.getModel();
        modeltablasalidaparq = (DefaultTableModel) this.listapuertassalidaparq.getModel();

        this.mostrarDatostablaentradadisp();
        this.mostrarDatostablasalidaDisp();
        this.mostrarDatostablaentradaparq();
        this.mostrarDatostablasalidaparq();
        alinearDatos(listapuertasnetradadisp, listapuertasnetradadisp.getColumnCount());
        alinearDatos(listapuertasentradaparq, listapuertasentradaparq.getColumnCount());
        alinearDatos(listapuertassalidadisp, listapuertassalidadisp.getColumnCount());
        alinearDatos(listapuertassalidaparq, listapuertassalidaparq.getColumnCount());

    }

    private void Limpiar(DefaultTableModel d) {
        int b = d.getRowCount() - 1;  //Índices van de 0 a n-1
        for (int i = b; i >= 0; i--) {
            d.removeRow(i);
        }
    }

    public void mostrarDatostablaentradadisp() {
        this.Limpiar(modeltablaentradadisp);
        List<Puerta> lista = new ArrayList();
        lista = pus.getListapuertasentrada();
        for (Puerta p : lista) {
            String valor = null;
            if (p.getTipoDePuerta().estadoPuerta().equalsIgnoreCase("entrada")) {
                valor = "Entrada";
            } else if (p.getTipoDePuerta().estadoPuerta().equalsIgnoreCase("salida")) {
                valor = "Salida";
            } else if (p.getTipoDePuerta().estadoPuerta().equalsIgnoreCase("entrada/salida")) {
                valor = "E / S";
            }
            modeltablaentradadisp.addRow(new Object[]{p.getCodigo(), p.getNumero(), p.getUbicacion(), valor});
        }
    }

    public void mostrarDatostablasalidaDisp() {
        this.Limpiar(modeltablasalidadisp);
        List<Puerta> lista = new ArrayList();
        lista = pus.getListapuertasalida();
        for (Puerta p : lista) {
            String valor = null;
            if (p.getTipoDePuerta().estadoPuerta().equalsIgnoreCase("entrada")) {
                valor = "Entrada";
            } else if (p.getTipoDePuerta().estadoPuerta().equalsIgnoreCase("salida")) {
                valor = "Salida";
            } else if (p.getTipoDePuerta().estadoPuerta().equalsIgnoreCase("entrada/salida")) {
                valor = "E / S";
            }
            modeltablasalidadisp.addRow(new Object[]{p.getCodigo(), p.getNumero(), p.getUbicacion(), valor});
        }
    }

    public void mostrarDatostablaentradaparq() {
        this.Limpiar(modeltablaentradaparq);
        List<Puerta> lista = new ArrayList();
        lista = ps.getPuertasentrada();
        for (Puerta p : lista) {

            String valor = null;
            if (p.getTipoDePuerta().estadoPuerta().equalsIgnoreCase("entrada")) {
                valor = "Entrada";
            } else if (p.getTipoDePuerta().estadoPuerta().equalsIgnoreCase("salida")) {
                valor = "Salida";
            } else if (p.getTipoDePuerta().estadoPuerta().equalsIgnoreCase("entrada/salida")) {
                valor = "E / S";
            }
            modeltablaentradaparq.addRow(new Object[]{p.getCodigo(), p.getNumero(), p.getUbicacion(), valor});
        }
    }

    public void mostrarDatostablasalidaparq() {
        this.Limpiar(modeltablasalidaparq);
        List<Puerta> lista = new ArrayList();
        lista = ps.getPuertassalida();
        for (Puerta p : lista) {
            String valor = null;
            if (p.getTipoDePuerta().estadoPuerta().equalsIgnoreCase("entrada")) {
                valor = "Entrada";
            } else if (p.getTipoDePuerta().estadoPuerta().equalsIgnoreCase("salida")) {
                valor = "Salida";
            } else if (p.getTipoDePuerta().estadoPuerta().equalsIgnoreCase("entrada/salida")) {
                valor = "E / S";
            }
            modeltablasalidaparq.addRow(new Object[]{p.getCodigo(), p.getNumero(), p.getUbicacion(), valor});
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

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        codparqlbl = new javax.swing.JLabel();
        numparqlbl = new javax.swing.JLabel();
        capacidad = new javax.swing.JLabel();
        capsilder = new javax.swing.JSlider();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        msnlbl = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listapuertasnetradadisp = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listapuertasentradaparq = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listapuertassalidadisp = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        listapuertassalidaparq = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        jButton4.setText("jButton4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(930, 680));
        setSize(new java.awt.Dimension(930, 680));
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Datos de Parqueadero");

        codparqlbl.setForeground(new java.awt.Color(255, 255, 255));
        codparqlbl.setText(" PAR001");

        numparqlbl.setForeground(new java.awt.Color(255, 255, 255));
        numparqlbl.setText("01");

        capacidad.setForeground(new java.awt.Color(255, 255, 255));
        capacidad.setText("Capacidad:   10  Vehiculos");

        capsilder.setMaximum(50);
        capsilder.setPaintLabels(true);
        capsilder.setValue(10);
        capsilder.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                capsilderAncestorMoved(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        capsilder.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                capsilderStateChanged(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));

        jButton3.setText("<< --");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("+ >>");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("+ >>");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("<< -");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Codigo:");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Numero:");

        jLabel8.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Campus");

        jLabel9.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nuevo Parqueadero");

        msnlbl.setForeground(new java.awt.Color(255, 255, 255));
        msnlbl.setText("agrege mas puertas");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Puertas de Entrada Disponibles", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setOpaque(false);

        listapuertasnetradadisp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Numero", "Ubicacion", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(listapuertasnetradadisp);
        if (listapuertasnetradadisp.getColumnModel().getColumnCount() > 0) {
            listapuertasnetradadisp.getColumnModel().getColumn(0).setResizable(false);
            listapuertasnetradadisp.getColumnModel().getColumn(1).setResizable(false);
            listapuertasnetradadisp.getColumnModel().getColumn(2).setResizable(false);
            listapuertasnetradadisp.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Puertas de entrada al Parqueadero", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setOpaque(false);

        listapuertasentradaparq.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Numero", "Ubicacion", "tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane2.setViewportView(listapuertasentradaparq);
        if (listapuertasentradaparq.getColumnModel().getColumnCount() > 0) {
            listapuertasentradaparq.getColumnModel().getColumn(0).setResizable(false);
            listapuertasentradaparq.getColumnModel().getColumn(1).setResizable(false);
            listapuertasentradaparq.getColumnModel().getColumn(2).setResizable(false);
            listapuertasentradaparq.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Puertas de Salida Disponilbes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setOpaque(false);

        listapuertassalidadisp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Numero", "Ubicacion", "tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane4.setViewportView(listapuertassalidadisp);
        if (listapuertassalidadisp.getColumnModel().getColumnCount() > 0) {
            listapuertassalidadisp.getColumnModel().getColumn(0).setResizable(false);
            listapuertassalidadisp.getColumnModel().getColumn(1).setResizable(false);
            listapuertassalidadisp.getColumnModel().getColumn(2).setResizable(false);
            listapuertassalidadisp.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Puertas de Salida al Parqueadero", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel5.setOpaque(false);

        listapuertassalidaparq.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Numero", "Ubicacion", "tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane5.setViewportView(listapuertassalidaparq);
        if (listapuertassalidaparq.getColumnModel().getColumnCount() > 0) {
            listapuertassalidaparq.getColumnModel().getColumn(0).setResizable(false);
            listapuertassalidaparq.getColumnModel().getColumn(1).setResizable(false);
            listapuertassalidaparq.getColumnModel().getColumn(2).setResizable(false);
            listapuertassalidaparq.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(332, 332, 332)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(341, 341, 341)
                                        .addComponent(capsilder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(368, 368, 368)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(codparqlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(capacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(numparqlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(msnlbl)
                        .addGap(518, 518, 518)
                        .addComponent(jLabel9)
                        .addContainerGap(11, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 864, Short.MAX_VALUE)
                        .addComponent(jSeparator1))
                    .addContainerGap(14, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(codparqlbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(numparqlbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(capacidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(capsilder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(msnlbl)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 173, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(159, 159, 159)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 225, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 890, 580);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/fondo3.png"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(0, 0, 920, 660);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void capsilderAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_capsilderAncestorMoved
        // TODO add your handling code here:

    }//GEN-LAST:event_capsilderAncestorMoved

    private void capsilderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_capsilderStateChanged
        // TODO add your handling code here:
        this.capacidad.setText("Capacidad:  " + this.capsilder.getValue() + "  Vehiculos");
    }//GEN-LAST:event_capsilderStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ps.setModificar(false);
        ps.limpiarlistas();
        ListaParqueaderosGUI gUI = new ListaParqueaderosGUI();
        this.setVisible(false);
        gUI.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        boolean v = false;
        if (ps.isModificar()) {
            v = true;
        }

        try {
            // TODO add your handling code here:
            String codigo = this.codparqlbl.getText();
            int numero = Integer.parseInt(this.numparqlbl.getText());
            int capacidad = this.capsilder.getValue();

            Parqueadero p = ps.crearParqueadero(codigo, numero, capacidad);
            cs.agregarParqueadero(p);
            ps.limpiarlistas();
            ps.setModificar(false);
            this.setVisible(false);
            ps.setModificar(false);
            ListaParqueaderosGUI lpg = new ListaParqueaderosGUI();
            lpg.setVisible(true);
            JOptionPane.showMessageDialog(this, v ? "Parqueadero Modificado Exitosamente" : "Parqueadero Creado Exitosamente");
        } catch (ParqueaderoVacioException ex) {
            JOptionPane.showMessageDialog(this, "El parqueadero no tiene puertas");
        } catch (CodigoInvalidoExcetion ex) {
            JOptionPane.showMessageDialog(this, "Codigo de Parqueadero Invalido");
        } catch (CapacidadInvalidaException ex) {
            JOptionPane.showMessageDialog(this, "Capacidad no Puede ser menor o igual que cero");
        } catch (NumeroParqueaderoInvalido ex) {
            JOptionPane.showMessageDialog(this, "Numero de parqueadero invalido");
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int index = this.listapuertasnetradadisp.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione una puerta de entrada");
        } else {
            String codigo = (String) this.listapuertasnetradadisp.getValueAt(index, 0);
            Puerta p = pus.obtenerPuertaentrada(codigo);
            //System.out.println("puerta recuperada "+p);
            ps.agregarPuertaentrada(p);

            this.mostrarDatostablaentradadisp();
            this.mostrarDatostablasalidaDisp();
            this.mostrarDatostablaentradaparq();
            this.mostrarDatostablasalidaparq();
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int index = this.listapuertasentradaparq.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione una puerta del Parqueadero");
        } else {
            String codigo = (String) this.listapuertasentradaparq.getValueAt(index, 0);
            Puerta p = ps.obtenerPuertaEntrada(codigo);
            pus.agregarPuertaEntrada(p);
            this.mostrarDatostablaentradadisp();
            this.mostrarDatostablasalidaDisp();
            this.mostrarDatostablaentradaparq();
            this.mostrarDatostablasalidaparq();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int index = this.listapuertassalidadisp.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione una puerta de salida disponilbe");
        } else {
            String codigo = (String) this.listapuertassalidadisp.getValueAt(index, 0);
            Puerta p = pus.obtenerPuertasalida(codigo);
            ps.agregarPuertaSalida(p);
            System.out.println(">>> Puerta de salida agregada al parqueadero");
            this.mostrarDatostablaentradadisp();
            this.mostrarDatostablasalidaDisp();
            this.mostrarDatostablaentradaparq();
            this.mostrarDatostablasalidaparq();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int index = this.listapuertassalidaparq.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione una puerta del Parqueadero");
        } else {
            String codigo = (String) this.listapuertassalidaparq.getValueAt(index, 0);
            Puerta p = ps.obtenerPuertaSalida(codigo);
            pus.agregarPuertaSalida(p);
            System.out.println(">>> puerta de salida quitada de parqueadero");
            this.mostrarDatostablaentradadisp();
            this.mostrarDatostablasalidaDisp();
            this.mostrarDatostablaentradaparq();
            this.mostrarDatostablasalidaparq();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(DatosParqueaderoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatosParqueaderoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatosParqueaderoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatosParqueaderoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatosParqueaderoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel capacidad;
    private javax.swing.JSlider capsilder;
    private javax.swing.JLabel codparqlbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable listapuertasentradaparq;
    private javax.swing.JTable listapuertasnetradadisp;
    private javax.swing.JTable listapuertassalidadisp;
    private javax.swing.JTable listapuertassalidaparq;
    private javax.swing.JLabel msnlbl;
    private javax.swing.JLabel numparqlbl;
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
