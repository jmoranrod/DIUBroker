
import java.util.LinkedList;
import java.util.List;


public class Wallet {
    
    private String name;
    private double value;
    private List<Opcion> options;

    public Wallet() {
        this.options = new LinkedList<>();
        this.value = 0d;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void addOption(Opcion option){
        this.options.add(option);
        this.value += Double.parseDouble(option.Compra_Precio);
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
