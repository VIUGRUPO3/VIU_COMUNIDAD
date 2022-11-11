package gastos;


//* Se declara como clase abstracta ya que define unicamente la estructura de la clase.*//
//* No se va a instanciar ningún objeto de esta clase.*//
public class Liquidacion {

    /**
     * Declaración de atributos como protected para no ser accedidos por otras clases fuera del paquete.
     */

    private int idLiquidacion;//
    private String fecIni;
    private String fecFin;
    private double recibo;
    private int idUsuario;
    
    
    /**
     * Constructor "metodo que inicializa el objeto" de la clase Liquidación.
     */
    //(Dentro del constructor se incluyen los parametros)
    public Liquidacion(int idLiquidacion, String fecIni, String fecFin, double recibo, int idUsuario){
       
        this.idLiquidacion = idLiquidacion;
        this.fecIni = fecIni;
        this.fecFin = fecFin;
        this.recibo = recibo;
        this.idUsuario = idUsuario;
    }

    /**
     * Metodo getId, para obtener el identificar de Liquidación
     * 
     */
    public int getId (){
       return this.idLiquidacion;
    }
        
     public boolean altaLiquidacion(int idLiquidacion, String fecIni, String fecFin, double recibo, int idUsuario){
        boolean ok=false;
        
        this.idLiquidacion = idLiquidacion;
        this.fecIni = fecIni;
        this.fecFin = fecFin;
        this.recibo = recibo;
        this.idUsuario = idUsuario;
                
        //Pendiente logica alta de BD Liquidacion
        
        return ok;        
    }
    /**
    * Metodo bajaLiquidacion, para eliminar liquidacion de BD
    */
    public boolean bajaLiquidacion(int idUsuario){
        
        boolean ok=false;
        
        //Pendiente logica baja de BD liquidacion, devolver true si fue todo bien
        
        return ok;
    }
    /**
    * Metodo modLiquidacion, para modificar liquidacion de BD
    */
    public boolean modLiquidacion(int idLiquidacion, String fecIni, String fecFin, double recibo, int idUsuario){
        
        boolean ok=false;
        
        this.idLiquidacion = idLiquidacion;
        this.fecIni = fecIni;
        this.fecFin = fecFin;
        this.recibo = recibo;
        this.idUsuario = idUsuario;
        
        //Pendiente logica Modificar de BD liquidacion, devolver true si la modificación fue correcta
        
        return ok;
    }
    
    /**
     * Metodo getCalcularLiquidacion, calcula la liquidación para el inmueble asociado
     * 
     */
    public double getCalcularLiquidacion (int idInmueble, String fecIni, String fecFin){
       
        double liquidacion=0;
        
        /*Aqui se calcularia obtendrian los gastos asociados a un periodo de tiempo y se devuelve el montante calculado */
        
        return liquidacion;
                
    }
    
    /*Metodo para imprimir en consola los datos TEMPORAL */
    public String toString(){
        return String.format("%d - %s - %s - %d - %d",this.idLiquidacion,this.fecIni, this.fecFin, this.recibo, this.idUsuario) ;        
    
    }   
    
}


