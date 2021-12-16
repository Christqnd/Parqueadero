/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueadero;

import DATO.EmpresaDAO;
import DATO.EmpresaNoExisteException;
import DATO.EmpresaRepetidoException;
import DATO.PuertasDAO;
import DATO.UsuarioNoExisteException;
import DATO.UsuarioRepetidoException;
import GUI.Bienvenida;
import GUI.ParqueaderoMAINGUI;
import MODELO.Empresa;
import MODELO.Parqueadero;
import MODELO.Puerta;
import MODELO.PuertaEntrada;
import MODELO.PuertaEntradaSalida;
import MODELO.PuertaSalida;
import SERVICIO.EmpresaSERVICIO;
import SERVICIO.CodigosSERVICIO;
import SERVICIO.DatoInvalidoException;
import SERVICIO.FacturaExistenteException;
import SERVICIO.FechasErroneasException;
import SERVICIO.TarjetaSERVICIO;
import SERVICIO.UsuarioSERVICIO;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.josql.QueryExecutionException;
import org.josql.QueryParseException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/**
 *
 * @author gube
 */
public class Universidad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            /**
             * servicios
             */
           
            
//            
//          
//            try {
//
//            URL url = new URL(PropertyValues.getInstance().property.getUrlApiParkingGo()+"/vehiculos");//your url i.e fetch data from .
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setRequestProperty("Accept", "application/json");
//            if (conn.getResponseCode() != 200) {
//                throw new RuntimeException("Failed : HTTP Error code : "
//                        + conn.getResponseCode());
//            }
//            InputStreamReader in = new InputStreamReader(conn.getInputStream());
//            BufferedReader br = new BufferedReader(in);
//            String output;
//            while ((output = br.readLine()) != null) {
//                System.out.println(output);
//            }
//            JSONObject json= new JSONObject(output);
//            conn.disconnect();
//
//        } catch (Exception e) {
//            System.out.println("Exception in NetClientGet:- " + e);
//        }
            
            
            
            
            
            
            
            EmpresaSERVICIO cs=EmpresaSERVICIO.getInstancia();
            UsuarioSERVICIO us = new UsuarioSERVICIO();
            CodigosSERVICIO cods=CodigosSERVICIO.getInstancia();
            PuertasDAO pd=PuertasDAO.getInstancia();
            EmpresaDAO cd=EmpresaDAO.getInstancia();
            TarjetaSERVICIO ts=new TarjetaSERVICIO();
            /**
             * fin
             * Ventana de bienvenida
             */           
            Bienvenida b=new Bienvenida();
            b.setVisible(true);
            
            /**
             * fin
             * creando Campus
             */
            
            b.mostrarMensaje("Creando Campus 1...");
            
//            String codcampus1=cods.generarCodigo("CA");
//            esperar(100);
//            Campus campus1=new Campus("Central", codcampus1, 0);
//            b.mostrarMensaje("Creando Campus 1...Nuevo Parqueadero 1.");
//            String codparq=cods.generarCodigo("PA");
//            Parqueadero p=new Parqueadero(codparq, 1, 30, 0);
//            esperar();
//            String codpuerta=cods.generarCodigo("PU");
//            Puerta pu1=new Puerta(1, codpuerta, "Americas", null, new PuertaEntradaSalida());
//            esperar();
//            Puerta pu2=new Puerta(2, cods.generarCodigo("PU"), "doce de abril", null, new PuertaEntradaSalida());
//            esperar();
//            Puerta pu3=new Puerta(3, cods.generarCodigo("PU"), "sur", null, new PuertaSalida());
//            pd.AgregarPuerta(codcampus1, pu3);
//            pd.AgregarPuerta(codcampus1, pu2);
//            pd.AgregarPuerta(codcampus1, pu1);
//            b.mostrarMensaje("Creando Campus...Guardando Puertas.");
//            p.getPuertas().add(pu3);
//            p.getPuertas().add(pu2);
//            p.getPuertas().add(pu1);
//            b.mostrarMensaje("Creando Campus 1...Guardando Parqueadero 1.");
//            campus1.agregar(p);
//            
//            
//            b.mostrarMensaje("Creando Campus 1...Nuevo Parqueadero 2.");
//            p=new Parqueadero(cods.generarCodigo("PA"), 1, 30, 0);
//            esperar();
//            pu1=new Puerta(4, cods.generarCodigo("PU"), "tarqi", null, new PuertaEntrada());
//            esperar();
//            pu2=new Puerta(5, cods.generarCodigo("PU"), "3 de octubre", null, new PuertaEntradaSalida());
//            esperar();
//            pu3=new Puerta(6, cods.generarCodigo("PU"), "pio bravo", null, new PuertaSalida());
//            pd.AgregarPuerta(codcampus1, pu3);
//            pd.AgregarPuerta(codcampus1, pu2);
//            pd.AgregarPuerta(codcampus1, pu1);
//            b.mostrarMensaje("Creando Campus 1...Guardando Puertas.");
//            p.getPuertas().add(pu3);
//            p.getPuertas().add(pu2);
//            p.getPuertas().add(pu1);
//            b.mostrarMensaje("Creando Campus 1...Guardando Parqueadero 2.");
//            campus1.agregar(p);
//            
//            
//            
//            
//            b.mostrarMensaje("Creando Campus 1...Nuevo Parqueadero 3.");
//            p=new Parqueadero(cods.generarCodigo("PA"), 1, 30, 0);
//            esperar();
//            pu1=new Puerta(7, cods.generarCodigo("PU"), "larga", null, new PuertaEntrada());
//            esperar();
//            pu2=new Puerta(8, cods.generarCodigo("PU"), "Vargas Machuca", null, new PuertaEntradaSalida());
//            esperar();
//            pu3=new Puerta(9, cods.generarCodigo("PU"), "luis cordero", null, new PuertaSalida());
//            pd.AgregarPuerta(codcampus1, pu3);
//            pd.AgregarPuerta(codcampus1, pu2);
//            pd.AgregarPuerta(codcampus1, pu1);
//            b.mostrarMensaje("Creando Campus...Guardando Puertas.");
//            p.getPuertas().add(pu3);
//            p.getPuertas().add(pu2);
//            p.getPuertas().add(pu1);
//            b.mostrarMensaje("Creando Campus 1...Guardando Parqueadero 3.");
//            campus1.agregar(p);
//            
//            b.mostrarMensaje("Guardando Campus 1...");
//            cd.guardar(campus1);
//            
//           
//            
//            /**
//             * nuevo campus
//             */
//            b.mostrarMensaje("Creando Campus 2...");
//            
//            String codcampus=cods.generarCodigo("CA");
//            esperar(100);
//            campus1=new Campus("Hospitalidad", codcampus, 0);
//            b.mostrarMensaje("Creando Campus 2...Nuevo Parqueadero 1.");
//            p=new Parqueadero(cods.generarCodigo("PA"), 1, 30, 0);
//            esperar();
//            pu1=new Puerta(1, cods.generarCodigo("PU"), "Americas", null, new PuertaEntrada());
//            esperar();
//            pu2=new Puerta(2, cods.generarCodigo("PU"), "doce de abril", null, new PuertaEntradaSalida());
//            esperar();
//            pu3=new Puerta(3, cods.generarCodigo("PU"), "sur", null, new PuertaSalida());
//            pd.AgregarPuerta(codcampus, pu3);
//            pd.AgregarPuerta(codcampus, pu2);
//            pd.AgregarPuerta(codcampus, pu1);
//            b.mostrarMensaje("Creando Campus...Guardando Puertas.");
//            p.getPuertas().add(pu3);
//            p.getPuertas().add(pu2);
//            p.getPuertas().add(pu1);
//            b.mostrarMensaje("Creando Campus 2...Guardando Parqueadero 1.");
//            campus1.agregar(p);
//            
//            
//            b.mostrarMensaje("Creando Campus 2...Nuevo Parqueadero 2.");
//            String codparq2=cods.generarCodigo("PA");
//            p=new Parqueadero(codparq2, 1, 30, 0);
//            esperar();
//            String codpuerta1= cods.generarCodigo("PU");
//            pu1=new Puerta(4, codpuerta1, "Tarqui", null, new PuertaEntrada());
//            esperar();
//            pu2=new Puerta(5, cods.generarCodigo("PU"), "d3 de octubre", null, new PuertaEntradaSalida());
//            esperar();
//            String codpuerta2=cods.generarCodigo("PU");
//            pu3=new Puerta(6, codpuerta2, "pio bravo", null, new PuertaSalida());
//            pd.AgregarPuerta(codcampus, pu3);
//            pd.AgregarPuerta(codcampus, pu2);
//            pd.AgregarPuerta(codcampus, pu1);
//            b.mostrarMensaje("Creando Campus 2...Guardando Puertas.");
//            p.getPuertas().add(pu3);
//            p.getPuertas().add(pu2);
//            p.getPuertas().add(pu1);
//            b.mostrarMensaje("Creando Campus 2...Guardando Parqueadero 2.");
//            campus1.agregar(p);
//            
//            
//            
//           
//            b.mostrarMensaje("Creando Campus 2...Nuevo Parqueadero 3.");
//            String codparq3=cods.generarCodigo("PA");
//            p=new Parqueadero(codparq3, 1, 30, 0);
//            esperar();
//            pu1=new Puerta(7, cods.generarCodigo("PU"), "Vargas Machuca", null, new PuertaEntrada());
//            esperar();
//            pu2=new Puerta(8, cods.generarCodigo("PU"), "larga", null, new PuertaEntradaSalida());
//            esperar();
//            pu3=new Puerta(9, cods.generarCodigo("PU"), "luis cordero", null, new PuertaSalida());
//            pd.AgregarPuerta(codcampus, pu3);
//            pd.AgregarPuerta(codcampus, pu2);
//            pd.AgregarPuerta(codcampus, pu1);
//            b.mostrarMensaje("Creando Campus 2...Guardando Puertas 3.");
//            p.getPuertas().add(pu3);
//            p.getPuertas().add(pu2);
//            p.getPuertas().add(pu1);
//            b.mostrarMensaje("Creando Campus 2...Guardando Parqueadero 3.");
//            campus1.agregar(p);
//            
//            b.mostrarMensaje("Guardando Campus 2...");
//            cd.guardar(campus1);
//            
//            /**
//             * Creando usuarios
//             */
//            
//            b.mostrarMensaje("Creando Usuario 1...");
//            //public void guardarUsuario(String nombre, String apellido, String cedula, String telefono, String placa, String modelo, String marca, String tipotarifa, String modo) throws
//    
//            us.guardarUsuario("Pablo", "Guachi", "0105719926", "123123", "aaa-111","2015","mazda", "Docente", "c");
//            us.agregarCampusParqueadero("0105719926",codcampus1, codparq);
            
//            ts.comprovarDatos("0105719926", codcampus1, codparq, codpuerta, "entrar");
//            esperar();
//            ts.comprovarDatos("0105719926", codcampus1, codparq, codpuerta, "salir");
//            esperar(50);
            
//            b.mostrarMensaje("Creando Usuarios2...");
//            us.guardarUsuario("Chistian", "quinde", "1234567890", "098098", "2222-bbbb", "2014", "zuzuki", "Estudiante", "c");
//            us.agregarCampusParqueadero("1234567890", codcampus, codparq3);
//            us.agregarCampusParqueadero("1234567890", codcampus1, codparq);
//            us.agregarCampusParqueadero("1234567890", codcampus, codparq2);
//            
//            System.out.println("entrar: "+ts.comprovarDatos("1234567890", codcampus, codparq2, codpuerta1, "entrar"));
//            esperar();
//            System.out.println("salir: "+ts.comprovarDatos("1234567890", codcampus, codparq2, codpuerta2, "salir"));
//            ts.comprovarDatos("1234567890", codcampus1, codparq, codpuerta1, "entrar");
            //pendiente de salir         
            
            
            b.setVisible(false);
            ParqueaderoMAINGUI pmg = new ParqueaderoMAINGUI();
            pmg.setVisible(true);
//        } catch (CampusRepetidoException ex) {
//            Logger.getLogger(Universidad.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (DatoInvalidoException ex) {
//            Logger.getLogger(Universidad.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (UsuarioRepetidoException ex) {
//            Logger.getLogger(Universidad.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (UsuarioNoExisteException ex) {
//            Logger.getLogger(Universidad.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (QueryParseException ex) {
//            Logger.getLogger(Universidad.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (QueryExecutionException ex) {
//            Logger.getLogger(Universidad.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (FacturaExistenteException ex) {
//            Logger.getLogger(Universidad.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (FechasErroneasException ex) {
//            Logger.getLogger(Universidad.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (CampusNoExisteException ex) {
//            Logger.getLogger(Universidad.class.getName()).log(Level.SEVERE, null, ex);
//        }
        }
        catch (Exception ex) {
            Logger.getLogger(Universidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void esperar(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void esperar(long i){
        try {
            Thread.sleep(i);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
