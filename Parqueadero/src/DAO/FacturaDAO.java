/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODELO.DetalleFactura;
import MODELO.Factura;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Christian Quinde <christian24091992@gmail.com>
 */
public class FacturaDAO {

    private Map<String, LinkedList<Factura>> facturas = null;
    private static FacturaDAO instancia = null;

    private FacturaDAO() {
        facturas = new HashMap<>();
    }

    public static FacturaDAO getInstancia() {
        if (instancia == null) {
            instancia = new FacturaDAO();
        }
        return instancia;
    }

    public void setFacturas(Map<String, LinkedList<Factura>> facturas) {
        this.facturas = facturas;
    }

    public Map<String, LinkedList<Factura>> getFacturas() {
        return facturas;
    }

    public boolean agregar(String cedula, Factura factura) {
        getFacturas().put(cedula, new LinkedList<Factura>());
        getFacturas().get(cedula).add(factura);
        for (Map.Entry<String, LinkedList<Factura>> entrySet : facturas.entrySet()) {
            String key = entrySet.getKey();
            LinkedList<Factura> value = entrySet.getValue();
            System.out.println("clave:" + key);
            for (Factura value1 : value) {
                System.out.println("valores : " + value1.estadoFactura());
            }
        }
        return true;
    }
    public LinkedList<Factura> buscar(String cedula){
        return getFacturas().get(cedula);
    }

    public boolean existe(String cedula) {
        return getFacturas().containsKey(cedula);
    }

    public void eliminar(String cedula){
         getFacturas().remove(cedula);
    }
}
