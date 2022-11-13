/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

import java.util.Date;

/**
 *
 * @author fer
 */
public class Gasto {
    
    //1.Atributos
    
    private int id;
    private Date fechaRegistro;
    private Date fechaPago;
    private Proveedor proveedor;
    private String comprobante;
    private Categoria categoria;
    
    //2.Constructores

    public Gasto() {}

    public Gasto(int id, Date fechaRegistro, Date fechaPago, Proveedor proveedor, String comprobante, Categoria categoria) {
        this.id = id;
        this.fechaRegistro = fechaRegistro;
        this.fechaPago = fechaPago;
        this.proveedor = proveedor;
        this.comprobante = comprobante;
        this.categoria = categoria;
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

    public void setGasto(Date fechaRegistro, Date fechaPago, Proveedor proveedor, String comprobante,Categoria categoria) {
        this.fechaRegistro = fechaRegistro;
        this.fechaPago = fechaPago;
        this.proveedor = proveedor;
        this.comprobante = comprobante;
        this.categoria = categoria;
    }
    
    

    @Override
    public String toString() {
        return "Gasto{" + "id=" + id + ", fechaRegistro=" + fechaRegistro + ", fechaPago=" + fechaPago + ", proveedor=" + proveedor + ", comprobante=" + comprobante + ", categoria=" + categoria + '}';
    }
    
    
    
    
    
}
