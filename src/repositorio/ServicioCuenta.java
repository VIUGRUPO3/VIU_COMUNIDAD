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

import java.time.LocalDate;

/** Clase que asocia el servicio con inmueble en base a fecha de alta y baja
 * 
 * 
 */
public class ServicioCuenta {
    
    //Atributos
    
    private Inmueble inmueble;
    private Servicio servicio;
    private LocalDate fechaAlta;
    private LocalDate fechaBaja;
    
    
    //Constructores
    

    public ServicioCuenta() {}

    /** 
     * 
     * @param inmueble objeto inmueble 
     * @param servicio objeto servicio
     * @param fechaAlta Objeto fecha con fecha de alta
     */
    public ServicioCuenta(Inmueble inmueble, Servicio servicio, LocalDate fechaAlta) {
        this.inmueble = inmueble;
        this.servicio = servicio;
        this.fechaAlta = fechaAlta;
    }
    
    
    //Metodos

        //Getters
            /** Metodo que nos devuelve el objeto del inmueble
             * 
             * @return inmueble objeto inmueble
             */
            public Inmueble getInmueble() {
                return inmueble;
            }
            /** Metodo que devuelve objeto servicio
             * 
             * @return servicio objeto servicio 
             */
            public Servicio getServicio() {
                return servicio;
            }
            /** Metodo que devuelve objeto fecha alta del servicio
             * 
             * @return fechaAlta objeto fecha alta 
             */
            public LocalDate getFechaAlta() {
                return fechaAlta;
            }

            /** Metodo que devuelve objeto FechaBaja del servicio
             * 
             * @return fechaBaja objeto fecha de baja 
             */
            public LocalDate getFechaBaja() {
                return fechaBaja;
            }

         //Setters
            /** Metodo que establece el objeto Inmueble
             * 
             * @param inmueble objeto inmueble 
             */
            public void setInmueble(Inmueble inmueble) {
                this.inmueble = inmueble;
            }
            /** Metodo que establece el objeto servicio
             * 
             * @param servicio objeto servicio 
             */
            public void setServicio(Servicio servicio) {
                this.servicio = servicio;
            }
            /** Metodo que asigna fecha baja
             * 
             * @param fechaBaja objeto fecha baja 
             */
            public void setFechaBaja(LocalDate fechaBaja) {
                this.fechaBaja = fechaBaja;
            }
            /** Metodo que asigna fecha alta
             * 
             * @param fechaAlta objeto fecha alta 
             */
            public void setFechaAlta(LocalDate fechaAlta) {
                this.fechaAlta = fechaAlta;
            }
               
            /**Metodo que actualiza el objeto ServicioCuenta
             * 
             * @param inmueble objeto inmueble
             * @param servicio objeto servicio
             * @param fechaAlta objeto fecha alta
             * @param fechaBaja objeto fecha baja
             */
            public void setServicioCuenta(Inmueble inmueble, Servicio servicio, LocalDate fechaAlta, LocalDate fechaBaja){
               this.setInmueble(inmueble);
               this.setServicio(servicio);
               this.setFechaAlta(fechaAlta);
               this.setFechaBaja(fechaBaja);
            }

        //Funcionalidad
            
            //No se indentifican metodos especificos funcionales
            
        //Print
            
            /** Metodo print string para devolver los datos de serviciocuenta establecidos
             * 
             * @return string con los parametros de servicioCuenta
             */
            @Override
            public String toString() {
                return "CUENTA SERVICIO \n"  + inmueble + "\nservicio - " + servicio + "\nfechaAlta - " + fechaAlta + "\nfechaBaja - " + fechaBaja + "\n-----------------------------\n\n";
            }
    
   
    
    
    
    
}
