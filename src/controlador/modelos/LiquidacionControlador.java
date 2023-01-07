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
import dao.ServicioUsuarios;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
 * @author fer
 */
public class LiquidacionControlador {

    //Atributos
    private ServicioInmuebles si = new ServicioInmuebles();
    private ServicioUsuarios su = new ServicioUsuarios();
    private ServicioServicios ss = new ServicioServicios();
    private ServicioServicioCuentas ssc = new ServicioServicioCuentas();
    private ServicioLiquidacion sl = new ServicioLiquidacion();
    private ServicioGastosConcepto sgc = new ServicioGastosConcepto();
    private ServicioGastos sg = new ServicioGastos();

    //Constructores
    public LiquidacionControlador() {
    }

    //Metodos
    public void generarLiquidacion(JDateChooser dtFechaInicioEL, JDateChooser dtFechaFinEL, JTable tabla) {
        LocalDate fInicio = convertToLocalDateViaInstant(dtFechaInicioEL.getDate());
        LocalDate fFin = convertToLocalDateViaInstant(dtFechaFinEL.getDate());
        List<Inmueble> listaInmuebles = si.listarInmuebles();
        Liquidacion l = new Liquidacion(fInicio, fFin);
        sl.insertarLiquidacionDB(l);
        l = sl.ultimoIdLiquidacion();
        List<Gasto> gastosLiquidados = new ArrayList();

        for (Inmueble inmueble : listaInmuebles) {
            List<ServicioCuenta> listaServiciosInmueble = ssc.buscarServiciosInmueble(inmueble.getId());
            for (ServicioCuenta sc : listaServiciosInmueble) {
                Servicio s = ss.buscarId(sc.getServicio().getId());
                int inmueblesAsociadosServicio = ssc.ContarInmueblesAsociadosServicio(s);
                LiquidacionDetalleServicio lds = new LiquidacionDetalleServicio(s, l, inmueble, s.getTarifa());
                sl.insertarLiquidacionDetalleServicioDB(lds);
                List<GastoConcepto> listaConceptos = sgc.buscarConceptosServicio(s.getId());
                for (GastoConcepto gc : listaConceptos) {
                    List<Gasto> listaGastosAsociados = sg.buscarGastosAsociadosConcepto(gc);
                    for (Gasto g : listaGastosAsociados) {
                        if (g.getFechaRegistro().after(dtFechaInicioEL.getDate()) && g.getFechaRegistro().before(dtFechaFinEL.getDate()) && g.isLiquidado()== false) {
                            Double cuota = g.getImporte() / inmueblesAsociadosServicio;
                            LiquidacionDetalleGasto ldg = new LiquidacionDetalleGasto(gc.getNombre(), l, inmueble, cuota);
                            sl.insertarLiquidacionDetalleGastoDB(ldg);
                            gastosLiquidados.add(g);
                        }
                    }
                }
            }
        }
        l.setGastosLiquidados(gastosLiquidados);
        liquidarGastos(l);
    }

    private void liquidarGastos(Liquidacion l){
        for(Gasto g : l.getGastosLiquidados()){
            sg.liquidarGasto(g);
        }
    }
    public LocalDate convertToLocalDateViaInstant(java.util.Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    
   

    public int obtenerIdTabla(int row, JTable tabla) {
        int id = (int) tabla.getValueAt(row, 0);
        return id;
    }

    public void cargarTablaLiquidaciones(Date fecha, JTable tabla) {
        String tipo;
        List<Liquidacion> lista = new ArrayList();
        if(fecha != null){
            lista = sl.buscarLiquidacion(fecha);
        }else{
            lista = sl.listarLiquidaciones();
        }
        
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setNumRows(0);
        for (int i = 0; i < lista.size(); i++) {
            model.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getFechaInicio(), lista.get(i).getFechaFin()});
        }
    }

    public void cargarTablaLiquidacionDetalleServicios(int idLiquidacion, JTable tabla) {
        String tipo;
        Liquidacion l = sl.buscarId(idLiquidacion);
        List<LiquidacionDetalleServicio> lista = sl.buscarLiquidacionDetalleServicio(l);
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setNumRows(0);
        for (int i = 0; i < lista.size(); i++) {
            
            model.addRow(new Object[]{lista.get(i).getInmueble().getDireccion(), lista.get(i).getServicio().getNombre(), lista.get(i).getCuota()});
        }
    }
    
    public void cargarTablaLiquidacionDetalleGastos(int idLiquidacion, JTable tabla) {
        String tipo;
        Liquidacion l = sl.buscarId(idLiquidacion);
        List<LiquidacionDetalleGasto> lista = sl.buscarLiquidacionDetalleGasto(l);
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setNumRows(0);
        for (int i = 0; i < lista.size(); i++) {
            
            model.addRow(new Object[]{lista.get(i).getInmueble().getDireccion(), lista.get(i).getGastoLiquidacion(), lista.get(i).getCuota()});
        }
    }
    
    public void cargarDatosLiquidacion(int idLiquidacion, JDateChooser dtFechaInicioEL, JDateChooser dtFechaFinEL, JTextField txtIdEL) {
        Liquidacion l = sl.buscarId(idLiquidacion);
        txtIdEL.setText(Integer.toString(idLiquidacion));
        Date fechaInicioDate = Date.from(l.getFechaInicio().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date fechaFinDate = Date.from(l.getFechaFin().atStartOfDay(ZoneId.systemDefault()).toInstant());
        dtFechaInicioEL.setDate(fechaInicioDate);
        dtFechaFinEL.setDate(fechaFinDate);
    }

    
    
    //Fin de la clase
}
