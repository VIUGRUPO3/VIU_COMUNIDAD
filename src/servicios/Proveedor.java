package servicios;


//* Se declara como clase abstracta ya que define unicamente la estructura de la clase.*//
//* No se va a instanciar ningún objeto de esta clase.*//
abstract class Proveedor {

    /**
     * Declaración de atributos como protected para no ser accedidos por otras clases fuera del paquete.
     */

    protected int idProveedor;//
    protected String nombre;
    protected String telf;
    protected String email;
    protected String direccion;
    
    
    /**
     * Constructor "metodo que inicializa el objeto" de la clase Proveedor.
     */
    //(Dentro del constructor se incluyen los paramatros)
    protected Proveedor(int idProveedor, String nombre, String telf, String email, String direccion){
       
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
                
        //Pendiente logica alta de BD gastos
        
        return ok;        
    }
    /**
    * Metodo bajaUsuario, pra eliminar usuario de BD
    * NOTA: "void" ya que no devuelve nada el metodo
    */
    public boolean bajaProveedor(int idProveedor){
        
        boolean ok=false;
        
        //Pendiente logica baja de BD gasto, devolver true si fue todo bien
        
        return ok;
    }
    /**
    * Metodo modUsuario, para modificar usuario de BD
    */
    public boolean modProveedor(int idProveedor, String nombre, String telf, String email, String direccion){
        
        boolean ok=false;
        
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.telf = telf;
        this.email = email;
        this.direccion = direccion;
        
        //Pendiente logica Modificar de BD gasto, devolver true si la modificación fue correcta
        
        return ok;
    }
    
    /**
     * Metodo login, reliaza el login contra la app
     * 
     */
       
    /*Metodo para imprimir en consola los datos TEMPORAL */
    public String toString(){
        return String.format("%d - %s - %s - %s - %s",this.idProveedor,this.nombre, this.telf, this.email, this.direccion) ;        
    
    }   
    
}


