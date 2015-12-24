/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICIO;

import DAO.UsuarioNoExisteException;
import MODELO.Tarjeta;
import MODELO.Usuario;
import java.util.Date;
import org.josql.QueryExecutionException;
import org.josql.QueryParseException;

/**
 *
 * @author gube
 */
public class TarjetaSERVICIO {

    private Tarjeta tarjeta;
    private FacturaSERVICIO fs = null;
    private static TarjetaSERVICIO instancia = null;

    public TarjetaSERVICIO() {
        fs = new FacturaSERVICIO();
    }

    public static TarjetaSERVICIO getInstancia() {
        if (instancia == null) {
            instancia = new TarjetaSERVICIO();
        }
        return instancia;
    }

    public void CrearNuevaTarjeta() {
        this.tarjeta = new Tarjeta();
    }

    public void agregarCampus(String keyCampus) {

    }

    public boolean comprovarDatos(String cedula, String codigoCampus, String codigoParqueadero, String codigoPuerta, String modo) throws QueryParseException, QueryExecutionException, UsuarioNoExisteException, FacturaExistenteException, FechasErroneasException {
        Usuario usuario = new UsuarioSERVICIO().recuperarUsuario(cedula);
        boolean b = usuario.getTarjeta().verificar(codigoCampus, codigoParqueadero,codigoPuerta, modo, new Date());
        if (modo.equals("salir") && b) {
            if (!fs.existeFactura(cedula)) {
                fs.crearFactura(usuario, usuario.getTarjeta().getRegistroIngreso(), usuario.getTarjeta().getRegistroSalida());
            } else {
                fs.agregarDetalleFactura(cedula, usuario.getTarjeta().getRegistroIngreso(), usuario.getTarjeta().getRegistroSalida());
            }
        }
        return b;
    }

    /**
     * @return the tarjeta
     */
    public Tarjeta getTarjeta() {
        return tarjeta;
    }
}
