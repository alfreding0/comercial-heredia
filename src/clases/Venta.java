package clases;

/**
 *
 * @author alfreding0
 */
public class Venta {
    private String id;
    private String total;
    private String fecha;
    private String hora;
    private String ci_cliente;
    private String ci_personal;
    
    private final Conexion con = new Conexion();

    public Venta() {
    }

    public Venta(String total, String fecha, String hora, String ci_cliente, String ci_personal) {
        this.total = total;
        this.fecha = fecha;
        this.hora = hora;
        this.ci_cliente = ci_cliente;
        this.ci_personal = ci_personal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getCi_cliente() {
        return ci_cliente;
    }

    public void setCi_cliente(String ci_cliente) {
        this.ci_cliente = ci_cliente;
    }

    public String getCi_personal() {
        return ci_personal;
    }

    public void setCi_personal(String ci_personal) {
        this.ci_personal = ci_personal;
    }
    
    public void guardarVenta(){
        String comando = "INSERT INTO venta (total, fecha, hora, ci_cliente, ci_personal) VALUES ('"+ this.total +"', '"+ this.fecha +"', '"+ this.hora +"', '"+ this.ci_cliente +"', '"+ this.ci_personal +"');";
        con.ejecutarComando(comando);
    }
    
//    public void mostrarVenta(JTable tabla){
//        DefaultTableModel model;
//        try {
//            String [] titulos = {"ID","NOMBRE","STOCK","PRECIO (Bs.)"};
//            model = new DefaultTableModel(null, titulos);
//            
//            String consulta = "SELECT * FROM producto;";
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
    
    public void modificarVenta(){
        String comando = "UPDATE venta SET total='"+ this.total +"', fecha='"+ this.fecha +"', hora='"+ this.hora +"', ci_cliente='"+this.ci_cliente+"', ci_personal='"+this.ci_personal+"' WHERE id='"+ this.id+"';";
        con.ejecutarComando(comando);
    }
    
    public void eliminarVenta(){
        String comando = "DELETE FROM venta WHERE id = '"+this.id+"'";
        con.ejecutarComando(comando);
    }
}
