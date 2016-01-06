
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

    public Wallet(String name) {
        this.name = name;
        this.options = new LinkedList<>();
        this.value = 0d;
        this.frame = new WalletFrame(name);
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
        this.value += toFloat(option.Compra_Precio);
        this.frame.addOptionsToTable(options);
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
    
    private Float toFloat(String texto){
        texto = texto.replace(".", "");
        texto = texto.replace(",", ".");
        return Float.valueOf(texto);
    }
    
}
