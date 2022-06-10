/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pro2_be;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Service {
    private static Service uniqueInstance;
    
    public static Service instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Service();
        }
        return uniqueInstance;
    }
    
    HashMap<String,Medico> medicos;
    
    private Service(){
        medicos=new HashMap<>();
    }
    
    public Medico medicosCREATE(Medico med) throws Exception{
        if(medicos.get(med.getCedula()) != null){
            throw new Exception ("406-medico ya existe");
        }else{
            medicos.put(med.getCedula(), med);
            return med;
        }
    }
    
    public List<Medico> medicosREAD(){
        return new ArrayList(medicos.values());
    }
    
    public Medico medicosREAD(String cedula) throws Exception{
        if(medicos.get(cedula) != null){
            return medicos.get(cedula);
        }else{
            throw new Exception("404-Medico no existe");
        }
    }
    
    public void medicosUPDATE(Medico med) throws Exception{
        if(medicos.get(med.getCedula()) == null){
            throw new Exception("404-Medico no existe");
        }else{
            medicos.put(med.getCedula(), med);
        }
    }
    
    public void medicosDELETE(String cedula) throws Exception{
        if(medicos.get(cedula) == null){
            throw new Exception("404-Medico no existe");
        }else{
            medicos.remove(cedula);
        }
    }
}
