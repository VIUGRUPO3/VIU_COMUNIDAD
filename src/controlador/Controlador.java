// Asignatura: 21GIIN Proyectos Programación
// Profesor: Eduardo Zamudio
// @author: Grupo 3
// Miembros:
//       @author:Fernando Hernandez Fernandez
//       @author:Javier Barbero Sales
//       @author:Martin Gonzalez Dominguez
// @version: 08/01/2023/package controlador;

package controlador;

import java.awt.event.KeyEvent;
import static java.awt.image.ImageObserver.HEIGHT;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
    //public static MainFrameAdmin mfa = new MainFrameAdmin();       
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
    
    public void ocultarFrame(JInternalFrame jif, JDesktopPane dp){
        jif.setVisible(false);
        dp.remove(jif);
        jif = null;
        
    }
    
    public void mostrarFrame(JInternalFrame jif, JDesktopPane dp){
        dp.add(jif);
        jif.setVisible(true);
    }
     
    public void limpiarDesktopPane(JDesktopPane dp){
        for(JInternalFrame jif: dp.getAllFrames()){
            if (jif!=null){
                jif.setVisible(false);
                dp.remove(jif);
                jif = null;
            }
        }
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
    
    /**
     * Metodo que vacia la tabla especificada
     * @param tabla Tabla que se vaciara
     */
     public void limpiarTabla(JTable tabla) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setNumRows(0);
    }
    
    //FUNCIONES DE FILTRADO
    //solo letras y espacios
    public boolean filtrarCaracteres(String texto, char caracter, String modo){
        if (modo.equals("l")){
            if(!(Character.isLetter(caracter) && (caracter != KeyEvent.VK_SPACE) && (caracter != KeyEvent.VK_BACK_SPACE) && (caracter != KeyEvent.VK_DELETE))){
                JOptionPane.showMessageDialog(null, "Caracter no válido.\n Solo se admiten letras", "ComunidadVIU", HEIGHT);
                return true;
            }
            return false;
        }
    
       //solo numeros
        if (modo.equals("n")){
            if(!(Character.isDigit(caracter)  && (caracter != KeyEvent.VK_BACK_SPACE) && (caracter != KeyEvent.VK_DELETE))){
                JOptionPane.showMessageDialog(null, "Caracter no válido.\n Solo se admiten números", "ComunidadVIU", HEIGHT);
                return true;
            }
            return false;
        }
        //letras y numeros
        if (modo.equals("ln")){
            if(!(Character.isDigit(caracter)) && !(Character.isLetter(caracter))  && (caracter != KeyEvent.VK_SPACE) && (caracter != KeyEvent.VK_BACK_SPACE) && (caracter != KeyEvent.VK_DELETE) && (caracter != KeyEvent.VK_BACK_SLASH) && (caracter != KeyEvent.VK_SLASH) ){
                JOptionPane.showMessageDialog(null, "Caracter no válido.\n Solo se admiten letas/números", "ComunidadVIU", HEIGHT);
                return true;
            }
            return false;
        }
        
        //emails
        if (modo.equals("m")  && (caracter != KeyEvent.VK_BACK_SPACE) && (caracter != KeyEvent.VK_DELETE)){
//            if(!(Character.isAlphabetic(caracter))){
//                JOptionPane.showMessageDialog(null, "Caracter no válido.", "ComunidadVIU", HEIGHT);
//                return true;
//            }
            return false;
        }
        //telefonos:
        if (modo.equals("t")){
            if(!(Character.isDigit(caracter)) && !(caracter == '+')  && (caracter != KeyEvent.VK_BACK_SPACE) && (caracter != KeyEvent.VK_DELETE)){
                JOptionPane.showMessageDialog(null, "Caracter no válido.\n Solo se admiten números o el caracter de prefijo +", "ComunidadVIU", HEIGHT);
                return true;
            }
            return false;
        }
        return false;
    }

}
