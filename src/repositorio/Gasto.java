// Autor Grupo 3

package repositorio;

import java.time.LocalDate;
import java.util.Date;


public class Gasto {
    
    //1.Atributos
    
    private int id;
    private String descripcion;
    private LocalDate fechaRegistro;
    private LocalDate fechaPago;
    private Proveedor proveedor;
    private String comprobante;
    private GastoCategoria categoria;
    private boolean liquidado;
    private double importe;
    
    //2.Constructores

    public Gasto() {}

    public Gasto(int id, String descripcion, LocalDate fechaRegistro, LocalDate fechaPago, Proveedor proveedor, String comprobante, GastoCategoria categoria, double importe, boolean liquidado) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
        this.fechaPago = fechaPago;
        this.proveedor = proveedor;
        this.comprobante = comprobante;
        this.categoria = categoria;
        this.importe = importe;
        this.liquidado = liquidado;
    }
    
    //3.Metodos

    public int getId() {
        return id;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getComprobante() {
        return comprobante;
    }

    public GastoCategoria getCategoria() {
        return categoria;
    }   

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public double getImporte() {
        return importe;
    }

    public boolean isLiquidado() {
        return liquidado;
    }

    public void setLiquidado(boolean liquidado) {
        this.liquidado = liquidado;
    }

    public void setGasto(String descripcion, LocalDate fechaRegistro, LocalDate fechaPago, Proveedor proveedor, String comprobante, GastoCategoria categoria, double importe, boolean liquidado) {
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
        this.fechaPago = fechaPago;
        this.proveedor = proveedor;
        this.comprobante = comprobante;
        this.categoria = categoria;
        this.importe = importe;
        this.liquidado = liquidado;
    }
    
    

    @Override
    public String toString() {
        return "--------Gasto" + id + "--------\n fechaRegistro - " + fechaRegistro + "\n fechaPago    - " + fechaPago + "\n comprobante  - " + comprobante + "\n categoria    - " + categoria + "\n liquidado    - " + liquidado + "\n" + proveedor + "\n--------TOTAL--------\n    " + importe + "Euros \n\n";
    }
    
    
    
    
    
}
