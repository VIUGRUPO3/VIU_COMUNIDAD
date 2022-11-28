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
    import java.util.ArrayList;
    import java.util.List;

/** Clase que identifica la gestion del tipo de servicio FIjo / opcional
 *
 */
public class ServicioTipos {
    
//Atributos

/**
*  Coleccion de Servicios Fijos
* */
private List<Servicio> serviciosFijos;
/**
*  Coleccion de Servicios Opcionales
* */
private List<Servicio> serviciosOpcionales;

//Constructores

public ServicioTipos() {
    this.serviciosFijos = new ArrayList(); 
    this.serviciosOpcionales = new ArrayList();
}

/** Constructor 
* @param serviciosFijos Lista para almacenar los servicios identificados como Fijos / obligatorios a los vecinos
* @param serviciosOpcionales Lista para almacenar los servicios identificados como Opcionales a los vecinos
**/
public ServicioTipos(List<Servicio> serviciosFijos, List<Servicio> serviciosOpcionales) {
    this.serviciosFijos = serviciosFijos;
    this.serviciosOpcionales = serviciosOpcionales;
}

//Metodos

    //Getters
        
        /** Metodo que obtiene el listado de servicios fijos
         * 
         * @return serviciosFijos lista de servicios fijos 
         */
        public List<Servicio> getServiciosFijos() {
            return serviciosFijos;
        }
        
        /** Metodo que obtiene el listado de servicios obcionales
         * 
         * @return serviciosOpcionales lista de servicios opcionales 
         */
        public List<Servicio> getServiciosOpcionales() {
            return serviciosOpcionales;
        }

    //Setters

        //No se identifican Metodos Setters

    //Funcionalidad

        /** Metodo que incluye el servicio en servicio Fijo
         * 
         * @param servicio añade el servicio en la lista de servicios fijos 
         */
        public void addServiciosFijos(Servicio servicio) {
            this.serviciosFijos.add(servicio) ;
        }

        /** Metodo que incluye el servicio en servicio opcional
         * 
         * @param servicio añade el servicio en la lista de servicios opcionales 
         */
        public void addServiciosOpcionales(Servicio servicio) {
            this.serviciosOpcionales.add(servicio);
        }
        
        /** Metodo que asigna los serviciosFIjos a los inmuebles, como son fijos se asignan a todos los inmuebles
         * 
         * @param comunidadCRUD objeto comunidad que contiene toda la información de la comunidad
         * @param servicio objeto servicio a ser incluido en los inmuebles
         * @param fechaAlta objeto fecha de alta del servicio
         */
        public void asignarServiciosFijosInmuebles (ComunidadCRUD comunidadCRUD, Servicio servicio, LocalDate fechaAlta){
            comunidadCRUD.inmuebles.forEach(inmueble ->{
                //comunidadCRUD.servicioTipos.getServiciosFijos().forEach(servicioFijo ->{
                    ServicioCuenta servicioCuenta = new ServicioCuenta(inmueble, servicio, fechaAlta); 
                    comunidadCRUD.serviciosCuenta.add(servicioCuenta);
                //});
            });
        }
        
        /** Metodo que asigna los servicios opcionales a los inmuebles que lo solicitan
         * 
         * @param comunidadCRUD objeto comunidad que contiene toda la información de la comunidad
         * @param servicio objeto servicio a ser incluido en el inmueble
         * @param inmueble Objeto inmueble al que se va a incluir el servicio
         * @param fechaAlta objeto fecha de alta del servicio
         */
        public void asignarServicioOpcionalInmueble (ComunidadCRUD comunidadCRUD, Servicio servicio, Inmueble inmueble, LocalDate fechaAlta){
            ServicioCuenta servicioCuenta = new ServicioCuenta(inmueble, servicio, fechaAlta); 
            comunidadCRUD.serviciosCuenta.add(servicioCuenta);
        }

    //Print

        //No se identifican Metodos Print
}
