/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gube
 */
public class Parqueadero implements java.io.Serializable{
    private String codigo;
    private int numero;    
    private int capacidad;
    private int ocupados;
    
    private List<Puerta> puertas=new ArrayList();

    public Parqueadero(String codigo, int numero, int capacidad, int ocupados) {
        this.codigo = codigo;
        this.numero = numero;
        this.capacidad = capacidad;
        this.ocupados = ocupados;
    }

    public Parqueadero() {
    }
    
    @Override
    public String toString() {
        return this.getCodigo()+", "+this.getNumero()+", "+this.getCapacidad();
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the capacidad
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * @param capacidad the capacidad to set
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * @return the ocupados
     */
    public int getOcupados() {
        return ocupados;
    }

    /**
     * @param ocupados the ocupados to set
     */
    public void setOcupados(int ocupados) {
        this.ocupados = ocupados;
    }

    /**
     * @return the puertas
     */
    public List<Puerta> getPuertas() {
        return puertas;
    }

    /**
     * @param puertas the puertas to set
     */
    public void setPuertas(List<Puerta> puertas) {
        this.puertas = puertas;
    }
    
    
    
}
