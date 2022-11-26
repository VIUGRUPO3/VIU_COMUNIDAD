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



//Clase encargada de realizar todas las operaciones con los usuarios vecinos, implementa la interfaz UserInterfaceOps
public class Admin extends Usuario{

    
    // Atributos 
    
        /** Todos los atributos son heredados de la clase Usuario **/
    
    // Constructores 

    public Admin() {}
    
    /**
    * @param id Identificador unico de Admin
    * @param nombre Nombre comun completo Admin
    * @param clave Clave / Contraseña de acceso del Admin
    * @param telefono Telefono asociado a Admin
    * @param email Email asociado a Admin
    **/
    public Admin(int id, String nombre, String clave, String telefono, String email) {
        super(id, nombre, clave, telefono, email);
    }
 
    
// Metodos
    
    // Funcionalidad
        
        /** Metodo para crear una instancia de la clase Vecino y añadirlo a la Comunidad 
        * 
        * @param comunidadCRUD objeto comunidad que contiene toda la información de la Comunidad
        * @param id identificador unico del objeto Vecino
        * @param nombre nombre propio del objeto Vecino
        * @param clave clave de acceso a la aplicacion para este Vecino
        * @param telefono telefono de contacto del Vecino
        * @param email email de contacto del Vecino
        **/    
        public void altaVecino (ComunidadCRUD comunidadCRUD, int id, String nombre, String clave, String telefono, String email ){
            Vecino vecino = new Vecino(id, nombre, clave, telefono, email);
            comunidadCRUD.vecinos.add(vecino);
        }

        /** Metodo para eliminar un Vecino de la Comunidad quedando sus inmuebles a cargo de la Comunidad
        * 
        * @param comunidadCRUD objeto comunidad que contiene toda la información de la Comunidad
        * @param vecino instancia de la clase Vecino que se va a eliminar
        **/    
        public void bajaVecino (ComunidadCRUD comunidadCRUD, Vecino vecino){
            vecino.bajaVecino(comunidadCRUD, vecino);
        }

        /** Metodo para actualizar los datos de una instancia de la clase Vecino 
        * 
        * @param comunidadCRUD objeto comunidad que contiene toda la información de la Comunidad
        * @param nombre nombre propio del objeto Vecino
        * @param clave clave de acceso a la aplicacion para este Vecino
        * @param telefono telefono de contacto del Vecino
        * @param email email de contacto del Vecino
        * @param vecino instancia de la clase Vecino de la cual se va a actualizar la informacion
        **/  
        public void updateVecino (ComunidadCRUD comunidadCRUD, String nombre, String clave, String telefono, String email, Vecino vecino){
            vecino.updateVecino(comunidadCRUD, nombre, clave, telefono, email, vecino);
        }

        /** Metodo para dar de alta una instancia de la clase Inmueble y añadirlo a la Comunidad 
        * 
        * @param comunidadCRUD objeto comunidad que contiene toda la información de la Comunidad
        * @param id identificador de la instancia de la clase Inmueble
        * @param vecino instancia de la clase Vecino propietario del Inmueble
        * @param direccion direccion completa del Inmueble
        **/  
        public void altaInmueble (ComunidadCRUD comunidadCRUD, int id, Vecino vecino, String direccion ){
            Inmueble inmueble = new Inmueble (id, vecino, direccion);
            comunidadCRUD.inmuebles.add(inmueble);
        }

        /** Metodo para dar de baja una instancia de la clase Inmueble y eliminarlo de la comunidad 
        * 
        * @param comunidadCRUD objeto comunidad que contiene toda la información de la comunidad
        * @param inmueble instancia de la clase Inmueble que causara baja y se eliminara de la comunidad
        **/
        public void bajaInmueble (ComunidadCRUD comunidadCRUD, Inmueble inmueble){
            inmueble.bajaInmueble(comunidadCRUD, inmueble);
        }
        
        /** Metodo para actualizar los datos de una instancia de la clase Inmueble  
        * 
        * @param comunidadCRUD objeto comunidad que contiene toda la información de la comunidad
        * @param vecino instancia de la clase vecino propietaria del Inmueble
        * @param direccion direccion completa del inmueble
        * @param inmueble instancia de la clase Inmueble que actualizara los datos
        **/
        public void updateInmueble (ComunidadCRUD comunidadCRUD, Vecino vecino, String direccion, Inmueble inmueble ){
            inmueble.updateInmueble(comunidadCRUD, vecino, direccion, inmueble);
        }

        /** Metodo para dar de alta una instancia de la clase Servicio y añadirlo a la Comunidad  
        * 
        * @param comunidadCRUD objeto comunidad que contiene toda la información de la Comunidad
        * @param id identificador de la instancia Servicio
        * @param nombre nombre descriptivo del Servicio
        * @param tarifa tarifa que se cobrara a los que utilicen el Servicio
        **/
        public void altaServicio (ComunidadCRUD comunidadCRUD, int id, String nombre, double tarifa){
            Servicio servicio = new Servicio (id, nombre, tarifa);
            comunidadCRUD.servicios.add(servicio);
        }

        /** Metodo para dar de baja una instancia de la clase Servicio y eliminarlo de la Comunidad  
        * 
        * @param comunidadCRUD objeto comunidad que contiene toda la información de la Comunidad
        * @param servicio instancia de la clase Servicio que causara baja y se eliminara de la Comunidad 
        **/
        public void bajaServicio (ComunidadCRUD comunidadCRUD, Servicio servicio){
            servicio.bajaServicio(comunidadCRUD, servicio);
        }

        /** Metodo para actualizar los datos de una instancia de la clase Servicio  
        * 
        * @param comunidadCRUD objeto comunidad que contiene toda la información de la comunidad
        * @param nombre nombre descriptivo del Servicio
        * @param tarifa tarifa que se cobrara a los que utilicen el Servicio
        * @param servicio instancia de la clase Servicio que actualizara los datos
        **/
        public void updateServicio (ComunidadCRUD comunidadCRUD, String nombre, double tarifa, Servicio servicio){
            servicio.updateServicio(comunidadCRUD, nombre, tarifa, servicio);
        }

        /** Metodo para dar de alta una instancia de la clase Proveedor y añadirlo a la Comunidad  
        * 
        * @param comunidadCRUD objeto comunidad que contiene toda la información de la Comunidad
        * @param id identificador de la instancia Proveedor
        * @param nombre nombre del Proveedor
        * @param direccion tarifa que se cobrara a los que utilicen el Servicio
        * @param telefono telefono de contacto del Proveedor
        * @param email email de contacto del Proveedor
        **/
        public void altaProveedor (ComunidadCRUD comunidadCRUD, int id, String nombre, String direccion, String telefono, String email){
            Proveedor proveedor = new Proveedor(id, nombre, direccion, telefono, email);
            comunidadCRUD.proveedores.add(proveedor);
        }

        /** Metodo para dar de baja una instancia de la clase Proveedor y eliminarlo de la Comunidad  
        * 
        * @param comunidadCRUD objeto comunidad que contiene toda la información de la Comunidad
        * @param proveedor instancia de la clase Proveedor que causara baja y se eliminara de la Comunidad 
        **/
        public void bajaProveedor (ComunidadCRUD comunidadCRUD, Proveedor proveedor){
            proveedor.bajaProveedor(comunidadCRUD, proveedor);
        }

        /** Metodo para actualizar los datos de una instancia de la clase Proveedor  
        * 
        * @param comunidadCRUD objeto comunidad que contiene toda la información de la comunidad
        * @param nombre nombre del Proveedor
        * @param direccion direccion de contacto del Proveedor
        * @param telefono telefono de contacto del Proveedor
        * @param email email de contacto del Proveedor
        * @param proveedor instancia de la clase Servicio que actualizara los datos
        **/
        public void updateProveedor (ComunidadCRUD comunidadCRUD, String nombre, String direccion, String telefono, String email, Proveedor proveedor){
            proveedor.updateProveedor(comunidadCRUD, nombre, direccion, telefono, email, proveedor);
        }

        /** Metodo para dar de alta una instancia de la clase GastoConceptoCompuesto y añadirlo a la Comunidad, un concepto de gasto asociara un gasto a un servicio para su inclusion en las liquidaciones pertinentes 
        * 
        * @param comunidadCRUD objeto comunidad que contiene toda la información de la Comunidad
        * @param id identificador de la instancia Concepto de Gasto
        * @param nombre nombre del Concepto de Gasto
        * @param servicio Servicio al que esta asociado el Concepto de Gasto compuesto
        **/
        public void altaGastoConceptoCompuesto (ComunidadCRUD comunidadCRUD, String id, String nombre, Servicio servicio){
            GastoConceptoCompuesto gastoConceptoCompuesto = new GastoConceptoCompuesto(id, nombre, servicio);
            comunidadCRUD.gastosConcepto.add(gastoConceptoCompuesto);
        }

        /** Metodo para dar de alta una instancia de la clase GastoConceptoSimple y añadirlo a la Comunidad, un concepto de gasto asociara un gasto a un servicio para su inclusion en las liquidaciones pertinentes 
        * 
        * @param comunidadCRUD objeto comunidad que contiene toda la información de la Comunidad
        * @param id identificador de la instancia Concepto de Gasto
        * @param nombre nombre del Concepto de Gasto
        * @param servicio Servicio al que esta asociado el Concepto de Gasto compuesto
        **/
        public void altaGastoConceptoSimple (ComunidadCRUD comunidadCRUD, String id, String nombre, Servicio servicio){
            GastoConceptoSimple gastoConceptoSimple = new GastoConceptoSimple(id, nombre, servicio);
            comunidadCRUD.gastosConcepto.add(gastoConceptoSimple);
        }

        /** Metodo para dar de alta una instancia de la clase Gasto y añadirlo a la Comunidad  
        * 
        * @param comunidadCRUD objeto comunidad que contiene toda la información de la Comunidad
        * @param id identificador de la instancia Gasto
        * @param descripcion descripcion del Gasto
        * @param fechaRegistro fecha en la que se registra el Gasto
        * @param fechaPago fecha en la que se realiza el pago del Gasto
        * @param proveedor Proveedor del Gasto
        * @param comprobante numero de comprobante del Gasto proporcionado por el proveedor
        * @param gastoConcepto concepto/rubro asociado al gasto
        * @param importe importe del Gasto
        * @param liquidado Indica si se ha realizado el cobro del Gasto en las liquidacion o esta pendiente 
        **/
        public void altaGasto (ComunidadCRUD comunidadCRUD, int id, String descripcion, LocalDate fechaRegistro, LocalDate fechaPago, Proveedor proveedor, String comprobante, GastoConcepto gastoConcepto, double importe, boolean liquidado){
            Gasto gasto = new Gasto(id, descripcion, fechaRegistro, fechaPago, proveedor, comprobante, gastoConcepto, importe, liquidado);
            comunidadCRUD.gastos.add(gasto);
        }

        /** Metodo para dar de baja una instancia de la clase Gasto y eliminarlo de la Comunidad  
        * 
        * @param comunidadCRUD objeto comunidad que contiene toda la información de la Comunidad
        * @param gasto instancia de la clase Gasto que causara baja y se eliminara de la Comunidad 
        **/
        public void bajaGasto(ComunidadCRUD comunidadCRUD, Gasto gasto){
            gasto.bajaGasto(comunidadCRUD, gasto);

        }

        /** Metodo para actualizar los datos de una instancia de la clase Gasto  
        * 
        * @param comunidadCRUD objeto comunidad que contiene toda la información de la comunidad
        * @param descripcion descripcion del Gasto
        * @param fechaRegistro fecha en la que se registra el Gasto
        * @param fechaPago fecha en la que se realiza el pago del Gasto
        * @param proveedor Proveedor del Gasto
        * @param comprobante numero de comprobante del Gasto proporcionado por el proveedor
        * @param gastoConcepto concepto/rubro asociado al gasto
        * @param importe importe del Gasto
        * @param liquidado Indica si se ha realizado el cobro del Gasto en las liquidacion o esta pendiente 
        * @param gasto instancia de la clase Servicio que actualizara los datos
        **/
        public void updateGasto(ComunidadCRUD comunidadCRUD, String descripcion, LocalDate fechaRegistro, LocalDate fechaPago, Proveedor proveedor, String comprobante, GastoConcepto gastoConcepto, double importe, boolean liquidado, Gasto gasto){
            gasto.updateGasto(comunidadCRUD, descripcion, fechaRegistro, fechaPago, proveedor, comprobante, gastoConcepto, importe, liquidado, gasto);
        }

        /** Metodo que genera una nueva liquidacion entre las fechas indicadas  
        * 
        * @param comunidadCRUD objeto comunidad que contiene toda la información de la comunidad
        * @param id identificador de la liquidacion
        * @param fechaInicio fecha inicial del periodo a liquidar
        * @param fechaFin fecha final del periodo a liquidar
        **/
        public void liquidar(ComunidadCRUD comunidadCRUD, int id, LocalDate fechaInicio, LocalDate fechaFin){
            Liquidacion liquidacion = new Liquidacion(id, fechaInicio, fechaFin);
            liquidacion.generarLiquidacion(fechaInicio, fechaFin, comunidadCRUD, liquidacion);
        }

        /** Metodo que define un servicio como Fijo y lo asigna a todos los inmuebles de la comunidad  
        * 
        * @param comunidadCRUD objeto comunidad que contiene toda la información de la comunidad
        * @param servicio instancia de la clase Servicio que se va a definir como fijo
        * @param fechaAlta fecha inicial del disfrute del servicio
        **/
        public void definirServicioFijo(ComunidadCRUD comunidadCRUD, Servicio servicio, LocalDate fechaAlta){
            servicio.definirFijo(comunidadCRUD);
            comunidadCRUD.getServicioTipos().asignarServiciosFijosInmuebles(comunidadCRUD, servicio, fechaAlta);
        }

        /** Metodo que define un servicio como Opcional 
        * 
        * @param comunidadCRUD objeto comunidad que contiene toda la información de la comunidad
        * @param servicio instancia de la clase Servicio que de va a definir como fijo
        **/
        public void definirServicoOpcional (ComunidadCRUD comunidadCRUD, Servicio servicio){
            servicio.definirOpcional(comunidadCRUD);
        }

        /** Metodo que define un servicio como Opcional 
        * 
        * @param comunidadCRUD objeto comunidad que contiene toda la información de la comunidad
        * @param servicio instancia de la clase Servicio que se va a asignar
        * @param inmueble instancia de la clase Inmueble al que se le asignara el servicio
        * @param fechaAlta fecha inicial del disfrute del servicio
        **/
        public void asignarServicioOpcional (ComunidadCRUD comunidadCRUD, Servicio servicio, Inmueble inmueble, LocalDate fechaAlta){
            comunidadCRUD.getServicioTipos().asignarServiciosOpcionalInmuebles(comunidadCRUD, servicio, inmueble, LocalDate.parse("2022-11-01"));
        }
                  

}
