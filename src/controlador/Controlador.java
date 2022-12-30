/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import modelo.usuario.Vecino;
import vista.LoginFrame;
import vista.MainFrameAdmin;
import vista.MainFrameVecino;

/**
 *
 * @author fer
 */
public class Controlador {

//Atributos
    public static MainFrameAdmin mainFrameAdmin = new MainFrameAdmin();
    public static MainFrameVecino mainFrameVecino = new MainFrameVecino();
    //Constructores
    public Controlador() {
    }

    //Metodos
    public void iniciarApp() {
        mainFrameAdmin.setVisible(false);
        LoginFrame loginForm = new LoginFrame();
        loginForm.setVisible(true);
    }

    public void autenticado(Vecino v, String tipoUsuario) {
            switch (tipoUsuario) {
                case "admin":
                    mainFrameAdmin.setVisible(true);
                    mainFrameAdmin.jLabel42.setText(Integer.toString(v.getId()) + " - ");
                    mainFrameAdmin.jLabel37.setText(v.getNombre() + " " + v.getApellidos());
                    break;
                case "vecino":
                    mainFrameVecino.setVisible(true);
                    mainFrameVecino.jLabel39.setText(Integer.toString(v.getId()) + " - ");
                    mainFrameVecino.jLabel37.setText(v.getNombre() + " " + v.getApellidos());
                    break;
                default:
                    iniciarApp();
                    break;
            }
    }
    
    public void logoutAdmin(){
        mainFrameAdmin.setVisible(false);
        mainFrameAdmin.dispose();
        iniciarApp();
    }
    public void logoutVecino(){
        mainFrameVecino.setVisible(false);
        mainFrameVecino.dispose();
        iniciarApp();
    }

}
