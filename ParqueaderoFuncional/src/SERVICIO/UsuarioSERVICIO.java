/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICIO;

import DATO.EmpresaNoExisteException;
import DATO.UsuarioNoExisteException;
import DATO.UsuarioRepetidoException;
import DATO.UsuariosDAO;
import MODELO.Factura;
import MODELO.Puerta;
import MODELO.Tarjeta;
import MODELO.Usuario;
import MODELO.Vehiculo;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.josql.QueryExecutionException;
import org.josql.QueryParseException;

/**
 *
 * @author gube
 */
public class UsuarioSERVICIO {

    private FacturaSERVICIO fs = new FacturaSERVICIO();

//    public void guardarUsuario(String nombre, String apellido, String cedula, String telefono, LinkedList<Vehiculo> listVehiculosDeUsuario) throws
    public void guardarUsuario(Usuario usuario) throws
	    DatoInvalidoException, UsuarioRepetidoException, UsuarioNoExisteException, QueryParseException, QueryExecutionException, FacturaExistenteException, FechasErroneasException {
	if (this.validarDatos(usuario.getPrimerNombre())) {
	    throw new DatoInvalidoException("Campo nombre es requerido");
	}
	if (this.validarDatos(usuario.getPrimerApellido())) {
	    throw new DatoInvalidoException("Campo apellido es requerido");
	}
//        if (!this.validarDatos(cedula) || cedula.length() != 10) {
//            throw new DatoInvalidoException("Cédula Invalida, verifique los datos de la cédula");
//        }
	if (this.validarDatos(usuario.getTelefono())) {
	    throw new DatoInvalidoException("Campo telefono es requerido");
	}
	if (usuario.getVehiculos().isEmpty()) {
	    throw new DatoInvalidoException("Se debe agregar al menos un vehiculo ");
	}
//        Usuario usuario= new Usuario(nombre, apellido, cedula, telefono,listVehiculosDeUsuario);
//        Usuario usuario = new Usuario(nombre, apellido, cedula, telefono, new Vehiculo(placa, marca, modelo), new Tarjeta());
//        switch (tipotarifa) {
//            case "Docente":
//                usuario.tarifaDocente();
//                break;
//            case "Estudiante":
//                usuario.tarifaEstudiante();
//                break;
//            case "Empleado":
//                usuario.tarifaEmpleado();
//                break;
//        }//si esta en modo c se creara un nuevo usuario , si esta en modo m se modificara el usuario
//        if (modo.equalsIgnoreCase("c")) {
//            if (!
	UsuariosDAO.getInstancia().guardar(usuario);
//) {// se lanzara una excepcion en caso de ya exisir el usuario
//                throw new UsuarioRepetidoException("El usuario de cedula : " + usuario.getCedula() + " ya existe");
//            }
//        } else if (modo.equalsIgnoreCase("m")) {
//            if (!UsuariosDAO.getInstancia().modificar(usuario, cedula)) {
//                if (fs.existeFactura(cedula)) {
//                    fs.modificarDatosFactura(usuario);
//                }
//            }
//        }
	System.out.println("Usuario creado y guardado correctamente");
    }
    
    
    public void modificarUsuario(Long id,Usuario usuario) throws
	    DatoInvalidoException, UsuarioRepetidoException, UsuarioNoExisteException, QueryParseException, QueryExecutionException, FacturaExistenteException, FechasErroneasException, IOException {
	if (this.validarDatos(usuario.getPrimerNombre())) {
	    throw new DatoInvalidoException("Campo nombre es requerido");
	}
	if (this.validarDatos(usuario.getPrimerApellido())) {
	    throw new DatoInvalidoException("Campo apellido es requerido");
	}
//        if (!this.validarDatos(cedula) || cedula.length() != 10) {
//            throw new DatoInvalidoException("Cédula Invalida, verifique los datos de la cédula");
//        }
	if (this.validarDatos(usuario.getTelefono())) {
	    throw new DatoInvalidoException("Campo telefono es requerido");
	}
	if (usuario.getVehiculos().isEmpty()) {
	    throw new DatoInvalidoException("Se debe agregar al menos un vehiculo ");
	}
	UsuariosDAO.getInstancia().modificar(usuario, id);

	System.out.println("Usuario modificado y guardado correctamente");
    }

    public void agregarCampusParqueadero(String cedula, String codigoCampus, String codigoParqueadero) throws QueryParseException, QueryExecutionException, UsuarioNoExisteException, EmpresaNoExisteException {
	List<Puerta> puertas = EmpresaSERVICIO.getInstancia().recuperarParqueaderoDeCampus(codigoCampus, codigoParqueadero).getPuertas();
//        UsuariosDAO.getInstancia().obtener(cedula).getTarjeta().agregarPermisos(codigoCampus, codigoParqueadero, puertas);
    }

    private boolean validarDatos(String dato) {
	return (dato.isEmpty() || dato.trim().length() == 0);
    }

    public Usuario recuperarUsuario(Long id) throws QueryParseException, QueryExecutionException, UsuarioNoExisteException, IOException {
	return UsuariosDAO.getInstancia().obtener(id);
    }

    public boolean eliminarUsuario(Long id) throws QueryParseException, QueryExecutionException, UsuarioNoExisteException, IOException {
	return UsuariosDAO.getInstancia().eliminar(id);
    }

    public boolean agregarFacturaUsuario(String cedula, Factura factura) throws QueryParseException, QueryExecutionException, UsuarioNoExisteException {
//        return UsuariosDAO.getInstancia().obtener(cedula).agregarFactura(factura);
	return false;
    }

    public List<Usuario> recuperarUsuarios() throws UsuarioNoExisteException, QueryExecutionException, QueryParseException, IOException {
	List<Usuario> usuarios = UsuariosDAO.getInstancia().obtenerListaUsuario("cedula");
	if (usuarios.isEmpty()) {
	    throw new UsuarioNoExisteException("No existe usuarios creados");
	}
	return usuarios;
    }
}
