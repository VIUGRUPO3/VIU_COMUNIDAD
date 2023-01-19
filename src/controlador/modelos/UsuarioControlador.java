// Asignatura: 21GIIN Proyectos Programación
// Profesor: Eduardo Zamudio
// @author: Grupo 3
// Miembros:
//       @author:Fernando Hernandez Fernandez
//       @author:Javier Barbero Sales
//       @author:Martin Gonzalez Dominguez
// @version: 08/01/2023/package controlador;

package controlador.modelos;

import controlador.Controlador;
import dao.ServicioUsuarios;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.usuario.Admin;
import modelo.usuario.Vecino;

/**
 *
 * @author fer
 */
public class UsuarioControlador {
    
   
//Atributos
    private ServicioUsuarios su = new ServicioUsuarios();
    private Controlador ctrl = new Controlador();
    //Constructores
    public UsuarioControlador() {
    }
 
    //Metodos
    public boolean autenticarUsuario(String userName, String pwd){
        Vecino v = su.comprobarCredenciales(userName, pwd);
        if (v != null){
            String tipoUsuario = su.obtenerTipoUsuario(v);
            ctrl.autenticado(v, tipoUsuario);
            return true;
        }
        return false;
    }
    
    
    
    public void registrarVecino(
            JTextField txtNombreEU,
            JTextField txtApellidosEU,
            JTextField txtTelefonoEU,
            JTextField txtEmailEU,
            JTextField txtUserNameEU,
            JPasswordField txtPasswordEU, JTable tabla){
        
        String nombre = txtNombreEU.getText();
        String apellidos = txtApellidosEU.getText();
        String telefono = txtTelefonoEU.getText();
        String email = txtEmailEU.getText();
        String userName = txtUserNameEU.getText();
        String pwd = txtPasswordEU.getText();
        Vecino v = new Vecino(nombre, apellidos, userName, pwd, telefono, email);
        su.insertarVecinoDB(v); 
        cargarTablaUsuarios("", tabla);
        
    }
    
    public void updateUsuario(
            JTextField txtIdEU,
            JTextField txtNombreEU,
            JTextField txtApellidosEU,
            JTextField txtTelefonoEU,
            JTextField txtEmailEU,
            JTextField txtUserNameEU,
            JPasswordField txtPasswordEU, JTable tabla){
        
        int id = Integer.parseInt(txtIdEU.getText());
        String nombre = txtNombreEU.getText();
        String apellidos = txtApellidosEU.getText();
        String telefono = txtTelefonoEU.getText();
        String email = txtEmailEU.getText();
        String userName = txtUserNameEU.getText();
        String clave = txtPasswordEU.getText();
        Vecino v = new Vecino (id, nombre, apellidos, userName, clave, telefono,email);
        su.updateUsuario(v);
        cargarTablaUsuarios("", tabla);
    }
    
    public void registrarAdmin(
            JTextField txtNombreRA,
            JTextField txtApellidosRA,
            JTextField txtTelefonoRA,
            JTextField txtEmailRA,
            JTextField txtUserNameRA,
            JPasswordField txtPasswordRA, JTable tabla){
        String nombre = txtNombreRA.getText();
        String apellidos = txtApellidosRA.getText();
        String telefono = txtTelefonoRA.getText();
        String email = txtEmailRA.getText();
        String userName = txtUserNameRA.getText();
        String pwd = txtPasswordRA.getText();
        Admin a = new Admin(nombre, apellidos, userName, pwd, telefono, email);
        su.insertarAdminDB(a);
        cargarTablaUsuarios("", tabla);
    }
    
    public List<Vecino> obtenerListaUsuarios(String nombre){
        List<Vecino> lista = su.buscarNombre(nombre);
        return lista;
    }
    
    public void eliminarUsuario (JTable tabla){
        int[] lista = tabla.getSelectedRows();
        if (lista.length != 0) {
            for (int row : lista) {
                Vecino v = su.buscarId(obtenerIdTablaUser(row, tabla));
                su.borrarVecino(v);
            }
        }
        cargarTablaUsuarios("", tabla);
    }
    
    public void cargarFormUsuario(
            JTable tabla, 
            JTextField txtIdEU,
            JTextField txtNombreEU,
            JTextField txtApellidosEU,
            JTextField txtTelefonoEU,
            JTextField txtEmailEU,
            JTextField txtUserNameEU,
            JPasswordField txtPasswordEU ){
        int row = tabla.getSelectedRow();
        Vecino v = obtenerVecino(obtenerIdTablaUser(row, tabla));
        txtIdEU.setText(Integer.toString(v.getId()));
        txtNombreEU.setText(v.getNombre());
        txtApellidosEU.setText(v.getApellidos());
        txtTelefonoEU.setText(v.getTelefono());
        txtEmailEU.setText(v.getEmail());
        txtUserNameEU.setText(v.getUserName());
        txtPasswordEU.setText(v.getClave());
    }
    
    public Vecino obtenerVecino (int id){
        Vecino v = su.buscarId(id);
        return v;
    }
    
    public int obtenerIdTablaUser(int row, JTable tabla) {
        int id = (int) tabla.getValueAt(row, 0);
        return id;
    }
    
    public void cargarTablaUsuarios(String nombre, JTable tabla) {
        List<Vecino> lista = obtenerListaUsuarios(nombre);
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setNumRows(0);
        for (int i = 0; i < lista.size(); i++) {
            model.addRow(new Object[]{lista.get(i).getId(), 
                lista.get(i).getNombre(), 
                lista.get(i).getApellidos(), 
                lista.get(i).getTelefono(), 
                lista.get(i).getEmail(), 
                lista.get(i).getUserName(), 
                su.obtenerTipoUsuario(lista.get(i)).toUpperCase()});
        }
    }
    
    public void cargarVecinosSelected(JTable tabla, JLabel lblId, JLabel lblNombre, JLabel lblApellidos) {
        int row = tabla.getSelectedRow();
        lblId.setText(Integer.toString((int) tabla.getValueAt(row, 0)));
        lblNombre.setText((String) tabla.getValueAt(row, 1));
        lblApellidos.setText((String) tabla.getValueAt(row, 2));
    }
    
    
    //Fin de la clase
}
