// Autor Grupo 3

//************************ INFO ************************

package repositorio;


public class DetalleLiquidacionGasto extends DetalleLiquidacion {
    
    //1.Atributos
    protected Gasto gasto;
    protected double cuota;
    
    
    
    //2.Constructores

    

    public DetalleLiquidacionGasto(Gasto gasto, int id, double cuota) {
        super(id);
        this.gasto = gasto;
        this.cuota = cuota;
    }

    //3.Metodos
    
    @Override
    public String toString() {
        return id + " " + gasto.getNombreCategoria() + " - " + this.cuota + " Euros\n";
    }
    
}
