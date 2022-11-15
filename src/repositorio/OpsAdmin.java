
package repositorio;

import java.time.LocalDate;
import java.util.List;

    //Interface para las operaciones realizadas con los usuarios vecinos
public interface OpsAdmin {
    
    //1.Atributos
    
    //2. Metodos
    
        //Metodos con objetos Vecino
    public abstract void saveVecino(Vecino vecino); 
    public abstract void deleteVecino(Vecino vecino);
    public abstract List<Vecino> viewVecinos();
    public abstract void updateVecino(Vecino vecino, String nombre, String clave, String telefono, String email);
    
         //Metodos con objetos Categoria
    public abstract void saveCategoria(Categoria categoria);
    public abstract void deleteCategoria(Categoria categoria);
    public abstract List<Categoria> viewCategorias();
    public abstract void updateCategoria(Categoria categoria, String nombre);
    
        //Metodos con objetos Inmueble
    public abstract void saveInmueble(Inmueble inmueble);
    public abstract void deleteInmueble(Inmueble inmueble);
    public abstract List<Inmueble> viewInmuebles();
    public abstract void updateInmueble(Inmueble inmueble, Vecino vecino, String direccion);
    
        //Metodos con ServicioFijo
   public abstract void saveServicioFijo(ServicioFijo servicioFijo);
   public abstract void asignarServicioFijoInmuebles(ServicioFijo servicioFijo);
   public abstract void deleteServicioFijo(ServicioFijo servicioFijo);
   public abstract void desasignarServicioFijoInmuebles(ServicioFijo servicioFijo);
   public abstract void updateServicioFijo(ServicioFijo servicioFijo, String nombre, double tarifa);
   //public void updateServicioFijoInmuebles(ServicioFijo servicioFijo); Este metodo no hace falta ya que el update referencia al objeto.
   public abstract List<ServicioFijo> viewServiciosFijos();
   
        //Metodos con ServicioOpcional
   public abstract void saveServicioOpcional(ServicioOpcional servicioOpcional);
   public abstract void asignarServicioOpcionalInmueble(ServicioOpcional servicioOpcional, Inmueble inmueble);
   public abstract void deleteServicioOpcional(ServicioOpcional servicioOpcional);
   public abstract void desasignarServicioOcionalInmuebles(ServicioOpcional servicioOpcional);
   public abstract void desasignarServicioOpcionalInmueble(ServicioOpcional servicioOpcional, Inmueble inmueble);
   public abstract void updateServicioOpcional(ServicioOpcional servicioOpcional, String nombre, double tarifa);
   public abstract List<ServicioOpcional> viewServiciosOpcionales();
   
        //Metodos con Proveedor
   public abstract void saveProveedor(Proveedor proveedor);
   public abstract void deleteProveedor(Proveedor proveedor);
   public abstract void updateProveedor(Proveedor proveedor, String nombre, String direccion, String telefono, String email);
   public abstract List<Proveedor> viewProveedores();
   
        //Metodos con Gasto
   public abstract void saveGasto(Gasto gasto);
   public abstract void deleteGasto(Gasto gasto);
   public abstract void updateGasto(Gasto gasto, String descripcion, LocalDate fechaRegistro, LocalDate fechaPago, Proveedor proveedor, String comprobante,Categoria categoria, double importe);
   public abstract List<Gasto> viewGastos();
   
        //Metodos con Liquidacion
   public abstract void saveLiquidacion(Liquidacion liquidacion);
   public abstract void deleteLiquidacion(Liquidacion liquidacion);
   public abstract List<Liquidacion> viewLiquidaciones();
   //public Liquidacion generarLiquidacion(LocalDate fechaInicio, LocalDate fechaFin, Inmueble inmuebleLiquidado);
   public abstract List<Liquidacion> generarLiquidaciones(LocalDate fechaInicio, LocalDate fechaFin);
   public abstract List<Liquidacion> consultaLiquidacionInmueble (Inmueble inmueble);
   public abstract List<Liquidacion> consultaLiquidacionVecino (Vecino vecino);
   
    
    
}
