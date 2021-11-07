/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICIO;

import DAO.FacturaDAO;
import DAO.UsuarioNoExisteException;
import MODELO.DetalleFactura;
import MODELO.Factura;
import MODELO.FacturaPendiente;
import MODELO.Usuario;
import java.util.Date;
import java.util.LinkedList;
import org.josql.QueryExecutionException;
import org.josql.QueryParseException;

/**
 *
 * @author Christian Quinde <christian24091992@gmail.com>
 */
public class FacturaSERVICIO {
//UsuarioSRV.getFacuraActual(cedula).agregarDetalleFactura(new detalleFactura)

    public boolean crearFactura(Usuario u, Date entrada, Date salida) throws FacturaExistenteException, FechasErroneasException, QueryParseException, QueryExecutionException, UsuarioNoExisteException {
        Date tiempo = new Date();
        double total = u.getTarifa().obtenerTarifa() * 1.12;
        double subtotal = u.getTarifa().obtenerTarifa();
        double iva = u.getTarifa().obtenerTarifa() * 0.12;
        if (!validarFechas(entrada, salida)) {
            throw new FechasErroneasException("Las fechas no son correctas");
        }
        Factura factura = new Factura(tiempo, total, subtotal, iva, new FacturaPendiente());
        factura.getListaDetalleFacturas().add(new DetalleFactura(entrada, salida));
//        new UsuarioSERVICIO().recuperarUsuario(u.getCedula()).agregarFactura(factura);
        if (FacturaDAO.getInstancia().existe(u.getCedula())) {
            throw new FacturaExistenteException("La factura de la persona con numero de cédula :" + u.getCedula() + " ya existe");
        } else if (FacturaDAO.getInstancia().agregar(u.getCedula(), factura)) {
            System.out.println("Factura creada con exito");
        }
        return true;
    }

    public boolean agregarDetalleFactura(String cedula, Date entrada, Date salida) throws FechasErroneasException {
        if (!validarFechas(entrada, salida)) {
            throw new FechasErroneasException("Las fechas no son correctas");
        }
        if (FacturaDAO.getInstancia().existe(cedula)) {
            FacturaDAO.getInstancia().getFacturas().get(cedula).getFirst().getListaDetalleFacturas().addFirst(new DetalleFactura(entrada, salida));
        }
        return true;
    }

    private boolean validarFechas(Date entrada, Date salida) {
        if (entrada.before(salida)) {
            return true;
        } else {
            return false;
        }
    }

    public LinkedList<Factura> recuperarFacturas(String cedula) {
        return FacturaDAO.getInstancia().buscar(cedula);
    }

    public boolean existeFactura(String cedula) {
        return FacturaDAO.getInstancia().existe(cedula);
    }

    public void modificarDatosFactura(Usuario u) {
        Date tiempo = new Date();
        double total = u.getTarifa().obtenerTarifa() * 1.12;
        double subtotal = u.getTarifa().obtenerTarifa();
        double iva = u.getTarifa().obtenerTarifa() * 0.12;
        FacturaDAO.getInstancia().buscar(u.getCedula()).get(0).setTotal(total);
        FacturaDAO.getInstancia().buscar(u.getCedula()).get(0).setTiempo(tiempo);
        FacturaDAO.getInstancia().buscar(u.getCedula()).get(0).setSubtotal(subtotal);
        FacturaDAO.getInstancia().buscar(u.getCedula()).get(0).setIva(iva);
    }
}
