// Autor Grupo 3

//************************ INFO ************************

package repositorio;

public class DetalleLiquidacionServicio extends DetalleLiquidacion {
    
    //1.Atributos
    protected Servicio servicio;
    
    //2.Constructores

    public DetalleLiquidacionServicio() {}

  

    public DetalleLiquidacionServicio(Servicio servicio, int id) {
        super(id);
        this.servicio = servicio;
    }
    
    //3.Metodos

    @Override
    public String toString() {
        return id + " " + servicio.nombre + " - " + this.servicio.tarifa + " Euros\n";
    }
    
}
