package servicios;


//* Se declara como clase abstracta ya que define unicamente la estructura de la clase.*//
//* No se va a instanciar ningún objeto de esta clase.*//
abstract class Servicio {

    /**
     * Declaración de atributos como protected para no ser accedidos por otras clases fuera del paquete.
     */

    protected int idServicio;//
    protected String tipo;
    protected double importeServicio;
    protected String descripcion;
    protected boolean costeCompartido;
    protected int idProveedor;
        
    /**
     * Constructor "metodo que inicializa el objeto" de la clase Gasto.
     */
    //(Dentro del constructor se incluyen los parametros)
    protected Servicio(int idServicio, String tipo, double importeServicio, String descripcion, boolean costeCompartido, int idProveedor){
       
        this.idServicio = idServicio;
        this.tipo = tipo;
        this.importeServicio = importeServicio;
        this.descripcion = descripcion;
        this.costeCompartido = costeCompartido;
        this.idProveedor = idProveedor;
    }

    /**
     * Metodo getId, para obtener el identificar de usuario
     * 
     */
    public int getId (){
       return this.idServicio;
    }
        
     public boolean altaServicio(int idServicio, String tipo, double importeServicio, String descripcion, boolean costeCompartido, int idProveedor){
        boolean ok=false;
        
        this.idServicio = idServicio;
        this.tipo = tipo;
        this.importeServicio = importeServicio;
        this.descripcion = descripcion;
        this.costeCompartido = costeCompartido;
        this.idProveedor = idProveedor;
                
        //Pendiente logica alta de BD gastos
        
        return ok;        
    }
    /**
    * Metodo bajaUsuario, para eliminar usuario de BD
    * NOTA: "void" ya que no devuelve nada el metodo
    */
    public boolean bajaServicio(int idServicio){
        
        boolean ok=false;
        
        //Pendiente logica baja de BD gasto, devolver true si fue todo bien
        
        return ok;
    }
    /**
    * Metodo modUsuario, para modificar servicio de BD
    */
    public boolean modServicio(int idServicio, String tipo, double importeServicio, String descripcion, boolean costeCompartido, int idProveedor){
        
        boolean ok=false;
        
        this.idServicio = idServicio;
        this.tipo = tipo;
        this.importeServicio = importeServicio;
        this.descripcion = descripcion;
        this.costeCompartido = costeCompartido;
        this.idProveedor = idProveedor;
        
        //Pendiente logica Modificar de BD servicio, devolver true si la modificación fue correcta
        
        return ok;
    }
    
    /*Metodo para imprimir en consola los datos TEMPORAL */
    public String toString(){
        return String.format("%d - %s - %d - %s - %b - %d",this.idServicio,this.tipo, this.importeServicio, this.descripcion, this.costeCompartido , this.idProveedor) ;        
    
    }   
    
}


