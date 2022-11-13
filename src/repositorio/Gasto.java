/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author fer
 */
public class Gasto {
    
    //1.Atributos
    
    private int id;
    private String descripcion;
    private LocalDate fechaRegistro;
    private LocalDate fechaPago;
    private Proveedor proveedor;
    private String comprobante;
    private Categoria categoria;
    private double importe;
    
    //2.Constructores

    public Gasto() {}

    public Gasto(int id, String descripcion, LocalDate fechaRegistro, LocalDate fechaPago, Proveedor proveedor, String comprobante, Categoria categoria, double importe) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
        this.fechaPago = fechaPago;
        this.proveedor = proveedor;
        this.comprobante = comprobante;
        this.categoria = categoria;
        this.importe = importe;
    }
    
    //3.Metodos

    public int getId() {
        return id;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setGasto(String descripcion, LocalDate fechaRegistro, LocalDate fechaPago, Proveedor proveedor, String comprobante, Categoria categoria, double importe) {
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
        this.fechaPago = fechaPago;
        this.proveedor = proveedor;
        this.comprobante = comprobante;
        this.categoria = categoria;
        this.importe = importe;
    }
    
    

    @Override
    public String toString() {
        return "Gasto{" + "id=" + id + ", fechaRegistro=" + fechaRegistro + ", fechaPago=" + fechaPago + ", proveedor=" + proveedor + ", comprobante=" + comprobante + ", categoria=" + categoria + '}';
    }
    
    
    
    
    
}
