/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author gube
 */
public class Parqueadero implements java.io.Serializable {

    private Long idParqueadero;
    private String codigo;
    private int numero;
    private String nombre;
    private String descripcion;
    private String estado;
    private Date fechaCreacion;
    private int capacidad;
    private int ocupados;
    private Long idEmpresa;
    private List<Puerta> puertas;

    public Parqueadero() {
        super();
        this.codigo = "";
        this.numero = 0;
        this.nombre = "";
        this.descripcion = "";
        this.estado = "A";
        this.fechaCreacion = new Date();;
        this.capacidad = 0;
        this.ocupados = 0;
        this.puertas = new LinkedList<>();;
    }

    public Parqueadero(Long idParqueadero, String codigo, int numero, String nombre, String descripcion, String estado, Date fechaCreacion, int capacidad, int ocupados, Long idEmpresa, List<Puerta> puertas) {
        super();
        this.idParqueadero = idParqueadero;
        this.codigo = codigo;
        this.numero = numero;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.capacidad = capacidad;
        this.ocupados = ocupados;
        this.idEmpresa = idEmpresa;
        this.puertas = puertas;
    }

    public Long getIdParqueadero() {
        return idParqueadero;
    }

    public void setIdParqueadero(Long idParqueadero) {
        this.idParqueadero = idParqueadero;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getOcupados() {
        return ocupados;
    }

    public void setOcupados(int ocupados) {
        this.ocupados = ocupados;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public List<Puerta> getPuertas() {
        return puertas;
    }

    public void setPuertas(List<Puerta> puertas) {
        this.puertas = puertas;
    }

}
