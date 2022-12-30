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

import modelo.usuario.Vecino;

/**
 * Clase que gestiona el tipo Inmueble
 *
 */
public class Inmueble {

    //1. Atributos
    /**
     * ID del inmueble
    *
     */
    private int id;

    /**
     * Clase Vecino con los datos del vecino propietario del inmueble
     */
    private Vecino vecino;

    /**
     * Direccion del inmueble
     */
    private String direccion;

    //2. Constructores
    /**
     * Constructor de la clase Inmueble
     */
    public Inmueble() {
    }

    /**
     * Constructor de la clase Inmueble
     *
     * @param id el id del Inmueble
     * @param vecino el objeto al que pertenece el inmueble
     * @param direccion la dirección a la que corresponde el inmueble
    *
     */
    public Inmueble(int id, Vecino vecino, String direccion) {
        this.id = id;
        this.vecino = vecino;
        this.direccion = direccion;
    }

    public Inmueble(String direccion) {
        this.direccion = direccion;
    }
    
    

    //3. Métodos
    //Getters
    /**
     * Método getId, para obtener el identificar de inmueble
     *
     * @return id identificador de inmueble
        *
     */
    public int getId() {
        return this.id;
    }

    /**
     * Método getDireccion, para obtener la direccion del inmueble
     *
     * @return direccion la direccion del inmueble
        *
     */
    public String getDireccion() {
        return this.direccion;
    }

    /**
     * Método getVecino, para obtener el objeto vecino correspondiente al
     * inmueble actual
     *
     * @return vecino objeto vecino
        *
     */
    public Vecino getVecino() {
        return vecino;
    }

    //Setters
    /**
     * Método para asignar un vecino a un inmueble
     *
     * @param vecino objeto vecino
        *
     */
    public void setVecino(Vecino vecino) {
        this.vecino = vecino;
    }

    /**
     * Método para asignar un objeto vecino y una direccion a un inmueble
     *
     * @param vecino objeto vecino a asociar
     * @param direccion direccion a asociar con el inmueble
        *
     */
    public void setInmueble(Vecino vecino, String direccion) {
        this.vecino = vecino;
        this.direccion = direccion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id;
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
        final Inmueble other = (Inmueble) obj;
        return this.id == other.id;
    }
    
    

    /**
     * Método para dar de baja un inmueble
     *
     * @param comunidadCRUD objeto comunidadCRUD asociado al inmueble
     * @param inmuebleBaja objeto inmueble a dar de baja
        *
     */
    public void bajaInmueble(ComunidadCRUD comunidadCRUD, Inmueble inmuebleBaja) {
        comunidadCRUD.inmuebles.forEach(inmueble -> {
            if (inmueble == inmuebleBaja) {
                inmueble = null;
            }
        });
    }

    /**
     * Método para actualizar los datos de un inmueble
     *
     * @param comunidadCRUD objeto comunidadCRUD donde actualizar los datos
     * @param vecino objeto vecino que contiene los datos del propietario del
     * inmueble
     * @param direccion direccion asociada al inmueble
     * @param inmuebleModificar el objeto inmueble a modificar
        *
     */
    public void updateInmueble(ComunidadCRUD comunidadCRUD, Vecino vecino, String direccion, Inmueble inmuebleModificar) {
        comunidadCRUD.inmuebles.forEach(inmueble -> {
            if (inmueble == inmuebleModificar) {
                inmueble.setInmueble(vecino, direccion);
            }
        });
    }

    /**
     * Método toString que sobreescribe el heredado de la clase Object
     * ////REVISAR
     *
     *
     */
    @Override
    public String toString() {
        return "------Inmueble" + id + "------"
                + "\nPropietario - " + vecino.getNombre()
                + "\ndirecccion  - " + direccion
                + "\n";
    }

}
