package usuario;


//* Se declara como clase abstracta ya que define unicamente la estructura de la clase.*//
//* No se va a instanciar ningún objeto de esta clase.*//
abstract class Usuario {

    /**
     * Declaración de atributos como protected para no ser accedidos por otras clases fuera del paquete.
     */

    protected int idUsuario;//
    protected String nombre;
    protected String clave;
    protected String telefono;
    protected String email;
    protected String tipo;
    //Se declara esta variable como privada para que este protegida dentro de la clase
    private String token;

    /**
     * Constructor "metodo que inicializa el objeto" de la clase Usuario.
     */
    //(Dentro del constructor se incluyen los parametros)
    protected Usuario(int idUsuario, String nombre, String clave, String telefono, String email, String tipo){
       
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.clave = clave;
        this.telefono = telefono;
        this.email = email;
        this.tipo = tipo;

    }

    /**
     * Metodo getId, para obtener el identificar de usuario
     * 
     */
    public int getId (){
       return this.idUsuario;
    }
    
     /**
     * Metodo getRol, para obtener el rol de usuario "Admin" o "Vecino"
     * 
     */
    public String getRol (){
       return this.tipo;
    }
    
    /**
     * Metodo login, reliaza el login contra la app
     * 
     */
    public String login (int idUsuario, String email, String clave){
       
        this.idUsuario= idUsuario;
        this.email=email;
        this.clave=clave;
        this.token = "Email incorrecto"; //Pendiente de logica
        // Variable para la logica de login
        String emailBd;
        String claveBd;
        /*
        Incluir logica de login 
        */       
        //Pendiente consulta a BD con idUsuario para comprobar el email y la clave y validar si es correcto
      
               
        return token;
        
        
    }
    
    /*Metodo para imprimir en consola los datos TEMPORAL */
    public String toString(){
        return String.format("%d - %s - %s - %s - %s - %s",this.idUsuario,this.nombre, this.clave, this.telefono, this.email, this.tipo) ;
    }   
    

}
