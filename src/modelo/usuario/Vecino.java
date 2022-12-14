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
 * Clase que gestiona el tipo de usuario Vecino, hereda de Usuario
 *
 */
public class Vecino extends Usuario implements VecinoInterface {

    // Atributos 
    // Todos los atributos son heredados de la clase Usuario
    
// Constructores 
    /**
     * Constructor de la clase Vecino
     *
     * @param id Identificador unico de Vecino
     * @param nombre Nombre comun completo Vecino
     * @param apellidos Apellidos del vecino
     * @param userName nombre de usuario de acceso a la aplicacion
     * @param clave Clave / Contraseña de acceso del Vecino
     * @param telefono Telefono asociado a Vecino
     * @param email Email asociado a Vecino
     *
     */
    public Vecino(int id, String nombre, String apellidos, String userName, String clave, String telefono, String email) {
        super(id, nombre, apellidos, userName, clave, telefono, email);
    }
    
    public Vecino(String nombre, String apellidos, String userName, String clave, String telefono, String email) {
        super(nombre, apellidos, userName, clave, telefono, email);
    }

    public Vecino() {
    }

    
    
    
    // Métodos 
    // Getters 
    /**
     * Método para consultar el id de un vecino
     *
     * @return id identificador de vecino
     *
     */
    public int getId() {
        return id;
    }

    /**
     * Método para consultar el nombre de un vecino
     *
     * @return nombre nombre de vecino
     *
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para consultar la clave de un vecino
     *
     * @return clave clave de vecino
     *
     */
    public String getClave() {
        return clave;
    }

    /**
     * Método para consultar el telefono de un vecino
     *
     * @return telefono telefono de vecino
     *
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Método para consultar el email de un vecino
     *
     * @return email correo de vecino
     *
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método para consultar si un vecino está logueado
     *
     * @return logged booleano que devuelve si el vecino está logueado
     *
     */
    public boolean isLogged() {
        return logged;
    }

    // Setters 
    /**
     * Método para asignar una id a un vecino
     *
     * @param id identificador de vecino
     *
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método para asignar un nombre a un vecino
     *
     * @param nombre nombre del vecino
     *
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    
    /**
     * Método para asignar una id a un vecino
     *
     * @param clave clave del vecino
     *
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * Método para asignar un telefono a un vecino
     *
     * @param telefono telefono de un vecino
     *
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Método para asignar un correo a un vecino
     *
     * @param email correo de un vecino
     *
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Método para asignar si un vecino está logueado o no
     *
     * @param logged booleano que indica si el usuario está logueado
     *
     */
    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    /**
     * Método para asignar valores a los atributos de vecino
     *
     * @param nombre nombre del vecino
     * @param clave clave del usuario
     * @param telefono telefono del usuario
     * @param email correo del usuario
     *
     */
    public void setVecino(String nombre, String clave, String telefono, String email) {
        this.nombre = nombre;
        this.clave = clave;
        this.telefono = telefono;
        this.email = email;

    }

    // Funcionalidad
    /**
     * Método para consultar las cuentas de servicio de un vecino
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la comunidad
     * @param vecinoBorrar id del vecino
     *
     */
    @Override
    public void bajaVecino(ComunidadCRUD comunidadCRUD, Vecino vecinoBorrar) {
        Vecino comunidad = comunidadCRUD.getVecino();        // Asignamos el vecino "Comunidad" al espacio de memoria que ocupaba el vecino eliminado
        comunidadCRUD.getInmuebles().forEach(inmueble -> {
            if (inmueble.getVecino() == vecinoBorrar) {
                inmueble.setVecino(comunidad);
            }
        });
        comunidadCRUD.getVecinos().forEach(vecino -> {
            if (vecino == vecinoBorrar) {
                comunidadCRUD.getVecinos().set(comunidadCRUD.getVecinos().indexOf(vecino), comunidad);

            }
        });
    }

    /**
     * Método para consultar las cuentas de servicio de un vecino
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la comunidad
     * @param nombre nombre del vecino
     * @param clave clave del vecino
     * @param telefono telefono del vecino
     * @param email correo electronico
     * @param vecinoModificar id del vecino a modificar
     *
     */
    @Override
    public void updateVecino(ComunidadCRUD comunidadCRUD, String nombre, String clave, String telefono, String email, Vecino vecinoModificar) {
        comunidadCRUD.getVecinos().forEach(vecino -> {
            if (vecino == vecinoModificar) {
                vecino.setVecino(nombre, clave, telefono, email);
            }
        });
    }

    /**
     * Método para consultar las liquidaciones de un vecino
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la comunidad
     * @param liquidacion objeto que contiene la cabecera de la liquidación
     *
     */
    @Override
    public void consultarLiquidacion(ComunidadCRUD comunidadCRUD, Liquidacion liquidacion) {
        System.out.println("------------------------------------------------\n");
        System.out.println("CONSULTA DE LIQUIDACION DE:  " + this.nombre + "\n");
        comunidadCRUD.getInmuebles().forEach(inmueble -> {

            if (inmueble.getVecino() == this) {
                System.out.println("\n" + liquidacion + "\n");
                System.out.println(inmueble);
                liquidacion.imprimirLiquidacionInmueble(comunidadCRUD, liquidacion, inmueble);
            }
        });
    }

    /**
     * Método para consultar las cuentas de servicio de un vecino
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la comunidad
     *
     */
    @Override
    public void consultarServicioCuentas(ComunidadCRUD comunidadCRUD) {
        System.out.println("------------------------------------------------\n");
        System.out.println("CONSULTA DE SERVICIOS DE:  " + this.nombre + "\n");
        comunidadCRUD.getInmuebles().forEach(inmueble -> {
            if (inmueble.getVecino() == this) {
                comunidadCRUD.getServiciosCuenta().forEach(servicioCuenta -> {
                    if (servicioCuenta.getInmueble() == inmueble) {
                        System.out.println(servicioCuenta);
                    }
                });
            }
        });
    }

    // Print 
    // No se identifican Métodos Print 
}
