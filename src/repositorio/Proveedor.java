/****
* 
* Asignatura: 21GIIN Proyectos Programación
* Profesor: Eduardo Zamudio
* @author: Grupo 3
* Miembros:
*       @author:Fernando Hernandez Fernandez
*       @author:Javier Barbero Sales
*       @author:Martin Gonzalez Dominguez
* @version: 01/12/2022/A 
* 
* ########################## INFO ##########################
*
* Descripción:
*   - 
* Peculiaridades:
*   - Clase Abstracta, ya que no se instanciara ningun objeto de esta clase.
* Herencias:
*   - N/A
* Extends:
*   - N/A
* 
****/


package repositorio;


public class Proveedor {
    
    //1.Atributos
    
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    
    //2.Constructores

    public Proveedor() {}

    public Proveedor(int id, String nombre, String direccion, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }
    
    //3.Metodos

    public int getId() {
        return id;
    } 

    public void setProveedor(String nombre, String direccion, String telefono, String email) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    
    
    

    @Override
    public String toString() {
        return "--------Proveedor"+ id + "--------\nnombr - " + nombre + "\ndirec - " + direccion + "\ntelef - " + telefono + "\nemail - " + email + "\n";
    }
    
    
    
}
