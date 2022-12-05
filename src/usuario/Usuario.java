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

/**
 * Se declara como clase abstracta ya que define unicamente la estructura de la
 * clase. No se va a instanciar ningún objeto de esta clase.
 *
 * Se declaran los atributos como protected para no ser accedidos por otras
 * clases fuera del paquete.
 *
 */
abstract class Usuario {
//Atributos 

    /**
     * ID del usuario
     *
     */
    protected int id;

    /**
     * Nombre del usuario
     */
    protected String nombre;

    /**
     * Clave de acceso del usuario
     */
    protected String clave;

    /**
     * Teléfono del usuario
     */
    protected String telefono;

    /**
     * Correo electrónico del usuario
     */
    protected String email;

    /**
     * Booleano que indica si el usuario ha iniciado sesión(True) o no(False)
     */
    protected boolean logged;

//Constructor
    /**
     * Constructor de la clase Usuario
     *
     * @param id Identificador unico de Vecino
     * @param nombre Nombre comun completo Vecino
     * @param clave Clave / Contraseña de acceso del Vecino
     * @param telefono Telefono asociado a Vecino
     * @param email Email asociado a vecino
     *
     */
    public Usuario(int id, String nombre, String clave, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
        this.telefono = telefono;
        this.email = email;
    }

// Métodos
    //Getters 
    /**
     * Método que devuelve la ID del usuario actual
     *
     * @return id ID del usuario actual
     */
    public int getId() {
        return id;
    }

    // Setters 
    //No se identifican Setters
    // Funcionalidad
    /**
     * Método validacion de login
     *
     * @param email email del usaurios (vecino/admin)
     * @param clave string clave para acceder al sistema
     * @return devuelve una variable logged con valor "true" en caso de
     * validación OK
     */
    public boolean login(String email, String clave) {
        if (this.email == email && this.clave == clave) {
            logged = true;
        }
        return logged;
    }

    /**
     * Método que devuelve si el usuario esta logeado
     *
     * @return devuelve variable "logged" en caso de usaurio logado
     */
    public boolean isLogged() {
        return logged;
    }

    //Print
    /**
     * Método toString que sobreescribe el heredado de la clase Object
     *
     * @return cadena string con los parametros de registro del usuario
     */
    @Override
    public String toString() {
        return "Usuario" + id + "\nnombr - " + nombre + "\nclave - " + clave + "\ntelef - " + telefono + "\nemail - " + email + "\n\n";
    }

}
