/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.modelos;

import dao.ServicioInmuebles;
import dao.ServicioProveedores;
import dao.ServicioServicioCuentas;
import dao.ServicioServicios;
import dao.ServicioUsuarios;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Inmueble;
import modelo.Proveedor;
import modelo.Servicio;
import modelo.ServicioCuenta;

/**
 *
 * @author fer
 */
public class ProveedorControlador {

    //Atributos
    private ServicioInmuebles si = new ServicioInmuebles();
    private ServicioUsuarios su = new ServicioUsuarios();
    private ServicioServicios ss = new ServicioServicios();
    private ServicioProveedores sp = new ServicioProveedores();
    private ServicioServicioCuentas ssc = new ServicioServicioCuentas();

    //Constructores
    public ProveedorControlador() {
    }

    //Metodos
    public void registrarProveedor(JTextField txtNombreES, JTextField txtTarifaES, JComboBox comboTipo, JTable tabla) {
        boolean tipo = false;
        List<Inmueble> listaInmuebles = si.listarInmuebles();
        if (comboTipo.getSelectedItem().equals("Obligatorio")) {
            tipo = false;
        } else {
            tipo = true;
        }
        Servicio s = new Servicio(txtNombreES.getText(), Double.parseDouble(txtTarifaES.getText()), tipo);
        ss.insertarServicioDB(s);
        Servicio sInsertado = ss.obtenerUltimoServicio();
        if (tipo == false) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date today = new Date();
            for (Inmueble i : listaInmuebles) {
                ServicioCuenta sc = new ServicioCuenta(i, sInsertado, today);
                ssc.insertarServicioCuentaDB(sc);
            }
        }
        cargarTablaProveedores("", tabla);
    }

    public void updateServicio(JTextField txtIdES, JTextField txtNombreES, JTextField txtTarifaES, JComboBox comboTipo, JTable tabla) {
        boolean tipo = false;
        List<Inmueble> listaInmuebles = si.listarInmuebles();
        int id = Integer.parseInt(txtIdES.getText());
        String nombre = txtNombreES.getText();
        double tarifa = Double.parseDouble(txtTarifaES.getText());
        if (comboTipo.getSelectedItem().equals("Obligatorio")) {
            tipo = false;
        } else {
            tipo = true;
        }
        Servicio s = new Servicio(id, nombre, tarifa, tipo);
        ss.updateServicio(s);
        if (tipo == false) {
            eliminarServicioCuentaServicio(s);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date today = new Date();
            for (Inmueble i : listaInmuebles) {
                ServicioCuenta sc = new ServicioCuenta(i, s, today);
                ssc.insertarServicioCuentaDB(sc);
            }
        }
        cargarTablaProveedores("", tabla);
    }

    public void eliminarServicio(JTable tabla) {
        int[] lista = tabla.getSelectedRows();
        if (lista.length != 0) {
            for (int row : lista) {
                Servicio s = ss.buscarId(obtenerIdTablaServicios(row, tabla));
                eliminarServicioCuentaServicio(s);
                ss.borrarServicio(s);
            }
        }
        cargarTablaProveedores("", tabla);
    }
    
    private void eliminarServicioCuentaServicio(Servicio s){
        List<ServicioCuenta> listaServicioCuenta = ssc.buscarInmublesServicios(s.getId());
        for (ServicioCuenta sc : listaServicioCuenta) {
            ssc.borrarServicioCuenta(sc);
        }
    }

    public void cargarFormServicio(
            JTextField txtIdES,
            JTextField txtNombreES,
            JTextField txtTarifaES,
            JComboBox  cmbTipoES,
            JTable tabla) {
        int indexTipo = 0;
        int row = tabla.getSelectedRow();
        Servicio s = ss.buscarId(obtenerIdTablaServicios(row, tabla));
        txtIdES.setText(Integer.toString(s.getId()));
        txtNombreES.setText(s.getNombre());
        txtTarifaES.setText(Double.toString(s.getTarifa()));
        if(s.isOpcional()==true){
            indexTipo = 1;
        }else{
            indexTipo = 0;
        }
        cmbTipoES.setSelectedIndex(indexTipo);
    }

    public int obtenerIdTablaServicios(int row, JTable tabla) {
        int id = (int) tabla.getValueAt(row, 0);
        return id;
    }

    public void cargarTablaProveedores(String nombre, JTable tabla) {
        String tipo;
        List<Proveedor> lista = sp.buscarProveedor(nombre);
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setNumRows(0);
        for (int i = 0; i < lista.size(); i++) {
            model.addRow(new Object[]{
                lista.get(i).getId(), 
                lista.get(i).getNombre(), 
                lista.get(i).getDireccion(),
                lista.get(i).getTelefono(),
                lista.get(i).getEmail()
                });
        }
    }
    
    public void cargarTablaServiciosOpcionales(String nombre, JTable tabla) {
        String tipo;
        List<Servicio> lista = ss.buscarServiciosOpcionales(nombre);
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setNumRows(0);
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).isOpcional() == true) {
                tipo = "Opcional";
            } else {
                tipo = "Obligatorio";
            }
            model.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getNombre(), lista.get(i).getTarifa(), tipo});
        }
    }

    public void cargarTablaInmueblesServicio(int idServicio, JTable tabla) {
        List<ServicioCuenta> listaServicioCuenta = ssc.buscarInmublesServicios(idServicio);
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setNumRows(0);
        for(ServicioCuenta sc : listaServicioCuenta){
            Inmueble i = si.buscarId(sc.getInmueble().getId());
            model.addRow(new Object[]{i.getId(), i.getDireccion(), i.getVecino().getNombre() + " " + i.getVecino().getApellidos()});
        }
    }
    
    public void cargarTablaServiciosInmueble(int idInmueble, JTable tabla) {
        List<ServicioCuenta> listaServicioCuenta = ssc.buscarServiciosInmueble(idInmueble);
        String tipoServicio;
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setNumRows(0);
        for(ServicioCuenta sc : listaServicioCuenta){
            Servicio s = ss.buscarId(sc.getServicio().getId());
            if(s.isOpcional()==true){
                tipoServicio = "Opcional";
            }else{
                tipoServicio = "Obligatorio";
            }
            model.addRow(new Object[]{s.getId(), s.getNombre(), s.getTarifa(), tipoServicio});
        }
    }

    public void cargarServicioSelected(JTable tabla, JLabel lblServicioIdAS, JLabel lblServicioNombreAS, JLabel lblTarifaServicioAS, JLabel lblServicioTipoAS){
        int row = tabla.getSelectedRow();
        lblServicioIdAS.setText(Integer.toString((int) tabla.getValueAt(row, 0)));
        lblServicioNombreAS.setText((String) tabla.getValueAt(row, 1));
        lblTarifaServicioAS.setText(Double.toString((double)tabla.getValueAt(row, 2)) );
        lblServicioTipoAS.setText((String) tabla.getValueAt(row, 3));
    }
    
//    public void cargarTablaVecinosAsignacion(String nombre, JTable tabla) {
//        List<Vecino> lista = su.buscarNombre(nombre);
//        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
//        model.setNumRows(0);
//        for (int i = 0; i < lista.size(); i++) {
//            model.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getNombre(), lista.get(i).getApellidos()});
//        }
//    }
//
//    public void cargarTablaInmueblesSelected(JTable tablaFuente, JTable tablaDestino, JButton boton, JButton boton2, JButton boton3, JTextField texto) {
//        tablaFuente.setEnabled(true);
//        boton.setEnabled(true);
//        boton2.setEnabled(true);
//        boton3.setEnabled(true);
//        texto.setEnabled(true);
//        int[] rows = tablaFuente.getSelectedRows();
//        DefaultTableModel model = (DefaultTableModel) tablaDestino.getModel();
//        model.setNumRows(0);
//        for (int i = 0; i < rows.length; i++) {
//            model.addRow(new Object[]{tablaFuente.getValueAt(rows[i], 0), tablaFuente.getValueAt(rows[i], 1)});
//        }
//    }
//
//    public void cargarTablaInmueblesFromEdit(JTable tablaFuente, JTable tablaDestino, JButton boton, JButton boton2, JButton boton3, JTextField texto, Inmueble i) {
//        tablaFuente.setEnabled(false);
//        boton.setEnabled(false);
//        boton2.setEnabled(false);
//        boton3.setEnabled(false);
//        texto.setEnabled(false);
//        DefaultTableModel model = (DefaultTableModel) tablaDestino.getModel();
//        model.setNumRows(0);
//        model.addRow(new Object[]{i.getId(), i.getDireccion()});
//    }
//
//    public void cargarVecinosSelected(JTable tabla, JLabel lblId, JLabel lblNombre, JLabel lblApellidos) {
//        int row = tabla.getSelectedRow();
//        lblId.setText(Integer.toString((int) tabla.getValueAt(row, 0)));
//        lblNombre.setText((String) tabla.getValueAt(row, 1));
//        lblApellidos.setText((String) tabla.getValueAt(row, 2));
//
//    }
//
    
//AsignarServicio(tblSeleccionInmueblesAI, lblServicioIdAS)
    public void AsignarServicio(JTable tabla, JLabel lblId) {
        int rows = tabla.getRowCount();
        Servicio s = ss.buscarId(Integer.parseInt(lblId.getText()));
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date today = new Date();
        for (int i = 0; i < rows; i++) {
            Inmueble inmueble = si.buscarId((int) tabla.getValueAt(i, 0)); 
            ServicioCuenta sc = new ServicioCuenta(inmueble, s, today);
            ssc.insertarServicioCuentaDB(sc);
        }
    }
    //Fin de la clase
}
