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

import java.time.LocalDate;

public class ServicioCuenta {
    
    //1.Atributos
    
    private Inmueble inmueble;
    private Servicio servicio;
    private LocalDate fechaAlta;
    private LocalDate fechaBaja;
    
    
    //2.Constructores
    

    public ServicioCuenta() {}

    public ServicioCuenta(Inmueble inmueble, Servicio servicio, LocalDate fechaAlta) {
        this.inmueble = inmueble;
        this.servicio = servicio;
        this.fechaAlta = fechaAlta;
    }
    
    
        //3.Metodos
    
        //Getters
    public Inmueble getInmueble() {
        return inmueble;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    
    public LocalDate getFechaBaja() {
        return fechaBaja;
    }
    
         //Setters
    
    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    
     //Metodo que actualiza el objeto ServicioCuenta

   public void setServicioCuenta(Inmueble inmueble, Servicio servicio, LocalDate fechaAlta, LocalDate fechaBaja){
       this.setInmueble(inmueble);
       this.setServicio(servicio);
       this.setFechaAlta(fechaAlta);
       this.setFechaBaja(fechaBaja);
   }
   
   

    @Override
    public String toString() {
        return "CUENTA SERVICIO \n"  + inmueble + "\nservicio - " + servicio + "\nfechaAlta - " + fechaAlta + "\nfechaBaja - " + fechaBaja + "\n-----------------------------\n\n";
    }
    
   
    
    
    
    
}
