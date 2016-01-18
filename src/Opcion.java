
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
    public String cantidad;
    public String fechaEntrada;

    public Opcion(String cantidad, String Tipo, String Vencimiento, String Ejercicio, String fechaEntrada, String Compra_Precio) {
        this.Tipo = Tipo;
        this.Compra_Precio = Compra_Precio;
        this.Vencimiento = Vencimiento;
        this.Ejercicio = Ejercicio;
        this.fechaEntrada = fechaEntrada;
        this.cantidad = cantidad;
    }

    public Opcion() {
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public void setVenta_Precio(String Venta_Precio) {
        this.Venta_Precio = Venta_Precio;
    }

    public void setCompra_Precio(String Compra_Precio) {
        this.Compra_Precio = Compra_Precio;
    }
    
    @Override
    public String toString() {
        return "*" + Tipo + "*" + Hora + "*" + Volumen + "*" + Ultimo + "*" + Compra_Vol + "*" + Compra_Precio + "*" + Venta_Vol + "*" + Venta_Precio + "*" + Vencimiento + "*" + Ejercicio + "*";
    }

    public String toWallet(int number) {
        return number+" "+Tipo+" "+Vencimiento+" "+Ejercicio+" "+getDate()+" "+Compra_Precio;
    }
    
    public Opcion toOpcion(String[] fields){
        String vencimiento = fields[2] +" "+ fields[3] +" "+ fields[4];
        return new Opcion(fields[0],fields[1],vencimiento,fields[5],fields[6], fields[7]);
    }

    public String getDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String formatedDate = sdf.format(date);
        return formatedDate;
    }
    
    
}



