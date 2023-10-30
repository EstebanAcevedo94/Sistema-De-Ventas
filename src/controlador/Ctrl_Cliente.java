package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Cliente;


public class Ctrl_Cliente {

    //metodo para guardar un nuevo cliente
    public boolean guardar(Cliente objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("insert into cliente values(?,?,?,?,?)");
            consulta.setString(1, objeto.getIdCliente());
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getApellido());
            consulta.setString(4, objeto.getTelefono());
            consulta.setInt(5, 1);

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar cliente: " + e);
        }

        return respuesta;
    }

    //metodo para consultar si el cliente ya esta registrado en la BBDD
    public boolean existeCliente(String cliente) {
        boolean respuesta = false;
        String sql = "select cliente_id from cliente where cliente_id = '" + cliente + "';";
        Statement st;

        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar cliente: " + e);
        }
        return respuesta;
    }

    //Metodo actualizar cliente
    public boolean actualizar(Cliente objeto, String idCliente) {
        boolean respuesta = false;
        Connection cn = (Connection) conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = (PreparedStatement) cn.prepareStatement("update cliente set cliente_id=?, cliente_nombre=?, cliente_apellido=?, cliente_telefono=?, usuario_estado=? where cliente_id ='" + idCliente + "'");
            consulta.setString(1, objeto.getIdCliente());
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getApellido());
            consulta.setString(4, objeto.getTelefono());
            consulta.setInt(5, objeto.getEstado());
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente: " + e);
        }
        return respuesta;
    }

    //Metodo eliminar cliente
    public boolean eliminar(String idCliente) {
        boolean respuesta = false;
        Connection cn = (Connection) conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = (PreparedStatement) cn.prepareStatement("delete from cliente where cliente_id ='" + idCliente + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e);
        }
        return respuesta;
    }
}
