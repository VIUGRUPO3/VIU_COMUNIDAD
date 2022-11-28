// Asignatura: 21GIIN Proyectos Programación
// Profesor: Eduardo Zamudio
// @author: Grupo 3
// Miembros:
//       @author:Fernando Hernandez Fernandez
//       @author:Javier Barbero Sales
//       @author:Martin Gonzalez Dominguez
// @version: 01/12/2022/

// Paquete
package usuario;

import repositorio.ComunidadCRUD;
import repositorio.Liquidacion;

/**
 *
 */
public interface VecinoInterface {
    
    /** Metodo abstracto de la clase vecino usado por el admin para dar de baja a un vecino
     * 
     * @param comunidadCRUD
     * @param vecinoBorrar 
     */
    public abstract void bajaVecino (ComunidadCRUD comunidadCRUD, Vecino vecinoBorrar);
    
    /** Metodo abstracto de la clase vecino usado por el admin para actualizar los datos del vecino
     * 
     * @param comunidadCRUD
     * @param nombre
     * @param clave
     * @param telefono
     * @param email
     * @param vecinoModificar 
     */
    public abstract void updateVecino (ComunidadCRUD comunidadCRUD, String nombre, String clave, String telefono, String email, Vecino vecinoModificar);
    
    /** Metodo abstracto usado por la clase vecino para consultar sus liquidaciones
     * 
     * @param comunidadCRUD
     * @param liquidacion 
     */
    public abstract void consultarLiquidacion (ComunidadCRUD comunidadCRUD, Liquidacion liquidacion);
    
    /** Metodo abstracto usado por la clase vecino para consultar los servicios a los que estan adscritos sus inmuebles
     * 
     * @param comunidadCRUD 
     */
    public abstract void consultarServicioCuentas (ComunidadCRUD comunidadCRUD);
    
}
