
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
    
    
}



