/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATO;

import MODELO.Empresa;
import MODELO.Usuario;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.josql.*;
import parqueadero.PropertyValues;

/**
 *
 * @author gube
 */
public class EmpresaDAO {

    //private Map<String,Campus> listacampus=new HashMap<>();

    private List<Empresa> listacampus = new ArrayList();
    private static EmpresaDAO instancia = null;
    Query query = new Query();

    private EmpresaDAO() {
    }

    public static EmpresaDAO getInstancia() {
        if (instancia == null) {
            instancia = new EmpresaDAO();
        }
        return instancia;
    }

    public boolean guardar(Empresa e) throws EmpresaRepetidoException {
//        if (this.buscar(e.getCodigo())) {
//            throw new EmpresaRepetidoException("El campus con codigo: " + c.getCodigo() + " ya existe");
//        }

    try {

            URL url = new URL(PropertyValues.getInstance().property.getUrlApiParkingGo() + "/empresas");//your url i.e fetch data from .
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            String jsonInputString = usuario.toJSONCreate();

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response.toString());
            }

            if (conn.getResponseCode() != 201) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            conn.disconnect();

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e.getMessage());
        }


















//        this.listacampus.add(e);
    }
    
    public void guardarModificado(Empresa c){
        int valor=this.buscarIndice(c.getCodigo());
        listacampus.remove(valor);
        listacampus.add(valor, c);
        System.out.println("Campus Modificado");
    }

    
    public void eliminarCampus(String codigo_) throws EmpresaNoExisteException{
       
            if (!this.buscar(codigo_)) {
                throw new EmpresaNoExisteException("El campus con codigo no existe");
            }
            this.listacampus.remove(this.buscarIndice(codigo_));
         
    }
    public Empresa obtener(String codigo_) throws EmpresaNoExisteException, QueryParseException, QueryExecutionException {
        if (!this.buscar(codigo_)) {
            throw new EmpresaNoExisteException("El campus con codigo no existe");
        }

        String sql = "SELECT * FROM MODELO.Campus WHERE codigo= :codigo_ ORDER BY codigo";
        this.query.parse(sql);

        this.query.setVariable("codigo_", new String(codigo_));

        QueryResults qr = this.query.execute(this.listacampus);

        Iterator i;
        Empresa p = null;
        for (i = qr.getResults().iterator(); i.hasNext();) {
            p = (Empresa) i.next();
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

    public List<Empresa> obtenerListaEmpresas(String filtro) throws QueryExecutionException, QueryParseException {
        List<Empresa> l = new ArrayList();
        String sql = "SELECT * FROM MODELO.Campus ORDER BY " + filtro;
        this.query.parse(sql);

        QueryResults qr = this.query.execute(this.listacampus);

        Iterator i;
        for (i = qr.getResults().iterator(); i.hasNext();) {
            l.add((Empresa) i.next());
        }
        return l;
    }
    
    public List<Empresa> obtenerListaEmpresas() throws QueryExecutionException, QueryParseException, IOException {
        List<Empresa> l = new ArrayList();
//         List<Usuario> l = new ArrayList();
        URL url = new URL(PropertyValues.getInstance().property.getUrlApiParkingGo()+ "/empresas/activas");//your url i.e fetch data from .
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
        }
        InputStreamReader in = new InputStreamReader(conn.getInputStream());
        BufferedReader br = new BufferedReader(in);
        String output;
        while ((output = br.readLine()) != null) {
            ObjectMapper mapper = new ObjectMapper();
            // convert to json object
            JsonNode jsonNode = mapper.readTree(output);
            if (jsonNode.isArray()) {
                for (final JsonNode objNode : jsonNode) {
                    System.out.println(objNode.toPrettyString());
                    byte[] jsonData = objNode.toString().getBytes();
                    Empresa empresa = mapper.readValue(jsonData, Empresa.class);
                    l.add(empresa);
                }
            }
        }
        conn.disconnect();
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
