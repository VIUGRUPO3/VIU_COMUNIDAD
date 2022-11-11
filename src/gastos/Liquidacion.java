package gastos;


//* Se declara como clase abstracta ya que define unicamente la estructura de la clase.*//
//* No se va a instanciar ningún objeto de esta clase.*//
abstract class Liquidacion {

    /**
     * Declaración de atributos como protected para no ser accedidos por otras clases fuera del paquete.
     */

    protected int idLiquidacion;//
    protected String fecIni;
    protected String fecFin;
    protected double recibo;
    protected int idUsuario;
    
    
    /**
     * Constructor "metodo que inicializa el objeto" de la clase Gasto.
     */
    //(Dentro del constructor se incluyen los paramatros)
    protected Liquidacion(int idLiquidacion, String fecIni, String fecFin, double recibo, int idUsuario){
       
        this.idLiquidacion = idLiquidacion;
        this.fecIni = fecIni;
        this.fecFin = fecFin;
        this.recibo = recibo;
        this.idUsuario = idUsuario;
    }

    /**
     * Metodo getId, para obtener el identificar de usuario
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
                
        //Pendiente logica alta de BD gastos
        
        return ok;        
    }
    /**
    * Metodo bajaUsuario, pra eliminar usuario de BD
    * NOTA: "void" ya que no devuelve nada el metodo
    */
    public boolean bajaLiquidacion(int idUsuario){
        
        boolean ok=false;
        
        //Pendiente logica baja de BD gasto, devolver true si fue todo bien
        
        return ok;
    }
    /**
    * Metodo modUsuario, para modificar usuario de BD
    */
    public boolean modLiquidacion(int idLiquidacion, String fecIni, String fecFin, double recibo, int idUsuario){
        
        boolean ok=false;
        
        this.idLiquidacion = idLiquidacion;
        this.fecIni = fecIni;
        this.fecFin = fecFin;
        this.recibo = recibo;
        this.idUsuario = idUsuario;
        
        //Pendiente logica Modificar de BD gasto, devolver true si la modificación fue correcta
        
        return ok;
    }
    
    /**
     * Metodo login, reliaza el login contra la app
     * 
     */
    public double getCalcularLiquidacion (int idInmueble, String fecIni, String fecFin){
       
        double liquidacion=0;
        
        /*Aqui se calcularia el gasto de un servicio a lo largo de un periodo de tiempo y se devuelve el montante calculado */
        
        return liquidacion;
                
    }
    
    /*Metodo para imprimir en consola los datos TEMPORAL */
    public String toString(){
        return String.format("%d - %s - %s - %d - %d",this.idLiquidacion,this.fecIni, this.fecFin, this.recibo, this.idUsuario) ;        
    
    }   
    
}


