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
import java.util.Date;

/**
 * Clase que gestiona las operaciones referentes a servicios
 *
 */
public class Servicio extends ServicioAbs{

    /**
     * Tarifa del servicio
     */
    private double tarifa;

    public Servicio() {
    }

    public Servicio(double tarifa) {
        this.tarifa = tarifa;
    }

    public Servicio(double tarifa, String nombre, boolean opcional) {
        super(nombre, opcional);
        this.tarifa = tarifa;
    }

    public Servicio(double tarifa, int id, String nombre, boolean opcional) {
        super(id, nombre, opcional);
        this.tarifa = tarifa;
    }
    
    

    //Métodos
    //equals
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.getId();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Servicio other = (Servicio) obj;
        return this.getId() == other.getId();
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
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
                servicio.setNombre(nombre);
                servicio.setTarifa(tarifa);
                servicio.setOpcional(opcional);
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
    public void asignarServiciosFijosInmuebles(ComunidadCRUD comunidadCRUD, Date fechaAlta) {
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
    public void asignarServicioOpcionalInmueble(ComunidadCRUD comunidadCRUD, Inmueble inmueble, Date fechaAlta) {
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
        return this.getNombre() + " -> " + tarifa + "Euros \n";
    }

}
