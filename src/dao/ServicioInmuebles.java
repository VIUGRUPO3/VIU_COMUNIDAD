/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.usuario.Vecino;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import modelo.Inmueble;


/**
 *
 * @author fer
 */
public class ServicioInmuebles {

    //Atributos
    private ServicioUsuarios su = new ServicioUsuarios();
    private Connection conn;
    //Constructores
    /**
     * Constructor de la clase
     */
    public ServicioInmuebles() {
        this.conn = Conexion.conn;
    }

    //Metodos

    public void insertarInmuebleDB(Inmueble i) {
        String sql = "insert into inmuebles (direccion) values (?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setString(1, i.getDireccion());
                stmt.execute();
                stmt.close();
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
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
    }

    
    public void borrarInmueble(Inmueble i) {
        String sql = "delete from inmuebles where id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setInt(1, i.getId());
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
    public List<Inmueble> listarInmuebles() {
        List<Inmueble> lista = new ArrayList();
        Vecino v = null;
        try {            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from inmuebles");
            while (rs.next()) {
                if (rs.getInt("vecinoId") > 0) {
                        v = su.buscarId(rs.getInt("vecinoId"));
                    } else {
                        v = null;
                    }
                lista.add(new Inmueble(rs.getInt("id"),
                        v, rs.getString("direccion")
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
                rs.close();
                stmt.close();
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
    
    public List<Inmueble> buscarInmueblesVecino(int vecinoId) {
        List<Inmueble> lista = new ArrayList();
        Vecino v = null;
        try {
            PreparedStatement stmt = busquedaInmueblesVecino(conn, vecinoId);
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) {
                    v = su.buscarId(rs.getInt("vecinoId"));
                    lista.add(new Inmueble(rs.getInt("id"),
                            v, rs.getString("direccion")));
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
    private PreparedStatement busquedaInmueblesVecino(Connection con, int vecinoId) throws SQLException {
        String sql = "select * from inmuebles where vecinoId like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, vecinoId);
        return ps;
    }
    
    
   

}
