
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class MainFrame extends JFrame {
    private WalletOption walletOption;
    private boolean isCall;
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        
        
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        /*createWallet.setActionCommand("createWallet");
        createWallet.addActionListener(this);*/
        Fecha.setEditable(false);
        addPUTOptionToWallet.setEnabled(false);
        this.setLocationRelativeTo(null);
        addToWalletDialog.setLocationRelativeTo(null);
        createWalletDialog.setLocationRelativeTo(null);
        hideColumns();
        // Añade un listener para obtener el contenido de las filas. 
        TablaOpcionesPUT.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(TablaOpcionesPUT.getSelectedRow() < 0)
                    addPUTOptionToWallet.setEnabled(false);
                else
                    addPUTOptionToWallet.setEnabled(true);
            }
        });
        
        connectionStatusButton.setContentAreaFilled(false);
        connectionStatusButton.setOpaque(true);
        fillCombobox();
        
        setDate();
        Timer timDate = new Timer(1000,new ActionListener(){ // 1 segundo
            @Override
            public void actionPerformed(ActionEvent evt){
                setDate();
            }
        });
        timDate.start();
        
        CollectData();
        Timer timData = new Timer(180000,new ActionListener(){ // 3 minutos
            @Override
            public void actionPerformed(ActionEvent evt){
                CollectData();
                updateWallets();
            }
        });
        timData.start();
        
        Timer refreshTimer = new Timer(1000,new ActionListener(){ // 1 segundo
            @Override
            public void actionPerformed(ActionEvent evt){
                if (Escritorio.getSelectedFrame() instanceof WalletFrame) {
                    String selected = Escritorio.getSelectedFrame().getName();
                    for (Wallet wallet : walletList) {
                        if (wallet.getName().equals(selected)) {
                            updateLabels(wallet);
                            break;
                        }
                    }
                    
                }
            }
        });
        refreshTimer.start();
        
    }
    
    
    private void testWallets() {
        Wallet wallet  = new Wallet("asd");
        
        wallet.getWalletIO().writeToFile("SD2");
        wallet.getWalletIO().writeToFile("SD2");
        wallet.getWalletIO().writeToFile("SD2");
        wallet.getWalletIO().writeToFile("SD2");
        wallet.getWalletIO().writeToFile("SD2");
        
        System.out.println("SIIIU");
        printWallet(wallet);
        int nWallets = findWallets().length;
        System.out.println(nWallets);
        
    }
    
    private void printWallet(Wallet wallet){
        List walletItems = wallet.getWalletIO().readFromFile();
        int walletSize = walletItems.size();
        for (int i = 0; i < walletSize; i++) {
            System.out.println(walletItems.get(i));
        }
    }
        
    private File[] findWallets(){
        File f = new File(".");
        File[] matchingFiles = f.listFiles(new FilenameFilter() {
        public boolean accept(File dir, String name) {
            return name.endsWith(".dbr");
            }
        });
        return matchingFiles;
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

    private void hideColumns() {
        /* OCULTA LAS COLUMNAS DEL VENCIMIENTO */
        TablaOpcionesPUT.getColumnModel().getColumn(8).setMinWidth(0);
        TablaOpcionesPUT.getColumnModel().getColumn(8).setMaxWidth(0);
        TablaOpcionesPUT.getColumnModel().getColumn(8).setWidth(0);
        
        TablaOpcionesCALL.getColumnModel().getColumn(8).setMinWidth(0);
        TablaOpcionesCALL.getColumnModel().getColumn(8).setMaxWidth(0);
        TablaOpcionesCALL.getColumnModel().getColumn(8).setWidth(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addToWalletDialog = new javax.swing.JDialog();
        walletSelector = new javax.swing.JComboBox();
        walletLabel = new javax.swing.JLabel();
        acceptButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        nOptionsLabel = new javax.swing.JLabel();
        numberOfOptions = new javax.swing.JTextField();
        createWalletDialog = new javax.swing.JDialog();
        walletNameLabel = new javax.swing.JLabel();
        walletNameTextField = new javax.swing.JTextField();
        acceptWalletNameButton = new javax.swing.JButton();
        cancelWalletNameButton = new javax.swing.JButton();
        fileChooser = new javax.swing.JFileChooser();
        deleteWalletDialog = new javax.swing.JDialog();
        deleteLabel = new javax.swing.JLabel();
        deleteComboBox = new javax.swing.JComboBox();
        deleteAcceptButton = new javax.swing.JButton();
        deleteCancelButton = new javax.swing.JButton();
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
        addCallOptionToWallet = new javax.swing.JButton();
        VentanaOpcionesPUT = new javax.swing.JInternalFrame();
        putComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaOpcionesPUT = new javax.swing.JTable();
        addPUTOptionToWallet = new javax.swing.JButton();
        topPanel = new javax.swing.JPanel();
        Fecha = new javax.swing.JTextField();
        connectionStatusButton = new javax.swing.JButton();
        connectionStateLabel = new javax.swing.JLabel();
        importLabel = new javax.swing.JLabel();
        walletValueLabel = new javax.swing.JLabel();
        earningsLabel = new javax.swing.JLabel();
        BarraMenu = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exit = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        deleteButton = new javax.swing.JMenuItem();
        walletMenu = new javax.swing.JMenu();
        createWallet = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        openWalletMenuButton = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        addToWalletDialog.setTitle("Añadir a Opción a Cartera");
        addToWalletDialog.setMinimumSize(new java.awt.Dimension(315, 162));
        addToWalletDialog.setResizable(false);

        walletLabel.setText("Seleccionar cartera:");

        acceptButton.setText("Aceptar");
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        nOptionsLabel.setText("Número de opciones:");

        numberOfOptions.setText("1");

        javax.swing.GroupLayout addToWalletDialogLayout = new javax.swing.GroupLayout(addToWalletDialog.getContentPane());
        addToWalletDialog.getContentPane().setLayout(addToWalletDialogLayout);
        addToWalletDialogLayout.setHorizontalGroup(
            addToWalletDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addToWalletDialogLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(acceptButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(cancelButton)
                .addGap(64, 64, 64))
            .addGroup(addToWalletDialogLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(addToWalletDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(walletLabel)
                    .addComponent(nOptionsLabel))
                .addGap(36, 36, 36)
                .addGroup(addToWalletDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(walletSelector, 0, 110, Short.MAX_VALUE)
                    .addComponent(numberOfOptions))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addToWalletDialogLayout.setVerticalGroup(
            addToWalletDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addToWalletDialogLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(addToWalletDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nOptionsLabel)
                    .addComponent(numberOfOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(addToWalletDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(walletLabel)
                    .addComponent(walletSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(addToWalletDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acceptButton)
                    .addComponent(cancelButton))
                .addGap(27, 27, 27))
        );

        createWalletDialog.setTitle("Crear cartera");
        createWalletDialog.setMinimumSize(new java.awt.Dimension(330, 119));

        walletNameLabel.setText("Introducir nombre de cartera:");

        acceptWalletNameButton.setText("Aceptar");
        acceptWalletNameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptWalletNameButtonActionPerformed(evt);
            }
        });

        cancelWalletNameButton.setText("Cancelar");
        cancelWalletNameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelWalletNameButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout createWalletDialogLayout = new javax.swing.GroupLayout(createWalletDialog.getContentPane());
        createWalletDialog.getContentPane().setLayout(createWalletDialogLayout);
        createWalletDialogLayout.setHorizontalGroup(
            createWalletDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createWalletDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(createWalletDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(walletNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createWalletDialogLayout.createSequentialGroup()
                        .addComponent(acceptWalletNameButton)
                        .addGap(31, 31, 31)))
                .addGroup(createWalletDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(createWalletDialogLayout.createSequentialGroup()
                        .addComponent(walletNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createWalletDialogLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(cancelWalletNameButton)
                        .addGap(58, 58, 58))))
        );
        createWalletDialogLayout.setVerticalGroup(
            createWalletDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createWalletDialogLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(createWalletDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(walletNameLabel)
                    .addComponent(walletNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(createWalletDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acceptWalletNameButton)
                    .addComponent(cancelWalletNameButton))
                .addGap(21, 21, 21))
        );

        deleteWalletDialog.setTitle("Eliminar cartera");
        deleteWalletDialog.setMaximumSize(new java.awt.Dimension(400, 183));
        deleteWalletDialog.setMinimumSize(new java.awt.Dimension(400, 183));

        deleteLabel.setText("Nombre de la cartera: ");

        deleteAcceptButton.setText("Aceptar");
        deleteAcceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAcceptButtonActionPerformed(evt);
            }
        });

        deleteCancelButton.setText("Cancelar");
        deleteCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout deleteWalletDialogLayout = new javax.swing.GroupLayout(deleteWalletDialog.getContentPane());
        deleteWalletDialog.getContentPane().setLayout(deleteWalletDialogLayout);
        deleteWalletDialogLayout.setHorizontalGroup(
            deleteWalletDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteWalletDialogLayout.createSequentialGroup()
                .addGroup(deleteWalletDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(deleteWalletDialogLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(deleteLabel))
                    .addGroup(deleteWalletDialogLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(deleteAcceptButton)))
                .addGap(73, 73, 73)
                .addGroup(deleteWalletDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deleteWalletDialogLayout.createSequentialGroup()
                        .addComponent(deleteCancelButton)
                        .addGap(12, 12, 12)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        deleteWalletDialogLayout.setVerticalGroup(
            deleteWalletDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteWalletDialogLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(deleteWalletDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteLabel)
                    .addComponent(deleteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(deleteWalletDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteAcceptButton)
                    .addComponent(deleteCancelButton))
                .addContainerGap(51, Short.MAX_VALUE))
        );

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
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
        );
        VentanaFuturosLayout.setVerticalGroup(
            VentanaFuturosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
        );

        VentanaOpcionesCALL.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        VentanaOpcionesCALL.setIconifiable(true);
        VentanaOpcionesCALL.setTitle("Opciones IBEX35 - CALL");
        VentanaOpcionesCALL.setToolTipText("Opciones CALL del IBEX35");
        VentanaOpcionesCALL.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        addCallOptionToWallet.setText("Añadir a cartera");
        addCallOptionToWallet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCallOptionToWalletActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout VentanaOpcionesCALLLayout = new javax.swing.GroupLayout(VentanaOpcionesCALL.getContentPane());
        VentanaOpcionesCALL.getContentPane().setLayout(VentanaOpcionesCALLLayout);
        VentanaOpcionesCALLLayout.setHorizontalGroup(
            VentanaOpcionesCALLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaOpcionesCALLLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addCallOptionToWallet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(callComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
        );
        VentanaOpcionesCALLLayout.setVerticalGroup(
            VentanaOpcionesCALLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaOpcionesCALLLayout.createSequentialGroup()
                .addGroup(VentanaOpcionesCALLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VentanaOpcionesCALLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(callComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGroup(VentanaOpcionesCALLLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(addCallOptionToWallet, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addContainerGap())
        );

        VentanaOpcionesPUT.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        VentanaOpcionesPUT.setIconifiable(true);
        VentanaOpcionesPUT.setTitle("Opciones IBEX35 - PUT");
        VentanaOpcionesPUT.setToolTipText("Opciones PUT del IBEX35");
        VentanaOpcionesPUT.setMaximumSize(new java.awt.Dimension(450, 2147483647));
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

        addPUTOptionToWallet.setText("Añadir a cartera");
        addPUTOptionToWallet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPUTOptionToWalletActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout VentanaOpcionesPUTLayout = new javax.swing.GroupLayout(VentanaOpcionesPUT.getContentPane());
        VentanaOpcionesPUT.getContentPane().setLayout(VentanaOpcionesPUTLayout);
        VentanaOpcionesPUTLayout.setHorizontalGroup(
            VentanaOpcionesPUTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VentanaOpcionesPUTLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addPUTOptionToWallet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(putComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addComponent(jScrollPane4)
        );
        VentanaOpcionesPUTLayout.setVerticalGroup(
            VentanaOpcionesPUTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaOpcionesPUTLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(VentanaOpcionesPUTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addPUTOptionToWallet)
                    .addComponent(jLabel2)
                    .addComponent(putComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
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
                        .addComponent(VentanaFuturos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                        .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EscritorioLayout.createSequentialGroup()
                        .addGroup(EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(VentanaContado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VentanaOpcionesPUT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(VentanaOpcionesCALL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EscritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VentanaFuturos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(VentanaContado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(VentanaOpcionesPUT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VentanaOpcionesCALL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(343, 343, 343))
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

        connectionStateLabel.setText("Estado de conexión: ");

        importLabel.setText("Importe invertido: ");

        walletValueLabel.setText("Valor actual de la cartera: ");

        earningsLabel.setText("Ganancia de la cartera: ");

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(importLabel)
                .addGap(110, 110, 110)
                .addComponent(walletValueLabel)
                .addGap(114, 114, 114)
                .addComponent(earningsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(connectionStateLabel)
                .addGap(39, 39, 39)
                .addComponent(connectionStatusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(topPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(connectionStateLabel)
                            .addComponent(importLabel)
                            .addComponent(walletValueLabel)
                            .addComponent(earningsLabel)))
                    .addGroup(topPanelLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(connectionStatusButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(topPanelLayout.createSequentialGroup()
                                .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        fileMenu.setText("Archivo");

        exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        exit.setText("Salir");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        fileMenu.add(exit);

        BarraMenu.add(fileMenu);

        editMenu.setText("Editar");

        deleteButton.setText("Eliminar opción");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        editMenu.add(deleteButton);

        BarraMenu.add(editMenu);

        walletMenu.setText("Cartera");

        createWallet.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK));
        createWallet.setText("Crear cartera");
        createWallet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createWalletActionPerformed(evt);
            }
        });
        walletMenu.add(createWallet);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem2.setText("Cerrar cartera");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        walletMenu.add(jMenuItem2);

        openWalletMenuButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK));
        openWalletMenuButton.setText("Abrir cartera");
        openWalletMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openWalletMenuButtonActionPerformed(evt);
            }
        });
        walletMenu.add(openWalletMenuButton);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem1.setText("Eliminar cartera");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        walletMenu.add(jMenuItem1);

        BarraMenu.add(walletMenu);

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
        String query = putComboBox.getSelectedItem().toString();
        filter(query, TablaOpcionesPUT);
    }//GEN-LAST:event_putComboBoxItemStateChanged

    private void callComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_callComboBoxItemStateChanged
        String query = callComboBox.getSelectedItem().toString();
        filter(query, TablaOpcionesCALL);
    }//GEN-LAST:event_callComboBoxItemStateChanged

    private void createWalletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createWalletActionPerformed
        createWalletDialog.setVisible(true);
    }//GEN-LAST:event_createWalletActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        this.addToWalletDialog.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed
        for (Wallet wallet : walletList) {
            if(wallet.getName().equals(walletSelector.getSelectedItem().toString())){
                Opcion opcion;
                if (isCall) {
                    opcion = getSelectedRow(TablaOpcionesCALL.getSelectedRow(), TablaOpcionesCALL);
                    opcion.Tipo = "CALL";
                }else{
                    opcion = getSelectedRow(TablaOpcionesPUT.getSelectedRow(), TablaOpcionesPUT);
                    opcion.Tipo = "PUT";
                }
                opcion.setCantidad(numberOfOptions.getText());
                WalletOption option = new WalletOption(numberOfOptions.getText(), opcion.Tipo, formatDate(opcion.Vencimiento), opcion.Ejercicio, opcion.getDate(), opcion.Compra_Precio, opcion.Venta_Precio);
                wallet.updateFrame(option);
                updateLabels(wallet);
                wallet.getWalletIO().writeToFile(option.toString());
            }
        }
        addToWalletDialog.setVisible(false);
    }//GEN-LAST:event_acceptButtonActionPerformed

    private void updateLabels(Wallet wallet) {
        earningsLabel.setText("Ganancias de la cartera: " + wallet.getEarnings());
        if (wallet.getEarnings() < 0f) {
            earningsLabel.setForeground(Color.red);
        }else{
            earningsLabel.setForeground(Color.green);
        }
        walletValueLabel.setText("Valor actual de la cartera: " + wallet.getValue());
        importLabel.setText("Importe invertido: " + wallet.getInverted());
    }

    private void addPUTOptionToWalletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPUTOptionToWalletActionPerformed
        this.addToWalletDialog.setVisible(true);
        isCall = false;
    }//GEN-LAST:event_addPUTOptionToWalletActionPerformed

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

    private void cancelWalletNameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelWalletNameButtonActionPerformed
        createWalletDialog.setVisible(false);
    }//GEN-LAST:event_cancelWalletNameButtonActionPerformed

    private void acceptWalletNameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptWalletNameButtonActionPerformed
        if(!walletNameTextField.getText().isEmpty()){
            Wallet wallet = new Wallet(walletNameTextField.getText());
            walletList.add(wallet);
            
            wallet.getFrame().setVisible(true);
            Escritorio.add(wallet.getFrame());
            fillCombobox();
            try {
                wallet.getFrame().setSelected(true);
            } catch (Exception e) {
            }
        }else{
            JOptionPane.showMessageDialog(this, "Nombre de la cartera inválido", "Error", JOptionPane.ERROR_MESSAGE);
        }
        createWalletDialog.setVisible(false);
    }//GEN-LAST:event_acceptWalletNameButtonActionPerformed


    private void openWalletMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openWalletMenuButtonActionPerformed
        fileChooser.setCurrentDirectory(new File("."));
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivo de cartera", "dbr"));
        if(evt.getSource() == openWalletMenuButton){
            int returnValue = fileChooser.showOpenDialog(this);
            if(returnValue == fileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                if (walletList.isEmpty()) {
                    openWallet(file);
                    
                }else{
                    for (int i = 0; i < walletList.size(); i++) {
                        if (file.getName().substring(0, file.getName().length() - 4).equals(walletList.get(i).getName())) {
                            break;
                        }
                        if (i == walletList.size()-1) {
                            openWallet(file);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_openWalletMenuButtonActionPerformed

    private void openWallet(File file) throws HeadlessException {
        if(file.getPath().contains(".dbr")){
            Wallet wallet = createWallet(file.getName().substring(0, file.getName().length() - 4));
            List<String> lines = wallet.getWalletIO().readFromFile();
            for (String line : lines) {
                if(line.contains(" ")){
                    String[] optionFields = line.split("\\s");
                    String vencimiento = optionFields[2];
                    walletOption = new WalletOption(optionFields[0], optionFields[1], vencimiento, optionFields[3], optionFields[4], optionFields[5], optionFields[6]);

                    String[] date = walletOption.getVencimiento().split("/");
                    LocalDateTime dateTime = LocalDateTime.now();
                    LocalDate today = dateTime.toLocalDate();
                    LocalDate fechaVencimiento = LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));

                    if (fechaVencimiento.compareTo(today) >= 0) {
                        wallet.updateFrame(walletOption);
                    }
                }
            }
            for (String line : lines) {
                if(line.contains(" ")){
                    String[] optionFields = line.split("\\s");
                    String vencimiento = optionFields[2];
                    walletOption = new WalletOption(optionFields[0], optionFields[1], vencimiento, optionFields[3], optionFields[4], optionFields[5], optionFields[6]);

                    String[] date = walletOption.getVencimiento().split("/");
                    LocalDateTime dateTime = LocalDateTime.now();
                    LocalDate today = dateTime.toLocalDate();
                    LocalDate fechaVencimiento = LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));

                    if (fechaVencimiento.compareTo(today) <= 0) {
                        wallet.getWalletIO().removeLine(lines.indexOf(line));
                        lines = wallet.getWalletIO().readFromFile();
                    }
                }
            }
            updateWallets();
            updateLabels(wallet);
        }else{
            JOptionPane.showMessageDialog(this, "Esta aplicación utiliza archivos .dbr", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addCallOptionToWalletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCallOptionToWalletActionPerformed
        this.addToWalletDialog.setVisible(true);
        isCall = true;
    }//GEN-LAST:event_addCallOptionToWalletActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if(Escritorio.getSelectedFrame() instanceof WalletFrame){
            WalletFrame frame = (WalletFrame) Escritorio.getSelectedFrame();
            DefaultTableModel model = (DefaultTableModel) frame.getjTable().getModel();
            String row = frame.getRow(frame.getjTable().getSelectedRow());
            int rowNumber = frame.getjTable().getSelectedRow();
            model.removeRow(frame.getjTable().getSelectedRow());
            String walletName = frame.getName();
            for (int i = 0; i < walletList.size(); i++) {
                if (walletList.get(i).getName().equals(walletName)) {
                    walletList.get(i).getwOptions().remove(rowNumber);
                    walletList.get(i).getWalletIO().removeLine(rowNumber);
                }
            }
            frame.setTableIndex(frame.getTableIndex()-1);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.deleteWalletDialog.setVisible(true);
        deleteWalletDialog.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void deleteAcceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAcceptButtonActionPerformed
        int dialogConfirm = JOptionPane.showConfirmDialog(deleteWalletDialog, "Al eliminar la cartera se borrará el archivo del disco. ¿Está seguro de querer eliminar?", "Advertencia", JOptionPane.YES_NO_CANCEL_OPTION);
        if (dialogConfirm == JOptionPane.YES_OPTION) {
            String walletToDelete = deleteComboBox.getSelectedItem().toString();
            for (Wallet wallet : walletList) {
                if (wallet.getName().equals(walletToDelete)) {
                    wallet.getFrame().dispose();
                    wallet.getWalletIO().removeFile();
                    walletList.remove(wallet);
                    fillCombobox();
                }
            }
            this.deleteWalletDialog.setVisible(false);
        } else if (dialogConfirm == JOptionPane.CANCEL_OPTION){
            this.deleteWalletDialog.setVisible(false);
        }
    }//GEN-LAST:event_deleteAcceptButtonActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        for (Wallet wallet : walletList) {
            if (wallet.getFrame().getName().equals(Escritorio.getSelectedFrame().getName())) {
                walletList.remove(wallet);
                fillCombobox();
                Escritorio.getSelectedFrame().dispose();
            }
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void deleteCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCancelButtonActionPerformed
        this.deleteWalletDialog.setVisible(false);
    }//GEN-LAST:event_deleteCancelButtonActionPerformed

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
    private javax.swing.JButton acceptButton;
    private javax.swing.JButton acceptWalletNameButton;
    private javax.swing.JButton addCallOptionToWallet;
    private javax.swing.JButton addPUTOptionToWallet;
    private javax.swing.JDialog addToWalletDialog;
    private javax.swing.JComboBox callComboBox;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton cancelWalletNameButton;
    private javax.swing.JLabel connectionStateLabel;
    private javax.swing.JButton connectionStatusButton;
    private javax.swing.JMenuItem createWallet;
    private javax.swing.JDialog createWalletDialog;
    private javax.swing.JButton deleteAcceptButton;
    private javax.swing.JMenuItem deleteButton;
    private javax.swing.JButton deleteCancelButton;
    private javax.swing.JComboBox deleteComboBox;
    private javax.swing.JLabel deleteLabel;
    private javax.swing.JDialog deleteWalletDialog;
    private javax.swing.JLabel earningsLabel;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exit;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel importLabel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel nOptionsLabel;
    private javax.swing.JTextField numberOfOptions;
    private javax.swing.JMenuItem openWalletMenuButton;
    private javax.swing.JComboBox putComboBox;
    private javax.swing.JPanel topPanel;
    private javax.swing.JLabel walletLabel;
    private javax.swing.JMenu walletMenu;
    private javax.swing.JLabel walletNameLabel;
    private javax.swing.JTextField walletNameTextField;
    private javax.swing.JComboBox walletSelector;
    private javax.swing.JLabel walletValueLabel;
    // End of variables declaration//GEN-END:variables

    private MEFF_Contado contado = new MEFF_Contado();
    private MEFF_Futuros futuros = new MEFF_Futuros();
    private MEFF_Opciones opciones = new MEFF_Opciones();
    private ArrayList optionsToWallet = new ArrayList();
    private List<Wallet> walletList = new LinkedList<>();
    private DefaultTableModel dm;

    private void setDate(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss ");
        String formatedDate = sdf.format(date);
        formatedDate = formatedDate.concat(" (local)");
        Fecha.setText(formatedDate);
    }

    private String formatDate(String vencimiento){   
        String[] list = vencimiento.split("\\s");
        String month = list[1];
        switch (month){
            case "ene" : list[1] = "01";
                break;
            case "feb" : list[1] = "02";
                break;
            case "mar" : list[1] = "03";
                break;
            case "abr" : list[1] = "04";
                break;
            case "may" : list[1] = "05";
                break;
            case "jun" : list[1] = "06";
                break;
            case "jul" : list[1] = "07";
                break;
            case "ago" : list[1] = "08";
                break;
            case "sep" : list[1] = "09";
                break;
            case "oct" : list[1] = "10";
                break;
            case "nov" : list[1] = "11";
                break;
            case "dic" : list[1] = "12";
                break;
        }
        return list[0]+ "/" + list[1] + "/" + list[2];
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
    
    private void tablaOpciones() {
        boolean connectionStatus = opciones.getOptions();
        updateConnectionStatus(connectionStatus);
        
        if (connectionStatus) {
            opciones.getOptions();
            int nOpcionesCALL = calculateOptions("CALL");
            int nOpcionesPUT = calculateOptions("PUT");
            int nopciones = opciones.Opciones.size();
            DefaultTableModel tablemodel = (DefaultTableModel) TablaOpcionesCALL.getModel();
            tablemodel.setRowCount(nOpcionesCALL);
            tablemodel = (DefaultTableModel) TablaOpcionesPUT.getModel();
            tablemodel.setRowCount(nOpcionesPUT);
            int index = 0, tableIndex = 0;
            populateCALLTable(index, nopciones, tableIndex, nOpcionesCALL);
            populatePUTTable(index, nopciones, tableIndex, nOpcionesPUT);
            
        }
    }

    private void populateCALLTable(int index, int nopciones, int tableIndex, int nOpcionesCALL) {
        while((index < nopciones) && (tableIndex < nOpcionesCALL)){
            if(opciones.Opciones.get(index).Tipo.equals("CALL")){
                TablaOpcionesCALL.setValueAt(opciones.Opciones.get(index).Ejercicio, tableIndex, 0);
                TablaOpcionesCALL.setValueAt(opciones.Opciones.get(index).Compra_Vol, tableIndex, 1);
                TablaOpcionesCALL.setValueAt(opciones.Opciones.get(index).Compra_Precio, tableIndex, 2);
                TablaOpcionesCALL.setValueAt(opciones.Opciones.get(index).Venta_Precio, tableIndex, 3);
                TablaOpcionesCALL.setValueAt(opciones.Opciones.get(index).Venta_Vol, tableIndex, 4);
                TablaOpcionesCALL.setValueAt(opciones.Opciones.get(index).Ultimo, tableIndex, 5);
                TablaOpcionesCALL.setValueAt(opciones.Opciones.get(index).Volumen, tableIndex, 6);
                TablaOpcionesCALL.setValueAt(opciones.Opciones.get(index).Hora, tableIndex, 7);
                TablaOpcionesCALL.setValueAt(opciones.Opciones.get(index).Vencimiento, tableIndex, 8);
                tableIndex++;
                index++;
            }else{
                index++;
            }
        }
    }

    private void populatePUTTable(int index, int nopciones, int tableIndex, int nOpcionesPUT) {
        while((index < nopciones) && (tableIndex < nOpcionesPUT)){
            if(opciones.Opciones.get(index).Tipo.equals("PUT")){
                TablaOpcionesPUT.setValueAt(opciones.Opciones.get(index).Ejercicio, tableIndex, 0);
                TablaOpcionesPUT.setValueAt(opciones.Opciones.get(index).Compra_Vol, tableIndex, 1);
                TablaOpcionesPUT.setValueAt(opciones.Opciones.get(index).Compra_Precio, tableIndex, 2);
                TablaOpcionesPUT.setValueAt(opciones.Opciones.get(index).Venta_Precio, tableIndex, 3);
                TablaOpcionesPUT.setValueAt(opciones.Opciones.get(index).Venta_Vol, tableIndex, 4);
                TablaOpcionesPUT.setValueAt(opciones.Opciones.get(index).Ultimo, tableIndex, 5);
                TablaOpcionesPUT.setValueAt(opciones.Opciones.get(index).Volumen, tableIndex, 6);
                TablaOpcionesPUT.setValueAt(opciones.Opciones.get(index).Hora, tableIndex, 7);
                TablaOpcionesPUT.setValueAt(opciones.Opciones.get(index).Vencimiento, tableIndex, 8);
                tableIndex++;
                index++;
            }else{
                index++;
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
            //Notificaciones.setText("Datos disponibles");
        }

    }

    private void tablaContado() {
        boolean spot = contado.getSpot();
        updateConnectionStatus(spot);
        if (spot) {
            //Notificaciones.setText("Recolectando datos ....");

            // actualiza la tabla de contado
            contado.getSpot();
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

    private Wallet createWallet(String name) {
        Wallet wallet = new Wallet(name);
        wallet.getFrame().setVisible(true);
        Escritorio.add(wallet.getFrame());
        walletList.add(wallet);
        fillCombobox();
        try {
            wallet.getFrame().setSelected(true);
        } catch (Exception e) {
        }
        return wallet;
    }

    private int calculateOptions(String tipo) {
        int value = 0;
        for (Opcion opcion : opciones.Opciones) {
            if(opcion.Tipo.equals(tipo)) value++;
        }
        return value;
    }
    
    private Opcion getSelectedRow(int selectedRow, JTable table) {
        Opcion opcion = new Opcion();
        opcion.Ejercicio = table.getValueAt(selectedRow, 0).toString();
        opcion.Vencimiento = table.getValueAt(selectedRow, 8).toString();
        opcion.Compra_Precio = table.getValueAt(selectedRow, 2).toString();
        opcion.Venta_Precio = table.getValueAt(selectedRow, 3).toString();
        optionsToWallet.add(opcion);
        return opcion;
    }

    private void fillCombobox() {
        walletSelector.removeAllItems();
        deleteComboBox.removeAllItems();
        for (Wallet wallet : walletList) {
            walletSelector.addItem(wallet.getName());
            deleteComboBox.addItem(wallet.getName());
        }
    }

    private void updateWallets(){
        String tipo ="";
        String ejercicio="";
        String fecha="";
        LocalDate today;
        for (Wallet wallet : walletList) {
            for (WalletOption option : wallet.getwOptions()) {
                tipo = option.getTipo();
                ejercicio = option.getEjercicio();
                fecha = option.getVencimiento();
                String precioNuevo = searchOption(ejercicio, tipo, fecha);
                updateOption(wallet, precioNuevo, ejercicio, fecha);
            }
        }
    }

    private String searchOption(String ejercicio, String tipo, String fecha) {
        if (tipo.equals("CALL")) {
            for (int i = 0; i < TablaOpcionesCALL.getModel().getRowCount(); i++) {
                String ejercicioTabla = TablaOpcionesCALL.getModel().getValueAt(i, 0).toString();
                String fechaTabla = TablaOpcionesCALL.getModel().getValueAt(i, 8).toString();
                fechaTabla = formatDate(fechaTabla);
                if (ejercicioTabla.trim().equals(ejercicio) && fecha.compareTo(fechaTabla) == 0) {
                    return TablaOpcionesCALL.getModel().getValueAt(i, 2).toString();
                }
            }
        }else{
            for (int i = 0; i < TablaOpcionesPUT.getModel().getRowCount(); i++) {
                String ejercicioTabla = TablaOpcionesPUT.getModel().getValueAt(i, 0).toString();
                String fechaTabla = TablaOpcionesPUT.getModel().getValueAt(i, 8).toString();
                fechaTabla = formatDate(fechaTabla);
                if (ejercicioTabla.trim().equals(ejercicio) && fecha.compareTo(fechaTabla) == 0) {
                    return TablaOpcionesPUT.getModel().getValueAt(i, 2).toString();
                }
            }
        }
        return "-";
    }

    private void updateOption(Wallet wallet, String precioNuevo, String ejercicio, String fecha) {
        String fila ="";
        for (WalletOption option : wallet.getwOptions()) {
            if (option.getEjercicio().equals(ejercicio) && option.getVencimiento().compareTo(fecha) == 0) {
                if (!option.getPrecioCompra().equals(precioNuevo)) {
                    option.setPrecioCompra(precioNuevo);
                    for (int i = 0; i < wallet.getFrame().getjTable().getModel().getRowCount(); i++) {
                        String ejerTabla = wallet.getFrame().getjTable().getModel().getValueAt(i, 3).toString();
                        String fechaTabla = wallet.getFrame().getjTable().getModel().getValueAt(i, 2).toString();
                        if (ejerTabla.equals(ejercicio) && fechaTabla.equals(fecha)) {
                            wallet.getFrame().getjTable().setValueAt(precioNuevo, i, 5);
                            for (int j = 0; j < wallet.getFrame().getjTable().getModel().getColumnCount(); j++) {
                                if (wallet.getFrame().getjTable().getValueAt(i, j).toString().equals(" ")) {
                                    fila += "- ";
                                }else if (wallet.getFrame().getjTable().getValueAt(i, j).toString().contains("-")){
                                    fila += "- ";
                                }else{
                                    fila += wallet.getFrame().getjTable().getValueAt(i, j).toString() + " ";
                                }
                            }
                            fila.trim();
                            wallet.getWalletIO().writeToFile(fila);
                            wallet.getWalletIO().removeLine(i+1);
                        }
                    }
                }
            }
        }
    }
}
