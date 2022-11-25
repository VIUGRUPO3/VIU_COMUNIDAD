// Autor Grupo 3

//************************ INFO ************************

package repositorio;

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

    public int getVecinoId() {
        return vecino.id;
    }
    
    public String getNombreVecino() {
        return vecino.nombre;
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
    
    

        //Metodo asignar un servicio a un inmueble
    //public void asignarServicioInmueble (Servicio servicio, LocalDate fechaAlta){
    //    ServicioCuenta servicioCuenta = new ServicioCuenta(this, servicio, fechaAlta);
    //}
    
//        //Metodo desasignar un servicio a un inmueble
//    public void desAsignarServicioInmueble (ServicioCuenta servicioCuenta, LocalDate fechaBaja){
//        servicioCuenta.setFechaBaja(fechaBaja);
//    }
    
        
        //Metodo toString que sobreescribe el heredado de la clase Object ////REVISAR
    @Override
    public String toString() {
        return "------Inmueble" + id +"------"
                + "\nPropietario - " + vecino.nombre 
                + "\ndirecccion  - " + direccion 
                + "\n";
    }
   


 
}