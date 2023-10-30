package modelo;

public class Cliente {

    //Atributos
    private String idCliente;
    private String nombre;
    private String apellido;
    private String telefono;
    private int estado;

    //Contructor
    public Cliente() {
        this.idCliente = "";
        this.nombre = "";
        this.apellido = "";
        this.telefono = "";
        this.estado = 0;
    }
    //Contructor sobrecargado

    public Cliente(String idCliente, String nombre, String apellido, String telefono, int estado) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.estado = estado;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
