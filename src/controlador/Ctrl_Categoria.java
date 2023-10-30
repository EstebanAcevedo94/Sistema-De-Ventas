package controlador;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import modelo.Categoria;
import java.sql.ResultSet;

public class Ctrl_Categoria {

    private int numeroTicket;

    //Metodo para registrar categoria
    public boolean guardar(Categoria objeto) {
        this.SiguienteTicket();
        boolean respuesta = false;
        Connection cn = (Connection) conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = (PreparedStatement) cn.prepareStatement("insert into categoria values(?,?,?)");
            consulta.setInt(1, numeroTicket);//id
            consulta.setString(2, objeto.getNombre());
            consulta.setInt(3, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar categoría: " + e);
        }
        return respuesta;
    }

    //Metodo para ver si exite la categoria
    public boolean existeCategoria(String categoria) {
        boolean respuesta = false;
        String sql = "select categoria_nombre from categoria where categoria_nombre = '" + categoria + "'";
        Statement st;

        try {
            Connection cn = (Connection) conexion.Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar categoría: " + e);
        }
        return respuesta;
    }

    //Metodo actualizar categoria
    public boolean actualizar(Categoria objeto, int idCategoria) {
        boolean respuesta = false;
        Connection cn = (Connection) conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = (PreparedStatement) cn.prepareStatement("update categoria set categoria_nombre=? where categoria_id ='" +idCategoria+ "'");
            consulta.setString(1, objeto.getNombre());
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar categoría: " + e);
        }
        return respuesta;
    }
    
    //Metodo eliminar categoria
    public boolean eliminar(int idCategoria) {
        boolean respuesta = false;
        Connection cn = (Connection) conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = (PreparedStatement) cn.prepareStatement("delete from categoria where categoria_id ='" +idCategoria+ "'");
            consulta.executeUpdate();
            
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar categoría: " + e);
        }
        return respuesta;
    }
    
    //Metodo para generar el siguiente numero de categoria
    public void SiguienteTicket() {
        com.mysql.jdbc.Connection cn = (com.mysql.jdbc.Connection) Conexion.conectar();
        String sql = "select max(categoria_id) as ultimo from categoria";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                numeroTicket = rs.getInt("ultimo") + 1;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener ultima categoria: " + e);
        }
    }
}
