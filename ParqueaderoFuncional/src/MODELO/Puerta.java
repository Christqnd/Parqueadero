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
public class Puerta implements java.io.Serializable {

    private Long idPuerta;
    private boolean asignado = false;
    private int numero;
    private String descripcion;
    /* Entrada, Salida, Mixta*/
    private String tipo;
    private Long idParqueadero;

    public Puerta() {
        super();
        this.numero = 0;
        this.descripcion = "";
        this.tipo = "";
    }

    public Puerta(Long idLong, int numero, String descripcion, String tipo, Long idParqueadero) {
        super();
        this.idPuerta = idPuerta;
        this.numero = numero;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.idParqueadero = idParqueadero;
    }

    public Long getIdPuerta() {
        return idPuerta;
    }

    public void setIdPuerta(Long idPuerta) {
        this.idPuerta = idPuerta;
    }

    public boolean isAsignado() {
        return asignado;
    }

    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getIdParqueadero() {
        return idParqueadero;
    }

    public void setIdParqueadero(Long idParqueadero) {
        this.idParqueadero = idParqueadero;
    }

}
