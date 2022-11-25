// Autor Grupo 3

//************************ INFO ************************



package repositorio;


/*Clase que hereda de Usuario*/

public class Vecino extends Usuario {

    //1. Atributos
    
    
    
    //2. Constructores
    
    public Vecino() {}

    public Vecino(int id, String nombre, String clave, String telefono, String email) {
        super(id, nombre, clave, telefono, email);
    }
    
    //3.Metodos

    //Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getClave() {
        return clave;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public boolean isLogged() {
        return logged;
    }
     

    //Setters
    
    public void setId(int id) {
        this.id = id;
    }
   
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }
    
    //Metodo para consultar las liquidaciones de un vecino
    
    public void consultarLiquidacion (ComunidadCRUD comunidadCRUD, Liquidacion liquidacion){
        System.out.println("------------------------------------------------\n");
        System.out.println("CONSULTA DE LIQUIDACION DE:  " + this.nombre + "\n");
        comunidadCRUD.inmuebles.forEach(inmueble -> {
            if(inmueble.getVecino() == this){
                comunidadCRUD.liquidacionesDetalle.forEach(liquidacionDetalle ->{
                   if(liquidacionDetalle.getLiquidacion() == liquidacion && liquidacionDetalle.getInmueble() == inmueble){
                       
                       System.out.println(liquidacionDetalle);
                   } 
                });
            }
        });
    }
 
    //Metodo para consultar las cuentas de servicio de un vecino
    
    public void consultarServicioCuentas (ComunidadCRUD comunidadCRUD){
        System.out.println("------------------------------------------------\n");
        System.out.println("CONSULTA DE SERVICIOS DE:  " + this.nombre + "\n");
        comunidadCRUD.inmuebles.forEach(inmueble -> {
            if(inmueble.getVecino() == this) {
                comunidadCRUD.serviciosCuenta.forEach(servicioCuenta -> {
                   if(servicioCuenta.getInmueble() == inmueble){
                       System.out.println(servicioCuenta);
                   } 
                });
            }
        });
    }
    
    
   
       
}

