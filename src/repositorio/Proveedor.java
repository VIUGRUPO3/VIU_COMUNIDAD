/****
* 
* Asignatura: 21GIIN Proyectos Programación
* Profesor: Eduardo Zamudio
* @author: Grupo 3
* Miembros:
*       @author:Fernando Hernandez Fernandez
*       @author:Javier Barbero Sales
*       @author:Martin Gonzalez Dominguez
* @version: 01/12/2022/A 
* 

* 
****/


package repositorio;


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

    public void bajaProveedor(ComunidadCRUD comunidadCRUD, Proveedor proveedorBorrar){
        comunidadCRUD.proveedores.forEach(proveedor ->{
            if(proveedor == proveedorBorrar){
                proveedor = null;
            }
        });
    }
    
    public void updateProveedor(ComunidadCRUD comunidadCRUD, String nombre, String direccion, String telefono, String email, Proveedor proveedorModificar){
        comunidadCRUD.proveedores.forEach(proveedor ->{
            if(proveedor == proveedorModificar){
                proveedor.setProveedor(nombre, direccion, telefono, email);
            }
        });
    }
    
    

    @Override
    public String toString() {
        return "--------Proveedor"+ id + "--------\nnombr - " + nombre + "\ndirec - " + direccion + "\ntelef - " + telefono + "\nemail - " + email + "\n";
    }
    
    
    
}
