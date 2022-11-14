
package Main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import repositorio.Admin;
import repositorio.Categoria;
import repositorio.Gasto;
import repositorio.Inmueble;
import repositorio.Liquidacion;
import repositorio.Proveedor;
import repositorio.ServicioFijo;
import repositorio.ServicioOpcional;
import repositorio.Vecino;
/**
 *
 * @author Grupo3
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int login;
        
            //Instancia de la clase usada para realizar las operaciones con los usuarios
        Admin admin = new Admin();
        
            //instancias de la clase Vecino 
        Vecino vecino1 = new Vecino(1,"Martin","abc","666778899","martin@viu.es");
        Vecino vecino2 = new Vecino(2,"Fernando","def","690002255","fer@viu.es");
        Vecino vecino3 = new Vecino(3,"Javier","ert","651214542","javi@viu.es");
        Vecino vecino4 = new Vecino(4,"Antonio","qwe","658923455","antonio@viu.es");
        Vecino vecino5 = new Vecino(5,"Antonio2","qwe2","658923452","antonio2@viu.es");
        
            //Instancias de la clase Inmueble
        Inmueble inmueble1 = new Inmueble(1, vecino1, "Gran Via");
        Inmueble inmueble2 = new Inmueble(2, vecino1, "Serrano");
        Inmueble inmueble3 = new Inmueble(3, vecino1, "Arenal");
        Inmueble inmueble4 = new Inmueble(4, vecino4, "Ronda");
        Inmueble inmueble5 = new Inmueble(5, vecino5, "Ronda2");
        
            //Instancias de la clase Categoria
        Categoria categoria1 = new Categoria(1, "Mantenimient Gral");
        Categoria categoria2 = new Categoria(2, "Jardines/piscinas");
        Categoria categoria3 = new Categoria(3, "Inst.  Deportivas");
        Categoria categoria4 = new Categoria(4, "Personal  interno");
        Categoria categoria5 = new Categoria(5, "Impuestos y tasas");
        Categoria categoria6 = new Categoria(6, "Multas");
        
            //Instancias de la clase ServicioFijo
        ServicioFijo servicioFijo1 = new ServicioFijo(1, "Jardineria ", 100, categoria2);
        ServicioFijo servicioFijo2 = new ServicioFijo(2, "Conserjeria", 50, categoria4);
        
            //Instancias de la clase ServicioOpcional
        ServicioOpcional servicioOpcional1 = new ServicioOpcional(1, "Piscina    ", 60, categoria2);
        ServicioOpcional servicioOpcional2 = new ServicioOpcional(2, "Paddle     ", 30, categoria3);
        
             //Instancias de la clase Proveedor
        Proveedor proveedor1 = new Proveedor(1, "Jardines Eden", "C/Serrano, 3", "666888777","jardineden@gmail.com");
        Proveedor proveedor2 = new Proveedor(2, "Multiservicios 24H", "C/Velazquez, 8", "666521485","multiservs@gmail.com");
        Proveedor proveedor3 = new Proveedor(3, "Luxury Pools", "Avda.Estacion, 21", "668741963","luxpools@gmail.com");
        Proveedor proveedor4 = new Proveedor(4, "Paddle Club", "Ctra. Malaga", "669874512","paddleclub@gmail.com");
        Proveedor proveedor5 = new Proveedor(5, "Atlas Services", "C/Jaul", "669879854","atlas@gmail.com");
        
            //Instancias de la clase Gasto
        Gasto gasto1 = new Gasto(
                         1,
                  "Talado de palmeras",
                LocalDate.parse("01/11/2022",DateTimeFormatter.ofPattern("d/M/yyyy")),
                   LocalDate.parse("30/11/2022",DateTimeFormatter.ofPattern("d/M/yyyy")),
                   proveedor1,
                  "JR345",
                   categoria2,
                     1000
        );
        Gasto gasto2 = new Gasto(
                         2,
                  "Red Paddle",
                LocalDate.parse("10/11/2022",DateTimeFormatter.ofPattern("d/M/yyyy")),
                   LocalDate.parse("20/11/2022",DateTimeFormatter.ofPattern("d/M/yyyy")),
                   proveedor4,
                  "JR345",
                   categoria3,
                     200
        );
        
        
    //Operaciones de almacenamiento dentro de las estructuras de datos
            
            //Guardamos los Vecinos instanciados dentro de un ArrayList de Vecinos
        admin.saveVecino(vecino1);
        admin.saveVecino(vecino2);
        admin.saveVecino(vecino3);
        admin.saveVecino(vecino4);
        admin.saveVecino(vecino5);
        
            //Guardamos los inmuebles instanciados dentro de un ArrayList de Inmuebles
        admin.saveInmueble(inmueble1);
        admin.saveInmueble(inmueble2);
        admin.saveInmueble(inmueble3);
        admin.saveInmueble(inmueble4);
        admin.saveInmueble(inmueble5);
        
            //Guardamos las categorias instanciados dentro de un ArrayList de Categorias
        admin.saveCategoria(categoria1);
        admin.saveCategoria(categoria2);
        admin.saveCategoria(categoria3);
        admin.saveCategoria(categoria4);
        admin.saveCategoria(categoria5);
        admin.saveCategoria(categoria6);
        
            //Guardamos los servicios fijos instanciados dentro de un ArrayList de Servicios Fijos
            //Al ser servicios fijos se incluiran en todos los inmuebles creados
        admin.saveServicioFijo(servicioFijo1);
        admin.asignarServicioFijoInmuebles(servicioFijo1);
        admin.saveServicioFijo(servicioFijo2);
        admin.asignarServicioFijoInmuebles(servicioFijo2);
        
            //Guardamos los servicios opcionales dentro de un Array de Servicios opcionales
        admin.saveServicioOpcional(servicioOpcional1);
        admin.saveServicioOpcional(servicioOpcional2);
        
            //Asignamos varios servicios opcionales a varios inmuebles
        admin.asignarServicioOpcionalInmueble(servicioOpcional1, inmueble1);
        admin.asignarServicioOpcionalInmueble(servicioOpcional2, inmueble1);
        admin.asignarServicioOpcionalInmueble(servicioOpcional1, inmueble2);
        admin.asignarServicioOpcionalInmueble(servicioOpcional2, inmueble2);
        admin.asignarServicioOpcionalInmueble(servicioOpcional1, inmueble3);
        admin.asignarServicioOpcionalInmueble(servicioOpcional2, inmueble3);
        
            //Guardamos los proveedores instanciados dentro de un ArrayList de proveedores
        admin.saveProveedor(proveedor1);
        admin.saveProveedor(proveedor2);
        admin.saveProveedor(proveedor3);
        admin.saveProveedor(proveedor4);
        admin.saveProveedor(proveedor5);
        
            //Guardamos los gastos instanciados dentro de un ArrayList de gastos
        admin.saveGasto(gasto1);
        admin.saveGasto(gasto2);
        
        login = vecino2.login("fer@viu.es", "def");
        System.out.println(login);

    //Operaciones de eliminacion, update e impresion de VECINOS
        
            //Generamos una variable con la lista completa de vecinos y la imprimimos por pantalla
        List<Vecino> vecinos = admin.viewVecinos();
        System.out.println("VALOR INICIAL DEL ARRAY DE VECINOS \n");
        System.out.println(vecinos);
        
        //Eliminamos un vecino del ArrayList de Vecinos
        admin.deleteVecino(vecino5);
        
            //Actualizamos los datos del vecino seleccionado
        admin.updateVecino(vecino4, "Maria", "wer", "666555444", "maria@viu.es");
        
        
    //Operaciones de eliminacion, update e impresion de INMUEBLES
    
            //Generamos una variable con la lista completa de inmuebles y la imprimimos por pantalla
        List<Inmueble> inmuebles = admin.viewInmuebles();
        System.out.println("\n\nVALOR INICIAL DEL ARRAY DE INMUEBLES \n");
        System.out.println(inmuebles);
        
        //Eliminamos un inmueble del ArrayList de Inmuebles
        admin.deleteInmueble(inmueble5);
        
            //Actualizamos los datos del inmueble seleccionado
        admin.updateInmueble(inmueble4, vecino1, "Colon");
        
            //Eliminamos un vecino del ArrayList de Vecinos. Comprobamos si tiene inmuebles y desasignamos en ese caso
        admin.deleteVecino(vecino3);
        
    
    //Operaciones de eliminacion, update e impresion de CATEGORIAS
        
            //Generamos una variable con la lista completa de categorias y la imprimimos por pantalla
        List<Categoria> categorias = admin.viewCategorias();
        System.out.println("\n\nVALOR INICIAL DEL ARRAY DE CATEGORIAS \n");
        System.out.println(categorias);
        
            //Eliminamos una categoria del ArrayList de Categorias
        admin.deleteCategoria(categoria6);
        
            //Actualizamos los datos del inmueble seleccionado
        admin.updateCategoria(categoria5, "Tasas e Impuestos");
        
            
                
    //Operaciones de eliminacion, update e impresion de SERVICIOS FIJOS
    
            //Imprime el array de serviciosFijos
        List<ServicioFijo> serviciosFijos = admin.viewServiciosFijos();
        System.out.println("\n\nVALOR INICIAL DEL ARRAY DE SERVICIOS FIJOS \n");
        System.out.println(serviciosFijos);
    
            //Desasignacion del ServicioFijo que se va a eliminar de todos los inmuebles
        //admin.desasignarServicioFijoInmuebles(servicioFijo1);

            //Eliminacion del servicio Fijo
        //admin.deleteServicioFijo(servicioFijo1);
        
            //Update del serviciofijo asi como de todos los serviciosFijos asignados a los inmuebles
        //admin.updateServicioFijo(servicioFijo2, "Basura", 30, categoria1);
        
    
    //Operaciones de eliminacion, update e impresion de SERVICIOS OPCIONALES
    
            //Imprime el array de serviciosFijos
        List<ServicioOpcional> serviciosOpcionales = admin.viewServiciosOpcionales();
        System.out.println("\n\nVALOR INICIAL DEL ARRAY DE SERVICIOS OPCIONALES \n");
        System.out.println(serviciosOpcionales);
    
            //Desasignacion del ServicioFijo que se va a eliminar de todos los inmuebles
        admin.desasignarServicioOpcionalInmueble(servicioOpcional1, inmueble3);

            //Eliminacion del servicio Opcional
        admin.desasignarServicioOcionalInmuebles(servicioOpcional2);
        admin.deleteServicioOpcional(servicioOpcional2);
        
            //Update del serviciofijo asi como de todos los serviciosFijos asignados a los inmuebles
        admin.updateServicioOpcional(servicioOpcional1, "Gimnasio", 50, categoria3);
        
       
    //Operaciones de eliminacion, update e impresion de PROVEEDORES
       
            //Generamos una variable con la lista completa de inmuebles y la imprimimos por pantalla
        List<Proveedor> proveedores = admin.viewProveedores();
        System.out.println("\n\nVALOR INICIAL DEL ARRAY DE PROVEEDORES \n");
        System.out.println(proveedores);
        
            //Eliminamos un proveedor del ArrayList de proveedores
        admin.deleteProveedor(proveedor5);
        
            //Actualizamos los datos del inmueble seleccionado
        admin.updateProveedor(proveedor1, "Garden Express", "C/Altamira, 33", "665842684", "gardenex@gmail.com");
        
    //Operaciones de eliminacion, update e impresion de GASTOS
       
            //Generamos una variable con la lista completa de inmuebles y la imprimimos por pantalla
        List<Gasto> gastos = admin.viewGastos();
        System.out.println("\n\nVALOR INICIAL DEL ARRAY DE GASTOS \n");
        System.out.println(gastos);
        
            //Eliminamos un proveedor del ArrayList de Gasto
        //admin.deleteGasto(gasto1);
        
            //Actualizamos los datos del inmueble seleccionado
        admin.updateGasto(gasto1,
                 "Talado Setos",
                 LocalDate.parse("01/11/2022",DateTimeFormatter.ofPattern("d/M/yyyy")),
                    LocalDate.parse("30/11/2022",DateTimeFormatter.ofPattern("d/M/yyyy")),
                    proveedor4,
                   "GRF3",
                    categoria3,
                      500);
        
        
    //Operaciones de impresion despues de las actualizaciones    
        
            //Generamos una variable con la lista completa de vecinos y la imprimimos por pantalla una vez editados
        List<Vecino> vecinosEdit = admin.viewVecinos();
        
            //Generamos una variable con la lista completa de inmuebles y la imprimimos por pantalla
        List<Inmueble> inmueblesEditados = admin.viewInmuebles();
        
            //Generamos una variable con la lista completa de categorias y la imprimimos por pantalla
        List<Categoria> categoriasEditadas = admin.viewCategorias();
        
            //Generamos una variable con la lista completa de serviciosFijos y la imprimimos por pantalla una vez editados
        List<ServicioFijo> serviciosFijosEdit = admin.viewServiciosFijos();
        
            //Generamos una variable con la lista completa de serviciosOpcionales y la imprimimos por pantalla una vez editados
        List<ServicioOpcional> serviciosOpcionalesEdit = admin.viewServiciosOpcionales();
        
            //Generamos una variable con la lista completa de proveedores y la imprimimos por pantalla una vez editados
        List<Proveedor> proveedoresEdit = admin.viewProveedores();
        
            //Generamos una variable con la lista completa de gastos y la imprimimos por pantalla una vez editados
        List<Gasto> gastosEdit = admin.viewGastos();
        
        System.out.println("\n\nVALOR FINAL DEL ARRAY DE VECINOS \n");
        System.out.println(vecinosEdit);
        System.out.println("\n\nVALOR FINAL DEL ARRAY DE INMUEBLES \n");
        System.out.println(inmueblesEditados);
        System.out.println("\n\nVALOR FINAL DEL ARRAY DE CATEGORIAS \n");
        System.out.println(categoriasEditadas);
        System.out.println("\n\nVALOR FINAL DEL ARRAY DE SERVICIOS FIJOS \n");
        System.out.println(serviciosFijosEdit);
        System.out.println("\n\nVALOR FINAL DEL ARRAY DE SERVICIOS OPCIONALES \n");
        System.out.println(serviciosOpcionalesEdit);
        System.out.println("\n\nVALOR FINAL DEL ARRAY DE PROVEEDORES \n");
        System.out.println(proveedoresEdit);
        System.out.println("\n\nVALOR FINAL DEL ARRAY DE GASTOS \n");
        System.out.println(gastosEdit);
        
        
        Liquidacion liquidacion1 = admin.generarLiquidacion(
                 LocalDate.parse("01/11/2022",DateTimeFormatter.ofPattern("d/M/yyyy")),
                   LocalDate.parse("30/11/2022",DateTimeFormatter.ofPattern("d/M/yyyy")), 
            inmueble1);
        
        admin.saveLiquidacion(liquidacion1);
        
        List<Liquidacion> liquidacionesEdit = admin.viewLiquidaciones();
        System.out.println(liquidacionesEdit);
    }
    
}
