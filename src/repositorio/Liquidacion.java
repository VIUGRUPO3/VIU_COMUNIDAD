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
    private List<DetalleLiquidacionServicio> ServicioLiquidado;
    
    //2.Constructores

    public Liquidacion() {}

    public Liquidacion(int id, LocalDate fechaInicio, LocalDate fechaFin, double total, List<DetalleLiquidacionGasto> gastoLiquidado, List<DetalleLiquidacionServicio> ServicioLiquidado) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.total = total;
        this.gastoLiquidado = new ArrayList();
        this.ServicioLiquidado = new ArrayList();
    }

    
    
    //3.Metodos

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Liquidacion{" + "id=" + id + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", total=" + total + '}';
    }
    
    
    
    
    
}
