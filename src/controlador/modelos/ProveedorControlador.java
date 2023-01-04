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
    public void registrarProveedor(JTextField txtNombreEP, JTextField txtDireccionEP, JTextField txtTelefonoEP, JTextField txtEmailEP, JTable tabla) {
        Proveedor p = new Proveedor(txtNombreEP.getText(), txtDireccionEP.getText(), txtTelefonoEP.getText(), txtEmailEP.getText());
        sp.insertarProveedorDB(p);
        cargarTablaProveedores("", tabla);
    }

    public void updateProveedor(JTextField txtIdEP, JTextField txtNombreEP, JTextField txtDireccionEP, JTextField txtTelefonoEP, JTextField txtEmailEP, JTable tabla) {
        int id = Integer.parseInt(txtIdEP.getText());
        String nombre = txtNombreEP.getText();
        String direccion = txtDireccionEP.getText();
        String telefono = txtTelefonoEP.getText();
        String email = txtEmailEP.getText();
        Proveedor p = new Proveedor(id, nombre, direccion, telefono, email);
        sp.updateProveedor(p);
        cargarTablaProveedores("", tabla);
    }

    public void eliminarProveedor(JTable tabla) {
        int[] lista = tabla.getSelectedRows();
        if (lista.length != 0) {
            for (int row : lista) {
                Proveedor p = sp.buscarId(obtenerIdTablaProveedores(row, tabla));
                sp.borrarProveedor(p);
            }
        }
        cargarTablaProveedores("", tabla);
    }

    public void cargarFormProveedor(
            JTextField txtIdEP,
            JTextField txtNombreEP,
            JTextField txtDireccionEP,
            JTextField txtTelefonoEP,
            JTextField txtEmailEP,
            JTable tabla) {
        int row = tabla.getSelectedRow();
        Proveedor p = sp.buscarId(obtenerIdTablaProveedores(row, tabla));
        txtIdEP.setText(Integer.toString(p.getId()));
        txtNombreEP.setText(p.getNombre());
        txtDireccionEP.setText(p.getDireccion());
        txtTelefonoEP.setText(p.getTelefono());
        txtEmailEP.setText(p.getEmail());
    }

    public int obtenerIdTablaProveedores(int row, JTable tabla) {
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
   
    
    public void cargarTablaGastosProveedor(){
        //TODO implementar metodo de carga de tabla de gastos de un proveedor
    }
    //Fin de la clase
}
