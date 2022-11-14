/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;



/**
 *
 * @author fer
 */
abstract class DetalleLiquidacion {
    
    //1.Atributos
    
    protected int id;
    protected Categoria categoria;
    
    
    //2.Constructores
    
    public DetalleLiquidacion() {}

    public DetalleLiquidacion(int id, Categoria categoria) {
        this.id = id;
        this.categoria = categoria;
    }
    
    //3.Metodos

    public int getId() {
        return id;
    }

    
    
    
    
    
}
