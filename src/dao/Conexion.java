// Asignatura: 21GIIN Proyectos Programación
// Profesor: Eduardo Zamudio
// @author: Grupo 3
// Miembros:
//       @author:Fernando Hernandez Fernandez
//       @author:Javier Barbero Sales
//       @author:Martin Gonzalez Dominguez
// @version: 08/01/2023/package controlador;
package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fer
 */
public class Conexion {
    
    static Connection conn = null;
    
    public Conexion() throws IOException, ClassNotFoundException {
        Conexion.conn = conectarBD();
    }
    
    
    
    
    
    public Connection conectarBD() throws IOException, ClassNotFoundException {
        InputStream config;
        try {
            config = new FileInputStream("./src/resources/config.properties");
            Properties prop = new Properties();
            prop.load(config);
            String dbURL = prop.getProperty("db.url");
            String dbUser = prop.getProperty("db.user");
            String dbPassword = prop.getProperty("db.password");

            ConexionDB conDB = new ConexionDB(dbURL, dbUser, dbPassword);
            conn = conDB.getConnection();
            return conn;

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
