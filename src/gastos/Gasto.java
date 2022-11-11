package gastos;


//* Se declara como clase abstracta ya que define unicamente la estructura de la clase.*//
//* No se va a instanciar ningún objeto de esta clase.*//
abstract class Gasto {

    /**
     * Declaración de atributos como protected para no ser accedidos por otras clases fuera del paquete.
     */

    protected int idGasto;//
    protected String fecAltaGasto;
    protected double costeGasto;
    protected String descripcion;
    protected int idUsuario;
    protected int idServicio;
    protected int idLiquidacion;
    protected String fecPago;
    
    /**
     * Constructor "metodo que inicializa el objeto" de la clase Gasto.
     */
    //(Dentro del constructor se incluyen los paramatros)
    protected Gasto(int idGasto, String fecAltaGasto , double costeGasto, String descripcion, int idUsuario, int idServicio, int idLiquidacion, String fecPago){
       
        this.idGasto = idGasto;
        this.fecAltaGasto = fecAltaGasto;
        this.costeGasto = costeGasto;
        this.descripcion = descripcion;
        this.idUsuario = idUsuario;
        this.idServicio = idServicio;
        this.idLiquidacion = idLiquidacion;
        this.fecPago = fecPago;
    }

    /**
     * Metodo getId, para obtener el identificar de usuario
     * 
     */
    public int getId (){
       return this.idGasto;
    }
        
     public boolean altaGasto(int idGasto, String fecAltaGasto , double costeGasto, String descripcion, int idUsuario, int idServicio, int idLiquidacion, String fecPago){
        boolean ok=false;
        
        this.idGasto = idGasto;
        this.fecAltaGasto = fecAltaGasto;
        this.costeGasto = costeGasto;
        this.descripcion = descripcion;
        this.idUsuario = idUsuario;
        this.idServicio = idServicio;
        this.idLiquidacion = idLiquidacion;
        this.fecPago = fecPago;
                
        //Pendiente logica alta de BD gastos
        
        return ok;        
    }
    /**
    * Metodo bajaUsuario, pra eliminar usuario de BD
    * NOTA: "void" ya que no devuelve nada el metodo
    */
    public boolean bajaGasto (int idUsuario){
        
        boolean ok=false;
        
        //Pendiente logica baja de BD gasto, devolver true si fue todo bien
        
        return ok;
    }
    /**
    * Metodo modUsuario, para modificar usuario de BD
    */
    public boolean modGasto(int idGasto, String fecAltaGasto , double costeGasto, String descripcion, int idUsuario, int idServicio, int idLiquidacion, String fecPago){
        
        boolean ok=false;
        
        this.idGasto = idGasto;
        this.fecAltaGasto = fecAltaGasto;
        this.costeGasto = costeGasto;
        this.descripcion = descripcion;
        this.idUsuario = idUsuario;
        this.idServicio = idServicio;
        this.idLiquidacion = idLiquidacion;
        this.fecPago = fecPago;
        
        //Pendiente logica Modificar de BD gasto, devolver true si la modificación fue correcta
        
        return ok;
    }
    
    /**
     * Metodo login, reliaza el login contra la app
     * 
     */
    public double getCalcularGasto (int idInmueble, String fecIni, String fecFin){
       
        double gasto=0;
        
        /*Aqui se calcularia el gasto de un servicio a lo largo de un periodo de tiempo y se devuelve el montante calculado */
        
        return gasto;
                
    }
    
    /*Metodo para imprimir en consola los datos TEMPORAL */
    public String toString(){
        return String.format("%d - %s - %d - %s - %d - % d - %d - %s",this.idGasto,this.fecAltaGasto, this.costeGasto, this.descripcion, this.idUsuario, this.idServicio, this.idLiquidacion, this.fecPago) ;        
    
    }   
    
}


