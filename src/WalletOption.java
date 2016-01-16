public class WalletOption {

    private String cantidad;
    private String tipo;
    private String vencimiento;
    private String ejercicio;
    private String fechaEntrada;
    private String precioCompra;

    public WalletOption(String cantidad, String tipo, String vencimiento, String ejercicio, String fechaEntrada, String precioCompra) {
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.vencimiento = vencimiento;
        this.ejercicio = ejercicio;
        this.fechaEntrada = fechaEntrada;
        this.precioCompra = precioCompra;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }

    public String getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(String ejercicio) {
        this.ejercicio = ejercicio;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(String precioCompra) {
        this.precioCompra = precioCompra;
    }
    
    
    
    @Override
    public String toString() {
        return cantidad + " " + tipo + " " + vencimiento + " " + ejercicio.trim() + " " + fechaEntrada + " " + precioCompra;
    }
    
    
    
}
