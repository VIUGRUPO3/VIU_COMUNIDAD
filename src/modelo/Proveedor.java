// Asignatura: 21GIIN Proyectos Programación
// Profesor: Eduardo Zamudio
// @author: Grupo 3
// Miembros:
//       @author:Fernando Hernandez Fernandez
//       @author:Javier Barbero Sales
//       @author:Martin Gonzalez Dominguez
// @version: 01/12/2022/
// Paquete
package modelo;

/**
 * Clase que gestiona el tipo Proveedor
 *
 */
public class Proveedor {

    //1.Atributos
    /**
     * ID del proveedor
    *
     */
    private int id;

    /**
     * Nombre del proveedor
     */
    private String nombre;

    /**
     * Dirección del proveedor
     */
    private String direccion;

    /**
     * Teléfono del proveedor
     */
    private String telefono;

    /**
     * Correo electrónico del proveedor
     */
    private String email;

    //2.Constructores
    /**
     * Constructor de la clase Proveedor
     */
    public Proveedor() {
    }

    /**
     * Constructor de la clase Proveedor
     *
     * @param id Identificador unico de Proveedor
     * @param nombre Nombre del Proveedor
     * @param direccion Direccion del Proveedor
     * @param telefono Telefono asociado al Proveedor
     * @param email Email asociado al Proveedor
    *
     */
    public Proveedor(int id, String nombre, String direccion, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public Proveedor(String nombre, String direccion, String telefono, String email) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.id;
        return hash;
    }

    /**
     * Método para consultar el id de un proveedor
     *
     * @return id identificador del proveedor
     *
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Proveedor other = (Proveedor) obj;
        return this.id == other.id;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Método para asociar datos (nombre, direccion, telefono, email) a un
     * proveedor
     *
     * @param nombre Nombre del Proveedor
     * @param direccion Direccion del Proveedor
     * @param telefono Telefono asociado al Proveedor
     * @param email Email asociado al Proveedor
     *
     */
    public void setProveedor(String nombre, String direccion, String telefono, String email) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    /**
     * Método para dar de baja a un proveedor
     *
     * @param comunidadCRUD objeto que contiene los objetos de la comunidad
     * @param proveedorBorrar objeto proveedor a borrar
     *
     */
    public void bajaProveedor(ComunidadCRUD comunidadCRUD, Proveedor proveedorBorrar) {
        comunidadCRUD.proveedores.forEach(proveedor -> {
            if (proveedor == proveedorBorrar) {
                proveedor = null;
            }
        });
    }

    /**
     * Método para actualizar los datos asociados a un proveedor
     *
     * @param comunidadCRUD objeto que contiene los objetos asociados a la
     * comunidad
     * @param nombre Nombre del Proveedor
     * @param direccion Direccion del Proveedor
     * @param telefono Telefono asociado al Proveedor
     * @param email Email asociado al Proveedor
     * @param proveedorModificar el objeto proveedor a modificar
     *
     */
    public void updateProveedor(ComunidadCRUD comunidadCRUD, String nombre, String direccion, String telefono, String email, Proveedor proveedorModificar) {
        comunidadCRUD.proveedores.forEach(proveedor -> {
            if (proveedor == proveedorModificar) {
                proveedor.setProveedor(nombre, direccion, telefono, email);
            }
        });
    }

    /**
     * Método para consultar los datos asociados a un proveedor
     *
     * @return String con los datos asociados al proveedor
     *
     */
    @Override
    public String toString() {
        return "--------Proveedor" + id + "--------\nnombr - " + nombre + "\ndirec - " + direccion + "\ntelef - " + telefono + "\nemail - " + email + "\n";
    }

}
