/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author Christian Quinde <christian24091992@gmail.com>
 */
public class Factura implements StateFactura{

    private Date tiempo;
    private String cedula;
    private double total;
    private double subtotal;
    private double iva;
    private StateFactura estadoFactura;
    private LinkedList<DetalleFactura> listaDetalleFacturas = new LinkedList<>();

    public Factura() {
    }

    public Factura(Date tiempo, double total, double subtotal, double iva, StateFactura estadoFactura) {
        this.tiempo = tiempo;
        this.total = total;
        this.subtotal = subtotal;
        this.iva = iva;
        this.estadoFactura = estadoFactura;
    }
    

    @Override
    public String estadoFactura() {
        return getEstadoFactura().estadoFactura();
    }

    /**
     * @return the tiempo
     */
    public Date getTiempo() {
        return tiempo;
    }

    /**
     * @param tiempo the tiempo to set
     */
    public void setTiempo(Date tiempo) {
        this.tiempo = tiempo;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the subtotal
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * @return the iva
     */
    public double getIva() {
        return iva;
    }

    /**
     * @param iva the iva to set
     */
    public void setIva(double iva) {
        this.iva = iva;
    }

    /**
     * @return the estadoFactura
     */
    public StateFactura getEstadoFactura() {
        return estadoFactura;
    }

    /**
     * @param estadoFactura the estadoFactura to set
     */
    public void setEstadoFactura(StateFactura estadoFactura) {
        this.estadoFactura = estadoFactura;
    }

    /**
     * @return the listaDetalleFacturas
     */
    public LinkedList<DetalleFactura> getListaDetalleFacturas() {
        return listaDetalleFacturas;
    }

    /**
     * @param listaDetalleFacturas the listaDetalleFacturas to set
     */
    public void setListaDetalleFacturas(LinkedList<DetalleFactura> listaDetalleFacturas) {
        this.listaDetalleFacturas = listaDetalleFacturas;
    }

}
