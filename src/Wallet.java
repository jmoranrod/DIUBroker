import java.io.File;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;


public class Wallet {
    
    private String walletName;
    private List<WalletOption> wOptions;
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

    public void updateFrame(WalletOption opcion) {
        wOptions.add(opcion);
        this.frame.addOptionsToTable(wOptions.size(), opcion);
    }

    public WalletIO getWalletIO() {
        return walletIO;
    }
    
    public void addOption(WalletOption option){
        this.wOptions.add(option);
        //this.value += toFloat(option.Compra_Precio);
        this.frame.addOptionsToTable(wOptions.size(), wOptions.get(wOptions.indexOf(wOptions.size()-1)));
        //writeToFile(option.toWallet(1));
    }
    
    private Float toFloat(String texto){
        texto = texto.replace(".", "");
        texto = texto.replace(",", ".");
        return Float.valueOf(texto);
    }
}
