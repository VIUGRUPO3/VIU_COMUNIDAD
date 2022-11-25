/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

/**
 *
 * @author fer
 */
public class GastoLiquidacion {
    
    //1.Atributos
    private String nombreConcepto;
    private double cuota;
    
    //2.Constructores

    public GastoLiquidacion() {}

    public GastoLiquidacion(String nombreConcepto, double cuota) {
        this.nombreConcepto = nombreConcepto;
        this.cuota = cuota;
    }
    
    //3.Metodos
    
    //Getters
    
    public String getNombreConcepto() {
        return nombreConcepto;
    }

    public double getCuota() {
        return cuota;
    }
    
    //Setters

    public void setGastoConcepto(String nmbreConcepto) {
        this.nombreConcepto = nombreConcepto;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    @Override
    public String toString() {
        return  nombreConcepto + " -> " + cuota + "EUROS\n";
    }
    
    
    
    
    
    
}
