
package repositorio;

/**
 *
 * @author fer
 */
public class Proveedor {
    
    //1.Atributos
    
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    
    //2.Constructores

    public Proveedor() {}

    public Proveedor(int id, String nombre, String direccion, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }
    
    //3.Metodos

    public int getId() {
        return id;
    } 

    public void setProveedor(String nombre, String direccion, String telefono, String email) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    
    
    

    @Override
    public String toString() {
        return "--------Proveedor"+ id + "--------\nnombr - " + nombre + "\ndirec - " + direccion + "\ntelef - " + telefono + "\nemail - " + email + "\n";
    }
    
    
    
}
