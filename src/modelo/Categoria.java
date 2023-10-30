package modelo;

public class Categoria {

    private int idCategoria;
    private String nombre;
    private int estado;

    public Categoria() {
        this.idCategoria = 0;
        this.nombre = "";
        this.estado = 0;
    }

    public Categoria(int idCategoria, String nombre, int estado) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.estado = estado;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
