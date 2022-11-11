package usuario;


//* Se declara como clase abstracta ya que define unicamente la estructura de la clase.*//
//* No se va a instanciar ningún objeto de esta clase.*//
public class Inmueble {

    /**
     * Declaración de atributos como privados para no ser accedidos por otras clases fuera del paquete.
     */

    private int idInmueble;//
    private String direccion;
    private int idUsuario;
    
    //Se declara esta variable como privada para que este protegida dentro de la clase
    //private String token;

    /**
     * Constructor "metodo que inicializa el objeto" de la clase Unmueble.
     */
    //(Dentro del constructor se incluyen los parametros)
    public Inmueble(int idInmueble, String direccion, int idUsuario){
       
        this.idInmueble = idInmueble;
        this.direccion = direccion;
        this.idUsuario = idUsuario;
    }

    /**
     * Metodo getId, para obtener el identificar de inmueble
     * 
     */
    public int getId (){
       return this.idInmueble;
    }
    
     /**
     * Metodo getDireccion, para obtener la direccion del inmueble
     * 
     */
    public String getDireccion(){
       return this.direccion;
    }
    
    /**
     * Metodo login, reliaza el login contra la app
     * 
     */
    public boolean altaInmueble (int idInmueble, String direccion, int idUsuario){
        
        boolean ok = false;
        
        this.idInmueble=idInmueble;
        this.direccion=direccion;
        this.idUsuario= idUsuario;     
        
        /* Conectar a BBDD e introducir el inmueble, devolver True o False en función de si la operacion tuvo exito o no */
        
        return ok;
    }
    
    public boolean modInmueble (int idInmueble, String direccion, int idUsuario){
        
        boolean ok = false;
        
        this.idInmueble=idInmueble;
        this.direccion=direccion;
        this.idUsuario= idUsuario;     
        
        /* Conectar a BBDD y modificar el inmueble, devolver True o False en función de si la operacion tuvo exito o no */
        
        return ok;
    }
    
    public boolean bajaInmueble (int idInmueble){
        
        boolean ok = false;
        
        /* Conectar a BBDD y dar de baja el inmueble, devolver True o False en función de si la operacion tuvo exito o no */
        
        return ok;
    }

    public String[] getConsultaServicios (int idInmueble){
        
        String[] servicios={};
        
        /* Conectar a BBDD y obtener los servicios asociados al inmueble, devolver array con idServicios asociados al inmueble */
        
        return servicios;
    }
    
    /*Metodo para imprimir en consola los datos TEMPORAL */
    public String toString(){
        return String.format("%d - %s - %d ",this.idInmueble,this.direccion, this.idUsuario) ;
    }   
    

}
