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
            model.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getNombre(), s.getNombre()});
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

   
    //Fin de la clase
}
