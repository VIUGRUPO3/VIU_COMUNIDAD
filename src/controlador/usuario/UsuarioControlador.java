/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.usuario;

import controlador.Controlador;
import dao.ServicioUsuarios;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.usuario.Admin;
import modelo.usuario.Vecino;
import vista.MainFrameAdmin;

/**
 *
 * @author fer
 */
public class UsuarioControlador {
    private static ServicioUsuarios su = new ServicioUsuarios();
   
//Atributos
    private static Controlador ctrl = new Controlador();
    //Constructores
    public UsuarioControlador() {
    }
 
    //Metodos
    public void autenticarUsuario(String userName, String pwd){
        ServicioUsuarios su = new ServicioUsuarios();
        if(su.comprobarCredenciales(userName, pwd) == true){
            ctrl.autenticado(true);
        }else{
            ctrl.autenticado(false);
        }
    }
    
    public void registrarVecino(Vecino v){
        su.insertarVecinoDB(v); 
    }
    public void registrarAdmin(Admin a){
        su.insertarAdminDB(a);
    }
    
    public List<Vecino> obtenerListaUsuarios(String nombre){
        List<Vecino> lista = su.buscarNombre(nombre);
        return lista;
    }
    
    public void eliminarUsuario (int id){
        Vecino v = su.buscarId(id);
        su.borrarVecino(v);
    }
    
    public Vecino obtenerVecino (int id){
        Vecino v = su.buscarId(id);
        return v;
    }
    
    public void updateUsuario(Vecino v){
        su.updateUsuario(v);
    }
    
    
    //Fin de la clase
}
