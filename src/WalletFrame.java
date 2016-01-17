import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
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
    private int tableIndex;

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
        //setLocation(880, 90+(walletNumber * 2));
        panel.setLayout(new BorderLayout());
        this.setContentPane(panel);
        panel.add(jScrollPane, BorderLayout.CENTER);
    }

    public void setTableIndex(int tableIndex) {
        this.tableIndex = tableIndex;
    }

    public int getTableIndex() {
        return tableIndex;
    }
    
    public JTable getjTable() {
        return jTable;
    }
    
    public String getRow(int index){
        return (String) jTable.getValueAt(index, 0) + " " +
               jTable.getValueAt(index, 1) + " " +
               jTable.getValueAt(index, 2) + " " + 
               jTable.getValueAt(index, 3) + " " +
               jTable.getValueAt(index, 4) + " " +
               jTable.getValueAt(index, 5) + "  ";
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
        tm.addColumn("P. Venta de mercado");
    }
    
    public void addOptionsToTable(int rowCount, Opcion opcion){
        DefaultTableModel tablemodel = (DefaultTableModel) jTable.getModel();
        tablemodel.setRowCount(rowCount);
        if(opcion == null) return;
        jTable.setValueAt(opcion.cantidad, rowCount - 1, 0); //comprobar en la lista si coinciden 2 opciones
        jTable.setValueAt(opcion.Tipo, rowCount - 1, 1);
        jTable.setValueAt(opcion.Vencimiento, rowCount - 1, 2);
        jTable.setValueAt(opcion.Ejercicio, rowCount - 1, 3);
        jTable.setValueAt(getDate(), rowCount - 1, 4);
        jTable.setValueAt(opcion.Compra_Precio, rowCount - 1, 5);
        jTable.setValueAt(opcion.Venta_Precio, rowCount-1, 6);
    }
    
    public void addOptionsToTable(int rowCount, WalletOption opcion){
        DefaultTableModel tablemodel = (DefaultTableModel) jTable.getModel();
        tablemodel.setRowCount(rowCount);
        if(opcion == null) return;
        jTable.setValueAt(opcion.getCantidad(), tableIndex, 0); //comprobar en la lista si coinciden 2 opciones
        jTable.setValueAt(opcion.getTipo(), tableIndex, 1);
        jTable.setValueAt(opcion.getVencimiento(), tableIndex, 2);
        jTable.setValueAt(opcion.getEjercicio(), tableIndex, 3);
        jTable.setValueAt(getDate(), tableIndex, 4);
        jTable.setValueAt(opcion.getPrecioCompra(), tableIndex, 5);
        jTable.setValueAt(opcion.getPrecioVenta(), tableIndex, 6);
        tableIndex++;
    }

    private String getDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String formatedDate = sdf.format(date);
        return formatedDate;
    }
    
    
}