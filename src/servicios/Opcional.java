
package servicios;

/**
 *
 * @author Grupo3
 */

/*Clase que hereda de Servicio*/

public class Opcional extends Servicio {

    private int numInmuebles;
    /**
    * Constructor de la clase Opcional.
    */
    public Opcional(int idServicio, String tipo, double importeServicio, String descripcion, boolean costeCompartido, int idProveedor){
        super(idServicio, tipo, importeServicio, descripcion, costeCompartido, idProveedor);
    }

    public int getId (){
        return this.idServicio;
    }

    public int getNumInmuebles(){
        
        int numInmuebles = 0;
    
        /* Logica que calcula el numero de inmuebles con ese servicio contratado */
        return numInmuebles;
    }
}