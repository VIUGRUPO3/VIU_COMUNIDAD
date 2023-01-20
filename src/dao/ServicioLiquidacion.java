// Asignatura: 21GIIN Proyectos Programación
// Profesor: Eduardo Zamudio
// @author: Grupo 3
// Miembros:
//       @author:Fernando Hernandez Fernandez
//       @author:Javier Barbero Sales
//       @author:Martin Gonzalez Dominguez
// @version: 01/12/2022/

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
import modelo.ServicioCuenta;

/**
 *
 * 
 */
public class ServicioLiquidacion {

//Atributos
    private Connection conn;
    ServicioInmuebles si = new ServicioInmuebles();
    ServicioServicios ss = new ServicioServicios();
    ServicioServicioCuentas ssc = new ServicioServicioCuentas();

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
        String sql = "insert into liquidacionDetalleServicio (idServicioCuenta, cuota, idLiquidacion) values (?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setInt(1, lds.getSc().getId());
                stmt.setDouble(2, lds.getCuota());
                stmt.setInt(3, lds.getLiquidacion().getId());
                stmt.execute();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
    }

    public void insertarLiquidacionDetalleGastoDB(LiquidacionDetalleGasto ldg) {
        String sql = "insert into liquidacionDetalleGasto (idServicioCuenta, cuota, idLiquidacion, gastoConcepto) values (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setInt(1, ldg.getSc().getId());
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
                    ServicioCuenta sc = ssc.buscarId(rs.getInt("idServicioCuenta"));
                    LiquidacionDetalleServicio lds = new LiquidacionDetalleServicio(
                            l,
                            sc,
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
                    ServicioCuenta sc = ssc.buscarId(rs.getInt("idServicioCuenta"));
                    LiquidacionDetalleGasto ldg = new LiquidacionDetalleGasto(
                            rs.getString("gastoConcepto"),
                            l,
                            sc,
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

    public List<Liquidacion> buscarLiquidacionInmueble(int idServicioCuenta) {
        List<Liquidacion> lista = new ArrayList();
        Liquidacion l = null;
        ServicioCuenta sc = ssc.buscarId(idServicioCuenta);
        try {
            PreparedStatement stmt = busquedaLiquidacionInmueble(conn, idServicioCuenta);
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
    private PreparedStatement busquedaLiquidacionInmueble(Connection con, int idServicioCuenta) throws SQLException {
        String sql = "select * from liquidacionDetalleServicio where idServicioCuenta like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idServicioCuenta);
        return ps;
    }

    public List<LiquidacionDetalleServicio> buscarLiquidacionDetalleServicioInmueble(int idServicioCuenta, int idLiquidacion) {
        List<LiquidacionDetalleServicio> lista = new ArrayList();
        try {
            PreparedStatement stmt = busquedaLiquidacionDetalleServicioInmueble(conn, idServicioCuenta, idLiquidacion);
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) {
                    Liquidacion l = buscarId(idLiquidacion);
                    ServicioCuenta sc = ssc.buscarId(idServicioCuenta);
                    LiquidacionDetalleServicio lds = new LiquidacionDetalleServicio(
                            l,
                            sc,
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
    private PreparedStatement busquedaLiquidacionDetalleServicioInmueble(Connection con, int idServicioCuenta, int idLiquidacion) throws SQLException {
        String sql = "select * from liquidacionDetalleServicio where idServicioCuenta like ? and idLiquidacion like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idServicioCuenta);
        ps.setInt(2, idLiquidacion);
        return ps;
    }
    
    public List<LiquidacionDetalleGasto> buscarLiquidacionDetalleGastoInmueble(int idServicioCuenta, int idLiquidacion) {
        List<LiquidacionDetalleGasto> lista = new ArrayList();
        try {
            PreparedStatement stmt = busquedaLiquidacionDetalleGastoInmueble(conn, idServicioCuenta, idLiquidacion);
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) {
                    Liquidacion l = buscarId(idLiquidacion);
                    ServicioCuenta sc = ssc.buscarId(idServicioCuenta);                   
                    LiquidacionDetalleGasto ldg = new LiquidacionDetalleGasto(
                            rs.getString("GastoConcepto"),
                            l,
                            sc,
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
