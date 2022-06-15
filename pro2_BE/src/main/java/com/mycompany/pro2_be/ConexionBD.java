/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pro2_be;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author gabri
 */
public class ConexionBD {

    public ConexionBD() {
    }
    
    /*----------------------Medicos----------------------*/
    
    public void insertMed(Medico medi){
        Connection con = null;
        try{
            con = ConexionMySQL.ConectarBasedeDatos1();
            Statement statement = con.createStatement();
        
            statement.executeUpdate("INSERT INTO Medicos(cedula, nombre, contrasenna,especi, ubicacion, costo, frqCitas)"
             + " values ('"+medi.getCedula()+"', '"+medi.getNombre()+"','"+medi.getPassword()+"', '"+medi.getEspeci()+"',"
                     + " '"+medi.getUbicacion()+"', '"+medi.getCosto() +"', '"+medi.getFrqCitas()+"')");

            con.close();
        }catch (SQLException e) {
            e.getSQLState();
        }
    }
    
    
    public void insertHorario(String ced, Schedule horario){
        Connection con = null;
        try{
            con = ConexionMySQL.ConectarBasedeDatos1();
            Statement statement = con.createStatement();
        
            statement.executeUpdate("INSERT INTO Horarios(cedula_med, dia, horaIni,horaFin)"
             + " values ('"+ced+"', '"+horario.getDia()+"',"+horario.getHoraIni()+", '"+horario.getHoraFin()+"')");

            con.close();
        }catch (SQLException e) {
            e.getSQLState();
        }
    }
    
    public void insertarListHorario(String ced, List<Schedule> horario){
        for (int i=0;i<horario.size();i++) {
            insertHorario(ced, horario.get(i));
        }
    }
    public List<Schedule> getListHorario(String cedula_med){
        Connection con = null;
        List<Schedule> horarios = new ArrayList();
        
        try {
            con = ConexionMySQL.ConectarBasedeDatos1();
            CallableStatement statement = con.prepareCall("SELECT * FROM Horarios WHERE Horarios.cedula_med = '"+cedula_med+"'");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Schedule horario;
                horario = new Schedule(rs.getString("dia"), rs.getInt("horaIni"), rs.getInt("horaFin"));
                horarios.add(horario);
            }
            con.close();
            return horarios;
        } catch (SQLException e) {
            return null;
        }

    }
    public Medico busqMedicoId(String id, String passw){
        Connection con = null;
        Medico medico = null;
        try {
            con = ConexionMySQL.ConectarBasedeDatos1();
            CallableStatement statement = con.prepareCall("SELECT * FROM Medicos WHERE Medicos.cedula = '"+id +"' AND Medicos.contrasenna = '"+passw+"'");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                medico = new Medico(rs.getString("cedula"), rs.getString("nombre"), rs.getString("contrasenna"), rs.getString("especi"), rs.getString("ubicacion"), rs.getString("costo"), getListHorario(id), rs.getString("frqCitas"));
            }
            con.close();
            return medico;
        } catch (SQLException e) {
            return null;
        }
    }
        public Medico busqMedico(String id){
        Connection con = null;
        Medico medico = null;
        try {
            con = ConexionMySQL.ConectarBasedeDatos1();
            CallableStatement statement = con.prepareCall("SELECT * FROM Medicos WHERE Medicos.cedula = '"+id+"'");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                medico = new Medico(rs.getString("cedula"), rs.getString("nombre"), rs.getString("contrasenna"), rs.getString("especi"), rs.getString("ubicacion"), rs.getString("costo"), getListHorario(id), rs.getString("frqCitas"));
            }
            con.close();
            return medico;
        } catch (SQLException e) {
            return null;
        }
    }
     
    /*----------------------Pacientes----------------------*/
    public void insertPer(Persona per){
        Connection con = null;
        try{
            con = ConexionMySQL.ConectarBasedeDatos1();
            Statement statement = con.createStatement();
        
            statement.executeUpdate("INSERT INTO Personas(id, nombre, sexo,telefono, correo, edad)"
             + " values ('"+per.getCedula()+"', '"+per.getNombre()+"','"+per.getSexo()+"', "+per.getTelefono()+","
                     + " '"+per.getCorreo() +"', "+per.getEdad()+")");

            con.close();
        }catch (SQLException e) {
            e.getSQLState();
        }
    }
    
//    
//    public Paciente busqPacientePTR(double id2, String clave2){
//        Connection con = null;
//        Paciente paciente = null;
//        try {
//            con = ConexionMySQL.ConectarBasedeDatos1();
//            CallableStatement statement = con.prepareCall("SELECT * FROM Pacientes WHERE Pacientes.id = "+id2+" and Pacientes.clave= '"+clave2+"'");
//            ResultSet rs = statement.executeQuery();
//            while(rs.next()){
//              paciente = new Paciente(rs.getDouble("id"), rs.getString("clave"), rs.getString("nombre"), 2);
//            }
//            con.close();
//            return paciente;
//        } catch (SQLException e) {
//            return null;
//       }
//        
//    }
 
//    public void insertPac(Paciente paci){
//        Connection con = null;
//        try{
//            con = ConexionMySQL.ConectarBasedeDatos1();
//            Statement statement = con.createStatement();
//        
//            statement.executeUpdate("INSERT INTO Pacientes(id, clave, nombre) values ("+paci.getID()+", '"+paci.getClave()+"', '"+paci.getNombre()+"')");
//            
//            con.close();
//        }catch (SQLException e) {
//            e.getSQLState();
//        }
//    }
    
    /*----------------------Administrador----------------------*/
    
//    public boolean busqAdmi(double id2, String clave2){
//        Connection con = null;
//        Administrador administrador = null;
//        try {
//            con = ConexionMySQL.ConectarBasedeDatos1();
//            CallableStatement statement = con.prepareCall("SELECT * FROM Admi WHERE id = "+id2+" and clave= '"+clave2+"'");
//            ResultSet rs = statement.executeQuery();
//            while(rs.next()){
//                administrador = new Administrador(rs.getDouble("id"), rs.getString("clave"), 1);
//            }
//            con.close();
//            return administrador != null;
//        } catch (Exception e) {
//            return false;
//        }
//        
//    }
    
    public void updateMed(String id){
        Connection con = null;
        try{
            con = ConexionMySQL.ConectarBasedeDatos1();
            Statement statement = con.createStatement();
        
            statement.executeUpdate("UPDATE Medico SET estado='activo' WHERE id='"+id+"'");

            con.close();
        }catch (SQLException e) {
            e.getSQLState();
        }
    }
    
}
