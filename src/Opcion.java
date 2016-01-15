
import java.text.SimpleDateFormat;
import java.util.Date;


public class Opcion {
    public String Tipo;
    public String Hora;
    public String Volumen;
    public String Ultimo;
    public String Compra_Vol;
    public String Compra_Precio;
    public String Venta_Vol;
    public String Venta_Precio;
    public String Vencimiento;
    public String Ejercicio;

    @Override
    public String toString() {
        return "*" + Tipo + "*" + Hora + "*" + Volumen + "*" + Ultimo + "*" + Compra_Vol + "*" + Compra_Precio + "*" + Venta_Vol + "*" + Venta_Precio + "*" + Vencimiento + "*" + Ejercicio + "*";
    }

    public String toWallet(int number) {
        return number+" "+Tipo+" "+Vencimiento+" "+Ejercicio+" "+getDate()+" "+Compra_Precio;
    }

    private String getDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String formatedDate = sdf.format(date);
        return formatedDate;
    }
    
    
}



