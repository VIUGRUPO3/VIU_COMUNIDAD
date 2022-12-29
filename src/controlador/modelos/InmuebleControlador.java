/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.modelos;

import controlador.Controlador;
import dao.ServicioInmuebles;
import dao.ServicioUsuarios;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Inmueble;
import modelo.usuario.Admin;
import modelo.usuario.Vecino;

/**
 *
 * @author fer
 */
public class InmuebleControlador {

    //Atributos
    private static ServicioInmuebles si = new ServicioInmuebles();
    private static ServicioUsuarios su = new ServicioUsuarios();
    private static Controlador ctrl = new Controlador();

    //Constructores
    public InmuebleControlador() {
    }

    //Metodos
    public void registrarInmueble() {
        String direccion = ctrl.mainFrameAdmin.txtDireccionEI.getText();
        Inmueble i = new Inmueble(direccion);
        si.insertarInmuebleDB(i);
        cargarTablaInmuebles("",ctrl.mainFrameAdmin.jTable2);
    }

    public void updateInmueble() {
        int id = Integer.parseInt(ctrl.mainFrameAdmin.txtIdEI.getText());
        Vecino v = null;
        String direccion = ctrl.mainFrameAdmin.txtDireccionEI.getText();
        if(ctrl.mainFrameAdmin.txtIdVecinoEI.getText().equals("")){
             v = null;
        }else{
            v = su.buscarId(Integer.parseInt(ctrl.mainFrameAdmin.txtIdVecinoEI.getText()));
        }
        Inmueble i = new Inmueble(id, v, direccion);
        si.updateInmueble(i);
        cargarTablaInmuebles("",ctrl.mainFrameAdmin.jTable2);
    }

    public List<Inmueble> obtenerListaInmuebles(String direccion) {
        List<Inmueble> lista = si.buscarDireccion(direccion);
        return lista;
    }

    public void eliminarInmueble() {
        int[] lista = ctrl.mainFrameAdmin.jTable2.getSelectedRows();
        if (lista.length != 0) {
            for (int row : lista) {
                Inmueble i = si.buscarId(obtenerIdTablaInmuebles(row, ctrl.mainFrameAdmin.jTable2));
                si.borrarInmueble(i);
            }
        }
        cargarTablaInmuebles("",ctrl.mainFrameAdmin.jTable2);
    }

    public void cargarFormInmueble() {
        int row = ctrl.mainFrameAdmin.jTable2.getSelectedRow();
        Inmueble i = obtenerInmueble(obtenerIdTablaInmuebles(row, ctrl.mainFrameAdmin.jTable2));
        ctrl.mainFrameAdmin.txtIdEI.setText(Integer.toString(i.getId()));
        ctrl.mainFrameAdmin.txtDireccionEI.setText(i.getDireccion());
        Vecino v = i.getVecino();
        if (v != null) {
            ctrl.mainFrameAdmin.txtIdVecinoEI.setText(Integer.toString(v.getId()));
            ctrl.mainFrameAdmin.txtNombreEI.setText(v.getNombre());
            ctrl.mainFrameAdmin.txtApellidosEI.setText(v.getApellidos());
            ctrl.mainFrameAdmin.txtTelefonoEI.setText(v.getTelefono());
            ctrl.mainFrameAdmin.txtEmailEI.setText(v.getEmail());
        }else{
            ctrl.mainFrameAdmin.txtIdVecinoEI.setText("");
            ctrl.mainFrameAdmin.txtNombreEI.setText("");
            ctrl.mainFrameAdmin.txtApellidosEI.setText("");
            ctrl.mainFrameAdmin.txtTelefonoEI.setText("");
            ctrl.mainFrameAdmin.txtEmailEI.setText("");
        }

    }

    public Inmueble obtenerInmueble(int id) {
        Inmueble i = si.buscarId(id);
        return i;
    }

    public int obtenerIdTablaInmuebles(int row, JTable tabla) {
        int id = (int) tabla.getValueAt(row, 0);
        return id;
    }

    public void cargarTablaInmuebles(String direccion, JTable tabla) {
        List<Inmueble> lista = obtenerListaInmuebles(direccion);
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setNumRows(0);
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getVecino()!=null){
               model.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getDireccion(), lista.get(i).getVecino().getNombre() + " " + lista.get(i).getVecino().getApellidos()}); 
            }else{
                model.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getDireccion(), " " });
            }
            
        }
    }
    
    public void cargarTablaVecinosAsignacion(String nombre, JTable tabla) {
        List<Vecino> lista = su.buscarNombre(nombre);
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setNumRows(0);
        for (int i = 0; i < lista.size(); i++) {
                model.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getNombre(), lista.get(i).getApellidos() });
        }
    }
    
    
    
    public void cargarTablaInmueblesSelected(JTable tablaFuente, JTable tablaDestino){
        int[] rows = tablaFuente.getSelectedRows();
        DefaultTableModel model = (DefaultTableModel) tablaDestino.getModel();
        model.setNumRows(0);
        for (int i = 0; i < rows.length; i++) {
                model.addRow(new Object[]{tablaFuente.getValueAt(rows[i], 0), tablaFuente.getValueAt(rows[i], 1)});
        }
    }
    
    public void cargarTablaInmueblesFromEdit(JTable tablaFuente, JTable tablaDestino, JButton boton, JButton boton2, JButton boton3, JTextField texto, Inmueble i){
        tablaFuente.setEnabled(false);
        boton.setEnabled(false);
        boton2.setEnabled(false);
        boton3.setEnabled(false);
        texto.setEnabled(false);
        DefaultTableModel model = (DefaultTableModel) tablaDestino.getModel();
        model.setNumRows(0);
        model.addRow(new Object[]{i.getId(), i.getDireccion()});
    }
    
    public void cargarVecinosSelected(JTable tabla, JLabel lblId, JLabel lblNombre, JLabel lblApellidos){
        int row = tabla.getSelectedRow();
        lblId.setText(Integer.toString((int)tabla.getValueAt(row, 0)));
        lblNombre.setText((String)tabla.getValueAt(row, 1));
        lblApellidos.setText((String)tabla.getValueAt(row, 2));
        
    }
    
    public boolean comprobarAsignacion(JTable tabla, JLabel lblId){
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        int rows = model.getRowCount();
        if(rows > 0 && !lblId.equals("")){
            return true;
        }else{
            return false;
        }
    }
    
    public void AsignarInmueble(JTable tabla, JLabel lblId){
        int rows = tabla.getRowCount();
        Vecino v = su.buscarId(Integer.parseInt(lblId.getText()));
        for(int i=0; i < rows; i++){
            Inmueble inmueble = new Inmueble((int)tabla.getValueAt(i, 0), v, (String)tabla.getValueAt(i, 1));
            si.updateInmueble(inmueble);
        }
    }
    //Fin de la clase
}
