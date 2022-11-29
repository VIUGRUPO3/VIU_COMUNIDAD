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

/**
 *  Clase que gestiona las operaciones referentes a servicios
 * */
public class Servicio {
    
    //Atributos
    private int id;
    private String nombre;
    private double tarifa;
    private int inmueblesAdheridos;
     
    //Constructores
    public Servicio() {}

    /** 
     * 
     * @param id objeto id de servicio
     * @param nombre objeto nombre de servicio
     * @param tarifa objeto tarifa de servicio
     */
    public Servicio(int id, String nombre, double tarifa) {
        this.id = id;
        this.nombre = nombre;
        this.tarifa = tarifa;
        this.inmueblesAdheridos = 0;
    }
    
     //Metodos
        
        //Getters
            /** Metodo obtiene el Id de servicio
             * 
             * @return id identificar de servicio 
             */
            public int getId() {
                return id;
            }
            
            /** Metodo obtiene el nombre del servicio
             * 
             * @return nombre string nombre de servicio 
             */
            public String getNombre() {
                return nombre;
            }
            
            /** Metodo que obtiene la tarifa asociada al servicio
             * 
             * @return tarifa coste del servicio 
             */
            public double getTarifa() {
                return tarifa;
            }
        
        //Setters
            
            /** Metodo Establece el id del servicio
             * 
             * @param id identificador de servicio 
             */
            public void setId(int id) {
                this.id = id;
            }
            
            /** Metodo Establece el nombre del servicio
             * 
             * @param nombre objeto nombre del servicio
             */
            public void setNombre(String nombre) {
                this.nombre = nombre;
            }
            
            /** Metodo establece tarifa del servicio
             * 
             * @param tarifa objeto precio del servicio 
             */
            public void setTarifa(double tarifa) {
                this.tarifa = tarifa;
            }
            
            /** Metodo establece el objeto servicio con su Nombre y tarifa
             * 
             * @param nombre objeto nombre servicio
             * @param tarifa objeto coste servicio
             */
            public void setServicio (String nombre, double tarifa){
                this.nombre = nombre;
                this.tarifa = tarifa;
            }


            
        //Funcionalidad
            /** Metodo establece como fijo un servicio identificado
             * 
             * @param comunidadCRUD objeto comunidad que contiene toda la información de la comunidad
             */
            public void definirFijo  (ComunidadCRUD comunidadCRUD) {
                comunidadCRUD.servicioTipos.addServiciosFijos(this);
                }
            /** Metodo establece como opcional un servicio identificado
             * 
             * @param comunidadCRUD objeto comunidad que contiene toda la información de la comunidad
             */
            public void definirOpcional (ComunidadCRUD comunidadCRUD) {
                comunidadCRUD.servicioTipos.addServiciosOpcionales(this);
            }  

            /** Metodo establece como fijo un servicio identificado
             * 
             * @param comunidadCRUD objeto comunidad que contiene toda la información de la comunidad
             * 
             * @return inmueblesAdheridos el numero de inmuebles adheridos al objeto comunidad
             */
            public int inmueblesAdheridos (ComunidadCRUD comunidadCRUD){
               inmueblesAdheridos = 0;
               comunidadCRUD.serviciosCuenta.forEach(servicioCuenta ->{
                   if(servicioCuenta.getServicio() == this){
                       inmueblesAdheridos = inmueblesAdheridos + 1;
                   }
               });
               return inmueblesAdheridos;
           }

            /** 
             * Metodo que permite dar de baja un servicio
             * 
             * @param comunidadCRUD objeto que contiene la informacion de la comunidad y sus objetos correspondientes
             * @param servicioBorrar objeto de servicio a borrar
             **/
            public void bajaServicio (ComunidadCRUD comunidadCRUD, Servicio servicioBorrar){
                comunidadCRUD.servicios.forEach(servicio ->{
                    if(servicio == servicioBorrar){
                        servicio = null;
                    }
                });
            }

            /** 
             * Metodo que permite actualizar la informacion de un servicio
             * 
             * @param comunidadCRUD objeto que contiene la informacion de la comunidad y sus objetos correspondientes
             * @param nombre nombre del servicio
             * @param tarifa tarifa del servicio
             * @param servicioModificar objeto servicio que va a ser modificado
             **/
            public void updateServicio (ComunidadCRUD comunidadCRUD, String nombre, double tarifa, Servicio servicioModificar ){
                comunidadCRUD.servicios.forEach(servicio ->{
                    if(servicio == servicioModificar){
                        servicio.setServicio(nombre, tarifa);
                    }
                });
            }
        
        /** 
        * Metodo toString que devuelve el nombre y tarifa del servicio actual
        * 
        * @return String nombre + " -> "+ tarifa + "Euros \n"
        **/
        //Print
            @Override
            public String toString() {
                return nombre + " -> "+ tarifa + "Euros \n";
            }

    
}
