// Asignatura: 21GIIN Proyectos Programación
// Profesor: Eduardo Zamudio
// @author: Grupo 3
// Miembros:
//       @author:Fernando Hernandez Fernandez
//       @author:Javier Barbero Sales
//       @author:Martin Gonzalez Dominguez
// @version: 08/01/2023/package controlador;


import dao.Conexion;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.usuario.Vecino;
import vista.LoginFrame;
import vista.MainFrameAdmin;
import vista.MainFrameVecino;

/**
 * Clase Controlador
 */
public class Controlador {

//Atributos

    /**
     * Se define la ventana Admin
     */
    public static MainFrameAdmin mainFrameAdmin = new MainFrameAdmin();

    /**
     * Se define la ventana Vecino
     */
    public static MainFrameVecino mainFrameVecino = new MainFrameVecino();
    //Constructores

    /**
     * Constructor principal
     */
    public Controlador() {
        
    }

    //Metodos

    /**
     * Método que define el inicio de la aplicación
     */
    public void iniciarApp() {
        mainFrameAdmin.setVisible(false);
        LoginFrame loginForm = new LoginFrame();
        loginForm.setVisible(true);
    }

    /**
     * Método que establece la parte que será visible dependiendo de si el usuario logueado es Administrador o Vecino.
     * En caso de no ser ni Vecino ni Administrador, se mostrará el panel de login.
     * @param v Objeto vecino
     * @param tipoUsuario Tipo de usuario
     */
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
    
    /**
     * Método de logout para el tipo de usuario Administrador
     */
    public void logoutAdmin(){
        mainFrameAdmin.setVisible(false);
        mainFrameAdmin.dispose();
        iniciarApp();
    }

    /**
     * Método de logout para el tipo de usuario Vecino
     */
    public void logoutVecino(){
        mainFrameVecino.setVisible(false);
        mainFrameVecino.dispose();
        iniciarApp();
    }

}
