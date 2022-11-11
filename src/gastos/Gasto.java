package gastos;


//* Se declara como clase abstracta ya que define unicamente la estructura de la clase.*//
//* No se va a instanciar ningún objeto de esta clase.*//
public class Gasto {

    /**
     * Declaración de atributos como privados para no ser accedidos por otras clases fuera del paquete.
     */

    private int idGasto;//
    private String fecAltaGasto;
    private double costeGasto;
    private String descripcion;
    private int idUsuario;
    private int idServicio;
    private int idLiquidacion;
    private String fecPago;
    
    /**
     * Constructor "metodo que inicializa el objeto" de la clase Gasto.
     */
    //(Dentro del constructor se incluyen los parametros)
    public Gasto(int idGasto, String fecAltaGasto , double costeGasto, String descripcion, int idUsuario, int idServicio, int idLiquidacion, String fecPago){
       
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
     * Metodo getId, para obtener el identificar de Gasto
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
    * Metodo bajaUsuario, para eliminar Gasto de BD
    */
    public boolean bajaGasto (int idGasto){
        
        boolean ok=false;
        
        //Pendiente logica baja de BD gasto, devolver true si fue todo bien
        
        return ok;
    }
    /**
    * Metodo modGasto, para modificar gasto de BD
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
     * Metodo getCalcularGasto, calcula el gasto acumulado durante un periodo de tiempo por un inmueble     * 
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


