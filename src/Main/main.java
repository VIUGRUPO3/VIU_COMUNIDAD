// Asignatura: 21GIIN Proyectos Programación
// Profesor: Eduardo Zamudio
// @author: Grupo 3
// Miembros:
//       @author:Fernando Hernandez Fernandez
//       @author:Javier Barbero Sales
//       @author:Martin Gonzalez Dominguez
// @version: 01/12/2022/

// Paquete
package Main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import usuario.Admin;
import repositorio.ComunidadCRUD;
import repositorio.GastoConceptoCompuesto;




public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean login;
        
            //Instancia de la clase usada para realizar el Almacenamiento/tratamiendo de datos de la comunidad (BD)
        ComunidadCRUD comunidadCRUD = new ComunidadCRUD ();
        Admin admin = new Admin(1, "Admin","1234", "666555444","grupo3@viu.es");
        
        
        
            //instancias de la clase Vecino 
        admin.altaVecino(comunidadCRUD,1,"Martin    ","abc ","666778899","martin@viu.es  ");
        admin.altaVecino(comunidadCRUD,2,"Fernando  ","def ","690002255","fer@viu.es     ");
        admin.altaVecino(comunidadCRUD,3,"Javier    ","ert ","651214542","javi@viu.es    ");
        admin.altaVecino(comunidadCRUD,4,"Antonio   ","qwe ","658923455","antonio@viu.es ");
        admin.altaVecino(comunidadCRUD,5,"Mateo  ","qwe2","658923452","mateo@viu.es");
        
        
            //Instancias de la clase Inmueble
        admin.altaInmueble(comunidadCRUD, 1, comunidadCRUD.getVecinos().get(0), "Gran Via");
        admin.altaInmueble(comunidadCRUD, 2, comunidadCRUD.getVecinos().get(0), "Serrano ");
        admin.altaInmueble(comunidadCRUD, 3, comunidadCRUD.getVecinos().get(2), "Arenal  ");
        admin.altaInmueble(comunidadCRUD, 4, comunidadCRUD.getVecinos().get(3), "Ronda   ");
        admin.altaInmueble(comunidadCRUD, 5, comunidadCRUD.getVecinos().get(4), "Ronda2  ");
        
              
            //Instancias de la clase Servicio
        admin.altaServicio(comunidadCRUD, 1, "Jardineria   ", 100, false);
        admin.altaServicio(comunidadCRUD, 2, "Mantenimiento", 50, false);
        admin.altaServicio(comunidadCRUD, 3, "Piscina      ", 60, true);
        admin.altaServicio(comunidadCRUD, 4, "Paddle       ", 30, true);
        admin.altaServicio(comunidadCRUD, 5, "Conserjeria  ", 20, true);
        
       
             //Instancias de la clase Proveedor
        admin.altaProveedor(comunidadCRUD, 1, "Jardines Eden     ", "C/Serrano, 3     ", "666888777","jardineden@gmail.com");
        admin.altaProveedor(comunidadCRUD, 2, "Multiservicios 24H", "C/Velazquez, 8   ", "666521485","multiservs@gmail.com");
        admin.altaProveedor(comunidadCRUD, 3, "Luxury Pools      ", "Avda.Estacion, 21", "668741963","luxpools@gmail.com  ");
        admin.altaProveedor(comunidadCRUD, 4, "Paddle Club       ", "Ctra. Malaga     ", "669874512","paddleclub@gmail.com");
        admin.altaProveedor(comunidadCRUD, 5, "Atlas Services    ", "C/Jaul           ", "669879854","atlas@gmail.com     ");
        
        
            //Instancias de la clase GastoConceptoCompuestos
        admin.altaGastoConceptoCompuesto(comunidadCRUD, "1", "Paddle       ", comunidadCRUD.getServicios().get(3));
        
                //Estos conceptos son Simples pero subconceptos de GastosCompuesto Paddle
                    admin.altaGastoConceptoCompuesto(comunidadCRUD, "1_1", "Pista     ", comunidadCRUD.getServicios().get(3));
                    
                        //Estos conceptos son Simples pero subconceptos de GastosCompuesto Paddle 
                            admin.altaGastoConceptoSimple(comunidadCRUD, "1_1_1", "Pintura     ", comunidadCRUD.getServicios().get(3));
                            admin.altaGastoConceptoSimple(comunidadCRUD, "1_1_2", "Asfalto     ", comunidadCRUD.getServicios().get(3));
                            admin.altaGastoConceptoSimple(comunidadCRUD, "1_1_3", "Red         ", comunidadCRUD.getServicios().get(3));
                            
                   
                    admin.altaGastoConceptoSimple(comunidadCRUD, "1_2", "Cubierta       ", comunidadCRUD.getServicios().get(3));
                    admin.altaGastoConceptoSimple(comunidadCRUD, "1_3", "Materiales     ", comunidadCRUD.getServicios().get(3));
                    

            //Instancias de la clase GastosConceptoSimple 
        admin.altaGastoConceptoSimple(comunidadCRUD, "2", "Jardines     ", comunidadCRUD.getServicios().get(0));
        admin.altaGastoConceptoSimple(comunidadCRUD, "3", "Mantenimiento", comunidadCRUD.getServicios().get(1));
        admin.altaGastoConceptoSimple(comunidadCRUD, "4", "Piscinas     ", comunidadCRUD.getServicios().get(2));
        admin.altaGastoConceptoSimple(comunidadCRUD, "5", "Conserjeria  ", comunidadCRUD.getServicios().get(4));
        
        

            //Asignar Subconceptos a Comceptos (Jerarquia solicitada en enunciado de actividad)
        admin.jerarquizarConceptos(comunidadCRUD.getGastosConcepto().get(1), (GastoConceptoCompuesto) comunidadCRUD.getGastosConcepto().get(0));
                admin.jerarquizarConceptos(comunidadCRUD.getGastosConcepto().get(2), (GastoConceptoCompuesto) comunidadCRUD.getGastosConcepto().get(1));
                admin.jerarquizarConceptos(comunidadCRUD.getGastosConcepto().get(3), (GastoConceptoCompuesto) comunidadCRUD.getGastosConcepto().get(1));
                admin.jerarquizarConceptos(comunidadCRUD.getGastosConcepto().get(4), (GastoConceptoCompuesto) comunidadCRUD.getGastosConcepto().get(1));
        admin.jerarquizarConceptos(comunidadCRUD.getGastosConcepto().get(5), (GastoConceptoCompuesto) comunidadCRUD.getGastosConcepto().get(0));
        admin.jerarquizarConceptos(comunidadCRUD.getGastosConcepto().get(6), (GastoConceptoCompuesto) comunidadCRUD.getGastosConcepto().get(0));

        
        
           
            //Instancias de la clase Gasto
        admin.altaGasto(comunidadCRUD, 1,
                          "Talado de palmeras",
                         LocalDate.parse("01/11/2022",DateTimeFormatter.ofPattern("d/M/yyyy")),
                            LocalDate.parse("29/11/2022",DateTimeFormatter.ofPattern("d/M/yyyy")),
                            comunidadCRUD.getProveedores().get(0),
                          "JR345",
                         comunidadCRUD.getGastosConcepto().get(7),
                              1000,
                            false);
        admin.altaGasto(comunidadCRUD, 2,
                          "Red Paddle",
                         LocalDate.parse("01/11/2022",DateTimeFormatter.ofPattern("d/M/yyyy")),
                            LocalDate.parse("29/11/2022",DateTimeFormatter.ofPattern("d/M/yyyy")),
                            comunidadCRUD.getProveedores().get(3),
                          "JR345",
                         comunidadCRUD.getGastosConcepto().get(4),
                              300,
                            false);
        admin.altaGasto(comunidadCRUD, 3,
                          "Conserjeria",
                         LocalDate.parse("01/11/2022",DateTimeFormatter.ofPattern("d/M/yyyy")),
                            LocalDate.parse("29/11/2022",DateTimeFormatter.ofPattern("d/M/yyyy")),
                            comunidadCRUD.getProveedores().get(4),
                          "JR345",
                         comunidadCRUD.getGastosConcepto().get(10),
                              600,
                            false);
        

          
             //Define un servicio como fijo y se lo asigna a todos los inmuebles de la comunidad
             
        admin.asignarServicioFijo(comunidadCRUD, comunidadCRUD.getServicios().get(0),LocalDate.parse("2022-11-01"));
        admin.asignarServicioFijo(comunidadCRUD, comunidadCRUD.getServicios().get(1),LocalDate.parse("2022-11-01"));
        
        
//            //Guardamos los servicios opcionales dentro de un Array de Servicios opcionales //CAMBIAR!!!!
//        
//        admin.asignarServicoOpcional(comunidadCRUD, comunidadCRUD.getServicios().get(2));
//        admin.asignarServicoOpcional(comunidadCRUD, comunidadCRUD.getServicios().get(3));
        

     
            //Asignamos varios servicios opcionales a varios inmuebles
         
        admin.asignarServicioOpcional(comunidadCRUD, comunidadCRUD.getServicios().get(2), comunidadCRUD.getInmuebles().get(0), LocalDate.parse("2022-11-01"));
        admin.asignarServicioOpcional(comunidadCRUD, comunidadCRUD.getServicios().get(2), comunidadCRUD.getInmuebles().get(1), LocalDate.parse("2022-11-01"));
        admin.asignarServicioOpcional(comunidadCRUD, comunidadCRUD.getServicios().get(2), comunidadCRUD.getInmuebles().get(2), LocalDate.parse("2022-11-01"));
        admin.asignarServicioOpcional(comunidadCRUD, comunidadCRUD.getServicios().get(2), comunidadCRUD.getInmuebles().get(3), LocalDate.parse("2022-11-01"));
        admin.asignarServicioOpcional(comunidadCRUD, comunidadCRUD.getServicios().get(2), comunidadCRUD.getInmuebles().get(4), LocalDate.parse("2022-11-01"));
        admin.asignarServicioOpcional(comunidadCRUD, comunidadCRUD.getServicios().get(3), comunidadCRUD.getInmuebles().get(0), LocalDate.parse("2022-11-01"));
        
        

        

        
        
        // Autentificacion 
        login = comunidadCRUD.getVecinos().get(1).login("fer@viu.es     ", "def ");
        if(login == true){
            System.out.println("Usuario autenticado correctamente");
        }else{
            System.out.println("Error de autenticacion");
        }
        
        
        admin.bajaVecino(comunidadCRUD, comunidadCRUD.getVecinos().get(4));
        
        System.out.println("------------------- VECINOS -------------------\n");
        System.out.println(comunidadCRUD.getVecinos());
        System.out.println("------------------ INMUEBLES ------------------\n");
        System.out.println(comunidadCRUD.getInmuebles());
        System.out.println("------------------ SERVICIOS ------------------\n");
        System.out.println(comunidadCRUD.getServicios());
        System.out.println("--------------- CUENTAS SERVICIO ---------------\n");
        System.out.println(comunidadCRUD.getServiciosCuenta());
        System.out.println("-------------- CONCEPTOS DE GASTO --------------\n");
        System.out.println(comunidadCRUD.getGastosConcepto());
        System.out.println("-------------------- GASTO --------------------\n");
        System.out.println(comunidadCRUD.getGastos());
        

        
        
        
        
        
        
        //Creacion de una liquidacion 
        
        admin.liquidar(comunidadCRUD, 1, LocalDate.parse("2022-11-01"), LocalDate.parse("2022-11-30"));
        System.out.println("---------------- LIQUIDACIONES ----------------\n"); 
        admin.imprimirLiquidacion(comunidadCRUD, comunidadCRUD.getLiquidaciones().get(0));
        
        //Consultas realizadas por la clase Vecino (liquidaciones y servicios de inmuebles propios)
        comunidadCRUD.getVecinos().get(0).consultarLiquidacion(comunidadCRUD, comunidadCRUD.getLiquidaciones().get(0));
        comunidadCRUD.getVecinos().get(0).consultarServicioCuentas(comunidadCRUD);
        
        
    }
    
}
