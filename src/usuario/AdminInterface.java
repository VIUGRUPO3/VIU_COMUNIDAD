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
 *
 */
public interface AdminInterface {
    
    public abstract void altaVecino (ComunidadCRUD comunidadCRUD, int id, String nombre, String clave, String telefono, String email );
    public abstract void bajaVecino (ComunidadCRUD comunidadCRUD, Vecino vecino);
    public abstract void updateVecino (ComunidadCRUD comunidadCRUD, String nombre, String clave, String telefono, String email, Vecino vecino);
    
    public abstract void altaInmueble (ComunidadCRUD comunidadCRUD, int id, Vecino vecino, String direccion );
    public abstract void bajaInmueble (ComunidadCRUD comunidadCRUD, Inmueble inmueble);
    public abstract void updateInmueble (ComunidadCRUD comunidadCRUD, Vecino vecino, String direccion, Inmueble inmueble );
    
    public abstract void altaServicio (ComunidadCRUD comunidadCRUD, int id, String nombre, double tarifa);
    public abstract void bajaServicio (ComunidadCRUD comunidadCRUD, Servicio servicio);
    public abstract void updateServicio (ComunidadCRUD comunidadCRUD, String nombre, double tarifa, Servicio servicio);
    
    public abstract void altaProveedor (ComunidadCRUD comunidadCRUD, int id, String nombre, String direccion, String telefono, String email);
    public abstract void bajaProveedor (ComunidadCRUD comunidadCRUD, Proveedor proveedor);
    public abstract void updateProveedor (ComunidadCRUD comunidadCRUD, String nombre, String direccion, String telefono, String email, Proveedor proveedor);
    
    public abstract void altaGastoConceptoCompuesto (ComunidadCRUD comunidadCRUD, String id, String nombre, Servicio servicio);
    public abstract void altaGastoConceptoSimple (ComunidadCRUD comunidadCRUD, String id, String nombre, Servicio servicio);
    
    public abstract void altaGasto (ComunidadCRUD comunidadCRUD, int id, String descripcion, LocalDate fechaRegistro, LocalDate fechaPago, Proveedor proveedor, String comprobante, GastoConcepto gastoConcepto, double importe, boolean liquidado);
    public abstract void bajaGasto(ComunidadCRUD comunidadCRUD, Gasto gasto);
    public abstract void updateGasto(ComunidadCRUD comunidadCRUD, String descripcion, LocalDate fechaRegistro, LocalDate fechaPago, Proveedor proveedor, String comprobante, GastoConcepto gastoConcepto, double importe, boolean liquidado, Gasto gasto);
    
    public abstract void liquidar(ComunidadCRUD comunidadCRUD, int id, LocalDate fechaInicio, LocalDate fechaFin);
    
    public abstract void definirServicioFijo(ComunidadCRUD comunidadCRUD, Servicio servicio, LocalDate fechaAlta);
    
    public abstract void definirServicoOpcional (ComunidadCRUD comunidadCRUD, Servicio servicio);
    
    public abstract void asignarServicioOpcional (ComunidadCRUD comunidadCRUD, Servicio servicio, Inmueble inmueble, LocalDate fechaAlta);
    
    public abstract void jerarquizarConceptos(GastoConcepto gastoConcepto, GastoConceptoCompuesto gastoConceptoCompuestoPadre);
    
}
