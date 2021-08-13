package clases;

/**
 *
 * @author alfreding0
 */
public class VentaDetalle {
    private String id_venta;
    private String id_producto;
    private String precio_unid;
    private String cantidad;
    
    private final Conexion con = new Conexion();

    public VentaDetalle(String id_venta, String id_producto, String precio_unid, String cantidad) {
        this.id_venta = id_venta;
        this.id_producto = id_producto;
        this.precio_unid = precio_unid;
        this.cantidad = cantidad;
    }

    public VentaDetalle() {
    }

    public String getId_venta() {
        return id_venta;
    }

    public void setId_venta(String id_venta) {
        this.id_venta = id_venta;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getPrecio_unid() {
        return precio_unid;
    }

    public void setPrecio_unid(String precio_unid) {
        this.precio_unid = precio_unid;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    
    public void guardarVentaDetalle(){
        String comando = "INSERT INTO detalle_venta (id_venta, id_producto, precio_unid, cantidad) VALUES ('"+ this.id_venta +"', '"+ this.id_producto +"', '"+ this.precio_unid +"', '"+ this.cantidad +"');";
        con.ejecutarComando(comando);
    }
    
//    public void mostrarVentaDetalle(JTable tabla){
//        DefaultTableModel model;
//        try {
//            String [] titulos = {"ID","NOMBRE","STOCK","PRECIO (Bs.)"};
//            model = new DefaultTableModel(null, titulos);
//            
//            String consulta = "SELECT * FROM detalle_venta;";
//            
//            ResultSet rs = con.ejecutarConsulta(consulta);
//            ResultSetMetaData datos = rs.getMetaData();
//            
//            int nc=datos.getColumnCount();
//            
//            while (rs.next()) {
//                Object fila []= new Object [nc];
//                
//                for(int i=0;i<nc;i++){
//                    fila[i]=rs.getObject(i+1);
//                }
//                model.addRow(fila);
//            }
//            tabla.setModel(model);
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al mostrar productos!\n"+ex.getMessage());
//        }
//    }
    
//    public void modificarVentaDetalle(){
//        String comando = "UPDATE detalle_venta SET nombre='"+ this.nombre +"', stock='"+ this.stock +"', precio='"+ this.precio +"' WHERE id='"+ this.id+"';";
//        con.ejecutarComando(comando);
//    }
    
    public void eliminarVentaDetalle(){
        String comando = "DELETE FROM detalle_venta WHERE id_producto = '"+this.id_producto+"'";
        con.ejecutarComando(comando);
    }
}
