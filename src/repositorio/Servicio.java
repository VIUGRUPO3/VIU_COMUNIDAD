
package repositorio;

/**
 *
 * @author fer
 */
abstract class Servicio {
    
    //1. Atributos
    protected int id;
    protected String nombre;
    protected double tarifa;
    protected Categoria categoria;
     
    //2. Constructores
    public Servicio() {}

    public Servicio(int id, String nombre, double tarifa, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.tarifa = tarifa;
        this.categoria = categoria;
    }
    
     //3. Metodos
    @Override
    public String toString() {
        return nombre + " -> "+ tarifa + "Euros  (" + categoria + ")\n";
    }

    
}
