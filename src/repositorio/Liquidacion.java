// Autor Grupo 3

//************************ INFO ************************

package repositorio;

import java.time.LocalDate;


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
   
   public void generarLiquidacion(LocalDate fechaInicio, LocalDate fechaFin, ComunidadCRUD comunidadCRUD, Liquidacion liquidacion){
       comunidadCRUD.inmuebles.forEach(inmueble ->{
           LiquidacionDetalle liquidacionDetalle = new LiquidacionDetalle(liquidacion, inmueble);
           liquidacionDetalle.identificarServiciosInmueble(comunidadCRUD);
           liquidacionDetalle.identificarGastosInmueble(comunidadCRUD, fechaInicio, fechaFin);
           liquidacionDetalle.calcularLiquidacion(comunidadCRUD);
           comunidadCRUD.liquidacionesDetalle.add(liquidacionDetalle);
       });
       
       comunidadCRUD.liquidaciones.add(liquidacion);
       
   }
   
   
    
   public void consultarLiquidacionInmueble(LocalDate fechaInicio, LocalDate fechaFin, ComunidadCRUD comunidadCRUD, Inmueble inmueble){
       Liquidacion liquidacion = new Liquidacion(id, fechaInicio, fechaFin);
       LiquidacionDetalle liquidacionDetalle = new LiquidacionDetalle(liquidacion, inmueble);
       liquidacionDetalle.identificarServiciosInmueble(comunidadCRUD);
        
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
