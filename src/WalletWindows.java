
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class WalletWindows extends JInternalFrame {
    
    private static int walletNumber = 0;
    private JPanel panel = new JPanel();
    private JTable jTable = new JTable(dataModel());
    private JScrollPane jScrollPane = new JScrollPane(jTable);

    public WalletWindows() {
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

    public WalletWindows(String title) {
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
        tm.addColumn("Nº de Opciones");
        tm.addColumn("Tipo de Opción");
        tm.addColumn("F. Vencimiento");
        tm.addColumn("P. Ejercicio");
        tm.addColumn("F. Entrada a Cartera");
        tm.addColumn("P. Compra de mercado");
    }
    
    
    
    
}
