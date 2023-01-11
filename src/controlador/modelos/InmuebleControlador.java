// Asignatura: 21GIIN Proyectos Programación
// Profesor: Eduardo Zamudio
// @author: Grupo 3
// Miembros:
//       @author:Fernando Hernandez Fernandez
//       @author:Javier Barbero Sales
//       @author:Martin Gonzalez Dominguez
// @version: 08/01/2023/package controlador;

package controlador.modelos;

import dao.ServicioInmuebles;
import dao.ServicioServicioCuentas;
import dao.ServicioUsuarios;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Inmueble;
import modelo.ServicioCuenta;
import modelo.usuario.Vecino;

/**
 *
 *Clase que Gestiona las operaciones sobre los inmuebles
 */
public class InmuebleControlador {

    //Atributos

    /**
     *Atributo que contiene el objeto ServicioInmuebles asociado
     */
    private ServicioInmuebles si = new ServicioInmuebles();

    /**
     *Atributo que contiene el objeto ServicioUsuarios asociado
     */
    private ServicioUsuarios su = new ServicioUsuarios();

    /**
     *Atributo que contiene el objeto ServicioServicioCuentas asociado
     */
    private ServicioServicioCuentas ssc = new ServicioServicioCuentas();

    //Constructores

    /**
     *Constructor de clase
     */
    public InmuebleControlador() {
    }

    //Metodos

    /**
     *Método que permite registrar un nuevo inmueble
     * @param txtDireccionEI Dirección del inmueble
     * @param tabla tabla donde se va a añadir el inmueble
     */
    public void registrarInmueble(JTextField txtDireccionEI, JTable tabla) {
        String direccion = txtDireccionEI.getText();
        Inmueble i = new Inmueble(direccion);
        si.insertarInmuebleDB(i);
        cargarTablaInmuebles("", tabla);
    }

    /**
     * Método que permite actualizar un inmueble
     * @param txtIdEI Id del inmueble
     * @param txtDireccionEI Direccion del inmueble
     * @param txtIdVecinoEI ID de vecino asociado al inmueble
     * @param tabla tabla que contiene los inmuebles
     */
    public void updateInmueble(JTextField txtIdEI, JTextField txtDireccionEI, JTextField txtIdVecinoEI, JTable tabla) {
        int id = Integer.parseInt(txtIdEI.getText());
        Vecino v = null;
        String direccion = txtDireccionEI.getText();
        if (txtIdVecinoEI.getText().equals("")) {
            v = null;
        } else {
            v = su.buscarId(Integer.parseInt(txtIdVecinoEI.getText()));
        }
        Inmueble i = new Inmueble(id, v, direccion);
        si.updateInmueble(i);
        cargarTablaInmuebles("", tabla);
    }

    /**
     * Método que obtiene el listado de inmuebles presentes en dicha dirección
    * @param direccion direccion del inmueble
     * @return lista listado de inmuebles en dicha dirección
     */
    public List<Inmueble> obtenerListaInmuebles(String direccion) {
        List<Inmueble> lista = si.buscarDireccion(direccion);
        return lista;
    }

    /**
     * Método que permite eliminar un inmueble
     * @param tabla tabla de inmuebles
     */
    public void eliminarInmueble(JTable tabla) {
        int[] lista = tabla.getSelectedRows();
        if (lista.length != 0) {
            for (int row : lista) {
                Inmueble i = si.buscarId(obtenerIdTablaInmuebles(row, tabla));
                eliminarServicioCuentaServicio(i);
                si.borrarInmueble(i);
            }
        }
        cargarTablaInmuebles("", tabla);
    }

    /**
     * Método para elimiinar un ServicioCuentaServicio asociado a un inmueble
     * @param i objeto inmueble
     */
    private void eliminarServicioCuentaServicio(Inmueble i) {
        List<ServicioCuenta> listaServicioCuenta = ssc.buscarServiciosInmueble(i.getId());
        for (ServicioCuenta sc : listaServicioCuenta) {
            ssc.borrarServicioCuenta(sc);
        }
    }

    /**
     * Método que carga los datos de un inmueble en el formulario en caso de haberle proporcionado un ID, en caso contrario los muestra vacíos
     * @param txtIdEI ID del inmueble
     * @param txtDireccionEI direccion del inmueble
     * @param txtIdVecinoEI ID del vecino asociado a dicho inmueble
     * @param txtNombreEI nombre del vecino asociado
     * @param txtApellidosEI Apellidos del vecino asociado
     * @param txtTelefonoEI Telefono del vecino asociado
     * @param txtEmailEI corero electrónico del vecino asociado
     * @param tabla tabla que contiene los inmuebles
     */
    public void cargarFormInmueble(
            JTextField txtIdEI,
            JTextField txtDireccionEI,
            JTextField txtIdVecinoEI,
            JTextField txtNombreEI,
            JTextField txtApellidosEI,
            JTextField txtTelefonoEI,
            JTextField txtEmailEI,
            JTable tabla) {
        int row = tabla.getSelectedRow();
        Inmueble i = obtenerInmueble(obtenerIdTablaInmuebles(row, tabla));
        txtIdEI.setText(Integer.toString(i.getId()));
        txtDireccionEI.setText(i.getDireccion());
        Vecino v = i.getVecino();
        if (v != null) {
            txtIdVecinoEI.setText(Integer.toString(v.getId()));
            txtNombreEI.setText(v.getNombre());
            txtApellidosEI.setText(v.getApellidos());
            txtTelefonoEI.setText(v.getTelefono());
            txtEmailEI.setText(v.getEmail());
        } else {
            txtIdVecinoEI.setText("");
            txtNombreEI.setText("");
            txtApellidosEI.setText("");
            txtTelefonoEI.setText("");
            txtEmailEI.setText("");
        }

    }

    /**
     * Método que devuelve el objeto inmueble asociado a un ID concreto
     * @param id ID del inmueble
     * @return i objeto inmueble
     */
    public Inmueble obtenerInmueble(int id) {
        Inmueble i = si.buscarId(id);
        return i;
    }

    /**
     * Método que obtiene el id del inmueble seleccionado
     * @param row fila seleccionada
     * @param tabla tabla donde se ha seleccionado el inmueble
     * @return id ID del inmueble seleccionado
     */
    public int obtenerIdTablaInmuebles(int row, JTable tabla) {
        int id = (int) tabla.getValueAt(row, 0);
        return id;
    }

    /**
     *Método que carga en una tabla los inmuebles asociados a una dirección
     * @param direccion dirección de los inmuebles
     * @param tabla tabla donde se van a mostrar los inmuebles
     */
    public void cargarTablaInmuebles(String direccion, JTable tabla) {
        List<Inmueble> lista = obtenerListaInmuebles(direccion);
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setNumRows(0);
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getVecino() != null) {
                model.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getDireccion(), lista.get(i).getVecino().getNombre() + " " + lista.get(i).getVecino().getApellidos()});
            } else {
                model.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getDireccion(), " "});
            }

        }
    }

    /**
     *Método que carga los inmuebles asociados a un vecino
     * @param vecinoId ID del vecino asociado a los inmuebles
     * @param tabla tabla donde se van a cargar los inmuebles
     */
    public void cargarTablaInmueblesVecino(int vecinoId, JTable tabla) {
        List<Inmueble> lista = si.buscarInmueblesVecino(vecinoId);
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setNumRows(0);
        for (int i = 0; i < lista.size(); i++) {
            model.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getDireccion(), lista.get(i).getVecino().getNombre() + " " + lista.get(i).getVecino().getApellidos()});
        }
    }

    /**
     *Método que permite asociar un vecino a un inmueble
     * @param nombre nombre del vecino
     * @param tabla tabla que contiene el inmueble a asignar
     */
    public void cargarTablaVecinosAsignacion(String nombre, JTable tabla) {
        List<Vecino> lista = su.buscarNombre(nombre);
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setNumRows(0);
        for (int i = 0; i < lista.size(); i++) {
            model.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getNombre(), lista.get(i).getApellidos()});
        }
    }

    /**
     * Método que carga los inmuebles seleccionados de una tabla en otra
     * @param tablaFuente tabla que contiene los inmuebles
     * @param tablaDestino tabla que contendrá los inmuebles
     * @param boton btnFiltrarInmuebleAI
     * @param boton2 btnLimpiarTablaAI
     * @param boton3 btnSeleccionarInmueblesAI
     * @param texto txtFiltrarInmuebleAI
     */
    public void cargarTablaInmueblesSelected(JTable tablaFuente, JTable tablaDestino, JButton boton, JButton boton2, JButton boton3, JTextField texto) {
        tablaFuente.setEnabled(true);
        boton.setEnabled(true);
        boton2.setEnabled(true);
        boton3.setEnabled(true);
        texto.setEnabled(true);
        int[] rows = tablaFuente.getSelectedRows();
        DefaultTableModel model = (DefaultTableModel) tablaDestino.getModel();
        model.setNumRows(0);
        for (int i = 0; i < rows.length; i++) {
            model.addRow(new Object[]{tablaFuente.getValueAt(rows[i], 0), tablaFuente.getValueAt(rows[i], 1)});
        }
    }

    /**
     * Método que envía la tabla inmuebles de la parte de edición a la tabla de resultados después de haber una edición/actualización de los mismos
     * @param tablaFuente Tabla origen
     * @param tablaDestino Tabla destino
     * @param boton boton de filtrado
     * @param boton2 boton de limpieza
     * @param boton3 boton seleccionar
     * @param texto texto de filtrador
     * @param i objeto inmueble
     */
    public void cargarTablaInmueblesFromEdit(JTable tablaFuente, JTable tablaDestino, JButton boton, JButton boton2, JButton boton3, JTextField texto, Inmueble i) {
        tablaFuente.setEnabled(false);
        boton.setEnabled(false);
        boton2.setEnabled(false);
        boton3.setEnabled(false);
        texto.setEnabled(false);
        DefaultTableModel model = (DefaultTableModel) tablaDestino.getModel();
        model.setNumRows(0);
        model.addRow(new Object[]{i.getId(), i.getDireccion()});
    }

    /**
     * Método que permite la carga de la tabla inmuebles para proceder a su asignación
     * @param tablaFuente tabla origen
     * @param tablaDestino tabla que va a recibir los inmuebles
     */
    public void cargarTablaInmueblesAsignar(JTable tablaFuente, JTable tablaDestino) {
        int[] rows = tablaFuente.getSelectedRows();
        DefaultTableModel model = (DefaultTableModel) tablaDestino.getModel();
        model.setNumRows(0);
        for (int i = 0; i < rows.length; i++) {
            model.addRow(new Object[]{tablaFuente.getValueAt(rows[i], 0), tablaFuente.getValueAt(rows[i], 1), tablaFuente.getValueAt(rows[i], 2)});
        }

    }

    /**
     *Método que permite cargar en contenido de la tabla de inmuebles sin servicios asociados
     * @param tablaDestino tabla que va a recibir los inmuebles
     * @param tablaServicios  tabla con los servicios disponibles
     */
    public void cargarTablaInmueblesSinServicio(JTable tablaDestino, JTable tablaServicios) {
        int rowServicios = tablaServicios.getSelectedRow();
        int idServicio = (int) tablaServicios.getValueAt(rowServicios, 0);
        List<Inmueble> lista = obtenerInmueblesSinServicio(idServicio);
        DefaultTableModel model = (DefaultTableModel) tablaDestino.getModel();
        model.setNumRows(0);
        for (int i = 0; i < lista.size(); i++) {
            model.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getDireccion(), lista.get(i).getVecino().getNombre() + " " + lista.get(i).getVecino().getApellidos()});
        }
    }

    /**
     *Método que obtiene un listado de los inmuebles sin determinado servicio
     * @param idServicio ID del servicio
     * @return InmueblesDisponibles Listado de inmuebles sin dicho servicio
     */
    public List<Inmueble> obtenerInmueblesSinServicio(int idServicio) {
        List<ServicioCuenta> listaCuentasServicio = ssc.buscarInmublesServicios(idServicio);
        List<Inmueble> listaInmueblesConServicio = new ArrayList();
        boolean inmueblePresente = false;
        for (ServicioCuenta sc : listaCuentasServicio) {
            listaInmueblesConServicio.add(sc.getInmueble());
        }
        List<Inmueble> listaInmuebles = si.listarInmuebles();
        List<Inmueble> InmueblesDisponibles = new ArrayList();
        for (Inmueble inmueble : listaInmuebles) {
            inmueblePresente = false;
            for (Inmueble inmuebleConServicio : listaInmueblesConServicio) {
                if (inmuebleConServicio.equals(inmueble)) {
                    inmueblePresente = true;
                }
            }
            if (inmueblePresente == false) {
                InmueblesDisponibles.add(inmueble);
            }
        }
        return InmueblesDisponibles;
    }

    /**
     * Método que permite comprobar si está presente determinado ID en una tabla
     * @param tabla tabla que comprobar si contiene el ID
     * @param lblId ID a comprobar
     * @return booleano booleando que indica si hay o no presencia de dicho ID en la tabla indicada
     */
    public boolean comprobarAsignacion(JTable tabla, JLabel lblId) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        int rows = model.getRowCount();
        if (rows > 0 && !lblId.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método que permite asignar el vecino seleccionado a un inmueble
     * @param tabla tabla con el listado de inmuebles
     * @param lblId ID del vecino
     */
    public void AsignarInmueble(JTable tabla, JLabel lblId) {
        int rows = tabla.getRowCount();
        Vecino v = su.buscarId(Integer.parseInt(lblId.getText()));
        for (int i = 0; i < rows; i++) {
            Inmueble inmueble = new Inmueble((int) tabla.getValueAt(i, 0), v, (String) tabla.getValueAt(i, 1));
            si.updateInmueble(inmueble);
        }
    }
    //Fin de la clase
}
