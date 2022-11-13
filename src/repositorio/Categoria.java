
package repositorio;

/**
 *
 * @author fer
 */
public class Categoria {
    
    //1.Atributos
    
    private int id;
    private String nombre;
    
    //2.Constructores

    public Categoria() {}

    public Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    //3.Metodos

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCategoria(String nombre) {
        this.nombre = nombre;
    }
   
    @Override
    public String toString() {
        return id + " - " + nombre;
    }
    
    
    
    
}
