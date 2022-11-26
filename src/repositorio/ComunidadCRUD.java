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

* 
****/

    /** Paquete **/
    package repositorio;


    import java.time.LocalDate;
    import java.util.ArrayList;
    import java.util.List;

    /**
     *  Clase que gestiona la Comunidad, almacena las colecciones de todos los objetos de la comunidad
     * */
    public class ComunidadCRUD {

    // Atributos

        /**
        *  Coleccion de Vecinos pertenecientes a la Comunidad
        * */
        protected List<Vecino> vecinos;
        /**
        *  Coleccion de Inmuebles pertenecientes a la Comunidad
        * */
        protected List<Inmueble> inmuebles;
        /**
        *  Coleccion de Conceptos de Gastos pertenecientes a la Comunidad
        * */
        protected List<GastoConcepto> gastosConcepto;
        /**
        *  Coleccion de Servicios pertenecientes a la Comunidad
        * */
        protected List<Servicio> servicios;
        /**
        *  Coleccion de Cuentas de Servicios pertenecientes a la Comunidad
        * */
        protected List<ServicioCuenta> serviciosCuenta;
        /**
        *  Coleccion de Proveedores que usa la Comunidad
        * */
        protected List<Proveedor> proveedores;
        /**
        *  Coleccion de Gastos pertenecientes a la Comunidad
        * */
        protected List<Gasto> gastos;
        /**
        *  Coleccion de Liquidaciones efectuadas por la Comunidad
        * */
        protected List<Liquidacion> liquidaciones;
        /**
        *  Coleccion de Detalle de liquidaciones de cada inmueble de la Comunidad
        * */
        protected List<LiquidacionDetalle> liquidacionesDetalle;
        /**
        *  Coleccion de Servicios de la comunidad organizados segun su tipo
        * */
        protected ServicioTipos servicioTipos;
        /**
        *  Vecino Comunidad 
        * */
        protected Vecino vecino = new Vecino(0, "Comunidad", "000", "666555222", "comunidad@viu.es");

    // Constructores

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


    // Metodos

        //Getters
            /** 
            * Metodo para consultar el listado de Vecinos 
            * 
            * @return vecinos Lista de Vecinos
            **/
            public List<Vecino> getVecinos() {
                return vecinos;
            }

            /** 
            * Metodo para consultar el listado de Inmuebles 
            * 
            * @return inmuebles Lista de Inmuebles
            **/
            public List<Inmueble> getInmuebles() {
                return inmuebles;
            }

            /** 
            * Metodo para consultar el listado de Conceptos de Gasto 
            * 
            * @return gastosConcepto Lista de Conceptos de Gasto
            **/
            public List<GastoConcepto> getGastosConcepto() {
                return gastosConcepto;
            }

            /** 
            * Metodo para consultar el listado de Servicios 
            * 
            * @return servicios Lista de Servicios
            **/
            public List<Servicio> getServicios() {
                return servicios;
            }

            /** 
            * Metodo para consultar el listado de Proveedores 
            * 
            * @return proveedores Lista de Proveedores
            **/
            public List<Proveedor> getProveedores() {
                return proveedores;
            }

            /** 
            * Metodo para consultar el listado de Gastos 
            * 
            * @return gastos Lista de Gastos
            **/
            public List<Gasto> getGastos() {
                return gastos;
            }

            /** 
            * Metodo para consultar el listado de liquidaciones 
            * 
            * @return liquidaciones Lista de Liquidaciones
            **/
            public List<Liquidacion> getLiquidaciones() {
                return liquidaciones;
            }

            /** 
            * Metodo para consultar el listado de Detalle de liquidacion 
            * 
            * @return liquidacionDetalle Lista de Detalle de Liquidacion
            **/
            public List<LiquidacionDetalle> getLiquidacionesDetalle() {
                return liquidacionesDetalle;
            }

            /** 
            * Metodo para consultar el Vecino Comunidad 
            * 
            * @return vecino Devuelve el vecino Comunidad
            **/
            public Vecino getVecino() {
                return vecino;
            }

            /** 
            * Metodo para consultar el listado de Cuentas de Servicios 
            * 
            * @return serviciosCuenta Lista de Cuentas de Servicio
            **/
            public List<ServicioCuenta> getServiciosCuenta() {
                return serviciosCuenta;
            }

            /** 
            * Metodo para consultar el listado los Servicios segun su tipologia 
            * 
            * @return servicioTipos Lista de Servcios segun su tipologia
            **/
            public ServicioTipos getServicioTipos() {
                return servicioTipos;
            } 
    }
