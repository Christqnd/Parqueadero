/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gube
 */
public class Empresa implements java.io.Serializable {

    private Long idEmpresa;
    private String codigo;
    private String nombre;
    private String descripcion;
    private String propietario;
    private String estado;
    private Date fechaCreacion;
    private List<Parqueadero> parqueaderos;

    public Empresa() {
        super();
        this.codigo = "";
        this.nombre = "";
        this.descripcion = "";
        this.propietario = "";
        this.estado = "A";
        this.fechaCreacion = new Date();
        this.parqueaderos = new LinkedList<>();

    }

    public Empresa(Long idEmpresa, String codigo, String nombre, String descripcion, String propietario, String estado, Date fechaCreacion, List<Parqueadero> parqueaderos) {
        super();
        this.idEmpresa = idEmpresa;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.propietario = propietario;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.parqueaderos = parqueaderos;
    }
    
    
        public Empresa( String codigo, String nombre, String descripcion, String propietario, List<Parqueadero> parqueaderos) {
        super();
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.propietario = propietario;
        this.estado = "A";
        this.fechaCreacion = new Date();
        this.parqueaderos = parqueaderos;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
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

    public List<Parqueadero> getParqueaderos() {
        return parqueaderos;
    }

    public void setParqueaderos(List<Parqueadero> parqueaderos) {
        this.parqueaderos = parqueaderos;
    }
    

    
}
