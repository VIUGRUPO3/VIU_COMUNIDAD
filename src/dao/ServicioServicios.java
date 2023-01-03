/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import modelo.Servicio;

/**
 *
 * @author fer
 */
public class ServicioServicios {

    //Atributos
    private ServicioUsuarios su = new ServicioUsuarios();
    private Connection conn;

    //Constructores
    /**
     * Constructor de la clase
     */
    public ServicioServicios() {
        this.conn = Conexion.conn;

    }

    //Metodos


    
    public void insertarServicioDB(Servicio s) {
        String sql = "insert into servicios (nombre, tarifa, opcional) values (?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setString(1, s.getNombre());
                stmt.setDouble(2, s.getTarifa());
                stmt.setBoolean(3, s.isOpcional());
                stmt.execute();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
    }
    
    public Servicio obtenerUltimoServicio(){
        int idServicio = 0;
        try {
            Statement stmt3 = conn.createStatement();
            ResultSet rs = stmt3.executeQuery("select * from servicios where  id=(select max(id) from servicios)");
            while (rs.next()) {
                idServicio = rs.getInt("id");
            }
            rs.close();
            stmt3.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServicioServicios.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        Servicio s = buscarId(idServicio);
        return s;
    }

    public void updateServicio(Servicio s) {
        String sql = "update servicios set nombre = ? , tarifa = ?, opcional = ? where id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setString(1, s.getNombre());
                stmt.setDouble(2, s.getTarifa());
                stmt.setBoolean(3, s.isOpcional());
                stmt.setInt(4, s.getId());
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
    public void borrarServicio(Servicio s) {
        String sql = "delete from servicios where id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setInt(1, s.getId());
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
    public List<Servicio> listarServicios() {
        List<Servicio> lista = new ArrayList();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from servicios");
            while (rs.next()) {
                lista.add(new Servicio(
                        rs.getInt("id"),
                        rs.getString("nombre"), 
                        rs.getDouble("tarifa"),
                        rs.getBoolean("opcional")
                ));
            }
            rs.close();
            stmt.close();

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
    public List<Servicio> buscarServicios(String nombre) {
        List<Servicio> lista = new ArrayList();
        try {
            PreparedStatement stmt = busquedaServicios(conn, nombre);
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) {
                    lista.add(new Servicio(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getDouble("tarifa"),
                            rs.getBoolean("opcional")
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

    /**
     * Metodo que genera la consulta parametrizada para realizar la busqueda
     * porNombre
     *
     * @param con
     * @param nombre
     * @return
     * @throws SQLException
     */
    private PreparedStatement busquedaServicios(Connection con, String nombre) throws SQLException {
        String sql = "select * from servicios where nombre like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nombre + "%");
        return ps;
    }
    
    public List<Servicio> buscarServiciosOpcionales(String nombre) {
        List<Servicio> lista = new ArrayList();
        try {
            PreparedStatement stmt = busquedaServiciosOpcionales(conn, nombre);
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) {
                    lista.add(new Servicio(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getDouble("tarifa"),
                            rs.getBoolean("opcional")
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

    /**
     * Metodo que genera la consulta parametrizada para realizar la busqueda
     * porNombre
     *
     * @param con
     * @param nombre
     * @return
     * @throws SQLException
     */
    private PreparedStatement busquedaServiciosOpcionales(Connection con, String nombre) throws SQLException {
        String sql = "select * from servicios where opcional = ? and nombre like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setBoolean(1, true);
        ps.setString(2, nombre + "%");
        return ps;
    }

    /**
     * Metodo que busca dentro de los registros todos los vecinos que contengan
     * en su nombre el parametro pasado por referencia
     *
     * @param nombre
     * @return
     */
    public Servicio buscarId(int id) {
        Servicio s = new Servicio();
        try {
            PreparedStatement stmt = busquedaId(conn, id);
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) {
                    s.setId(rs.getInt("id"));
                    s.setNombre(rs.getString("nombre"));
                    s.setTarifa(rs.getDouble("tarifa"));
                    s.setOpcional(rs.getBoolean("opcional"));
                }
                rs.close();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }

        return s;
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
        String sql = "select * from servicios where id like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }

}
