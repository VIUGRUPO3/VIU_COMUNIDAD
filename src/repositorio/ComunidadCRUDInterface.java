/****
* 
* Asignatura: 21GIIN Proyectos Programación
* Profesor: Eduardo Zamudio
* @author: Grupo 3
* Miembros:
*       @author:Fernando Hernandez Fernandez
*       @author:Javier Barbero Sales
*       @author:Martin Gonzalez Dominguez
* @version: 01/12/2022/A 
* 
* ########################## INFO ##########################
*
* Descripción:
*   - 
* Peculiaridades:
*   - Clase Abstracta, ya que no se instanciara ningun objeto de esta clase.
* Herencias:
*   - N/A
* Extends:
*   - N/A
* 
****/



package repositorio;


import java.time.LocalDate;
import java.util.List;


public interface ComunidadCRUDInterface {
    
    //Metodos CRUD de Vecino
    
    public abstract void saveVecino(Vecino vecino);
    public abstract List<Vecino> viewVecinos();
    public abstract void updateVecino(Vecino vecino, String nombre, String clave, String telefono, String email);
    public abstract void deleteVecino(Vecino vecino);
    
    //Metodos CRUD de Inmueble
    
    public abstract void saveInmueble(Inmueble inmueble);
    public abstract List<Inmueble> viewInmuebles();
    public abstract void updateInmueble(Inmueble inmueble, Vecino vecino, String direccion);
    public abstract void deleteInmueble(Inmueble inmueble);
    
    //Metodos CRUD de Servicio
    public abstract void saveServicio(Servicio servicio);
    public abstract List<Servicio> viewServicios();
    public abstract void updateServicio(Servicio servicio, String nombre, double tarifa);
    public abstract void deleteServicio(Servicio servicio);
    
    //Metodos CRUD de ServicioCuenta
    public abstract void saveServiciosCuenta(ServicioCuenta servicioCuenta);
    public abstract List<ServicioCuenta> viewServiciosCuenta();
    
    
    //Metodos CRUD de GastosConcepto
    public abstract void saveGastosConcepto(GastoConcepto categoria);
    public abstract List<GastoConcepto> viewGastosConcepto();
    public abstract void updateGastosConcepto(GastoConcepto gastoConcepto, Servicio servicio, String nombre);
    public abstract void deleteGastosConcepto(GastoConcepto gastoConcepto);
    
    //Metodos CRUD de Proveedor
    public abstract void saveProveedor(Proveedor proveedor);
    public abstract List<Proveedor> viewProveedores();
    public abstract void updateProveedor(Proveedor proveedor, String nombre, String direccion, String telefono, String email);
    public abstract void deleteProveedor(Proveedor proveedor);
        
    //Metodos CRUD de Gasto
    public abstract void saveGasto(Gasto gasto);
    public abstract List<Gasto> viewGastos();
    public abstract void updateGasto(Gasto gasto, String descripcion, LocalDate fechaRegistro, LocalDate fechaPago, Proveedor proveedor, String comprobante,GastoConcepto categoria, double importe, boolean liquidado);
    public abstract void deleteGasto(Gasto gasto);
    
    //Metodos CRUD de Liquidacion
    public abstract void saveLiquidacion(Liquidacion liquidacion);
    public abstract List<Liquidacion> viewLiquidaciones();
    public abstract void deleteLiquidacion(Liquidacion liquidacion);
    
}
