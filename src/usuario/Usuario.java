package usuario;

abstract class Usuario {

    /**
     * Declaración de atributos
     *
     * Se declara como clase abstracta ya que define unicamente la estructura de la clase.
     *
     * No se va a instanciar ningún objeto de esta clase.
     */

    protected int idUsuario;
    protected String nombre;
    protected String clave;
    protected String telefono;
    protected String email;
    protected String tipo;

            /*
    public int idUsuario;
    public String nombre;
    public String clave;
    public String telefono;
    public String email;
    public String tipo;
*/
    /**
     * Constructor de la clase Usuario.
     */
    protected Usuario(int idUsuario, String nombre, String clave, String telefono, String email, String tipo){
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.clave = clave;
        this.telefono = telefono;
        this.email = email;
        this.tipo = tipo;
    }

    /**
     * Método de la clase Usuario, que permite actualizar los datos.
     */
    protected void setUsuario(String nombre, String clave, String telefono, String email, String tipo){
        this.nombre = nombre;
        this.clave = clave;
        this.telefono = telefono;
        this.email = email;
        this.tipo = tipo;
    }

}
