
import java.util.LinkedList;
import java.util.List;


public class Wallet {
    
    private String name;
    private double value;
    private List<Opcion> options;
    private WalletFrame frame;

    public Wallet() {
        this.options = new LinkedList<>();
        this.value = 0d;
        this.frame = new WalletFrame();
    }

    public WalletFrame getFrame() {
        return frame;
    }
        
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void addOption(Opcion option){
        this.options.add(option);
        this.frame.addOptionsToTable(options);
//        this.value += Double.parseDouble(option.Compra_Precio);
    }
    
    public List<Opcion> getOptions() {
        return options;
    }

    public void setOptions(List<Opcion> options) {
        this.options = options;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
}
