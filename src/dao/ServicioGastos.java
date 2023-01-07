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
import modelo.Gasto;
import modelo.GastoConcepto;
import modelo.Proveedor;

/**
 *
 * @author fer
 */
public class ServicioGastos {

//Atributos
        private Connection conn;
        private ServicioProveedores sp = new ServicioProveedores();
        private ServicioGastosConcepto sgc = new ServicioGastosConcepto();
    //Constructores
    /**
     * Constructor de la clase
     */
    public ServicioGastos() {
        this.conn = Conexion.conn;
    }

    //Metodos

    public void insertarGastoDB(Gasto g) {
        String sql = "insert into gastos (descripcion, fechaRegistro, idProveedor, comprobante, idConcepto, liquidado, importe) values (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setString(1, g.getDescripcion());
                stmt.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now()));
                stmt.setInt(3, g.getProveedor().getId());
                stmt.setString(4, g.getComprobante());
                stmt.setInt(5, g.getGastoConcepto().getId());
                stmt.setBoolean(6, false);
                stmt.setDouble(7, g.getImporte());
                stmt.execute();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
    }

    public void updateGasto(Gasto g) {
        String sql = "update gastos set descripcion = ? , idProveedor = ?, comprobante = ?, idConcepto = ?, importe = ? where id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setString(1, g.getDescripcion());
                stmt.setInt(2, g.getProveedor().getId());
                stmt.setString(3, g.getComprobante());
                stmt.setInt(4, g.getGastoConcepto().getId());
                stmt.setDouble(5, g.getImporte());
                stmt.setInt(6, g.getId());
                stmt.execute();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
    }
    
    public void liquidarGasto(Gasto g) {
        String sql = "update gastos set liquidado = ? where id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setBoolean(1, true);
                stmt.setInt(2, g.getId());
                stmt.execute();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
    }

    public void borrarGasto(Gasto g) {
        String sql = "delete from gastos where id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setInt(1, g.getId());
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
    public List<Gasto> listarGastos() {
        List<Gasto> lista = new ArrayList();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from gastos");
            while (rs.next()) {
                
                Proveedor p = sp.buscarId(rs.getInt("idProveedor"));
                GastoConcepto gc = sgc.buscarId(rs.getInt("idConcepto"));
                Gasto g = new Gasto (
                        rs.getInt("id"),
                        rs.getString("descripcion"),
                        rs.getDate("fechaRegistro"),
                        rs.getDate("fechaPago"),
                        p,
                        rs.getString("comprobante"),
                        gc,
                        rs.getDouble("importe"),
                        rs.getBoolean("liquidado")    
                );
                lista.add(g);
            }
            rs.close();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
        return lista;
    }

     public List<Gasto> buscarGasto(String descripcion) {
        List<Gasto> lista = new ArrayList();
        try {
            PreparedStatement stmt = busquedaGasto(conn, descripcion);
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) { 
                    Proveedor p = sp.buscarId(rs.getInt("idProveedor"));
                    GastoConcepto gc = sgc.buscarId(rs.getInt("idConcepto"));
                    Gasto g = new Gasto (
                        rs.getInt("id"),
                        rs.getString("descripcion"),
                        rs.getDate("fechaRegistro"),
                        rs.getDate("fechaPago"),
                        p,
                        rs.getString("comprobante"),
                        gc,
                        rs.getDouble("importe"),
                        rs.getBoolean("liquidado")    
                    );
                    lista.add(g);
                }
                rs.close();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }

        return lista;
    }

    
    private PreparedStatement busquedaGasto(Connection con, String descripcion) throws SQLException {
        String sql = "select * from gastos where descripcion like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, descripcion + "%");
        return ps;
    }
    
    public Gasto buscarId(int id) {
        Gasto g = new Gasto();
        try {
            PreparedStatement stmt = busquedaId(conn, id);
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) {
                    Proveedor p = sp.buscarId(rs.getInt("idProveedor"));
                    GastoConcepto gc = sgc.buscarId(rs.getInt("idConcepto"));
                    g.setId(rs.getInt("id"));
                    g.setDescripcion(rs.getString("descripcion"));
                    g.setFechaRegistro(rs.getDate("fechaRegistro"));
                    g.setFechaPago(rs.getDate("fechaPago"));
                    g.setProveedor(p);
                    g.setComprobante(rs.getString("comprobante"));
                    g.setGastoConcepto(gc);
                    g.setImporte(rs.getDouble("importe"));
                    g.setLiquidado(rs.getBoolean("liquidado"));
                }
                rs.close();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }

        return g;
    }

    
    private PreparedStatement busquedaId(Connection con, int id) throws SQLException {
        String sql = "select * from gastos where id like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }
    
    public List<Gasto> buscarGastosAsociadosConcepto (GastoConcepto gc){
        List<Gasto> lista = new ArrayList();
        try {
            PreparedStatement stmt = busquedaGastoAsociadoConcepto(conn, gc.getId());
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) { 
                    Proveedor p = sp.buscarId(rs.getInt("idProveedor"));
                    Gasto g = new Gasto (
                        rs.getInt("id"),
                        rs.getString("descripcion"),
                        rs.getDate("fechaRegistro"),
                        rs.getDate("fechaPago"),
                        p,
                        rs.getString("comprobante"),
                        gc,
                        rs.getDouble("importe"),
                        rs.getBoolean("liquidado")    
                    );
                    lista.add(g);
                }
                rs.close();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }

        return lista;
    }

    
    private PreparedStatement busquedaGastoAsociadoConcepto(Connection con, int idGastoConcepto) throws SQLException {
        String sql = "select * from gastos where idConcepto like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idGastoConcepto);
        return ps;
    }
    
}
