/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODELO.Campus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.josql.*;

/**
 *
 * @author gube
 */
public class CampusDAO {

    //private Map<String,Campus> listacampus=new HashMap<>();

    private List<Campus> listacampus = new ArrayList();
    private static CampusDAO instancia = null;
    Query query = new Query();

    private CampusDAO() {
    }

    public static CampusDAO getInstancia() {
        if (instancia == null) {
            instancia = new CampusDAO();
        }
        return instancia;
    }

    public void guardar(Campus c) throws CampusRepetidoException {
        if (this.buscar(c.getCodigo())) {
            throw new CampusRepetidoException("El campus con codigo: " + c.getCodigo() + " ya existe");
        }
        this.listacampus.add(c);
    }
    
    public void guardarModificado(Campus c){
        int valor=this.buscarIndice(c.getCodigo());
        listacampus.remove(valor);
        listacampus.add(valor, c);
        System.out.println("Campus Modificado");
    }

    
    public void eliminarCampus(String codigo_) throws CampusNoExisteException{
       
            if (!this.buscar(codigo_)) {
                throw new CampusNoExisteException("El campus con codigo no existe");
            }
            this.listacampus.remove(this.buscarIndice(codigo_));
         
    }
    public Campus obtener(String codigo_) throws CampusNoExisteException, QueryParseException, QueryExecutionException {
        if (!this.buscar(codigo_)) {
            throw new CampusNoExisteException("El campus con codigo no existe");
        }

        String sql = "SELECT * FROM MODELO.Campus WHERE codigo= :codigo_ ORDER BY codigo";
        this.query.parse(sql);

        this.query.setVariable("codigo_", new String(codigo_));

        QueryResults qr = this.query.execute(this.listacampus);

        Iterator i;
        Campus p = null;
        for (i = qr.getResults().iterator(); i.hasNext();) {
            p = (Campus) i.next();
        }
        return p;
    }

    public boolean buscarPor(String nombre) {
        boolean valor = false;
        for (int i = 0; i < this.listacampus.size() && valor == false; i++) {
            if (this.listacampus.get(i).getNombre().equalsIgnoreCase(nombre)) {
                valor = true;
            }
        }
        return valor;
    }
    
    public int buscarIndice(String codigo){
        int i,valor = 0;
        for(i=0;i<this.listacampus.size();i++){
            if(listacampus.get(i).getCodigo().equals(codigo)){
                valor=i;
                i=listacampus.size()+1;
            }
        }
        return valor;
    }

    public List<Campus> obtenerListaCampus(String filtro) throws QueryExecutionException, QueryParseException {
        List<Campus> l = new ArrayList();
        String sql = "SELECT * FROM MODELO.Campus ORDER BY " + filtro;
        this.query.parse(sql);

        QueryResults qr = this.query.execute(this.listacampus);

        Iterator i;
        for (i = qr.getResults().iterator(); i.hasNext();) {
            l.add((Campus) i.next());
        }
        return l;
    }

    public boolean buscar(String codigo) {
        boolean valor = false;
        for (int i = 0; i < this.listacampus.size() && valor == false; i++) {
            if (this.listacampus.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                valor = true;
            }
        }
        System.out.println("valor: "+valor);
        return valor;
        
    }

}
