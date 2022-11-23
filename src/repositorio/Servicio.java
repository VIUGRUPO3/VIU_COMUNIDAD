// Autor Grupo 3

//************************ INFO ************************

package repositorio;


public class Servicio {
    
    //1. Atributos
    private int id;
    private String nombre;
    private double tarifa;
     
    //2. Constructores
    public Servicio() {}

    public Servicio(int id, String nombre, double tarifa) {
        this.id = id;
        this.nombre = nombre;
        this.tarifa = tarifa;
    }
    
     //3. Metodos

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }
    
    
    
    public void definirFijo  (ComunidadCRUD comunidadCRUD) {
        comunidadCRUD.servicioTipos.addServiciosFijos(this);
        }
    
    public void definirOpcional (ComunidadCRUD comunidadCRUD) {
        comunidadCRUD.servicioTipos.addServiciosOpcionales(this);
    }  
    
    
    
    
    @Override
    public String toString() {
        return nombre + " -> "+ tarifa + "Euros \n";
    }

    
}
