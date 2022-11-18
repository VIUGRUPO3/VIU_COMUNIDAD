// Autor Grupo 3

//************************ INFO ************************
//Clase para gestionar  el trabajo con las listas en fase de pruebas

package repositorio;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import repositorio.Categoria;
import repositorio.Categoria;
import repositorio.Gasto;
import repositorio.Gasto;
import repositorio.Inmueble;
import repositorio.Inmueble;
import repositorio.InterfaceComunidadCRUD;
import repositorio.Liquidacion;
import repositorio.Liquidacion;
import repositorio.Proveedor;
import repositorio.Proveedor;
import repositorio.Servicio;
import repositorio.Servicio;
import repositorio.Vecino;
import repositorio.Vecino;


public class ComunidadCRUD implements InterfaceComunidadCRUD {
    
//1. Atributos
    protected List<Vecino> vecinos;
    protected List<Inmueble> inmuebles;
    protected List<Categoria> categorias;
    protected List<Servicio> servicios;
    protected List<Proveedor> proveedores;
    protected List<Gasto> gastos;
    protected List<Liquidacion> liquidaciones;
    //Asociacion de inmueble sin propietario a comunidad
    Vecino vecino = new Vecino(0, "Comunidad", "000", "666555222", "comunidad@viu.es");
    
//2.Constructores

    public ComunidadCRUD() {
        this.vecinos = new ArrayList();
        this.inmuebles = new ArrayList();
        this.categorias = new ArrayList();
        this.servicios = new ArrayList();
        this.proveedores = new ArrayList();
        this.gastos = new ArrayList();
        this.liquidaciones = new ArrayList();
    }
    

//3. Metodos
    
//Getters

    public List<Vecino> getVecinos() {
        return vecinos;
    }

    public List<Inmueble> getInmuebles() {
        return inmuebles;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }


    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    public List<Liquidacion> getLiquidaciones() {
        return liquidaciones;
    }

    public Vecino getVecino() {
        return vecino;
    }
    
    
    
//VECINOS
       
        //Metodo que almacena un objeto vecino dentro de un ArrayList
    @Override
    public void saveVecino(Vecino vecino){
        vecinos.add(vecino);
    }
    
        //Metodo que devuelve la lista de vecinos
    @Override
    public List<Vecino> viewVecinos(){
        return vecinos;
    }

        //Metodo que actualiza los datos del vecino especificado en parametros
    @Override
    public void updateVecino(Vecino vecino, String nombre, String clave, String telefono, String email){
        vecino.nombre=nombre;
        vecino.clave=clave;
        vecino.telefono=telefono;
        vecino.email=email; 
    }
    
        //Metodo que borra un objeto vecino del ArrayList de Vecinos ademas al eliminar al vecino actualiza los inmuebles del vecino dejandolos sin propietario
    @Override
    public void deleteVecino(Vecino vecino){
        vecinos.remove(vecinos.indexOf(vecino));
        inmuebles.forEach(inmueble -> {
            if(inmueble.getVecino() == vecino){
                inmueble.setVecino(this.vecino);
            }
        });
        
    }

    

   
//INMUEBLES
    
        //Metodo que almacena un objeto inmueble dentro de un ArrayList de Inmuebles
    @Override
    public void saveInmueble(Inmueble inmueble){
        inmuebles.add(inmueble);
    }
    
        //Metodo que devuelve la lista de inmuebles
    @Override
    public List<Inmueble> viewInmuebles(){
        return inmuebles;
    }

        //Metodo que actualiza los datos del inmueble especificado en parametros
    @Override
    public void updateInmueble(Inmueble inmueble, Vecino vecino, String direccion){
        inmueble.setInmueble(vecino, direccion);
    }
        
        //Metodo que borra un objeto vecino del ArrayList de Inmuebles
    @Override
    public void deleteInmueble(Inmueble inmueble){
        inmuebles.remove(inmuebles.indexOf(inmueble));
    }
    
//SERVICIOS
     
        //Metodo que almacena un objeto servicioFijo dentro de un ArrayList de serviciosFijos
    @Override
    public void saveServicio(Servicio servicio){
        servicios.add(servicio);
    }
    
       //Metodo que devuelve la lista de serviciosFijos
    @Override
    public List<Servicio> viewServicios(){
        return servicios;
    }    
     
        //Metodo que actualiza los datos del inmueble especificado en parametros
    @Override
    public void updateServicio(Servicio servicio, String nombre, double tarifa){
        servicio.nombre = nombre;
        servicio.tarifa = tarifa;
        
    }

        //Metodo que borra un objeto servicioFijo del ArrayList de serviciosFijos
    @Override
    public void deleteServicio(Servicio servicio){
        servicios.remove(servicios.indexOf(servicio));
    }

//CATEGORIAS (CONCEPTOS/RUBROS
    
        //Metodo que almacena un objeto inmueble dentro de un ArrayList de Inmuebles
    @Override
    public void saveCategoria(Categoria categoria){
        categorias.add(categoria);
    }

        //Metodo que devuelve la lista de inmuebles
    @Override
    public List<Categoria> viewCategorias(){
        return categorias;
    }
      
        //Metodo que actualiza los datos del inmueble especificado en parametros
    @Override
    public void updateCategoria(Categoria categoria, Servicio servicio, String nombre){
        categoria.setServicio(servicio);
        categoria.setNombre(nombre);
    }
    
        //Metodo que borra un objeto vecino del ArrayList de Inmuebles
    @Override
    public void deleteCategoria(Categoria categoria){
        categorias.remove(categorias.indexOf(categoria));
    }
    
//PROVEEDORES
    
        //Guarda un Proveedor en ArrayList de PROVEEDORES
    @Override
    public void saveProveedor(Proveedor proveedor){
        proveedores.add(proveedor);
    }
    
    @Override
    public List<Proveedor> viewProveedores(){
        return proveedores;
    }
 
    
        //Actualiza los datos del proveedor en el ArrayList de PROVEEDORES
    @Override
    public void updateProveedor(Proveedor proveedor, String nombre, String direccion, String telefono, String email){
        proveedor.setProveedor(nombre, direccion, telefono, email);
    }
    
        //Borra un Proveedor en ArrayList de PROVEEDORES
    @Override
    public void deleteProveedor(Proveedor proveedor){
        proveedores.remove(proveedores.indexOf(proveedor));
    }

    
//GASTOS
    
        //Guarda un Proveedor en ArrayList de PROVEEDORES
    @Override
    public void saveGasto(Gasto gasto){
        gastos.add(gasto);
    }

    @Override
    public List<Gasto> viewGastos(){
        return gastos;
    }
        
        //Actualiza los datos del proveedor en el ArrayList de PROVEEDORES
    @Override
    public void updateGasto(Gasto gasto, String descripcion, LocalDate fechaRegistro, LocalDate fechaPago, Proveedor proveedor, String comprobante,Categoria categoria, double importe, boolean liquidado){
        gasto.setGasto(descripcion, fechaRegistro, fechaPago, proveedor, comprobante, categoria, importe, liquidado);
    }

        //Borra un Proveedor en ArrayList de PROVEEDORES
    @Override
    public void deleteGasto(Gasto gasto){
        gastos.remove(gastos.indexOf(gasto));
    }
    
  
 //LIQUIDACIONES
    
        //Guarda un Liquidacion en ArrayList de LIQUIDACIONES
    @Override
    public void saveLiquidacion(Liquidacion liquidacion){
        liquidaciones.add(liquidacion);
    }

            //Devuelve el ArrayList de LIQUIDACIONES
    @Override
    public List<Liquidacion> viewLiquidaciones(){
        return liquidaciones;
    }
    
        //Borra un Liquidacion en ArrayList de LIQUIDACIONES
    @Override
    public void deleteLiquidacion(Liquidacion liquidacion){
        liquidaciones.remove(liquidaciones.indexOf(liquidacion));
    }
    

    
    
    
    
    
}
