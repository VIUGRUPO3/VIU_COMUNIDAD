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
 *  Interface que permite aunar todos los métodos relacionados con el Administrador bajo una sola clase
 * */
public interface AdminInterface {
    /**
     * Metodo que permite dar de alta un vecino
     * 
     * @param comunidadCRUD objeto que contiene los datos y resto de objetos de la comunidad
     * @param id identificador del vecino 
     * @param nombre nombre del vecino a dar de alta
     * @param clave clave del vecino a dar de alta
     * @param telefono telefono del vecino a dar de alta
     * @param email correo electronico del vecino a dar de alta
     */
    public abstract void altaVecino (ComunidadCRUD comunidadCRUD, int id, String nombre, String clave, String telefono, String email );
    
    /**
     * Metodo que permite dar de baja un vecino
     * 
     * @param comunidadCRUD
     * @param vecino 
     */
    public abstract void bajaVecino (ComunidadCRUD comunidadCRUD, Vecino vecino);
    
    /**
     * Metodo que permite dar de actualizar un vecino
     * 
     * @param comunidadCRUD
     * @param nombre
     * @param clave
     * @param telefono
     * @param email
     * @param vecino 
     */
    public abstract void updateVecino (ComunidadCRUD comunidadCRUD, String nombre, String clave, String telefono, String email, Vecino vecino);
    
    /**
     * Metodo que permite dar de alta un inmueble
     * 
     * @param comunidadCRUD
     * @param id
     * @param vecino
     * @param direccion 
     */
    public abstract void altaInmueble (ComunidadCRUD comunidadCRUD, int id, Vecino vecino, String direccion );
    
    /**
     * Metodo que permite dar de baja un inmueble
     * 
     * @param comunidadCRUD
     * @param inmueble 
     */
    public abstract void bajaInmueble (ComunidadCRUD comunidadCRUD, Inmueble inmueble);
    
    /**
     * Metodo que permite modificar un inmueble
     * 
     * @param comunidadCRUD
     * @param vecino
     * @param direccion
     * @param inmueble 
     */
    public abstract void updateInmueble (ComunidadCRUD comunidadCRUD, Vecino vecino, String direccion, Inmueble inmueble );
    
    /**
     * Metodo que permite dar de alta un servicio
     * 
     * @param comunidadCRUD
     * @param id
     * @param nombre
     * @param tarifa 
     */
    public abstract void altaServicio (ComunidadCRUD comunidadCRUD, int id, String nombre, double tarifa);
    
    /**
     * Metodo que permite dar de baja un servicio
     * 
     * @param comunidadCRUD
     * @param servicio 
     */
    public abstract void bajaServicio (ComunidadCRUD comunidadCRUD, Servicio servicio);
    
    /**
     * Metodo que permite modificar la informacion de un servicio
     * 
     * @param comunidadCRUD
     * @param nombre
     * @param tarifa
     * @param servicio 
     */
    public abstract void updateServicio (ComunidadCRUD comunidadCRUD, String nombre, double tarifa, Servicio servicio);
    
    /**
     * Metodo que permite dar de alta un proveedor
     * 
     * @param comunidadCRUD
     * @param id
     * @param nombre
     * @param direccion
     * @param telefono
     * @param email 
     */
    public abstract void altaProveedor (ComunidadCRUD comunidadCRUD, int id, String nombre, String direccion, String telefono, String email);
    
    /**
     * Metodo que permite dar de baja un proveedor
     * 
     * @param comunidadCRUD
     * @param proveedor 
     */
    public abstract void bajaProveedor (ComunidadCRUD comunidadCRUD, Proveedor proveedor);
    
    /**
     * Metodo que permite modificar la informacion de un proveedor
     * 
     * @param comunidadCRUD
     * @param nombre
     * @param direccion
     * @param telefono
     * @param email
     * @param proveedor 
     */
    public abstract void updateProveedor (ComunidadCRUD comunidadCRUD, String nombre, String direccion, String telefono, String email, Proveedor proveedor);
    
    /**
     * Metodo que permite dar de alta un gasto compuesto
     * 
     * @param comunidadCRUD
     * @param id
     * @param nombre
     * @param servicio 
     */
    public abstract void altaGastoConceptoCompuesto (ComunidadCRUD comunidadCRUD, String id, String nombre, Servicio servicio);
    
    /**
     * Metodo que permite dar de alta un gasto simple
     * 
     * @param comunidadCRUD
     * @param id
     * @param nombre
     * @param servicio 
     */
    public abstract void altaGastoConceptoSimple (ComunidadCRUD comunidadCRUD, String id, String nombre, Servicio servicio);
    
    /**
     * Metodo que permite dar de alta un gasto 
     * 
     * @param comunidadCRUD
     * @param id
     * @param descripcion
     * @param fechaRegistro
     * @param fechaPago
     * @param proveedor
     * @param comprobante
     * @param gastoConcepto
     * @param importe
     * @param liquidado 
     */
    public abstract void altaGasto (ComunidadCRUD comunidadCRUD, int id, String descripcion, LocalDate fechaRegistro, LocalDate fechaPago, Proveedor proveedor, String comprobante, GastoConcepto gastoConcepto, double importe, boolean liquidado);
    
    /**
     * Metodo que permite dar de baja un gasto 
     * 
     * @param comunidadCRUD
     * @param gasto 
     */
    public abstract void bajaGasto(ComunidadCRUD comunidadCRUD, Gasto gasto);
    
    /**
     * Metodo que permite modificar la informacion relacionada con un gasto
     * 
     * @param comunidadCRUD
     * @param descripcion
     * @param fechaRegistro
     * @param fechaPago
     * @param proveedor
     * @param comprobante
     * @param gastoConcepto
     * @param importe
     * @param liquidado
     * @param gasto 
     */
    public abstract void updateGasto(ComunidadCRUD comunidadCRUD, String descripcion, LocalDate fechaRegistro, LocalDate fechaPago, Proveedor proveedor, String comprobante, GastoConcepto gastoConcepto, double importe, boolean liquidado, Gasto gasto);
    
    /**
     * Metodo que permite calcular las liquidaciones de un vecino
     * 
     * @param comunidadCRUD
     * @param id
     * @param fechaInicio
     * @param fechaFin 
     */
    public abstract void liquidar(ComunidadCRUD comunidadCRUD, int id, LocalDate fechaInicio, LocalDate fechaFin);
    
    /**
     * Metodo que permite definir un servicio fijo
     * 
     * @param comunidadCRUD
     * @param servicio
     * @param fechaAlta 
     */
    public abstract void definirServicioFijo(ComunidadCRUD comunidadCRUD, Servicio servicio, LocalDate fechaAlta);
    
    /**
     * Metodo que permite definir un servicio opcional
     * 
     * @param comunidadCRUD
     * @param servicio 
     */
    public abstract void definirServicoOpcional (ComunidadCRUD comunidadCRUD, Servicio servicio);
    
    /**
     * Metodo que permite asignar un servicio opcional
     * 
     * @param comunidadCRUD
     * @param servicio
     * @param inmueble
     * @param fechaAlta 
     */
    public abstract void asignarServicioOpcional (ComunidadCRUD comunidadCRUD, Servicio servicio, Inmueble inmueble, LocalDate fechaAlta);
    
    /** 
     * Metodo que permite jerarquizar gastos
     * 
     * @param gastoConcepto
     * @param gastoConceptoCompuestoPadre 
     */
    public abstract void jerarquizarConceptos(GastoConcepto gastoConcepto, GastoConceptoCompuesto gastoConceptoCompuestoPadre);
    
}
