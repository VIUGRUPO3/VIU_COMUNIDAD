// Asignatura: 21GIIN Proyectos Programación
// Profesor: Eduardo Zamudio
// @author: Grupo 3
// Miembros:
//       @author:Fernando Hernandez Fernandez
//       @author:Javier Barbero Sales
//       @author:Martin Gonzalez Dominguez
// @version: 01/12/2022/

// Paquete
package repositorio;

/**
 *  Clase que gestiona el tipo Proveedor
 * */
public class Proveedor {
    
    //1.Atributos
    /**
    *  Se definen los atributos principales de la clase proveedor: id, nombre, direccion, telefono, email
    * */
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    
    //2.Constructores

    public Proveedor() {}
    /**
     * Constructor de la clase Proveedor
     * 
    * @param id Identificador unico de Proveedor
    * @param nombre Nombre del Proveedor
    * @param direccion Direccion del Proveedor
    * @param telefono Telefono asociado al Proveedor
    * @param email Email asociado al Proveedor
    **/
    public Proveedor(int id, String nombre, String direccion, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }
    
    //3.Metodos

    /** 
     * Metodo para consultar el id de un proveedor
     * 
     * @return id identificador del proveedor
     **/
    public int getId() {
        return id;
    } 

    /** 
    * Metodo para asociar datos (nombre, direccion, telefono, email) a un proveedor
    * 
    * @param nombre Nombre del Proveedor
    * @param direccion Direccion del Proveedor
    * @param telefono Telefono asociado al Proveedor
    * @param email Email asociado al Proveedor
     **/
    public void setProveedor(String nombre, String direccion, String telefono, String email) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    /** 
    * Metodo para dar de baja a un proveedor
    * 
    * @param comunidadCRUD objeto que contiene los objetos de la comunidad
    * @param proveedorBorrar objeto proveedor a borrar
     **/
    public void bajaProveedor(ComunidadCRUD comunidadCRUD, Proveedor proveedorBorrar){
        comunidadCRUD.proveedores.forEach(proveedor ->{
            if(proveedor == proveedorBorrar){
                proveedor = null;
            }
        });
    }
    
    /** 
    * Metodo para actualizar los datos asociados a un proveedor
    * 
    * @param comunidadCRUD objeto que contiene los objetos asociados a la comunidad
    * @param nombre Nombre del Proveedor
    * @param direccion Direccion del Proveedor
    * @param telefono Telefono asociado al Proveedor
    * @param email Email asociado al Proveedor
    * @param proveedorModificar el objeto proveedor a modificar
     **/
    public void updateProveedor(ComunidadCRUD comunidadCRUD, String nombre, String direccion, String telefono, String email, Proveedor proveedorModificar){
        comunidadCRUD.proveedores.forEach(proveedor ->{
            if(proveedor == proveedorModificar){
                proveedor.setProveedor(nombre, direccion, telefono, email);
            }
        });
    }
    
    
    /** 
     * Metodo para consultar los datos asociados a un proveedor
     * 
     * @return String con los datos asociados al proveedor
     **/
    @Override
    public String toString() {
        return "--------Proveedor"+ id + "--------\nnombr - " + nombre + "\ndirec - " + direccion + "\ntelef - " + telefono + "\nemail - " + email + "\n";
    }
    
    
    
}
