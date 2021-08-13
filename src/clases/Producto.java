package clases;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alfreding0
 */
public class Producto {
    private String id;
    private String nombre;
    private String stock;
    private String precio;
    
    private final Conexion con = new Conexion();

    public Producto() {
    }

    public Producto(String nombre, String stock, String precio) {
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }
    
    //este constructor se va a utilizar para listar Productos en el combobox
    public Producto(String id, String nombre, String stock, String precio) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    
    public void guardarProducto(){
        String comando = "INSERT INTO producto (nombre, stock, precio) VALUES ('"+ this.nombre +"', '"+ this.stock +"', '"+ this.precio +"');";
        con.ejecutarComando(comando);
    }
    
    public void mostrarProductos(JTable tabla){
        DefaultTableModel model;
        try {
            String [] titulos = {"ID","NOMBRE","STOCK","PRECIO (Bs.)"};
            model = new DefaultTableModel(null, titulos);
            
            String consulta = "SELECT * FROM producto;";
            
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
            JOptionPane.showMessageDialog(null, "Error al mostrar productos!\n"+ex.getMessage());
        }
    }
    
    public void modificarProducto(){
        String comando = "UPDATE producto SET nombre='"+ this.nombre +"', stock='"+ this.stock +"', precio='"+ this.precio +"' WHERE id='"+ this.id+"';";
        con.ejecutarComando(comando);
    }
    
    public void eliminarProducto(){
        String comando = "DELETE FROM producto WHERE id = '"+this.id+"'";
        con.ejecutarComando(comando);
    }
    
    public void disminuirStock(int cantidad){
        try {
            int ultimo_stock = 0;
            ResultSet res = con.ejecutarConsulta("SELECT stock FROM producto WHERE id='" +this.id+ "'");
            
            while(res.next()){
                ultimo_stock = res.getInt("stock");
            }
            int stock_actual = ultimo_stock - cantidad;
            String comando = "UPDATE producto SET stock="+ stock_actual +"; ";
            con.ejecutarComando(comando);
            
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void aumentarStock(int cantidad){
        try {
            int ultimo_stock = 0;
            ResultSet res = con.ejecutarConsulta("SELECT stock FROM producto WHERE id='" +this.id+ "'");
            
            while(res.next()){
                ultimo_stock = res.getInt("stock");
            }
            int stock_actual = ultimo_stock + cantidad;
            String comando = "UPDATE producto SET stock="+ stock_actual +"; ";
            con.ejecutarComando(comando);
            
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void listarProductos(JComboBox<Producto> comboBoxProducto){
        try{
            
            ResultSet rs = con.ejecutarConsulta("SELECT id, nombre, stock, precio FROM producto ORDER BY nombre; ");
            
            //este es un señuelo solamente para saber si es o no es un dato real de la base de datos.
            comboBoxProducto.addItem(new Producto("000", "titulo", "titulo", "titulo"));
            
            
            //va a cargar los productos como una lista de elemetnos en el JComboBox
            while(rs.next()){
                comboBoxProducto.addItem(new Producto(
                        rs.getString("id"),
                        rs.getString("nombre"),
                        rs.getString("stock"), 
                        rs.getString("precio")
                    )
                );
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al listar Productos\n"+e);
        }
    }
    
//    //Para que al listar todo el personal en el jcombobox solo muestre nombres y apellidos, sin los demas atributos
    @Override
    public String toString(){
        if(!this.id.equals("000") && !this.nombre.equals("titulo") &&  !this.stock.equals("titulo") &&  !this.precio.equals("titulo"))
            return this.nombre;
        else
            return "SELECCIONE UN PRODUCTO:";
    }
}
