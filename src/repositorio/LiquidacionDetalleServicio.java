/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

/**
 *
 * @author fer
 */
public class LiquidacionDetalleServicio extends LiquidacionDetalle {
    
    //Atributos
    private Servicio servicio;
    
    //Constructores

    public LiquidacionDetalleServicio() {
    }

    public LiquidacionDetalleServicio(Servicio servicio, Liquidacion liquidacion, Inmueble inmueble, double cuota) {
        super(liquidacion, inmueble, cuota);
        this.servicio = servicio;
    }

    
    
    //Metodos
    
    //Getters

    public Servicio getServicio() {
        return servicio;
    }
    
    //Setters

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    @Override
    public String toString() {
        return  "" + servicio;
    }
    
    
    
    
    
}
