// Asignatura: 21GIIN Proyectos Programación
// Profesor: Eduardo Zamudio
// @author: Grupo 3
// Miembros:
//       @author:Fernando Hernandez Fernandez
//       @author:Javier Barbero Sales
//       @author:Martin Gonzalez Dominguez
// @version: 01/12/2022/


//PRUEBA


// Paquete
package Main;

import controlador.Controlador;
import dao.Conexion;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que gestiona el programa principal
 */
public class main {

    /**
     * Método principal del programa
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        
        boolean login;
        
        
        //Arriba pruebas, aqui comienza la app.
        try {
            Conexion conexion = new Conexion();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        Controlador ctrl = new Controlador();
        ctrl.iniciarApp();
        
    }
    
}
