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
    private Servicio servicio;

    //Constructores
    /**
     * Constructor de la clase LiquidacionDetalleServicio
     */
    public LiquidacionDetalleServicio() {
    }

    /**
     * Constructor de la clase LiquidacionDetalleServicio
     *
     * @param servicio Objeto servicio que contiene todos los detalles del
     * servicio al que se le va a detallar la liquidación
     * @param liquidacion Objeto liquidación que contiene todos los detalles de
     * la liquidación
     * @param inmueble Objeto inmueble que contiene todos los detalles del
     * inmueble al que se le va a detallar la liquidación
     * @param cuota cuota a pagar en la liquidación
     */
    public LiquidacionDetalleServicio(Servicio servicio, Liquidacion liquidacion, Inmueble inmueble, double cuota) {
        super(liquidacion, inmueble, cuota);
        this.servicio = servicio;
    }

    //Métodos
    //Getters
    /**
     * Método para obtener el servicio relativo a los detalles de la liquidación
     *
     * @return servicio Objeto servicio que contiene todos los detalles del
     * servicio al que se le va a detallar la liquidación
     */
    public Servicio getServicio() {
        return servicio;
    }

    //Setters
    /**
     * Método para establecer el servicio relativo a los detalles de la
     * liquidación
     *
     * @param servicio Objeto servicio que contiene todos los detalles del
     * servicio al que se le va a detallar la liquidación
     */
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
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
        return "" + servicio;
    }

}
