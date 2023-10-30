package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Producto;

public class Ctrl_Producto {

    //metodo para guardar un nuevo producto
    public boolean guardar(Producto objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("insert into producto values(?,?,?,?,?,?,?,?)");
            consulta.setInt(1, objeto.getIdProducto());
            consulta.setString(2, objeto.getNombre());
            consulta.setDouble(3, objeto.getCantidad());
            consulta.setInt(4, objeto.getPrecio());
            consulta.setString(5, objeto.getDescripcion());
            consulta.setInt(6, objeto.getPorcentajeIva());
            consulta.setInt(7, objeto.getIdCategoria());
            consulta.setInt(8, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar producto: " + e);
        }

        return respuesta;
    }

    //metodo para consultar si el producto ya esta registrado en la BBDD
    public boolean existeProducto(int producto) {
        boolean respuesta = false;
        String sql = "select producto_id from producto where producto_id = '" + producto + "';";
        Statement st;

        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar producto: " + e);
        }
        return respuesta;
    }

    //Metodo actualizar producto
    public boolean actualizar(Producto objeto, int idProducto) {
        boolean respuesta = false;
        Connection cn = (Connection) conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = (PreparedStatement) cn.prepareStatement("update producto set producto_id=?, producto_nombre=?, producto_cantidad=?, producto_precio=?, producto_descripcion=?, producto_iva=?, producto_id_categoria=?, producto_estado=? where producto_id ='" + idProducto + "'");
            consulta.setInt(1, objeto.getIdProducto());
            consulta.setString(2, objeto.getNombre());
            consulta.setDouble(3, objeto.getCantidad());
            consulta.setInt(4, objeto.getPrecio());
            consulta.setString(5, objeto.getDescripcion());
            consulta.setInt(6, objeto.getPorcentajeIva());
            consulta.setInt(7, objeto.getIdCategoria());
            consulta.setInt(8, objeto.getEstado());
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar producto: " + e);
        }
        return respuesta;
    }

    //Metodo eliminar producto
    public boolean eliminar(int idProducto) {
        boolean respuesta = false;
        Connection cn = (Connection) conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = (PreparedStatement) cn.prepareStatement("delete from producto where producto_id ='" + idProducto + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e);
        }
        return respuesta;
    }

    //Metodo para actualizar stock producto
    public boolean actualizarStock(Producto object, int idProducto) {
        boolean respuesta = false;
        Connection cn = (Connection) conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = (PreparedStatement) cn.prepareStatement("update producto set producto_cantidad=? where producto_id ='" + idProducto + "'");
            consulta.setDouble(1, object.getCantidad());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar stock del producto: " + e);
        }
        return respuesta;
    }
}
