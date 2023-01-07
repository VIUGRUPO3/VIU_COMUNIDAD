/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Inmueble;
import modelo.Liquidacion;
import modelo.LiquidacionDetalleGasto;
import modelo.LiquidacionDetalleServicio;
import modelo.Servicio;

/**
 *
 * @author fer
 */
public class ServicioLiquidacion {

//Atributos
    private Connection conn;
    ServicioInmuebles si = new ServicioInmuebles();
    ServicioServicios ss = new ServicioServicios();

    //Constructores
    /**
     * Constructor de la clase
     */
    public ServicioLiquidacion() {
        this.conn = Conexion.conn;
    }

    //Metodos
    public void insertarLiquidacionDB(Liquidacion l) {
        String sql = "insert into liquidaciones (fechaInicio, fechaFin) values (?, ?)";
        Date fechaInicio = Date.from(l.getFechaInicio().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date fechaFin = Date.from(l.getFechaFin().atStartOfDay(ZoneId.systemDefault()).toInstant());
        java.sql.Date fechaInicioSql = new java.sql.Date(fechaInicio.getTime());
        java.sql.Date fechaFinSql = new java.sql.Date(fechaFin.getTime());
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setDate(1, fechaInicioSql);
                stmt.setDate(2, fechaFinSql);
                stmt.execute();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
    }

    public Liquidacion ultimoIdLiquidacion() {
        int idLiquidacion = 0;
        try {
            Statement stmt3 = conn.createStatement();
            ResultSet rs = stmt3.executeQuery("select * from liquidaciones where  id=(select max(id) from liquidaciones)");
            while (rs.next()) {
                idLiquidacion = rs.getInt("id");
            }
            rs.close();
            stmt3.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServicioServicios.class.getName()).log(Level.SEVERE, null, ex);
        }

        Liquidacion l = buscarId(idLiquidacion);
        return l;
    }

    public void insertarLiquidacionDetalleServicioDB(LiquidacionDetalleServicio lds) {
        String sql = "insert into liquidacionDetalleServicio (idInmueble, cuota, idLiquidacion, idServicio) values (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setInt(1, lds.getInmueble().getId());
                stmt.setDouble(2, lds.getServicio().getTarifa());
                stmt.setInt(3, lds.getLiquidacion().getId());
                stmt.setInt(4, lds.getServicio().getId());
                stmt.execute();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
    }

    public void insertarLiquidacionDetalleGastoDB(LiquidacionDetalleGasto ldg) {
        String sql = "insert into liquidacionDetalleGasto (idInmueble, cuota, idLiquidacion, gastoConcepto) values (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setInt(1, ldg.getInmueble().getId());
                stmt.setDouble(2, ldg.getCuota());
                stmt.setInt(3, ldg.getLiquidacion().getId());
                stmt.setString(4, ldg.getGastoLiquidacion());
                stmt.execute();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
    }

    private LocalDate utilDateToLocalDate(java.util.Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public Liquidacion buscarId(int id) {
        Liquidacion l = new Liquidacion();
        try {
            PreparedStatement stmt = busquedaId(conn, id);
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) {
                    Date fechaInicioDate = new Date(rs.getDate("fechaInicio").getTime());
                    Date fechaFinDate = new Date(rs.getDate("fechaFin").getTime());
                    LocalDate fechaInicio = utilDateToLocalDate(fechaInicioDate);
                    LocalDate fechaFin = utilDateToLocalDate(fechaFinDate);
                    l.setId(rs.getInt("id"));
                    l.setFechaInicio(fechaInicio);
                    l.setFechaFin(fechaFin);

                }
                rs.close();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }

        return l;
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
        String sql = "select * from liquidaciones where id like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }

    public List<Liquidacion> buscarLiquidacion(Date fecha) {
        List<Liquidacion> lista = new ArrayList();
        try {
            PreparedStatement stmt = busquedaLiquidacion(conn, fecha);
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) {
                    Date fechaInicioDate = new Date(rs.getDate("fechaInicio").getTime());
                    Date fechaFinDate = new Date(rs.getDate("fechaFin").getTime());
                    LocalDate fechaInicio = utilDateToLocalDate(fechaInicioDate);
                    LocalDate fechaFin = utilDateToLocalDate(fechaFinDate);
                    Liquidacion l = new Liquidacion(rs.getInt("id"), fechaInicio, fechaFin);
                    lista.add(l);

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
    private PreparedStatement busquedaLiquidacion(Connection con, Date fecha) throws SQLException {
        String sql = "select * from liquidaciones where fechaInicio <= ? and fechaFin >= ?";
        PreparedStatement ps = con.prepareStatement(sql);
        java.sql.Date fechaSql = new java.sql.Date(fecha.getTime());
        ps.setDate(1, fechaSql);
        ps.setDate(2, fechaSql);
        return ps;
    }

    public List<LiquidacionDetalleServicio> buscarLiquidacionDetalleServicio(Liquidacion l) {
        List<LiquidacionDetalleServicio> lista = new ArrayList();
        try {
            PreparedStatement stmt = busquedaLiquidacionDetalleServicio(conn, l);
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) {
                    Servicio s = ss.buscarId(rs.getInt("idServicio"));
                    Inmueble i = si.buscarId(rs.getInt("idInmueble"));
                    LiquidacionDetalleServicio lds = new LiquidacionDetalleServicio(
                            s,
                            l,
                            i,
                            rs.getDouble("cuota")
                    );
                    lista.add(lds);

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
    private PreparedStatement busquedaLiquidacionDetalleServicio(Connection con, Liquidacion l) throws SQLException {
        String sql = "select * from liquidacionDetalleServicio where idLiquidacion like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, l.getId());
        return ps;
    }

    public List<LiquidacionDetalleGasto> buscarLiquidacionDetalleGasto(Liquidacion l) {
        List<LiquidacionDetalleGasto> lista = new ArrayList();
        try {
            PreparedStatement stmt = busquedaLiquidacionDetalleGasto(conn, l);
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) {

                    Inmueble i = si.buscarId(rs.getInt("idInmueble"));
                    LiquidacionDetalleGasto ldg = new LiquidacionDetalleGasto(
                            rs.getString("gastoConcepto"),
                            l,
                            i,
                            rs.getDouble("cuota")
                    );
                    lista.add(ldg);

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
    private PreparedStatement busquedaLiquidacionDetalleGasto(Connection con, Liquidacion l) throws SQLException {
        String sql = "select * from liquidacionDetalleGasto where idLiquidacion like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, l.getId());
        return ps;
    }

    public List<Liquidacion> listarLiquidaciones() {
        List<Liquidacion> lista = new ArrayList();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from liquidaciones");
            while (rs.next()) {
                Date fechaInicioDate = new Date(rs.getDate("fechaInicio").getTime());
                Date fechaFinDate = new Date(rs.getDate("fechaFin").getTime());
                LocalDate fechaInicio = utilDateToLocalDate(fechaInicioDate);
                LocalDate fechaFin = utilDateToLocalDate(fechaFinDate);
                lista.add(new Liquidacion(
                        rs.getInt("id"),
                        fechaInicio,
                        fechaFin
                ));
            }
            rs.close();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
        return lista;
    }

    public List<Liquidacion> buscarLiquidacionInmueble(int idInmueble) {
        List<Liquidacion> lista = new ArrayList();
        Liquidacion l = null;
        try {
            PreparedStatement stmt = busquedaLiquidacionInmueble(conn, idInmueble);
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) {
                    l = buscarId(rs.getInt("idLiquidacion"));
                }
                lista.add(l);
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
    private PreparedStatement busquedaLiquidacionInmueble(Connection con, int idInmueble) throws SQLException {
        String sql = "select * from liquidacionDetalleServicio where idInmueble like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idInmueble);
        return ps;
    }

    public List<LiquidacionDetalleServicio> buscarLiquidacionDetalleServicioInmueble(int idInmueble, int idLiquidacion) {
        List<LiquidacionDetalleServicio> lista = new ArrayList();
        try {
            PreparedStatement stmt = busquedaLiquidacionDetalleServicioInmueble(conn, idInmueble, idLiquidacion);
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) {
                    Liquidacion l = buscarId(idLiquidacion);
                    Inmueble i = si.buscarId(idInmueble);
                    Servicio s = ss.buscarId(rs.getInt("idServicio"));
                    LiquidacionDetalleServicio lds = new LiquidacionDetalleServicio(
                            s,
                            l,
                            i,
                            rs.getDouble("cuota")
                    );
                    lista.add(lds);
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
    private PreparedStatement busquedaLiquidacionDetalleServicioInmueble(Connection con, int idInmueble, int idLiquidacion) throws SQLException {
        String sql = "select * from liquidacionDetalleServicio where idInmueble like ? and idLiquidacion like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idInmueble);
        ps.setInt(2, idLiquidacion);
        return ps;
    }
    
    public List<LiquidacionDetalleGasto> buscarLiquidacionDetalleGastoInmueble(int idInmueble, int idLiquidacion) {
        List<LiquidacionDetalleGasto> lista = new ArrayList();
        try {
            PreparedStatement stmt = busquedaLiquidacionDetalleGastoInmueble(conn, idInmueble, idLiquidacion);
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) {
                    Liquidacion l = buscarId(idLiquidacion);
                    Inmueble i = si.buscarId(idInmueble);                   
                    LiquidacionDetalleGasto ldg = new LiquidacionDetalleGasto(
                            rs.getString("GastoConcepto"),
                            l,
                            i,
                            rs.getDouble("cuota")
                    );
                    lista.add(ldg);
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
    private PreparedStatement busquedaLiquidacionDetalleGastoInmueble(Connection con, int idInmueble, int idLiquidacion) throws SQLException {
        String sql = "select * from liquidacionDetalleGasto where idInmueble like ? and idLiquidacion like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idInmueble);
        ps.setInt(2, idLiquidacion);
        return ps;
    }

}
