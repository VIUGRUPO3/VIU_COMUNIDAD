
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
    
     
    //2. Constructores
    public Servicio() {}

    public Servicio(int id, String nombre, double tarifa) {
        this.id = id;
        this.nombre = nombre;
        this.tarifa = tarifa;
        
    }
    
     //3. Metodos
    @Override
    public String toString() {
        return nombre + " -> "+ tarifa + "Euros \n";
    }

    
}
