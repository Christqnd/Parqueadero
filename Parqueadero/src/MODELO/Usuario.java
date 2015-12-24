/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.util.List;

/**
 *
 * @author gube
 */
public class Usuario implements java.io.Serializable{
//usamos la interfaz comparable o josql?????
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private Vehiculo vehiculo;
    private Tarjeta tarjeta;
    private Tarifa tarifa;
    private List<Factura> facturas;

    public Usuario(String nombre, String apellido, String cedula,String telefono, Vehiculo vehiculo, Tarjeta tarjeta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono=telefono;
        this.vehiculo = vehiculo;
        this.tarjeta = tarjeta;
        this.facturas= getFacturas();
    }

    /**
     * Establece la tarifa para cada tipo de usuario
     */
    public void tarifaDocente() {
        setTarifa(new Docente());
    }

    public void tarifaEstudiante() {
        setTarifa(new Estudiante());
    }

    public void tarifaEmpleado() {
        setTarifa(new Empleado());
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the vehiculo
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * @param vehiculo the vehiculo to set
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * @return the tarjeta
     */
    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    /**
     * @param tarjeta the tarjeta to set
     */
    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    /**
     * @return the tarifa
     */
    public Tarifa getTarifa() {
        return tarifa;
    }

    /**
     * @param tarifa the tarifa to set
     */
    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    @Override
    public String toString() {
        return this.getNombre() + ", " + this.getApellido() + ", " + this.getCedula();
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public boolean agregarFactura(Factura factura) {
        return getFacturas().add(factura);
    }
//agregar getFactura actual 

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
