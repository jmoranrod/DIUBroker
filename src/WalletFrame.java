
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class WalletFrame extends JInternalFrame {
    
    private static int walletNumber = 0;
    private JPanel panel = new JPanel();
    private JTable jTable = new JTable(dataModel());
    private JScrollPane jScrollPane = new JScrollPane(jTable);

    public WalletFrame() {
        super("Wallet #"+(++walletNumber),      // name
                true,                           // resizable
                false,                          // closable
                false,                          // maximizable
                true);                          // iconifiable
        setPreferredSize(new Dimension(550, 250));
        pack();
        setLocation(880, 90*walletNumber);
        panel.setLayout(new BorderLayout());
        this.setContentPane(panel);
        panel.add(jScrollPane, BorderLayout.CENTER);
        
        
    }

    public WalletFrame(String title) {
        super(title,
                true,
                false,
                false,
                true);
        setPreferredSize(new Dimension(550, 250));
        ++walletNumber;
        pack();
        setLocation(880, 90*walletNumber);
        panel.setLayout(new BorderLayout());
        this.setContentPane(panel);
        panel.add(jScrollPane, BorderLayout.CENTER);
    }

    private DefaultTableModel dataModel() {
        DefaultTableModel tm = new DefaultTableModel();
        createColumns(tm);
        return tm;
    }

    private void createColumns(DefaultTableModel tm) {
        tm.addColumn("Nº. Opciones");
        tm.addColumn("T. Opción");
        tm.addColumn("F. Vencimiento");
        tm.addColumn("P. Ejercicio");
        tm.addColumn("F. Entrada a Cartera");
        tm.addColumn("P. Compra de mercado");
    }
    
    public void addOptionsToTable(int optionsNumber, Opcion opcion){
        //System.out.println("Estoy aqui");
        DefaultTableModel tablemodel = (DefaultTableModel) jTable.getModel();
        tablemodel.setRowCount(optionsNumber);
        if(opcion == null) return;
        jTable.setValueAt(1, optionsNumber - 1, 0); //comprobar en la lista si coinciden 2 opciones
        jTable.setValueAt(opcion.Tipo, optionsNumber - 1, 1);
        jTable.setValueAt(opcion.Vencimiento, optionsNumber - 1, 2);
        jTable.setValueAt(opcion.Ejercicio, optionsNumber - 1, 3);
        jTable.setValueAt(getDate(), optionsNumber - 1, 4);
        jTable.setValueAt(opcion.Compra_Precio, optionsNumber - 1, 5);
        /*        
        for (Opcion opcion : optionList) {
            jTable.setValueAt(1, 0, 0); //comprobar en la lista si coinciden 2 opciones
            jTable.setValueAt(opcion.Tipo, 0, 1);
            jTable.setValueAt(opcion.Vencimiento, 0, 2);
            jTable.setValueAt(opcion.Ejercicio, 0, 3);
            jTable.setValueAt(getDate(), 0, 4);
            jTable.setValueAt(opcion.Compra_Precio, 0, 5);
        }
        */
    }

    private String getDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String formatedDate = sdf.format(date);
        return formatedDate;
    }
    
    
}
