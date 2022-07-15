/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICIO;

import DATO.EmpresaDAO;
import DATO.EmpresaNoExisteException;
import DATO.EmpresaRepetidoException;
import MODELO.Empresa;
import MODELO.Parqueadero;
import MODELO.Puerta;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.josql.QueryExecutionException;
import org.josql.QueryParseException;

/**
 *
 * @author pablopc
 */
public class EmpresaSERVICIO {

    private boolean modificar = false;

    private Empresa empresa = null;

    private static EmpresaSERVICIO instancia = null;

    private EmpresaSERVICIO() {
    }

    public static EmpresaSERVICIO getInstancia() {
        if (instancia == null) {
            instancia = new EmpresaSERVICIO();
        }
        return instancia;
    }

    public List<Empresa> obtenerlistaEmpresa() throws QueryExecutionException, QueryParseException, IOException {
        return EmpresaDAO.getInstancia().obtenerListaEmpresas();
    }

    public void crearEmpresa(Empresa empresa) throws NombreEmpresaInvalidoException, EmpresaConNombreExistenteException, EmpresaRepetidoException {
//        if (EmpresaDAO.getInstancia().buscarPor(nombre)) {
//            throw new EmpresaConNombreExistenteException();
//        }

        if (empresa.getNombre().length() == 0 || empresa.getNombre() == null) {
            throw new NombreEmpresaInvalidoException();
        }

        if (empresa.getDescripcion().length() == 0 || empresa.getDescripcion() == null) {
            throw new NombreEmpresaInvalidoException();
        }

//        if (PuertasSERVICIO.getInstancia().getListapuertas().isEmpty()) {
//            throw new EmpresaSinPuertasException();
//        }
//        if (this.empresa.getParqueaderos().isEmpty()) {
//            throw new EmpresaVacioException();
//        }
//        if (EmpresaDAO.getInstancia().buscarPor(this.getEmpresa().getNombre())) {
//            throw new EmpresaConNombreExistenteException();
//        }
//        this.campus.setCant_puertas(PuertasSERVICIO.getInstancia().getListapuertas().size());
        EmpresaDAO.getInstancia().guardar(empresa);
//        PuertasSERVICIO.getInstancia().GuardarPuertas(this.empresa.getCodigo());

        this.empresa = new Empresa();
    }

    public void modificarEmpresa(String codigo, String nombre) throws NombreEmpresaInvalidoException {
        if (nombre.length() == 0 || nombre == null) {
            throw new NombreEmpresaInvalidoException();
        }
        this.empresa.setNombre(nombre);
    }

//    public void GuardarEmpresa(Empresa empresa) throws EmpresaRepetidoException, EmpresaConNombreExistenteException, EmpresaVacioException, NombreEmpresaInvalidoException, EmpresaSinPuertasException {
//
//        if (empresa.getNombre().length() == 0 || empresa.getNombre() == null) {
//            throw new NombreEmpresaInvalidoException();
//        }
//        if (this.getEmpresa() == null) {
//            throw new EmpresaVacioException();
//        }
//        if (PuertasSERVICIO.getInstancia().getListapuertas().isEmpty()) {
//            throw new EmpresaSinPuertasException();
//        }
//        if (this.empresa.getParqueaderos().isEmpty()) {
//            throw new EmpresaVacioException();
//        }
//        if (EmpresaDAO.getInstancia().buscarPor(this.getEmpresa().getNombre())) {
//            throw new EmpresaConNombreExistenteException();
//        }
////        this.campus.setCant_puertas(PuertasSERVICIO.getInstancia().getListapuertas().size());
//        EmpresaDAO.getInstancia().guardar(getEmpresa());
//        PuertasSERVICIO.getInstancia().GuardarPuertas(this.empresa.getCodigo());
//        this.empresa = null;
//        PuertasSERVICIO.getInstancia().getListapuertas().clear();
//        ParqueaderosSERVICIO.getInstancia().setParqueadero(null);
//
//    }
    public void eliminarparqueadero(String codigo) {
        this.empresa.getParqueaderos().remove(codigo);
    }

    public void GuardarEmpresaModificado(String nombre) throws NombreEmpresaInvalidoException, EmpresaVacioException, EmpresaSinPuertasException {
        if (nombre.length() == 0 || nombre == null) {
            throw new NombreEmpresaInvalidoException();
        }
        if (this.getEmpresa() == null) {
            throw new EmpresaVacioException();
        }
        if (PuertasSERVICIO.getInstancia().getListapuertas().isEmpty()) {
            throw new EmpresaSinPuertasException();
        }
        if (this.empresa.getParqueaderos().isEmpty()) {
            throw new EmpresaVacioException();
        }

//        this.campus.setCant_puertas(PuertasSERVICIO.getInstancia().getListapuertas().size());
        EmpresaDAO.getInstancia().guardarModificado(this.empresa);
        PuertasSERVICIO.getInstancia().guardarNuevasPuertas(this.empresa.getCodigo());

        this.empresa = null;
        PuertasSERVICIO.getInstancia().getListapuertas().clear();
        ParqueaderosSERVICIO.getInstancia().setParqueadero(null);
    }

    public void eliminarEmpresa(String codigo) throws EmpresaNoExisteException {
        EmpresaDAO.getInstancia().eliminarCampus(codigo);
    }

    public void agregarParqueadero(Parqueadero p) {

//        this.campus.agregar(p);
        System.out.println(">>> Parqueadero Agregado: " + this.empresa.getParqueaderos().size());
    }

    public List<Parqueadero> obtenerParqueaderos() {
        List<Parqueadero> lista = new ArrayList<Parqueadero>(this.empresa.getParqueaderos());

        return lista;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public Empresa recuperarEmpresa(String codigo) throws EmpresaNoExisteException, QueryParseException, QueryExecutionException {
        return EmpresaDAO.getInstancia().obtener(codigo);
    }

    public Parqueadero recuperarParqueaderoDeEmpresa(String codigoCampues, String codigoParqueadero) throws EmpresaNoExisteException, QueryParseException, QueryExecutionException {
        return EmpresaDAO.getInstancia().obtener(codigoCampues).getParqueaderos().get(Integer.parseInt(codigoParqueadero));
    }

    public Puerta recuperarParqueaderoDeEmpresaDePuerta(String codigoCampues, String codigoParqueadero, String codigoPuerta) throws EmpresaNoExisteException, QueryParseException, QueryExecutionException {
        for (Iterator<Puerta> iterator = EmpresaDAO.getInstancia().obtener(codigoCampues).getParqueaderos().get(Integer.parseInt(codigoParqueadero)).getPuertas().iterator(); iterator.hasNext();) {
            Puerta next = iterator.next();
            if (next.getIdPuerta().equals(codigoPuerta)) {
                return next;
            }
        }
        return null;
//        CampusDAO.getInstancia().obtener(codigoCampues).getParqueaderos().get(codigoParqueadero);
    }

    public void cargarEmpresa(String codigo) throws EmpresaNoExisteException {
        try {
            this.empresa = EmpresaDAO.getInstancia().obtener(codigo);
        } catch (QueryParseException ex) {
            System.out.println("Error josql QueryParseException");
        } catch (QueryExecutionException ex) {
            System.out.println("Error josql QueryExecutionException");
        }
    }

    /**
     * @return the modificar
     */
    public boolean isModificar() {
        return modificar;
    }

    /**
     * @param modificar the modificar to set
     */
    public void setModificar(boolean modificar) {
        this.modificar = modificar;
    }

    public void agregarParqueaderoModificado(Parqueadero p) {

    }

}
