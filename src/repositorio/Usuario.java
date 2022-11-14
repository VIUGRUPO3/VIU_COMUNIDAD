package repositorio;

import java.util.ArrayList;
import java.util.List;


//* Se declara como clase abstracta ya que define unicamente la estructura de la clase.*//
//* No se va a instanciar ningún objeto de esta clase.*//
public class Usuario {

    //1, Atributos
        // Declaración de atributos como protected para no ser accedidos por otras clases fuera del paquete.
    
    protected int id;//
    protected String nombre;
    protected String clave;
    protected String telefono;
    protected String email;
    
    private int logged;
        //Se declara esta variable como privada para que este protegida dentro de la clase    
    
    //2. Constructor
        // Constructor "metodo que inicializa el objeto" de la clase Usuario.
        //(Dentro del constructor se incluyen los parametros)
        //Como buena practica se crea un constructor vacio
    
    public Usuario(){
        
        
    }

    public Usuario(int id, String nombre, String clave, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
        this.telefono = telefono;
        this.email = email;
        
    }

    

   

    //3. Metodos
        
        //Metodo getId, para obtener el identificar de usuario
    public int getId (){
       return id;
    }
    
        //Metodo toString que sobreescribe el heredado de la clase Object

    @Override
    public String toString() {
        return "Usuario" + id + "\nnombr - " + nombre + "\nclave - " + clave + "\ntelef - " + telefono + "\nemail - " + email + "\n\n";
    }   
    
    public int login(String email, String clave){
        if(this.email == email){
                if (this.clave == clave){
                 logged = this.id;
                }
            }
        return logged;
    }
    
}
