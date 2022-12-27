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

import java.time.LocalDate;

/**
 * Clase que asocia el servicio con inmueble en base a fecha de alta y baja
 *
 */
public class ServicioCuenta {

    //Atributos
    /**
     * Objeto Inmueble asociado al ServicioCuenta
     */
    private Inmueble inmueble;

    /**
     * Objeto Servicio asociado al ServicioCuenta
     */
    private Servicio servicio;

    /**
     * Fecha de alta del servicio
     */
    private LocalDate fechaAlta;

    /**
     * Fecha de baja del servicio
     */
    private LocalDate fechaBaja;

    //Constructores
    /**
     * Constructor de la clase ServicioCuenta
     */
    public ServicioCuenta() {
    }

    /**
     * Constructor de la clase ServicioCuenta
     *
     * @param inmueble objeto inmueble
     * @param servicio objeto servicio
     * @param fechaAlta Objeto fecha con fecha de alta
     */
    public ServicioCuenta(Inmueble inmueble, Servicio servicio, LocalDate fechaAlta) {
        this.inmueble = inmueble;
        this.servicio = servicio;
        this.fechaAlta = fechaAlta;
    }

    //Métodos
    //Getters
    /**
     * Método que nos devuelve el objeto del inmueble
     *
     * @return inmueble objeto inmueble
     */
    public Inmueble getInmueble() {
        return inmueble;
    }

    /**
     * Método que devuelve objeto servicio
     *
     * @return servicio objeto servicio
     */
    public Servicio getServicio() {
        return servicio;
    }

    /**
     * Método que devuelve objeto fecha alta del servicio
     *
     * @return fechaAlta objeto fecha alta
     */
    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    /**
     * Método que devuelve objeto FechaBaja del servicio
     *
     * @return fechaBaja objeto fecha de baja
     */
    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    //Setters
    /**
     * Método que establece el objeto Inmueble
     *
     * @param inmueble objeto inmueble
     */
    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    /**
     * Método que establece el objeto servicio
     *
     * @param servicio objeto servicio
     */
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    /**
     * Método que asigna fecha baja
     *
     * @param fechaBaja objeto fecha baja
     */
    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    /**
     * Método que asigna fecha alta
     *
     * @param fechaAlta objeto fecha alta
     */
    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    /**
     * Método que actualiza el objeto ServicioCuenta
     *
     * @param inmueble objeto inmueble
     * @param servicio objeto servicio
     * @param fechaAlta objeto fecha alta
     * @param fechaBaja objeto fecha baja
     */
    public void setServicioCuenta(Inmueble inmueble, Servicio servicio, LocalDate fechaAlta, LocalDate fechaBaja) {
        this.setInmueble(inmueble);
        this.setServicio(servicio);
        this.setFechaAlta(fechaAlta);
        this.setFechaBaja(fechaBaja);
    }

    //Funcionalidad
    //No se indentifican metodos especificos funcionales
    //Print
    /**
     * Método print string para devolver los datos de serviciocuenta
     * establecidos
     *
     * @return string con los parametros de servicioCuenta
     */
    @Override
    public String toString() {
        return "CUENTA SERVICIO \n" + inmueble + "\nservicio - " + servicio + "\nfechaAlta - " + fechaAlta + "\nfechaBaja - " + fechaBaja + "\n-----------------------------\n\n";
    }

}
