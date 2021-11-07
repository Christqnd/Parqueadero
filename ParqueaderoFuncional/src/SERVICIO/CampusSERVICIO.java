/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICIO;

import DAO.CampusDAO;
import DAO.CampusNoExisteException;
import DAO.CampusRepetidoException;
import MODELO.Campus;
import MODELO.Parqueadero;
import MODELO.Puerta;
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
public class CampusSERVICIO {

    private boolean modificar = false;

    private Campus campus = null;

    private static CampusSERVICIO instancia = null;

    private CampusSERVICIO() {
    }

    public static CampusSERVICIO getInstancia() {
        if (instancia == null) {
            instancia = new CampusSERVICIO();
        }
        return instancia;
    }

    public List<Campus> obtenerlistaCampus() throws QueryExecutionException, QueryParseException {
        return CampusDAO.getInstancia().obtenerListaCampus("nombre");
    }

    public void crearCampus(String codigo, String nombre, int cant_puertas) throws NombreCampusInvalidoException, CampusConNombreExistenteException {
        if (CampusDAO.getInstancia().buscarPor(nombre)) {
            throw new CampusConNombreExistenteException();
        }
        if (nombre.length() == 0 || nombre == null) {
            throw new NombreCampusInvalidoException();
        }
        this.campus = new Campus(nombre, codigo, cant_puertas);
    }

    public void modificarCampus(String codigo, String nombre) throws NombreCampusInvalidoException {
        if (nombre.length() == 0 || nombre == null) {
            throw new NombreCampusInvalidoException();
        }
        this.campus.setNombre(nombre);
    }

    public void GuardarCampus(String nombre) throws CampusRepetidoException, CampusConNombreExistenteException, Campusvacioexception, NombreCampusInvalidoException, CampusSinPuertasException {

        if (nombre.length() == 0 || nombre == null) {
            throw new NombreCampusInvalidoException();
        }
        if (this.getCampus() == null) {
            throw new Campusvacioexception();
        }
        if (PuertasSERVICIO.getInstancia().getListapuertas().isEmpty()) {
            throw new CampusSinPuertasException();
        }
        if (this.campus.getParqueaderos().isEmpty()) {
            throw new Campusvacioexception();
        }
        if (CampusDAO.getInstancia().buscarPor(this.getCampus().getNombre())) {
            throw new CampusConNombreExistenteException();
        }
        this.campus.setCant_puertas(PuertasSERVICIO.getInstancia().getListapuertas().size());
        CampusDAO.getInstancia().guardar(getCampus());
        PuertasSERVICIO.getInstancia().GuardarPuertas(this.campus.getCodigo());
        this.campus = null;
        PuertasSERVICIO.getInstancia().getListapuertas().clear();
        ParqueaderosSERVICIO.getInstancia().setParqueadero(null);

    }

    public void eliminarparqueadero(String codigo){
        this.campus.getParqueaderos().remove(codigo);
    }
    public void GuardarCampusModificado(String nombre) throws NombreCampusInvalidoException, Campusvacioexception, CampusSinPuertasException {
        if (nombre.length() == 0 || nombre == null) {
            throw new NombreCampusInvalidoException();
        }
        if (this.getCampus() == null) {
            throw new Campusvacioexception();
        }
        if (PuertasSERVICIO.getInstancia().getListapuertas().isEmpty()) {
            throw new CampusSinPuertasException();
        }
        if (this.campus.getParqueaderos().isEmpty()) {
            throw new Campusvacioexception();
        }

        this.campus.setCant_puertas(PuertasSERVICIO.getInstancia().getListapuertas().size());
        CampusDAO.getInstancia().guardarModificado(this.campus);
        PuertasSERVICIO.getInstancia().guardarNuevasPuertas(this.campus.getCodigo());

        this.campus = null;
        PuertasSERVICIO.getInstancia().getListapuertas().clear();
        ParqueaderosSERVICIO.getInstancia().setParqueadero(null);
    }

    
    public void eliminarCampus(String codigo) throws CampusNoExisteException{
        CampusDAO.getInstancia().eliminarCampus(codigo);
    }
    public void agregarParqueadero(Parqueadero p) {
        
        this.campus.agregar(p);

        System.out.println(">>> Parqueadero Agregado: " + this.campus.getParqueaderos().size());
    }

    public List<Parqueadero> obtenerParqueaderos() {
        List<Parqueadero> lista = new ArrayList<Parqueadero>(this.campus.getParqueaderos().values());

        return lista;
    }
    
    

    /**
     * @return the campus
     */
    public Campus getCampus() {
        return campus;
    }

    public Campus recuperarCampus(String codigo) throws CampusNoExisteException, QueryParseException, QueryExecutionException {
        return CampusDAO.getInstancia().obtener(codigo);
    }

    public Parqueadero recuperarParqueaderoDeCampus(String codigoCampues, String codigoParqueadero) throws CampusNoExisteException, QueryParseException, QueryExecutionException {
        return CampusDAO.getInstancia().obtener(codigoCampues).getParqueaderos().get(codigoParqueadero);
    }

    public Puerta recuperarParqueaderoDeCampusDePuerta(String codigoCampues, String codigoParqueadero,String codigoPuerta) throws CampusNoExisteException, QueryParseException, QueryExecutionException {
        for (Iterator<Puerta> iterator = CampusDAO.getInstancia().obtener(codigoCampues).getParqueaderos().get(codigoParqueadero).getPuertas().iterator(); iterator.hasNext();) {
            Puerta next = iterator.next();
            if(next.getCodigo().equalsIgnoreCase(codigoPuerta))
                return next;
        }
        return null;
//        CampusDAO.getInstancia().obtener(codigoCampues).getParqueaderos().get(codigoParqueadero);
    }
    
    public void cargarCampus(String codigo) throws CampusNoExisteException {
        try {
            this.campus = CampusDAO.getInstancia().obtener(codigo);
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
