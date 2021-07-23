package clases;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alfreding0
 */
public class Cliente {
    private String ci;
    private String nombre_completo;
    private String fecha_nac;
    private String genero;
    private String direccion;
    
    private final Conexion con = new Conexion();

    public Cliente(String ci, String nombre_completo, String fecha_nac, String genero, String direccion) {
        this.ci = ci;
        this.nombre_completo = nombre_completo;
        this.fecha_nac = fecha_nac;
        this.genero = genero;
        this.direccion = direccion;
    }

    public Cliente() {
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void guardarCliente(){
        String comando = "INSERT INTO cliente VALUES ('"+ this.ci +"', '"+ this.nombre_completo +"', '"+ this.fecha_nac +"', '"+ this.genero +"', '"+ this.direccion +"');";
        con.ejecutarComando(comando);
    }
    
    public void mostrarClientes(JTable tabla){
        DefaultTableModel model;
        try {
            String [] titulos = {"CI","NOMBRE COMPLETO","FECHA NAC.","GÉNERO","DIRECCION"};
            model = new DefaultTableModel(null, titulos);
            
            String consulta = "SELECT ci, nombre_completo, fecha_nac, genero, direccion FROM cliente;";
            
            ResultSet rs = con.ejecutarConsulta(consulta);
            ResultSetMetaData datos = rs.getMetaData();
            
            int nc=datos.getColumnCount();
            
            while (rs.next()) {
                Object fila []= new Object [nc];
                
                for(int i=0;i<nc;i++){
                    fila[i]=rs.getObject(i+1);
                }
                model.addRow(fila);
            }
            tabla.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al mostrar clientes!\n"+ex.getMessage());
        }
    }
    
//    public void modificarCliente(){
//        Con
//    }
//    
//    public void eliminarCliente(){
//        Con
//    }
}
