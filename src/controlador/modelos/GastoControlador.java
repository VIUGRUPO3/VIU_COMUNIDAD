// Asignatura: 21GIIN Proyectos Programación
// Profesor: Eduardo Zamudio
// @author: Grupo 3
// Miembros:
//       @author:Fernando Hernandez Fernandez
//       @author:Javier Barbero Sales
//       @author:Martin Gonzalez Dominguez
// @version: 08/01/2023/package controlador;
package controlador.modelos;

import dao.ServicioGastos;
import dao.ServicioGastosConcepto;
import dao.ServicioProveedores;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Gasto;
import modelo.GastoConcepto;
import modelo.Proveedor;

/**
 * Clase GastoConceptoControlador
 */
public class GastoControlador {

//Atributos
    /**
     * Atributo que definie el ServicioGastosConcepto
     */
    private ServicioGastosConcepto sgc = new ServicioGastosConcepto();

    /**
     * Atributo que definie el ServicioProveedores
     */
    private ServicioProveedores sp = new ServicioProveedores();

    /**
     * Atributo que definie el ServicioGastos
     */
    private ServicioGastos sg = new ServicioGastos();

    /**
     * Atributo que definie el Controlador de Proveedores
     */
    private ProveedorControlador pc = new ProveedorControlador();

    /**
     * Atributo que definie el Controlador de Proveedores
     */
    private GastoConceptoControlador gcc = new GastoConceptoControlador();

    //Constructores
    /**
     * Constructor de Clase
     */
    public GastoControlador() {
    }

    //Metodos

    /**
     * Método para registrar un nuevo gasto
     * @param txtDescripcionEG campo de texto con la descripción del gasto
     * @param tblProveedoresEG tabla proveedores, donde se ha seleccionado el proveedor correspondiente
     * @param txtComprobanteEG campo de texto donde se indica el comprobante del gasto
     * @param tblConceptosEG tabla donde se ha seleccionado el concepto de gasto
     * @param txtImporteEG importe
     * @param tblGastosGG tabla de gastos donde se va a introducir el nuevo gasto
     */
    public void registrarGasto(JTextField txtDescripcionEG, JTable tblProveedoresEG, JTextField txtComprobanteEG, JTable tblConceptosEG, JTextField txtImporteEG, JTable tblGastosGG) {
        if (tblProveedoresEG.getSelectedRowCount() > 0 && tblConceptosEG.getSelectedRowCount() > 0) {
            Proveedor p = sp.buscarId((int) tblProveedoresEG.getValueAt(tblProveedoresEG.getSelectedRow(), 0));
            GastoConcepto gc = sgc.buscarId((int) tblConceptosEG.getValueAt(tblConceptosEG.getSelectedRow(), 0));
            Date today = new Date();

            Gasto g = new Gasto(
                    txtDescripcionEG.getText(),
                    today,
                    p,
                    txtComprobanteEG.getText(),
                    gc,
                    Double.parseDouble(txtImporteEG.getText())
            );
            sg.insertarGastoDB(g);
        }
        cargarTablaGastos("", tblGastosGG);
    }

    /**
     * Método que permite la actualización de un gasto previo
     * @param txtIdEG campo de texto con el ID del gasto
     * @param txtDescripcionEG Descripción del gasto
     * @param tblProveedoresEG tabla de proveedores
     * @param txtComprobanteEG campo de texto que indica el comprobante
     * @param tblConceptosEG tabla de conceptos donde se ha indicado el concepto del gasto
     * @param txtImporteEG importe del gasto
     * @param tblGastosGG tabla donde está el gasto a actualizar
     */
    public void updateGasto(JTextField txtIdEG, JTextField txtDescripcionEG, JTable tblProveedoresEG, JTextField txtComprobanteEG, JTable tblConceptosEG, JTextField txtImporteEG, JTable tblGastosGG) {
        int id = Integer.parseInt(txtIdEG.getText());
        Proveedor p = sp.buscarId((int) tblProveedoresEG.getValueAt(tblProveedoresEG.getSelectedRow(), 0));
        GastoConcepto gc = sgc.buscarId((int) tblConceptosEG.getValueAt(tblConceptosEG.getSelectedRow(), 0));
        Gasto g = new Gasto(
                id,
                txtDescripcionEG.getText(),
                p,
                txtComprobanteEG.getText(),
                gc,
                Double.parseDouble(txtImporteEG.getText())
        );
        sg.updateGasto(g);
        cargarTablaGastos("", tblGastosGG);
    }

    /**
     * Método que elimina el GastoConcepto seleccionado de la tabla de
     * GastoConceptos
     *
     * @param tabla tabla GastoConcepto
     */
    public void eliminarGasto(JTable tabla) {
        int[] lista = tabla.getSelectedRows();
        if (lista.length != 0) {
            for (int row : lista) {
                int id = obtenerIdTabla(row, tabla);
                Gasto g = sg.buscarId(id);
                sg.borrarGasto(g);
            }
        }
        cargarTablaGastos("", tabla);
    }

    /**
     * Método que carga el gasto seleccionado para su edición
     * @param txtIdEG ID del gasto seleccionado
     * @param txtDescripcionEG Descripción del gasto
     * @param txtFRegEG Fecha de registro del gasto
     * @param txtFPagoEG Fecha de pago del gasto
     * @param tblProveedoresEG tabla de Proveedores
     * @param txtComprobanteEG campo de texto del comprobante
     * @param tblConceptosEG tabla de conceptos, donde aparece seleccionado el concepto del gasto
     * @param txtImporteEG importe del gasto
     * @param txtEstadoEG estado del gasto
     * @param tblGastosGG tabla que contiene los gastos
     */
    public void cargarGastoEdicion(
            JTextField txtIdEG,
            JTextField txtDescripcionEG,
            JTextField txtFRegEG,
            JTextField txtFPagoEG,
            JTable tblProveedoresEG,
            JTextField txtComprobanteEG,
            JTable tblConceptosEG,
            JTextField txtImporteEG,
            JTextField txtEstadoEG,
            JTable tblGastosGG) {
        String estado;
        int row = tblGastosGG.getSelectedRow();
        Gasto g = sg.buscarId(obtenerIdTabla(row, tblGastosGG));
        Proveedor p = g.getProveedor();
        GastoConcepto gc = g.getGastoConcepto();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String fechaRegistro = dateFormat.format(g.getFechaRegistro());
        
        if (g.isLiquidado() == true) {
            estado = "LIQUIDADO";
        } else {
            estado = "PENDIENTE";
        }
        txtIdEG.setText(Integer.toString(g.getId()));
        txtDescripcionEG.setText(g.getDescripcion());
        txtFRegEG.setText(fechaRegistro);
        
        txtComprobanteEG.setText(g.getComprobante());
        txtImporteEG.setText(Double.toString(g.getImporte()));
        txtEstadoEG.setText(estado);
        pc.cargarTablaProveedorEdicion(p, tblProveedoresEG);
        gcc.cargarTablaConceptosEdicion(gc, tblConceptosEG);
    }

    /**
     * Método que obtiene el id de la fila de GastoConcepto seleccionada
     *
     * @param row fila seleccionada
     * @param tabla tabla donde se ha seleccionado la fila
     * @return id devuelve el ID del GastoConcepto seleccionado
     */
    public int obtenerIdTabla(int row, JTable tabla) {
        int id = (int) tabla.getValueAt(row, 0);
        return id;
    }

    /**
     * Método que carga la lista de ConceptoGastoConceptos en la tabla
     * especificada
     *
     * @param nombre Nombre del GastoConcepto a buscar
     * @param tabla Tabla donde va a ser cargado el GastoConcepto
     */
    public void cargarTablaGastos(String nombre, JTable tabla) {
        String estado;
        List<Gasto> lista = sg.buscarGasto(nombre);
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setNumRows(0);
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).isLiquidado() == true) {
                estado = "LIQUIDADO";
            } else {
                estado = "PENDIENTE";
            }
            model.addRow(new Object[]{
                lista.get(i).getId(),
                lista.get(i).getDescripcion(),
                lista.get(i).getFechaRegistro(),
                lista.get(i).getFechaPago(),
                lista.get(i).getProveedor().getNombre(),
                lista.get(i).getComprobante(),
                lista.get(i).getGastoConcepto().getNombre() + " (" + lista.get(i).getGastoConcepto().getServicio().getNombre() + ")",
                lista.get(i).getImporte(),
                estado
            });
        }
    }

    /**
     * Método que carga la tabla de gastos por proveedor
     * @param idProveedor ID del proveedor
     * @param tabla tabla en la que mostrar los gastos
     */
    public void cargarTablaGastosProveedor(int idProveedor, JTable tabla) {
        String estado;
        List<Gasto> lista = sg.buscarGastoProveedor(idProveedor);
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setNumRows(0);
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).isLiquidado() == true) {
                estado = "LIQUIDADO";
            } else {
                estado = "PENDIENTE";
            }
            model.addRow(new Object[]{
                lista.get(i).getId(),
                lista.get(i).getDescripcion(),
                lista.get(i).getFechaRegistro(),
                lista.get(i).getFechaPago(),
                lista.get(i).getProveedor().getNombre(),
                lista.get(i).getComprobante(),
                lista.get(i).getGastoConcepto().getNombre() + " (" + lista.get(i).getGastoConcepto().getServicio().getNombre() + ")",
                lista.get(i).getImporte(),
                estado
            });
        }
    }
    //Fin de la clase
}
