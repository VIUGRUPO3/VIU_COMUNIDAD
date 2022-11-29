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
 *  Clase abstracta que gestiona el tipo de objeto GastoConcepto
 *  La finalidad de esta clase es permitir asociar un gasto a un servicio
 * */
public abstract class  GastoConcepto {
    
    //1.Atributos
    /**
    *  Se definen los atributos principales de la clase: id, nombre, servicio
    * */
    private String id;
    private String nombre;
    private Servicio servicio;
    
    //2.Constructores

    public GastoConcepto() {}

    /**
    *  Constructor de la clase GastoConcepto
    * 
    * @param id el id del GastoConcepto correspondiente
    * @param nombre el nombre del gasto
    * @param servicio el objeto servicio asociado a dicho gasto
    * */
    public GastoConcepto(String id, String nombre, Servicio servicio) {
        this.id = id;
        this.nombre = nombre;
        this.servicio = servicio;
    }
    
    //3.Metodos
    //Getters

    /** 
    * Metodo para consultar la id asociada a un GastoConcepto
    * 
    * @return id id correspondiente a dicho GastoConcepto
    **/
    public String getId() {
        return id;
    }

    /** 
    * Metodo para consultar el nombre asociado a un GastoConcepto
    * 
    * @return nombre correspondiente a dicho GastoConcepto
    **/
    public String getNombre() {
        return nombre;
    }

    /** 
    * Metodo para consultar el servicio asociado a un GastoConcepto
    * 
    * @return servicio objeto servicio asociado a dicho GastoConcepto
    **/
    public Servicio getServicio() {
        return servicio;
    }
    
    //Setters

    /** 
    * Metodo para asociar un id a un GastoConcepto
    * 
    * @param id id a asociar al GastoConcepto
    **/
    public void setId(String id) {
        this.id = id;
    }

    /** 
    * Metodo para asociar un nombre a un GastoConcepto
    * 
    * @param nombre nombre a asociar al GastoConcepto
    **/
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** 
    * Metodo para asociar un servicio a un GastoConcepto
    * 
    * @param servicio objeto servicio a asociar al GastoConcepto
    **/
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    
    /** 
    * Metodo para añadir un nuevo GastoConcepto  
    * 
    * @param gastoConcepto objeto GastoConceptoCompuesto a añadir
    **/
    public void asignacionConceptos (GastoConceptoCompuesto gastoConcepto ) {
        gastoConcepto.getGastosConcepto().add(this);
    }    
    
    /** 
    * Metodo para devolver el id y nombre asociado
    * 
    * @return String en formato id + " - " + nombre + "\n"
    **/
    @Override
    public String toString() {
        return id + " - " + nombre + "\n";
    }
    
    
    
    
}
