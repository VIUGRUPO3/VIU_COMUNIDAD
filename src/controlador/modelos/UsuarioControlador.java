// Asignatura: 21GIIN Proyectos Programación
// Profesor: Eduardo Zamudio
// @author: Grupo 3
// Miembros:
//       @author:Fernando Hernandez Fernandez
//       @author:Javier Barbero Sales
//       @author:Martin Gonzalez Dominguez
// @version: 08/01/2023/package controlador;

package controlador.modelos;

import controlador.Controlador;
import dao.ServicioUsuarios;
import java.util.List;
import modelo.usuario.Admin;
import modelo.usuario.Vecino;

/**
 *
 * @author fer
 */
public class UsuarioControlador {
    
   
//Atributos
    private ServicioUsuarios su = new ServicioUsuarios();
    private Controlador ctrl = new Controlador();
    //Constructores
    public UsuarioControlador() {
    }
 
    //Metodos
    public boolean autenticarUsuario(String userName, String pwd){
        Vecino v = su.comprobarCredenciales(userName, pwd);
        if (v != null){
            String tipoUsuario = su.obtenerTipoUsuario(v);
            ctrl.autenticado(v, tipoUsuario);
            return true;
        }
        return false;
    }
    
    public void registrarVecino(
            String nombre,
            String apellidos,
            String telefono,
            String email,
            String userName,
            String password){
        Vecino v = new Vecino(nombre, apellidos, userName, password, telefono, email);
        su.insertarVecinoDB(v);   
    }
    
    public void updateUsuario(
            int id,
            String nombre,
            String apellidos,
            String telefono,
            String email,
            String userName,
            String password){
        Vecino v = new Vecino (id, nombre, apellidos, userName, password, telefono,email);
        su.updateUsuario(v);
    }
    
    public void registrarAdmin( Admin a){
        su.insertarAdminDB(a);
    }
    
    public List<Vecino> obtenerListaUsuarios(String nombre){
        List<Vecino> lista = su.buscarNombre(nombre);
        return lista;
    }
    
    public void eliminarUsuario (int id){
        Vecino v = obtenerVecino(id);
        su.borrarVecino(v);
    }
        
    public Vecino obtenerVecino (int id){
        Vecino v = su.buscarId(id);
        return v;
    }
   
    public String obtenerTipoUsuario(Vecino v){
        String tipo = su.obtenerTipoUsuario(v);
        return tipo;
    }
       
    //Fin de la clase
}
