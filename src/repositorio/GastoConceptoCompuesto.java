
package repositorio;

import java.util.List;
import java.util.ArrayList;



public class GastoConceptoCompuesto extends GastoConcepto {
    
    //1.Atributos

    protected List<GastoConcepto> gastosConcepto;
    
    
    //2.Constructores

    public GastoConceptoCompuesto() {}
    
    public GastoConceptoCompuesto(String id, String nombre, Servicio servicio) {
        super(id, nombre, servicio);
        this.gastosConcepto= new ArrayList();
    }
    
    //3.Metodos

    public List<GastoConcepto> getGastosConcepto() {
        return gastosConcepto;
    }

    public void setGastosConcepto(List<GastoConcepto> gastosConcepto) {
        this.gastosConcepto = gastosConcepto;
    }
    
}
