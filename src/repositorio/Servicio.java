// Autor Grupo 3

//************************ INFO ************************

package repositorio;


public class Servicio {
    
    //1. Atributos
    protected int id;
    protected String nombre;
    protected double tarifa;
    protected TipoServicio tipoServicio;    
     
    //2. Constructores
    public Servicio() {}

    public Servicio(int id, String nombre, double tarifa) {
        this.id = id;
        this.nombre = nombre;
        this.tarifa = tarifa;
    }
    
     //3. Metodos
    
    public void definirFijo (Servicio servicio) {
        this.tipoServicio.addServiciosFijos(servicio);
        }
    
    public void definirOpcional (Servicio servicio) {
        this.tipoServicio.addServiciosOpcionales(servicio);
    }  
    
    
    
    
    @Override
    public String toString() {
        return nombre + " -> "+ tarifa + "Euros \n";
    }

    
}
