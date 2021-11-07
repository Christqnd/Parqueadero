/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODELO.Usuario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.josql.*;

/**
 *
 * @author gube
 */
public class UsuariosDAO {

    private static UsuariosDAO instancia = null;
    private List<Usuario> listaUsuarios = new ArrayList();
    Query query = new Query();

    private UsuariosDAO() {

    }

    public static UsuariosDAO getInstancia() {
        if (instancia == null) {
            instancia = new UsuariosDAO();
        }
        return instancia;
    }


    public boolean guardar(Usuario u) throws UsuarioRepetidoException {
        if (this.buscar(u.getCedula())) {
            throw new UsuarioRepetidoException("El usuario con cedula : " + u.getCedula() + "  ya existe");
        }
        return this.listaUsuarios.add(u);
    }

    public boolean eliminar(String cedula) throws UsuarioNoExisteException, QueryParseException, QueryExecutionException {
        if (!this.buscar(cedula)) {
            throw new UsuarioNoExisteException("El usuario con cedula : " + cedula + " no existe");
        }
        return this.listaUsuarios.remove(obtener(cedula));
    }
    public boolean modificar(Usuario usuarioNuevo,String cedula) throws UsuarioNoExisteException, QueryParseException, QueryExecutionException{
        if (!this.buscar(cedula)) {
            throw new UsuarioNoExisteException("El usuario con cedula : " + cedula + " no existe");
        }
        return this.listaUsuarios.remove(obtener(cedula))&&this.listaUsuarios.add(usuarioNuevo);
    }
    public Usuario obtener(String cedula_) throws QueryParseException, QueryExecutionException, UsuarioNoExisteException {
        if (!this.buscar(cedula_)) {
            throw new UsuarioNoExisteException("El usuario con cedula : " + cedula_ + " no existe");
        }

        String sql = "SELECT * FROM MODELO.Usuario WHERE cedula= :cedula_ ORDER BY cedula";
        this.query.parse(sql);

        this.query.setVariable("cedula_", new String(cedula_));

        QueryResults qr = this.query.execute(this.listaUsuarios);

        Iterator i;
        Usuario u = null;
        for (i = qr.getResults().iterator(); i.hasNext();) {
            u = (Usuario) i.next();
        }
        return u;
    }

    public boolean buscarPor(String nombre) {
        boolean valor = false;
        for (int i = 0; i < this.listaUsuarios.size() && valor == false; i++) {
            if (this.listaUsuarios.get(i).getNombre().equalsIgnoreCase(nombre)) {
                valor = true;
            }
        }
        return valor;
    }

    public List<Usuario> obtenerListaUsuario(String filtro) throws QueryExecutionException, QueryParseException {
        List<Usuario> l = new ArrayList();
        String sql = "SELECT * FROM MODELO.Usuario ORDER BY " + filtro;
        this.query.parse(sql);

        QueryResults qr = this.query.execute(this.listaUsuarios);

        Iterator i;
        for (i = qr.getResults().iterator(); i.hasNext();) {
            l.add((Usuario) i.next());
        }
        return l;
    }

    public boolean buscar(String cedula) {
        boolean valor = false;
        for (int i = 0; i < this.listaUsuarios.size() && valor == false; i++) {
            if (this.listaUsuarios.get(i).getCedula().equalsIgnoreCase(cedula)) {
                valor = true;
            }
        }
        return valor;
    }

}
