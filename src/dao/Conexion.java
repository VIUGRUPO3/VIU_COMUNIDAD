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
 * Clase Conexion para gestionar la conexión a la base de datos
 */
public class Conexion {
    
    /**
     * Atributo que contiene la conexión a la base de datos
     */
    static Connection conn = null;
    
    /**
     * Método para establecer una conexión a la base de datos
     * @throws IOException Excepción en caso de que haya problemas conectando a la base de datos
     * @throws ClassNotFoundException Excepciones relativas a problemas de clase a la hora de conectar
     */
    public Conexion() throws IOException, ClassNotFoundException {
        Conexion.conn = conectarBD();
    }
    
    /**
     * Método que establece una conexión a la base de datos
     * @return Si no hay problemas, devuelve null
     * @throws IOException Excepción devuelta en caso de no poder conectar
     * @throws ClassNotFoundException Excepción devuelta en caso de haber problemas al operar la conexión
     */
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
