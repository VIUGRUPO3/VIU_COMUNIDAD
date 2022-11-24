
package repositorio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fer
 */
public class LiquidacionDetalle {
    
    //1.Atributos
    private Liquidacion liquidacion;
    private Inmueble inmueble;
    private List<Servicio> serviciosLiquidacion;
    private List<Gasto> gastosLiquidacion;
    private double totalLiquidacion;
    
    //2.Constructores

    public LiquidacionDetalle() {
        this.serviciosLiquidacion = new ArrayList();
        this.gastosLiquidacion = new ArrayList();
    }

    public LiquidacionDetalle(Liquidacion liquidacion, Inmueble inmueble) {
        this.liquidacion = liquidacion;
        this.inmueble = inmueble;
        this.totalLiquidacion = 0;
        this.serviciosLiquidacion = new ArrayList();
        this.gastosLiquidacion = new ArrayList();
    }
    
    //3.Metodos
    
    public void identificarServiciosInmueble(ComunidadCRUD comunidadCRUD){  
        comunidadCRUD.serviciosCuenta.forEach(servicioCuenta ->{
            if(servicioCuenta.getInmueble() == this.inmueble){
                serviciosLiquidacion.add(servicioCuenta.getServicio());
            }
        });       
        
    }
    
    
    public void identificarGastosInmueble(ComunidadCRUD comunidadCRUD, Inmueble inmueble){  
        
        

    }
    public int inmueblesAdheridosServicio(ComunidadCRUD comunidadCRUD, Servicio servicio){
        return 0;
        //TODO: implementar logica 
    }
    
   
    
    
    
}
