/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.usuario.UsuarioControlador;
import java.awt.Component;
import java.util.HashMap;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.usuario.Admin;
import modelo.usuario.Vecino;
import vista.LoginFrame;
import vista.MainFrame;

/**
 *
 * @author fer
 */
public class Controlador {

    //Atributos
    UsuarioControlador uc = new UsuarioControlador();
    static MainFrame mainFrame = new MainFrame();

    //Constructores
    public Controlador() {
    }

    //Metodos
    public void iniciarApp() {
        mainFrame.setVisible(false);
        LoginFrame loginForm = new LoginFrame();
        loginForm.setVisible(true);
    }

    public void autenticado(boolean autenticado) {
        if (autenticado == true) {
            mainFrame.setVisible(autenticado);
        } else {
            iniciarApp();
        }
    }

    public void registrarVecino() {
        String nombre = mainFrame.txtNombreRV.getText();
        String apellidos = mainFrame.txtApellidosRV.getText();
        String telefono = mainFrame.txtTelefonoRV.getText();
        String email = mainFrame.txtEmailRV.getText();
        String userName = mainFrame.txtUserNameRV.getText();
        String pwd = mainFrame.txtPasswordRV.getText();
        Vecino v = new Vecino(nombre, apellidos, userName, pwd, telefono, email);
        uc.registrarVecino(v);
    }

    public void registrarAdmin() {
        String nombre = mainFrame.txtNombreRA.getText();
        String apellidos = mainFrame.txtApellidosRA.getText();
        String telefono = mainFrame.txtTelefonoRA.getText();
        String email = mainFrame.txtEmailRA.getText();
        String userName = mainFrame.txtUserNameRA.getText();
        String pwd = mainFrame.txtPasswordRA.getText();
        Admin a = new Admin(nombre, apellidos, userName, pwd, telefono, email);
        uc.registrarAdmin(a);

    }

    public void cargarTablaUsuarios(String nombre) {
        List<Vecino> lista = uc.obtenerListaUsuarios(nombre);
        DefaultTableModel model = (DefaultTableModel) mainFrame.jTable1.getModel();
        model.setNumRows(0);
        for (int i = 0; i < lista.size(); i++) {
            model.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getNombre(), lista.get(i).getApellidos(), lista.get(i).getTelefono(), lista.get(i).getEmail(), lista.get(i).getUserName()});
        }
    }

    public void eliminarUsuario() {
        int[] lista = mainFrame.jTable1.getSelectedRows();
        if (lista.length != 0) {
            for (int row : lista) {
                uc.eliminarUsuario(obtenerIdTabla(row));
            }
        }
        cargarTablaUsuarios("");
    }

    public int obtenerIdTabla(int row) {
        int id = (int) mainFrame.jTable1.getValueAt(row, 0);
        return id;
    }
    
    public void cargarFormUsuario(){
        int row = mainFrame.jTable1.getSelectedRow();
        Vecino v = uc.obtenerVecino(obtenerIdTabla(row));
        mainFrame.txtIdEU.setText(Integer.toString(v.getId()));
        mainFrame.txtNombreEU.setText(v.getNombre());
        mainFrame.txtApellidosEU.setText(v.getApellidos());
        mainFrame.txtTelefonoEU.setText(v.getTelefono());
        mainFrame.txtEmailEU.setText(v.getEmail());
        mainFrame.txtUserNameEU.setText(v.getUserName());
        mainFrame.txtPasswordEU.setText(v.getClave());
    }
    
    public void updateUsuario(){
        int id = Integer.parseInt(mainFrame.txtIdEU.getText());
        String nombre = mainFrame.txtNombreEU.getText();
        String apellidos = mainFrame.txtApellidosEU.getText();
        String telefono = mainFrame.txtTelefonoEU.getText();
        String email = mainFrame.txtEmailEU.getText();
        String userName = mainFrame.txtUserNameEU.getText();
        String clave = mainFrame.txtPasswordEU.getText();
        Vecino v = new Vecino (id, nombre, apellidos, userName, clave, telefono,email);
        uc.updateUsuario(v);
        cargarTablaUsuarios("");
    }

}
