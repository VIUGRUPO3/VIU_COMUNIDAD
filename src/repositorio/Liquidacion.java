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
    
//    private List<DetalleLiquidacionGasto> gastoLiquidado;
//    private List<DetalleLiquidacionServicio> servicioLiquidado;
//    private Inmueble inmueble;
    
    
    //2.Constructores

    public Liquidacion() {}

    public Liquidacion(int id, LocalDate fechaInicio, LocalDate fechaFin) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    

    
    
    //3.Metodos

    //Getters

    public int getId() {
        return id;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

   //liquidacion.generarLiquidacion(01/11/2022, 30/11/2022, comunidadCrud, liquidacionDetalle)
   
   public void generarLiquidacion(LocalDate fechaInicio, LocalDate fechaFin, ComunidadCRUD comunidadCRUD){
       Liquidacion liquidacion = new Liquidacion(id, fechaInicio, fechaFin);
       comunidadCRUD.inmuebles.forEach(inmueble ->{
           LiquidacionDetalle liquidacionDetalle = new LiquidacionDetalle(liquidacion, inmueble);
           liquidacionDetalle.identificarServiciosInmueble(comunidadCRUD);
       });
       
   }
    
   public void generarLiquidacionInmueble(LocalDate fechaInicio, LocalDate fechaFin, ComunidadCRUD comunidadCRUD, Inmueble inmueble){
       Liquidacion liquidacion = new Liquidacion(id, fechaInicio, fechaFin);
       LiquidacionDetalle liquidacionDetalle = new LiquidacionDetalle(liquidacion, inmueble);
       liquidacionDetalle.identificarServiciosInmueble(comunidadCRUD);
        
   }

   
    
        
    //Genera las liquidaciones entre las fechas especificdas
    
//    double totalLiquidacion = 0;
//    double totalGastosServiciosFijos = 0;
//    double totalGastosServiciosOpcionales = 0;
//    
//    
//    int inmueblesAdheridos = 0;
//    double cantidadLiquidada = 0;
//    
//    
//
//    public List<Liquidacion> generarLiquidaciones(LocalDate fechaInicio, LocalDate fechaFin){
//        
//        inmuebles.forEach(inmueble ->{
//            
//                List<DetalleLiquidacionServicio> servicioLiquidado = new ArrayList();
//                List<DetalleLiquidacionGasto> gastoLiquidado = new ArrayList();
//            
//                inmueble.serviciosFijos.forEach(servicioFijo ->{
//                    DetalleLiquidacionServicio detalleServicioFijo = new DetalleLiquidacionServicio(servicioFijo, servicioLiquidado.size());
//                    servicioLiquidado.add(detalleServicioFijo);
//                    totalLiquidacion = totalLiquidacion + servicioFijo.tarifa;
//                    categorias.forEach(categoria -> {
//                       if(categoria.getServicio() == servicioFijo){
//                           gastos.forEach(gasto -> {
//                                if ( 
//                                    ((gasto.getFechaRegistro().isAfter(fechaInicio) && gasto.getFechaRegistro().isBefore(fechaFin)) || 
//                                     (gasto.getFechaRegistro().isEqual(fechaInicio) || gasto.getFechaRegistro().isEqual(fechaFin))) &&                                      
//                                      gasto.getCategoria() == categoria && gasto.isLiquidado() == false
//                                    ){                  
//                                        totalGastosServiciosFijos = gasto.getImporte()/(vecinos.size());
//                                        cantidadLiquidada += totalGastosServiciosFijos;
//                                        DetalleLiquidacionGasto detalleGasto = new DetalleLiquidacionGasto(gasto, gastoLiquidado.size(),totalGastosServiciosFijos);
//                                        gastoLiquidado.add(detalleGasto);
//                                        totalLiquidacion = totalLiquidacion + totalGastosServiciosFijos;                                        
//                                    }                              
//                           });
//                       } 
//                    });
//                });
//                
//                
//                inmueble.serviciosOpcionales.forEach(servicioOpcional -> {
//                    DetalleLiquidacionServicio detalleServicioOpcional = new DetalleLiquidacionServicio(servicioOpcional, servicioLiquidado.size());
//                    servicioLiquidado.add(detalleServicioOpcional);
//                    totalLiquidacion = totalLiquidacion + servicioOpcional.tarifa;
//                    categorias.forEach(categoria -> {
//                       if(categoria.getServicio() == servicioOpcional){
//                           gastos.forEach(gasto -> {
//                                if ( 
//                                    ((gasto.getFechaRegistro().isAfter(fechaInicio) && gasto.getFechaRegistro().isBefore(fechaFin)) || 
//                                    (gasto.getFechaRegistro().isEqual(fechaInicio) || gasto.getFechaRegistro().isEqual(fechaFin))) && 
//                                     gasto.getCategoria() == categoria && gasto.isLiquidado() == false
//                                    ){
//                                        totalGastosServiciosOpcionales = gasto.getImporte()/ this.inmueblesadheridos(servicioOpcional);            
//                                        DetalleLiquidacionGasto detalleGasto = new DetalleLiquidacionGasto(gasto, gastoLiquidado.size(),totalGastosServiciosOpcionales);
//                                        gastoLiquidado.add(detalleGasto);
//                                        totalLiquidacion = totalLiquidacion + totalGastosServiciosOpcionales;                                      
//                                    }                              
//                           });
//                       } 
//                    });
//                });     
//                
//                Liquidacion liquidacion = new Liquidacion(liquidaciones.size(), fechaInicio, fechaFin, totalLiquidacion, gastoLiquidado, servicioLiquidado, inmueble);
//                totalLiquidacion = 0;
//                liquidaciones.add(liquidacion);  
//        });
//        liquidaciones.forEach(liquidacion -> {
//            liquidacion.getGastoLiquidado().forEach(detalleGasto -> {
//               detalleGasto.gasto.setLiquidado(true);
//            });
//        });
//        return liquidaciones;   
//    }
//    
//    public List<Liquidacion> consultaLiquidacionInmueble (Inmueble inmueble){
//        List<Liquidacion> liquidacionesInmueble = new ArrayList();
//        liquidaciones.forEach(liquidacion ->{
//            if(liquidacion.getInmueble() == inmueble){        
//                liquidacionesInmueble.add(liquidacion);
//            }
//        });
//        return liquidacionesInmueble;
//    }
//    
//     public List<Liquidacion> consultaLiquidacionVecino (Vecino vecino){
//        List<Liquidacion> liquidacionesVecino = new ArrayList();
//        liquidaciones.forEach(liquidacion ->{
//            if(liquidacion.getInmueble().getVecino() == vecino){        
//                liquidacionesVecino.add(liquidacion);
//            }
//        });
//        return liquidacionesVecino;
//    }

    @Override
    public String toString() {
        return "  -------Liquidacion Nº" + id + "-------"
                + "\n------------------------------------" 
                + "\nInicio - " + fechaInicio 
                + "\nFin - " + fechaFin 
                + "\n\n";
    }
    
    
    
    
    
}
