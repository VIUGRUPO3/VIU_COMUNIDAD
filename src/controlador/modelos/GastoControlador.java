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
import dao.ServicioInmuebles;
import dao.ServicioProveedores;
import dao.ServicioServicioCuentas;
import dao.ServicioServicios;
import dao.ServicioUsuarios;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    //Fin de la clase
}
