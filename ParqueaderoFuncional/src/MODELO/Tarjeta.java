/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gube
 */
public class Tarjeta implements java.io.Serializable {

    /**
     * lista de codigos de parqueaderos por campus
     */
    private Date registroIngreso;
    private Date registroSalida;
    private String registroCodigoCampus;
    private String registroCodigoParqueadero;
    /**
     * para verificar si el usuario esta dentro a fuera de un parqueadero
     */
    private boolean estado = false;
    //primer string para codigo de campus y list<String> claves de parqueadero con acceso
    private Map<String, List<String>> permisosCP = new HashMap();
    //primer string para codigo de parqueadero y segundo para claves de puerta
    private Map<String, List<String>> permisosPP = new HashMap<>();
    //primer string para codigo de puertas y segundo para tipo de puerta
    private Map<String, String> permisosPT = new HashMap<>();

    public boolean verificar(String keycampus, String keyparqueadero, String keypuerta, String modo, Date fecha) {
        if (this.permisosCP.containsKey(keycampus)) {
            if (this.permisosCP.get(keycampus).contains(keyparqueadero)) {
                if (modo.equals("entrar") && !estado) {// permisosPP.get(keyparqueadero).get(keypuerta).equals("Entrada")||permisosPP.get(keyparqueadero).get(keypuerta).equals("Entrada/Salida") )
                    if (this.permisosPP.get(keyparqueadero).contains(keypuerta) && (permisosPT.get(keypuerta).equals("Entrada")||permisosPT.get(keypuerta).equals("Entrada/Salida"))) {
                        estado = true;
                        registroIngreso = fecha;
                        registroCodigoCampus = keycampus;
                        registroCodigoParqueadero = keyparqueadero;
                        System.out.println("Entrada exitosa");
                        return true;
                    }

                } else if (modo.equals("salir") && estado) {//&&( permisosPP.get(keyparqueadero).get(keypuerta).equals("Salida")||permisosPP.get(keyparqueadero).get(keypuerta).equals("Entrada/Salida") )
                    if (registroCodigoCampus.equals(keycampus) && registroCodigoParqueadero.equals(keyparqueadero)) {
                        if (this.permisosPP.get(keyparqueadero).contains(keypuerta) && (permisosPT.get(keypuerta).equals("Salida")||permisosPT.get(keypuerta).equals("Entrada/Salida"))) {
                            estado = false;
                            registroSalida = fecha;
                            System.out.println("Entrada exitosa");
                            return true;
                        }
                    }
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
        return false;
    }

    public void agregarPermisos(String keycampus, String keyparqueadero, List<Puerta> puertas) {
        if (this.permisosCP.containsKey(keycampus)) {
            this.permisosCP.get(keycampus).add(keyparqueadero);
//////////////////////////////////////////////////////////////////////////////////////////////////
            if (!this.permisosPP.containsKey(keyparqueadero)) {
                permisosPP.put(keyparqueadero, new ArrayList<String>());
            }
            if (this.permisosPP.containsKey(keyparqueadero)) {
                for (Iterator<Puerta> p = puertas.iterator(); p.hasNext();) {
                    Puerta puerta = p.next();
                    permisosPP.get(keyparqueadero).add(puerta.getCodigo());
                    permisosPT.put(puerta.getCodigo(), puerta.getTipoDePuerta().estadoPuerta());
                }
            }
///////////////////////////////////////////////////////////////////////////////////////////////////
        } else {
            this.permisosCP.put(keycampus, new ArrayList<String>());
            this.agregarPermisos(keycampus, keyparqueadero, puertas);
        }

    }

    public void setPermisos(Map<String, List<String>> permisosCP) {
        this.permisosCP = permisosCP;
    }

    public Map<String, List<String>> getPermisos() {
        return permisosCP;
    }

    public void setRegistroSalida(Date registroSalida) {
        this.registroSalida = registroSalida;
    }

    public void setRegistroIngreso(Date registroIngreso) {
        this.registroIngreso = registroIngreso;
    }

    public Date getRegistroSalida() {
        return registroSalida;
    }

    public Date getRegistroIngreso() {
        return registroIngreso;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

}
