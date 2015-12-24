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
public class Estudiante implements Tarifa, java.io.Serializable{

    private final Double valor=30.40;
    
    @Override
    public double obtenerTarifa() {
        return this.valor;
    }    
}
