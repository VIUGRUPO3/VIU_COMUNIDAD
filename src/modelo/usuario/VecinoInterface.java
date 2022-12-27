// Asignatura: 21GIIN Proyectos Programación
// Profesor: Eduardo Zamudio
// @author: Grupo 3
// Miembros:
//       @author:Fernando Hernandez Fernandez
//       @author:Javier Barbero Sales
//       @author:Martin Gonzalez Dominguez
// @version: 01/12/2022/
// Paquete
package modelo.usuario;

import modelo.ComunidadCRUD;
import modelo.Liquidacion;

/**
 * Interface de la clase vecino
 *
 *
 */
public interface VecinoInterface {

    /**
     * Método abstracto de la clase vecino usado por el admin para dar de baja a
     * un vecino
     *
     * @param comunidadCRUD objeto que almacena todos los datos de la comunidad
     * @param vecinoBorrar objeto que almacena todos los datos del vecino a
     * borrar
     */
    public abstract void bajaVecino(ComunidadCRUD comunidadCRUD, Vecino vecinoBorrar);

    /**
     * Método abstracto de la clase vecino usado por el admin para actualizar
     * los datos del vecino
     *
     * @param comunidadCRUD objeto que almacena todos los datos de la comunidad
     * @param nombre nombre del vecino
     * @param clave clave de acceso del vecino
     * @param telefono telefono del vecido
     * @param email correo electronico del vecino
     * @param vecinoModificar objeto vecino a modificar
     */
    public abstract void updateVecino(ComunidadCRUD comunidadCRUD, String nombre, String clave, String telefono, String email, Vecino vecinoModificar);

    /**
     * Método abstracto usado por la clase vecino para consultar sus
     * liquidaciones
     *
     * @param comunidadCRUD objeto que almacena todos los datos de la comunidad
     * @param liquidacion objeto que almacena todos los datos de la liquidacion
     */
    public abstract void consultarLiquidacion(ComunidadCRUD comunidadCRUD, Liquidacion liquidacion);

    /**
     * Método abstracto usado por la clase vecino para consultar los servicios a
     * los que estan adscritos sus inmuebles
     *
     * @param comunidadCRUD objeto que almacena todos los datos de la comunidad
     */
    public abstract void consultarServicioCuentas(ComunidadCRUD comunidadCRUD);

}
