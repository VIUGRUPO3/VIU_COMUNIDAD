/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

/**
 *
 * @author fer
 */
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
