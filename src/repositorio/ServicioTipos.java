// Autor Grupo 3

//************************ INFO ************************


package repositorio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ServicioTipos {
    
//1. Atributos 
    
    private List<Servicio> serviciosFijos;
    private List<Servicio> serviciosOpcionales;
    
//2. Constructores
    
    public ServicioTipos() {
        this.serviciosFijos = new ArrayList(); 
        this.serviciosOpcionales = new ArrayList();
    }
    
    public ServicioTipos(List<Servicio> serviciosFijos, List<Servicio> serviciosOpcionales) {
        this.serviciosFijos = serviciosFijos;
        this.serviciosOpcionales = serviciosOpcionales;
    }
    
//3. Metodos

    public List<Servicio> getServiciosFijos() {
        return serviciosFijos;
    }

    public List<Servicio> getServiciosOpcionales() {
        return serviciosOpcionales;
    }
 
    
    
    public void addServiciosFijos(Servicio servicio) {
        this.serviciosFijos.add(servicio) ;
    }
    
    public void addServiciosOpcionales(Servicio servicio) {
        this.serviciosOpcionales.add(servicio);
    }
    
    public void asignarServiciosFijosInmuebles (ComunidadCRUD comunidadCRUD, LocalDate fechaAlta){
        comunidadCRUD.inmuebles.forEach(inmueble ->{
            comunidadCRUD.servicioTipos.getServiciosFijos().forEach(servicioFijo ->{
                ServicioCuenta servicioCuenta = new ServicioCuenta(inmueble, servicioFijo, fechaAlta); 
                comunidadCRUD.serviciosCuenta.add(servicioCuenta);
            });
        });
    }

    public void asignarServiciosOpcionalInmuebles (ComunidadCRUD comunidadCRUD, Servicio servicio, Inmueble inmueble, LocalDate fechaAlta){
        ServicioCuenta servicioCuenta = new ServicioCuenta(inmueble, servicio, fechaAlta); 
        comunidadCRUD.serviciosCuenta.add(servicioCuenta);
    }    
    




    


}
