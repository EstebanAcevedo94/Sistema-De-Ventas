package vista;

import java.sql.Connection;
import conexion.Conexion;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InterGraficarVentas extends javax.swing.JInternalFrame {

    ArrayList<Integer> listaCantidad = new ArrayList<>();
    ArrayList<String> listaFechas = new ArrayList<>();
    int cantidadResultados = 0;
    String[] vector_fechaVenta;
    int[] vector_estatusCantidad;

    //Constructor
    public InterGraficarVentas() {
        initComponents();
        this.setSize(550, 650);
        this.setTitle("Historial de Ventas");
        this.MetodoContador();
        vector_fechaVenta = new String[cantidadResultados];
        vector_estatusCantidad = new int[cantidadResultados];
        this.metodoAlmacenaDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Seleccione ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    //Metodo para determinar la cantidad de resultados a graficar
    private int MetodoContador() {
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select venta_fecha, count(venta_fecha) as Fecha from venta "
                    + "where venta_fecha between '" + InterGraficas.fecha_inicio + "' and '" + InterGraficas.fecha_fin + "'group by venta_fecha");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                cantidadResultados++;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error en: " + e);
        }
        return cantidadResultados;
    }

    //Metodo para almacenar el las listas los datos a graficar
    private void metodoAlmacenaDatos() {
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select venta_fecha, count(venta_fecha) as Ventas from venta "
                    + "where venta_fecha between '" + InterGraficas.fecha_inicio + "' and '" + InterGraficas.fecha_fin + "'group by venta_fecha");
            ResultSet rs = pst.executeQuery();
            int contador = 0;
            while (rs.next()) {
                vector_fechaVenta[contador] = rs.getString("venta_fecha");
                listaFechas.add(vector_fechaVenta[contador]);
                vector_estatusCantidad[contador] = rs.getInt("Ventas");
                listaCantidad.add(vector_estatusCantidad[contador]);
                contador++;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error en: " + e);
        }
    }

    //Metodo para determinar cual es el dia de Mayor cantidad de ventas
    public int MetodoMayorVenta(ArrayList<Integer> listaCantidad) {
        int mayor = 0;
        for (int i = 0; i < listaCantidad.size(); i++) {
            if (listaCantidad.get(i) > mayor) {
                mayor = listaCantidad.get(i);
            }
        }
        return mayor;
    }

    //Metodo para graficar
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int mayorVenta = MetodoMayorVenta(listaCantidad);
        int largo_NuevoIngreso = 0;
        int parametro1 = 133;
        int parametroFecha = 118;
        int parametro3 = 100;
        for (int i = 0; i < listaCantidad.size(); i++) {
            largo_NuevoIngreso = listaCantidad.get(i)*400 / mayorVenta;
            switch (i) {
                case 0:
                    g.setColor(new Color(140,0,75));//Morado
                    break;
                case 1:
                    g.setColor(new Color(255,0,0));//Rojo
                    break;
                case 2:
                    g.setColor(new Color(0,0,0));//Negro
                    break;
                case 3:
                    g.setColor(new Color(255,255,255));//Blanco
                    break;
                case 4:
                    g.setColor(new Color(0,85,0));//Verde
                    break;
                case 5:
                    g.setColor(new Color(0,0,255));//Azul
                    break;
                case 6:
                    g.setColor(new Color(255,127,0));//Naranjo
                    break;
                default:
                    g.setColor(new Color(17,251,216));//celeste
                    break;
            }
            g.fillRect(100, parametro3, largo_NuevoIngreso, 40);
            g.drawString(listaFechas.get(i), 10, parametroFecha);
            g.drawString("Cantidad: "+ listaCantidad.get(i), 10, parametro1);
            parametro1+=50;
            parametroFecha+=50;
            parametro3+=50;
        }
    }

}
