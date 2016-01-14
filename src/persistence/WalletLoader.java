package persistence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WalletLoader {
    
    private String walletName;
    private Path file;

    public WalletLoader(String walletName) {
        this.walletName = walletName;
        file = Paths.get(walletName+".txt");
    }
    
    public boolean writeToFile(ArrayList lines){
        
        try {
            if (Files.exists(file)){
                Files.write(file, lines, StandardOpenOption.APPEND);
                return true;
            }else{
                System.out.println("HOLAAA");
                //Files.createFile(file);
                Files.write(file, lines, StandardOpenOption.CREATE_NEW);
                return true;
            }
        } catch (IOException ex) {
            Logger.getLogger(WalletLoader.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List readFromFile(){
        try {
            return Files.readAllLines(file);
        } catch (IOException ex) {
            Logger.getLogger(WalletLoader.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
