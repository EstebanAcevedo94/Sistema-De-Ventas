package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Datos;

public class Ctrl_Datos {

    //Metodo actualizar producto
    public boolean actualizar(Datos objeto, int idDato) {
        boolean respuesta = false;
        Connection cn = (Connection) conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = (PreparedStatement) cn.prepareStatement("update dato set dato_rut=?, dato_nombre=?, dato_telefono=?, dato_direccion=?, dato_razon=? where dato_id ='" + idDato + "'");
            consulta.setString(1, objeto.getRut());
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getTelefono());
            consulta.setString(4, objeto.getDireccion());
            consulta.setString(5, objeto.getRazon());
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar datos: " + e);
        }
        return respuesta;
    }
}
