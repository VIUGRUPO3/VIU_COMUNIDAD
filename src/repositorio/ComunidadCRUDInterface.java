// Autor Grupo 3

//************************ INFO ************************

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
    public void saveServiciosCuenta(ServicioCuenta servicioCuenta);
    public abstract List<ServicioCuenta> viewServiciosCuenta();
    
    
    //Metodos CRUD de Categoria
    public abstract void saveCategoria(GastoCategoria categoria);
    public abstract List<GastoCategoria> viewCategorias();
    public abstract void updateCategoria(GastoCategoria categoria, Servicio servicio, String nombre);
    public abstract void deleteCategoria(GastoCategoria categoria);
    
    //Metodos CRUD de Proveedor
    public abstract void saveProveedor(Proveedor proveedor);
    public abstract List<Proveedor> viewProveedores();
    public abstract void updateProveedor(Proveedor proveedor, String nombre, String direccion, String telefono, String email);
    public abstract void deleteProveedor(Proveedor proveedor);
        
    //Metodos CRUD de Gasto
    public abstract void saveGasto(Gasto gasto);
    public abstract List<Gasto> viewGastos();
    public abstract void updateGasto(Gasto gasto, String descripcion, LocalDate fechaRegistro, LocalDate fechaPago, Proveedor proveedor, String comprobante,GastoCategoria categoria, double importe, boolean liquidado);
    public abstract void deleteGasto(Gasto gasto);
    
    //Metodos CRUD de Liquidacion
    public abstract void saveLiquidacion(Liquidacion liquidacion);
    public abstract List<Liquidacion> viewLiquidaciones();
    public abstract void deleteLiquidacion(Liquidacion liquidacion);
    
}
