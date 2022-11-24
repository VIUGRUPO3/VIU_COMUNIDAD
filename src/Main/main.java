// Autor Grupo 3

//************************ INFO ************************



package Main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import repositorio.Admin;
import repositorio.ComunidadCRUD;
import repositorio.Gasto;
import repositorio.GastoConceptoCompuesto;
import repositorio.GastoConceptoSimple;
import repositorio.Inmueble;
import repositorio.Liquidacion;
import repositorio.Proveedor;
import repositorio.Servicio;
import repositorio.ServicioTipos;
import repositorio.Vecino;

public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean login;
        
            //Instancia de la clase usada para realizar el Almacenamiento/tratamiendo de datos de la comunidad (BD)
        ComunidadCRUD comunidadCrud = new ComunidadCRUD ();
        
        
        
            //instancias de la clase Vecino 
        Vecino vecino1 = new Vecino(1,"Martin    ","abc ","666778899","martin@viu.es  ");
        Vecino vecino2 = new Vecino(2,"Fernando  ","def ","690002255","fer@viu.es     ");
        Vecino vecino3 = new Vecino(3,"Javier    ","ert ","651214542","javi@viu.es    ");
        Vecino vecino4 = new Vecino(4,"Antonio   ","qwe ","658923455","antonio@viu.es ");
        Vecino vecino5 = new Vecino(5,"Antonio2  ","qwe2","658923452","antonio2@viu.es");
        
            //Instancias de la clase Inmueble
        Inmueble inmueble1 = new Inmueble(1, vecino1, "Gran Via");
        Inmueble inmueble2 = new Inmueble(2, vecino2, "Serrano ");
        Inmueble inmueble3 = new Inmueble(3, vecino3, "Arenal  ");
        Inmueble inmueble4 = new Inmueble(4, vecino4, "Ronda   ");
        Inmueble inmueble5 = new Inmueble(5, vecino2, "Ronda2  ");
              
            //Instancias de la clase Servicio
        Servicio servicio1 = new Servicio(1, "Jardineria   ", 100);
        Servicio servicio2 = new Servicio(2, "Mantenimiento", 50);
        Servicio servicio3 = new Servicio(3, "Piscina    ", 60);
        Servicio servicio4 = new Servicio(4, "Paddle     ", 30);
        Servicio servicio5 = new Servicio(5, "Conserjeria", 20);
       
             //Instancias de la clase Proveedor
        Proveedor proveedor1 = new Proveedor(1, "Jardines Eden     ", "C/Serrano, 3     ", "666888777","jardineden@gmail.com");
        Proveedor proveedor2 = new Proveedor(2, "Multiservicios 24H", "C/Velazquez, 8   ", "666521485","multiservs@gmail.com");
        Proveedor proveedor3 = new Proveedor(3, "Luxury Pools      ", "Avda.Estacion, 21", "668741963","luxpools@gmail.com  ");
        Proveedor proveedor4 = new Proveedor(4, "Paddle Club       ", "Ctra. Malaga     ", "669874512","paddleclub@gmail.com");
        Proveedor proveedor5 = new Proveedor(5, "Atlas Services    ", "C/Jaul           ", "669879854","atlas@gmail.com     ");
        
            //Instancias de la clase GastoConceptoCompuestos
        GastoConceptoCompuesto gastoConcepto1 = new GastoConceptoCompuesto("1", "Paddle       ", servicio4);
        
                //Estos conceptos son Simples pero subconceptos de GastosCompuesto Paddle 
                    GastoConceptoCompuesto gastoConcepto1_1 = new GastoConceptoCompuesto("1_1", "Pista     ", servicio4);
                    
                        //Estos conceptos son Simples pero subconceptos de GastosCompuesto Paddle 
                            GastoConceptoSimple gastoConcepto1_1_1 = new GastoConceptoSimple("1_1_1", "Pintura     ", servicio4);
                            GastoConceptoSimple gastoConcepto1_1_2 = new GastoConceptoSimple("1_1_2", "Asfalto       ", servicio4);
                            GastoConceptoSimple gastoConcepto1_1_3 = new GastoConceptoSimple("1_1_3", "Red   ", servicio4);
                   
                    GastoConceptoSimple gastoConcepto1_2 = new GastoConceptoSimple("1_2", "Cubierta       ", servicio4);
                    GastoConceptoSimple gastoConcepto1_3 = new GastoConceptoSimple("1_3", "Materiales   ", servicio4);

            //Instancias de la clase GastosConceptoSimple    
        GastoConceptoSimple gastoConcepto2 = new GastoConceptoSimple("2", "Jardines     ", servicio1);
        GastoConceptoSimple gastoConcepto3 = new GastoConceptoSimple("3", "Mantenimiento", servicio2);
        GastoConceptoSimple gastoConcepto4 = new GastoConceptoSimple("4", "Piscinas     ", servicio3);
        GastoConceptoSimple gastoConcepto5 = new GastoConceptoSimple("5", "Conserjeria  ", servicio5);
        

            //Asignar Subconcetos a Comceptos (Jerarquia solicitada en enunciado de actividad)
        gastoConcepto1_1.asignacionConceptos(gastoConcepto1);
            gastoConcepto1_1_1.asignacionConceptos(gastoConcepto1_1);
            gastoConcepto1_1_2.asignacionConceptos(gastoConcepto1_1);
            gastoConcepto1_1_3.asignacionConceptos(gastoConcepto1_1);
        gastoConcepto1_2.asignacionConceptos(gastoConcepto1);
        gastoConcepto1_3.asignacionConceptos(gastoConcepto1);
        
      
        
            //Instancias de la clase Gasto
        Gasto gasto1 = new Gasto(
                         1,
                  "Talado de palmeras",
                   LocalDate.parse("01/11/2022",DateTimeFormatter.ofPattern("d/M/yyyy")),
                   LocalDate.parse("29/11/2022",DateTimeFormatter.ofPattern("d/M/yyyy")),
                   proveedor1,
                  "JR345",
                   gastoConcepto2,
                     1000,
                   false
        );
        Gasto gasto2 = new Gasto(
                         2,
                  "Red Paddle",
                LocalDate.parse("10/11/2022",DateTimeFormatter.ofPattern("d/M/yyyy")),
                   LocalDate.parse("20/11/2022",DateTimeFormatter.ofPattern("d/M/yyyy")),
                   proveedor4,
                  "JR345",
                   gastoConcepto1_1_3,
                     300,
                   false
        );
        Gasto gasto3 = new Gasto(
                         3,
                  "Conserjeria",
                LocalDate.parse("10/11/2022",DateTimeFormatter.ofPattern("d/M/yyyy")),
                   LocalDate.parse("20/11/2022",DateTimeFormatter.ofPattern("d/M/yyyy")),
                   proveedor5,
                  "Consj45",
                   gastoConcepto5,
                     1400, 
                   false
        );
        
        
    //Operaciones de almacenamiento dentro de las estructuras de datos
            
            //Guardamos los Vecinos instanciados dentro de un ArrayList de Vecinos
        comunidadCrud.saveVecino(vecino1);
        comunidadCrud.saveVecino(vecino2);
        comunidadCrud.saveVecino(vecino3);
        comunidadCrud.saveVecino(vecino4);
        comunidadCrud.saveVecino(vecino5);
        
            //Guardamos los inmuebles instanciados dentro de un ArrayList de Inmuebles
        comunidadCrud.saveInmueble(inmueble1);
        comunidadCrud.saveInmueble(inmueble2);
        comunidadCrud.saveInmueble(inmueble3);
        comunidadCrud.saveInmueble(inmueble4);
        comunidadCrud.saveInmueble(inmueble5);
        
          
            //Guardamos los servicios fijos instanciados dentro de un ArrayList de Servicios Fijos 
            //Al ser servicios fijos se incluiran en todos los inmuebles creados
        comunidadCrud.saveServicio(servicio1);
        servicio1.definirFijo(comunidadCrud);
        comunidadCrud.saveServicio(servicio2);
        servicio2.definirFijo(comunidadCrud);
            //Asigna todos los servicios fijos a todos lo inmuebles
        comunidadCrud.getServicioTipos().asignarServiciosFijosInmuebles(comunidadCrud, LocalDate.parse("2022-11-01"));
        
            //Guardamos los servicios opcionales dentro de un Array de Servicios opcionales //CAMBIAR!!!!
        comunidadCrud.saveServicio(servicio3);
        servicio3.definirOpcional(comunidadCrud);
        comunidadCrud.saveServicio(servicio4);
        servicio4.definirOpcional(comunidadCrud);
     
            //Asignamos varios servicios opcionales a varios inmuebles
        comunidadCrud.getServicioTipos().asignarServiciosOpcionalInmuebles(comunidadCrud, servicio3, inmueble1, LocalDate.parse("2022-11-01"));
        comunidadCrud.getServicioTipos().asignarServiciosOpcionalInmuebles(comunidadCrud, servicio3, inmueble2, LocalDate.parse("2022-11-01"));
        comunidadCrud.getServicioTipos().asignarServiciosOpcionalInmuebles(comunidadCrud, servicio3, inmueble3, LocalDate.parse("2022-11-01"));
        comunidadCrud.getServicioTipos().asignarServiciosOpcionalInmuebles(comunidadCrud, servicio3, inmueble4, LocalDate.parse("2022-11-01"));
        comunidadCrud.getServicioTipos().asignarServiciosOpcionalInmuebles(comunidadCrud, servicio3, inmueble5, LocalDate.parse("2022-11-01"));
        comunidadCrud.getServicioTipos().asignarServiciosOpcionalInmuebles(comunidadCrud, servicio4, inmueble1, LocalDate.parse("2022-11-01"));
        
            //Guardamos los proveedores instanciados dentro de un ArrayList de proveedores
        comunidadCrud.saveProveedor(proveedor1);
        comunidadCrud.saveProveedor(proveedor2);
        comunidadCrud.saveProveedor(proveedor3);
        comunidadCrud.saveProveedor(proveedor4);
        comunidadCrud.saveProveedor(proveedor5);
        
            //Guardamos los gastos instanciados dentro de un ArrayList de gastos // CAMBIAR!!!!
        comunidadCrud.saveGasto(gasto1);
        comunidadCrud.saveGasto(gasto2);
        comunidadCrud.saveGasto(gasto3);
        
        // QUITAR DEL CODIGO // Mas ADELANTE SE UTILIZA // CAMBIAR!!!!
        login = vecino2.login("fer@viu.es     ", "def ");
        if(login == true){
            System.out.println("Usuario autenticado correctamente");
        }else{
            System.out.println("Error de autenticacion");
        }
        
    }
    
}
