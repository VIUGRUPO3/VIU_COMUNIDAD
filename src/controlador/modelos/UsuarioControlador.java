/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.modelos;

import controlador.Controlador;
import dao.ServicioUsuarios;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modelo.usuario.Admin;
import modelo.usuario.Vecino;
import vista.MainFrameAdmin;

/**
 *
 * @author fer
 */
public class UsuarioControlador {
    private static ServicioUsuarios su = new ServicioUsuarios();
   
//Atributos
    private static Controlador ctrl = new Controlador();
    //Constructores
    public UsuarioControlador() {
    }
 
    //Metodos
    public void autenticarUsuario(String userName, String pwd){
        ServicioUsuarios su = new ServicioUsuarios();
        Vecino v = su.comprobarCredenciales(userName, pwd);
        String tipoUsuario = su.obtenerTipoUsuario(v);
        ctrl.autenticado(v, tipoUsuario);
    }
    
    
    
    public void registrarVecino(){
        String nombre = ctrl.mainFrameAdmin.txtNombreEU.getText();
        String apellidos = ctrl.mainFrameAdmin.txtApellidosEU.getText();
        String telefono = ctrl.mainFrameAdmin.txtTelefonoEU.getText();
        String email = ctrl.mainFrameAdmin.txtEmailEU.getText();
        String userName = ctrl.mainFrameAdmin.txtUserNameEU.getText();
        String pwd = ctrl.mainFrameAdmin.txtPasswordEU.getText();
        Vecino v = new Vecino(nombre, apellidos, userName, pwd, telefono, email);
        su.insertarVecinoDB(v); 
        cargarTablaUsuarios("");
    }
    
    public void updateUsuario(){
        int id = Integer.parseInt(ctrl.mainFrameAdmin.txtIdEU.getText());
        String nombre = ctrl.mainFrameAdmin.txtNombreEU.getText();
        String apellidos = ctrl.mainFrameAdmin.txtApellidosEU.getText();
        String telefono = ctrl.mainFrameAdmin.txtTelefonoEU.getText();
        String email = ctrl.mainFrameAdmin.txtEmailEU.getText();
        String userName = ctrl.mainFrameAdmin.txtUserNameEU.getText();
        String clave = ctrl.mainFrameAdmin.txtPasswordEU.getText();
        Vecino v = new Vecino (id, nombre, apellidos, userName, clave, telefono,email);
        su.updateUsuario(v);
        cargarTablaUsuarios("");
    }
    
    public void registrarAdmin(){
        String nombre = ctrl.mainFrameAdmin.txtNombreRA.getText();
        String apellidos = ctrl.mainFrameAdmin.txtApellidosRA.getText();
        String telefono = ctrl.mainFrameAdmin.txtTelefonoRA.getText();
        String email = ctrl.mainFrameAdmin.txtEmailRA.getText();
        String userName = ctrl.mainFrameAdmin.txtUserNameRA.getText();
        String pwd = ctrl.mainFrameAdmin.txtPasswordRA.getText();
        Admin a = new Admin(nombre, apellidos, userName, pwd, telefono, email);
        su.insertarAdminDB(a);
        cargarTablaUsuarios("");
    }
    
    public List<Vecino> obtenerListaUsuarios(String nombre){
        List<Vecino> lista = su.buscarNombre(nombre);
        return lista;
    }
    
    public void eliminarUsuario (){
        int[] lista = ctrl.mainFrameAdmin.jTable1.getSelectedRows();
        if (lista.length != 0) {
            for (int row : lista) {
                Vecino v = su.buscarId(obtenerIdTablaUser(row));
                su.borrarVecino(v);
            }
        }
        cargarTablaUsuarios("");
    }
    
    public void cargarFormUsuario(){
        int row = ctrl.mainFrameAdmin.jTable1.getSelectedRow();
        Vecino v = obtenerVecino(obtenerIdTablaUser(row));
        ctrl.mainFrameAdmin.txtIdEU.setText(Integer.toString(v.getId()));
        ctrl.mainFrameAdmin.txtNombreEU.setText(v.getNombre());
        ctrl.mainFrameAdmin.txtApellidosEU.setText(v.getApellidos());
        ctrl.mainFrameAdmin.txtTelefonoEU.setText(v.getTelefono());
        ctrl.mainFrameAdmin.txtEmailEU.setText(v.getEmail());
        ctrl.mainFrameAdmin.txtUserNameEU.setText(v.getUserName());
        ctrl.mainFrameAdmin.txtPasswordEU.setText(v.getClave());
    }
    
    public Vecino obtenerVecino (int id){
        Vecino v = su.buscarId(id);
        return v;
    }
    
    public int obtenerIdTablaUser(int row) {
        int id = (int) ctrl.mainFrameAdmin.jTable1.getValueAt(row, 0);
        return id;
    }
    
    public void cargarTablaUsuarios(String nombre) {
        List<Vecino> lista = obtenerListaUsuarios(nombre);
        DefaultTableModel model = (DefaultTableModel) ctrl.mainFrameAdmin.jTable1.getModel();
        model.setNumRows(0);
        for (int i = 0; i < lista.size(); i++) {
            model.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getNombre(), lista.get(i).getApellidos(), lista.get(i).getTelefono(), lista.get(i).getEmail(), lista.get(i).getUserName()});
        }
    }
    
    
    //Fin de la clase
}
