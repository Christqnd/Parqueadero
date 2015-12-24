/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICIO;

import DAO.CampusNoExisteException;
import DAO.UsuarioNoExisteException;
import DAO.UsuarioRepetidoException;
import DAO.UsuariosDAO;
import MODELO.Factura;
import MODELO.Puerta;
import MODELO.Tarjeta;
import MODELO.Usuario;
import MODELO.Vehiculo;
import java.util.List;
import org.josql.QueryExecutionException;
import org.josql.QueryParseException;

/**
 *
 * @author gube
 */
public class UsuarioSERVICIO {

    private FacturaSERVICIO fs = new FacturaSERVICIO();

    public void guardarUsuario(String nombre, String apellido, String cedula, String telefono, String placa, String modelo, String marca, String tipotarifa, String modo) throws
            DatoInvalidoException, UsuarioRepetidoException, UsuarioNoExisteException, QueryParseException, QueryExecutionException, FacturaExistenteException, FechasErroneasException {
        if (!this.validarDatos(nombre)) {
            throw new DatoInvalidoException("Campo nombre es requerido");
        }
        if (!this.validarDatos(apellido)) {
            throw new DatoInvalidoException("Campo apellido es requerido");
        }
        if (!this.validarDatos(cedula) || cedula.length() != 10) {
            throw new DatoInvalidoException("Cédula Invalida, verifique los datos de la cédula");
        }
        if (!this.validarDatos(telefono)) {
            throw new DatoInvalidoException("Campo telefono es requerido");
        }
        if (!this.validarDatos(placa)) {
            throw new DatoInvalidoException("Campo placa es requerido");
        }
        if (!this.validarDatos(modelo)) {
            throw new DatoInvalidoException("Campo modelo es requerido");
        }
        if (!this.validarDatos(marca)) {
            throw new DatoInvalidoException("Campo marca es requerido");
        }

        if (!this.validarDatos(tipotarifa)) {
            throw new DatoInvalidoException("Seleccione el tipo de usuario a crear");
        }
        Usuario usuario = new Usuario(nombre, apellido, cedula, telefono, new Vehiculo(placa, marca, modelo), new Tarjeta());
        switch (tipotarifa) {
            case "Docente":
                usuario.tarifaDocente();
                break;
            case "Estudiante":
                usuario.tarifaEstudiante();
                break;
            case "Empleado":
                usuario.tarifaEmpleado();
                break;
        }//si esta en modo c se creara un nuevo usuario , si esta en modo m se modificara el usuario
        if (modo.equalsIgnoreCase("c")) {
            if (!UsuariosDAO.getInstancia().guardar(usuario)) {// se lanzara una excepcion en caso de ya exisir el usuario
                throw new UsuarioRepetidoException("El usuario de cedula : " + usuario.getCedula() + " ya existe");
            }
        } else if (modo.equalsIgnoreCase("m")) {
            if (!UsuariosDAO.getInstancia().modificar(usuario, cedula)) {
                if (fs.existeFactura(cedula)) {
                    fs.modificarDatosFactura(usuario);
                }
            }
        }
        System.out.println("Usuario creado y guardado correctamente");
    }

    public void agregarCampusParqueadero(String cedula, String codigoCampus, String codigoParqueadero) throws QueryParseException, QueryExecutionException, UsuarioNoExisteException, CampusNoExisteException {
        List<Puerta> puertas = CampusSERVICIO.getInstancia().recuperarParqueaderoDeCampus(codigoCampus, codigoParqueadero).getPuertas();
        UsuariosDAO.getInstancia().obtener(cedula).getTarjeta().agregarPermisos(codigoCampus, codigoParqueadero, puertas);
    }

    private boolean validarDatos(String dato) {
        return !(dato.isEmpty() || dato.length() == 0);
    }

    public Usuario recuperarUsuario(String cedula) throws QueryParseException, QueryExecutionException, UsuarioNoExisteException {
        return UsuariosDAO.getInstancia().obtener(cedula);
    }

    public boolean eliminarUsuario(String cedula) throws QueryParseException, QueryExecutionException, UsuarioNoExisteException {
        return UsuariosDAO.getInstancia().eliminar(cedula);
    }

    public boolean agregarFacturaUsuario(String cedula, Factura factura) throws QueryParseException, QueryExecutionException, UsuarioNoExisteException {
        return UsuariosDAO.getInstancia().obtener(cedula).agregarFactura(factura);
    }

    public List<Usuario> recuperarUsuarios() throws UsuarioNoExisteException, QueryExecutionException, QueryParseException {
        List<Usuario> usuarios = UsuariosDAO.getInstancia().obtenerListaUsuario("cedula");
        if (usuarios.isEmpty()) {
            throw new UsuarioNoExisteException("No existe usuarios creados");
        }
        return usuarios;
    }
}
