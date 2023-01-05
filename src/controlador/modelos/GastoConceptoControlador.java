// Asignatura: 21GIIN Proyectos Programación
// Profesor: Eduardo Zamudio
// @author: Grupo 3
// Miembros:
//       @author:Fernando Hernandez Fernandez
//       @author:Javier Barbero Sales
//       @author:Martin Gonzalez Dominguez
// @version: 08/01/2023/package controlador;

package controlador.modelos;

import dao.ServicioGastosConcepto;
import dao.ServicioInmuebles;
import dao.ServicioServicioCuentas;
import dao.ServicioServicios;
import dao.ServicioUsuarios;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.GastoConcepto;
import modelo.GastoConceptoSimple;
import modelo.Servicio;

/**
 * Clase GastoConceptoControlador
 */
public class GastoConceptoControlador {

    //Atributos

    /**
     * Atributo que definie el ServicioInmuebles
     */
    private ServicioInmuebles si = new ServicioInmuebles();

    /**
     * Atributo que definie el ServicioUsuarios
     */
    private ServicioUsuarios su = new ServicioUsuarios();

    /**
     * Atributo que definie el ServicioServicios
     */
    private ServicioServicios ss = new ServicioServicios();

    /**
     * Atributo que definie el ServicioServicioCuentas
     */
    private ServicioServicioCuentas ssc = new ServicioServicioCuentas();

    /**
     * Atributo que definie el ServicioGastosConcepto
     */
    private ServicioGastosConcepto sgc = new ServicioGastosConcepto();

    //Constructores

    /**
     * Constructor de Clase
     */
    public GastoConceptoControlador() {
    }

    //Metodos

    /**
     * Metodo que registra un nuevo GastoConcepto
     * @param txtNombreEGC Campo de Texto con el nombre del Gasto Concepto
     * @param tablaServicios tabla que contiene los servicios registrados
     * @param tabla tabla que contiene el listado de gastos
     */
    public void registrarGastoConcepto(JTextField txtNombreEGC, JTable tablaServicios, JTable tabla) {
        if(tablaServicios.getSelectedRow()>=0){
            Servicio s = ss.buscarId((int)tablaServicios.getValueAt(tablaServicios.getSelectedRow(), 0));
            GastoConcepto gc = new GastoConceptoSimple(txtNombreEGC.getText(),s);
            sgc.insertarGastoConceptoDB(gc);
        }
        cargarTablaConceptosGC("", tabla);
    }

    /**
     * Metodo que actualiza un GastoConcepto ya establecido anteriormente
     * @param txtIdEGC Id del GastoConcepto
     * @param txtNombreEGC Nombre del GastoConcepto
     * @param tablaServicios Tabla que contiene los servicios ofrecidos
     * @param tabla Tabla donde se almacena el listado de gastos
     */
    public void updateGastoConcepto(JTextField txtIdEGC, JTextField txtNombreEGC, JTable tablaServicios, JTable tabla) {
        int id = Integer.parseInt(txtIdEGC.getText());
        String nombre = txtNombreEGC.getText();
        Servicio s = ss.buscarId((int)tablaServicios.getValueAt(tablaServicios.getSelectedRow(), 0));
        GastoConcepto gc = new GastoConceptoSimple(id, nombre, s);
        sgc.updateGastoConcepto(gc);
        cargarTablaConceptosGC("", tabla);
    }

    /**
     * Método que elimina el GastoConcepto seleccionado de la tabla de GastoConceptos
     * @param tabla tabla GastoConcepto
     */
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
    
    /**
     * Método que obtiene los datos del GastoConcepto seleccionado
     * @param txtIdEGC Campo de texto con el ID del GastoConcepto seleccionado
     * @param txtNombreEGC Campo de texto con el nombre del GastoConcepto seleccionado
     * @param tablaServicios tabla que contiene los servicios
     * @param tabla tabla donde está seleccionado el GastoConcepto
     */
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

    /**
     * Método que obtiene el id de la fila de GastoConcepto seleccionada
     * @param row fila seleccionada
     * @param tabla tabla donde se ha seleccionado la fila
     * @return id devuelve el ID del GastoConcepto seleccionado
     */
    public int obtenerIdTablaGC(int row, JTable tabla) {
        int id = (int) tabla.getValueAt(row, 0);
        return id;
    }

    /**
     * Método que obtiene el ID del servicio seleccionado en la tabla mediante la fila indicada
     * @param row fila del servicio a obtener el id
     * @param tabla tabla que lista los servicios 
     * @return idServicio ID del servicio seleccionado
     */
    public int obtenerIdServicioTablaGC(int row, JTable tabla) {
        int idServicio = (int) tabla.getValueAt(row, 2);
        return idServicio;
    }

    /**
     * Método que carga la lista de ConceptoGastoConceptos en la tabla especificada 
     * @param nombre Nombre del GastoConcepto a buscar
     * @param tabla Tabla donde va a ser cargado el GastoConcepto
     */
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
    
    public void cargarTablaConceptosEdicion(GastoConcepto gc, JTable tabla) {
        
        List<GastoConcepto> lista = sgc.listarGastosConceptos();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setNumRows(0);
        for (int i = 0; i < lista.size(); i++) {
            Servicio s = lista.get(i).getServicio();
            List<GastoConcepto> hijos = sgc.buscarConceptosHijos(lista.get(i).getId());
       
            model.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getNombre(), s.getNombre(),hijos});
            if(lista.get(i).equals(gc)){
                tabla.setRowSelectionInterval(i, i);
            }
        
        }
    }
    
    /**
     * Método que carga la lista de EConceptoGastoConceptos en la tabla especificada 
     * @param s Nombre del Servicio a incluir
     * @param tabla Tabla donde se va a incluir el servicio
     */
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

    /**
     * Método que carga el Concepto seleccionado en la tabla indicada
     * @param tabla Tabla donde se va a cargar 
     * @param lblIdJGC
     * @param lblNombreJGC
     * @param lblServicioJGC
     */
    public void cargarConceptoSelected(JTable tabla, JLabel lblIdJGC, JLabel lblNombreJGC, JLabel lblServicioJGC){
        int row = tabla.getSelectedRow();
        GastoConcepto gc = sgc.buscarId((int) tabla.getValueAt(row, 0));
        
        lblIdJGC.setText(Integer.toString(gc.getId()));
        lblNombreJGC.setText(gc.getNombre());
        lblServicioJGC.setText(gc.getServicio().getNombre() );
        
    }
    
    /**
     *
     * @param tablaDestino
     * @param tablaFuente
     */
    public void cargarTablaConceptosPorServicio(JTable tablaDestino, JTable tablaFuente){
        int rowConcepto = tablaFuente.getSelectedRow();
        int idConcepto = (int) tablaFuente.getValueAt(rowConcepto, 0);
        GastoConcepto gc = sgc.buscarId(idConcepto);
        List<GastoConcepto> lista = sgc.buscarConceptosServicio(gc.getServicio().getId());
        DefaultTableModel model = (DefaultTableModel) tablaDestino.getModel();
        model.setNumRows(0);
        GastoConcepto gcPadre = sgc.buscarConceptosPadre(gc.getId());
        for (int i = 0; i < lista.size(); i++) {
            if(!lista.get(i).equals(gc) && !lista.get(i).equals(gcPadre)){
                model.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getNombre(), lista.get(i).getServicio().getNombre()});
            }
        }
    }
   
    /**
     *
     * @param tablaFuente
     * @param tablaDestino
     */
    public void cargarTablaConceptosAsignar(JTable tablaFuente, JTable tablaDestino){
        int[] rows = tablaFuente.getSelectedRows();
        DefaultTableModel model = (DefaultTableModel) tablaDestino.getModel();
        model.setNumRows(0);
        for (int i = 0; i < rows.length; i++) {
            model.addRow(new Object[]{tablaFuente.getValueAt(rows[i], 0), tablaFuente.getValueAt(rows[i], 1), tablaFuente.getValueAt(rows[i], 2)});
        }
    }
    
    /**
     *
     * @param lblIdJGC
     * @param tblSeleccionConceptosJGC
     */
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
    
    
    public void borrarJerarquia (JLabel lblIdJGC){
        int idConcepto = Integer.parseInt(lblIdJGC.getText());
        GastoConcepto gc = sgc.buscarId(idConcepto);
        sgc.borrarJerarquia(gc);
        
    }
    //Fin de la clase
}
