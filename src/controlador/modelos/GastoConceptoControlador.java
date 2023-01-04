/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.modelos;

import dao.ServicioGastosConcepto;
import dao.ServicioInmuebles;
import dao.ServicioServicioCuentas;
import dao.ServicioServicios;
import dao.ServicioUsuarios;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.GastoConcepto;
import modelo.GastoConceptoSimple;
import modelo.Inmueble;
import modelo.Servicio;
import modelo.ServicioCuenta;

/**
 *
 * @author fer
 */
public class GastoConceptoControlador {

    //Atributos
    private ServicioInmuebles si = new ServicioInmuebles();
    private ServicioUsuarios su = new ServicioUsuarios();
    private ServicioServicios ss = new ServicioServicios();
    private ServicioServicioCuentas ssc = new ServicioServicioCuentas();
    private ServicioGastosConcepto sgc = new ServicioGastosConcepto();

    //Constructores
    public GastoConceptoControlador() {
    }

    //Metodos
    public void registrarGastoConcepto(JTextField txtNombreEGC, JTable tablaServicios, JTable tabla) {
        if(tablaServicios.getSelectedRow()>=0){
            Servicio s = ss.buscarId((int)tablaServicios.getValueAt(tablaServicios.getSelectedRow(), 0));
            GastoConcepto gc = new GastoConceptoSimple(txtNombreEGC.getText(),s);
            sgc.insertarGastoConceptoDB(gc);
        }
        cargarTablaConceptosGC("", tabla);
    }

    public void updateGastoConcepto(JTextField txtIdEGC, JTextField txtNombreEGC, JTable tablaServicios, JTable tabla) {
        int id = Integer.parseInt(txtIdEGC.getText());
        String nombre = txtNombreEGC.getText();
        Servicio s = ss.buscarId((int)tablaServicios.getValueAt(tablaServicios.getSelectedRow(), 0));
        GastoConcepto gc = new GastoConceptoSimple(id, nombre, s);
        sgc.updateGastoConcepto(gc);
        cargarTablaConceptosGC("", tabla);
    }

    public void eliminarGastoConcepto(JTable tabla) {
        int[] lista = tabla.getSelectedRows();
        if (lista.length != 0) {
            for (int row : lista) {
                int id =obtenerIdTablaGC(row, tabla);
                GastoConcepto gc =  sgc.buscarId(id);
                sgc.borrarGastoConcepto(gc);
            }
        }
        cargarTablaConceptosGC("", tabla);
    }
    
    

    public void cargarFormGastoConcepto(
            JTextField txtIdEGC,
            JTextField txtNombreEGC,
            JTable tablaServicios,
            JTable tabla) {
        int row = tabla.getSelectedRow();
        GastoConcepto gc = sgc.buscarId(obtenerIdTablaGC(row, tabla));
        Servicio s = gc.getServicio();
        txtIdEGC.setText(Integer.toString(gc.getId()));
        txtNombreEGC.setText(gc.getNombre());
        cargarTablaServiciosEGC(s, tablaServicios);
    }

    public int obtenerIdTablaGC(int row, JTable tabla) {
        int id = (int) tabla.getValueAt(row, 0);
        return id;
    }
    public int obtenerIdServicioTablaGC(int row, JTable tabla) {
        int idServicio = (int) tabla.getValueAt(row, 2);
        return idServicio;
    }

    public void cargarTablaConceptosGC(String nombre, JTable tabla) {
        
        List<GastoConcepto> lista = sgc.buscarGastoConcepto(nombre);
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setNumRows(0);
        for (int i = 0; i < lista.size(); i++) {
            Servicio s = lista.get(i).getServicio();
            List<GastoConcepto> hijos = sgc.buscarConceptosHijos(lista.get(i).getId());
           
            model.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getNombre(), s.getNombre(),hijos});
        }
    }
    
    public void cargarTablaServiciosEGC(Servicio s, JTable tabla) {
        String tipo;
        List<Servicio> lista = ss.buscarServicios("");
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setNumRows(0);
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).isOpcional() == true) {
                tipo = "Opcional";
            } else {
                tipo = "Obligatorio";
            }
            model.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getNombre(), lista.get(i).getTarifa(), tipo});
            if(lista.get(i).equals(s)){
                tabla.setRowSelectionInterval(i, i);
            }
        }
    }

    public void cargarConceptoSelected(JTable tabla, JLabel lblIdJGC, JLabel lblNombreJGC, JLabel lblServicioJGC){
        int row = tabla.getSelectedRow();
        GastoConcepto gc = sgc.buscarId((int) tabla.getValueAt(row, 0));
        
        lblIdJGC.setText(Integer.toString(gc.getId()));
        lblNombreJGC.setText(gc.getNombre());
        lblServicioJGC.setText(gc.getServicio().getNombre() );
        
    }
    
    public void cargarTablaConceptosPorServicio(JTable tablaDestino, JTable tablaFuente){
        int rowConcepto = tablaFuente.getSelectedRow();
        int idConcepto = (int) tablaFuente.getValueAt(rowConcepto, 0);
        GastoConcepto gc = sgc.buscarId(idConcepto);
        List<GastoConcepto> lista = sgc.buscarConceptosServicio(gc.getServicio().getId());
        DefaultTableModel model = (DefaultTableModel) tablaDestino.getModel();
        model.setNumRows(0);
        for (int i = 0; i < lista.size(); i++) {
            if(!lista.get(i).equals(gc)){
                model.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getNombre(), lista.get(i).getServicio().getNombre()});
            }
        }
    }
   
    public void cargarTablaConceptosAsignar(JTable tablaFuente, JTable tablaDestino){
        int[] rows = tablaFuente.getSelectedRows();
        DefaultTableModel model = (DefaultTableModel) tablaDestino.getModel();
        model.setNumRows(0);
        for (int i = 0; i < rows.length; i++) {
            model.addRow(new Object[]{tablaFuente.getValueAt(rows[i], 0), tablaFuente.getValueAt(rows[i], 1), tablaFuente.getValueAt(rows[i], 2)});
        }
    }
    
    public void registrarJerarquia(JLabel lblIdJGC, JTable tblSeleccionConceptosJGC){
        int idConceptoPadre = Integer.parseInt((String)lblIdJGC.getText());
        
        int rows = tblSeleccionConceptosJGC.getRowCount();
        for(int i = 0; i<rows ; i++){
            int idConceptoHijo = (int)tblSeleccionConceptosJGC.getValueAt(i, 0);
            if(sgc.existeIdJerarquia(idConceptoHijo)==false){
                sgc.insertarJerarquia(idConceptoPadre, idConceptoHijo);
            }else{
                sgc.updateJerarquia(idConceptoPadre, idConceptoHijo);
            }
            
        }
        
    }
    
    //Fin de la clase
}
