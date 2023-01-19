package controlador;

// Asignatura: 21GIIN Proyectos Programación
// Profesor: Eduardo Zamudio
// @author: Grupo 3
// Miembros:
//       @author:Fernando Hernandez Fernandez
//       @author:Javier Barbero Sales
//       @author:Martin Gonzalez Dominguez
// @version: 08/01/2023/package controlador;


import javax.swing.JInternalFrame;
import modelo.usuario.Vecino;
import vista.LoginFrame;
import vista.MainFrameAdmin;
import vista.MainFrameAdminMVC;
import vista.MainFrameVecino;

/**
 * Clase Controlador
 */
public class Controlador {

//Atributos

    /**
     * Se define la ventana Admin
     */
    public static MainFrameAdminMVC mfamvc = new MainFrameAdminMVC();

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
        if(mfamvc.isVisible()==true){
            mfamvc.setVisible(false);
        }
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
                    mfamvc.setVisible(true);
                    mfamvc.jLabel42.setText(Integer.toString(v.getId()) + " - ");
                    mfamvc.jLabel37.setText(v.getNombre() + " " + v.getApellidos());
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
    
    public void ocultarFrame(JInternalFrame jif){
        jif.setVisible(false);
        mfamvc.panelDatos.remove(jif);
        
    }
    
    public void mostrarFrame(JInternalFrame jif){
        mfamvc.panelDatos.add(jif);
        jif.setVisible(true);
    }
    /**
     * Método de logout para el tipo de usuario Administrador
     */
    public void logoutAdmin(){
        mfamvc.setVisible(false);
        mfamvc.dispose();
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
