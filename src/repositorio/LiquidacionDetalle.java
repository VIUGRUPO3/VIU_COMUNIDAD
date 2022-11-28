/****
* 
* Asignatura: 21GIIN Proyectos Programación
* Profesor: Eduardo Zamudio
* @author: Grupo 3
* Miembros:
*       @author:Fernando Hernandez Fernandez
*       @author:Javier Barbero Sales
*       @author:Martin Gonzalez Dominguez
* @version: 01/12/2022/A 
* 

* 
****/

package repositorio;

import java.time.LocalDate;
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
    private List<GastoLiquidacion> gastosLiquidacion;
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
    
    //Getters

    public Liquidacion getLiquidacion() {
        return liquidacion;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public List<Servicio> getServiciosLiquidacion() {
        return serviciosLiquidacion;
    }

    public List<GastoLiquidacion> getGastosLiquidacion() {
        return gastosLiquidacion;
    }

    public double getTotalLiquidacion() {
        return totalLiquidacion;
    }
    
    //Setters

    public void setLiquidacion(Liquidacion liquidacion) {
        this.liquidacion = liquidacion;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public void setServiciosLiquidacion(List<Servicio> serviciosLiquidacion) {
        this.serviciosLiquidacion = serviciosLiquidacion;
    }

    public void setGastosLiquidacion(List<GastoLiquidacion> gastosLiquidacion) {
        this.gastosLiquidacion = gastosLiquidacion;
    }

    public void setTotalLiquidacion(double totalLiquidacion) {
        this.totalLiquidacion = totalLiquidacion;
    }
    
    //Metodo que calcula el total del detalle de liquidacion
    
    public void calcularLiquidacion (ComunidadCRUD comunidadCRUD){
               this.serviciosLiquidacion.forEach(servicio -> {
                   this.totalLiquidacion = totalLiquidacion + servicio.getTarifa();           
               });
               this.gastosLiquidacion.forEach(gastoLiquidacion -> {
                   this.totalLiquidacion = totalLiquidacion + gastoLiquidacion.getCuota();           
               });
    }
    
    //Metodo que identifica los servicios a los que esta adscrito cada inmueble
    
    public void identificarServiciosDetalle(ComunidadCRUD comunidadCRUD){  
        comunidadCRUD.serviciosCuenta.forEach(servicioCuenta ->{
            if(servicioCuenta.getInmueble() == this.inmueble){
                serviciosLiquidacion.add(servicioCuenta.getServicio());
            }
        });       
    }
    
    //Metodo que identifica los gastos que han generado los servicios a los que esta adscrito el inmueble
    
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
    
    
    
    @Override
    public String toString() {
        return liquidacion + "\n" + inmueble + "\n ---- SERVICIOS A LIQUIDAR ----\n" + serviciosLiquidacion + "\n ---- GASTOS A LIQUIDAR ---- \n" + gastosLiquidacion + "\n ---- TOTAL DETALLE --- \n" + totalLiquidacion + "\n\n";
    }
    
   
    
    
    
}
