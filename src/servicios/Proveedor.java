package servicios;


//* Se declara como clase abstracta ya que define unicamente la estructura de la clase.*//
//* No se va a instanciar ningún objeto de esta clase.*//
public class Proveedor {

    /**
     * Declaración de atributos como privados para no ser accedidos por otras clases fuera del paquete.
     */

    private int idProveedor;//
    private String nombre;
    private String telf;
    private String email;
    private String direccion;
    
    
    /**
     * Constructor "metodo que inicializa el objeto" de la clase Proveedor.
     */
    //(Dentro del constructor se incluyen los parametros)
    public Proveedor(int idProveedor, String nombre, String telf, String email, String direccion){
       
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.telf = telf;
        this.email = email;
        this.direccion = direccion;
    }

    /**
     * Metodo getId, para obtener el identificar de Proveedor
     * 
     */
    public int getId (){
       return this.idProveedor;
    }
        
     public boolean altaProveedor(int idProveedor, String nombre, String telf, String email, String direccion){
        boolean ok=false;
        
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.telf = telf;
        this.email = email;
        this.direccion = direccion;
                
        //Pendiente logica alta de BD Proveedor
        
        return ok;        
    }
    /**
    * Metodo bajaProveedor, para eliminar proveedor de BD
    
    */
    public boolean bajaProveedor(int idProveedor){
        
        boolean ok=false;
        
        //Pendiente logica baja de BD gasto, devolver true si fue todo bien
        
        return ok;
    }
    /**
    * Metodo modProveedor, para modificar proveedor de BD
    */
    public boolean modProveedor(int idProveedor, String nombre, String telf, String email, String direccion){
        
        boolean ok=false;
        
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.telf = telf;
        this.email = email;
        this.direccion = direccion;
        
        //Pendiente logica Modificar de BD proveedor, devolver true si la modificación fue correcta
        
        return ok;
    }
    
      
    /*Metodo para imprimir en consola los datos TEMPORAL */
    public String toString(){
        return String.format("%d - %s - %s - %s - %s",this.idProveedor,this.nombre, this.telf, this.email, this.direccion) ;        
    
    }   
    
}


