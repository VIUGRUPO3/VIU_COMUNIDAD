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
import modelo.Proveedor;

/**
 *
 * @author fer
 */
public class ServicioProveedores {

//Atributos
    private Connection conn;

    //Constructores
    /**
     * Constructor de la clase
     */
    public ServicioProveedores() {
        this.conn = Conexion.conn;
    }

    public void insertarProveedorDB(Proveedor p) {
        String sql = "insert into proveedores (nombre, direccion, telefono, email) values (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setString(1, p.getNombre());
                stmt.setString(2, p.getDireccion());
                stmt.setString(3, p.getTelefono());
                stmt.setString(4, p.getEmail());
                stmt.execute();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
    }

    public void updateProveedor(Proveedor p) {
        String sql = "update proveedores set nombre = ? , direccion = ?, telefono = ?, email = ?  where id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setString(1, p.getNombre());
                stmt.setString(2, p.getDireccion());
                stmt.setString(3, p.getTelefono());
                stmt.setString(4, p.getEmail());
                stmt.setInt(5, p.getId());
                stmt.execute();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
    }

    public void borrarProveedor(Proveedor p) {
        String sql = "delete from proveedores where id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setInt(1, p.getId());
                stmt.execute();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
    }

    public List<Proveedor> listarProveedores() {
        List<Proveedor> lista = new ArrayList();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from proveedores");
            while (rs.next()) {
                lista.add(new Proveedor(
                        rs.getInt("id"),
                        rs.getString("nombre"), 
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("email")
                ));
            }
            rs.close();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
        return lista;
    }

    public List<Proveedor> buscarProveedor(String nombre) {
        List<Proveedor> lista = new ArrayList();
        try {
            PreparedStatement stmt = busquedaProveedores(conn, nombre);
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) {
                    lista.add(new Proveedor(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("direccion"),
                            rs.getString("telefono"),
                            rs.getString("email")
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

    private PreparedStatement busquedaProveedores(Connection con, String nombre) throws SQLException {
        String sql = "select * from proveedores where nombre like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nombre + "%");
        return ps;
    }

    public Proveedor buscarId(int id) {
        Proveedor p = new Proveedor();
        try {
            PreparedStatement stmt = busquedaId(conn, id);
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) {
                    p.setId(rs.getInt("id"));
                    p.setNombre(rs.getString("nombre"));
                    p.setDireccion(rs.getString("direccion"));
                    p.setTelefono(rs.getString("telefono"));
                    p.setEmail(rs.getString("email"));
                }
                rs.close();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }

        return p;
    }

    private PreparedStatement busquedaId(Connection con, int id) throws SQLException {
        String sql = "select * from proveedores where id like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }

}
