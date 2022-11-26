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
* ########################## INFO ##########################
*
* Descripción:
*   - 
* Peculiaridades:
*   - Clase Abstracta, ya que no se instanciara ningun objeto de esta clase.
* Herencias:
*   - N/A
* Extends:
*   - N/A
* 
****/


package repositorio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Liquidacion {
    
    //1.Atributos
    
    private int id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<Gasto> gastosLiquidados;
    
    
//    private List<DetalleLiquidacionGasto> gastoLiquidado;
//    private List<DetalleLiquidacionServicio> servicioLiquidado;
//    private Inmueble inmueble;
    
    
    //2.Constructores

    public Liquidacion() {}

    public Liquidacion(int id, LocalDate fechaInicio, LocalDate fechaFin) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.gastosLiquidados = new ArrayList();
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

    public List<Gasto> getGastosLiquidados() {
        return gastosLiquidados;
    }
    
     //Marca como liquidados todos los gastos correspondientes a la liquidacion
   public void liquidarGastos(Liquidacion liquidacion){
       liquidacion.gastosLiquidados.forEach(gasto ->{
           gasto.setLiquidado(true);
       });
   }

   //liquidacion.generarLiquidacion(01/11/2022, 30/11/2022, comunidadCrud, liquidacionDetalle)
   
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
   
   
  
    
   public void consultarLiquidacionInmueble(LocalDate fechaInicio, LocalDate fechaFin, ComunidadCRUD comunidadCRUD, Inmueble inmueble){
       Liquidacion liquidacion = new Liquidacion(id, fechaInicio, fechaFin);
       LiquidacionDetalle liquidacionDetalle = new LiquidacionDetalle(liquidacion, inmueble);
       liquidacionDetalle.identificarServiciosDetalle(comunidadCRUD);
        
   }

    // Metodo generar gastos en Liquidacion
   
   
   
    @Override
    public String toString() {
        return "  -----------Liquidacion Nº" + id + "------------"
                + "\n----------------------------------------------" 
                + "\nInicio - " + fechaInicio 
                + "   ->   Fin -    " + fechaFin 
                + "\n----------------------------------------------";
    }
    
    
    
    
    
}
