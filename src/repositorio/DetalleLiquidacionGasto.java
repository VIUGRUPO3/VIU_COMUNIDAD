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
    
    
    //2.Constructores

    public DetalleLiquidacionGasto(Gasto gasto) {
        this.gasto = gasto;
    }

    public DetalleLiquidacionGasto(Gasto gasto, int id, Categoria categoria) {
        super(id, categoria);
        this.gasto = gasto;
    }

    //3.Metodos
    
    
}
