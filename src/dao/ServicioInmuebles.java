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
    private Connection conn;
    //Constructores
    /**
     * Constructor de la clase
     */
    public ServicioInmuebles() {
        try {
            this.conn = conectarBD();
        } catch (IOException ex) {
            Logger.getLogger(ServicioInmuebles.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServicioInmuebles.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        String sql = "insert into inmuebles (direccion) values (?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setString(1, i.getDireccion());
                stmt.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
    }

    public void updateInmueble(Inmueble i) {
        String sql = "";
        if (i.getVecino() != null) {
            sql = "update inmuebles set direccion = ? , vecinoId = ? where id = ?";
        } else {
            sql = "update inmuebles set direccion = ?  where id = ?";
        }
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setString(1, i.getDireccion());
                if (i.getVecino() != null) {
                    stmt.setInt(2, i.getVecino().getId());
                    stmt.setInt(3, i.getId());
                } else {

                    stmt.setInt(2, i.getId());
                }
                stmt.execute();
            }
        } catch (SQLException e) {
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
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setInt(1, i.getId());
                stmt.execute();
            }
        } catch (SQLException e) {
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
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from inmuebles");
            while (rs.next()) {
                Vecino v = su.buscarId(rs.getInt("vecinoId"));
                lista.add(new Inmueble(rs.getInt("id"),
                        v, rs.getString("direccion")
                ));
            }
            System.out.println(lista);

        } catch (SQLException e) {
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
        Vecino v = null;
        try {
            PreparedStatement stmt = busquedaDireccion(conn, direccion);
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) {
                    if (rs.getInt("vecinoId") > 0) {
                        v = su.buscarId(rs.getInt("vecinoId"));
                    } else {
                        v = null;
                    }

                    lista.add(new Inmueble(rs.getInt("id"),
                            v, rs.getString("direccion")));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }

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
        String sql = "select * from inmuebles where direccion like ?";
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
        Vecino v = null;
        try {
            PreparedStatement stmt = busquedaId(conn, id);
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) {
                    if (rs.getInt("vecinoId") > 0) {
                        v = su.buscarId(rs.getInt("vecinoId"));
                    } else {
                        v = null;
                    }

                    i.setId(rs.getInt("id"));
                    i.setDireccion(rs.getString("direccion"));
                    i.setVecino(v);

                }
            }
        } catch (SQLException e) {
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
        String sql = "select * from inmuebles where id like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }
    
    public List<Inmueble> listarInmueblesLibres() {
        List<Inmueble> lista = new ArrayList();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from inmuebles where vecinoId is null");
            while (rs.next()) {
                Vecino v = null;
                lista.add(new Inmueble(rs.getInt("id"),
                        v, rs.getString("direccion")
                ));
            }
            

        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
        return lista;
    }
    
    public List<Inmueble> listarVecinosAsignar() {
        List<Inmueble> lista = new ArrayList();
        try {
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from inmuebles where vecinoId is null");
            while (rs.next()) {
                Vecino v = null;
                lista.add(new Inmueble(rs.getInt("id"),
                        v, rs.getString("direccion")
                ));
            }
            

        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
        return lista;
    }

}
