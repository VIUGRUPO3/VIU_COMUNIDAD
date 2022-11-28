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

* 
****/


/** Paquete **/
    package repositorio;

/** Librerias **/
    import java.time.LocalDate;
    import java.util.ArrayList;
    import java.util.List;


public class ServicioTipos {
    
    /** 1. Atributos **/
    
        private List<Servicio> serviciosFijos;
        private List<Servicio> serviciosOpcionales;
    
    /** 2. Constructores **/
        
        public ServicioTipos() {
            this.serviciosFijos = new ArrayList(); 
            this.serviciosOpcionales = new ArrayList();
        }

        /**
        * @param serviciosFijos Lista para almacenar los servicios identificados como Fijos / obligatorios a los vecinos
        * @param serviciosOpcionales Lista para almacenar los servicios identificados como Opcionales a los vecinos
        **/
        public ServicioTipos(List<Servicio> serviciosFijos, List<Servicio> serviciosOpcionales) {
            this.serviciosFijos = serviciosFijos;
            this.serviciosOpcionales = serviciosOpcionales;
        }
    
    /** 3.Metodos **/
        
        /** Getters **/
        
            public List<Servicio> getServiciosFijos() {
                return serviciosFijos;
            }

            public List<Servicio> getServiciosOpcionales() {
                return serviciosOpcionales;
            }
        
        /** Setters **/
            
            /** N/A: No se identifican Metodos Setters **/
        
        /** Funcionalidad **/
        
            public void addServiciosFijos(Servicio servicio) {
                this.serviciosFijos.add(servicio) ;
            }

            public void addServiciosOpcionales(Servicio servicio) {
                this.serviciosOpcionales.add(servicio);
            }

            public void asignarServiciosFijosInmuebles (ComunidadCRUD comunidadCRUD, Servicio servicio, LocalDate fechaAlta){
                comunidadCRUD.inmuebles.forEach(inmueble ->{
                    //comunidadCRUD.servicioTipos.getServiciosFijos().forEach(servicioFijo ->{
                        ServicioCuenta servicioCuenta = new ServicioCuenta(inmueble, servicio, fechaAlta); 
                        comunidadCRUD.serviciosCuenta.add(servicioCuenta);
                    //});
                });
            }

            public void asignarServicioOpcionalInmueble (ComunidadCRUD comunidadCRUD, Servicio servicio, Inmueble inmueble, LocalDate fechaAlta){
                ServicioCuenta servicioCuenta = new ServicioCuenta(inmueble, servicio, fechaAlta); 
                comunidadCRUD.serviciosCuenta.add(servicioCuenta);
            }
            
        /** Print **/
            
            /** N/A: No se identifican Metodos Print **/
}
