// Asignatura: 21GIIN Proyectos Programación
// Profesor: Eduardo Zamudio
// @author: Grupo 3
// Miembros:
//       @author:Fernando Hernandez Fernandez
//       @author:Javier Barbero Sales
//       @author:Martin Gonzalez Dominguez
// @version: 08/01/2023/package controlador;

package controlador.modelos;

import dao.ServicioInmuebles;
import dao.ServicioServicioCuentas;
import dao.ServicioUsuarios;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Inmueble;
import modelo.ServicioCuenta;
import modelo.usuario.Vecino;

/**
 *
 * @author fer
 */
public class InmuebleControlador {

    //Atributos
    private ServicioInmuebles si = new ServicioInmuebles();
    private ServicioUsuarios su = new ServicioUsuarios();
    private ServicioServicioCuentas ssc = new ServicioServicioCuentas();

    //Constructores
    public InmuebleControlador() {
    }

    //Metodos
    public void registrarInmueble(JTextField txtDireccionEI, JTable tabla) {
        String direccion = txtDireccionEI.getText();
        Inmueble i = new Inmueble(direccion);
        si.insertarInmuebleDB(i);
        cargarTablaInmuebles("", tabla);
    }

    public void updateInmueble(JTextField txtIdEI, JTextField txtDireccionEI, JTextField txtIdVecinoEI, JTable tabla) {
        int id = Integer.parseInt(txtIdEI.getText());
        Vecino v = null;
        String direccion = txtDireccionEI.getText();
        if (txtIdVecinoEI.getText().equals("")) {
            v = null;
        } else {
            v = su.buscarId(Integer.parseInt(txtIdVecinoEI.getText()));
        }
        Inmueble i = new Inmueble(id, v, direccion);
        si.updateInmueble(i);
        cargarTablaInmuebles("", tabla);
    }

    public List<Inmueble> obtenerListaInmuebles(String direccion) {
        List<Inmueble> lista = si.buscarDireccion(direccion);
        return lista;
    }

    public void eliminarInmueble(JTable tabla) {
        int[] lista = tabla.getSelectedRows();
        if (lista.length != 0) {
            for (int row : lista) {
                Inmueble i = si.buscarId(obtenerIdTablaInmuebles(row, tabla));
                eliminarServicioCuentaServicio(i);
                si.borrarInmueble(i);
            }
        }
        cargarTablaInmuebles("", tabla);
    }

    private void eliminarServicioCuentaServicio(Inmueble i) {
        List<ServicioCuenta> listaServicioCuenta = ssc.buscarServiciosInmueble(i.getId());
        for (ServicioCuenta sc : listaServicioCuenta) {
            ssc.borrarServicioCuenta(sc);
        }
    }

    public void cargarFormInmueble(
            JTextField txtIdEI,
            JTextField txtDireccionEI,
            JTextField txtIdVecinoEI,
            JTextField txtNombreEI,
            JTextField txtApellidosEI,
            JTextField txtTelefonoEI,
            JTextField txtEmailEI,
            JTable tabla) {
        int row = tabla.getSelectedRow();
        Inmueble i = obtenerInmueble(obtenerIdTablaInmuebles(row, tabla));
        txtIdEI.setText(Integer.toString(i.getId()));
        txtDireccionEI.setText(i.getDireccion());
        Vecino v = i.getVecino();
        if (v != null) {
            txtIdVecinoEI.setText(Integer.toString(v.getId()));
            txtNombreEI.setText(v.getNombre());
            txtApellidosEI.setText(v.getApellidos());
            txtTelefonoEI.setText(v.getTelefono());
            txtEmailEI.setText(v.getEmail());
        } else {
            txtIdVecinoEI.setText("");
            txtNombreEI.setText("");
            txtApellidosEI.setText("");
            txtTelefonoEI.setText("");
            txtEmailEI.setText("");
        }

    }

    public Inmueble obtenerInmueble(int id) {
        Inmueble i = si.buscarId(id);
        return i;
    }

    public int obtenerIdTablaInmuebles(int row, JTable tabla) {
        int id = (int) tabla.getValueAt(row, 0);
        return id;
    }

    public void cargarTablaInmuebles(String direccion, JTable tabla) {
        List<Inmueble> lista = obtenerListaInmuebles(direccion);
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setNumRows(0);
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getVecino() != null) {
                model.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getDireccion(), lista.get(i).getVecino().getNombre() + " " + lista.get(i).getVecino().getApellidos()});
            } else {
                model.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getDireccion(), " "});
            }

        }
    }

    public void cargarTablaInmueblesVecino(int vecinoId, JTable tabla) {
        List<Inmueble> lista = si.buscarInmueblesVecino(vecinoId);
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setNumRows(0);
        for (int i = 0; i < lista.size(); i++) {
            model.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getDireccion(), lista.get(i).getVecino().getNombre() + " " + lista.get(i).getVecino().getApellidos()});
        }
    }

    public void cargarTablaVecinosAsignacion(String nombre, JTable tabla) {
        List<Vecino> lista = su.buscarNombre(nombre);
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setNumRows(0);
        for (int i = 0; i < lista.size(); i++) {
            model.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getNombre(), lista.get(i).getApellidos()});
        }
    }

    public void cargarTablaInmueblesSelected(JTable tablaFuente, JTable tablaDestino, JButton boton, JButton boton2, JButton boton3, JTextField texto) {
        tablaFuente.setEnabled(true);
        boton.setEnabled(true);
        boton2.setEnabled(true);
        boton3.setEnabled(true);
        texto.setEnabled(true);
        int[] rows = tablaFuente.getSelectedRows();
        DefaultTableModel model = (DefaultTableModel) tablaDestino.getModel();
        model.setNumRows(0);
        for (int i = 0; i < rows.length; i++) {
            model.addRow(new Object[]{tablaFuente.getValueAt(rows[i], 0), tablaFuente.getValueAt(rows[i], 1)});
        }
    }

    public void cargarTablaInmueblesFromEdit(JTable tablaFuente, JTable tablaDestino, JButton boton, JButton boton2, JButton boton3, JTextField texto, Inmueble i) {
        tablaFuente.setEnabled(false);
        boton.setEnabled(false);
        boton2.setEnabled(false);
        boton3.setEnabled(false);
        texto.setEnabled(false);
        DefaultTableModel model = (DefaultTableModel) tablaDestino.getModel();
        model.setNumRows(0);
        model.addRow(new Object[]{i.getId(), i.getDireccion()});
    }

    public void cargarTablaInmueblesAsignar(JTable tablaFuente, JTable tablaDestino) {
        int[] rows = tablaFuente.getSelectedRows();
        DefaultTableModel model = (DefaultTableModel) tablaDestino.getModel();
        model.setNumRows(0);
        for (int i = 0; i < rows.length; i++) {
            model.addRow(new Object[]{tablaFuente.getValueAt(rows[i], 0), tablaFuente.getValueAt(rows[i], 1), tablaFuente.getValueAt(rows[i], 2)});
        }

    }

    public void cargarTablaInmueblesSinServicio(JTable tablaDestino, JTable tablaServicios) {
        int rowServicios = tablaServicios.getSelectedRow();
        int idServicio = (int) tablaServicios.getValueAt(rowServicios, 0);
        List<Inmueble> lista = obtenerInmueblesSinServicio(idServicio);
        DefaultTableModel model = (DefaultTableModel) tablaDestino.getModel();
        model.setNumRows(0);
        for (int i = 0; i < lista.size(); i++) {
            model.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getDireccion(), lista.get(i).getVecino().getNombre() + " " + lista.get(i).getVecino().getApellidos()});
        }
    }

    public List<Inmueble> obtenerInmueblesSinServicio(int idServicio) {
        List<ServicioCuenta> listaCuentasServicio = ssc.buscarInmublesServicios(idServicio);
        List<Inmueble> listaInmueblesConServicio = new ArrayList();
        boolean inmueblePresente = false;
        for (ServicioCuenta sc : listaCuentasServicio) {
            listaInmueblesConServicio.add(sc.getInmueble());
        }
        List<Inmueble> listaInmuebles = si.listarInmuebles();
        List<Inmueble> InmueblesDisponibles = new ArrayList();
        for (Inmueble inmueble : listaInmuebles) {
            inmueblePresente = false;
            for (Inmueble inmuebleConServicio : listaInmueblesConServicio) {
                if (inmuebleConServicio.equals(inmueble)) {
                    inmueblePresente = true;
                }
            }
            if (inmueblePresente == false) {
                InmueblesDisponibles.add(inmueble);
            }
        }
        return InmueblesDisponibles;
    }

    public boolean comprobarAsignacion(JTable tabla, JLabel lblId) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        int rows = model.getRowCount();
        if (rows > 0 && !lblId.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public void AsignarInmueble(JTable tabla, JLabel lblId) {
        int rows = tabla.getRowCount();
        Vecino v = su.buscarId(Integer.parseInt(lblId.getText()));
        for (int i = 0; i < rows; i++) {
            Inmueble inmueble = new Inmueble((int) tabla.getValueAt(i, 0), v, (String) tabla.getValueAt(i, 1));
            si.updateInmueble(inmueble);
        }
    }
    //Fin de la clase
}
