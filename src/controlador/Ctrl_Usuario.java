package controlador;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;
import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.Usuario;

public class Ctrl_Usuario {

    //metodo para guardar un nuevo usuario
    public boolean guardar(Usuario objeto) {
        boolean respuesta = false;
        Connection cn = (Connection) Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into usuario values(?,?,?,?,?,?,?)");
            consulta.setString(1, (objeto.getIdUsuario()));
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getApellido());
            consulta.setString(4, objeto.getUsuario());
            consulta.setString(5, objeto.getPassword());
            consulta.setString(6, objeto.getTelefono());
            consulta.setInt(7, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar usuario: " + e);
        }

        return respuesta;
    }
    
    //metodo para guardar un nuevo admin
    public boolean guardarAdmin(Usuario objeto) {
        boolean respuesta = false;
        Connection cn = (Connection) Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into admin values(?,?,?,?,?,?,?)");
            consulta.setString(1, (objeto.getIdUsuario()));
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getApellido());
            consulta.setString(4, objeto.getUsuario());
            consulta.setString(5, objeto.getPassword());
            consulta.setString(6, objeto.getTelefono());
            consulta.setInt(7, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar admin: " + e);
        }

        return respuesta;
    }

    //metodo para consultar si el usuaruio ya esta registrado en la BBDD
    public boolean existeUsuario(String usuario) {
        boolean respuesta = false;
        String sql = "select usuario_id from usuario where usuario_id = '" + usuario + "';";
        Statement st;
        try {
            java.sql.Connection cn = Conexion.conectar();
            st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar usuario: " + e);
        }
        return respuesta;
    }
    
    //metodo para consultar si el admin ya esta registrado en la BBDD
    public boolean existeAdmin(String usuario) {
        boolean respuesta = false;
        String sql = "select admin_id from admin where admin_id = '" + usuario + "';";
        Statement st;
        try {
            java.sql.Connection cn = Conexion.conectar();
            st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar admin: " + e);
        }
        return respuesta;
    }

    //Metodo para iniciar sesión como usuario
    public boolean loginUser(Usuario objeto) {

        boolean respuesta = false;

        Connection cn = (Connection) Conexion.conectar();
        String sql = "select usuario_usuario,usuario_password from usuario where usuario_usuario = '" + objeto.getUsuario() + "' and usuario_password = '" + objeto.getPassword() + "'";
        Statement st;
        try {
            st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al iniciar sesión ");
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión");
        }

        return respuesta;

    }

    //Metodo para iniciar sesión como admin
    public boolean loginAdmin(Usuario objeto) {

        boolean respuesta = false;

        Connection cn = (Connection) Conexion.conectar();
        String sql = "select admin_usuario,admin_password from admin where admin_usuario = '" + objeto.getUsuario() + "' and admin_password = '" + objeto.getPassword() + "'";
        Statement st;
        try {
            st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al iniciar sesión ");
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión");
        }
        return respuesta;
    }

    //Metodo para iniciar sesión como super admin
    public boolean loginSuperAdmin(Usuario objeto) {

        boolean respuesta = false;

        Connection cn = (Connection) Conexion.conectar();
        String sql = "select super_admin_usuario,super_admin_password from super_admin where super_admin_usuario = '" + objeto.getUsuario() + "' and super_admin_password = '" + objeto.getPassword() + "'";
        Statement st;
        try {
            st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al iniciar sesión ");
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión");
        }
        return respuesta;
    }

    //Metodo actualizar cliente
    public boolean actualizar(Usuario objeto, String idUsuario) {
        boolean respuesta = false;
        Connection cn = (Connection) conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = (PreparedStatement) cn.prepareStatement("update usuario set usuario_id=?, usuario_nombre=?, usuario_apellido=?, usuario_usuario=?, usuario_password=?, usuario_telefono=?, usuario_estado=? where usuario_id ='" + idUsuario + "'");
            consulta.setString(1, objeto.getIdUsuario());
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getApellido());
            consulta.setString(4, objeto.getUsuario());
            consulta.setString(5, objeto.getPassword());
            consulta.setString(6, objeto.getTelefono());
            consulta.setInt(7, 1);
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e);
        }
        return respuesta;
    }
    
    //Metodo actualizar admin
    public boolean actualizarAdmin(Usuario objeto, String idUsuario) {
        boolean respuesta = false;
        Connection cn = (Connection) conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = (PreparedStatement) cn.prepareStatement("update admin set admin_id=?, admin_nombre=?, admin_apellido=?, admin_usuario=?, admin_password=?, admin_telefono=?, admin_estado=? where admin_id ='" + idUsuario + "'");
            consulta.setString(1, objeto.getIdUsuario());
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getApellido());
            consulta.setString(4, objeto.getUsuario());
            consulta.setString(5, objeto.getPassword());
            consulta.setString(6, objeto.getTelefono());
            consulta.setInt(7, 1);
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar admin: " + e);
        }
        return respuesta;
    }

    //Metodo eliminar cliente
    public boolean eliminar(String idUsuario) {
        boolean respuesta = false;
        java.sql.Connection cn = (java.sql.Connection) conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = (PreparedStatement) cn.prepareStatement("delete from usuario where usuario_id ='" + idUsuario + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e);
        }
        return respuesta;
    }
    
    //Metodo eliminar admin
    public boolean eliminarAdmin(String idUsuario) {
        boolean respuesta = false;
        java.sql.Connection cn = (java.sql.Connection) conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = (PreparedStatement) cn.prepareStatement("delete from admin where admin_id ='" + idUsuario + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar admin: " + e);
        }
        return respuesta;
    }

    //Metodo para verificar Admin
    public boolean VerificarAdmin(String Pass) {

        boolean respuesta = false;
        String sql = "select usuario_password from usuario where usuario_usuario = admin";
        Statement st;
        String[] columnas;
        try {
            java.sql.Connection cn = Conexion.conectar();
            st = (Statement) cn.createStatement();
            System.out.println("ST " + st);
            ResultSet rs = st.executeQuery(sql);
            System.out.println("RS " + rs);
            ResultSetMetaData mtd = (ResultSetMetaData) rs.getMetaData();
            System.out.println("Metadatos :" + mtd);
            int numColumnas = mtd.getColumnCount();
            columnas = new String[numColumnas];
            for (int i = 0; i < numColumnas; i++) {
                columnas[i] = mtd.getColumnLabel(i + 1);
                System.out.println(columnas);
            }
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar DDBB: " + e);
        }
        return respuesta;
    }
}
