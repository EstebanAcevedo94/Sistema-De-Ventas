package controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import conexion.Conexion;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import vista.InterFacturacion;

public class VentaPDF {

    private String nombreCliente;
    private String rutCliente;
    private String telefonoCliente;

    String Rut = "";
    String Nombre = "";
    String Telefono = "";
    String Direccion = "";
    String Razon = "";

    private int numeroTicket = 0;

    private String fechaActual = "";
    private String horaActual = "";
    private String nombreArchivoPDFVenta = "";

    //Metodo para cargar clientes
    public void DatosClientes(String idCliente) {
        Connection cn = (Connection) Conexion.conectar();
        String sql = "select * from cliente where CLIENTE_ID='" + idCliente + "'";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                nombreCliente = rs.getString("CLIENTE_NOMBRE") + " " + rs.getString("CLIENTE_APELLIDO");
                rutCliente = rs.getString("CLIENTE_ID");
                telefonoCliente = rs.getString("CLIENTE_TELEFONO");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener datos del cliente: " + e);
        }
    }

    //Metodo para generar ticket con cliente
    public void generarTicketPDF_cliente() {
        try {
            //Cargar numero ticket
            this.SiguienteTicket();
            // Cargar fecha actual con hora
            Date date = new Date();
            String fechaimpresa = new SimpleDateFormat("yyyy/MM/dd").format(date);
            fechaActual = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date);
            horaActual = new SimpleDateFormat("HH:mm:ss").format(date);
            // Cambiar formato de fecha de "/" a "_"
            String fechaNueva = fechaActual.replace("/", "_").replace(":", "_").replace(" ", "_");
            //Crear documento PDF
            nombreArchivoPDFVenta = "Venta_" + nombreCliente + "_" + fechaNueva + ".pdf";
            FileOutputStream archivo;
            File file = new File("src/pdf/" + nombreArchivoPDFVenta);
            archivo = new FileOutputStream(file);

            // Configurar tamaño y márgenes del documento
            Rectangle pageSize = PageSize.LETTER;
            Document doc = new Document(pageSize, 0, 0, 0, 0);

            PdfWriter.getInstance(doc, archivo);
            doc.open();
            //Espacio en blanco (Salto de linea)
            Paragraph espacio1 = new Paragraph();
            espacio1.add(Chunk.NEWLINE);
            espacio1.add("");
            espacio1.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio1);

            // Crear párrafo para la fecha
            Paragraph fecha = new Paragraph();
            fecha.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 35, Font.NORMAL, BaseColor.BLACK));
            fecha.add("Venta: \n" + numeroTicket + "\n\nFecha: \n" + fechaimpresa + "\n\n");

            PdfPTable Encabezado = new PdfPTable(1);
            Encabezado.setWidthPercentage(90);
            Encabezado.getDefaultCell().setBorder(0); // Quitar borde de la tabla
            Encabezado.setHorizontalAlignment(Element.ALIGN_CENTER); // Alinear al centro

            // Datos Negocio
            this.MetodoDatos();

            // Crear celda con los datos
            PdfPCell celdaDatos = new PdfPCell(new Phrase("R.U.T.: " + Rut + "\nN° " + numeroTicket + "\n" + Razon + "\n" + Nombre + "\n" + Direccion
                    + "\nTeléfono: " + Telefono + "\nFecha: " + fechaimpresa + "\nHora: " + horaActual,
                    new Font(Font.FontFamily.TIMES_ROMAN, 35, Font.BOLD, BaseColor.BLACK)));

            celdaDatos.setBorder(0);
            celdaDatos.setPaddingBottom(5); // Ajustar espacio inferior de la celda de datos
            celdaDatos.setHorizontalAlignment(Element.ALIGN_CENTER);

            // Agregar celda a la tabla de encabezado
            Encabezado.addCell(celdaDatos);
            Encabezado.setHorizontalAlignment(Element.ALIGN_CENTER);

            // Agregar tabla de encabezado al documento
            doc.add(Encabezado);
            //Espacio en blanco (Salto de linea)
            Paragraph espacio2 = new Paragraph();
            espacio2.add(Chunk.NEWLINE);
            espacio2.add("");
            espacio2.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio2);
            // Crear la tabla principal
            PdfPTable tablaPrincipal = new PdfPTable(1);
            tablaPrincipal.setWidthPercentage(100);
            tablaPrincipal.setHorizontalAlignment(Element.ALIGN_CENTER); // Alinear al centro

            // Crear la tabla de encabezado
            PdfPTable tablaEncabezado = new PdfPTable(4);
            tablaEncabezado.setWidthPercentage(100);
            tablaEncabezado.setHorizontalAlignment(Element.ALIGN_CENTER); // Alinear al centro

            //float[] columnasEncabezado = new float[]{15f, 50f, 15f, 20f};
            //tablaEncabezado.setWidths(columnasEncabezado);
            Font encabezadoFont = new Font(Font.FontFamily.TIMES_ROMAN, 32, Font.BOLD, BaseColor.BLACK);

            PdfPCell encabezado1 = new PdfPCell(new Phrase("Cantidad", encabezadoFont));
            PdfPCell encabezado2 = new PdfPCell(new Phrase("Nombre", encabezadoFont));
            PdfPCell encabezado3 = new PdfPCell(new Phrase("Precio", encabezadoFont));
            PdfPCell encabezado4 = new PdfPCell(new Phrase("Total", encabezadoFont));

            encabezado1.setBorder(0);
            encabezado2.setBorder(0);
            encabezado3.setBorder(0);
            encabezado4.setBorder(0);
            
            encabezado1.setHorizontalAlignment(Element.ALIGN_CENTER);
            encabezado2.setHorizontalAlignment(Element.ALIGN_CENTER);
            encabezado3.setHorizontalAlignment(Element.ALIGN_CENTER);
            encabezado4.setHorizontalAlignment(Element.ALIGN_CENTER);

            tablaEncabezado.addCell(encabezado1);
            tablaEncabezado.addCell(encabezado2);
            tablaEncabezado.addCell(encabezado3);
            tablaEncabezado.addCell(encabezado4);

            // Agregar encabezado a la tabla principal
            PdfPCell tablaEncabezadoCell = new PdfPCell(tablaEncabezado);
            tablaEncabezadoCell.setBorder(0);
            tablaPrincipal.addCell(tablaEncabezadoCell);

            // Crear la tabla de productos
            PdfPTable tablaProductos = new PdfPTable(4);
            tablaProductos.setWidthPercentage(100);
            tablaProductos.setHorizontalAlignment(Element.ALIGN_CENTER); // Alinear al centro

            //float[] columnasProductos = new float[]{15f, 50f, 15f, 20f};
            //tablaProductos.setWidths(columnasProductos);
            Font productosFont = new Font(Font.FontFamily.TIMES_ROMAN, 32, Font.NORMAL, BaseColor.BLACK);

            // Agregar productos a la tabla
            for (int i = 0; i < InterFacturacion.jTable_Productos.getRowCount(); i++) {
                String cantidad = InterFacturacion.jTable_Productos.getValueAt(i, 2).toString();
                String producto = InterFacturacion.jTable_Productos.getValueAt(i, 1).toString();
                String precio = InterFacturacion.jTable_Productos.getValueAt(i, 3).toString();
                String total = InterFacturacion.jTable_Productos.getValueAt(i, 7).toString();

                PdfPCell cantidadCell = new PdfPCell(new Phrase(cantidad, productosFont));
                PdfPCell productoCell = new PdfPCell(new Phrase(producto, productosFont));
                PdfPCell precioCell = new PdfPCell(new Phrase(precio, productosFont));
                PdfPCell totalCell = new PdfPCell(new Phrase(total, productosFont));

                cantidadCell.setBorder(0);
                productoCell.setBorder(0);
                precioCell.setBorder(0);
                totalCell.setBorder(0);
                
                cantidadCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                productoCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                precioCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                totalCell.setHorizontalAlignment(Element.ALIGN_CENTER);

                tablaProductos.addCell(cantidadCell);
                tablaProductos.addCell(productoCell);
                tablaProductos.addCell(precioCell);
                tablaProductos.addCell(totalCell);
            }
            // Agregar tabla de productos a la tabla principal
            PdfPCell tablaProductosCell = new PdfPCell(tablaProductos);
            tablaProductosCell.setBorder(0);
            tablaPrincipal.addCell(tablaProductosCell);
            tablaPrincipal.setHorizontalAlignment(Element.ALIGN_CENTER);
            // Agregar tabla principal al documento
            doc.add(tablaPrincipal);
            // Crear la tabla con 2 columnas
            PdfPTable tabla = new PdfPTable(2);
            tabla.setWidthPercentage(90);
            tabla.setHorizontalAlignment(Element.ALIGN_CENTER); // Alinear al centro
            tabla.getDefaultCell().setBorder(Rectangle.NO_BORDER); // Eliminar bordes de las celdas

            // Crear fuente para los nombres de los datos
            Font nombreFont = new Font(Font.FontFamily.TIMES_ROMAN, 32, Font.NORMAL, BaseColor.BLACK);

            // Crear fuente para los valores de los datos
            Font valorFont = new Font(Font.FontFamily.TIMES_ROMAN, 32, Font.BOLD, BaseColor.BLACK);

            //Espacio en blanco (Salto de linea)
            Paragraph espacio3 = new Paragraph();
            espacio3.add(Chunk.NEWLINE);
            espacio3.add("");
            espacio3.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio3);
            // Agregar los nombres de los datos a la celda izquierda
            Paragraph nombreSubtotal = new Paragraph("Subtotal: ", nombreFont);
            Paragraph nombreDescuento = new Paragraph("Descuento: ", nombreFont);
            Paragraph nombreIVA = new Paragraph("IVA: ", nombreFont);
            Paragraph nombreTotal = new Paragraph("Total a pagar: ", nombreFont);

            // Alinear los nombres de los datos a la derecha
            nombreSubtotal.setAlignment(Element.ALIGN_CENTER);
            nombreDescuento.setAlignment(Element.ALIGN_CENTER);
            nombreIVA.setAlignment(Element.ALIGN_CENTER);
            nombreTotal.setAlignment(Element.ALIGN_CENTER);

            // Agregar los nombres y valores de los datos a la tabla
            tabla.addCell(nombreSubtotal);
            tabla.addCell(new Phrase("$"+InterFacturacion.txt_Subtotal.getText(), valorFont));

            tabla.addCell(nombreDescuento);
            tabla.addCell(new Phrase("$"+InterFacturacion.txt_Descuento.getText(), valorFont));

            tabla.addCell(nombreIVA);
            tabla.addCell(new Phrase("$"+InterFacturacion.txt_IVA.getText(), valorFont));

            tabla.addCell(nombreTotal);
            tabla.addCell(new Phrase("$"+InterFacturacion.txt_Total.getText(), valorFont));
            
            tabla.setHorizontalAlignment(Element.ALIGN_CENTER);

            // Agregar la tabla al documento
            doc.add(tabla);
            //Pie de pagina
            Paragraph firma = new Paragraph();
            firma.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 35, Font.NORMAL, BaseColor.BLACK));
            firma.add(Chunk.NEWLINE);
            firma.add("\n\nCancelacion y firma\n\n");
            firma.add("_______________________");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);
            //Mensaje "Gracias"
            Paragraph mensaje = new Paragraph();
            mensaje.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 35, Font.NORMAL, BaseColor.BLACK));
            mensaje.add(Chunk.NEWLINE);
            mensaje.add("\nGracias por su compra.");
            mensaje.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensaje);
            //Espacio en blanco (Salto de linea)
            Paragraph espacio4 = new Paragraph();
            espacio4.add(Chunk.NEWLINE);
            espacio4.add("");
            espacio4.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio4);
            //Cerrar documnento y archivo
            doc.close();
            archivo.close();
            // Imprimir el documento
            FileInputStream fis = new FileInputStream(file);
            Doc pdfDoc = new SimpleDoc(fis, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
            PrintService service = PrintServiceLookup.lookupDefaultPrintService();
            DocPrintJob printJob = service.createPrintJob();
            printJob.print(pdfDoc, new HashPrintRequestAttributeSet());
            fis.close();
        } catch (DocumentException | IOException | PrintException e) {
            System.out.println("Error en: " + e);
        }
    }

    //Metodo para generar ticket sin cliente
    public void generarTicketPDF_sinCliente() {
        try {
            //Cargar numero ticket
            this.SiguienteTicket();
            // Cargar fecha actual con hora
            Date date = new Date();
            String fechaimpresa = new SimpleDateFormat("yyyy/MM/dd").format(date);
            String fechaActual = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date);
            horaActual = new SimpleDateFormat("HH:mm:ss").format(date);
            // Cambiar formato de fecha de "/" a "_"
            String fechaNueva = fechaActual.replace("/", "_").replace(":", "_").replace(" ", "_");
            //Crear documento PDF
            nombreArchivoPDFVenta = "Venta_" + fechaNueva + ".pdf";
            FileOutputStream archivo;
            File file = new File("src/pdf/" + nombreArchivoPDFVenta);
            archivo = new FileOutputStream(file);

            // Configurar tamaño y márgenes del documento
            Rectangle pageSize = PageSize.LETTER;
            Document doc = new Document(pageSize, 0, 0, 0, 0);

            PdfWriter.getInstance(doc, archivo);
            doc.open();
            //Espacio en blanco (Salto de linea)
            Paragraph espacio1 = new Paragraph();
            espacio1.add(Chunk.NEWLINE);
            espacio1.add("");
            espacio1.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio1);

            // Crear párrafo para la fecha
            Paragraph fecha = new Paragraph();
            fecha.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 35, Font.NORMAL, BaseColor.BLACK));
            fecha.add("Venta: \n" + numeroTicket + "\n\nFecha: \n" + fechaimpresa + "\n\n");

            PdfPTable Encabezado = new PdfPTable(1);
            Encabezado.setWidthPercentage(90);
            Encabezado.getDefaultCell().setBorder(0); // Quitar borde de la tabla
            Encabezado.setHorizontalAlignment(Element.ALIGN_CENTER); // Alinear al centro

            // Datos Negocio
            this.MetodoDatos();

            // Crear celda con los datos
            PdfPCell celdaDatos = new PdfPCell(new Phrase("R.U.T.: " + Rut + "\nN° " + numeroTicket + "\n" + Razon + "\n" + Nombre + "\n" + Direccion
                    + "\nTeléfono: " + Telefono + "\nFecha: " + fechaimpresa + "\nHora: " + horaActual,
                    new Font(Font.FontFamily.TIMES_ROMAN, 35, Font.BOLD, BaseColor.BLACK)));

            celdaDatos.setBorder(0);
            celdaDatos.setPaddingBottom(5); // Ajustar espacio inferior de la celda de datos
            celdaDatos.setHorizontalAlignment(Element.ALIGN_CENTER);

            // Agregar celda a la tabla de encabezado
            Encabezado.addCell(celdaDatos);
            Encabezado.setHorizontalAlignment(Element.ALIGN_CENTER);

            // Agregar tabla de encabezado al documento
            doc.add(Encabezado);
            //Espacio en blanco (Salto de linea)
            Paragraph espacio2 = new Paragraph();
            espacio2.add(Chunk.NEWLINE);
            espacio2.add("");
            espacio2.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio2);
            // Crear la tabla principal
            PdfPTable tablaPrincipal = new PdfPTable(1);
            tablaPrincipal.setWidthPercentage(100);
            tablaPrincipal.setHorizontalAlignment(Element.ALIGN_CENTER); // Alinear al centro

            // Crear la tabla de encabezado
            PdfPTable tablaEncabezado = new PdfPTable(4);
            tablaEncabezado.setWidthPercentage(100);
            tablaEncabezado.setHorizontalAlignment(Element.ALIGN_CENTER); // Alinear al centro

            //float[] columnasEncabezado = new float[]{15f, 50f, 15f, 20f};
            //tablaEncabezado.setWidths(columnasEncabezado);
            Font encabezadoFont = new Font(Font.FontFamily.TIMES_ROMAN, 32, Font.BOLD, BaseColor.BLACK);

            PdfPCell encabezado1 = new PdfPCell(new Phrase("Cantidad", encabezadoFont));
            PdfPCell encabezado2 = new PdfPCell(new Phrase("Nombre", encabezadoFont));
            PdfPCell encabezado3 = new PdfPCell(new Phrase("Precio", encabezadoFont));
            PdfPCell encabezado4 = new PdfPCell(new Phrase("Total", encabezadoFont));

            encabezado1.setBorder(0);
            encabezado2.setBorder(0);
            encabezado3.setBorder(0);
            encabezado4.setBorder(0);
            
            encabezado1.setHorizontalAlignment(Element.ALIGN_CENTER);
            encabezado2.setHorizontalAlignment(Element.ALIGN_CENTER);
            encabezado3.setHorizontalAlignment(Element.ALIGN_CENTER);
            encabezado4.setHorizontalAlignment(Element.ALIGN_CENTER);

            tablaEncabezado.addCell(encabezado1);
            tablaEncabezado.addCell(encabezado2);
            tablaEncabezado.addCell(encabezado3);
            tablaEncabezado.addCell(encabezado4);

            // Agregar encabezado a la tabla principal
            PdfPCell tablaEncabezadoCell = new PdfPCell(tablaEncabezado);
            tablaEncabezadoCell.setBorder(0);
            tablaPrincipal.addCell(tablaEncabezadoCell);

            // Crear la tabla de productos
            PdfPTable tablaProductos = new PdfPTable(4);
            tablaProductos.setWidthPercentage(100);
            tablaProductos.setHorizontalAlignment(Element.ALIGN_CENTER); // Alinear al centro

            //float[] columnasProductos = new float[]{15f, 50f, 15f, 20f};
            //tablaProductos.setWidths(columnasProductos);
            Font productosFont = new Font(Font.FontFamily.TIMES_ROMAN, 32, Font.NORMAL, BaseColor.BLACK);

            // Agregar productos a la tabla
            for (int i = 0; i < InterFacturacion.jTable_Productos.getRowCount(); i++) {
                String cantidad = InterFacturacion.jTable_Productos.getValueAt(i, 2).toString();
                String producto = InterFacturacion.jTable_Productos.getValueAt(i, 1).toString();
                String precio = InterFacturacion.jTable_Productos.getValueAt(i, 3).toString();
                String total = InterFacturacion.jTable_Productos.getValueAt(i, 7).toString();

                PdfPCell cantidadCell = new PdfPCell(new Phrase(cantidad, productosFont));
                PdfPCell productoCell = new PdfPCell(new Phrase(producto, productosFont));
                PdfPCell precioCell = new PdfPCell(new Phrase(precio, productosFont));
                PdfPCell totalCell = new PdfPCell(new Phrase(total, productosFont));

                cantidadCell.setBorder(0);
                productoCell.setBorder(0);
                precioCell.setBorder(0);
                totalCell.setBorder(0);
                
                cantidadCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                productoCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                precioCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                totalCell.setHorizontalAlignment(Element.ALIGN_CENTER);

                tablaProductos.addCell(cantidadCell);
                tablaProductos.addCell(productoCell);
                tablaProductos.addCell(precioCell);
                tablaProductos.addCell(totalCell);
            }
            // Agregar tabla de productos a la tabla principal
            PdfPCell tablaProductosCell = new PdfPCell(tablaProductos);
            tablaProductosCell.setBorder(0);
            tablaPrincipal.addCell(tablaProductosCell);
            tablaPrincipal.setHorizontalAlignment(Element.ALIGN_CENTER);
            // Agregar tabla principal al documento
            doc.add(tablaPrincipal);
            // Crear la tabla con 2 columnas
            PdfPTable tabla = new PdfPTable(2);
            tabla.setWidthPercentage(90);
            tabla.setHorizontalAlignment(Element.ALIGN_CENTER); // Alinear al centro
            tabla.getDefaultCell().setBorder(Rectangle.NO_BORDER); // Eliminar bordes de las celdas

            // Crear fuente para los nombres de los datos
            Font nombreFont = new Font(Font.FontFamily.TIMES_ROMAN, 32, Font.NORMAL, BaseColor.BLACK);

            // Crear fuente para los valores de los datos
            Font valorFont = new Font(Font.FontFamily.TIMES_ROMAN, 32, Font.BOLD, BaseColor.BLACK);

            //Espacio en blanco (Salto de linea)
            Paragraph espacio3 = new Paragraph();
            espacio3.add(Chunk.NEWLINE);
            espacio3.add("");
            espacio3.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio3);
            // Agregar los nombres de los datos a la celda izquierda
            Paragraph nombreSubtotal = new Paragraph("Subtotal: ", nombreFont);
            Paragraph nombreDescuento = new Paragraph("Descuento: ", nombreFont);
            Paragraph nombreIVA = new Paragraph("IVA: ", nombreFont);
            Paragraph nombreTotal = new Paragraph("Total a pagar: ", nombreFont);

            // Alinear los nombres de los datos a la derecha
            nombreSubtotal.setAlignment(Element.ALIGN_CENTER);
            nombreDescuento.setAlignment(Element.ALIGN_CENTER);
            nombreIVA.setAlignment(Element.ALIGN_CENTER);
            nombreTotal.setAlignment(Element.ALIGN_CENTER);

            // Agregar los nombres y valores de los datos a la tabla
            tabla.addCell(nombreSubtotal);
            tabla.addCell(new Phrase("$"+InterFacturacion.txt_Subtotal.getText(), valorFont));

            tabla.addCell(nombreDescuento);
            tabla.addCell(new Phrase("$"+InterFacturacion.txt_Descuento.getText(), valorFont));

            tabla.addCell(nombreIVA);
            tabla.addCell(new Phrase("$"+InterFacturacion.txt_IVA.getText(), valorFont));

            tabla.addCell(nombreTotal);
            tabla.addCell(new Phrase("$"+InterFacturacion.txt_Total.getText(), valorFont));
            
            tabla.setHorizontalAlignment(Element.ALIGN_CENTER);

            // Agregar la tabla al documento
            doc.add(tabla);
            //Pie de pagina
            Paragraph firma = new Paragraph();
            firma.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 35, Font.NORMAL, BaseColor.BLACK));
            firma.add(Chunk.NEWLINE);
            firma.add("\n\nCancelacion y firma\n\n");
            firma.add("_______________________");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);
            //Mensaje "Gracias"
            Paragraph mensaje = new Paragraph();
            mensaje.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 35, Font.NORMAL, BaseColor.BLACK));
            mensaje.add(Chunk.NEWLINE);
            mensaje.add("\nGracias por su compra.");
            mensaje.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensaje);
            //Espacio en blanco (Salto de linea)
            Paragraph espacio4 = new Paragraph();
            espacio4.add(Chunk.NEWLINE);
            espacio4.add("");
            espacio4.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio4);
            //Cerrar documnento y archivo
            doc.close();
            archivo.close();
            // Imprimir el documento
            FileInputStream fis = new FileInputStream(file);
            Doc pdfDoc = new SimpleDoc(fis, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
            PrintService service = PrintServiceLookup.lookupDefaultPrintService();
            DocPrintJob printJob = service.createPrintJob();
            printJob.print(pdfDoc, new HashPrintRequestAttributeSet());
            fis.close();
        } catch (DocumentException | IOException | PrintException e) {
            System.out.println("Error en: " + e);
        }
    }

    //Metodo para generar el siguiente numero de ticket
    public void SiguienteTicket() {
        Connection cn = (Connection) Conexion.conectar();
        String sql = "select max(venta_id) as ultimo from venta";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                numeroTicket = rs.getInt("ultimo") + 1;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener ultimo tiquet: " + e);
        }
    }

    //Metodo para obtener datos del negocio
    public void MetodoDatos() {
        Connection cn = (Connection) Conexion.conectar();
        String sql = "select dato_rut, dato_nombre, dato_telefono, dato_direccion, dato_razon from dato where dato_id = 1";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Rut = rs.getString("dato_rut");
                Nombre = rs.getString("dato_nombre");
                Telefono = rs.getString("dato_telefono");
                Direccion = rs.getString("dato_direccion");
                Razon = rs.getString("dato_razon");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener ultimo tiquet: " + e);
        }
    }
}
