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
 *  Clase que gestiona el tipo de gasto referente a las liquidaciones
 * */

public class GastoLiquidacion {
    
    //1.Atributos
    /**
    *  Se definen los atributos basicos de la clase
    * */
    private String nombreConcepto;
    private double cuota;
    
    //2.Constructores

    public GastoLiquidacion() {}

        /**
        * Constructor de la clase GastoLiquidacion
        * 
        * @param nombreConcepto nombre del concepto
        * @param cuota cuota a pagar
        **/
    public GastoLiquidacion(String nombreConcepto, double cuota) {
        this.nombreConcepto = nombreConcepto;
        this.cuota = cuota;
    }
    
    //3.Metodos
    
    //Getters
    /** 
     * Metodo para consultar el nombre del concepto asociado a un gasto de liquidacion
     * 
     * @return nombreConcepto el nombre del concepto del gasto
     **/     
    public String getNombreConcepto() {
        return nombreConcepto;
    }

    /** 
     * Metodo para consultar la cuota asociada a un gasto de liquidacion 
     * 
     * @return cuota el valor de la cuota correspondiente
     **/     
    public double getCuota() {
        return cuota;
    }
    
    //Setters
    /** 
    * Metodo para asignar nombre de concepto a un gasto
    * 
    * @param nombreConcepto  nombre del concepto a asociar
    **/      
    public void setNombreConcepto(String nombreConcepto) {
        this.nombreConcepto = nombreConcepto;
    }
    /** 
     * Metodo para asignar una cuota a un gasto
     * 
     * @param cuota valor de la cuota a asociar
     **/      
    public void setCuota(double cuota) {
        this.cuota = cuota;
    }
    /** 
     * Metodo para devolver el nombre del concepto y la cuota correspondiente a un GastoLiquidacion concreto
     * 
     * @return String con los valores correspondientes en formato nombreConcepto + " -> " + cuota + "EUROS\n"
     **/      
    @Override
    public String toString() {
        return  nombreConcepto + " -> " + cuota + "EUROS\n";
    }
    
    
    
    
    
    
}
