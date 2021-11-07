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
public class Empleado implements Tarifa, java.io.Serializable {

    private final Double valor = 30.0;

    @Override
    public double obtenerTarifa() {
        return this.valor;
    }

}
