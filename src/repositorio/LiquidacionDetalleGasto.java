/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

/**
 *
 * @author fer
 */
public class LiquidacionDetalleGasto extends LiquidacionDetalle {
    
    //Atributos
    private String gastoConcepto;
    
    //Constructores

    public LiquidacionDetalleGasto() {
    }

    public LiquidacionDetalleGasto(String gastoConcepto, Liquidacion liquidacion, Inmueble inmueble, double cuota) {
        super(liquidacion, inmueble, cuota);
        this.gastoConcepto = gastoConcepto;
    }

    
    
    //Metodos
    
    //Getters

    public String getGastoConcepto() {
        return gastoConcepto;
    }
    
    //Setters

    public void setGastoConcepto(String gastoConcepto) {
        this.gastoConcepto = gastoConcepto;
    }

    @Override
    public String toString() {
        return gastoConcepto + " -> "  + this.cuota ;
    }
    
    
    
}
