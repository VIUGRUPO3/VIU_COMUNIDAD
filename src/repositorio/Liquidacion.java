// Autor Grupo 3

//************************ INFO ************************

package repositorio;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;


public class Liquidacion {
    
    //1.Atributos
    
    private int id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double total;
    private List<DetalleLiquidacionGasto> gastoLiquidado;
    private List<DetalleLiquidacionServicio> servicioLiquidado;
    private Inmueble inmueble;
    
    
    //2.Constructores

    public Liquidacion() {}

    public Liquidacion(int id, LocalDate fechaInicio, LocalDate fechaFin, double total, List<DetalleLiquidacionGasto> gastoLiquidado, List<DetalleLiquidacionServicio> ServicioLiquidado, Inmueble inmueble) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.total = total;
        this.gastoLiquidado = gastoLiquidado;
        this.servicioLiquidado = ServicioLiquidado;
        this.inmueble = inmueble;
    }

    
    
    //3.Metodos

    //Getters
    public int getId() {
        return id;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public List<DetalleLiquidacionGasto> getGastoLiquidado() {
        return gastoLiquidado;
    }

    public List<DetalleLiquidacionServicio> getServicioLiquidado() {
        return servicioLiquidado;
    }
    
    
        
    //Genera las liquidaciones entre las fechas especificdas
    
    double totalLiquidacion = 0;
    double totalGastosServiciosFijos = 0;
    double totalGastosServiciosOpcionales = 0;
    int inmueblesAdheridos = 0;
    double cantidadLiquidada = 0;
    
    

    public List<Liquidacion> generarLiquidaciones(LocalDate fechaInicio, LocalDate fechaFin){
        
        inmuebles.forEach(inmueble ->{
            
                List<DetalleLiquidacionServicio> servicioLiquidado = new ArrayList();
                List<DetalleLiquidacionGasto> gastoLiquidado = new ArrayList();
            
                inmueble.serviciosFijos.forEach(servicioFijo ->{
                    DetalleLiquidacionServicio detalleServicioFijo = new DetalleLiquidacionServicio(servicioFijo, servicioLiquidado.size());
                    servicioLiquidado.add(detalleServicioFijo);
                    totalLiquidacion = totalLiquidacion + servicioFijo.tarifa;
                    categorias.forEach(categoria -> {
                       if(categoria.getServicio() == servicioFijo){
                           gastos.forEach(gasto -> {
                                if ( 
                                    ((gasto.getFechaRegistro().isAfter(fechaInicio) && gasto.getFechaRegistro().isBefore(fechaFin)) || 
                                     (gasto.getFechaRegistro().isEqual(fechaInicio) || gasto.getFechaRegistro().isEqual(fechaFin))) &&                                      
                                      gasto.getCategoria() == categoria && gasto.isLiquidado() == false
                                    ){                  
                                        totalGastosServiciosFijos = gasto.getImporte()/(vecinos.size());
                                        cantidadLiquidada += totalGastosServiciosFijos;
                                        DetalleLiquidacionGasto detalleGasto = new DetalleLiquidacionGasto(gasto, gastoLiquidado.size(),totalGastosServiciosFijos);
                                        gastoLiquidado.add(detalleGasto);
                                        totalLiquidacion = totalLiquidacion + totalGastosServiciosFijos;                                        
                                    }                              
                           });
                       } 
                    });
                });
                
                
                inmueble.serviciosOpcionales.forEach(servicioOpcional -> {
                    DetalleLiquidacionServicio detalleServicioOpcional = new DetalleLiquidacionServicio(servicioOpcional, servicioLiquidado.size());
                    servicioLiquidado.add(detalleServicioOpcional);
                    totalLiquidacion = totalLiquidacion + servicioOpcional.tarifa;
                    categorias.forEach(categoria -> {
                       if(categoria.getServicio() == servicioOpcional){
                           gastos.forEach(gasto -> {
                                if ( 
                                    ((gasto.getFechaRegistro().isAfter(fechaInicio) && gasto.getFechaRegistro().isBefore(fechaFin)) || 
                                    (gasto.getFechaRegistro().isEqual(fechaInicio) || gasto.getFechaRegistro().isEqual(fechaFin))) && 
                                     gasto.getCategoria() == categoria && gasto.isLiquidado() == false
                                    ){
                                        totalGastosServiciosOpcionales = gasto.getImporte()/ this.inmueblesadheridos(servicioOpcional);            
                                        DetalleLiquidacionGasto detalleGasto = new DetalleLiquidacionGasto(gasto, gastoLiquidado.size(),totalGastosServiciosOpcionales);
                                        gastoLiquidado.add(detalleGasto);
                                        totalLiquidacion = totalLiquidacion + totalGastosServiciosOpcionales;                                      
                                    }                              
                           });
                       } 
                    });
                });     
                
                Liquidacion liquidacion = new Liquidacion(liquidaciones.size(), fechaInicio, fechaFin, totalLiquidacion, gastoLiquidado, servicioLiquidado, inmueble);
                totalLiquidacion = 0;
                liquidaciones.add(liquidacion);  
        });
        liquidaciones.forEach(liquidacion -> {
            liquidacion.getGastoLiquidado().forEach(detalleGasto -> {
               detalleGasto.gasto.setLiquidado(true);
            });
        });
        return liquidaciones;   
    }
    
    public List<Liquidacion> consultaLiquidacionInmueble (Inmueble inmueble){
        List<Liquidacion> liquidacionesInmueble = new ArrayList();
        liquidaciones.forEach(liquidacion ->{
            if(liquidacion.getInmueble() == inmueble){        
                liquidacionesInmueble.add(liquidacion);
            }
        });
        return liquidacionesInmueble;
    }
    
     public List<Liquidacion> consultaLiquidacionVecino (Vecino vecino){
        List<Liquidacion> liquidacionesVecino = new ArrayList();
        liquidaciones.forEach(liquidacion ->{
            if(liquidacion.getInmueble().getVecino() == vecino){        
                liquidacionesVecino.add(liquidacion);
            }
        });
        return liquidacionesVecino;
    }

    @Override
    public String toString() {
        return "  -------Liquidacion Nº" + id + "-------"
                + "\nInmueble    - " + inmueble.getId()
                + "\nPropietario - " + inmueble.getNombreVecino() 
                + "\n------------------------------------" 
                + "\nInicio - " + fechaInicio 
                + "\nFin - " + fechaFin 
                + "\nTotal - " + total + " EUROS"
                + "\n--------Liquidacion Servicios-------\n\n"
                + servicioLiquidado
                + "\n----------Liquidacion Gastos--------\n"
                + gastoLiquidado + "\n\n";
    }
    
    
    
    
    
}
