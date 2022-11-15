/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author fer
 */
public class Liquidacion {
    
    //1.Atributos
    
    private int id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double total;
    private List<DetalleLiquidacionGasto> gastoLiquidado;
    private List<DetalleLiquidacionServicio> servicioLiquidado;
    private Inmueble inmueble;
    
    //2.Constructores

    public Liquidacion() {}

    public Liquidacion(int id, LocalDate fechaInicio, LocalDate fechaFin, double total, List<DetalleLiquidacionGasto> gastoLiquidado, List<DetalleLiquidacionServicio> ServicioLiquidado, Inmueble inmueble) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.total = total;
        this.gastoLiquidado = gastoLiquidado;
        this.servicioLiquidado = ServicioLiquidado;
        this.inmueble = inmueble;
    }

    
    
    //3.Metodos

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "  -------Liquidacion Nº" + id + "-------"
                + "\nInmueble    - " + inmueble.getId()
                + "\nPropietario - " + inmueble.getNombreVecino() 
                + "\n------------------------------------" 
                + "\nInicio - " + fechaInicio 
                + "\nFin - " + fechaFin 
                + "\nTotal - " + total + " EUROS"
                + "\n--------Liquidacion Servicios-------\n\n"
                + servicioLiquidado
                + "\n----------Liquidacion Gastos--------\n"
                + gastoLiquidado + "\n\n";
    }
    
    
    
    
    
}
