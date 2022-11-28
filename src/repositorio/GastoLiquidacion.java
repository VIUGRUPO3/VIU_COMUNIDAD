// Asignatura: 21GIIN Proyectos Programación
// Profesor: Eduardo Zamudio
// @author: Grupo 3
// Miembros:
//       @author:Fernando Hernandez Fernandez
//       @author:Javier Barbero Sales
//       @author:Martin Gonzalez Dominguez
// @version: 01/12/2022/

// Paquete
package repositorio;

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

    public void setNombreConcepto(String nombreConcepto) {
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
