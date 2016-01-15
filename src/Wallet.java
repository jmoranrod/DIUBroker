
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Wallet {
    
    private String walletName;
    private Path file;
    private double value;
    private List<Opcion> options;
    private List<WalletOption> wOptions;
    private WalletFrame frame;

    public Wallet() {
        this.options = new LinkedList<>();
        this.wOptions = new LinkedList<>();
        this.value = 0d;
        this.frame = new WalletFrame();
    }

    public Wallet(String walletName) {
        this.walletName = walletName;
        this.options = new LinkedList<>();
        this.wOptions = new LinkedList<>();
        this.value = 0d;
        this.frame = new WalletFrame(walletName);
        this.file = Paths.get(walletName +".dbr");
        
        initFile(walletName);
    }

    private void initFile(String walletName1) {
        ArrayList list = new ArrayList();
        list.add(walletName1);
        writeToFile(list);
    }

    public WalletFrame getFrame() {
        return frame;
    }
    
    
        
    public String getName() {
        return walletName;
    }

    public void setName(String name) {
        this.walletName = name;
    }
    
    public void addOptionList(List<Opcion> list){
        for (Opcion opcion : list) {
            addOption(opcion);
        }
    }

    public void updateFrame(int aux, WalletOption opcion) {
        System.out.println("AUUUUUUUUUUUUU "+aux);
        wOptions.add(opcion);
        this.frame.addOptionsToTable(wOptions.size(), opcion);
    }
    
    
    
    public void addOption(Opcion option){
        this.options.add(option);
        //this.value += toFloat(option.Compra_Precio);
        this.frame.addOptionsToTable(getOptions().size(), option);
        //writeToFile(option.toWallet(1));
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
    
    public boolean writeToFile(ArrayList lines){
        try {
            if (Files.exists(file)){
                Files.write(file, lines, StandardOpenOption.APPEND);
                return true;
            }else{
                Files.write(file, lines, StandardOpenOption.CREATE_NEW);
                return true;
            }
        } catch (IOException ex) {
            Logger.getLogger(Wallet.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean writeToFile(String line){
        ArrayList lines = new ArrayList();
        lines.add(line);
        try {
            if (Files.exists(file)){
                Files.write(file, lines, StandardOpenOption.APPEND);
                return true;
            }else{
                Files.write(file, lines, StandardOpenOption.CREATE_NEW);
                return true;
            }
        } catch (IOException ex) {
            Logger.getLogger(Wallet.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List readFromFile(){
        try {
            return Files.readAllLines(file);
        } catch (IOException ex) {
            Logger.getLogger(Wallet.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
