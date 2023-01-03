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
    public GastoConceptoSimple(int id, String nombre, Servicio servicio) {
        super(id, nombre, servicio);
    }

    public GastoConceptoSimple(String nombre, Servicio servicio) {
        super(nombre, servicio);
    }
}
