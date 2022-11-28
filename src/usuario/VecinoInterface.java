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
    
    public abstract void bajaVecino (ComunidadCRUD comunidadCRUD, Vecino vecinoBorrar);
    public abstract void updateVecino (ComunidadCRUD comunidadCRUD, String nombre, String clave, String telefono, String email, Vecino vecinoModificar);
    public abstract void consultarLiquidacion (ComunidadCRUD comunidadCRUD, Liquidacion liquidacion);
    public abstract void consultarServicioCuentas (ComunidadCRUD comunidadCRUD);
    
}
