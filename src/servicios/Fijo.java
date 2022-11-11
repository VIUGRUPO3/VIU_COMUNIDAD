
package servicios;

/**
 *
 * @author Grupo3
 */

/*Clase que hereda de Servicio*/

public class Fijo extends Servicio {

    /**
    * Constructor de la clase Fijo.
    */
    public Fijo(int idServicio, String tipo, double importeServicio, String descripcion, boolean costeCompartido, int idProveedor){
        super(idServicio, tipo, importeServicio, descripcion, costeCompartido, idProveedor);
    }

    public int getId (){
        return this.idServicio;
    }
    
}