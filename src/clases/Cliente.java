package clases;

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
    
//    public void modificarCliente(){
//        Con
//    }
//    
//    public void eliminarCliente(){
//        Con
//    }
}
