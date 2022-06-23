/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pro2_be;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Service {
    private static Service uniqueInstance;
    ConexionBD conn = new ConexionBD();
    
    public static Service instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Service();
        }
        return uniqueInstance;
    }
    
    
    HashMap<String,Persona> personas;
    HashMap<String,Medico> medicos;
    
    private Service(){
        personas=new HashMap<>();
        medicos=new HashMap<>();
   }
        
  
   
    public List<Persona> personasREAD() {
        return new ArrayList(personas.values());
    } 
    
    
        public List<Medico> medicosREAD() {
        return new ArrayList(medicos.values());
    } 
    
    
    public Persona personasREAD(String cedula)throws Exception {
        if (personas.get(cedula)!=null){
            return personas.get(cedula);
        }
        else{
            throw new Exception ("404-persona no existe");
        }
    }
    
    public List<Persona> personasMedicosREAD(String cedula_med)throws Exception {
        if (!conn.getPacXMedico(cedula_med).isEmpty()){
            return conn.getPacXMedico(cedula_med);
        }
        else{
            throw new Exception ("404-persona no existe");
        }
    }
    

     public List<Medico> MedicosREADL()throws Exception {
        if (!conn.getMedicos().isEmpty()){
            return conn.getMedicos();
        }
        else{
            throw new Exception ("404-medico no existe");
        }
    }
    
    

    public void personasUPDATE(Persona per)throws Exception {
        if (personas.get(per.getCedula())==null){
            throw new Exception ("404-persona no existe");
        }
        else{
            personas.put(per.getCedula(), per);
        }
    }
    
    public void personasDELETE(String cedula)throws Exception {
        if (personas.get(cedula)==null){
            throw new Exception ("404-persona no existe");
        }
        else{
            personas.remove(cedula);
        }
    }

    
    public Persona personasCREATE(Persona per)throws Exception {
        if (personas.get(per.getCedula())!=null){
            throw new Exception ("406-persona ya existe");
        }
        else{
            conn.insertPer(per);
            personas.put(per.getCedula(),per);
            return per;
        }
    } 
    
    public void citasCREATE(Cita c)throws Exception {
        if (conn.busqCita(c) != null){
            throw new Exception ("406-cita ya existe");
        }
        else{
            conn.insertCitas(c); 
        }
    }
    
    
    public Medico medicosCREATE(Medico med) throws Exception{
        if(conn.busqMedicoId(med.getCedula(), med.getPassword()) != null){
            throw new Exception ("406-medico ya existe");
        }else{             
            conn.insertMed(med);
            conn.insertarListHorario(med.getCedula(), med.getHorario() );
            return med;
        }
    }
    
      
    

      public void medicosUpdateEstado(String cedula)throws Exception {
        if (conn.busqMedico(cedula) != null){
             conn.updateMed(cedula);
        }
        else{
          
           throw new Exception ("406-medico ya existe");
        }
    }
    
    
    

    
    /*public Medico medicosREAD(String cedula) throws Exception{
        if(medicos.get(cedula) != null){
            return medicos.get(cedula);
        }else{
            throw new Exception("404-Medico no existe");
        }
    }*/
    public Medico medicosREAD(String cedula, String password) throws Exception{
        if(conn.busqMedicoId(cedula, password) != null){
            return conn.busqMedicoId(cedula, password);
        }else{
            throw new Exception("404-Medico no existe");
        }
    }
    
 
    
    public void medicosDELETE(String cedula) throws Exception{
        if(medicos.get(cedula) == null){
            throw new Exception("404-Medico no existe");
        }else{
            medicos.remove(cedula);
        }
    }

    public List<Cita> citasREAD(String cedula) throws Exception {
        if(conn.getCitasXMedico(cedula) != null){
            return conn.getCitasXMedico(cedula);
        }else{
            throw new Exception("404-Medico no existe");
        }
    }

}
