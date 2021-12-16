/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gube
 */
public class Empresa implements java.io.Serializable{
    private String nombre;
    private String codigo;
    private int Cant_puertas=0;
    private Map<String,Parqueadero> parqueaderos=new HashMap();

    public Empresa(String nombre, String codigo, int cant_puertas){
        this.nombre = nombre;
        this.codigo = codigo;
        this.Cant_puertas=cant_puertas;
    }    

    @Override
    public String toString() {
        return this.getCodigo()+", "+this.getNombre()+", "+this.getCant_puertas();
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
     * @return the Cant_puertas
     */
    public int getCant_puertas() {
        return Cant_puertas;
    }

    /**
     * @param Cant_puertas the Cant_puertas to set
     */
    public void setCant_puertas(int Cant_puertas) {
        this.Cant_puertas = Cant_puertas;
    }
    
    public void agregar(Parqueadero p){
        this.getParqueaderos().put(p.getCodigo(), p);
    }
    public Parqueadero obtener(String clave){
        return this.getParqueaderos().get(clave);
    }

    /**
     * @return the parqueaderos
     */
    public Map<String,Parqueadero> getParqueaderos() {
        return parqueaderos;
    }
}
