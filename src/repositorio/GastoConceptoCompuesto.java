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

import java.util.List;
import java.util.ArrayList;

/**
 * Clase que gestiona el tipo de gasto GastoConceptoCompuesto, hereda de la
 * clase GastoConcepto
 *
 */
public class GastoConceptoCompuesto extends GastoConcepto {

    //1.Atributos
    /**
     * Se definen los atributos basicos de la clase: la lista de gastos
     * gastoConcepto 
    *
     */
    protected List<GastoConcepto> gastosConcepto;

    //2.Constructores
    /**
     * Constructor de la clase GastoConceptoCompuesto
     */
    public GastoConceptoCompuesto() {
    }

    /**
     * Constructor de la clase GastoConceptoCompuesto
     *
     * @param id el id del gasto compuesto
     * @param nombre el nombre del gasto compuesto
     * @param servicio el servicio asociado al gasto compuesto
    *
     */
    public GastoConceptoCompuesto(String id, String nombre, Servicio servicio) {
        super(id, nombre, servicio);
        this.gastosConcepto = new ArrayList();
    }

    //3.Métodos
    /**
     * Método getGastosConcepto, para obtener el listado de gastos asociados al
     * gasto compuesto
     *
     * @return gastosConcepto lista compuesta por los gastos asociados a un
     * gasto compuesto
    *
     */
    public List<GastoConcepto> getGastosConcepto() {
        return gastosConcepto;
    }

    /**
     * Método setGastosConcepto, para asociar un listado de gastos a un gasto
     * compuesto
     *
     * @param gastosConcepto lista de gastoConceptos a asociar en el gasto
     * compuesto
    *
     */
    public void setGastosConcepto(List<GastoConcepto> gastosConcepto) {
        this.gastosConcepto = gastosConcepto;
    }

}
