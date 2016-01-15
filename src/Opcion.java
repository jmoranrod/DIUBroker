
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

    public Opcion() {
    }

    
    
    public Opcion(String Tipo, String Hora, String Volumen, String Ultimo, String Compra_Vol, String Compra_Precio, String Venta_Vol, String Venta_Precio, String Vencimiento, String Ejercicio) {
        this.Tipo = Tipo;
        this.Hora = Hora;
        this.Volumen = Volumen;
        this.Ultimo = Ultimo;
        this.Compra_Vol = Compra_Vol;
        this.Compra_Precio = Compra_Precio;
        this.Venta_Vol = Venta_Vol;
        this.Venta_Precio = Venta_Precio;
        this.Vencimiento = Vencimiento;
        this.Ejercicio = Ejercicio;
    }
    
    @Override
    public String toString() {
        return "\\^" + Tipo + "\\^" + Hora + "\\^" + Volumen + "\\^" + Ultimo + "\\^" + Compra_Vol + "\\^" + Compra_Precio + "\\^" + Venta_Vol + "\\^" + Venta_Precio + "\\^" + Vencimiento + "\\^" + Ejercicio + "\\^";
    }
    
    public Opcion toOption(String[] fields){
        return new Opcion(fields[0],fields[1],fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9]);
    }
}



