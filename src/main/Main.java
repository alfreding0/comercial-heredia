package main;

import clases.Conexion;
import clases.Producto;
import java.sql.ResultSet;

/**
 *
 * @author dark
 */
public class Main {
    
    
    public static void main(String[] args) {
        
        String nombre = "Fideito";
        String stock = "100";
        String precio = "8.70";
        
        int cantidad_vendido = 10;
                
//        Producto prod = new Producto(nombre, stock, precio);
        Producto prod = new Producto();
        prod.setId("2");
        
        prod.disminuirStock(cantidad_vendido);
                
        Conexion con = new Conexion();
        ResultSet respuesta = con.ejecutarConsulta("Select * from producto;");
        con.mostrarDatosPorConsola(respuesta);
    }    
}
