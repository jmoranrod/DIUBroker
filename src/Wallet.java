import java.io.File;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;


public class Wallet {
    
    private String walletName;
    private List<WalletOption> wOptions;
    
    private float value = 0;
    private float earnings;
    private float inverted;
    
    private WalletFrame frame;
    private WalletIO walletIO;
    private File f;

    public Wallet(String walletName) {
        this.walletName = walletName;
        this.walletIO = new WalletIO(walletName);
        walletIO.initFile();
        this.wOptions = new LinkedList<>();
        this.frame = new WalletFrame(walletName);
        this.frame.setName(walletName);
    }

    public Wallet(String walletName, WalletIO walletIO) {
        this.walletName = walletName;
        this.walletIO = walletIO;
        this.wOptions = new LinkedList<>();
        this.frame = new WalletFrame(walletName);
        this.frame.setName(walletName);
    }
    
    public WalletFrame getFrame(){
        return frame;
    }
    
    public String getName() {
        return walletName;
    }

    public void setName(String name) {
        this.walletName = name;
    }

    public List<WalletOption> getwOptions() {
        return wOptions;
    }

    public void setwOptions(List<WalletOption> wOptions) {
        this.wOptions = wOptions;
    }
    
    
    public void addOptionList(List<WalletOption> list){
        for (WalletOption opcion : list) {
            addOption(opcion);
        }
    }

    public void updateFrame(WalletOption option) {
        wOptions.add(option);
        calculateEarnings(option);
        this.frame.addOptionsToTable(wOptions.size(), option);
    }

    public WalletIO getWalletIO() {
        return walletIO;
    }
    
    public void addOption(WalletOption option){
        this.wOptions.add(option);
        calculateEarnings(option);
        this.frame.addOptionsToTable(wOptions.size(), wOptions.get(wOptions.indexOf(wOptions.size()-1)));
    }
    
    private Float toFloat(String texto){
        if (!texto.contains("-")) {
            texto = texto.replace(".", "");
            texto = texto.replace(",", ".");
            return Float.valueOf(texto);
        }
        return 0f;
    }

    public float getEarnings() {
        return earnings;
    }

    public void setEarnings(float earnings) {
        this.earnings = earnings;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getInverted() {
        return inverted;
    }

    public void setInverted(float inverted) {
        this.inverted = inverted;
    }
    
    private void calculateEarnings(WalletOption option) {
        float pCompra = 0;
        float pVenta = 0;
        if (option.getPrecioCompra().toString().contains("-") || option.getPrecioCompra().toString().contains(" ")) {
            System.out.println("PCOMPRA: "+ pCompra);
            pCompra = 0f;
        }else{
            System.out.println("PCOMPRA: "+ pCompra);
            pCompra = toFloat(option.getPrecioCompra());
        }
        if (option.getPrecioVenta().toString().contains("-") || option.getPrecioVenta().toString().contains(" ")) {
            System.out.println("PVENTA: "+ pVenta);
            pVenta = 0f;
        }else{
            System.out.println("PVENTA: "+ pVenta);
            pVenta = toFloat(option.getPrecioVenta());
        }
        
        /*this.earnings += toFloat(option.getPrecioCompra()) - toFloat(option.getPrecioVenta());
        this.value += toFloat(option.getPrecioCompra()) * toFloat(option.getCantidad());
        this.inverted += toFloat(option.getPrecioVenta()) * toFloat(option.getCantidad());*/
        this.earnings += pCompra - pVenta;
        this.value += pCompra * toFloat(option.getCantidad());
        this.inverted += pVenta * toFloat(option.getCantidad());
    }
}
