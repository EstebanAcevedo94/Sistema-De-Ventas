package modelo;

public class Datos {

    //Atributos
    private int idDato;
    private String rut;
    private String nombre;
    private String telefono;
    private String direccion;
    private String razon;
    

    //Contructor
    public Datos() {
        this.idDato = 0;
        this.rut = "";
        this.nombre = "";
        this.telefono = "";
        this.direccion = "";
        this.razon = "";
    }

    public Datos(int idDato, String rut, String nombre, String telefono, String direccion, String razon) {
        this.idDato = idDato;
        this.rut = rut;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.razon = razon;
    }

    public int getIdDato() {
        return idDato;
    }

    public void setIdDato(int idDato) {
        this.idDato = idDato;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

}
