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
public class Docente implements Tarifa, java.io.Serializable{
    
    private final double valor=70;

    @Override
    public double obtenerTarifa() {
        return this.valor;
    }
    
}
