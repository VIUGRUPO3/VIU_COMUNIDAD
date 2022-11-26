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
import java.util.ArrayList;
import java.util.List;


public class ComunidadCRUD {
    
//1. Atributos
    protected List<Vecino> vecinos;
    protected List<Inmueble> inmuebles;
    protected List<GastoConcepto> gastosConcepto;
    protected List<Servicio> servicios;
    protected List<ServicioCuenta> serviciosCuenta;
    protected List<Proveedor> proveedores;
    protected List<Gasto> gastos;
    protected List<Liquidacion> liquidaciones;
    protected List<LiquidacionDetalle> liquidacionesDetalle;
    protected ServicioTipos servicioTipos;
    //Asociacion de inmueble sin propietario a comunidad
    protected Vecino vecino = new Vecino(0, "Comunidad", "000", "666555222", "comunidad@viu.es");
    
//2.Constructores

    public ComunidadCRUD() {
        this.vecinos = new ArrayList();
        this.inmuebles = new ArrayList();
        this.gastosConcepto = new ArrayList();
        this.servicios = new ArrayList();
        this.serviciosCuenta = new ArrayList();
        this.proveedores = new ArrayList();
        this.gastos = new ArrayList();
        this.liquidaciones = new ArrayList();
        this.liquidacionesDetalle = new ArrayList();
        this.servicioTipos = new ServicioTipos();
    }
    

//3. Metodos
    
//Getters

    public List<Vecino> getVecinos() {
        return vecinos;
    }

    public List<Inmueble> getInmuebles() {
        return inmuebles;
    }

    public List<GastoConcepto> getGastosConcepto() {
        return gastosConcepto;
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

    public List<LiquidacionDetalle> getLiquidacionesDetalle() {
        return liquidacionesDetalle;
    }
    

    public Vecino getVecino() {
        return vecino;
    }

    public List<ServicioCuenta> getServiciosCuenta() {
        return serviciosCuenta;
    }

    public ServicioTipos getServicioTipos() {
        return servicioTipos;
    } 
}
