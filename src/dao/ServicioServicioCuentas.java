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
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import modelo.Inmueble;
import modelo.Servicio;
import modelo.ServicioCuenta;

/**
 *
 * 
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
    }

    //Metodos

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
   
    public int ContarInmueblesAsociadosServicio ( Servicio s){
        String sql = "select count(*) from servicioCuentas where idServicio = ?";
        int n = 0;
        try {
            PreparedStatement stmt = ContarInmuebles(conn, s.getId());
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) {
                    n = rs.getInt(1);
                }
                rs.close();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }

        return n;
    }
    private PreparedStatement ContarInmuebles(Connection con, int idServicio) throws SQLException {
        String sql = "select count(*) from servicioCuentas where idServicio = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idServicio);
        return ps;
    }

}
