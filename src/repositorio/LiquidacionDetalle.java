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

/**
 * Clase que gestiona el la clase LiquidacionDetalle, que contiene los detalles
 * de las liquidaciones
 *
 */
abstract class LiquidacionDetalle {

    //1.Atributos
    /**
     * Objeto liquidación con los datos de la liquidación con la que está
     * relacionada
    *
     */
    protected Liquidacion liquidacion;

    /**
     * Objeto inmueble con los datos del inmueble con el que está relacionado
     */
    protected Inmueble inmueble;

    /**
     * Cuota a pagar en la liquidación
     */
    protected double cuota;

    //2.Constructores
    /**
     * Constructor de la clase LiquidacionDetalle
     */
    public LiquidacionDetalle() {
    }

    /**
     * Constructor de la clase LiquidacionDetalle
     *
     * @param liquidacion objeto liquidacion a asociar
     * @param inmueble objeto inmueble al que va asociada dicha liquidacion
    *
     */
    public LiquidacionDetalle(Liquidacion liquidacion, Inmueble inmueble, double cuota) {
        this.liquidacion = liquidacion;
        this.inmueble = inmueble;
        this.cuota = cuota;
    }

    //3.Métodos
    //Getters
    /**
     * Método para consultar la liquidacion de un inmueble
     *
     * @return liquidacion objeto liquidacion del inmueble
     *
     */
    public Liquidacion getLiquidacion() {
        return liquidacion;
    }

    /**
     * Método para consultar el inmueble asociado a la liquidacion
     *
     * @return inmueble objeto inmueble asociado a la liquidacion
     *
     */
    public Inmueble getInmueble() {
        return inmueble;
    }

    /**
     * Método para consultar el total asociado a la liquidacion
     *
     * @return totalLiquidacion el total asociado a la liquidacion
     *
     */
    public double getCuota() {
        return cuota;
    }

    //Setters
    /**
     * Método para asociar un objeto liquidacion a la liquidacion actual
     *
     * @param liquidacion objeto liquidacion a asociar
     *
     */
    public void setLiquidacion(Liquidacion liquidacion) {
        this.liquidacion = liquidacion;
    }

    /**
     * Método para asociar un objeto inmueble a la liquidacion actual
     *
     * @param inmueble objeto inmueble a asociar
     *
     */
    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    /**
     * Método para asociar un total de liquidacion a la liquidacion actual
     *
     * @param cuota cantidad total de la liquidacion
     *
     */
    public void setTotalLiquidacion(double cuota) {
        this.cuota = cuota;
    }

    /**
     * Método que calcula el total del detalle de liquidacion
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la comunidad
     */
}
