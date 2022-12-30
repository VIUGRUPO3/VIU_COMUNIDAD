/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Inmueble;
import modelo.Servicio;
import modelo.ServicioCuenta;

/**
 *
 * @author fer
 */
public class ServicioServicioCuentas {

//Atributos
        private Connection conn;
        ServicioInmuebles si = new ServicioInmuebles();
        ServicioServicios ss = new ServicioServicios();
    //Constructores
    /**
     * Constructor de la clase
     */
    public ServicioServicioCuentas() {
        this.conn = Conexion.conn;
//        try {
//            this.conn = conectarBD();
//        } catch (IOException | ClassNotFoundException ex) {
//            Logger.getLogger(ServicioServicioCuentas.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    //Metodos
    /**
     * Metodo que conecta con la base de datos de servidor
     *
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
//    private Connection conectarBD() throws IOException, ClassNotFoundException {
//        InputStream config;
//        try {
//            config = new FileInputStream("./src/resources/config.properties");
//            Properties prop = new Properties();
//            prop.load(config);
//            String dbURL = prop.getProperty("db.url");
//            String dbUser = prop.getProperty("db.user");
//            String dbPassword = prop.getProperty("db.password");
//
//            ConexionDB conDB = new ConexionDB(dbURL, dbUser, dbPassword);
//            Connection conn = conDB.getConnection();
//            return conn;
//
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ServicioServicioCuentas.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }

    /**
     * Metodo que inserta una instancia de la clase Vecino en la base de datos
     *
     * @param vecino Objeto de la clase Vecino
     */
    public void insertarServicioCuentaDB(ServicioCuenta sc) {
        String sql = "insert into servicioCuentas (idInmueble, idServicio, fechaAlta) values (?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setInt(1, sc.getInmueble().getId());
                stmt.setInt(2, sc.getServicio().getId());
                stmt.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
                stmt.execute();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
    }

    public void updateServicioCuenta(ServicioCuenta sc) {
        String sql = "update servicioCuentas set idInmueble = ? , idServicio = ?, fechaAlta = ?, fechaBaja = ? where idInmueble = ? and idServicio = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setInt(1, sc.getInmueble().getId());
                stmt.setInt(2, sc.getServicio().getId());
                stmt.setDate(3, (Date) sc.getFechaAlta());
                stmt.setDate(4, (Date) sc.getFechaBaja());
                stmt.setInt(5, sc.getInmueble().getId());
                stmt.setInt(6, sc.getServicio().getId());
                stmt.execute();
                stmt.close();
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
    public void borrarServicioCuenta(ServicioCuenta sc) {
        String sql = "delete from servicioCuentas where idInmueble = ? and idServicio = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setInt(1, sc.getInmueble().getId());
                stmt.setInt(2, sc.getServicio().getId());
                stmt.execute();
                stmt.close();
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
    public List<ServicioCuenta> listarServicioCuenta() {
        List<ServicioCuenta> lista = new ArrayList();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from servicioCuentas");
            while (rs.next()) {
                Inmueble i = si.buscarId(rs.getInt("idInmueble"));
                Servicio s = ss.buscarId(rs.getInt("idServicio"));
                lista.add(new ServicioCuenta(
                        i,
                        s, 
                        rs.getDate("fechaAlta"),
                        rs.getDate("fechaBaja")
                ));
            }
            rs.close();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
        return lista;
    }

    
    public List<ServicioCuenta> buscarServiciosInmueble(int idInmueble) {
        List<ServicioCuenta> lista = new ArrayList();
        try {
            PreparedStatement stmt = busquedaServiciosInmueble(conn, idInmueble);
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) {
                    Inmueble i = si.buscarId(idInmueble);
                    Servicio s = ss.buscarId(rs.getInt("idServicio"));
                    lista.add(new ServicioCuenta(
                            i,
                            s,
                            rs.getDate("fechaAlta"),
                            rs.getDate("fechaBaja")
                    ));
                }
                rs.close();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }

        return lista;
    }

    
    private PreparedStatement busquedaServiciosInmueble(Connection con, int idInmueble) throws SQLException {
        String sql = "select * from servicioCuentas where idInmueble = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idInmueble);
        return ps;
    }

    public List<ServicioCuenta> buscarInmublesServicios(int idServicio) {
        List<ServicioCuenta> lista = new ArrayList();
        try {
            PreparedStatement stmt = busquedaInmueblesServicios(conn, idServicio);
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) {
                    Inmueble i = si.buscarId(rs.getInt("idInmueble"));
                    Servicio s = ss.buscarId(idServicio);
                    lista.add(new ServicioCuenta(
                            i,
                            s,
                            rs.getDate("fechaAlta"),
                            rs.getDate("fechaBaja")
                    ));
                }
                rs.close();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }

        return lista;
    }

    
    private PreparedStatement busquedaInmueblesServicios(Connection con, int idServicio) throws SQLException {
        String sql = "select * from servicioCuentas where idServicio = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idServicio);
        return ps;
    }
   

}
