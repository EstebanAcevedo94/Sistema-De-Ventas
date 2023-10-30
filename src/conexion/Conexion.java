package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    //conexion local
    public static Connection conectar() {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_sistema_ventas", "root", "17823991");
            return cn;
        } catch (SQLException e) {
            System.out.println("Error en conexion local " + e);
        }
        return null;
    }
}
