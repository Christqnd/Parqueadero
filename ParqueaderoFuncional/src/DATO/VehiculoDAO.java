/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.josql.QueryExecutionException;
import org.josql.QueryParseException;
import parqueadero.PropertyValues;

/**
 *
 * @author pc_hp
 */
public class VehiculoDAO {
    
    private static VehiculoDAO instancia = null;
    
    private VehiculoDAO() {

    }

    public static VehiculoDAO getInstancia() {
        if (instancia == null) {
            instancia = new VehiculoDAO();
        }
        return instancia;
    }
    
    public boolean eliminar(Long id) throws UsuarioNoExisteException, QueryParseException, QueryExecutionException, IOException {

        URL url = new URL(PropertyValues.getInstance().property.getUrlApiParkingGo() + "/vehiculos/dvehiculo/" + id.toString());//your url i.e fetch data from .
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("PUT");
        conn.setRequestProperty("Accept", "application/json");
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
    
}
