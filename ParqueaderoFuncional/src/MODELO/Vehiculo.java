/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

/**
 *
 * @author gube
 */
public class Vehiculo implements java.io.Serializable {

    private Long id;
    private String placa;
    private String marca;
    private String modelo;
    private String observacion;
    private String estado;
    private Long idUsuario;

    public Vehiculo(String placa, String marca, String modelo, String observacion, String estado, Long idUsuario) {
        super();
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.observacion = observacion;
        this.estado = estado;
        this.idUsuario = idUsuario;
    }

    public Vehiculo(Long id, String placa, String marca, String modelo, String observacion, String estado, Long idUsuario) {
        super();
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.observacion = observacion;
        this.estado = estado;
        this.idUsuario = idUsuario;
    }

    public Vehiculo(String placa, String marca, String modelo, String observacion, String estado) {
        super();
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.observacion = observacion;
        this.estado = estado;
    }

    public Vehiculo() {
        super();
        this.placa = "";
        this.marca = "";
        this.modelo = "";
        this.observacion = "";
        this.estado = "A";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "placa: " + this.placa + ", marca: " + this.marca + ", modelo: " + this.modelo + ", observacion: " + this.observacion + "";
    }

    public String toJSONCreate() {
        return "{ \"placa\": \"" + this.placa + "\", \"marca\": \"" + this.marca + "\", \"modelo\": \"" + this.modelo + "\", \"observacion\": \"" + this.observacion + "\", \"estado\": \"" + this.estado + "\"}";
    }

    public String toJSONUpdate() {
        return "{ "
                + (this.id == null ? "" : "\"id\": " + this.id + " ,")
                        + " \"placa\": \"" + this.placa + "\", \"marca\": \"" + this.marca + "\", \"modelo\": \"" + this.modelo + "\", \"observacion\": \"" + this.observacion + "\", \"estado\": \"" + this.estado + "\", \"idUsuario\": " + this.idUsuario + "}";
    }

}
