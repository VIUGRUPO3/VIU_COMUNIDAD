// Autor Grupo 3

//************************ INFO ************************


package repositorio;

import java.util.ArrayList;
import java.util.List;


public class TipoServicio {
    
//1. Atributos 
    
    private List<Servicio> serviciosFijos;
    private List<Servicio> serviciosOpcionales;
    
//2. Constructores
    
    public TipoServicio() {
        this.serviciosFijos = new ArrayList(); 
        this.serviciosOpcionales = new ArrayList();
    }
    
    public TipoServicio(List<Servicio> serviciosFijos, List<Servicio> serviciosOpcionales) {
        this.serviciosFijos = serviciosFijos;
        this.serviciosOpcionales = serviciosOpcionales;
    }
    
//3. Metodos

    public void addServiciosFijos(Servicio servicio) {
        this.serviciosFijos.add(servicio) ;
    }

    public void addServiciosOpcionales(Servicio servicio) {
        this.serviciosOpcionales.add(servicio);
    }

    


}
