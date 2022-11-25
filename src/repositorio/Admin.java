/****
* 
* Asignatura: 21GIIN Proyectos Programación
* Profesor: Eduardo Zamudio
* Autor: Grupo 3
* Miembros:
*      - Fernando Hernandez Fernandez
*      - Javier Barbero Sales
*      - Martin Gonzalez Dominguez
*
* ########################## INFO ##########################
*
* Descripción: 
* Peculiaridades:
* Herencias:
* Extends:
* 
****/

package repositorio;

import java.text.DecimalFormat;
import java.time.LocalDate;



//Clase encargada de realizar todas las operaciones con los usuarios vecinos, implementa la interfaz UserInterfaceOps
public class Admin extends Usuario{

    
    //1. Atributos

    
    //2.Constructores

    public Admin() {

    }

    public Admin(int id, String nombre, String clave, String telefono, String email) {
        super(id, nombre, clave, telefono, email);

    }
 
    
//3. Metodos
    
    public void altaVecino (ComunidadCRUD comunidadCRUD, int id, String nombre, String clave, String telefono, String email ){
        Vecino vecino = new Vecino(id, nombre, clave, telefono, email);
        comunidadCRUD.vecinos.add(vecino);
    }
    
    public void bajaVecino (ComunidadCRUD comunidadCRUD, Vecino vecinoBorrar){
        comunidadCRUD.vecinos.forEach(vecino -> {
            if(vecino == vecinoBorrar){
                //TODO: Implemetar eliminacion de vecino
            }
        });
    }
    
    public void altaInmueble (ComunidadCRUD comunidadCRUD, int id, Vecino vecino, String direccion ){
        Inmueble inmueble = new Inmueble (id, vecino, direccion);
        comunidadCRUD.inmuebles.add(inmueble);
    }
    
    public void altaServicio (ComunidadCRUD comunidadCRUD, int id, String nombre, double tarifa){
        Servicio servicio = new Servicio (id, nombre, tarifa);
        comunidadCRUD.servicios.add(servicio);
    }
    
    public void altaProveedor (ComunidadCRUD comunidadCRUD, int id, String nombre, String direccion, String telefono, String email){
        Proveedor proveedor = new Proveedor(id, nombre, direccion, telefono, email);
        comunidadCRUD.proveedores.add(proveedor);
    }
    
    public void altaGastoConceptoCompuesto (ComunidadCRUD comunidadCRUD, String id, String nombre, Servicio servicio){
        GastoConceptoCompuesto gastoConceptoCompuesto = new GastoConceptoCompuesto(id, nombre, servicio);
        comunidadCRUD.gastosConcepto.add(gastoConceptoCompuesto);
    }
    
    public void altaGastoConceptoSimple (ComunidadCRUD comunidadCRUD, String id, String nombre, Servicio servicio){
        GastoConceptoSimple gastoConceptoSimple = new GastoConceptoSimple(id, nombre, servicio);
        comunidadCRUD.gastosConcepto.add(gastoConceptoSimple);
    }
    
    public void altaGasto (ComunidadCRUD comunidadCRUD, int id, String descripcion, LocalDate fechaRegistro, LocalDate fechaPago, Proveedor proveedor, String comprobante, GastoConcepto gastoConcepto, double importe, boolean liquidado){
        Gasto gasto = new Gasto(id, descripcion, fechaRegistro, fechaPago, proveedor, comprobante, gastoConcepto, importe, liquidado);
        comunidadCRUD.gastos.add(gasto);
    }
    
    //Metodo que genera una liquidacion entre las fechas indicadas  
    public void liquidar(ComunidadCRUD comunidadCRUD, int id, LocalDate fechaInicio, LocalDate fechaFin){
        Liquidacion liquidacion = new Liquidacion(id, fechaInicio, fechaFin);
        liquidacion.generarLiquidacion(fechaInicio, fechaFin, comunidadCRUD, liquidacion);
    }

}
