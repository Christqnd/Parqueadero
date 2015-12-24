/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MODELO;

/**
 * 
 * @author Christian Quinde <christian24091992@gmail.com>
 */
public class FacturaCancelada implements StateFactura{

    @Override
    public String estadoFactura() {
       return "Factura Cancelada";
    }

}
