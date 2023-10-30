package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Detalle_Venta;
import modelo.Venta;

public class Ctrl_RegistrarVenta {

    
    //metodo para guardar una nueva venta
    public boolean guardarVenta(Venta objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("INSERT INTO venta VALUES (?, ?, ?, ?, ?)");
            consulta.setInt(1, objeto.getIdVenta());
            consulta.setString(2, objeto.getIdCliente());
            consulta.setDouble(3, objeto.getValorPagar());
            consulta.setString(4, objeto.getFechaVenta());
            consulta.setInt(5, 1);
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar venta: " + e);
        }
        return respuesta;
    }

    //metodo para guardar del detalle de venta
    public boolean guardarDetalle(Detalle_Venta objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("INSERT INTO detalle_venta VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            consulta.setInt(1, objeto.getIdDetalleVenta());
            consulta.setInt(2, objeto.getIdVenta());
            consulta.setInt(3, objeto.getIdProducto());
            consulta.setDouble(4, objeto.getCantidadProducto());
            consulta.setDouble(5, objeto.getPrecioUnitario());
            consulta.setDouble(6, objeto.getSubTotal());
            consulta.setDouble(7, objeto.getDescuento());
            consulta.setDouble(8, objeto.getIva());
            consulta.setDouble(9, objeto.getTotalPagar());
            consulta.setInt(10, 1);
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar detalle de venta: " + e);
        }
        return respuesta;
    }

    //Metodo actualizar venta
    public boolean actualizar(Venta objeto, int idVenta) {
        boolean respuesta = false;
        Connection cn = (Connection) conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = (PreparedStatement) cn.prepareStatement("update venta set venta_cliente_id=?, venta_estado=? where venta_id ='" + idVenta + "'");
            consulta.setString(1, objeto.getIdCliente());
            consulta.setInt(2, objeto.getEstado());
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar venta: " + e);
        }
        return respuesta;
    }
}
