/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import usuario.Admin;
import usuario.Vecino;
/**
 *
 * @author Grupo3
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //instancia de la clase Vecino 
        Vecino vecino = new Vecino(1,"Martin","abc","666778899","martin@viu.es","vecino");
        //instancia de la clase Admin 
        Admin admin = new Admin(2,"Javier","abc","666778899","javier@viu.es","Administrador");
        
        //Imprimimos los valores de vecino
        System.out.println(vecino.toString());
        //Imprimimos el ID del usuario      
        System.out.println("ID Usuario: " + vecino.getId());
         //Imprimimos el rol del usuario      
        System.out.println("Rol usuario: " + vecino.getRol());
        //Imprimimos la validacion "token" del login del usuario      
        System.out.println("Login: " + vecino.login(1,"KK","abc"));
        //Imprimimos la validacion "token" del login del usuario      
        System.out.println("Modificacion usuario: " + admin.modUsuario(2,"Javier","abc","666778899","javier@viu.es","Administrador"));
        
        
    }
    
}
