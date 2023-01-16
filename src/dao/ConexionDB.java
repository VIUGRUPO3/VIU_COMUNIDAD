// Asignatura: 21GIIN Proyectos Programación
// Profesor: Eduardo Zamudio
// @author: Grupo 3
// Miembros:
//       @author:Fernando Hernandez Fernandez
//       @author:Javier Barbero Sales
//       @author:Martin Gonzalez Dominguez
// @version: 01/12/2022/
package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Clase ConexionDB para gestionar la conexión a la base de datos
 */ 
public class ConexionDB {
    
    /**
     * Atributo que contiene la conexión a la base de datos
     */
    private static Connection con = null;
    
    /**
     * Método para establecer la conexión a la base de datos
     * @param url URL de conexión a la base de datos
     * @param user usuario de la base de datos
     * @param pwd contraseña de la base de datos
     * @throws ClassNotFoundException Excepción devuelta en caso de problemas
     */
    public ConexionDB(String url, String user, String pwd) throws ClassNotFoundException{
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pwd);
            System.out.println("Conexion establecida con la base de datos");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Método para devolver el handler a la conexión establecida
     * @return con Handler de la conexión
     */
    public static Connection getConnection(){
        return con;
    }

    
}
