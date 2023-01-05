// Asignatura: 21GIIN Proyectos Programación
// Profesor: Eduardo Zamudio
// @author: Grupo 3
// Miembros:
//       @author:Fernando Hernandez Fernandez
//       @author:Javier Barbero Sales
//       @author:Martin Gonzalez Dominguez
// @version: 01/12/2022/
// Paquete
package modelo.usuario;

import java.time.LocalDate;
import java.util.Date;
import modelo.ComunidadCRUD;
import modelo.Gasto;
import modelo.GastoConcepto;
import modelo.GastoConceptoCompuesto;
import modelo.GastoConceptoSimple;
import modelo.Inmueble;
import modelo.Liquidacion;
import modelo.Proveedor;
import modelo.Servicio;

/**
 * Clase que gestiona el tipo de usuario Admin, hereda de Usuario
 *
 */
public class Admin extends Usuario implements AdminInterface {

    // Atributos 
    // Todos los atributos son heredados de la clase Usuario
    // Constructores 
    /**
     * Constructor de la clase Admin
     * 
     * @param id Identificador unico de Admin
     * @param nombre Nombre comun completo Admin
     * @param apellidos Apellidos del vecino
     * @param userName nombre de usuario de acceso a la aplicacion
     * @param clave Clave / Contraseña de acceso del Admin
     * @param telefono Telefono asociado a Admin
     * @param email Email asociado a Admin
    *
     */
    public Admin(int id, String nombre, String apellidos, String userName, String clave, String telefono, String email) {
        super(id, nombre, apellidos, userName, clave, telefono, email);
    }
    public Admin( String nombre, String apellidos, String userName, String clave, String telefono, String email) {
        super(nombre, apellidos, userName, clave, telefono, email);
    }

// Métodos
    // Funcionalidad
    /**
     * Método para crear una instancia de la clase Vecino y añadirlo a la
     * Comunidad
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la Comunidad
     * @param id identificador unico del objeto Vecino
     * @param nombre nombre propio del objeto Vecino
     * @param apellidos Apellidos del vecino
     * @param userName Nombre de usuario de acceso a la aplicacion
     * @param clave clave de acceso a la aplicacion para este Vecino
     * @param telefono telefono de contacto del Vecino
     * @param email email de contacto del Vecino
        *
     */
    public void altaVecino(ComunidadCRUD comunidadCRUD, int id, String nombre, String apellidos, String userName, String clave, String telefono, String email) {
        Vecino vecino = new Vecino(id, nombre, apellidos, userName, clave, telefono, email);
        comunidadCRUD.getVecinos().add(vecino);
    }

    /**
     * Método para eliminar un Vecino de la Comunidad quedando sus inmuebles a
     * cargo de la Comunidad
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la Comunidad
     * @param vecino instancia de la clase Vecino que se va a eliminar
        *
     */
    @Override
    public void bajaVecino(ComunidadCRUD comunidadCRUD, Vecino vecino) {
        vecino.bajaVecino(comunidadCRUD, vecino);
    }

    /**
     * Método para actualizar los datos de una instancia de la clase Vecino
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la Comunidad
     * @param nombre nombre propio del objeto Vecino
     * @param clave clave de acceso a la aplicacion para este Vecino
     * @param telefono telefono de contacto del Vecino
     * @param email email de contacto del Vecino
     * @param vecino instancia de la clase Vecino de la cual se va a actualizar
     * la informacion
        *
     */
    @Override
    public void updateVecino(ComunidadCRUD comunidadCRUD, String nombre, String clave, String telefono, String email, Vecino vecino) {
        vecino.updateVecino(comunidadCRUD, nombre, clave, telefono, email, vecino);
    }

    /**
     * Método para dar de alta una instancia de la clase Inmueble y añadirlo a
     * la Comunidad
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la Comunidad
     * @param id identificador de la instancia de la clase Inmueble
     * @param vecino instancia de la clase Vecino propietario del Inmueble
     * @param direccion direccion completa del Inmueble
        *
     */
    @Override
    public void altaInmueble(ComunidadCRUD comunidadCRUD, int id, Vecino vecino, String direccion) {
        Inmueble inmueble = new Inmueble(id, vecino, direccion);
        comunidadCRUD.getInmuebles().add(inmueble);
    }

    /**
     * Método para dar de baja una instancia de la clase Inmueble y eliminarlo
     * de la comunidad
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la comunidad
     * @param inmueble instancia de la clase Inmueble que causara baja y se
     * eliminara de la comunidad
        *
     */
    @Override
    public void bajaInmueble(ComunidadCRUD comunidadCRUD, Inmueble inmueble) {
        inmueble.bajaInmueble(comunidadCRUD, inmueble);
    }

    /**
     * Método para actualizar los datos de una instancia de la clase Inmueble
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la comunidad
     * @param vecino instancia de la clase vecino propietaria del Inmueble
     * @param direccion direccion completa del inmueble
     * @param inmueble instancia de la clase Inmueble que actualizara los datos
        *
     */
    @Override
    public void updateInmueble(ComunidadCRUD comunidadCRUD, Vecino vecino, String direccion, Inmueble inmueble) {
        inmueble.updateInmueble(comunidadCRUD, vecino, direccion, inmueble);
    }

    /**
     * Método para dar de alta una instancia de la clase Servicio y añadirlo a
     * la Comunidad
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la Comunidad
     * @param id identificador de la instancia Servicio
     * @param nombre nombre descriptivo del Servicio
     * @param tarifa tarifa que se cobrara a los que utilicen el Servicio
     * @param opcional tipo de servicio
        *
     */
    @Override
    public void altaServicio(ComunidadCRUD comunidadCRUD, int id, String nombre, double tarifa, boolean opcional) {
        Servicio servicio = new Servicio(id, nombre, tarifa, opcional);
        comunidadCRUD.getServicios().add(servicio);
    }

    /**
     * Método para dar de baja una instancia de la clase Servicio y eliminarlo
     * de la Comunidad
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la Comunidad
     * @param servicio instancia de la clase Servicio que causara baja y se
     * eliminara de la Comunidad 
        *
     */
    @Override
    public void bajaServicio(ComunidadCRUD comunidadCRUD, Servicio servicio) {
        servicio.bajaServicio(comunidadCRUD, servicio);
    }

    /**
     * Método para actualizar los datos de una instancia de la clase Servicio
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la comunidad
     * @param nombre nombre descriptivo del Servicio
     * @param tarifa tarifa que se cobrara a los que utilicen el Servicio
     * @param opcional tipo de servicio
     * @param servicio instancia de la clase Servicio que actualizara los datos
        *
     */
    @Override
    public void updateServicio(ComunidadCRUD comunidadCRUD, String nombre, double tarifa, boolean opcional, Servicio servicio) {
        servicio.updateServicio(comunidadCRUD, nombre, tarifa, opcional, servicio);
    }

    /**
     * Método para dar de alta una instancia de la clase Proveedor y añadirlo a
     * la Comunidad
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la Comunidad
     * @param id identificador de la instancia Proveedor
     * @param nombre nombre del Proveedor
     * @param direccion tarifa que se cobrara a los que utilicen el Servicio
     * @param telefono telefono de contacto del Proveedor
     * @param email email de contacto del Proveedor
        *
     */
    @Override
    public void altaProveedor(ComunidadCRUD comunidadCRUD, int id, String nombre, String direccion, String telefono, String email) {
        Proveedor proveedor = new Proveedor(id, nombre, direccion, telefono, email);
        comunidadCRUD.getProveedores().add(proveedor);
    }

    /**
     * Método para dar de baja una instancia de la clase Proveedor y eliminarlo
     * de la Comunidad
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la Comunidad
     * @param proveedor instancia de la clase Proveedor que causara baja y se
     * eliminara de la Comunidad 
        *
     */
    @Override
    public void bajaProveedor(ComunidadCRUD comunidadCRUD, Proveedor proveedor) {
        proveedor.bajaProveedor(comunidadCRUD, proveedor);
    }

    /**
     * Método para actualizar los datos de una instancia de la clase Proveedor
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la comunidad
     * @param nombre nombre del Proveedor
     * @param direccion direccion de contacto del Proveedor
     * @param telefono telefono de contacto del Proveedor
     * @param email email de contacto del Proveedor
     * @param proveedor instancia de la clase Servicio que actualizara los datos
        *
     */
    @Override
    public void updateProveedor(ComunidadCRUD comunidadCRUD, String nombre, String direccion, String telefono, String email, Proveedor proveedor) {
        proveedor.updateProveedor(comunidadCRUD, nombre, direccion, telefono, email, proveedor);
    }

    /**
     * Método para dar de alta una instancia de la clase GastoConceptoCompuesto
     * y añadirlo a la Comunidad, un concepto de gasto asociara un gasto a un
     * servicio para su inclusion en las liquidaciones pertinentes
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la Comunidad
     * @param id identificador de la instancia Concepto de Gasto
     * @param nombre nombre del Concepto de Gasto
     * @param servicio Servicio al que esta asociado el Concepto de Gasto
     * compuesto
        *
     */
    @Override
    public void altaGastoConceptoCompuesto(ComunidadCRUD comunidadCRUD, int id, String nombre, Servicio servicio) {
        GastoConceptoCompuesto gastoConceptoCompuesto = new GastoConceptoCompuesto(id, nombre, servicio);
        comunidadCRUD.getGastosConcepto().add(gastoConceptoCompuesto);
    }

    /**
     * Método para dar de alta una instancia de la clase GastoConceptoSimple y
     * añadirlo a la Comunidad, un concepto de gasto asociara un gasto a un
     * servicio para su inclusion en las liquidaciones pertinentes
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la Comunidad
     * @param id identificador de la instancia Concepto de Gasto
     * @param nombre nombre del Concepto de Gasto
     * @param servicio Servicio al que esta asociado el Concepto de Gasto
     * compuesto
        *
     */
    @Override
    public void altaGastoConceptoSimple(ComunidadCRUD comunidadCRUD, int id, String nombre, Servicio servicio) {
        GastoConceptoSimple gastoConceptoSimple = new GastoConceptoSimple(id, nombre, servicio);
        comunidadCRUD.getGastosConcepto().add(gastoConceptoSimple);
    }

    /**
     * Método para dar de alta una instancia de la clase Gasto y añadirlo a la
     * Comunidad
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la Comunidad
     * @param id identificador de la instancia Gasto
     * @param descripcion descripcion del Gasto
     * @param fechaRegistro fecha en la que se registra el Gasto
     * @param fechaPago fecha en la que se realiza el pago del Gasto
     * @param proveedor Proveedor del Gasto
     * @param comprobante numero de comprobante del Gasto proporcionado por el
     * proveedor
     * @param gastoConcepto concepto/rubro asociado al gasto
     * @param importe importe del Gasto
     * @param liquidado Indica si se ha realizado el cobro del Gasto en las
     * liquidacion o esta pendiente 
        *
     */
    @Override
    public void altaGasto(ComunidadCRUD comunidadCRUD, int id, String descripcion, Date fechaRegistro, Date fechaPago, Proveedor proveedor, String comprobante, GastoConcepto gastoConcepto, double importe, boolean liquidado) {
        Gasto gasto = new Gasto(id, descripcion, fechaRegistro, fechaPago, proveedor, comprobante, gastoConcepto, importe, liquidado);
        comunidadCRUD.getGastos().add(gasto);
    }

    /**
     * Método para dar de baja una instancia de la clase Gasto y eliminarlo de
     * la Comunidad
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la Comunidad
     * @param gasto instancia de la clase Gasto que causara baja y se eliminara
     * de la Comunidad 
        *
     */
    @Override
    public void bajaGasto(ComunidadCRUD comunidadCRUD, Gasto gasto) {
        gasto.bajaGasto(comunidadCRUD, gasto);

    }

    /**
     * Método para actualizar los datos de una instancia de la clase Gasto
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la comunidad
     * @param descripcion descripcion del Gasto
     * @param fechaRegistro fecha en la que se registra el Gasto
     * @param fechaPago fecha en la que se realiza el pago del Gasto
     * @param proveedor Proveedor del Gasto
     * @param comprobante numero de comprobante del Gasto proporcionado por el
     * proveedor
     * @param gastoConcepto concepto/rubro asociado al gasto
     * @param importe importe del Gasto
     * @param liquidado Indica si se ha realizado el cobro del Gasto en las
     * liquidacion o esta pendiente
     * @param gasto instancia de la clase Servicio que actualizara los datos
        *
     */
    @Override
    public void updateGasto(ComunidadCRUD comunidadCRUD, String descripcion, Date fechaRegistro, Date fechaPago, Proveedor proveedor, String comprobante, GastoConcepto gastoConcepto, double importe, boolean liquidado, Gasto gasto) {
        gasto.updateGasto(comunidadCRUD, descripcion, fechaRegistro, fechaPago, proveedor, comprobante, gastoConcepto, importe, liquidado, gasto);
    }

    /**
     * Método que genera una nueva liquidacion entre las fechas indicadas
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la comunidad
     * @param id identificador de la liquidacion
     * @param fechaInicio fecha inicial del periodo a liquidar
     * @param fechaFin fecha final del periodo a liquidar
        *
     */
    @Override
    public void liquidar(ComunidadCRUD comunidadCRUD, int id, LocalDate fechaInicio, LocalDate fechaFin) {
        Liquidacion liquidacion = new Liquidacion(id, fechaInicio, fechaFin);
        liquidacion.generarLiquidacion(fechaInicio, fechaFin, comunidadCRUD, liquidacion);
        comunidadCRUD.getLiquidaciones().add(liquidacion);
    }

    /**
     * Método que muestra la liquidación actual
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la comunidad
     * @param liquidacion objeto liquidación que contiene toda la información
     * referente a la liquidación
     */
    public void imprimirLiquidacion(ComunidadCRUD comunidadCRUD, Liquidacion liquidacion) {
        liquidacion.imprimirLiquidacion(comunidadCRUD, liquidacion);
    }

    /**
     * Método que define un servicio como Fijo y lo asigna a todos los inmuebles
     * de la comunidad
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la comunidad
     * @param servicio instancia de la clase Servicio que se va a definir como
     * fijo
     * @param fechaAlta fecha inicial del disfrute del servicio
        *
     */
    public void asignarServicioFijo(ComunidadCRUD comunidadCRUD, Servicio servicio, Date fechaAlta) {
        servicio.asignarServiciosFijosInmuebles(comunidadCRUD, fechaAlta);
    }

    /**
     * Método que define un servicio como Opcional
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la comunidad
     * @param servicio instancia de la clase Servicio que se va a asignar
     * @param inmueble instancia de la clase Inmueble al que se le asignara el
     * servicio
     * @param fechaAlta fecha inicial del disfrute del servicio
        *
     */
    public void asignarServicioOpcional(ComunidadCRUD comunidadCRUD, Servicio servicio, Inmueble inmueble, Date fechaAlta) {
        servicio.asignarServicioOpcionalInmueble(comunidadCRUD, inmueble, fechaAlta);
    }

    /**
     * Método que permite jerarquizar un gastoConcepto hijo con respecto a un
     * gastoConcepto padre
     *
     * @param gastoConcepto objeto gastoConcepto hijo a jerarquizar con respecto
     * a un objeto gastoConcepto padre
     * @param gastoConceptoCompuestoPadre el objeto gastoConcepto padre
     */
    @Override
    public void jerarquizarConceptos(GastoConcepto gastoConcepto, GastoConceptoCompuesto gastoConceptoCompuestoPadre) {
        gastoConcepto.asignacionConceptos(gastoConceptoCompuestoPadre);
    }

}
