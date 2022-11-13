package repositorio;

import java.util.ArrayList;
import java.util.List;


public class Inmueble {

    //1. Atributos

    private int id;
    private Vecino vecino;
    private String direccion;
    protected List<ServicioFijo> serviciosFijos = new ArrayList();
    protected List<ServicioOpcional> serviciosOpcionales = new ArrayList(); 
    
    //2. Constructores

    public Inmueble() {}

    public Inmueble(int id, Vecino vecino, String direccion) {
        this.id = id;
        this.vecino = vecino;
        this.direccion = direccion;
    }

    

    //3. Metodos
    
        // Metodo getId, para obtener el identificar de inmueble
    public int getId (){
       return this.id;
    }
    
        //Metodo getDireccion, para obtener la direccion del inmueble
    public String getDireccion(){
       return this.direccion;
    }

    public Vecino getVecino() {
        return vecino;
    }

    public void setVecino(Vecino vecino) {
        this.vecino = vecino;
    }
    

    public void setInmueble(Vecino vecino, String direccion) {
        this.vecino = vecino;
        this.direccion = direccion;
    }

    
    
    
        
        //Metodo toString que sobreescribe el heredado de la clase Object
    @Override
    public String toString() {
        return "Inmueble" + id + "\nvecin - " + vecino.nombre + "\ndirec - " + direccion + "\n- Serv Fijos asociados - \n" + serviciosFijos + "\n- Serv Opcionales asoc - \n" + serviciosOpcionales +"\n}\n\n";
    }
   


 
}