package main;

import clases.Conexion;
import java.sql.ResultSet;

/**
 *
 * @author dark
 */
public class Main {
    
    
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        
        String comando = "INSERT INTO tipo_personales (descripcion) VALUES ('prueba 1');";
        conexion.ejecutarComando(comando);
        
        String consulta = "SELECT * FROM tipo_personal;";
        ResultSet res = conexion.ejecutarConsulta(consulta);
                
        conexion.mostrarDatosPorConsola(res);
    }    
}
