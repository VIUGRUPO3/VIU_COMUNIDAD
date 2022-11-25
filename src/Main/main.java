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

package Main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import repositorio.Admin;
import repositorio.ComunidadCRUD;
import repositorio.GastoConceptoCompuesto;

public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean login;
        
            //Instancia de la clase usada para realizar el Almacenamiento/tratamiendo de datos de la comunidad (BD)
        ComunidadCRUD comunidadCrud = new ComunidadCRUD ();
        Admin admin = new Admin();
        
        
        
            //instancias de la clase Vecino 
        admin.altaVecino(comunidadCrud,1,"Martin    ","abc ","666778899","martin@viu.es  ");
        admin.altaVecino(comunidadCrud,2,"Fernando  ","def ","690002255","fer@viu.es     ");
        admin.altaVecino(comunidadCrud,3,"Javier    ","ert ","651214542","javi@viu.es    ");
        admin.altaVecino(comunidadCrud,4,"Antonio   ","qwe ","658923455","antonio@viu.es ");
        admin.altaVecino(comunidadCrud,5,"Mateo  ","qwe2","658923452","mateo@viu.es");
        
        
            //Instancias de la clase Inmueble
        admin.altaInmueble(comunidadCrud, 1, comunidadCrud.getVecinos().get(0), "Gran Via");
        admin.altaInmueble(comunidadCrud, 2, comunidadCrud.getVecinos().get(0), "Serrano ");
        admin.altaInmueble(comunidadCrud, 3, comunidadCrud.getVecinos().get(2), "Arenal  ");
        admin.altaInmueble(comunidadCrud, 4, comunidadCrud.getVecinos().get(3), "Ronda   ");
        admin.altaInmueble(comunidadCrud, 5, comunidadCrud.getVecinos().get(4), "Ronda2  ");
        
              
            //Instancias de la clase Servicio
        admin.altaServicio(comunidadCrud, 1, "Jardineria   ", 100);
        admin.altaServicio(comunidadCrud, 2, "Mantenimiento", 50);
        admin.altaServicio(comunidadCrud, 3, "Piscina      ", 60);
        admin.altaServicio(comunidadCrud, 4, "Paddle       ", 30);
        admin.altaServicio(comunidadCrud, 5, "Conserjeria  ", 20);
        
       
             //Instancias de la clase Proveedor
        admin.altaProveedor(comunidadCrud, 1, "Jardines Eden     ", "C/Serrano, 3     ", "666888777","jardineden@gmail.com");
        admin.altaProveedor(comunidadCrud, 2, "Multiservicios 24H", "C/Velazquez, 8   ", "666521485","multiservs@gmail.com");
        admin.altaProveedor(comunidadCrud, 3, "Luxury Pools      ", "Avda.Estacion, 21", "668741963","luxpools@gmail.com  ");
        admin.altaProveedor(comunidadCrud, 4, "Paddle Club       ", "Ctra. Malaga     ", "669874512","paddleclub@gmail.com");
        admin.altaProveedor(comunidadCrud, 5, "Atlas Services    ", "C/Jaul           ", "669879854","atlas@gmail.com     ");
        
        
            //Instancias de la clase GastoConceptoCompuestos
        admin.altaGastoConceptoCompuesto(comunidadCrud, "1", "Paddle       ", comunidadCrud.getServicios().get(3));
        
                //Estos conceptos son Simples pero subconceptos de GastosCompuesto Paddle
                    admin.altaGastoConceptoCompuesto(comunidadCrud, "1_1", "Pista     ", comunidadCrud.getServicios().get(3));
                    
                        //Estos conceptos son Simples pero subconceptos de GastosCompuesto Paddle 
                            admin.altaGastoConceptoSimple(comunidadCrud, "1_1_1", "Pintura     ", comunidadCrud.getServicios().get(3));
                            admin.altaGastoConceptoSimple(comunidadCrud, "1_1_2", "Asfalto     ", comunidadCrud.getServicios().get(3));
                            admin.altaGastoConceptoSimple(comunidadCrud, "1_1_3", "Red         ", comunidadCrud.getServicios().get(3));
                            
                   
                    admin.altaGastoConceptoSimple(comunidadCrud, "1_2", "Cubierta       ", comunidadCrud.getServicios().get(3));
                    admin.altaGastoConceptoSimple(comunidadCrud, "1_3", "Materiales     ", comunidadCrud.getServicios().get(3));
                    

            //Instancias de la clase GastosConceptoSimple 
        admin.altaGastoConceptoSimple(comunidadCrud, "2", "Jardines     ", comunidadCrud.getServicios().get(0));
        admin.altaGastoConceptoSimple(comunidadCrud, "3", "Mantenimiento", comunidadCrud.getServicios().get(1));
        admin.altaGastoConceptoSimple(comunidadCrud, "4", "Piscinas     ", comunidadCrud.getServicios().get(2));
        admin.altaGastoConceptoSimple(comunidadCrud, "5", "Conserjeria  ", comunidadCrud.getServicios().get(4));
        
        

            //Asignar Subconceptos a Comceptos (Jerarquia solicitada en enunciado de actividad)
        comunidadCrud.getGastosConcepto().get(1).asignacionConceptos((GastoConceptoCompuesto) comunidadCrud.getGastosConcepto().get(0));
            comunidadCrud.getGastosConcepto().get(2).asignacionConceptos((GastoConceptoCompuesto) comunidadCrud.getGastosConcepto().get(1));
            comunidadCrud.getGastosConcepto().get(3).asignacionConceptos((GastoConceptoCompuesto) comunidadCrud.getGastosConcepto().get(1));
            comunidadCrud.getGastosConcepto().get(4).asignacionConceptos((GastoConceptoCompuesto) comunidadCrud.getGastosConcepto().get(1));
        comunidadCrud.getGastosConcepto().get(5).asignacionConceptos((GastoConceptoCompuesto) comunidadCrud.getGastosConcepto().get(0));
        comunidadCrud.getGastosConcepto().get(6).asignacionConceptos((GastoConceptoCompuesto) comunidadCrud.getGastosConcepto().get(0));

        
      
        
            //Instancias de la clase Gasto
        admin.altaGasto(comunidadCrud, 1,
                          "Talado de palmeras",
                         LocalDate.parse("01/11/2022",DateTimeFormatter.ofPattern("d/M/yyyy")),
                            LocalDate.parse("29/11/2022",DateTimeFormatter.ofPattern("d/M/yyyy")),
                            comunidadCrud.getProveedores().get(0),
                          "JR345",
                         comunidadCrud.getGastosConcepto().get(7),
                              1000,
                            false);
        admin.altaGasto(comunidadCrud, 2,
                          "Red Paddle",
                         LocalDate.parse("01/11/2022",DateTimeFormatter.ofPattern("d/M/yyyy")),
                            LocalDate.parse("29/11/2022",DateTimeFormatter.ofPattern("d/M/yyyy")),
                            comunidadCrud.getProveedores().get(3),
                          "JR345",
                         comunidadCrud.getGastosConcepto().get(4),
                              300,
                            false);
        admin.altaGasto(comunidadCrud, 3,
                          "Conserjeria",
                         LocalDate.parse("01/11/2022",DateTimeFormatter.ofPattern("d/M/yyyy")),
                            LocalDate.parse("29/11/2022",DateTimeFormatter.ofPattern("d/M/yyyy")),
                            comunidadCrud.getProveedores().get(4),
                          "JR345",
                         comunidadCrud.getGastosConcepto().get(10),
                              600,
                            false);
        
        
        
        
    //Operaciones de almacenamiento dentro de las estructuras de datos
            
            
        
            
        
          
            //Guardamos los servicios fijos instanciados dentro de un ArrayList de Servicios Fijos 
            //Al ser servicios fijos se incluiran en todos los inmuebles creados
        comunidadCrud.getServicios().get(0).definirFijo(comunidadCrud);
        //servicio1.definirFijo(comunidadCrud);
        comunidadCrud.getServicios().get(1).definirFijo(comunidadCrud);
        //servicio2.definirFijo(comunidadCrud);
            //Asigna todos los servicios fijos a todos lo inmuebles
        comunidadCrud.getServicioTipos().asignarServiciosFijosInmuebles(comunidadCrud, LocalDate.parse("2022-11-01"));
        
            //Guardamos los servicios opcionales dentro de un Array de Servicios opcionales //CAMBIAR!!!!
        comunidadCrud.getServicios().get(2).definirOpcional(comunidadCrud);
        //servicio3.definirOpcional(comunidadCrud);
        comunidadCrud.getServicios().get(3).definirOpcional(comunidadCrud);
        //servicio4.definirOpcional(comunidadCrud);
     
            //Asignamos varios servicios opcionales a varios inmuebles
        comunidadCrud.getServicioTipos().asignarServiciosOpcionalInmuebles(comunidadCrud, comunidadCrud.getServicios().get(2), comunidadCrud.getInmuebles().get(0), LocalDate.parse("2022-11-01"));
        comunidadCrud.getServicioTipos().asignarServiciosOpcionalInmuebles(comunidadCrud, comunidadCrud.getServicios().get(2), comunidadCrud.getInmuebles().get(1), LocalDate.parse("2022-11-01"));
        comunidadCrud.getServicioTipos().asignarServiciosOpcionalInmuebles(comunidadCrud, comunidadCrud.getServicios().get(2), comunidadCrud.getInmuebles().get(2), LocalDate.parse("2022-11-01"));
        comunidadCrud.getServicioTipos().asignarServiciosOpcionalInmuebles(comunidadCrud, comunidadCrud.getServicios().get(2), comunidadCrud.getInmuebles().get(3), LocalDate.parse("2022-11-01"));
        comunidadCrud.getServicioTipos().asignarServiciosOpcionalInmuebles(comunidadCrud, comunidadCrud.getServicios().get(2), comunidadCrud.getInmuebles().get(4), LocalDate.parse("2022-11-01"));
        comunidadCrud.getServicioTipos().asignarServiciosOpcionalInmuebles(comunidadCrud, comunidadCrud.getServicios().get(3), comunidadCrud.getInmuebles().get(0), LocalDate.parse("2022-11-01"));

        

        
        admin.liquidar(comunidadCrud, 1, LocalDate.parse("2022-11-01"), LocalDate.parse("2022-11-30"));
        
        // QUITAR DEL CODIGO // Mas ADELANTE SE UTILIZA // CAMBIAR!!!!
        login = comunidadCrud.getVecinos().get(1).login("fer@viu.es     ", "def ");
        if(login == true){
            System.out.println("Usuario autenticado correctamente");
        }else{
            System.out.println("Error de autenticacion");
        }
        
        
        admin.bajaVecino(comunidadCrud, comunidadCrud.getVecinos().get(4));
        
        System.out.println("------------------- VECINOS -------------------\n");
        System.out.println(comunidadCrud.getVecinos());
        System.out.println("------------------ INMUEBLES ------------------\n");
        System.out.println(comunidadCrud.getInmuebles());
        System.out.println("------------------ SERVICIOS ------------------\n");
        System.out.println(comunidadCrud.getServicios());
        System.out.println("--------------- CUENTAS SERVICIO ---------------\n");
        System.out.println(comunidadCrud.getServiciosCuenta());
        System.out.println("-------------- CONCEPTOS DE GASTO --------------\n");
        System.out.println(comunidadCrud.getGastosConcepto());
        System.out.println("-------------------- GASTO --------------------\n");
        System.out.println(comunidadCrud.getGastos());
        System.out.println("---------------- LIQUIDACIONES ----------------\n");
        System.out.println(comunidadCrud.getLiquidaciones());
        System.out.println("------------ DETALLE LIQUIDACIONES ------------\n");
        System.out.println(comunidadCrud.getLiquidacionesDetalle());
        
        
        comunidadCrud.getVecinos().get(0).consultarLiquidacion(comunidadCrud, comunidadCrud.getLiquidaciones().get(0));
        comunidadCrud.getVecinos().get(0).consultarServicioCuentas(comunidadCrud);
        
        
    }
    
}
