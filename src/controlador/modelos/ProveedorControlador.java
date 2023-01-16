// Asignatura: 21GIIN Proyectos Programación
// Profesor: Eduardo Zamudio
// @author: Grupo 3
// Miembros:
//       @author:Fernando Hernandez Fernandez
//       @author:Javier Barbero Sales
//       @author:Martin Gonzalez Dominguez
// @version: 08/01/2023/package controlador;

package controlador.modelos;

import dao.ServicioProveedores;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Proveedor;

/**
 *
 * Clase que gestiona el proveedor
 */
public class ProveedorControlador {

//Atributos
    private final ServicioProveedores S_P = new ServicioProveedores();

    //Constructores
    /**
     * Constructor de la clase
     */
    
    public ProveedorControlador() {
    }

    //Metodos
    /**
     * Alta de un proveedor 
     * @param txtNombreEP Nombre de Proveedor
     * @param txtDireccionEP Direccion de proveedor
     * @param txtTelefonoEP Telf de proveedor
     * @param txtEmailEP Email de proveedor
     * @param tabla tabla donde muestra los datos
     */
    public void registrarProveedor(JTextField txtNombreEP, JTextField txtDireccionEP, JTextField txtTelefonoEP, JTextField txtEmailEP, JTable tabla) {
        Proveedor p = new Proveedor(txtNombreEP.getText(), txtDireccionEP.getText(), txtTelefonoEP.getText(), txtEmailEP.getText());
        S_P.insertarProveedorDB(p);
        cargarTablaProveedores("", tabla);
    }

    /**
     * UPdate de un proveedor 
     * @param txtIdEP Id proveedor
     * @param txtNombreEP Nombre proveedor
     * @param txtDireccionEP Direccion proveedor
     * @param txtTelefonoEP telf proveedor
     * @param txtEmailEP email proveedor
     * @param tabla  tabla donde muestra los datos
     */
    public void updateProveedor(JTextField txtIdEP, JTextField txtNombreEP, JTextField txtDireccionEP, JTextField txtTelefonoEP, JTextField txtEmailEP, JTable tabla) {
        int id = Integer.parseInt(txtIdEP.getText());
        String nombre = txtNombreEP.getText();
        String direccion = txtDireccionEP.getText();
        String telefono = txtTelefonoEP.getText();
        String email = txtEmailEP.getText();
        Proveedor p = new Proveedor(id, nombre, direccion, telefono, email);
        S_P.updateProveedor(p);
        cargarTablaProveedores("", tabla);
    }
    
    /**
     * Eliminar proveedor
     * @param tabla tabla donde selecciona el proveedor o proveedores a eliminar
     */
    public void eliminarProveedor(JTable tabla) {
        int[] lista = tabla.getSelectedRows();
        if (lista.length != 0) {
            for (int row : lista) {
                Proveedor p = S_P.buscarId(obtenerIdTablaProveedores(row, tabla));
                S_P.borrarProveedor(p);
            }
        }
        cargarTablaProveedores("", tabla);
    }
    /**
     * Carga los datos del proveedor en el formulario para poder ser editado
     * @param txtIdEP ID proveedor
     * @param txtNombreEP Nombre proveedor
     * @param txtDireccionEP Direccion proveedor
     * @param txtTelefonoEP Telf proveedor
     * @param txtEmailEP Email Proveedor
     * @param tabla Tabla donde selecciona el proveedor a ser mostrado
     */
    public void cargarFormProveedor(
            JTextField txtIdEP,
            JTextField txtNombreEP,
            JTextField txtDireccionEP,
            JTextField txtTelefonoEP,
            JTextField txtEmailEP,
            JTable tabla) {
        int row = tabla.getSelectedRow();
        Proveedor p = S_P.buscarId(obtenerIdTablaProveedores(row, tabla));
        txtIdEP.setText(Integer.toString(p.getId()));
        txtNombreEP.setText(p.getNombre());
        txtDireccionEP.setText(p.getDireccion());
        txtTelefonoEP.setText(p.getTelefono());
        txtEmailEP.setText(p.getEmail());
    }
    /**
     * Obtener Id de la fila de la tabla proveedores
     * @param row numero de fila
     * @param tabla Tabla de proveedores
     * @return El idendtificador del proveedor
     */
    public int obtenerIdTablaProveedores(int row, JTable tabla) {
        int id = (int) tabla.getValueAt(row, 0);
        return id;
    }
    
    /**
     * Carga tabla con el listado completo de proveedores
     * @param nombre nombre proveedor
     * @param tabla tabla donde muestra los datos
     */
    public void cargarTablaProveedores(String nombre, JTable tabla) {
        String tipo;
        List<Proveedor> lista = S_P.buscarProveedor(nombre);
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
   /**
    * Carga tabla con los proveedores en EdicionGasto
    * @param p Proveedor
    * @param tabla Tabla donde muestra los datos
    */
    public void cargarTablaProveedorEdicionGasto(Proveedor p, JTable tabla){
        String tipo;
        List<Proveedor> lista = S_P.listarProveedores();
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
        if(lista.get(i).equals(p)){
                tabla.setRowSelectionInterval(i, i);
            }
        }
        
    }
    
   
    //Fin de la clase
}
