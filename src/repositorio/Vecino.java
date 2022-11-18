// Autor Grupo 3

//************************ INFO ************************



package repositorio;


/*Clase que hereda de Usuario*/

public class Vecino extends Usuario {

    //1. Atributos
    
    
    
    //2. Constructores
    
    public Vecino() {}

    public Vecino(int id, String nombre, String clave, String telefono, String email) {
        super(id, nombre, clave, telefono, email);
    }
    
    //3.Metodos

    //Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getClave() {
        return clave;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public boolean isLogged() {
        return logged;
    }
     

    //Setters
    
    public void setId(int id) {
        this.id = id;
    }
   
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }
    
    
 
       
}

