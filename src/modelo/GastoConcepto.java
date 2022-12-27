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
 * Clase abstracta que gestiona el tipo de objeto GastoConcepto La finalidad de
 * esta clase es permitir asociar un gasto a un servicio
 *
 */
public abstract class GastoConcepto {

    //1.Atributos
    /**
     * ID del GastoConcepto
    *
     */
    private String id;

    /**
     * Nombre del GastoConcepto
     */
    private String nombre;

    /**
     * Tipo de servicio asociado al GastoConcepto
     */
    private Servicio servicio;

    //2.Constructores
    /**
     * Clase GastoConcepto
     */
    public GastoConcepto() {
    }

    /**
     * Constructor de la clase GastoConcepto
     *
     * @param id el id del GastoConcepto correspondiente
     * @param nombre el nombre del gasto
     * @param servicio el objeto servicio asociado a dicho gasto
    *
     */
    public GastoConcepto(String id, String nombre, Servicio servicio) {
        this.id = id;
        this.nombre = nombre;
        this.servicio = servicio;
    }

    //3.Métodos
    //Getters
    /**
     * Método para consultar la id asociada a un GastoConcepto
     *
     * @return id id correspondiente a dicho GastoConcepto
    *
     */
    public String getId() {
        return id;
    }

    /**
     * Método para consultar el nombre asociado a un GastoConcepto
     *
     * @return nombre correspondiente a dicho GastoConcepto
    *
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para consultar el servicio asociado a un GastoConcepto
     *
     * @return servicio objeto servicio asociado a dicho GastoConcepto
    *
     */
    public Servicio getServicio() {
        return servicio;
    }

    //Setters
    /**
     * Método para asociar un id a un GastoConcepto
     *
     * @param id id a asociar al GastoConcepto
    *
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Método para asociar un nombre a un GastoConcepto
     *
     * @param nombre nombre a asociar al GastoConcepto
    *
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para asociar un servicio a un GastoConcepto
     *
     * @param servicio objeto servicio a asociar al GastoConcepto
    *
     */
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    /**
     * Método para añadir un nuevo GastoConcepto
     *
     * @param gastoConcepto objeto GastoConceptoCompuesto a añadir
    *
     */
    public void asignacionConceptos(GastoConceptoCompuesto gastoConcepto) {
        gastoConcepto.getGastosConcepto().add(this);
    }

    /**
     * Método para devolver el id y nombre asociado
     *
     * @return String en formato id + " - " + nombre + "\n"
    *
     */
    @Override
    public String toString() {
        return id + " - " + nombre + "\n";
    }

}
