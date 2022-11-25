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

/** Paquete **/
    package repositorio;

/** Librerias **/
    /** N/A: No se identifican Librerias adicionales **/

/** 
* Se declara como clase abstracta ya que define unicamente la estructura de la clase.
* No se va a instanciar ningún objeto de esta clase.
**/
abstract class Usuario {

    /** 1. Atributos **/

        /**
        * Declaración de atributos como protected para no ser accedidos por otras clases fuera del paquete.
        **/

        protected int id;
        protected String nombre;
        protected String clave;
        protected String telefono;
        protected String email;
        protected boolean logged;
    
    
    /** 2. Constructor **/
       
        public Usuario(){}

        /**
        * @param id Identificador unico de Vecino
        * @param nombre Nombre comun completo Vecino
        * @param clave Clave / Contraseña de acceso del Vecino
        * @param telefono Telefono asociado a Vecino
        * @param email Email asociado a vecino
        **/
        public Usuario(int id, String nombre, String clave, String telefono, String email) {
            this.id = id;
            this.nombre = nombre;
            this.clave = clave;
            this.telefono = telefono;
            this.email = email;
            }

    /** 3. Metodos **/
        
        /** Getters **/
        
            public int getId (){
               return id;
            }
    
        /** Setters **/ 
        
            /** N/A: No se identifican Setters **/
        
        /** Funcionalidad **/
                
            /** Metodo validacion de login **/
            public boolean login(String email, String clave){
                if(this.email == email && this.clave == clave){
                      logged = true;
                    }
                return logged;
            }
            /** Metodo que devuelve si el usuario esta logeado **/
            public boolean isLogged() {
                return logged;
            }
        
        /** Print **/
        
            /** Metodo toString que sobreescribe el heredado de la clase Object **/
            @Override
            public String toString() {
                return "Usuario" + id + "\nnombr - " + nombre + "\nclave - " + clave + "\ntelef - " + telefono + "\nemail - " + email + "\n\n";
            }   

}
