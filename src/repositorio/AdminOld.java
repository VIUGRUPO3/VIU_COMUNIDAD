
package repositorio;

/**
 * Clase que hereda de Usuario
 */
public class AdminOld extends Usuario {
    
    //1.Atributos
        //Atributos de la clase Admin
    private String mensaje;
    
    //2.Constructores
        // Constructor de la clase Admin.

    public AdminOld() {}

    public AdminOld(int id, String nombre, String clave, String telefono, String email) {
        super(id, nombre, clave, telefono, email);
    }

    //3.Metodos
        
    
    
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
