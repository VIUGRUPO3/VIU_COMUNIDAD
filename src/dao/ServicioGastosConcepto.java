/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import modelo.GastoConcepto;
import modelo.GastoConceptoSimple;
import modelo.Servicio;

/**
 *
 * @author fer
 */
public class ServicioGastosConcepto {

//Atributos
        private Connection conn;
        private ServicioServicios ss = new ServicioServicios();
    //Constructores
    /**
     * Constructor de la clase
     */
    public ServicioGastosConcepto() {
        this.conn = Conexion.conn;
    }

    //Metodos

    public void insertarGastoConceptoDB(GastoConcepto gc) {
        String sql = "insert into gastosConcepto (nombre, idServicio) values (?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setString(1, gc.getNombre());
                stmt.setInt(2, gc.getServicio().getId());
                stmt.execute();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
    }

    public void updateGastoConcepto(GastoConcepto gc) {
        String sql = "update gastosConcepto set nombre = ? , idServicio = ? where id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setString(1, gc.getNombre());
                stmt.setInt(2, gc.getServicio().getId());
                stmt.setInt(3, gc.getId());
                stmt.execute();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
    }

    public void borrarGastoConcepto(GastoConcepto gc) {
        String sql = "delete from gastosConcepto where id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setInt(1, gc.getId());
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
    public List<GastoConcepto> listarGastosConceptos() {
        List<GastoConcepto> lista = new ArrayList();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from gastosConcepto");
            while (rs.next()) {
                
                Servicio s = ss.buscarId(rs.getInt("idServicio"));
                GastoConcepto gc = new GastoConceptoSimple (rs.getString("nombre"),s);
                lista.add(gc);
            }
            rs.close();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
        return lista;
    }

     public List<GastoConcepto> buscarGastoConcepto(String nombre) {
        List<GastoConcepto> lista = new ArrayList();
        try {
            PreparedStatement stmt = busquedaGastoConcepto(conn, nombre);
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) {
                    
                    Servicio s = ss.buscarId(rs.getInt("idServicio"));
                    GastoConcepto gc = new GastoConceptoSimple (rs.getInt("id"),rs.getString("nombre"),s);
                    lista.add(gc);
                }
                rs.close();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }

        return lista;
    }

    
    private PreparedStatement busquedaGastoConcepto(Connection con, String nombre) throws SQLException {
        String sql = "select * from gastosConcepto where nombre like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nombre + "%");
        return ps;
    }
    
    public GastoConcepto buscarId(int id) {
        GastoConcepto gc = new GastoConceptoSimple();
        try {
            PreparedStatement stmt = busquedaId(conn, id);
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) {
                    
                    Servicio s = ss.buscarId(rs.getInt("idServicio"));
                    gc.setId(rs.getInt("id"));
                    gc.setNombre(rs.getString("nombre"));
                    gc.setServicio(s);
                    
                }
                rs.close();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }

        return gc;
    }

    
    private PreparedStatement busquedaId(Connection con, int id) throws SQLException {
        String sql = "select * from gastosConcepto where id like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }

    public List<GastoConcepto> buscarConceptosServicio(int idServicio) {
        List<GastoConcepto> lista = new ArrayList();
        try {
            PreparedStatement stmt = busquedaConceptosServicio(conn, idServicio);
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) {
                    
                    Servicio s = ss.buscarId(idServicio);
                    GastoConcepto gc = new GastoConceptoSimple (rs.getInt("id"), rs.getString("nombre"),s);
                    lista.add(gc);
                }
                rs.close();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }

        return lista;
    }

    
    private PreparedStatement busquedaConceptosServicio(Connection con, int idServicio) throws SQLException {
        String sql = "select * from gastosConcepto where idServicio = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idServicio);
        return ps;
    }
   
    public void insertarJerarquia(int idConceptoPadre,int idConceptoHijo){
        String sql = "insert into gastosCompuesto (idGastoConcepto, idConceptoPadre) values (?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setInt(1, idConceptoHijo);
                stmt.setInt(2, idConceptoPadre);
                stmt.execute();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
    }
    
    public void updateJerarquia(int idConceptoPadre,int idConceptoHijo) {
        String sql = "update gastosCompuesto set idConceptoPadre = ?  where idGastoConcepto = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setInt(1, idConceptoPadre);
                stmt.setInt(2, idConceptoHijo);
                stmt.execute();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
    }
    
    public boolean existeIdJerarquia(int id) {
        try {
            PreparedStatement stmt = busquedaIdJerarquia(conn, id);
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) {
                    return true;
                }
                rs.close();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
        return false;
    }

    
    private PreparedStatement busquedaIdJerarquia(Connection con, int id) throws SQLException {
        String sql = "select * from gastosCompuesto where idGastoConcepto like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }
    
    public List<GastoConcepto> buscarConceptosHijos(int idPadre) {
        List<GastoConcepto> lista = new ArrayList();
        try {
            PreparedStatement stmt = busquedaConceptosHijos(conn, idPadre);
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) {
                    GastoConcepto gc = buscarId(rs.getInt("idGastoConcepto"));
                    lista.add(gc);
                }
                rs.close();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }

        return lista;
    }

    
    private PreparedStatement busquedaConceptosHijos(Connection con, int idPadre) throws SQLException {
        String sql = "select * from gastosCompuesto where idConceptoPadre = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idPadre);
        return ps;
    }
    
    public GastoConcepto buscarConceptosPadre(int idHijo) {
        GastoConcepto  gc = null;
        try {
            PreparedStatement stmt = busquedaConceptosPadres(conn, idHijo);
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) {
                    gc = buscarId(rs.getInt("idConceptoPadre"));
                    
                }
                rs.close();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }

        return gc;
    }

    
    private PreparedStatement busquedaConceptosPadres(Connection con, int idHijo) throws SQLException {
        String sql = "select * from gastosCompuesto where idGastoConcepto = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idHijo);
        return ps;
    }
    
    public void borrarJerarquia(GastoConcepto gc) {
        String sql = "delete from gastosCompuesto where idGastoConcepto = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setInt(1, gc.getId());
                stmt.execute();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
    }

}
