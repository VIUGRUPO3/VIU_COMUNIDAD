// Asignatura: 21GIIN Proyectos Programación
// Profesor: Eduardo Zamudio
// @author: Grupo 3
// Miembros:
//       @author:Fernando Hernandez Fernandez
//       @author:Javier Barbero Sales
//       @author:Martin Gonzalez Dominguez
// @version: 01/12/2022/
// Paquete
package modelo;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase que gestiona las Liquidaciones
 *
 */
public class Liquidacion {

    //1.Atributos
    /**
     * ID de la liquidación
     *
     */
    private int id;

    /**
     * Fecha de inicio del periodo de la liquidación
     */
    private LocalDate fechaInicio;

    /**
     * Fecha de Fin del periodo de la liquidación
     */
    private LocalDate fechaFin;

    /**
     * Lista que contiene los gastos liquidados en liquidación
     */
    private List<Gasto> gastosLiquidados;

    //2.Constructores
    /**
     * Constructor de la clase Liquidacion
     */
    public Liquidacion() {
    }

    /**
     * Constructor de la clase Liquidacion
     *
     * @param id Identificador unico de Liquidacion
     * @param fechaInicio fecha de inicio de la liquidacion
     * @param fechaFin fecha de fin de la liquidacion
     *
     */
    public Liquidacion(int id, LocalDate fechaInicio, LocalDate fechaFin) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.gastosLiquidados = new ArrayList();
    }

    public Liquidacion(LocalDate fechaInicio, LocalDate fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.gastosLiquidados = new ArrayList();
    }
    
    

    //3.Métodos
    //Getters
    /**
     * Método para consultar el id de una liquidacion
     *
     * @return id identificador de liquidacion
     *
     */
    public int getId() {
        return id;
    }

    /**
     * Método para consultar la fecha de inicio de una liquidacion
     *
     * @return fechaInicio fecha de comienzo de la liquidacion
     *
     */
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Método para consultar la fecha de fin de una liquidacion
     *
     * @return fechaInicio fecha de finalizacion de la liquidacion
     *
     */
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    /**
     * Método para consultar los gastos liquidados en una liquidacion
     *
     * @return gastosLiquidados listado de gastos liquidados en la liquidacion
     *
     */
    public List<Gasto> getGastosLiquidados() {
        return gastosLiquidados;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setGastosLiquidados(List<Gasto> gastosLiquidados) {
        this.gastosLiquidados = gastosLiquidados;
    }

    
    
    /**
     * Método para establecer como liquidados todos los gastos correspondientes
     * a la liquidacion
     *
     * @param liquidacion liquidacion afectada
     *
     */
    //Marca como liquidados todos los gastos correspondientes a la liquidacion
    public void liquidarGastos(Liquidacion liquidacion) {
        liquidacion.gastosLiquidados.forEach(gasto -> {
            gasto.setLiquidado(true);
        });
    }

    /**
     * Método para generar una liquidacion
     *
     * @param fechaInicio fecha de inicio de la liquidacion
     * @param fechaFin fecha de fin de la liquidacion
     * @param comunidadCRUD objeto que contiene las liquidaciones de una
     * comunidad
     * @param liquidacion objeto que contiene la liquidacion generada
     *
     */
    public void generarLiquidacion(LocalDate fechaInicio, LocalDate fechaFin, ComunidadCRUD comunidadCRUD, Liquidacion liquidacion) {
        comunidadCRUD.inmuebles.forEach(inmueble -> {
            this.identificarServicios(comunidadCRUD, inmueble, liquidacion);
            this.identificarGastos(comunidadCRUD, fechaInicio, fechaFin, liquidacion, inmueble);
        });
        liquidacion.liquidarGastos(liquidacion);
        comunidadCRUD.liquidaciones.add(liquidacion);

    }

    /**
     * Método que imprime una liquidacion
     *
     * @param comunidadCRUD almacena todos los datos de la comunidad
     * @param liquidacionPrint Liquidacion que se desea imprimir
     */
    public void imprimirLiquidacion(ComunidadCRUD comunidadCRUD, Liquidacion liquidacionPrint) {
        comunidadCRUD.liquidaciones.forEach(liquidacion -> {
            System.out.println(liquidacionPrint);
            if (liquidacion == liquidacionPrint) {
                comunidadCRUD.inmuebles.forEach(inmueble -> {
                    double totalServicios = 0;
                    double totalGastos = 0;
                    double totalInmueble = 0;
                    System.out.println("\n" + inmueble);
                    System.out.println("---------------SERVICIOS---------------");
                    for (int index = 0; index < comunidadCRUD.liquidacionesDetalleServicio.size(); index++) {
                        if (comunidadCRUD.liquidacionesDetalleServicio.get(index).getLiquidacion() == liquidacionPrint && comunidadCRUD.liquidacionesDetalleServicio.get(index).getInmueble() == inmueble) {
                            System.out.println(comunidadCRUD.liquidacionesDetalleServicio.get(index));
                            totalServicios = totalServicios + comunidadCRUD.liquidacionesDetalleServicio.get(index).getCuota();
                        }
                    }

                    System.out.println("-------------------------------------------");
                    System.out.println("\n TOTAL SERVICIOS - " + totalServicios + "\n");
                    System.out.println("---------------GASTOS---------------");
                    for (int index2 = 0; index2 < comunidadCRUD.liquidacionesDetalleGasto.size(); index2++) {
                        if (comunidadCRUD.liquidacionesDetalleGasto.get(index2).getLiquidacion() == liquidacionPrint && comunidadCRUD.liquidacionesDetalleGasto.get(index2).getInmueble() == inmueble) {
                            System.out.println(comunidadCRUD.liquidacionesDetalleGasto.get(index2));
                            totalGastos = totalGastos + comunidadCRUD.liquidacionesDetalleGasto.get(index2).getCuota();
                        }
                    }
                    System.out.println("-------------------------------------------");
                    System.out.println("\n TOTAL GASTOS - " + totalGastos + "\n");
                    totalInmueble = totalGastos + totalServicios;
                    System.out.println("-------------------------------------------");
                    System.out.println("\n                       TOTAL INMUEBLE - " + totalInmueble + "\n\n");

                });

            }
        });
    }

    /**
     * Método que identifica los servicios a los que esta adscrito cada inmueble
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la comunidad
     * @param inmueble objeto inmueble con los datos del inmueble
     * @param liquidacion objeto liquidación con los datos de la liquidación
     */
    public void identificarServicios(ComunidadCRUD comunidadCRUD, Inmueble inmueble, Liquidacion liquidacion) {
        comunidadCRUD.serviciosCuenta.forEach(servicioCuenta -> {
            if (servicioCuenta.getInmueble() == inmueble) {
                LiquidacionDetalleServicio liquidacionDetalleServicio = new LiquidacionDetalleServicio(servicioCuenta.getServicio(), liquidacion, inmueble, servicioCuenta.getServicio().getTarifa());
                comunidadCRUD.liquidacionesDetalleServicio.add(liquidacionDetalleServicio);
            }
        });
    }

    /**
     * Método que identifica los gastos de la liquidacion
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la comunidad
     * @param fechaInicio fecha de inicio del gasto
     * @param fechaFin fecha de finalización del gasto
     * @param liquidacion objeto liquidación con los datos de la liquidación
     * @param inmueble objeto inmueble con los datos del inmueble
     */
    public void identificarGastos(ComunidadCRUD comunidadCRUD, LocalDate fechaInicio, LocalDate fechaFin, Liquidacion liquidacion, Inmueble inmueble) {
        comunidadCRUD.gastos.forEach(gasto -> {
            LocalDate fechaRegistro = convertToLocalDateViaInstant(gasto.getFechaRegistro());
            if (gasto.isLiquidado() == false && ((fechaRegistro.isAfter(fechaInicio) && fechaRegistro.isBefore(fechaFin))
                    || (fechaRegistro.isEqual(fechaInicio) || fechaRegistro.isEqual(fechaFin)))) {
                comunidadCRUD.gastosConcepto.forEach(gastoConcepto -> {
                    if (gasto.getGastoConcepto() == gastoConcepto) {

                        comunidadCRUD.liquidacionesDetalleServicio.forEach(liquidacionDetalleServicio -> {
                            if (gastoConcepto.getServicio() == liquidacionDetalleServicio.getServicio() && liquidacionDetalleServicio.getInmueble() == inmueble) {
                                //GastoLiquidacion gastoLiquidacion = new GastoLiquidacion(gastoConcepto.getNombre(), gasto.getImporte()/liquidacionDetalleServicio.getServicio().inmueblesAdheridos(comunidadCRUD));
                                LiquidacionDetalleGasto liquidacionDetalleGasto = new LiquidacionDetalleGasto(gastoConcepto.getNombre(), liquidacion, inmueble, gasto.getImporte() / liquidacionDetalleServicio.getServicio().inmueblesAdheridos(comunidadCRUD));
                                comunidadCRUD.liquidacionesDetalleGasto.add(liquidacionDetalleGasto);
                                this.gastosLiquidados.add(gasto);
                            }
                        });
                    }
                });
            }
        });
    }

    /**
     * Método para imprimir las liquidaciones de un inmueble espeificado
     *
     * @param comunidadCRUD objeto comunidad que contiene toda la información de
     * la comunidad
     * @param liquidacion objeto liquidación con los datos de la liquidación
     * @param inmueble objeto inmueble con los datos del inmueble
     */
    public void imprimirLiquidacionInmueble(ComunidadCRUD comunidadCRUD, Liquidacion liquidacion, Inmueble inmueble) {

        System.out.println("---------------SERVICIOS---------------");
        for (int index = 0; index < comunidadCRUD.liquidacionesDetalleServicio.size(); index++) {
            if (comunidadCRUD.liquidacionesDetalleServicio.get(index).getInmueble() == inmueble && comunidadCRUD.liquidacionesDetalleServicio.get(index).getLiquidacion() == liquidacion) {
                System.out.println(comunidadCRUD.liquidacionesDetalleServicio.get(index));
            }
        }
        System.out.println("---------------GASTOS---------------");
        for (int index2 = 0; index2 < comunidadCRUD.liquidacionesDetalleGasto.size(); index2++) {
            if (comunidadCRUD.liquidacionesDetalleGasto.get(index2).getInmueble() == inmueble && comunidadCRUD.liquidacionesDetalleGasto.get(index2).getLiquidacion() == liquidacion) {
                System.out.println(comunidadCRUD.liquidacionesDetalleGasto.get(index2));
            }
        }

    }
    
    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
    return dateToConvert.toInstant()
      .atZone(ZoneId.systemDefault())
      .toLocalDate();
    }

    /**
     * Método que devuelve el periodo de una liquidacion
     *
     * @return String cadena con el numero y perdiodo de una liquidacion
     *
     */
    @Override
    public String toString() {
        return "  -----------Liquidacion Nº" + id + "------------"
                + "\n----------------------------------------------"
                + "\nInicio - " + fechaInicio
                + "   ->   Fin -    " + fechaFin
                + "\n----------------------------------------------";
    }

}
