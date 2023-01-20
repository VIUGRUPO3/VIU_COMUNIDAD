/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author fersi
 */
public abstract class ServicioAbs {
    //Atributos
    /**
     * ID del servicio
     */
    protected int id;

    /**
     * Nombre del servicio
     */
    protected String nombre;

    /**
     * Booleano que indica la obligatoriedad del servicio. Si es obligatorio
     * tomará el valor False, en caso contrario será True
     */
    protected boolean opcional;
    
    public ServicioAbs() {
    }
   
    public ServicioAbs(String nombre, boolean opcional) {
        this.nombre = nombre;
        this.opcional = opcional;

    }

    public ServicioAbs(int id, String nombre, boolean opcional) {
        this.id = id;
        this.nombre = nombre;
        this.opcional = opcional;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isOpcional() {
        return opcional;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setOpcional(boolean opcional) {
        this.opcional = opcional;
    }
    
    
}
