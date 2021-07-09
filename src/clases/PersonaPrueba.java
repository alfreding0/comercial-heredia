package clases;


/**
 *
 * @author dark
 */
public class PersonaPrueba { //PERSONAL
    private String nombre;    // null           // "Alfredo"
    private String apellido;  // null           // "Gonzales Quiucha"
    private int edad;         // 0              // 13                                   
    private boolean estado;   // false          // false   o   true
    private String fecha_nac; // null           // "21/09/2021"

    
    //Constructor con pedido de datos (obligatorio)
    public PersonaPrueba(String nombre, String apellido, int edad, boolean estado, String fecha_nac) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.estado = estado;
        this.fecha_nac = fecha_nac;
    }

    //Constructor vacío (asignda los valores por defecto a las variables)
    public PersonaPrueba() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public boolean isEstado() {
        return estado;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public void insertarPersona(){
        //  INSERT INTO persona VALUES ('', '7698743', 'M', 'Camiri');
        String sql = "INSERT INTO persona VALUES ('" + this.nombre + "', '"+ this.edad +"', '"+ this.fecha_nac +"', '"+ this.estado +"');";
        db.ejecutarConsulta( sql );
    }
    
    public void mostrarPersonas(){
        // SELECT * FROM persona;
        
    }
    
    public void eliminarPersona(){
        
    }
}
