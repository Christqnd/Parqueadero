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
public class Puerta implements java.io.Serializable,StatePuerta{
    private boolean asignado=false;
    private int numero;
    private String Codigo;
    private String Ubicacion; // ejm: ave. 12 abril
    private Portero portero;
    private StatePuerta tipoDePuerta;//tipo de puerta(Entrada,Salida,Entrada y Salida)

    public Puerta(int numero, String Codigo, String Ubicacion) {
        this.numero = numero;
        this.Codigo = Codigo;
        this.Ubicacion = Ubicacion;
    }

    public Puerta(int numero, String Codigo, String Ubicacion, Portero portero, StatePuerta tipoDePuerta) {
        this.numero = numero;
        this.Codigo = Codigo;
        this.Ubicacion = Ubicacion;
        this.portero = portero;
        this.tipoDePuerta = tipoDePuerta;
    }
    

    public Puerta() {
        
    }

    @Override
    public String toString() {
        return this.getNumero()+", "+this.Codigo+", "+this.Ubicacion;
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
     * @return the Codigo
     */
    public String getCodigo() {
        return Codigo;
    }

    /**
     * @param Codigo the Codigo to set
     */
    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    /**
     * @return the Ubicacion
     */
    public String getUbicacion() {
        return Ubicacion;
    }

    /**
     * @param Ubicacion the Ubicacion to set
     */
    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    /**
     * @return the portero
     */
    public Portero getPortero() {
        return portero;
    }

    /**
     * @param portero the portero to set
     */
    public void setPortero(Portero portero) {
        this.portero = portero;
    }

    /**
     * @return the tipoDePuerta
     */
    public StatePuerta getTipoDePuerta() {
        return tipoDePuerta;
    }

    /**
     * @param tipoDePuerta the tipoDePuerta to set
     */
    public void setTipoDePuerta(StatePuerta tipoDePuerta) {
        this.tipoDePuerta = tipoDePuerta;
    }

    @Override
    public String estadoPuerta() {
        return getTipoDePuerta().estadoPuerta();
    }

    /**
     * @return the asignado
     */
    public boolean isAsignado() {
        return asignado;
    }

    /**
     * @param asignado the asignado to set
     */
    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }
    
    
}
