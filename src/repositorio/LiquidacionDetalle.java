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
abstract class LiquidacionDetalle {
    
    //1.Atributos
    /**
    *  Se definen los atributos principales de la clase LiquidacionDetalle: liquidacion, inmueble, serviciosLiquidacion, gastosLiquidacion, totalLiquidacion
    * */
    
   
    protected Liquidacion liquidacion;
    protected Inmueble inmueble;
    protected double cuota;
    
    //2.Constructores

    public LiquidacionDetalle() {}

    /**
    * Constructor de la clase LiquidacionDetalle
    * 
    * @param liquidacion objeto liquidacion a asociar
    * @param inmueble objeto inmueble al que va asociada dicha liquidacion
    **/
    public LiquidacionDetalle(Liquidacion liquidacion, Inmueble inmueble, double cuota) {
        this.liquidacion = liquidacion;
        this.inmueble = inmueble;
        this.cuota = cuota;
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
     * Metodo para consultar el total asociado a la liquidacion
     * 
     * @return totalLiquidacion el total asociado a la liquidacion
     **/
    public double getCuota() {
        return cuota;
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
     * Metodo para asociar un total de liquidacion a la liquidacion actual
     * 
     * @param totalLiquidacion cantidad total de la liquidacion
     **/
    public void setTotalLiquidacion(double cuota) {
        this.cuota = cuota;
    }
    
    /** Metodo que calcula el total del detalle de liquidacion
     * 
     * @param comunidadCRUD objeto comunidad que contiene toda la información de la comunidad
     */
    
    
    
    
   
    
    
    
}
