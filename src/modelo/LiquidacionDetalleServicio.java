// Asignatura: 21GIIN Proyectos Programación
// Profesor: Eduardo Zamudio
// @author: Grupo 3
// Miembros:
//       @author:Fernando Hernandez Fernandez
//       @author:Javier Barbero Sales
//       @author:Martin Gonzalez Dominguez
// @version: 01/12/2022/
// Paquete
package modelo;

/**
 *
 * Clase que contiene los detalles del servicio de la liquidación
 */
public class LiquidacionDetalleServicio extends LiquidacionDetalle {

    //Atributos
    /**
     * Objeto servicio que contiene todos los detalles del servicio al que se le
     * va a detallar la liquidación
     */
    

    //Constructores
    /**
     * Constructor de la clase LiquidacionDetalleServicio
     */
    public LiquidacionDetalleServicio() {
    }

    public LiquidacionDetalleServicio(Liquidacion liquidacion, ServicioCuenta sc, double cuota) {
        super(liquidacion, sc, cuota);
    }

    public Liquidacion getLiquidacion() {    
        return liquidacion;
    }

    public ServicioCuenta getSc() {    
        return sc;
    }

    //Métodos
    //Getters
    public double getCuota() {   
        return cuota;
    }

    public void setLiquidacion(Liquidacion liquidacion) {
        this.liquidacion = liquidacion;
    }

    public void setSc(ServicioCuenta sc) {
        this.sc = sc;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    

    /**
     * Función que devuelve una cadena con el servicio correspondiente al
     * LiquidacionDetalleServicio actual
     *
     * @return String cadena con el servicio correspondiente al
     * LiquidacionDetalleServicio actual
     */
    @Override
    public String toString() {
        return "" + sc;
    }

}
