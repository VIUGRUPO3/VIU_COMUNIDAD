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
    
    
//    private List<DetalleLiquidacionGasto> gastoLiquidado;
//    private List<DetalleLiquidacionServicio> servicioLiquidado;
//    private Inmueble inmueble;
    
    
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

   //liquidacion.generarLiquidacion(01/11/2022, 30/11/2022, comunidadCrud, liquidacionDetalle)

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
           LiquidacionDetalle liquidacionDetalle = new LiquidacionDetalle(liquidacion, inmueble);
           liquidacionDetalle.identificarServiciosDetalle(comunidadCRUD);
           liquidacionDetalle.identificarGastosDetalle(comunidadCRUD, fechaInicio, fechaFin, liquidacion);
           liquidacionDetalle.calcularLiquidacion(comunidadCRUD);          
           comunidadCRUD.liquidacionesDetalle.add(liquidacionDetalle);
       });
       liquidacion.liquidarGastos(liquidacion);
       comunidadCRUD.liquidaciones.add(liquidacion);
       
   }
   
   
  
    /** 
    * Metodo para consultar la liquidacion de un inmueble
    * 
    * @param fechaInicio fecha de inicio de la liquidacion
    * @param fechaFin fecha de fin de la liquidacion
    * @param comunidadCRUD objeto que contiene las liquidaciones de una comunidad
    * @param inmueble objeto inmueble del cual se va a generar la liquidacion
    **/    
   public void consultarLiquidacionInmueble(LocalDate fechaInicio, LocalDate fechaFin, ComunidadCRUD comunidadCRUD, Inmueble inmueble){
       Liquidacion liquidacion = new Liquidacion(id, fechaInicio, fechaFin);
       LiquidacionDetalle liquidacionDetalle = new LiquidacionDetalle(liquidacion, inmueble);
       liquidacionDetalle.identificarServiciosDetalle(comunidadCRUD);
        
   }

    // Metodo generar gastos en Liquidacion
   
   
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
