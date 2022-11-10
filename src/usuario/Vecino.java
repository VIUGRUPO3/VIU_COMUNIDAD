package usuario;

/*Clase que hereda de Usuario*/

public class Vecino extends Usuario {

    /**
    * Constructor de la clase vecino.
    */
    public Vecino(int id,String nombre, String clave, String telefono, String email, String tipo) {
        super(id,nombre, clave, telefono, email, tipo);
    }
  
    
}

