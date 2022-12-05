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

import java.time.LocalDate;

/**
 * Clase que gestiona las operaciones referentes a servicios
 *
 */
public class Servicio {

    //Atributos
    /**
     * ID del servicio
     */
    private int id;

    /**
     * Nombre del servicio
     */
    private String nombre;

    /**
     * Tarifa del servicio
     */
    private double tarifa;

    /**
     * Booleano que indica la obligatoriedad del servicio. Si es obligatorio
     * tomará el valor False, en caso contrario será True
     */
    private boolean opcional;

    //Constructores
    /**
     * Constructor de la clase servicio
     */
    public Servicio() {
    }

    /**
     * Constructor de la clase servicio
     *
     * @param id objeto id de servicio
     * @param nombre objeto nombre de servicio
     * @param tarifa objeto tarifa de servicio
     * @param opcional objeto tipo servicio opcional
     */
    public Servicio(int id, String nombre, double tarifa, boolean opcional) {
        this.id = id;
        this.nombre = nombre;
        this.tarifa = tarifa;
        this.opcional = opcional;

    }

    //Métodos
    //Getters
    /**
     * Método obtiene si el servicio es Opcional
     *
     * @return opcional tipo de servicio
     */
    public boolean isOpcional() {
        return opcional;
    }

    /**
     * Método obtiene el Id de servicio
     *
     * @return id identificar de servicio
     */
    public int getId() {
        return id;
    }

    /**
     * Método obtiene el nombre del servicio
     *
     * @return nombre string nombre de servicio
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que obtiene la tarifa asociada al servicio
     *
     * @return tarifa coste del servicio
     */
    public double getTarifa() {
        return tarifa;
    }

    //Setters
    /**
     * Método establece si el servicio es Opcional
     *
     * @param opcional tipo de servicio
     */
    public void setOpcional(boolean opcional) {
        this.opcional = opcional;
    }

    /**
     * Método Establece el id del servicio
     *
     * @param id identificador de servicio
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método Establece el nombre del servicio
     *
     * @param nombre objeto nombre del servicio
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método establece tarifa del servicio
     *
     * @param tarifa objeto precio del servicio
     */
    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    /**
     * Método establece el objeto servicio con su Nombre y tarifa
     *
     * @param nombre objeto nombre servicio
     * @param tarifa objeto coste servicio
     * @param opcional booleano que identifica si el servicio es opcional(True) o no(False)
     */
    public void setServicio(String nombre, double tarifa, boolean opcional) {
        this.nombre = nombre;
        this.tarifa = tarifa;
        this.opcional = opcional;
    }

    //Funcionalidad
    /**
     * Método establece como fijo un servicio identificado
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la comunidad
     *
     * @return inmueblesAdheridos el numero de inmuebles adheridos al objeto
     * comunidad
     */
    public int inmueblesAdheridos(ComunidadCRUD comunidadCRUD) {
        //ToDo: Implementación metodo para obtener resultado variable calculado "inmueblesAdheridos" como consulta de BD

        int inmueblesAdheridos = 0;
        for (int index = 0; index < comunidadCRUD.serviciosCuenta.size(); index++) {

            if (comunidadCRUD.serviciosCuenta.get(index).getServicio() == this) {
                inmueblesAdheridos++;
            };
        }
        return inmueblesAdheridos;

    }

    /**
     * Método que permite dar de baja un servicio
     *
     * @param comunidadCRUD objeto que contiene la informacion de la comunidad y
     * sus objetos correspondientes
     * @param servicioBorrar objeto de servicio a borrar
     *
     */
    public void bajaServicio(ComunidadCRUD comunidadCRUD, Servicio servicioBorrar) {
        comunidadCRUD.servicios.forEach(servicio -> {
            if (servicio == servicioBorrar) {
                servicio = null;
            }
        });
    }

    /**
     * Método que permite actualizar la informacion de un servicio
     *
     * @param comunidadCRUD objeto que contiene la informacion de la comunidad y
     * sus objetos correspondientes
     * @param nombre nombre del servicio
     * @param tarifa tarifa del servicio
     * @param opcional tipo de servicio
     * @param servicioModificar objeto servicio que va a ser modificado
     *
     */
    public void updateServicio(ComunidadCRUD comunidadCRUD, String nombre, double tarifa, boolean opcional, Servicio servicioModificar) {
        comunidadCRUD.servicios.forEach(servicio -> {
            if (servicio == servicioModificar) {
                servicio.setServicio(nombre, tarifa, opcional);
            }
        });
    }

    /**
     * Método que asigna los serviciosFIjos a los inmuebles, como son fijos se
     * asignan a todos los inmuebles
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la comunidad
     * @param fechaAlta objeto fecha de alta del servicio
     */
    public void asignarServiciosFijosInmuebles(ComunidadCRUD comunidadCRUD, LocalDate fechaAlta) {
        comunidadCRUD.inmuebles.forEach(inmueble -> {
            ServicioCuenta servicioCuenta = new ServicioCuenta(inmueble, this, fechaAlta);
            comunidadCRUD.serviciosCuenta.add(servicioCuenta);
        });
    }

    /**
     * Método que asigna los servicios opcionales a los inmuebles que lo
     * solicitan
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la comunidad
     * @param inmueble Objeto inmueble al que se va a incluir el servicio
     * @param fechaAlta objeto fecha de alta del servicio
     */
    public void asignarServicioOpcionalInmueble(ComunidadCRUD comunidadCRUD, Inmueble inmueble, LocalDate fechaAlta) {
        ServicioCuenta servicioCuenta = new ServicioCuenta(inmueble, this, fechaAlta);
        comunidadCRUD.serviciosCuenta.add(servicioCuenta);
    }

    //Print
    /**
     * Método toString que devuelve el nombre y tarifa del servicio actual
     *
     * @return String nombre + " -> "+ tarifa + "Euros \n"
     *
     */
    @Override
    public String toString() {
        return nombre + " -> " + tarifa + "Euros \n";
    }

}
