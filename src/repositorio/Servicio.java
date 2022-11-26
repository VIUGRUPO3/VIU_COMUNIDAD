/****
* 
* Asignatura: 21GIIN Proyectos Programación
* Profesor: Eduardo Zamudio
* @author: Grupo 3
* Miembros:
*       @author:Fernando Hernandez Fernandez
*       @author:Javier Barbero Sales
*       @author:Martin Gonzalez Dominguez
* @version: 01/12/2022/A 
* 
* ########################## INFO ##########################
*
* Descripción:
*   - 
* Peculiaridades:
*   - Clase Abstracta, ya que no se instanciara ningun objeto de esta clase.
* Herencias:
*   - N/A
* Extends:
*   - N/A
* 
****/


package repositorio;


public class Servicio {
    
    //1. Atributos
    private int id;
    private String nombre;
    private double tarifa;
    private int inmueblesAdheridos;
     
    //2. Constructores
    public Servicio() {}

    public Servicio(int id, String nombre, double tarifa) {
        this.id = id;
        this.nombre = nombre;
        this.tarifa = tarifa;
        this.inmueblesAdheridos = 0;
    }
    
     //3. Metodos

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }
    
    public void setServicio (String nombre, double tarifa){
        this.nombre = nombre;
        this.tarifa = tarifa;
    }
    
    
    
    public void definirFijo  (ComunidadCRUD comunidadCRUD) {
        comunidadCRUD.servicioTipos.addServiciosFijos(this);
        }
    
    public void definirOpcional (ComunidadCRUD comunidadCRUD) {
        comunidadCRUD.servicioTipos.addServiciosOpcionales(this);
    }  
    
    
    public int inmueblesAdheridos (ComunidadCRUD comunidadCRUD){
       inmueblesAdheridos = 0;
       comunidadCRUD.serviciosCuenta.forEach(servicioCuenta ->{
           if(servicioCuenta.getServicio() == this){
               inmueblesAdheridos = inmueblesAdheridos + 1;
           }
       });
       return inmueblesAdheridos;
   }
    
    public void bajaServicio (ComunidadCRUD comunidadCRUD, Servicio servicioBorrar){
        comunidadCRUD.servicios.forEach(servicio ->{
            if(servicio == servicioBorrar){
                servicio = null;
            }
        });
    }
    
    public void updateServicio (ComunidadCRUD comunidadCRUD, String nombre, double tarifa, Servicio servicioModificar ){
        comunidadCRUD.servicios.forEach(servicio ->{
            if(servicio == servicioModificar){
                servicio.setServicio(nombre, tarifa);
            }
        });
    }
    
    @Override
    public String toString() {
        return nombre + " -> "+ tarifa + "Euros \n";
    }

    
}
