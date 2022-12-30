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
import modelo.usuario.Admin;

/**
 *
 * @author fer
 */
public class ServicioUsuarios {
    
    private Connection conn;
    //Constructores
    /**
     * Constructor de la clase
     */
    public ServicioUsuarios() {
        try {
            this.conn = conectarBD();
        } catch (IOException ex) {
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//Atributos
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
            conn = conDB.getConnection();
            return conn;

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Metodo que inserta una instancia de la clase Vecino en la base de datos
     *
     * @param vecino Objeto de la clase Vecino
     */
    public void insertarVecinoDB(Vecino vecino) {
        int idUser = 0;
        String sql = "insert into usuarios (nombre, apellidos, userName, clave, telefono, email) values (?,?,?,?,?,?)";
        String sql2 = "insert into usuarios_roles (nombre, role, idUser) values (?,?,?)";
        try {
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setString(1, vecino.getNombre());
                stmt.setString(2, vecino.getApellidos());
                stmt.setString(3, vecino.getUserName());
                stmt.setString(4, vecino.getClave());
                stmt.setString(5, vecino.getTelefono());
                stmt.setString(6, vecino.getEmail());
                stmt.execute();
                Statement stmt3 = conn.createStatement();
                ResultSet rs = stmt3.executeQuery("select * from usuarios where  id=(select max(id) from usuarios)");
                while (rs.next()) {
                    idUser = rs.getInt("id");
                }
                rs.close();
                stmt3.close();
                stmt.close();
            }
            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            {
                stmt2.setString(1, vecino.getNombre());
                stmt2.setString(2, "vecino");
                stmt2.setInt(3, idUser);
                stmt2.execute();
                stmt2.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
    }
    
    
    public void updateUsuario(Vecino v) {
        String sql = "update usuarios set nombre = ? , apellidos = ?, userName =?, clave =?, telefono =?, email =? where id = ?";
        String sql2 = "update usuarios_roles set nombre = ? where idUser = ?";
        try {
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setString(1, v.getNombre());
                stmt.setString(2, v.getApellidos());
                stmt.setString(3, v.getUserName());
                stmt.setString(4, v.getClave());
                stmt.setString(5, v.getTelefono());
                stmt.setString(6, v.getEmail());
                stmt.setInt(7, v.getId());
                stmt.execute();
                stmt.close();
            }
            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            {
                stmt2.setString(1, v.getNombre());
                stmt2.setInt(2, v.getId());
                stmt2.execute();
                stmt2.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
    }

    
    public void insertarAdminDB(Admin admin) {
        int idUser = 0;
        String sql = "insert into usuarios (nombre, apellidos, userName, clave, telefono, email) values (?,?,?,?,?,?)";
        String sql2 = "insert into usuarios_roles (nombre, role, idUser) values (?,?,?)";
        try {
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setString(1, admin.getNombre());
                stmt.setString(2, admin.getApellidos());
                stmt.setString(3, admin.getUserName());
                stmt.setString(4, admin.getClave());
                stmt.setString(5, admin.getTelefono());
                stmt.setString(6, admin.getEmail());
                stmt.execute();
                Statement stmt3 = conn.createStatement();
                ResultSet rs = stmt3.executeQuery("select * from usuarios where  id=(select max(id) from usuarios)");
                while (rs.next()) {
                    idUser = rs.getInt("id");
                }
                rs.close();
                stmt3.close();
                stmt.close();
            }
            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            {
                stmt2.setString(1, admin.getNombre());
                stmt2.setString(2, "admin");
                stmt2.setInt(3, idUser);
                stmt2.execute();
                stmt2.close();
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
    public void borrarVecino(Vecino vecino) {
        String sql = "delete from usuarios where id = ?";
        String sql2 = "delete from usuarios_roles where idUser = ?";
        try {
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            {
                stmt.setInt(1, vecino.getId());
                stmt.execute();
                stmt.close();
            }
            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            {
                stmt2.setInt(1, vecino.getId());
                stmt2.execute();
                stmt2.close();
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
    public List<Vecino> listarVecinos() {
        List<Vecino> lista = new ArrayList();
        try {
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from usuarios");
            while (rs.next()) {
                lista.add(new Vecino(rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("userName"),
                        rs.getString("clave"),
                        rs.getString("telefono"),
                        rs.getString("email")));
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
    public List<Vecino> buscarNombre(String nombre) {
        List<Vecino> lista = new ArrayList();

        try {
            
            PreparedStatement stmt = busquedaNombre(conn, nombre);
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) {

                    lista.add(new Vecino(rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("apellidos"),
                            rs.getString("userName"),
                            rs.getString("clave"),
                            rs.getString("telefono"),
                            rs.getString("email")));
                    
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
    private PreparedStatement busquedaNombre(Connection con, String nombre) throws SQLException {
        String sql = "select * from usuarios where nombre like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nombre + "%");
        return ps;
    }

    /**
     * Metodo que busca dentro de los registros todos los vecinos que contengan
     * en su nombre el parametro pasado por referencia
     *
     * @param nombre
     * @return
     */
    public Vecino buscarId(int id) {
        Vecino v = new Vecino();

        try {
            
            PreparedStatement stmt = busquedaId(conn, id);
            ResultSet rs = stmt.executeQuery();
            {
                while (rs.next()) {
                    v.setId(rs.getInt("id"));
                    v.setNombre(rs.getString("nombre"));
                    v.setApellidos(rs.getString("apellidos"));
                    v.setUserName(rs.getString("userName"));
                    v.setClave(rs.getString("clave"));
                    v.setTelefono(rs.getString("telefono"));
                    v.setEmail(rs.getString("email"));
                }
                rs.close();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }

        return v;
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
        String sql = "select * from usuarios where id like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }

    /**
     * Metodo que autentica a un vecino
     *
     * @param userName
     * @param pwd
     */
    public Vecino comprobarCredenciales(String userName, String pwd) {
        try {
            
            PreparedStatement stmt = consultaCredenciales(conn, userName, pwd);
            ResultSet rs = stmt.executeQuery();

            if (rs.next() == false) {
                System.out.println("USUARIO ERRONEO");
                rs.close();
                stmt.close();
                return null;
            } else {
                System.out.println("USUARIO AUTENTICADO");
                Vecino v = buscarId(rs.getInt("id"));
                rs.close();
                stmt.close();
                return v;
            }
            
            

        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
    }

    /**
     * Metodo que genera la consulta para autenticar a un vecino
     *
     * @param con
     * @param userName
     * @param pwd
     * @return
     * @throws SQLException
     */
    private PreparedStatement consultaCredenciales(Connection con, String userName, String pwd) throws SQLException {
        String sql = "select * from usuarios where userName like ? and clave like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, userName);
        ps.setString(2, pwd);
        return ps;
    }
    
    public String obtenerTipoUsuario(Vecino v) {
        try {
            
            PreparedStatement stmt = consultaTipoUsuario(conn, v);
            ResultSet rs = stmt.executeQuery();

            if (rs.next() == false) {
                rs.close();
                stmt.close();
                return null;
            } else {
                String role = rs.getString("role");
                return role;
            }

        } catch (SQLException e) {
            throw new RuntimeException("error SQL", e);
        }
    }

    /**
     * Metodo que genera la consulta para autenticar a un vecino
     *
     * @param con
     * @param userName
     * @param pwd
     * @return
     * @throws SQLException
     */
    private PreparedStatement consultaTipoUsuario(Connection con, Vecino v) throws SQLException {
        String sql = "select * from usuarios_roles where idUser like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, v.getId());
        
        return ps;
    }

}
