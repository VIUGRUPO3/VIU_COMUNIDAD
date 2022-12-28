/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.modelos;

import controlador.Controlador;
import dao.ServicioInmuebles;
import dao.ServicioUsuarios;
import java.util.List;
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
        cargarTablaInmuebles("");
    }

    public void updateInmueble() {
        int id = Integer.parseInt(ctrl.mainFrameAdmin.txtIdEI.getText());
        String direccion = ctrl.mainFrameAdmin.txtDireccionEI.getText();

        Vecino v = su.buscarId(Integer.parseInt(ctrl.mainFrameAdmin.txtIdVecinoEI.getText()));
        Inmueble i = new Inmueble(id, v, direccion);
        si.updateInmueble(i);
        cargarTablaInmuebles("");
    }

    public List<Inmueble> obtenerListaInmuebles(String direccion) {
        List<Inmueble> lista = si.buscarDireccion(direccion);
        return lista;
    }

    public void eliminarInmueble() {
        int[] lista = ctrl.mainFrameAdmin.jTable2.getSelectedRows();
        if (lista.length != 0) {
            for (int row : lista) {
                Inmueble i = si.buscarId(obtenerIdTablaInmuebles(row));
                si.borrarInmueble(i);
            }
        }
        cargarTablaInmuebles("");
    }

    public void cargarFormInmueble() {
        int row = ctrl.mainFrameAdmin.jTable2.getSelectedRow();
        Inmueble i = obtenerInmueble(obtenerIdTablaInmuebles(row));
        ctrl.mainFrameAdmin.txtIdEI.setText(Integer.toString(i.getId()));
        ctrl.mainFrameAdmin.txtDireccionEI.setText(i.getDireccion());
        Vecino v = i.getVecino();
        if (v != null) {
            ctrl.mainFrameAdmin.txtIdVecinoEI.setText(Integer.toString(v.getId()));
            ctrl.mainFrameAdmin.txtNombreEI.setText(v.getNombre());
            ctrl.mainFrameAdmin.txtApellidosEI.setText(v.getApellidos());
            ctrl.mainFrameAdmin.txtTelefonoEI.setText(v.getTelefono());
            ctrl.mainFrameAdmin.txtEmailEU.setText(v.getEmail());
        }else{
            ctrl.mainFrameAdmin.txtIdVecinoEI.setText("");
            ctrl.mainFrameAdmin.txtNombreEI.setText("");
            ctrl.mainFrameAdmin.txtApellidosEI.setText("");
            ctrl.mainFrameAdmin.txtTelefonoEI.setText("");
            ctrl.mainFrameAdmin.txtEmailEU.setText("");
        }

    }

    public Inmueble obtenerInmueble(int id) {
        Inmueble i = si.buscarId(id);
        return i;
    }

    public int obtenerIdTablaInmuebles(int row) {
        int id = (int) ctrl.mainFrameAdmin.jTable2.getValueAt(row, 0);
        return id;
    }

    public void cargarTablaInmuebles(String direccion) {
        List<Inmueble> lista = obtenerListaInmuebles(direccion);
        DefaultTableModel model = (DefaultTableModel) ctrl.mainFrameAdmin.jTable2.getModel();
        model.setNumRows(0);
        for (int i = 0; i < lista.size(); i++) {
            model.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getDireccion(), lista.get(i).getVecino().getNombre() + " " + lista.get(i).getVecino().getApellidos()});
        }
    }

    //Fin de la clase
}
