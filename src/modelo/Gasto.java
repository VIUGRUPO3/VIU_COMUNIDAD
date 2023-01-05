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

import java.time.LocalDate;
import java.util.Date;

/**
 * Clase que gestiona la clase Gasto
 *
 */
public class Gasto {

    //1.Atributos
    /**
     * Se definen los atributos principales de la clase gasto: id, descripcion,
     * fechaRegistro, fechaPago, proveedor, comprobante, gastoConcepto,
     * liquidado, importe
    *
     */
    private int id;

    /**
     * Descripción del gasto
     */
    private String descripcion;

    /**
     * Fecha de registro del gasto
     */
    private Date fechaRegistro;

    /**
     * Fecha de pago del gasto
     */
    private Date fechaPago;

    /**
     * Proveedor asociado al gasto
     */
    private Proveedor proveedor;

    /**
     * Comprobante del gasto
     */
    private String comprobante;

    /**
     * Concepto del gasto
     */
    private GastoConcepto gastoConcepto;

    /**
     * Booleano que indica si el gasto ha sido liquidado(True) o no(False)
     */
    private boolean liquidado;

    /**
     * Importe del gasto
     */
    private double importe; //Este importe se reparte entre todos vecinos que tengan el servicio

    //2.Constructores
    /**
     * Constructor de la clase Gasto
     */
    public Gasto() {
    }

    /**
     * Constructor de la clase Gasto
     *
     * @param id Identificador unico de gasto
     * @param descripcion descripcion del gasto
     * @param fechaRegistro fecha de registro del gasto
     * @param fechaPago fecha de pago del gasto
     * @param proveedor proveedor asociado al gasto
     * @param comprobante comprobante asociado al gasto
     * @param gastoConcepto concepto asociado al gasto
     * @param importe importe asociado al gasto
     * @param liquidado estado de liquidacion asociado al gasto
     *
     *
     */
    public Gasto(int id, String descripcion, Date fechaRegistro, Date fechaPago, Proveedor proveedor, String comprobante, GastoConcepto gastoConcepto, double importe, boolean liquidado) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
        this.fechaPago = fechaPago;
        this.proveedor = proveedor;
        this.comprobante = comprobante;
        this.gastoConcepto = gastoConcepto;
        this.importe = importe;
        this.liquidado = liquidado;
    }

    public Gasto(String descripcion, Date fechaRegistro, Date fechaPago, Proveedor proveedor, String comprobante, GastoConcepto gastoConcepto, double importe) {
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
        this.fechaPago = fechaPago;
        this.proveedor = proveedor;
        this.comprobante = comprobante;
        this.gastoConcepto = gastoConcepto;
        this.importe = importe;
    }

    public Gasto(int id, String descripcion, Proveedor proveedor, String comprobante, GastoConcepto gastoConcepto, double importe) {
        this.id = id;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
        this.comprobante = comprobante;
        this.gastoConcepto = gastoConcepto;
        this.importe = importe;
    }

    public Gasto(String descripcion, Date fechaRegistro, Proveedor proveedor, String comprobante, GastoConcepto gastoConcepto, double importe) {
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
        this.proveedor = proveedor;
        this.comprobante = comprobante;
        this.gastoConcepto = gastoConcepto;
        this.importe = importe;
    }
    
    

    //3.Métodos
    /**
     * Método getId, para obtener el identificador asociado al gasto
     *
     * @return id identificador de gasto
    *
     */
    public int getId() {
        return id;
    }

    /**
     * Método getProveedor, para obtener el proveedor asociado al gasto
     *
     * @return proveedor proveedor de gasto
    *
     */
    public Proveedor getProveedor() {
        return proveedor;
    }

    /**
     * Método getDescripcion, para obtener la descripcion asociado al gasto
     *
     * @return descripcion descripcion asociada al gasto
    *
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método getComprobante, para obtener el comprobante asociado al gasto
     *
     * @return comprobante el comprobante asociado al gasto
    *
     */
    public String getComprobante() {
        return comprobante;
    }

    /**
     * Método getGastoConcepto, para obtener el gastoConcepto asociado al gasto
     *
     * @return gastoConcepto gastoConcepto asociado al gasto
    *
     */
    public GastoConcepto getGastoConcepto() {
        return gastoConcepto;
    }

    /**
     * Método getFechaRegistro, para obtener la fecha de registro asociado al
     * gasto
     *
     * @return fechaRegistro la fecha de registro asociado al gasto
    *
     */
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Método getFechaPago, para obtener la fecha de pago asociado al gasto
     *
     * @return fechaPago la fecha de pago asociado al gasto
    *
     */
    public Date getFechaPago() {
        return fechaPago;
    }

    /**
     * Método getImporte, para obtener el importe asociado al gasto
     *
     * @return importe importe asociado al gasto
    *
     */
    public double getImporte() {
        return importe;
    }

    /**
     * Método isLiquidado, para comprobar si el gasto está liquidado
     *
     * @return liquidado booleano que contiene el estado de liquidación del
     * gasto
    *
     */
    public boolean isLiquidado() {
        return liquidado;
    }

    /**
     * Método setLiquidado, para establecer el estado de liquidacion del gasto
     *
     * @param liquidado booleano que indica el estado de liquidación del gasto
    *
     */
    public void setLiquidado(boolean liquidado) {
        this.liquidado = liquidado;
    }

    /**
     * Método setGasto, establece la información asociada a un gasto
     *
     * @param descripcion descripcion del gasto
     * @param fechaRegistro fecha de registro del gasto
     * @param fechaPago fecha de pago del gasto
     * @param proveedor proveedor asociado al gasto
     * @param comprobante comprobante asociado al gasto
     * @param gastoConcepto concepto asociado al gasto
     * @param importe importe asociado al gasto
     * @param liquidado estado de liquidacion asociado al gasto
    *
     */
    public void setGasto(String descripcion, Date fechaRegistro, Date fechaPago, Proveedor proveedor, String comprobante, GastoConcepto gastoConcepto, double importe, boolean liquidado) {
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
        this.fechaPago = fechaPago;
        this.proveedor = proveedor;
        this.comprobante = comprobante;
        this.gastoConcepto = gastoConcepto;
        this.importe = importe;
        this.liquidado = liquidado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public void setGastoConcepto(GastoConcepto gastoConcepto) {
        this.gastoConcepto = gastoConcepto;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    
    
    /**
     * Método bajaGasto, da de baja a un gasto
     *
     * @param comunidadCRUD objeto que contiene todos los gastos de la comunidad
     * @param gastoBorrar objeto con el gasto a borrar
    *
     */
    public void bajaGasto(ComunidadCRUD comunidadCRUD, Gasto gastoBorrar) {
        comunidadCRUD.gastos.forEach(gasto -> {
            if (gasto == gastoBorrar) {
                gasto = null;
            }
        });
    }

    /**
     * Método updateGasto, actualiza la información asociada a un gasto
     *
     * @param comunidadCRUD objeto que contiene los gastos de la comunidad
     * @param descripcion descripcion del gasto
     * @param fechaRegistro fecha de registro del gasto
     * @param fechaPago fecha de pago del gasto
     * @param proveedor proveedor asociado al gasto
     * @param comprobante comprobante asociado al gasto
     * @param gastoConcepto concepto asociado al gasto
     * @param importe importe asociado al gasto
     * @param liquidado estado de liquidacion asociado al gasto
     * @param gastoModificar objeto que contiene el gasto a modificar
    *
     */
    public void updateGasto(ComunidadCRUD comunidadCRUD, String descripcion, Date fechaRegistro, Date fechaPago, Proveedor proveedor, String comprobante, GastoConcepto gastoConcepto, double importe, boolean liquidado, Gasto gastoModificar) {
        comunidadCRUD.gastos.forEach(gasto -> {
            if (gasto == gastoModificar) {
                gasto.setGasto(descripcion, fechaRegistro, fechaPago, proveedor, comprobante, gastoConcepto, importe, liquidado);
            }
        });
    }

    /**
     * Método toString que muestra los datos correspondientes a un gasto
     *
     *
     */
    @Override
    public String toString() {
        return "--------Gasto" + id + descripcion + "--------\n fechaRegistro - " + fechaRegistro + "\n fechaPago    - " + fechaPago + "\n comprobante  - " + comprobante + "\n concepto    - " + gastoConcepto + "\n liquidado    - " + liquidado + "\n" + proveedor + "\n--------TOTAL--------\n    " + importe + "Euros \n\n";
    }

}
