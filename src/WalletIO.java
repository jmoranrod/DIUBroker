
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WalletIO {
    
    private Path path;
    private String walletName;

    public WalletIO(String walletName) {
        this.walletName = walletName;
        this.path = FileSystems.getDefault().getPath(walletName+".dbr");
    }

    public WalletIO(Path path, String walletName) {
        this.path = path;
        this.walletName = walletName;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }
    
    public Path initFile(){
        try{
            if (!Files.exists(path)) {
                ArrayList name = new ArrayList();
                name.add(walletName);
                Files.write(path, name, StandardOpenOption.CREATE_NEW);
                return path;
            }
            return null;
        } catch (IOException ex) {
            Logger.getLogger(Wallet.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public Path linkFile(Path path){
        this.path = path;
        return this.path;
    }
    
    public boolean writeToFile(String line){
        try {
            ArrayList lines = new ArrayList();
            lines.add(line);
            if (Files.exists(path)){
                Files.write(path, lines, StandardOpenOption.APPEND);
                return true;
            }else{
                Files.write(path, lines, StandardOpenOption.CREATE_NEW);
                return true;
            }
        } catch (IOException ex) {
            Logger.getLogger(Wallet.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void writeToFile(List<String> lines){
        for (String line : lines) {
            writeToFile(line);
        }
    }
    
    public List readFromFile(){
        try{
            return Files.readAllLines(path);
        } catch (IOException ex) {
            Logger.getLogger(Wallet.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean removeLine(int index){
        List lines = readFromFile();
        try{
            Files.delete(path);
        }catch (IOException ex) {
            Logger.getLogger(Wallet.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        lines.remove(index);
        writeToFile(lines);
        return true;
    }

    public boolean removeFile() {
        try{
            Files.delete(path);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Wallet.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
