/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package usuario;

import repositorio.ComunidadCRUD;
import repositorio.Liquidacion;

/**
 *
 * @author fer
 */
public interface VecinoInterface {
    
    public abstract void bajaVecino (ComunidadCRUD comunidadCRUD, Vecino vecinoBorrar);
    public abstract void updateVecino (ComunidadCRUD comunidadCRUD, String nombre, String clave, String telefono, String email, Vecino vecinoModificar);
    public abstract void consultarLiquidacion (ComunidadCRUD comunidadCRUD, Liquidacion liquidacion);
    public abstract void consultarServicioCuentas (ComunidadCRUD comunidadCRUD);
    
}
