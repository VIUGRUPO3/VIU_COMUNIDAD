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
import dao.ServicioServicios;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Inmueble;
import modelo.Servicio;
import modelo.ServicioCuenta;

/**
 *
 * Clase que gestiona el Servicio
 */
public class ServicioControlador {

    //Atributos
    private final ServicioInmuebles S_I = new ServicioInmuebles();
    private final ServicioServicios S_S = new ServicioServicios();
    private final ServicioServicioCuentas S_S_C = new ServicioServicioCuentas();

    //Constructores
    /**
     * Constructor de la clase
     */
    public ServicioControlador() {
    }

    //Metodos
    /**
     * Registra un servicio
     * @param txtNombreES Nombre Servicio
     * @param txtTarifaES Tarifa Servicio
     * @param comboTipo Tipo Servicio
     * @param tabla Tabla donde muestra los datos
     */
    public void registrarServicio(JTextField txtNombreES, JTextField txtTarifaES, JComboBox comboTipo, JTable tabla) {
        boolean tipo = false;
        List<Inmueble> listaInmuebles = S_I.listarInmuebles();
        if (comboTipo.getSelectedItem().equals("Obligatorio")) {
            tipo = false;
        } else {
            tipo = true;
        }
        Servicio s = new Servicio(Double.parseDouble(txtTarifaES.getText()),txtNombreES.getText(),  tipo);
        S_S.insertarServicioDB(s);
        Servicio sInsertado = S_S.obtenerUltimoServicio();
        if (tipo == false) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date today = new Date();
            for (Inmueble i : listaInmuebles) {
                ServicioCuenta sc = new ServicioCuenta(i, sInsertado, today);
                S_S_C.insertarServicioCuentaDB(sc);
            }
        }
        cargarTablaServicios("", tabla);
    }
    /**
     * Update Servicio
     * @param txtIdES Id Servicio
     * @param txtNombreES Nombre Servicio
     * @param txtTarifaES Tarifa Servicio
     * @param comboTipo Tipo Servicio
     * @param tabla Tabla donde seleccionas el Servicio a ser modificado
     */
    public void updateServicio(JTextField txtIdES, JTextField txtNombreES, JTextField txtTarifaES, JComboBox comboTipo, JTable tabla) {
        boolean tipo = false;
        List<Inmueble> listaInmuebles = S_I.listarInmuebles();
        int id = Integer.parseInt(txtIdES.getText());
        String nombre = txtNombreES.getText();
        double tarifa = Double.parseDouble(txtTarifaES.getText());
        if (comboTipo.getSelectedItem().equals("Obligatorio")) {
            tipo = false;
        } else {
            tipo = true;
        }
        Servicio s = new Servicio(tarifa,id, nombre, tipo);
        S_S.updateServicio(s);
        if (tipo == false) {
            eliminarServicioCuentaServicio(s);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date today = new Date();
            for (Inmueble i : listaInmuebles) {
                ServicioCuenta sc = new ServicioCuenta(i, s, today);
                S_S_C.insertarServicioCuentaDB(sc);
            }
        }
        cargarTablaServicios("", tabla);
    }
    /**
     * Eliminar un servicio
     * @param tabla tabla donde selecciono el servicio a ser borrado
     */
    public void eliminarServicio(JTable tabla) {
        int[] lista = tabla.getSelectedRows();
        if (lista.length != 0) {
            for (int row : lista) {
                Servicio s = S_S.buscarId(obtenerIdTablaServicios(row, tabla));
                eliminarServicioCuentaServicio(s);
                S_S.borrarServicio(s);
            }
        }
        cargarTablaServicios("", tabla);
    }
    /**
     *  
     * @param s 
     */
    private void eliminarServicioCuentaServicio(Servicio s){
        List<ServicioCuenta> listaServicioCuenta = S_S_C.buscarInmublesServicios(s.getId());
        for (ServicioCuenta sc : listaServicioCuenta) {
            S_S_C.borrarServicioCuenta(sc);
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
        Servicio s = S_S.buscarId(obtenerIdTablaServicios(row, tabla));
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

    public void cargarTablaServicios(String nombre, JTable tabla) {
        String tipo;
        List<Servicio> lista = S_S.buscarServicios(nombre);
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
    
    public void cargarTablaServiciosOpcionales(String nombre, JTable tabla) {
        String tipo;
        List<Servicio> lista = S_S.buscarServiciosOpcionales(nombre);
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

//    public void cargarTablaInmueblesServicio(int idServicio, JTable tabla) {
//        List<ServicioCuenta> listaServicioCuenta = S_S_C.buscarInmublesServicios(idServicio);
//        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
//        model.setNumRows(0);
//        for(ServicioCuenta sc : listaServicioCuenta){
//            Inmueble i = S_I.buscarId(sc.getInmueble().getId());
//            model.addRow(new Object[]{i.getId(), i.getDireccion(), i.getVecino().getNombre() + " " + i.getVecino().getApellidos()});
//        }
//    }
    
    public Servicio obtenerServicio(int id){
        Servicio s = S_S.buscarId(id);
        return s;
    }

    public void cargarServicioSelected(JTable tabla, JLabel lblServicioIdAS, JLabel lblServicioNombreAS, JLabel lblTarifaServicioAS, JLabel lblServicioTipoAS){
        int row = tabla.getSelectedRow();
        lblServicioIdAS.setText(Integer.toString((int) tabla.getValueAt(row, 0)));
        lblServicioNombreAS.setText((String) tabla.getValueAt(row, 1));
        lblTarifaServicioAS.setText(Double.toString((double)tabla.getValueAt(row, 2)) );
        lblServicioTipoAS.setText((String) tabla.getValueAt(row, 3));
    }
    
    public void AsignarServicio(JTable tabla, JLabel lblId) {
        int rows = tabla.getRowCount();
        Servicio s = S_S.buscarId(Integer.parseInt(lblId.getText()));
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date today = new Date();
        for (int i = 0; i < rows; i++) {
            Inmueble inmueble = S_I.buscarId((int) tabla.getValueAt(i, 0)); 
            ServicioCuenta sc = new ServicioCuenta(inmueble, s, today);
            S_S_C.insertarServicioCuentaDB(sc);
        }
    }
    //Fin de la clase
}
