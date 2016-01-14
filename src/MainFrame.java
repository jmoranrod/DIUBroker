
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import persistence.WalletLoader;

public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        testWallets();
        
        
        initComponents();
        Fecha.setEditable(false);
        /* OCULTA LAS COLUMNA DEL VENCIMIENTO */
        TablaOpcionesPUT.getColumnModel().getColumn(8).setMinWidth(0);
        TablaOpcionesPUT.getColumnModel().getColumn(8).setMaxWidth(0);
        TablaOpcionesPUT.getColumnModel().getColumn(8).setWidth(0);
        
        TablaOpcionesCALL.getColumnModel().getColumn(8).setMinWidth(0);
        TablaOpcionesCALL.getColumnModel().getColumn(8).setMaxWidth(0);
        TablaOpcionesCALL.getColumnModel().getColumn(8).setWidth(0);
                
        /* Button color magic */
        connectionStatusButton.setContentAreaFilled(false);
        connectionStatusButton.setOpaque(true);
        
        setDate();
        Timer timDate = new Timer(1000,new ActionListener(){ // 1 segundo
            @Override
            public void actionPerformed(ActionEvent evt){
                setDate();
            }
        });
        timDate.start();
        
        CollectData();
        Timer timData = new Timer(30000,new ActionListener(){ // 3 minutos
            @Override
            public void actionPerformed(ActionEvent evt){
                CollectData();
            }
        });
        timData.start();
    }

    private void testWallets() {
        WalletLoader wallet  = new WalletLoader("asd");
        ArrayList list = new ArrayList<String>();
        list.add("sd1");
        list.add("sd2");
        list.add("sd3");
        list.add("sd4");
        wallet.writeToFile(list);
        
        ArrayList list2 = new ArrayList<String>();
        list2.add("sdb1");
        list2.add("sdb2");
        wallet.writeToFile(list2);
        
        List listaa = wallet.readFromFile();
        System.out.println(listaa.get(0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Escritorio = new javax.swing.JDesktopPane();
        infoPanel = new javax.swing.JPanel();
        Institucion = new javax.swing.JLabel();
        ULPGC = new javax.swing.JLabel();
        VentanaContado = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaContado = new javax.swing.JTable();
        VentanaFuturos = new javax.swing.JInternalFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaFuturos = new javax.swing.JTable();
        VentanaOpcionesCALL = new javax.swing.JInternalFrame();
        callComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaOpcionesCALL = new javax.swing.JTable();
        VentanaOpcionesPUT = new javax.swing.JInternalFrame();
        putComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaOpcionesPUT = new javax.swing.JTable();
        topPanel = new javax.swing.JPanel();
        Fecha = new javax.swing.JTextField();
        connectionStatusButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        BarraMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        exit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cartera de Opciones del IBEX35");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/euro.png")).getImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        Institucion.setText("<html>Universidad de Las Palmas de Gran Canaria<br>Escuela de Ingeniería Informática<br>Diseño de Interfaces de Usuario<br>Héctor Macías Casado<br>Javier Morán Rodríguez</html>");

        ULPGC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LOGO_ULPGC.jpg"))); // NOI18N

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addComponent(ULPGC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Institucion, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Institucion, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ULPGC))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        VentanaContado.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        VentanaContado.setIconifiable(true);
        VentanaContado.setTitle("Contado/Spot");
        VentanaContado.setToolTipText("Precio de Contado/Spot");
        VentanaContado.setVisible(true);

        TablaContado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Último", "Diferencia(%)", "Anterior", "Máximo", "Mínimo", "Fecha", "Hora(Madrid)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaContado);

        javax.swing.GroupLayout VentanaContadoLayout = new javax.swing.GroupLayout(VentanaContado.getContentPane());
        VentanaContado.getContentPane().setLayout(VentanaContadoLayout);
        VentanaContadoLayout.setHorizontalGroup(
            VentanaContadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
        );
        VentanaContadoLayout.setVerticalGroup(
            VentanaContadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        VentanaFuturos.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        VentanaFuturos.setIconifiable(true);
        VentanaFuturos.setTitle("Futuros (MINI) IBEX35");
        VentanaFuturos.setToolTipText("Futuros del (MINI)IBEX35");
        VentanaFuturos.setVisible(true);

        TablaFuturos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Vencimiento", "Vol. Compra", "P. Compra", "P Venta", "Vol. Venta", "Último", "Volumen", "Apertura", "Máximo", "Mínimo", "Anterior", "Hora(Madrid)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TablaFuturos);

        javax.swing.GroupLayout VentanaFuturosLayout = new javax.swing.GroupLayout(VentanaFuturos.getContentPane());
        VentanaFuturos.getContentPane().setLayout(VentanaFuturosLayout);
        VentanaFuturosLayout.setHorizontalGroup(
            VentanaFuturosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE)
        );
        VentanaFuturosLayout.setVerticalGroup(
            VentanaFuturosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaFuturosLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 244, Short.MAX_VALUE))
        );

        VentanaOpcionesCALL.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        VentanaOpcionesCALL.setIconifiable(true);
        VentanaOpcionesCALL.setTitle("Opciones IBEX35 - CALL");
        VentanaOpcionesCALL.setToolTipText("Opciones CALL del IBEX35");
        VentanaOpcionesCALL.setVisible(true);

        callComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                callComboBoxItemStateChanged(evt);
            }
        });

        jLabel1.setText("Fecha de Vencimiento:");

        TablaOpcionesCALL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Ejercicio", "Vol. Compra", "P Compra", "P Venta", "Vol. Venta", "Último", "Volumen", "Hora(Madrid)", "Vencimiento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(TablaOpcionesCALL);
        if (TablaOpcionesCALL.getColumnModel().getColumnCount() > 0) {
            TablaOpcionesCALL.getColumnModel().getColumn(7).setResizable(false);
            TablaOpcionesCALL.getColumnModel().getColumn(8).setResizable(false);
        }

        javax.swing.GroupLayout VentanaOpcionesCALLLayout = new javax.swing.GroupLayout(VentanaOpcionesCALL.getContentPane());
        VentanaOpcionesCALL.getContentPane().setLayout(VentanaOpcionesCALLLayout);
        VentanaOpcionesCALLLayout.setHorizontalGroup(
            VentanaOpcionesCALLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VentanaOpcionesCALLLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(callComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
        );
        VentanaOpcionesCALLLayout.setVerticalGroup(
            VentanaOpcionesCALLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaOpcionesCALLLayout.createSequentialGroup()
                .addGroup(VentanaOpcionesCALLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(callComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                .addContainerGap())
        );

        VentanaOpcionesPUT.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        VentanaOpcionesPUT.setIconifiable(true);
        VentanaOpcionesPUT.setTitle("Opciones IBEX35 - PUT");
        VentanaOpcionesPUT.setToolTipText("Opciones PUT del IBEX35");
        VentanaOpcionesPUT.setVisible(true);

        putComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        putComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                putComboBoxItemStateChanged(evt);
            }
        });

        jLabel2.setText("Fecha de Vencimiento:");

        TablaOpcionesPUT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Ejercicio", "Vol. Compra", "P Compra", "P Venta", "Vol. Venta", "Último", "Volumen", "Hora(Madrid)", "Vencimiento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(TablaOpcionesPUT);

        javax.swing.GroupLayout VentanaOpcionesPUTLayout = new javax.swing.GroupLayout(VentanaOpcionesPUT.getContentPane());
        VentanaOpcionesPUT.getContentPane().setLayout(VentanaOpcionesPUTLayout);
        VentanaOpcionesPUTLayout.setHorizontalGroup(
            VentanaOpcionesPUTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VentanaOpcionesPUTLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(putComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
        );
        VentanaOpcionesPUTLayout.setVerticalGroup(
            VentanaOpcionesPUTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaOpcionesPUTLayout.createSequentialGroup()
                .addGroup(VentanaOpcionesPUTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(putComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EscritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EscritorioLayout.createSequentialGroup()
                        .addComponent(VentanaContado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EscritorioLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(VentanaFuturos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(EscritorioLayout.createSequentialGroup()
                                .addComponent(VentanaOpcionesPUT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(VentanaOpcionesCALL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EscritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VentanaContado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(VentanaFuturos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EscritorioLayout.createSequentialGroup()
                        .addComponent(VentanaOpcionesPUT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EscritorioLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(VentanaOpcionesCALL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))))
        );
        Escritorio.setLayer(infoPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio.setLayer(VentanaContado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio.setLayer(VentanaFuturos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio.setLayer(VentanaOpcionesCALL, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio.setLayer(VentanaOpcionesPUT, javax.swing.JLayeredPane.DEFAULT_LAYER);

        topPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        connectionStatusButton.setEnabled(false);
        connectionStatusButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                connectionStatusButtonMouseClicked(evt);
            }
        });
        connectionStatusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectionStatusButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Estado de la conexión: ");

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(connectionStatusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(topPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addGroup(topPanelLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(connectionStatusButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(topPanelLayout.createSequentialGroup()
                                .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        jMenu1.setText("File");

        exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jMenu1.add(exit);

        BarraMenu.add(jMenu1);

        jMenu2.setText("Edit");
        BarraMenu.add(jMenu2);

        setJMenuBar(BarraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Escritorio))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int ret = JOptionPane.showConfirmDialog(null, "¿Realmente desea salir?", "Salir", JOptionPane.YES_NO_OPTION);
        if(ret == 0)
            System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        int ret = JOptionPane.showConfirmDialog(null, "¿Realmente desea salir?", "Salir", JOptionPane.YES_NO_OPTION);
        if(ret == 0)
            System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void putComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_putComboBoxItemStateChanged
        // TODO add your handling code here:
        
        String query = putComboBox.getSelectedItem().toString();
        
        filter(query, TablaOpcionesPUT);
        
    }//GEN-LAST:event_putComboBoxItemStateChanged

    private void callComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_callComboBoxItemStateChanged
        // TODO add your handling code here:
        
        String query = callComboBox.getSelectedItem().toString();
        
        filter(query, TablaOpcionesCALL);
        
    }//GEN-LAST:event_callComboBoxItemStateChanged

    private void connectionStatusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectionStatusButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_connectionStatusButtonActionPerformed

    private void connectionStatusButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_connectionStatusButtonMouseClicked
        CollectData();
        Timer timData = new Timer(180000,new ActionListener(){ // 3 minutos
            @Override
            public void actionPerformed(ActionEvent evt){
                CollectData();
            }
        });
        timData.start();
    }//GEN-LAST:event_connectionStatusButtonMouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar BarraMenu;
    private javax.swing.JDesktopPane Escritorio;
    private javax.swing.JTextField Fecha;
    private javax.swing.JLabel Institucion;
    private javax.swing.JTable TablaContado;
    private javax.swing.JTable TablaFuturos;
    private javax.swing.JTable TablaOpcionesCALL;
    private javax.swing.JTable TablaOpcionesPUT;
    private javax.swing.JLabel ULPGC;
    private javax.swing.JInternalFrame VentanaContado;
    private javax.swing.JInternalFrame VentanaFuturos;
    private javax.swing.JInternalFrame VentanaOpcionesCALL;
    private javax.swing.JInternalFrame VentanaOpcionesPUT;
    private javax.swing.JComboBox callComboBox;
    private javax.swing.JButton connectionStatusButton;
    private javax.swing.JMenuItem exit;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JComboBox putComboBox;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables

    private MEFF_Contado contado = new MEFF_Contado();
    private MEFF_Futuros futuros = new MEFF_Futuros();
    private MEFF_Opciones opciones = new MEFF_Opciones();
    private DefaultTableModel dm;

    private void setDate(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss ");
        String formatedDate = sdf.format(date);
        formatedDate = formatedDate.concat(" (local)");
        Fecha.setText(formatedDate);
    }

    private Float toFloat(String texto){
        texto = texto.replace(".", "");
        texto = texto.replace(",", ".");
        return Float.valueOf(texto);
    }

    private void CollectData(){
        tablaContado();
        tablaFuturos();
        tablaOpciones();
        fillComboBoxes();
    }
    
    private void updateConnectionStatus(boolean status){
        if (status) {
            connectionStatusButton.setBackground(Color.green);
            connectionStatusButton.setEnabled(false);
            connectionStatusButton.setText("Ok");
        }else{
            connectionStatusButton.setText("Reconectar");
            connectionStatusButton.setBackground(Color.red);
            connectionStatusButton.setEnabled(true);
        }
    }

    private void tablaOpciones() {
        boolean connectionStatus = opciones.getOptions();
        updateConnectionStatus(connectionStatus);
        if (connectionStatus) {
        
        
            int nopciones = opciones.Opciones.size();
            DefaultTableModel tablemodel = (DefaultTableModel) TablaOpcionesCALL.getModel();
            tablemodel.setRowCount(nopciones);
            tablemodel = (DefaultTableModel)TablaOpcionesPUT.getModel();
            tablemodel.setRowCount(nopciones);
            for(int i = 0; i < nopciones; i++){
                Opcion f = opciones.Opciones.get(i);
                switch (opciones.Opciones.get(i).Tipo) {
                    case "CALL":
                        TablaOpcionesCALL.setValueAt(f.Ejercicio, i, 0);
                        TablaOpcionesCALL.setValueAt(f.Compra_Vol, i, 1);
                        TablaOpcionesCALL.setValueAt(f.Compra_Precio, i, 2);
                        TablaOpcionesCALL.setValueAt(f.Venta_Precio, i, 3);
                        TablaOpcionesCALL.setValueAt(f.Venta_Vol, i, 4);
                        TablaOpcionesCALL.setValueAt(f.Ultimo, i, 5);
                        TablaOpcionesCALL.setValueAt(f.Volumen, i, 6);
                        TablaOpcionesCALL.setValueAt(f.Hora, i, 7);
                        TablaOpcionesCALL.setValueAt(f.Vencimiento, i, 8);
                        break;
                    case "PUT":
                        TablaOpcionesPUT.setValueAt(f.Ejercicio, i, 0);
                        TablaOpcionesPUT.setValueAt(f.Compra_Vol, i, 1);
                        TablaOpcionesPUT.setValueAt(f.Compra_Precio, i, 2);
                        TablaOpcionesPUT.setValueAt(f.Venta_Precio, i, 3);
                        TablaOpcionesPUT.setValueAt(f.Venta_Vol, i, 4);
                        TablaOpcionesPUT.setValueAt(f.Ultimo, i, 5); 
                        TablaOpcionesPUT.setValueAt(f.Volumen, i, 6);
                        TablaOpcionesPUT.setValueAt(f.Hora, i, 7);
                        TablaOpcionesPUT.setValueAt(f.Vencimiento, i, 8);
                        break;
                }

            }
        }
    }

    private void tablaFuturos() {
        boolean futures = futuros.getFutures();
        updateConnectionStatus(futures);
        
        if (futures) {
        
            int nfuturos = futuros.Futuros.size();
            DefaultTableModel tablemodel = (DefaultTableModel)TablaFuturos.getModel();
            tablemodel.setRowCount(nfuturos);

            for(int i=0;i<nfuturos;i++){
                Futuro f = futuros.Futuros.get(i);
                TablaFuturos.setValueAt(f.Vencimiento, i, 0);
                TablaFuturos.setValueAt(f.Compra_Vol, i, 1);
                TablaFuturos.setValueAt(f.Compra_Precio, i, 2);
                TablaFuturos.setValueAt(f.Venta_Precio, i, 3);
                TablaFuturos.setValueAt(f.Venta_Vol, i, 4);
                TablaFuturos.setValueAt(f.Ultimo, i, 5);
                TablaFuturos.setValueAt(f.Volumen, i, 6);
                TablaFuturos.setValueAt(f.Apertura, i, 7);
                TablaFuturos.setValueAt(f.Maximo, i, 8);
                TablaFuturos.setValueAt(f.Minimo, i, 9);
                TablaFuturos.setValueAt(f.Anterior, i, 10);
                TablaFuturos.setValueAt(f.Hora, i, 11);
            }
        }
        //Notificaciones.setText("Datos disponibles");
    }

    private void tablaContado() {
        //Notificaciones.setText("Recolectando datos ....");
        // actualiza la tabla de contado
        boolean spot = contado.getSpot();
        updateConnectionStatus(spot);
        if (spot) {
        
            TableModel model = TablaContado.getModel();
            TablaContado.setValueAt(contado.Spot, 0, 0);
            TablaContado.setValueAt(contado.Anterior, 0, 2);
            TablaContado.setValueAt(contado.Maximo, 0, 3);
            TablaContado.setValueAt(contado.Minimo, 0, 4);
            TablaContado.setValueAt(contado.Fecha, 0, 5);
            TablaContado.setValueAt(contado.Hora, 0, 6);

            Float diferencia = toFloat(contado.Diferencia);
            if(diferencia > 0){
                model.setValueAt("<html><font color='green'>"+diferencia+"</font></html>", 0, 1);
            }
            else if(diferencia < 0){
                model.setValueAt("<html><font color='red'>"+diferencia+"</font></html>", 0, 1);
            }
            else{
                model.setValueAt("<html><font color='black'>"+diferencia+"</font></html>", 0, 1);
            }
        }
    }

    private void fillComboBoxes() {
        addDatesToBox();
    }

    private void addDatesToBox() {
        for (String fecha : opciones.getFechas()) {
            putComboBox.addItem(fecha);
            callComboBox.addItem(fecha);
        }
    }

    private void filter(String query, JTable table){
        dm = (DefaultTableModel) table.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
        table.setRowSorter(tr);
        if(!query.equals("None")){
            tr.setRowFilter(RowFilter.regexFilter(query));
        }else{
            table.setRowSorter(tr);
        }  
    }
        
}


