/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

/**
 *
 * @author fer
 */
public class DetalleLiquidacionServicio extends DetalleLiquidacion {
    
    //1.Atributos
    protected Servicio servicio;
    
    //2.Constructores

    public DetalleLiquidacionServicio() {}

  

    public DetalleLiquidacionServicio(Servicio servicio, int id, Categoria categoria) {
        super(id, categoria);
        this.servicio = servicio;
    }
    
    //3.Metodos

    @Override
    public String toString() {
        return id + " " + categoria.getNombre() + " - " + this.servicio.tarifa + " Euros\n";
    }
    
}
