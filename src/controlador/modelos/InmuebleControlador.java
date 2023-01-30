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
import javax.swing.JTable;
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
     * 
     * @param direccion 
     */
    public void registrarInmueble(String direccion) {
        Inmueble i = new Inmueble(direccion);
        si.insertarInmuebleDB(i);
    }

    /**
     * 
     * @param id
     * @param direccion
     * @param idVecino 
     */
    public void updateInmueble(int id, String direccion, String idVecino) {
        Vecino v = null;
        if (idVecino.equals("")) {
            v = null;
        } else {
            v = su.buscarId(Integer.parseInt(idVecino));
        }
        Inmueble i = new Inmueble(id, v, direccion);
        si.updateInmueble(i);
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
     * 
     * @param id 
     */
    public void eliminarInmueble(int id) {
        Inmueble i = si.buscarId(id);
        eliminarServicioCuentaServicio(i);
        si.borrarInmueble(i);
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
     * 
     * @param idInmueble
     * @return 
     */
    public List<ServicioCuenta> listarServiciosInmueble(int idInmueble){
        List<ServicioCuenta> listaServicioCuenta = ssc.buscarServiciosInmueble(idInmueble);
        return listaServicioCuenta;
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
     * 
     * @param vecinoId
     * @return 
     */
    public List<Inmueble> obtenerInmueblesVecino(int vecinoId) {
        List<Inmueble> lista = si.buscarInmueblesVecino(vecinoId);
        return lista;
    }

//    /**
//     * Método que permite la carga de la tabla inmuebles para proceder a su asignación
//     * @param tablaFuente tabla origen
//     * @param tablaDestino tabla que va a recibir los inmuebles
//     */
//    public void cargarTablaInmueblesAsignar(JTable tablaFuente, JTable tablaDestino) {
//        int[] rows = tablaFuente.getSelectedRows();
//        DefaultTableModel model = (DefaultTableModel) tablaDestino.getModel();
//        model.setNumRows(0);
//        for (int i = 0; i < rows.length; i++) {
//            model.addRow(new Object[]{tablaFuente.getValueAt(rows[i], 0), tablaFuente.getValueAt(rows[i], 1), tablaFuente.getValueAt(rows[i], 2)});
//        }
//
//    }

//    /**
//     *Método que permite cargar en contenido de la tabla de inmuebles sin servicios asociados
//     * @param tablaDestino tabla que va a recibir los inmuebles
//     * @param tablaServicios  tabla con los servicios disponibles
//     */
//    public void cargarTablaInmueblesSinServicio(JTable tablaDestino, JTable tablaServicios) {
//        int rowServicios = tablaServicios.getSelectedRow();
//        int idServicio = (int) tablaServicios.getValueAt(rowServicios, 0);
//        List<Inmueble> lista = obtenerInmueblesSinServicio(idServicio);
//        DefaultTableModel model = (DefaultTableModel) tablaDestino.getModel();
//        model.setNumRows(0);
//        for (int i = 0; i < lista.size(); i++) {
//            model.addRow(new Object[]{lista.get(i).getId(), lista.get(i).getDireccion(), lista.get(i).getVecino().getNombre() + " " + lista.get(i).getVecino().getApellidos()});
//        }
//    }

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
     * Método que permite asignar el vecino seleccionado a un inmueble
     * @param tabla tabla con el listado de inmuebles
     * @param lblId ID del vecino
     */
    public void AsignarInmueble(List<Inmueble> inmuebles, int idVecino) {
        Vecino v = su.buscarId(idVecino);
        for (Inmueble i : inmuebles) {
            si.updateInmueble(i);
        }
    }
    //Fin de la clase
}
