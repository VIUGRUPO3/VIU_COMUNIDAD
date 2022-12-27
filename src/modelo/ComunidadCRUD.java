// Asignatura: 21GIIN Proyectos Programación
// Profesor: Eduardo Zamudio
// @author: Grupo 3
// Miembros:
//       @author:Fernando Hernandez Fernandez
//       @author:Javier Barbero Sales
//       @author:Martin Gonzalez Dominguez
// @version: 01/12/2022/
// Paquete
package modelo;
 
import modelo.usuario.Vecino;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona la Comunidad, almacena las colecciones de todos los
 * objetos de la comunidad
 *
 */
public class ComunidadCRUD {

// Atributos
    /**
     * Coleccion de Vecinos pertenecientes a la Comunidad
     *
     */
    protected List<Vecino> vecinos;
    /**
     * Coleccion de Inmuebles pertenecientes a la Comunidad
     *
     */
    protected List<Inmueble> inmuebles;
    /**
     * Coleccion de Conceptos de Gastos pertenecientes a la Comunidad
     *
     */
    protected List<GastoConcepto> gastosConcepto;
    /**
     * Coleccion de Servicios pertenecientes a la Comunidad
     *
     */
    protected List<Servicio> servicios;
    /**
     * Coleccion de Cuentas de Servicios pertenecientes a la Comunidad
     *
     */
    protected List<ServicioCuenta> serviciosCuenta;
    /**
     * Coleccion de Proveedores que usa la Comunidad
     *
     */
    protected List<Proveedor> proveedores;
    /**
     * Coleccion de Gastos pertenecientes a la Comunidad
     *
     */
    protected List<Gasto> gastos;
    /**
     * Coleccion de Liquidaciones efectuadas por la Comunidad
     *
     */
    protected List<Liquidacion> liquidaciones;
    /**
     * Coleccion de Detalle de liquidaciones de cada inmueble de la Comunidad
     *
     */
    protected List<LiquidacionDetalleServicio> liquidacionesDetalleServicio;
    /**
     * Coleccion de Detalle de liquidaciones de cada inmueble de la Comunidad
     *
     */
    protected List<LiquidacionDetalleGasto> liquidacionesDetalleGasto;

    /**
     * Vecino Comunidad
     *
     */
    protected Vecino vecino = new Vecino(0, "Comunidad", "VIU", "comunidad", "000", "666555222", "comunidad@viu.es");

// Constructores
    /**
     * Constructor de la clase ComunidadCRUD
     */
    public ComunidadCRUD() {
        this.vecinos = new ArrayList();
        this.inmuebles = new ArrayList();
        this.gastosConcepto = new ArrayList();
        this.servicios = new ArrayList();
        this.serviciosCuenta = new ArrayList();
        this.proveedores = new ArrayList();
        this.gastos = new ArrayList();
        this.liquidaciones = new ArrayList();
        this.liquidacionesDetalleServicio = new ArrayList();
        this.liquidacionesDetalleGasto = new ArrayList();
    }

// Métodos
    //Getters
    /**
     * Método para consultar el listado de Vecinos
     *
     * @return vecinos Lista de Vecinos
     *
     */
    public List<Vecino> getVecinos() {
        return vecinos;
    }

    /**
     * Método para consultar el listado de Inmuebles
     *
     * @return inmuebles Lista de Inmuebles
     *
     */
    public List<Inmueble> getInmuebles() {
        return inmuebles;
    }

    /**
     * Método para consultar el listado de Conceptos de Gasto
     *
     * @return gastosConcepto Lista de Conceptos de Gasto
     *
     */
    public List<GastoConcepto> getGastosConcepto() {
        return gastosConcepto;
    }

    /**
     * Método para consultar el listado de Servicios
     *
     * @return servicios Lista de Servicios
     *
     */
    public List<Servicio> getServicios() {
        return servicios;
    }

    /**
     * Método para consultar el listado de Proveedores
     *
     * @return proveedores Lista de Proveedores
     *
     */
    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    /**
     * Método para consultar el listado de Gastos
     *
     * @return gastos Lista de Gastos
     *
     */
    public List<Gasto> getGastos() {
        return gastos;
    }

    /**
     * Método para consultar el listado de liquidaciones
     *
     * @return liquidaciones Lista de Liquidaciones
     *
     */
    public List<Liquidacion> getLiquidaciones() {
        return liquidaciones;
    }

    /**
     * Método para consultar el listado de Detalle de liquidacion
     *
     * @return liquidacionDetalle Lista de Detalle de Liquidacion
     *
     */
    public List<LiquidacionDetalleServicio> getLiquidacionesDetalleServicio() {
        return liquidacionesDetalleServicio;
    }

    /**
     * Método para consultar el listado de Detalle de liquidacion
     *
     * @return liquidacionDetalle Lista de Detalle de Liquidacion
     *
     */
    public List<LiquidacionDetalleGasto> getLiquidacionesDetalleGasto() {
        return liquidacionesDetalleGasto;
    }

    /**
     * Método para consultar el Vecino Comunidad
     *
     * @return vecino Devuelve el vecino Comunidad
     *
     */
    public Vecino getVecino() {
        return vecino;
    }

    /**
     * Método para consultar el listado de Cuentas de Servicios
     *
     * @return serviciosCuenta Lista de Cuentas de Servicio
     *
     */
    public List<ServicioCuenta> getServiciosCuenta() {
        return serviciosCuenta;
    }

    //Setters
    //No se identifican metodos Setters
    // Funcionales
    // No se identifican metodos funcionales especificos
    //Print
    // No se indentifican metodos print especificos
}
