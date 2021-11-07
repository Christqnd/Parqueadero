    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.util.Date;

/**
 *
 * @author Christian Quinde <christian24091992@gmail.com>
 */
public class DetalleFactura {

    private Date fechaHoraEntrada;
    private Date fechaHoraSalida;
    private String tiempo;

    public DetalleFactura(Date fechaHoraEntrada, Date fechaHoraSalida) {
        this.fechaHoraEntrada = fechaHoraEntrada;
        this.fechaHoraSalida = fechaHoraSalida;
        this.tiempo=CalularTiempo(fechaHoraEntrada, fechaHoraSalida);
    }

    /**
     * @return the fechaHoraEntrada
     */
    public Date getFechaHoraEntrada() {
        return fechaHoraEntrada;
    }

    /**
     * @param fechaHoraEntrada the fechaHoraEntrada to set
     */
    public void setFechaHoraEntrada(Date fechaHoraEntrada) {
        this.fechaHoraEntrada = fechaHoraEntrada;
    }

    /**
     * @return the fechaHoraSalida
     */
    public Date getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    /**
     * @param fechaHoraSalida the fechaHoraSalida to set
     */
    public void setFechaHoraSalida(Date fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }


    /**
     * @return the tiempo
     */
    public String getTiempo() {
        return tiempo;
    }

    /**
     * @param tiempo the tiempo to set
     */
    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
    
    private String CalularTiempo(Date fecha1, Date fecha2) {
        long milisegundos = (fecha2.getTime() - fecha1.getTime());
        int segundos = (int) (milisegundos / 1000) % 60;
        int minutos = (int) ((milisegundos / (1000 * 60)) % 60);
        int horas = (int) ((milisegundos / (1000 * 60 * 60)));
        String f = " " + horas + " : " + minutos + " : " + segundos;
        return f;
    }
}
