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
 * Clase que gestiona el tipo de gasto con concepto simple, hereda de la clase
 * GastoConcepto
 *
 */
public class GastoConceptoSimple extends GastoConcepto {

    //1.Atributos
    //2.Constructores
    /**
     * Constructor de la clase GastoConceptoSimple
     */
    public GastoConceptoSimple() {
    }

    /**
     * Constructor de la clase GastoConceptoSimple
     *
     * @param id id del GastoConceptoSimple
     * @param nombre nombre del gasto
     * @param servicio servicio asociado al gasto indicado
    *
     */
    public GastoConceptoSimple(String id, String nombre, Servicio servicio) {
        super(id, nombre, servicio);
    }

    //3.Métodos
}
