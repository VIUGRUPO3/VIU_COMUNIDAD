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
*   - N/A
* Herencias:
*   - Clase heredada de Usuario
* Extends:
*   - Usuario
* 
****/


/** Paquete **/
    package repositorio;
    
/** Librerias **/
    /** N/A: No se identifican Librerias adicionales **/
   

/** 
* Clase que hereda de Usuario 
**/
public class Vecino extends Usuario {

    /** 1. Atributos **/
    
        /** N/A: No se identifican atributos **/
    
    /** 2. Constructores **/
    
        public Vecino() {}

        /**
        * @param id Identificador unico de Vecino
        * @param nombre Nombre comun completo Vecino
        * @param clave Clave / Contraseña de acceso del Vecino
        * @param telefono Telefono asociado a Vecino
        * @param email Email asociado a vecino
        **/
        public Vecino(int id, String nombre, String clave, String telefono, String email) {
            super(id, nombre, clave, telefono, email);
        }
    
    /** 3.Metodos **/

        /** Getters **/
        
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
     

        /** Setters **/
    
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
            
            public void setVecino (String nombre, String clave, String telefono, String email){
                this.nombre = nombre;
                this.clave = clave;
                this.telefono = telefono;
                this.email = email;
                
            }
    
        /** Funcionalidad **/
    
            /** Metodo para consultar las liquidaciones de un vecino **/
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

            /** Metodo para consultar las cuentas de servicio de un vecino **/
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
            
            public void bajaVecino (ComunidadCRUD comunidadCRUD, Vecino vecinoBorrar){
                Vecino comunidad = comunidadCRUD.vecino;        // Asignamos el vecino "Comunidad" al espacio de memoria que ocupaba el vecino eliminado
                comunidadCRUD.inmuebles.forEach(inmueble -> {
                if(inmueble.getVecino() == vecinoBorrar){
                    inmueble.setVecino(comunidad);
                }
                });
                comunidadCRUD.vecinos.forEach(vecino -> {
                if(vecino == vecinoBorrar){
                    comunidadCRUD.vecinos.set(comunidadCRUD.vecinos.indexOf(vecino), comunidad);

                    }
                });  
            }
            public void updateVecino (ComunidadCRUD comunidadCRUD, String nombre, String clave, String telefono, String email, Vecino vecinoModificar){
                comunidadCRUD.vecinos.forEach(vecino ->{
                    if(vecino == vecinoModificar){
                        vecino.setVecino(nombre, clave, telefono, email);
                    } 
                });
            }
        
        /** Print **/
        
          /** N/A: No se identifican Metodos Print **/
    
   
       
}

