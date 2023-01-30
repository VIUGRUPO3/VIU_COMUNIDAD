// Asignatura: 21GIIN Proyectos Programación
// Profesor: Eduardo Zamudio
// @author: Grupo 3
// Miembros:
//       @author:Fernando Hernandez Fernandez
//       @author:Javier Barbero Sales
//       @author:Martin Gonzalez Dominguez
// @version: 08/01/2023/package controlador;
package controlador.modelos;

import com.toedter.calendar.JDateChooser;
import dao.ServicioGastos;
import dao.ServicioGastosConcepto;
import dao.ServicioInmuebles;
import dao.ServicioLiquidacion;
import dao.ServicioServicioCuentas;
import dao.ServicioServicios;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Gasto;
import modelo.GastoConcepto;
import modelo.Inmueble;
import modelo.Liquidacion;
import modelo.LiquidacionDetalleGasto;
import modelo.LiquidacionDetalleServicio;
import modelo.Servicio;
import modelo.ServicioCuenta;

/**
 *
 *  Clase que gestiona la liquidación
 */
public class LiquidacionControlador {

    //Atributos
    private final ServicioInmuebles S_I = new ServicioInmuebles();
    private final ServicioServicios S_S = new ServicioServicios();
    private final ServicioServicioCuentas S_S_C = new ServicioServicioCuentas();
    private final ServicioLiquidacion S_L = new ServicioLiquidacion();
    private final ServicioGastosConcepto S_G_C = new ServicioGastosConcepto();
    private final ServicioGastos S_G = new ServicioGastos();

    //Constructores
    /**
     *  Contructor de la clase
     */
    public LiquidacionControlador() {
    }

    //Metodos
    /**
     *  Metodo que genera la liquidacion entre dos fechas informadas
     * @param dtFechaInicioEL Fecha incial
     * @param dtFechaFinEL Fecha final
     * @param tabla tabla donde se muestra la liquidación o liquidciones realizadas
     */
    public void generarLiquidacion(JDateChooser dtFechaInicioEL, JDateChooser dtFechaFinEL, JTable tabla) {
        LocalDate fInicio = convertToLocalDateViaInstant(dtFechaInicioEL.getDate());
        LocalDate fFin = convertToLocalDateViaInstant(dtFechaFinEL.getDate());
        List<Inmueble> listaInmuebles = S_I.listarInmuebles();
        Liquidacion l = new Liquidacion(fInicio, fFin);
        S_L.insertarLiquidacionDB(l);
        l = S_L.ultimoIdLiquidacion();
        List<Gasto> gastosLiquidados = new ArrayList();

        //for (Inmueble inmueble : listaInmuebles) {
            //List<ServicioCuenta> listaServiciosInmueble = S_S_C.buscarServiciosInmueble(inmueble.getId());
            List<ServicioCuenta> listaSC = S_S_C.listarServicioCuenta();
            for (ServicioCuenta sc : listaSC) {
                Servicio s = S_S.buscarId(sc.getServicio().getId());
                int inmueblesAsociadosServicio = S_S_C.contarInmueblesAsociadosServicio(s);
                LiquidacionDetalleServicio lds = new LiquidacionDetalleServicio( l, sc, sc.getServicio().getTarifa());
                S_L.insertarLiquidacionDetalleServicioDB(lds);
                List<GastoConcepto> listaConceptos = S_G_C.buscarConceptosServicio(s.getId());
                for (GastoConcepto gc : listaConceptos) {
                    List<Gasto> listaGastosAsociados = S_G.buscarGastosAsociadosConcepto(gc);
                    for (Gasto g : listaGastosAsociados) {
                        if (g.getFechaRegistro().after(dtFechaInicioEL.getDate()) && g.getFechaRegistro().before(dtFechaFinEL.getDate()) && g.isLiquidado() == false) {
                            Double cuota = g.getImporte() / inmueblesAsociadosServicio;
                            LiquidacionDetalleGasto ldg = new LiquidacionDetalleGasto(gc.getNombre(), l, sc, cuota);
                            S_L.insertarLiquidacionDetalleGastoDB(ldg);
                            gastosLiquidados.add(g);
                        }
                    }
                }
            }
        //}
        l.setGastosLiquidados(gastosLiquidados);
        liquidarGastos(l);
    }
    /**
     * Recorre los gastos incluidos en la liquidacion y establece el valor liquidado a TRUE
     * @param l liquidacion
     */
    private void liquidarGastos(Liquidacion l) {
        for (Gasto g : l.getGastosLiquidados()) {
            S_G.liquidarGasto(g);
        }
    }
    /**
     * COnvierte java.util.Date a LocalDate
     * @param dateToConvert tipo java.util.Date que vonvierte el Date
     * @return nos devuelve el LocalDate
     */
    public LocalDate convertToLocalDateViaInstant(java.util.Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
    /**
     * Nos facilita el ID del elemento seleccionado de la Tabla
     * @param row numero de fila
     * @param tabla tabla
     * @return nos devuelve el ID del row de la tabla
     */
    public int obtenerIdTabla(int row, JTable tabla) {
        int id = (int) tabla.getValueAt(row, 0);
        return id;
    }
    /**
     * Carga la tabla de liquidaciones que contenga la fecha solicitada
     * @param fecha fecha de liquidacion
     * @param tabla tabla donde se muestran las liquidaciones
     */
    public void cargarTablaLiquidaciones(Date fecha, JTable tabla) {
        String tipo;
        List<Liquidacion> lista = new ArrayList();
        if (fecha != null) {
            lista = S_L.buscarLiquidacion(fecha);
        } else {
            lista = S_L.listarLiquidaciones();
        }

        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setNumRows(0);
        for (int i = 0; i < lista.size(); i++) {
            model.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getFechaInicio(), lista.get(i).getFechaFin()});
        }
    }
    /**
     * Carga la tabla de liquidaciones con detalle y el importe final global Servicios
     * @param idLiquidacion id de liquidacion
     * @param tabla tabla para mostrar los datos de liquidación
     * @return cuota final
     */
    public Double cargarTablaLiquidacionDetalleServicios(int idLiquidacion, JTable tabla) {
        String tipo;
        Double cuotaFinal = 0.0;
        Liquidacion l = S_L.buscarId(idLiquidacion);
        List<LiquidacionDetalleServicio> lista = S_L.buscarLiquidacionDetalleServicio(l);
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setNumRows(0);
        for (int i = 0; i < lista.size(); i++) {
            model.addRow(new Object[]{lista.get(i).getSc().getInmueble().getDireccion(), lista.get(i).getSc().getServicio().getNombre(), lista.get(i).getCuota()});
            double cuota = lista.get(i).getCuota();
            cuotaFinal += cuota;
        }
        return cuotaFinal;
    }
    /**
     * Carga la tabla de liquidaciones con detalle y el importe final global Gastos
     * @param idLiquidacion id de liquidacion
     * @param tabla tabla para mostrar los datos de liquidación
     * @return cuota final
     */
    public Double cargarTablaLiquidacionDetalleGastos(int idLiquidacion, JTable tabla) {
        String tipo;
        Double cuotaFinal = 0.0;
        Liquidacion l = S_L.buscarId(idLiquidacion);
        List<LiquidacionDetalleGasto> lista = S_L.buscarLiquidacionDetalleGasto(l);
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setNumRows(0);
        for (int i = 0; i < lista.size(); i++) {
            model.addRow(new Object[]{lista.get(i).getSc().getInmueble().getDireccion(), lista.get(i).getGastoLiquidacion(), lista.get(i).getCuota()});
            Double cuota = lista.get(i).getCuota();
            cuotaFinal += cuota;
        }
        return cuotaFinal;
    }
    
    /**
     * Carga los datos de liquidaciones en el formulario en detalle
     * @param idLiquidacion Id liquidacion
     * @param dtFechaInicioEL fecha inicio
     * @param dtFechaFinEL fecha fin
     * @param txtIdEL Id de liquidacion en ediciónLiquidacion
     */
    public void cargarDatosLiquidacion(int idLiquidacion, JDateChooser dtFechaInicioEL, JDateChooser dtFechaFinEL, JTextField txtIdEL) {
        Liquidacion l = S_L.buscarId(idLiquidacion);
        txtIdEL.setText(Integer.toString(idLiquidacion));
        Date fechaInicioDate = Date.from(l.getFechaInicio().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date fechaFinDate = Date.from(l.getFechaFin().atStartOfDay(ZoneId.systemDefault()).toInstant());
        dtFechaInicioEL.setDate(fechaInicioDate);
        dtFechaFinEL.setDate(fechaFinDate);
    }
    /**
     * Carga tabla de liquidaciones de un inmueble
     * @param idInmueble id inmueble
     * @param tabla tabla donde muestra los resultados
     */
//    public void cargarTablaLiquidacionesInmueble(int idInmueble, JTable tabla) {
//        String tipo;
//       
//        List<Liquidacion> lista = new ArrayList();
//        lista = S_L.buscarLiquidacionInmueble(idInmueble);
//        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
//        model.setNumRows(0);
//        for (int i = 0; i < lista.size(); i++) {
//            model.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getFechaInicio(), lista.get(i).getFechaFin()});
//        }
//    }
    /**
     * Carga tabla de liquidaciones de un inmueble en detalle
     * @param idInmueble id inmueble
     * @param idLiquidacion id liquidacion
     * @param lblTotalEI label con el coste total del inmueble en EdilicionInueble
     * @param tabla tabla donde muestra los datos
     */
    public void cargarTablaLiquidacionDetalleInmueble(int idInmueble, int idLiquidacion, JLabel lblTotalEI, JTable tabla) {
        String tipo;
        Liquidacion l = S_L.buscarId(idLiquidacion);
        Double cuotaFinal = 0.0;
        List<LiquidacionDetalleServicio> listaServicios = S_L.buscarLiquidacionDetalleServicioInmueble(idInmueble, idLiquidacion);
        List<LiquidacionDetalleGasto> listaGastos = S_L.buscarLiquidacionDetalleGastoInmueble(idInmueble, idLiquidacion);
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setNumRows(0);
        for (int i = 0; i < listaServicios.size(); i++) {
            model.addRow(new Object[]{"SERVICIO", listaServicios.get(i).getSc().getServicio().getNombre(), listaServicios.get(i).getCuota()});
            Double cuota = listaServicios.get(i).getCuota();
            cuotaFinal += cuota;
        }
        for (int i = 0; i < listaGastos.size(); i++) {
            model.addRow(new Object[]{"GASTO", listaGastos.get(i).getGastoLiquidacion(), listaGastos.get(i).getCuota()});
            Double cuota = listaGastos.get(i).getCuota();
            cuotaFinal += cuota;
        }
        lblTotalEI.setText(String.format("%,.2f", cuotaFinal) + "€");
    }
    
    public List<LiquidacionDetalleServicio> serviciosLiquidadosInmueble(int idInmueble, int idLiquidacion){
        List<LiquidacionDetalleServicio> listaServicios = S_L.buscarLiquidacionDetalleServicioInmueble(idInmueble, idLiquidacion);
        return listaServicios;
    }
    
    public List<LiquidacionDetalleGasto> gastosLiquidadosInmueble(int idInmueble, int idLiquidacion){
        List<LiquidacionDetalleGasto> listaGastos = S_L.buscarLiquidacionDetalleGastoInmueble(idInmueble, idLiquidacion);
        return listaGastos;
    }
    public Liquidacion obtenerLiquidacion(int id){
        Liquidacion l  = S_L.buscarId(id);
        return l;
    }
    public List<Liquidacion> buscarLiquidacionInmueble(int idServicioCuenta){
        List<Liquidacion> listaLiquidacion = S_L.buscarLiquidacionInmueble(idServicioCuenta);
        return listaLiquidacion;
    }

    //Fin de la clase
}
