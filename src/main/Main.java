package main;

import clases.Prueba;

/**
 *
 * @author dark
 */
public class Main {
    
    
    public static void main(String[] args) {
        Prueba prueba_uno = new Prueba("Alfredo", "Gonzales", 151, true, "12-12-12");
        
        Prueba prueba_dos = new Prueba();
        
        
        System.out.println("Nombre Completo: " + prueba_uno.getNombre() + " " + prueba_uno.getApellido());
        System.out.println("Estado: " + prueba_uno.isEstado());
        
        prueba_uno.setEstado(false);
        System.out.println("Estado cambiado: " + prueba_uno.isEstado());    
        
        prueba_uno.setNombre("alfreding0");
        System.out.println("Nombre: " + prueba_uno.getNombre());   
        
        prueba_dos.setFecha_nac("03-03-2013");
        System.out.println("Test: " + prueba_dos.getNombre());
        System.out.println("Test: " + prueba_dos.getApellido());
        System.out.println("Test: " + prueba_dos.getFecha_nac());
        System.out.println("Test: " + prueba_dos.isEstado());
        System.out.println("Test: " + prueba_dos.getEdad());
    }    
}
