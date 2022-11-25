// Autor Grupo 3

//************************ INFO ************************

package repositorio;


public class  GastoConcepto {
    
    //1.Atributos
    
    private String id;
    private String nombre;
    private Servicio servicio;
    
    //2.Constructores

    public GastoConcepto() {}

    public GastoConcepto(String id, String nombre, Servicio servicio) {
        this.id = id;
        this.nombre = nombre;
        this.servicio = servicio;
    }
    
    //3.Metodos
    //Getters

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Servicio getServicio() {
        return servicio;
    }
    
    //Setters

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    
    public void asignacionConceptos (GastoConceptoCompuesto gastoConcepto ) {
        gastoConcepto.getGastosConcepto().add(this);

}
    
    
    
    @Override
    public String toString() {
        return id + " - " + nombre + "\n";
    }
    
    
    
    
}
