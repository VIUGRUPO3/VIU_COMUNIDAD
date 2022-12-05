// Asignatura: 21GIIN Proyectos Programación
// Profesor: Eduardo Zamudio
// @author: Grupo 3
// Miembros:
//       @author:Fernando Hernandez Fernandez
//       @author:Javier Barbero Sales
//       @author:Martin Gonzalez Dominguez
// @version: 01/12/2022/
// Paquete
package usuario;

import java.time.LocalDate;
import repositorio.ComunidadCRUD;
import repositorio.Gasto;
import repositorio.GastoConcepto;
import repositorio.GastoConceptoCompuesto;
import repositorio.Inmueble;
import repositorio.Proveedor;
import repositorio.Servicio;

/**
 * Interface que permite aunar todos los métodos relacionados con el
 * Administrador bajo una sola clase
 *
 */
public interface AdminInterface {

    /**
     * Método que permite dar de alta un vecino
     *
     * @param comunidadCRUD objeto que contiene los datos y resto de objetos de
     * la comunidad
     * @param id identificador del vecino
     * @param nombre nombre del vecino a dar de alta
     * @param clave clave del vecino a dar de alta
     * @param telefono telefono del vecino a dar de alta
     * @param email correo electronico del vecino a dar de alta
     */
    public abstract void altaVecino(ComunidadCRUD comunidadCRUD, int id, String nombre, String clave, String telefono, String email);

    /**
     * Método que permite dar de baja un vecino
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la Comunidad
     * @param vecino objeto vecino con los detalles del vecino
     */
    public abstract void bajaVecino(ComunidadCRUD comunidadCRUD, Vecino vecino);

    /**
     * Método que permite dar de actualizar un vecino
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la Comunidad
     * @param nombre nombre del vecino a dar de alta
     * @param clave clave del vecino a dar de alta
     * @param telefono telefono del vecino a dar de alta
     * @param email correo electronico del vecino a dar de alta
     * @param vecino objeto vecino a actualizar
     */
    public abstract void updateVecino(ComunidadCRUD comunidadCRUD, String nombre, String clave, String telefono, String email, Vecino vecino);

    /**
     * Método que permite dar de alta un inmueble
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la Comunidad
     * @param id identificador del vecino
     * @param vecino objeto vecino que contiene toda la información del vecino
     * @param direccion direccion del inmueble
     */
    public abstract void altaInmueble(ComunidadCRUD comunidadCRUD, int id, Vecino vecino, String direccion);

    /**
     * Método que permite dar de baja un inmueble
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la Comunidad
     * @param inmueble objeto inmueble que contiene toda la informacion del
     * inmueble
     */
    public abstract void bajaInmueble(ComunidadCRUD comunidadCRUD, Inmueble inmueble);

    /**
     * Método que permite modificar un inmueble
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la Comunidad
     * @param vecino objeto vecino que contiene toda la informacion del vecino
     * @param direccion direccion del inmueble
     * @param inmueble objeto inmueble que contiene toda la informacion del
     * inmueble
     */
    public abstract void updateInmueble(ComunidadCRUD comunidadCRUD, Vecino vecino, String direccion, Inmueble inmueble);

    /**
     * Método que permite dar de alta un servicio
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la Comunidad
     * @param id identificador de servicio
     * @param nombre nombre del servicio
     * @param tarifa tarifa del servicio
     * @param opcional tipo de servicio
     */
    public abstract void altaServicio(ComunidadCRUD comunidadCRUD, int id, String nombre, double tarifa, boolean opcional);

    /**
     * Método que permite dar de baja un servicio
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la Comunidad
     * @param servicio objeto servicio que contiene toda la informacion del
     * servicio
     */
    public abstract void bajaServicio(ComunidadCRUD comunidadCRUD, Servicio servicio);

    /**
     * Método que permite modificar la informacion de un servicio
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la Comunidad
     * @param nombre nombre del servicio
     * @param tarifa tarifa del servicio
     * @param opcional tipo de servicio
     * @param servicio objeto servicio que contiene toda la informacion del
     * servicio
     */
    public abstract void updateServicio(ComunidadCRUD comunidadCRUD, String nombre, double tarifa, boolean opcional, Servicio servicio);

    /**
     * Método que permite dar de alta un proveedor
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la Comunidad
     * @param id identificador del proveedor
     * @param nombre nombre del proveedor
     * @param direccion direccion del proveedor
     * @param telefono telefono del proveedor
     * @param email correo electronico del proveedor
     */
    public abstract void altaProveedor(ComunidadCRUD comunidadCRUD, int id, String nombre, String direccion, String telefono, String email);

    /**
     * Método que permite dar de baja un proveedor
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la Comunidad
     * @param proveedor objeto proveedor que contiene toda la informacion del
     * proveedor
     */
    public abstract void bajaProveedor(ComunidadCRUD comunidadCRUD, Proveedor proveedor);

    /**
     * Método que permite modificar la informacion de un proveedor
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la Comunidad
     * @param nombre nombre del proveedor
     * @param direccion direccion del proveedor
     * @param telefono telefono del proveedor
     * @param email correo electronico del proveedor
     * @param proveedor objeto proveedor que contiene toda la informacion del
     * proveedor
     */
    public abstract void updateProveedor(ComunidadCRUD comunidadCRUD, String nombre, String direccion, String telefono, String email, Proveedor proveedor);

    /**
     * Método que permite dar de alta un gasto compuesto
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la Comunidad
     * @param id identificador del gasto compuesto
     * @param nombre nombre del gasto compuesto
     * @param servicio objeto servicio que contiene toda la informacion del
     * servicio
     */
    public abstract void altaGastoConceptoCompuesto(ComunidadCRUD comunidadCRUD, String id, String nombre, Servicio servicio);

    /**
     * Método que permite dar de alta un gasto simple
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la Comunidad
     * @param id identificador del gasto simple
     * @param nombre nombre del gasto simple
     * @param servicio objeto servicio que contiene toda la informacion del
     * servicio
     */
    public abstract void altaGastoConceptoSimple(ComunidadCRUD comunidadCRUD, String id, String nombre, Servicio servicio);

    /**
     * Método que permite dar de alta un gasto
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la Comunidad
     * @param id identificador de gasto
     * @param descripcion descripcion de gasto
     * @param fechaRegistro fecha de registro del gasto
     * @param fechaPago fecha de pago del gasto
     * @param proveedor objeto proveedor que contiene toda la informacion del
     * proveedor
     * @param comprobante comprobante del gasto
     * @param gastoConcepto objeto gastoConcepto que contiene toda la
     * informacion del concepto de gasto
     * @param importe importe del gasto
     * @param liquidado booleano que indica si el gasto ya ha sido liquidado
     */
    public abstract void altaGasto(ComunidadCRUD comunidadCRUD, int id, String descripcion, LocalDate fechaRegistro, LocalDate fechaPago, Proveedor proveedor, String comprobante, GastoConcepto gastoConcepto, double importe, boolean liquidado);

    /**
     * Método que permite dar de baja un gasto
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la Comunidad
     * @param gasto objeto gasto que contiene toda la informacion del gasto
     */
    public abstract void bajaGasto(ComunidadCRUD comunidadCRUD, Gasto gasto);

    /**
     * Método que permite modificar la informacion relacionada con un gasto
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la Comunidad
     * @param descripcion descripcion del gasto
     * @param fechaRegistro fecha de registro del gasto
     * @param fechaPago fecha de pago del gasto
     * @param proveedor objeto proveedor que contiene toda la informacion del
     * proveedor
     * @param comprobante comprobante del gasto
     * @param gastoConcepto objeto gastoConcepto que contiene toda la
     * informacion del concepto de gasto
     * @param importe importe del gasto
     * @param liquidado booleano que indica si el gasto ya ha sido liquidado
     * @param gasto objeto gasto que contiene toda la informacion del gasto
     */
    public abstract void updateGasto(ComunidadCRUD comunidadCRUD, String descripcion, LocalDate fechaRegistro, LocalDate fechaPago, Proveedor proveedor, String comprobante, GastoConcepto gastoConcepto, double importe, boolean liquidado, Gasto gasto);

    /**
     * Método que permite calcular las liquidaciones de un vecino
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la Comunidad
     * @param id identificador de vecino
     * @param fechaInicio fecha de inicio del periodo de gastos a liquidar
     * @param fechaFin fecha de fin del periodo de gastos a liquidar
     */
    public abstract void liquidar(ComunidadCRUD comunidadCRUD, int id, LocalDate fechaInicio, LocalDate fechaFin);

    /**
     * Método que permite definir un servicio fijo
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la Comunidad
     * @param servicio objeto servicio que contiene toda la información del
     * servicio
     * @param fechaAlta fecha de alta del servicio fijo
     */
    public abstract void asignarServicioFijo(ComunidadCRUD comunidadCRUD, Servicio servicio, LocalDate fechaAlta);

    /**
     * Método que permite asignar un servicio opcional
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la Comunidad
     * @param servicio objeto servicio que contiene toda la información del
     * servicio
     * @param inmueble objeto inmueble que contiene toda la información del
     * inmueble
     * @param fechaAlta fecha de alta del servicio opcional
     */
    public abstract void asignarServicioOpcional(ComunidadCRUD comunidadCRUD, Servicio servicio, Inmueble inmueble, LocalDate fechaAlta);

    /**
     * Método que permite jerarquizar gastos
     *
     * @param gastoConcepto objeto gastoConcepto que contiene toda la
     * información del gasto
     * @param gastoConceptoCompuestoPadre objeto gastoCompuestoPadre al que se
     * le va a asignar como hijo el objeto gastoConcepto
     */
    public abstract void jerarquizarConceptos(GastoConcepto gastoConcepto, GastoConceptoCompuesto gastoConceptoCompuestoPadre);

}
