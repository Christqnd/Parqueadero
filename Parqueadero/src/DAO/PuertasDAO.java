/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODELO.Puerta;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pablopc
 */
public class PuertasDAO {
    private Map<String,List<Puerta>> puertas=new HashMap();
    private static PuertasDAO instancia=null;

    public PuertasDAO() {
    }
    
    public static PuertasDAO getInstancia(){
        if(instancia==null)
            instancia=new PuertasDAO();
        return instancia;
    }
    
    
    public void AgregarPuerta(String codcampus,Puerta p){
        if(this.getPuertas().containsKey(codcampus)){
            this.getPuertas().get(codcampus).add(p);
        }else{
            List lista=new ArrayList();
            lista.add(p);
            this.getPuertas().put(codcampus, lista);
        }
        System.out.println("Puerta: "+p.getCodigo()+" Guardada en campus: "+codcampus);
    }
    
   
    
    public List<Puerta> obtenerPuertas(String codCampus) throws CodigodeCampusNoExisteException{
        if(!this.puertas.containsKey(codCampus)){
            throw new CodigodeCampusNoExisteException();
        }
        return this.getPuertas().get(codCampus);
    }
    
    
    public Puerta obtenerPuerta(String codcampus,String codpuerta) throws CodigodeCampusNoExisteException, PuertaNoexisteException{
        if(!this.puertas.containsKey(codcampus)){
            throw new CodigodeCampusNoExisteException();
        }
        int valor=this.buscarPuerta(codcampus, codpuerta);
        if(valor==-1){
            throw new PuertaNoexisteException();
        }
        
                
        return this.puertas.get(codcampus).get(valor-1);
    }
    public void eliminarpuerta(String codcampus,String codpuerta) throws CodigodeCampusNoExisteException{
        if(!this.puertas.containsKey(codcampus)){
            throw new CodigodeCampusNoExisteException();
        }
        List<Puerta> lista=this.getPuertas().get(codcampus);
        
        int i=0;
        for(i=0;i<lista.size();i++){
            if(lista.get(i).getCodigo().equals(codpuerta)){
                i=lista.size();
            }
        }
        
        lista.remove(i);
        System.out.println("puerta Elimindada");
        this.getPuertas().put(codcampus, lista);
    }
    
    
    public List<Puerta> obtenerListaPuertasPor(String codcampus,String filtro) throws CodigodeCampusNoExisteException{
        List<Puerta> lista=this.obtenerPuertas(codcampus);
        List<Puerta> listareturn=new ArrayList();
        for(Puerta p:lista){
            if(p.getTipoDePuerta().estadoPuerta().equalsIgnoreCase(filtro)){
                listareturn.add(p);
            }
        }
        return listareturn;
    }
    public int buscarPuerta(String codcampus,String codpuerta){
        List <Puerta> lista=new ArrayList<>(this.puertas.get(codcampus));
        boolean valor=true;
        int i=0;
        while(valor){
            if(lista.get(i).getCodigo().equalsIgnoreCase(codpuerta)){
                valor=false;
            }
            i++;
        }
        if(valor)
            i=-1;
        return i;
    }

    /**
     * @return the puertas
     */
    public Map<String,List<Puerta>> getPuertas() {
        return puertas;
    }

    /**
     * @param puertas the puertas to set
     */
    public void setPuertas(Map<String,List<Puerta>> puertas) {
        this.puertas = puertas;
    }
    
    
    
    public void mostrar(){
        List<String> lista=new ArrayList<>(this.puertas.keySet());
        for(String s:lista){
            System.out.println(s);
            List<Puerta> lista2=this.puertas.get(s);
            for(Puerta p:lista2){
                System.out.println("/t"+p);
            }
        }
    }
    
}
