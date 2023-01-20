// Asignatura: 21GIIN Proyectos Programación
// Profesor: Eduardo Zamudio
// @author: Grupo 3
// Miembros:
//       @author:Fernando Hernandez Fernandez
//       @author:Javier Barbero Sales
//       @author:Martin Gonzalez Dominguez
// @version: 01/12/2022/
//Paquete
package modelo;

/**
 *
 * Clase que contiene los detalles del servicio de la liquidación
 */
public class LiquidacionDetalleGasto extends LiquidacionDetalle {

    //Atributos
    /**
     * Concepto que etiqueta al gastoConcepto generado
     */
    private String gastoConcepto;

    //Constructores
    /**
     * Constructor de la clase LiquidacionDetalleGasto
     */
    public LiquidacionDetalleGasto() {
    }

    public LiquidacionDetalleGasto(String gastoConcepto) {
        this.gastoConcepto = gastoConcepto;
    }

    public LiquidacionDetalleGasto(String gastoConcepto, Liquidacion liquidacion, ServicioCuenta sc, double cuota) {
        super(liquidacion, sc, cuota);
        this.gastoConcepto = gastoConcepto;
    }

    

    //Métodos
    //Getters
    /**
     * Obtener el objeto gastoConcepto de la liquidación actual
     *
     * @return gastoConcepto Objeto gastoConcepto con los detalles del concepto
     * de gasto actual
     */
    public String getGastoLiquidacion() {
        return gastoConcepto;
    }

    //Setters
    /**
     * Asigna un objeto gastoConcepto al gastoConcepto actual
     *
     * @param gastoConcepto objeto gastoConcepto a asignar
     */
    public void setGastoLiquidacion(String gastoConcepto) {
        this.gastoConcepto = gastoConcepto;
    }

    /**
     * Función que devuelve una cadena con el objeto gastoConcepto y la cuota
     * correspondiente
     *
     * @return String con el gastoConcepto actual y la cuota correspondiente
     */
    @Override
    public String toString() {
        return gastoConcepto + " -> " + this.cuota;
    }

}
