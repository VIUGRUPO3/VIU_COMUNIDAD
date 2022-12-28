/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import modelo.usuario.Vecino;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Inmueble;
import modelo.usuario.Admin;

/**
 *
 * @author fer
 */
public class ServicioInmuebles {
    //Atributos
    ServicioUsuarios su = new ServicioUsuarios();
    //Constructores
    /**
     * Constructor de la clase
     */
    public ServicioInmuebles() {
    }

    //Metodos
    /**
     * Metodo que conecta con la base de datos de servidor
     *
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
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
            Connection conn = conDB.getConnection();
            return conn;

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ServicioInmuebles.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Metodo que inserta una instancia de la clase Vecino en la base de datos
     *
     * @param vecino Objeto de la clase Vecino
     */
    public void insertarInmuebleDB(Inmueble i) {
        int idUser = 0;
        String sql = "insert into inmuebles (direccion) values (?)";
        try {
            Connection conn = conectarBD();
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setString(1, i.getDireccion());
                stmt.execute();
            }
        } catch (IOException | ClassNotFoundException | SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
    }
    
    
    public void updateInmueble(Inmueble i) {
        String sql = "update inmuebles set direccion = ? , vecinoid = ?";
        
        try {
            Connection conn = conectarBD();
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setString(1, i.getDireccion());
                stmt.setInt(2, i.getVecino().getId());
                stmt.execute();
            }
        } catch (IOException | ClassNotFoundException | SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
    }

    
    

    /**
     * Metodo que elimina un vecino de la base de datos
     *
     * @param vecino objeto de la clase vecino
     */
    public void borrarInmueble(Inmueble i) {
        String sql = "delete from inmuebles where id = ?";
        try {
            Connection conn = conectarBD();
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setInt(1, i.getId());
                stmt.execute();
            }
        } catch (IOException | ClassNotFoundException | SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
    }

    /**
     * Metodo que devuelve una lista de los vecinos almacenados en la base de
     * datos
     *
     * @return lista de vecinos
     */
    public List<Inmueble> listarInmuebles() {
        List<Inmueble> lista = new ArrayList();
        try {
            Connection conn = conectarBD();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from inmuebles");
            while (rs.next()) {
                Vecino v = su.buscarId(rs.getInt("vecinoId"));
                lista.add( new Inmueble(rs.getInt("id"),
                        v,rs.getString("direccion")
                        ));
            }
            System.out.println(lista);

        } catch (IOException | ClassNotFoundException | SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
        return lista;
    }

    /**
     * Metodo que busca dentro de los registros todos los vecinos que contengan
     * en su nombre el parametro pasado por referencia
     *
     * @param nombre
     * @return
     */
    public List<Inmueble> buscarDireccion(String direccion) {
        List<Inmueble> lista = new ArrayList();

        try {
            Connection conn = conectarBD();
            PreparedStatement stmt = busquedaDireccion(conn, direccion);
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) {
                    Vecino v = su.buscarId(rs.getInt("vecinoId"));
                    lista.add(new Inmueble(rs.getInt("id"),
                            v,rs.getString("direccion")));
                }
            }
        } catch (IOException | ClassNotFoundException | SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
        System.out.println(lista);
        return lista;
    }

    /**
     * Metodo que genera la consulta parametrizada para realizar la busqueda
     * porNombre
     *
     * @param con
     * @param nombre
     * @return
     * @throws SQLException
     */
    private PreparedStatement busquedaDireccion(Connection con, String direccion) throws SQLException {
        String sql = "select * from inmueble where direccion like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, direccion + "%");
        return ps;
    }

    /**
     * Metodo que busca dentro de los registros todos los vecinos que contengan
     * en su nombre el parametro pasado por referencia
     *
     * @param nombre
     * @return
     */
    public Inmueble buscarId(int id) {
        Inmueble i = new Inmueble();

        try {
            Connection conn = conectarBD();
            PreparedStatement stmt = busquedaId(conn, id);
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) {
                    Vecino v = su.buscarId(rs.getInt("vecinoId"));
                    i.setId(rs.getInt("id"));
                    i.setDireccion(rs.getString("direccion"));
                    i.setVecino(v);
                    
                }
            }
        } catch (IOException | ClassNotFoundException | SQLException e) {
            throw new RuntimeException("error SQL", e);
        }

        return i;
    }

    /**
     * Metodo que genera la consulta parametrizada para realizar la busqueda
     * porNombre
     *
     * @param con
     * @param nombre
     * @return
     * @throws SQLException
     */
    private PreparedStatement busquedaId(Connection con, int id) throws SQLException {
        String sql = "select * from imuebles where id like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }

}
