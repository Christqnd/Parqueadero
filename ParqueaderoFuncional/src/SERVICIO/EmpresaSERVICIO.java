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

    private Empresa campus = null;

    private static EmpresaSERVICIO instancia = null;

    private EmpresaSERVICIO() {
    }

    public static EmpresaSERVICIO getInstancia() {
        if (instancia == null) {
            instancia = new EmpresaSERVICIO();
        }
        return instancia;
    }

    public List<Empresa> obtenerlistaCampus() throws QueryExecutionException, QueryParseException, IOException {
//        return CampusDAO.getInstancia().obtenerListaCampus("nombre");
        return EmpresaDAO.getInstancia().obtenerListaCampus();
    }

    public void crearCampus(String codigo, String nombre, int cant_puertas) throws NombreCampusInvalidoException, EmpresaConNombreExistenteException {
        if (EmpresaDAO.getInstancia().buscarPor(nombre)) {
            throw new EmpresaConNombreExistenteException();
        }
        if (nombre.length() == 0 || nombre == null) {
            throw new NombreCampusInvalidoException();
        }
        this.campus = new Empresa(nombre, codigo, cant_puertas);
    }

    public void modificarCampus(String codigo, String nombre) throws NombreCampusInvalidoException {
        if (nombre.length() == 0 || nombre == null) {
            throw new NombreCampusInvalidoException();
        }
        this.campus.setNombre(nombre);
    }

    public void GuardarCampus(String nombre) throws EmpresaRepetidoException, EmpresaConNombreExistenteException, EmpresaVacioException, NombreCampusInvalidoException, EmpresaSinPuertasException {

        if (nombre.length() == 0 || nombre == null) {
            throw new NombreCampusInvalidoException();
        }
        if (this.getCampus() == null) {
            throw new EmpresaVacioException();
        }
        if (PuertasSERVICIO.getInstancia().getListapuertas().isEmpty()) {
            throw new EmpresaSinPuertasException();
        }
        if (this.campus.getParqueaderos().isEmpty()) {
            throw new EmpresaVacioException();
        }
        if (EmpresaDAO.getInstancia().buscarPor(this.getCampus().getNombre())) {
            throw new EmpresaConNombreExistenteException();
        }
        this.campus.setCant_puertas(PuertasSERVICIO.getInstancia().getListapuertas().size());
        EmpresaDAO.getInstancia().guardar(getCampus());
        PuertasSERVICIO.getInstancia().GuardarPuertas(this.campus.getCodigo());
        this.campus = null;
        PuertasSERVICIO.getInstancia().getListapuertas().clear();
        ParqueaderosSERVICIO.getInstancia().setParqueadero(null);

    }

    public void eliminarparqueadero(String codigo){
        this.campus.getParqueaderos().remove(codigo);
    }
    public void GuardarCampusModificado(String nombre) throws NombreCampusInvalidoException, EmpresaVacioException, EmpresaSinPuertasException {
        if (nombre.length() == 0 || nombre == null) {
            throw new NombreCampusInvalidoException();
        }
        if (this.getCampus() == null) {
            throw new EmpresaVacioException();
        }
        if (PuertasSERVICIO.getInstancia().getListapuertas().isEmpty()) {
            throw new EmpresaSinPuertasException();
        }
        if (this.campus.getParqueaderos().isEmpty()) {
            throw new EmpresaVacioException();
        }

        this.campus.setCant_puertas(PuertasSERVICIO.getInstancia().getListapuertas().size());
        EmpresaDAO.getInstancia().guardarModificado(this.campus);
        PuertasSERVICIO.getInstancia().guardarNuevasPuertas(this.campus.getCodigo());

        this.campus = null;
        PuertasSERVICIO.getInstancia().getListapuertas().clear();
        ParqueaderosSERVICIO.getInstancia().setParqueadero(null);
    }

    
    public void eliminarCampus(String codigo) throws EmpresaNoExisteException{
        EmpresaDAO.getInstancia().eliminarCampus(codigo);
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
    public Empresa getCampus() {
        return campus;
    }

    public Empresa recuperarCampus(String codigo) throws EmpresaNoExisteException, QueryParseException, QueryExecutionException {
        return EmpresaDAO.getInstancia().obtener(codigo);
    }

    public Parqueadero recuperarParqueaderoDeCampus(String codigoCampues, String codigoParqueadero) throws EmpresaNoExisteException, QueryParseException, QueryExecutionException {
        return EmpresaDAO.getInstancia().obtener(codigoCampues).getParqueaderos().get(codigoParqueadero);
    }

    public Puerta recuperarParqueaderoDeCampusDePuerta(String codigoCampues, String codigoParqueadero,String codigoPuerta) throws EmpresaNoExisteException, QueryParseException, QueryExecutionException {
        for (Iterator<Puerta> iterator = EmpresaDAO.getInstancia().obtener(codigoCampues).getParqueaderos().get(codigoParqueadero).getPuertas().iterator(); iterator.hasNext();) {
            Puerta next = iterator.next();
            if(next.getCodigo().equalsIgnoreCase(codigoPuerta))
                return next;
        }
        return null;
//        CampusDAO.getInstancia().obtener(codigoCampues).getParqueaderos().get(codigoParqueadero);
    }
    
    public void cargarCampus(String codigo) throws EmpresaNoExisteException {
        try {
            this.campus = EmpresaDAO.getInstancia().obtener(codigo);
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
