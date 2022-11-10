
package usuario;

/**
 * Clase que hereda de Usuario
 */
public class Admin extends Usuario {
    
    //*Atributos de la clase Admin*/
    private String mensaje;
    
    /**
    * Constructor de la clase Admin.
    */
    public Admin(int idUsuario, String nombre, String clave, String telefono, String email, String tipo) {
        super(idUsuario, nombre, clave, telefono, email, tipo);
    }
    /**
    * Metodo altaUsuario, para crear usuario de BD
    * NOTA: "void" ya que no devuelve nada el metodo
    */
    public void altaUsuario (int idUsuario, String nombre, String clave, String telefono, String email, String tipo){
        this.idUsuario=idUsuario;
        this.nombre = nombre;
        this.clave = clave;
        this.telefono = telefono;
        this.email = email;
        this.tipo = tipo;
        //Pendiente logica alta de BD usuario
    }
    /**
    * Metodo bajaUsuario, pra eliminar usuario de BD
    * NOTA: "void" ya que no devuelve nada el metodo
    */
    public void bajaUsuario (int idUsuario){
        this.idUsuario=idUsuario;
        //Pendiente logica baja de BD usuario
    }
    /**
    * Metodo modUsuario, para modificar usuario de BD
    */
    public String modUsuario (int idUsuario, String nombre, String clave, String telefono, String email, String tipo){
        this.idUsuario=idUsuario;
        this.nombre = nombre;
        this.clave = clave;
        this.telefono = telefono;
        this.email = email;
        this.tipo = tipo;
        //variable privada mensaje de Metodo
        this.mensaje="Modificacion usuario correcto"; //Pendiente de logica
        //Pendiente logica Modificar de BD usuario
        
        return mensaje;
    }
    
    /**
    * Metodo setVincularInmuebleServicio
    * NOTA: "void" ya que no devuelve nada el metodo
    */
    public void setVincularInmuebleServicio (int IdInmueble, int IdServicio){
        //Pendiente logica insert
    }
    
    /**
    * Metodo setDesvincularInmuebleServicio
    * NOTA: "void" ya que no devuelve nada el metodo
    */
    public void setDesvincularInmuebleServicio (int IdInmueble, int IdServicio){
        //Pendiente logica delete
    }
    
        /**
    * Metodo setVincularInmuebleUsuario
    * NOTA: "void" ya que no devuelve nada el metodo
    */
    public void setVincularInmuebleUsuario (int IdInmueble, int IdUsuario){
        //Pendiente logica insert
    }
    
            /**
    * Metodo setDesvincularInmuebleUsuario
    * NOTA: "void" ya que no devuelve nada el metodo
    */
    public void setDesvincularInmuebleUsuario (int IdInmueble, int IdUsuario){
        //Pendiente logica delete
    }
    
}
