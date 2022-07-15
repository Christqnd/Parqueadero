/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author gube
 */
public class Usuario implements java.io.Serializable {

    private Long id;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String cedula;
    private String telefono;
    private String estado;
    private List<Vehiculo> vehiculos;

    public Usuario(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String apellido, String cedula, String telefono, String estado) {
        super();
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.estado = estado;
        this.vehiculos = new LinkedList<>();
    }

    public Usuario(Long id, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String apellido, String cedula, String telefono, String estado, LinkedList<Vehiculo> vehiculos) {
        super();
        this.id = id;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.estado = estado;
        this.vehiculos = vehiculos;
    }

    public Usuario(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String apellido, String cedula, String telefono, String estado, LinkedList<Vehiculo> vehiculos) {
        super();
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.estado = estado;
        this.vehiculos = vehiculos;
    }

    public Usuario() {
        super();
        this.primerNombre = "";
        this.segundoNombre = "";
        this.primerApellido = "";
        this.segundoApellido = "";
        this.cedula = "";
        this.telefono = "";
        this.estado = "A";
        this.vehiculos = new LinkedList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Establece la tarifa para cada tipo de usuario
     */
//    public void tarifaDocente() {
//        setTarifa(new Docente());
//    }
//
//    public void tarifaEstudiante() {
//        setTarifa(new Estudiante());
//    }
//
//    public void tarifaEmpleado() {
//        setTarifa(new Empleado());
//    }
    /**
     * @return the vehiculo
     */
//    public Vehiculo getVehiculo() {
//        return vehiculo;
//    }
//
//    /**
//     * @param vehiculo the vehiculo to set
//     */
//    public void setVehiculo(Vehiculo vehiculo) {
//        this.vehiculo = vehiculo;
//    }
    /**
     * @return the tarjeta
     */
//    public Tarjeta getTarjeta() {
//        return tarjeta;
//    }
//
//    /**
//     * @param tarjeta the tarjeta to set
//     */
//    public void setTarjeta(Tarjeta tarjeta) {
//        this.tarjeta = tarjeta;
//    }
//
//    /**
//     * @return the tarifa
//     */
//    public Tarifa getTarifa() {
//        return tarifa;
//    }
//
//    /**
//     * @param tarifa the tarifa to set
//     */
//    public void setTarifa(Tarifa tarifa) {
//        this.tarifa = tarifa;
//    }
//    public List<Factura> getFacturas() {
//        return facturas;
//    }
//
//    public void setFacturas(List<Factura> facturas) {
//        this.facturas = facturas;
//    }
//    public boolean agregarFactura(Factura factura) {
//        return getFacturas().add(factura);
//    }
//agregar getFactura actual 
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {

        return "nombres: " + this.primerNombre + " " + this.segundoNombre + ", apellidos: " + this.primerApellido + " " + this.segundoApellido + ", cedula: " + this.cedula + ", telefono: " + this.telefono;

    }

    public String toJSONCreate() {
        String string = "{\"primerNombre\": \"" + this.primerNombre + "\", \"segundoNombre\": \"" + this.segundoNombre
                + "\", \"primerApellido\": \"" + this.primerApellido + "\", \"segundoApellido\": \"" + this.segundoApellido
                + "\", \"cedula\": \"" + this.cedula + "\", \"telefono\": \"" + this.telefono + "\", \"estado\": \"" + this.estado + "\", \"vehiculos\": [";
        for (Iterator<Vehiculo> iterator = vehiculos.iterator(); iterator.hasNext();) {
            Vehiculo vehiculo = iterator.next();
            string += vehiculo.toJSONCreate();
            string += iterator.hasNext() ? "," : "";
        }
        string += "] } ";
        return string;

    }

    public String toJSONUpdate() {
        String string
                = "{\"id\": " + this.id
                + " , \"primerNombre\": \"" + this.primerNombre + "\", \"segundoNombre\": \"" + this.segundoNombre
                + "\", \"primerApellido\": \"" + this.primerApellido + "\", \"segundoApellido\": \"" + this.segundoApellido
                + "\", \"cedula\": \"" + this.cedula + "\", \"telefono\": \"" + this.telefono + "\", \"estado\": \"" + this.estado + "\", \"vehiculos\": [";
        for (Iterator<Vehiculo> iterator = vehiculos.iterator(); iterator.hasNext();) {
            Vehiculo vehiculo = iterator.next();
            string += vehiculo.toJSONUpdate();
            string += iterator.hasNext() ? "," : "";
        }
        string += "] } ";
        return string;

    }

}
