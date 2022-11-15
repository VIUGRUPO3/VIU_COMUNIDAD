
package repositorio;

/**
 *
 * @author fer
 */
public class Categoria {
    
    //1.Atributos
    
    private int id;
    private String nombre;
    private Servicio servicio;
    
    //2.Constructores

    public Categoria() {}

    public Categoria(int id, String nombre, Servicio servicio) {
        this.id = id;
        this.nombre = nombre;
        this.servicio = servicio;
    }
    
    //3.Metodos

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    
    public Servicio getServicio() {
        return servicio;
    }

    public void setCategoria(String nombre) {
        this.nombre = nombre;
    }
    
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
   
    @Override
    public String toString() {
        return id + " - " + nombre;
    }
    
    
    
    
}
