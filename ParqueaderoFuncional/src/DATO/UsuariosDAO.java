/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATO;

import org.json.JSONException;
import org.json.JSONObject;

import MODELO.Usuario;
import com.fasterxml.jackson.core.JsonParser;
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
import org.josql.*;
import org.json.JSONObject;
import parqueadero.PropertyValues;

/**
 *
 * @author ChristQnd
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

    public boolean guardar(Usuario usuario) throws UsuarioRepetidoException {

        try {

            URL url = new URL(PropertyValues.getInstance().property.getUrlApiParkingGo() + "/usuarios");//your url i.e fetch data from .
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

        return this.listaUsuarios.add(usuario);
    }

    public boolean eliminar(Long id) throws UsuarioNoExisteException, QueryParseException, QueryExecutionException, IOException {

        URL url = new URL(PropertyValues.getInstance().property.getUrlApiParkingGo() + "/usuarios/duser/" + id.toString());//your url i.e fetch data from .
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("PUT");
        conn.setRequestProperty("Accept", "application/json");
        if (conn.getResponseCode() != 204) {
            throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
        }
        InputStreamReader in = new InputStreamReader(conn.getInputStream());
        BufferedReader br = new BufferedReader(in);
        String output = br.readLine();

        System.out.println(output.toString());

//        while ((output = 
//                ) != null) {
//            ObjectMapper mapper = new ObjectMapper();
//            JsonNode jsonNode = mapper.readTree(output);
//                    System.out.println(jsonNode.toPrettyString());
//                    byte[] jsonData = jsonNode.toString().getBytes();
//                    u = mapper.readValue(jsonData, Usuario.class);
//        }
        conn.disconnect();

        return true;
    }

    public boolean modificar(Usuario usuario, Long id) throws UsuarioNoExisteException, QueryParseException, QueryExecutionException, IOException {

        URL url = new URL(PropertyValues.getInstance().property.getUrlApiParkingGo() + "/usuarios/" + id.toString());//your url i.e fetch data from .
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("PUT");
        conn.setRequestProperty("Content-Type", "application/json; utf-8");
        conn.setRequestProperty("Accept", "application/json");
        conn.setDoOutput(true);

        String jsonInputString = usuario.toJSONUpdate();

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        if (conn.getResponseCode() != 204) {
            throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
        }
        InputStreamReader in = new InputStreamReader(conn.getInputStream());
        BufferedReader br = new BufferedReader(in);
        String output = br.readLine();

//        System.out.println(output.toString());

        conn.disconnect();

        return true;
    }

    public Usuario obtener(Long id) throws QueryParseException, QueryExecutionException, UsuarioNoExisteException, IOException {
        Usuario u = null;

        URL url = new URL(PropertyValues.getInstance().property.getUrlApiParkingGo() + "/usuarios/" + id.toString()+"/vehiculosactivos");//your url i.e fetch data from .
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
            JsonNode jsonNode = mapper.readTree(output);
            System.out.println(jsonNode.toPrettyString());
            byte[] jsonData = jsonNode.toString().getBytes();
            u = mapper.readValue(jsonData, Usuario.class);
        }
        conn.disconnect();

        return u;
    }

    public boolean buscarPor(String nombre) {
        boolean valor = false;
        for (int i = 0; i < this.listaUsuarios.size() && valor == false; i++) {
            if (this.listaUsuarios.get(i).getPrimerNombre().equalsIgnoreCase(nombre)) {
                valor = true;
            }
        }
        return valor;
    }

    public List<Usuario> obtenerListaUsuario(String filtro) throws IOException {
        List<Usuario> l = new ArrayList();
        URL url = new URL(PropertyValues.getInstance().property.getUrlApiParkingGo() + "/usuarios/activos");//your url i.e fetch data from .
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
                    Usuario usuario = mapper.readValue(jsonData, Usuario.class);
                    l.add(usuario);
                }
            }
        }
        conn.disconnect();
        return l;
    }

    public boolean buscar(Long id) {
        boolean valor = false;
        for (int i = 0; i < this.listaUsuarios.size() && valor == false; i++) {
            if (this.listaUsuarios.get(i).getId() == id) {
                valor = true;
            }
        }
        return valor;
    }

}
