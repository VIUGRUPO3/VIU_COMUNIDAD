
package repositorio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author fer
 */

//Clase encargada de realizar todas las operaciones con los usuarios vecinos, implementa la interfaz UserInterfaceOps
public class Admin extends Usuario implements OpsAdmin {
    
    //1. Atributos
    
    private final List<Vecino> vecinos;
    private final List<Inmueble> inmuebles;
    private final List<Categoria> categorias;
    private final List<ServicioFijo> serviciosFijos;
    private final List<ServicioOpcional> serviciosOpcionales;
    private final List<Proveedor> proveedores;
    private final List<Gasto> gastos;
    Vecino vecino = new Vecino(0, "Comunidad", "000", "666555222", "comunidad@viu.es");
    
    //2.Constructores

    public Admin() {
        this.vecinos = new ArrayList();
        this.inmuebles = new ArrayList();
        this.categorias = new ArrayList();
        this.serviciosFijos = new ArrayList();
        this.serviciosOpcionales = new ArrayList();
        this.proveedores = new ArrayList();
        this.gastos = new ArrayList();
    }

    public Admin(int id, String nombre, String clave, String telefono, String email) {
        super(id, nombre, clave, telefono, email);
        this.vecinos = new ArrayList();
        this.inmuebles = new ArrayList();
        this.categorias = new ArrayList();
        this.serviciosFijos = new ArrayList();
        this.serviciosOpcionales = new ArrayList();
        this.proveedores = new ArrayList();
        this.gastos = new ArrayList();
        
    }
    
    

    //3. Metodos
    
    
//VECINOS
    
        //Metodo que almacena un objeto vecino dentro de un ArrayList
    @Override
    public void saveVecino(Vecino vecino){
        vecinos.add(vecino);
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
    
    
//INMUEBLES
    
        //Metodo que almacena un objeto inmueble dentro de un ArrayList de Inmuebles
    @Override
    public void saveInmueble(Inmueble inmueble){
        inmuebles.add(inmueble);
    }
        //Metodo que borra un objeto vecino del ArrayList de Inmuebles
    @Override
    public void deleteInmueble(Inmueble inmueble){
        inmuebles.remove(inmuebles.indexOf(inmueble));
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
    

//CATEGORIAS (CONCEPTOS/RUBROS
    
        //Metodo que almacena un objeto inmueble dentro de un ArrayList de Inmuebles
    @Override
    public void saveCategoria(Categoria categoria){
        categorias.add(categoria);
    }
        //Metodo que borra un objeto vecino del ArrayList de Inmuebles
    @Override
    public void deleteCategoria(Categoria categoria){
        categorias.remove(categorias.indexOf(categoria));
    }
    
        //Metodo que devuelve la lista de inmuebles
    @Override
    public List<Categoria> viewCategorias(){
        return categorias;
    }
    
        //Metodo que actualiza los datos del inmueble especificado en parametros
    @Override
    public void updateCategoria(Categoria categoria, String nombre){
        categoria.setCategoria(nombre);
    }
    
//SERVICIOS FIJOS
        
        //Metodo que almacena un objeto servicioFijo dentro de un ArrayList de serviciosFijos
    @Override
    public void saveServicioFijo(ServicioFijo servicioFijo){
        serviciosFijos.add(servicioFijo);
    }
    
        //Metodo que asigna un servicioFijo a todos los inmuebles
    @Override
    public void asignarServicioFijoInmuebles(ServicioFijo servicioFijo){
        inmuebles.forEach(inmueble -> {
            inmueble.serviciosFijos.add(servicioFijo);
        }); 
    }
    
        //Metodo que borra un objeto servicioFijo del ArrayList de serviciosFijos
    @Override
    public void deleteServicioFijo(ServicioFijo servicioFijo){
        serviciosFijos.remove(serviciosFijos.indexOf(servicioFijo));
    }
    
        //Metodo que desasigna un servicioFijo a todos los inmuebles
    @Override
    public void desasignarServicioFijoInmuebles(ServicioFijo servicioFijo){
        inmuebles.forEach(inmueble -> {
            inmueble.serviciosFijos.remove(inmueble.serviciosFijos.indexOf(servicioFijo));
        }); 
    }
    
        //Metodo que actualiza los datos del inmueble especificado en parametros
    @Override
    public void updateServicioFijo(ServicioFijo servicioFijo, String nombre, double tarifa, Categoria categoria){
        servicioFijo.nombre = nombre;
        servicioFijo.tarifa = tarifa;
        servicioFijo.categoria = categoria;
    }
    
        //Este metodo resulta innecesario ya que el update referencia al objeto
    //public void updateServicioFijoInmuebles(ServicioFijo servicioFijo){
    //    inmuebles.forEach(inmueble ->{
    //        inmueble.serviciosFijos.set(inmueble.serviciosFijos.indexOf(servicioFijo), servicioFijo);
    //    });
    //}
    
    //Metodo que devuelve la lista de serviciosFijos
    @Override
    public List<ServicioFijo> viewServiciosFijos(){
        return serviciosFijos;
    }
    
//SERVICIOS OPCIONALES
        
        //Metodo que almacena un objeto servicioOpcional dentro de un ArrayList de serviciosFijos
    @Override
    public void saveServicioOpcional(ServicioOpcional servicioOpcional){
        serviciosOpcionales.add(servicioOpcional);
    }
    
        //Metodo que asigna un servicioOpcional a un inmueble
    @Override
    public void asignarServicioOpcionalInmueble(ServicioOpcional servicioOpcional, Inmueble inmueble){
        inmueble.serviciosOpcionales.add(servicioOpcional);
    }
    
        //Metodo que borra un objeto servicioOpcional del ArrayList de serviciosFijos
    @Override
    public void deleteServicioOpcional(ServicioOpcional servicioOpcional){
        serviciosOpcionales.remove(serviciosOpcionales.indexOf(servicioOpcional));
    }
    
    //Metodo que desasigna un servicioOpcinal a todos los inmuebles que lo tengan
    @Override
    public void desasignarServicioOcionalInmuebles(ServicioOpcional servicioOpcional){
        inmuebles.forEach(inmueble -> {
            if(inmueble.serviciosOpcionales.indexOf(servicioOpcional)>0){
                inmueble.serviciosOpcionales.remove(inmueble.serviciosOpcionales.indexOf(servicioOpcional));
            }
            
        }); 
    }
    
        //Metodo que desasigna un servicioFijo al inmueble especificado
    @Override
    public void desasignarServicioOpcionalInmueble(ServicioOpcional servicioOpcional, Inmueble inmueble){
        inmueble.serviciosOpcionales.remove(inmueble.serviciosOpcionales.indexOf(servicioOpcional));
    }
    
        //Metodo que actualiza los datos del servicioOpcional especificado en parametros
    @Override
    public void updateServicioOpcional(ServicioOpcional servicioOpcional, String nombre, double tarifa, Categoria categoria){
        servicioOpcional.nombre = nombre;
        servicioOpcional.tarifa = tarifa;
        servicioOpcional.categoria = categoria;
    }
    
        //Metodo que devuelve la lista de serviciosOpcionales
    @Override
    public List<ServicioOpcional> viewServiciosOpcionales(){
        return serviciosOpcionales;
    }
    
//PROVEEDORES
    
        //Guarda un Proveedor en ArrayList de PROVEEDORES
    @Override
    public void saveProveedor(Proveedor proveedor){
        proveedores.add(proveedor);
    }
    
        //Borra un Proveedor en ArrayList de PROVEEDORES
    @Override
    public void deleteProveedor(Proveedor proveedor){
        proveedores.remove(proveedores.indexOf(proveedor));
    }
    
        //Actualiza los datos del proveedor en el ArrayList de PROVEEDORES
    @Override
    public void updateProveedor(Proveedor proveedor, String nombre, String direccion, String telefono, String email){
        proveedor.setProveedor(nombre, direccion, telefono, email);
    }
    
    @Override
    public List<Proveedor> viewProveedores(){
        return proveedores;
    }
    
//GASTOS
    
        //Guarda un Proveedor en ArrayList de PROVEEDORES
    @Override
    public void saveGasto(Gasto gasto){
        gastos.add(gasto);
    }
    
        //Borra un Proveedor en ArrayList de PROVEEDORES
    @Override
    public void deleteGasto(Gasto gasto){
        gastos.remove(gastos.indexOf(gasto));
    }
    
        //Actualiza los datos del proveedor en el ArrayList de PROVEEDORES
    @Override
    public void updateGasto(Gasto gasto, String descripcion, LocalDate fechaRegistro, LocalDate fechaPago, Proveedor proveedor, String comprobante,Categoria categoria, double importe){
        gasto.setGasto(descripcion, fechaRegistro, fechaPago, proveedor, comprobante, categoria, importe);
    }
    
    @Override
    public List<Gasto> viewGasto(){
        return gastos;
    }
}
