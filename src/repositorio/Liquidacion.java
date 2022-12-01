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
 *  Clase que gestiona las Liquidaciones
 * */
public class Liquidacion {
    
    //1.Atributos
    /**
    *  Se definen los atributos principales de la clase liquidacion: id, fechaInicio, fechaFin, gastosLiquidados
    * */
    private int id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<Gasto> gastosLiquidados;
           
    
    //2.Constructores

    public Liquidacion() {}

    /**
     * Constructor de la clase Liquidacion
     * 
    * @param id Identificador unico de Liquidacion
    * @param fechaInicio fecha de inicio de la liquidacion
    * @param fechaFin fecha de fin de la liquidacion
    **/
    public Liquidacion(int id, LocalDate fechaInicio, LocalDate fechaFin) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.gastosLiquidados = new ArrayList();
    }

    
    //3.Metodos
    //Getters

    /** 
    * Metodo para consultar el id de una liquidacion 
    * 
    * @return id identificador de liquidacion
    **/
    public int getId() {
        return id;
    }

    /** 
    * Metodo para consultar la fecha de inicio de una liquidacion 
    * 
    * @return fechaInicio fecha de comienzo de la liquidacion
    **/    
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    /** 
    * Metodo para consultar la fecha de fin de una liquidacion 
    * 
    * @return fechaInicio fecha de finalizacion de la liquidacion
    **/
    public LocalDate getFechaFin() {
        return fechaFin;
    }
    
    /** 
    * Metodo para consultar los gastos liquidados en una liquidacion 
    * 
    * @return gastosLiquidados listado de gastos liquidados en la liquidacion
    **/
    public List<Gasto> getGastosLiquidados() {
        return gastosLiquidados;
    }
    
    /** 
    * Metodo para establecer como liquidados todos los gastos correspondientes a la liquidacion
    * 
    * @param liquidacion liquidacion afectada
    **/    
     //Marca como liquidados todos los gastos correspondientes a la liquidacion
   public void liquidarGastos(Liquidacion liquidacion){
       liquidacion.gastosLiquidados.forEach(gasto ->{
           gasto.setLiquidado(true);
       });
   }


    /** 
    * Metodo para generar una liquidacion 
    * 
    * @param fechaInicio fecha de inicio de la liquidacion
    * @param fechaFin fecha de fin de la liquidacion
    * @param comunidadCRUD objeto que contiene las liquidaciones de una comunidad
    * @param liquidacion objeto que contiene la liquidacion generada
    **/   
   public void generarLiquidacion(LocalDate fechaInicio, LocalDate fechaFin, ComunidadCRUD comunidadCRUD, Liquidacion liquidacion){
       comunidadCRUD.inmuebles.forEach(inmueble ->{
           this.identificarServicios(comunidadCRUD, inmueble, liquidacion);
           this.identificarGastos(comunidadCRUD, fechaInicio, fechaFin, liquidacion, inmueble);
       });
       liquidacion.liquidarGastos(liquidacion);
       comunidadCRUD.liquidaciones.add(liquidacion);
       
   }
   
   /**Metodo que imprime una liquidacion
    * 
    * @param comunidadCRUD almacena todos los datos de la comunidad
    * @param liquidacionPrint Liquidacion que se desea imprimir
    */
   public void imprimirLiquidacion(ComunidadCRUD comunidadCRUD, Liquidacion liquidacionPrint){
       comunidadCRUD.liquidaciones.forEach(liquidacion ->{
           System.out.println(liquidacionPrint);
           if(liquidacion == liquidacionPrint){
               comunidadCRUD.inmuebles.forEach(inmueble ->{
                    double totalServicios = 0;
                    double totalGastos = 0;
                    double totalInmueble = 0;
                    System.out.println("\n" + inmueble);
                    System.out.println("---------------SERVICIOS---------------");
                    for(int index = 0; index < comunidadCRUD.liquidacionesDetalleServicio.size(); index++){
                        if(comunidadCRUD.liquidacionesDetalleServicio.get(index).getLiquidacion() == liquidacionPrint && comunidadCRUD.liquidacionesDetalleServicio.get(index).getInmueble() == inmueble){
                            System.out.println(comunidadCRUD.liquidacionesDetalleServicio.get(index));
                            totalServicios = totalServicios + comunidadCRUD.liquidacionesDetalleServicio.get(index).getCuota();
                        }
                    }

                    System.out.println("-------------------------------------------");
                    System.out.println("\n TOTAL SERVICIOS - " + totalServicios + "\n");
                    System.out.println("---------------GASTOS---------------");
                    for(int index2 = 0; index2 < comunidadCRUD.liquidacionesDetalleGasto.size(); index2++){
                        if(comunidadCRUD.liquidacionesDetalleGasto.get(index2).getLiquidacion() == liquidacionPrint && comunidadCRUD.liquidacionesDetalleGasto.get(index2).getInmueble() == inmueble){
                            System.out.println(comunidadCRUD.liquidacionesDetalleGasto.get(index2));
                            totalGastos = totalGastos + comunidadCRUD.liquidacionesDetalleGasto.get(index2).getCuota();
                        }
                    }
                    System.out.println("-------------------------------------------");
                    System.out.println("\n TOTAL GASTOS - " + totalGastos + "\n");
                    totalInmueble = totalGastos + totalServicios;  
                    System.out.println("-------------------------------------------");
                    System.out.println("\n                       TOTAL INMUEBLE - " + totalInmueble + "\n\n");


                    });
               
           }
       });
   }
   /** Metodo que identifica los servicios a los que esta adscrito cada inmueble
     * 
     * @param comunidadCRUD objeto comunidad que contiene toda la información de la comunidad
     */
    public void identificarServicios(ComunidadCRUD comunidadCRUD, Inmueble inmueble, Liquidacion liquidacion){  
        comunidadCRUD.serviciosCuenta.forEach(servicioCuenta ->{
            if(servicioCuenta.getInmueble() == inmueble){
                LiquidacionDetalleServicio liquidacionDetalleServicio = new LiquidacionDetalleServicio(servicioCuenta.getServicio(), liquidacion, inmueble, servicioCuenta.getServicio().getTarifa());
                comunidadCRUD.liquidacionesDetalleServicio.add(liquidacionDetalleServicio);
            }
        });       
    }
    
    /** Metodo que identifica los gastos de la liquidacion
     * 
     * @param comunidadCRUD
     * @param fechaInicio 
     * @param fechaFin
     * @param liquidacion
     * @param inmueble 
     */
    public void identificarGastos(ComunidadCRUD comunidadCRUD, LocalDate fechaInicio, LocalDate fechaFin, Liquidacion liquidacion, Inmueble inmueble){ 
        comunidadCRUD.gastos.forEach(gasto->{
            if(gasto.isLiquidado() == false && (
                (gasto.getFechaRegistro().isAfter(fechaInicio) && gasto.getFechaRegistro().isBefore(fechaFin)) ||
                (gasto.getFechaRegistro().isEqual(fechaInicio) || gasto.getFechaRegistro().isEqual(fechaFin))
               )){
                comunidadCRUD.gastosConcepto.forEach(gastoConcepto ->{
                if(gasto.getGastoConcepto() == gastoConcepto){
                    
                    comunidadCRUD.liquidacionesDetalleServicio.forEach(liquidacionDetalleServicio -> {
                        if(gastoConcepto.getServicio() == liquidacionDetalleServicio.getServicio() && liquidacionDetalleServicio.getInmueble() == inmueble){
                            //GastoLiquidacion gastoLiquidacion = new GastoLiquidacion(gastoConcepto.getNombre(), gasto.getImporte()/liquidacionDetalleServicio.getServicio().inmueblesAdheridos(comunidadCRUD));
                            LiquidacionDetalleGasto liquidacionDetalleGasto = new LiquidacionDetalleGasto(gastoConcepto.getNombre(), liquidacion, inmueble, gasto.getImporte()/liquidacionDetalleServicio.getServicio().inmueblesAdheridos(comunidadCRUD));
                            comunidadCRUD.liquidacionesDetalleGasto.add(liquidacionDetalleGasto);
                            this.gastosLiquidados.add(gasto);
                        }
                    });
                }   
                }); 
            }             
        });
    }
    
    /** Metodo para imprimir las liquidaciones de un inmueble espeificado
     * 
     * @param comunidadCRUD
     * @param liquidacion
     * @param inmueble 
     */ 
   public void imprimirLiquidacionInmueble(ComunidadCRUD comunidadCRUD, Liquidacion liquidacion, Inmueble inmueble){
      
               
               System.out.println("---------------SERVICIOS---------------");
               for(int index = 0; index < comunidadCRUD.liquidacionesDetalleServicio.size(); index++){                   
                   if(comunidadCRUD.liquidacionesDetalleServicio.get(index).getInmueble() == inmueble && comunidadCRUD.liquidacionesDetalleServicio.get(index).getLiquidacion() == liquidacion){
                       System.out.println(comunidadCRUD.liquidacionesDetalleServicio.get(index));
                   }
               }
               System.out.println("---------------GASTOS---------------");
               for(int index2 = 0; index2 < comunidadCRUD.liquidacionesDetalleGasto.size(); index2++){
                   if(comunidadCRUD.liquidacionesDetalleGasto.get(index2).getInmueble() == inmueble && comunidadCRUD.liquidacionesDetalleGasto.get(index2).getLiquidacion() == liquidacion){
                       System.out.println(comunidadCRUD.liquidacionesDetalleGasto.get(index2));
                   }
               }
           
       
   }

    
   
    /** 
    * Metodo que devuelve el periodo de una liquidacion
    * 
    * @return String cadena con el numero y perdiodo de una liquidacion
    **/
    @Override
    public String toString() {
        return "  -----------Liquidacion Nº" + id + "------------"
                + "\n----------------------------------------------" 
                + "\nInicio - " + fechaInicio 
                + "   ->   Fin -    " + fechaFin 
                + "\n----------------------------------------------";
    }
    
    
    
    
    
}
