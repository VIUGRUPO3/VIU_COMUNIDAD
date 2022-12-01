// Asignatura: 21GIIN Proyectos Programación
// Profesor: Eduardo Zamudio
// @author: Grupo 3
// Miembros:
//       @author:Fernando Hernandez Fernandez
//       @author:Javier Barbero Sales
//       @author:Martin Gonzalez Dominguez
// @version: 01/12/2022/

// Paquete
package repositorio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *  Clase que gestiona el la clase LiquidacionDetalle, que contiene los detalles de las liquidaciones
 * */
public class LiquidacionDetalle {
    
    //1.Atributos
    /**
    *  Se definen los atributos principales de la clase LiquidacionDetalle: liquidacion, inmueble, serviciosLiquidacion, gastosLiquidacion, totalLiquidacion
    * */
    
   
    private Liquidacion liquidacion;
    private Inmueble inmueble;
    private List<Servicio> serviciosLiquidacion;
    private List<GastoLiquidacion> gastosLiquidacion;
    private double totalLiquidacion;
    
    //2.Constructores

    public LiquidacionDetalle() {
        this.serviciosLiquidacion = new ArrayList();
        this.gastosLiquidacion = new ArrayList();
    }

    /**
    * Constructor de la clase LiquidacionDetalle
    * 
    * @param liquidacion objeto liquidacion a asociar
    * @param inmueble objeto inmueble al que va asociada dicha liquidacion
    **/
    public LiquidacionDetalle(Liquidacion liquidacion, Inmueble inmueble) {
        this.liquidacion = liquidacion;
        this.inmueble = inmueble;
        this.totalLiquidacion = 0;
        this.serviciosLiquidacion = new ArrayList();
        this.gastosLiquidacion = new ArrayList();
    }
    
    //3.Metodos
    
    //Getters
    /** 
     * Metodo para consultar la liquidacion de un inmueble
     * 
     * @return liquidacion objeto liquidacion del inmueble
     **/
    public Liquidacion getLiquidacion() {
        return liquidacion;
    }

    /** 
     * Metodo para consultar el inmueble asociado a la liquidacion
     * 
     * @return inmueble objeto inmueble asociado a la liquidacion
     **/
    public Inmueble getInmueble() {
        return inmueble;
    }

    /** 
     * Metodo para consultar los servicios asociados a la liquidacion
     * 
     * @return serviciosLiquidacion servicios asociados a la liquidacion
     **/
    public List<Servicio> getServiciosLiquidacion() {
        return serviciosLiquidacion;
    }

    /** 
     * Metodo para consultar los gastos asociados a la liquidacion
     * 
     * @return gastosLiquidacion gastos asociados a la liquidacion
     **/
    public List<GastoLiquidacion> getGastosLiquidacion() {
        return gastosLiquidacion;
    }

    /** 
     * Metodo para consultar el total asociado a la liquidacion
     * 
     * @return totalLiquidacion el total asociado a la liquidacion
     **/
    public double getTotalLiquidacion() {
        return totalLiquidacion;
    }
    
    //Setters

    /** 
     * Metodo para asociar un objeto liquidacion a la liquidacion actual
     * 
     * @param liquidacion objeto liquidacion a asociar
     **/
    public void setLiquidacion(Liquidacion liquidacion) {
        this.liquidacion = liquidacion;
    }

    /** 
     * Metodo para asociar un objeto inmueble a la liquidacion actual
     * 
     * @param inmueble objeto inmueble a asociar
     **/
    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    /** 
     * Metodo para asociar un listado se servicios a la liquidacion actual
     * 
     * @param serviciosLiquidacion listado de servicios a asociar
     **/
    public void setServiciosLiquidacion(List<Servicio> serviciosLiquidacion) {
        this.serviciosLiquidacion = serviciosLiquidacion;
    }

    /** 
     * Metodo para asociar un listado se gastos a la liquidacion actual
     * 
     * @param gastosLiquidacion listado de gastos a asociar
     **/
    public void setGastosLiquidacion(List<GastoLiquidacion> gastosLiquidacion) {
        this.gastosLiquidacion = gastosLiquidacion;
    }

    /** 
     * Metodo para asociar un total de liquidacion a la liquidacion actual
     * 
     * @param totalLiquidacion cantidad total de la liquidacion
     **/
    public void setTotalLiquidacion(double totalLiquidacion) {
        this.totalLiquidacion = totalLiquidacion;
    }
    
    /** Metodo que calcula el total del detalle de liquidacion
     * 
     * @param comunidadCRUD objeto comunidad que contiene toda la información de la comunidad
     */
    public void calcularLiquidacion (ComunidadCRUD comunidadCRUD){
               this.serviciosLiquidacion.forEach(servicio -> {
                   this.totalLiquidacion = totalLiquidacion + servicio.getTarifa();           
               });
               this.gastosLiquidacion.forEach(gastoLiquidacion -> {
                   this.totalLiquidacion = totalLiquidacion + gastoLiquidacion.getCuota();           
               });
    }
    
    /** Metodo que identifica los servicios a los que esta adscrito cada inmueble
     * 
     * @param comunidadCRUD objeto comunidad que contiene toda la información de la comunidad
     */
    public void identificarServiciosDetalle(ComunidadCRUD comunidadCRUD){  
        comunidadCRUD.serviciosCuenta.forEach(servicioCuenta ->{
            if(servicioCuenta.getInmueble() == this.inmueble){
                serviciosLiquidacion.add(servicioCuenta.getServicio());
            }
        });       
    }
    
    /** Metodo que identifica los gastos que han generado los servicios a los que esta adscrito el inmueble
     * 
     * @param comunidadCRUD objeto comunidad que contiene toda la información de la comunidad
     * @param fechaInicio fecha de inicio del periodo de la liquidacion actual
     * @param fechaFin fecha de final del periodo de la liquidacion actual
     * @param liquidacion objeto liquidacion que contiene los datos de la liquidacion actual
     */
    public void identificarGastosDetalle(ComunidadCRUD comunidadCRUD, LocalDate fechaInicio, LocalDate fechaFin, Liquidacion liquidacion){ 
        comunidadCRUD.gastos.forEach(gasto->{
            if(gasto.isLiquidado() == false && (
                (gasto.getFechaRegistro().isAfter(fechaInicio) && gasto.getFechaRegistro().isBefore(fechaFin)) ||
                (gasto.getFechaRegistro().isEqual(fechaInicio) || gasto.getFechaRegistro().isEqual(fechaFin))
               )){
                comunidadCRUD.gastosConcepto.forEach(gastoConcepto ->{
                if(gasto.getGastoConcepto() == gastoConcepto){
                    this.serviciosLiquidacion.forEach(servicio -> {
                        if(gastoConcepto.getServicio() == servicio){
                            GastoLiquidacion gastoLiquidacion = new GastoLiquidacion(gastoConcepto.getNombre(), gasto.getImporte()/servicio.inmueblesAdheridos(comunidadCRUD));
                            gastosLiquidacion.add(gastoLiquidacion);
                            liquidacion.getGastosLiquidados().add(gasto);
                        }
                    });
                }   
                }); 
            }             
        });
    }
    
    
    /** 
    * Metodo toString que devuelve todos los datos correspondientes a la liquidacion actual
    * 
    * @return String cadena con todos los datos correspondientes a la liquidacion actual
    **/    
    @Override
    public String toString() {
        return liquidacion + "\n" + inmueble + "\n ---- SERVICIOS A LIQUIDAR ----\n" + serviciosLiquidacion + "\n ---- GASTOS A LIQUIDAR ---- \n" + gastosLiquidacion + "\n ---- TOTAL DETALLE --- \n" + totalLiquidacion + "\n\n";
    }
    
   
    
    
    
}
