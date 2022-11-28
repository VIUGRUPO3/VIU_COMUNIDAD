// Asignatura: 21GIIN Proyectos Programación
// Profesor: Eduardo Zamudio
// @author: Grupo 3
// Miembros:
//       @author:Fernando Hernandez Fernandez
//       @author:Javier Barbero Sales
//       @author:Martin Gonzalez Dominguez
// @version: 01/12/2022/

// Paquete
package repositorio;

import usuario.Vecino;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Inmueble {

    //1. Atributos

    private int id;
    private Vecino vecino;
    private String direccion;
     


    
    //2. Constructores

    public Inmueble() {}

    public Inmueble(int id, Vecino vecino, String direccion) {
        this.id = id;
        this.vecino = vecino;
        this.direccion = direccion;
    }

    

    //3. Metodos
    
        //Getters
        // Metodo getId, para obtener el identificar de inmueble
    public int getId (){
       return this.id;
    }
    
        //Metodo getDireccion, para obtener la direccion del inmueble
    public String getDireccion(){
       return this.direccion;
    }


    public Vecino getVecino() {
        return vecino;
    }
    

        //Setters
    public void setVecino(Vecino vecino) {
        this.vecino = vecino;
    }
    

    public void setInmueble(Vecino vecino, String direccion) {
        this.vecino = vecino;
        this.direccion = direccion;
    }
    
    public void bajaInmueble (ComunidadCRUD comunidadCRUD, Inmueble inmuebleBaja){
        comunidadCRUD.inmuebles.forEach(inmueble -> {
            if(inmueble == inmuebleBaja){
                inmueble = null;
            }
        }); 
    }

    public void updateInmueble (ComunidadCRUD comunidadCRUD, Vecino vecino, String direccion, Inmueble inmuebleModificar ){
        comunidadCRUD.inmuebles.forEach(inmueble ->{
            if(inmueble == inmuebleModificar){
                inmueble.setInmueble(vecino, direccion);
            }
        }); 
    }   
    
        
        //Metodo toString que sobreescribe el heredado de la clase Object ////REVISAR
    @Override
    public String toString() {
        return "------Inmueble" + id +"------"
                + "\nPropietario - " + vecino.getNombre()
                + "\ndirecccion  - " + direccion 
                + "\n";
    }
   


 
}