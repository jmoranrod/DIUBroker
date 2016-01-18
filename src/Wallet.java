import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class Wallet {
    
    private String walletName;
    private List<WalletOption> wOptions;
    private WalletFrame frame;
    private WalletIO walletIO;
    private float value = 0, earnings, inverted;

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
            pCompra = 0f;
        }else{
            pCompra = toFloat(option.getPrecioCompra());
        }
        if (option.getPrecioVenta().toString().contains("-") || option.getPrecioVenta().toString().contains(" ")) {
            pVenta = 0f;
        }else{
            pVenta = toFloat(option.getPrecioVenta());
        }
        this.earnings += pCompra - pVenta;
        this.value += pCompra * toFloat(option.getCantidad());
        this.inverted += pVenta * toFloat(option.getCantidad());
    }
}
