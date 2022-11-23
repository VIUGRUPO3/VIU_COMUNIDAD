// Autor Grupo 3

//************************ INFO ************************

package repositorio;


public class GastoCategoria {
    
    //1.Atributos
    
    private int id;
    private String nombre;
    private Servicio servicio;
    
    //2.Constructores

    public GastoCategoria() {}

    public GastoCategoria(int id, String nombre, Servicio servicio) {
        this.id = id;
        this.nombre = nombre;
        this.servicio = servicio;
    }
    
    //3.Metodos
    //Getters

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Servicio getServicio() {
        return servicio;
    }
    
    //Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
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
