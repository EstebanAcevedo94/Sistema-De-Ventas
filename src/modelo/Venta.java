package modelo;

public class Venta {

    private int idVenta;
    private String idCliente;
    private int valorPagar;
    private String fechaVenta;
    private int estado;
    private double subtotal;
    private double descuento;
    private double iva;

    public Venta() {
        this.idVenta = 0;
        this.idCliente = "";
        this.valorPagar = 0;
        this.fechaVenta = "";
        this.estado = 0;
        this.subtotal = 0.0;
        this.descuento = 0.0;
        this.iva = 0.0;

    }

    public Venta(int idVenta, String idCliente, int valorPagar, String fechaVenta, int estado, double subtotal, double descuento, double iva) {
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.valorPagar = valorPagar;
        this.fechaVenta = fechaVenta;
        this.estado = estado;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.iva = iva;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public int getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(int valorPagar) {
        this.valorPagar = valorPagar;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    

}
