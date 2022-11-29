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

/**
 *  Clase que gestiona el tipo Inmueble
 * */
public class Inmueble {

    //1. Atributos

    /**
    *  Se definen los atributos principales de la clase inmueble: id, vecino, direccion
    * */
    private int id;
    private Vecino vecino;
    private String direccion;
     


    
    //2. Constructores

    public Inmueble() {}

    /**
    *  Constructor de la clase Inmueble
    * 
    * @param id el id del Inmueble
    * @param vecino el objeto al que pertenece el inmueble
    * @param direccion la dirección a la que corresponde el inmueble
    * */
    public Inmueble(int id, Vecino vecino, String direccion) {
        this.id = id;
        this.vecino = vecino;
        this.direccion = direccion;
    }

    

    //3. Metodos
    
        //Getters
        /** 
        * Metodo getId, para obtener el identificar de inmueble
        * 
        * @return id identificador de inmueble
        **/
    public int getId (){
       return this.id;
    }

        /** 
        * Metodo getDireccion, para obtener la direccion del inmueble
        * 
        * @return direccion la direccion del inmueble
        **/
    public String getDireccion(){
       return this.direccion;
    }

        /** 
        * Metodo getVecino, para obtener el objeto vecino correspondiente al inmueble actual
        * 
        * @return vecino objeto vecino
        **/
    public Vecino getVecino() {
        return vecino;
    }
    

        //Setters
        /** 
        * Metodo para asignar un vecino a un inmueble
        * 
        * @param vecino objeto vecino
        **/      
    public void setVecino(Vecino vecino) {
        this.vecino = vecino;
    }
    
        /** 
        * Metodo para asignar un objeto vecino y una direccion a un inmueble
        * 
        * @param vecino objeto vecino a asociar
        * @param direccion direccion a asociar con el inmueble
        **/
    public void setInmueble(Vecino vecino, String direccion) {
        this.vecino = vecino;
        this.direccion = direccion;
    }
    
        /** 
        * Metodo para dar de baja un inmueble
        * 
        * @param comunidadCRUD objeto comunidadCRUD asociado al inmueble
        * @param inmuebleBaja objeto inmueble a dar de baja
        **/
    public void bajaInmueble (ComunidadCRUD comunidadCRUD, Inmueble inmuebleBaja){
        comunidadCRUD.inmuebles.forEach(inmueble -> {
            if(inmueble == inmuebleBaja){
                inmueble = null;
            }
        }); 
    }
     
        /** 
        * Metodo para actualizar los datos de un inmueble
        * 
        * @param comunidadCRUD objeto comunidadCRUD donde actualizar los datos
        * @param vecino objeto vecino que contiene los datos del propietario del inmueble
        * @param direccion direccion asociada al inmueble
        * @param inmuebleModificar el objeto inmueble a modificar
        **/
    public void updateInmueble (ComunidadCRUD comunidadCRUD, Vecino vecino, String direccion, Inmueble inmuebleModificar ){
        comunidadCRUD.inmuebles.forEach(inmueble ->{
            if(inmueble == inmuebleModificar){
                inmueble.setInmueble(vecino, direccion);
            }
        }); 
    }   
    
        /** 
        * Metodo toString que sobreescribe el heredado de la clase Object ////REVISAR
        * 
        **/
    @Override
    public String toString() {
        return "------Inmueble" + id +"------"
                + "\nPropietario - " + vecino.getNombre()
                + "\ndirecccion  - " + direccion 
                + "\n";
    }
   


 
}