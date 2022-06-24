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
        
            statement.executeUpdate("INSERT INTO Medicos(cedula, nombre, contrasenna,especi, ubicacion, costo, frqCitas, estado)"
             + " values ('"+medi.getCedula()+"', '"+medi.getNombre()+"','"+medi.getPassword()+"', '"+medi.getEspeci()+"',"
                     + " '"+medi.getUbicacion()+"', '"+medi.getCosto() +"', '"+medi.getFrqCitas()+"', 'Inactivo')");
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
                medico = new Medico(rs.getString("cedula"), rs.getString("nombre"), rs.getString("contrasenna"), rs.getString("especi"), rs.getString("ubicacion"), rs.getString("costo"), getListHorario(id), rs.getString("frqCitas"), rs.getString("estado"));
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
                medico = new Medico(rs.getString("cedula"), rs.getString("nombre"), rs.getString("contrasenna"), rs.getString("especi"), rs.getString("ubicacion"), rs.getString("costo"), getListHorario(id), rs.getString("frqCitas"), rs.getString("estado"));
            }
            con.close();
            return medico;
        } catch (SQLException e) {
            return null;
        }
    }
        
    public void updateMed(String cedula){
        Connection con = null;
        try{
            con = ConexionMySQL.ConectarBasedeDatos1();
            Statement statement = con.createStatement();
        
            statement.executeUpdate("UPDATE Medicos SET estado='Activo' WHERE cedula='"+cedula+"'");

            con.close();
        }catch (SQLException e) {
            e.getSQLState();
        }
    }
    
      
    
    /*----------------------Pacientes----------------------*/
    public void insertPer(Persona per){
        Connection con = null;
        try{
            con = ConexionMySQL.ConectarBasedeDatos1();
            Statement statement = con.createStatement();
        
            statement.executeUpdate("INSERT INTO Personas(id, nombre, sexo,telefono, correo, edad, cedula_med)"
             + " values ('"+per.getCedula()+"', '"+per.getNombre()+"','"+per.getSexo()+"', "+per.getTelefono()+","
                     + " '"+per.getCorreo() +"', "+per.getEdad()+", '"+per.getCedula_med()+"')");

            con.close();
        }catch (SQLException e) {
            e.getSQLState();
        }
    }
    
    public List<Persona> getPacXMedico(String cedula_med){
        Connection con = null;
        List<Persona> pacientes = new ArrayList();
        try {
            con = ConexionMySQL.ConectarBasedeDatos1();
            CallableStatement statement = con.prepareCall("SELECT * FROM Personas WHERE Personas.cedula_med = '"+cedula_med+"'");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Persona paciente;
                paciente = new Persona(rs.getString("id"), rs.getString("nombre"), rs.getString("sexo"), rs.getString("telefono"), rs.getString("correo"), rs.getString("edad"), rs.getString("cedula_med"));
                pacientes.add(paciente);
            }
            con.close();
            return pacientes;
        } catch (SQLException e) {
            return null;
        }
    }
    
      public List<Medico> getMedicos(){
        Connection con = null;
        List<Medico> medicos = new ArrayList();
        try {
            con = ConexionMySQL.ConectarBasedeDatos1();
            CallableStatement statement = con.prepareCall("SELECT * FROM Medicos WHERE Medicos.estado = 'Inactivo'");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Medico medico;
                medico = new Medico(rs.getString("cedula"), rs.getString("nombre"), rs.getString("contrasenna"), rs.getString("especi"), rs.getString("ubicacion"), rs.getString("costo"), rs.getString("frqCitas"), rs.getString("estado"));
                medicos.add(medico);
            }
            con.close();
            return medicos;
        } catch (SQLException e) {
            return null;
        }
    }

    /*----------------------Citas----------------------*/
    
    public void insertCitas(Cita cita){
        Connection con = null;
        try{
            con = ConexionMySQL.ConectarBasedeDatos1();
            Statement statement = con.createStatement();
        
            statement.executeUpdate("INSERT INTO Citas(idPac, idMed, dia, hora, minn, estado) values('"+cita.getIdPac()+"', '"+cita.getIdMed()+"', '"+cita.getDia()+"', '"+cita.getHora()+"', '"+cita.getMinn()+"', 'Pendiente')");
            con.close();
        }catch (SQLException e) {
            e.getSQLState();
        }
    }
    
    public Cita busqCita(Cita cita){
        Connection con = null;
        Cita citaC = null;
        try {
            con = ConexionMySQL.ConectarBasedeDatos1();
            CallableStatement statement = con.prepareCall("SELECT * FROM Citas WHERE Citas.idPac = '"+cita.getIdPac()+"' AND Citas.idMed='"+cita.getIdMed()+"' AND Citas.dia='"+cita.getDia()+"' AND Citas.hora='"+cita.getHora()+"' AND Citas.minn='"+cita.getMinn()+"' AND Citas.estado='Pendiente'");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                citaC = new Cita(rs.getString("idPac"), rs.getString("idMed"), rs.getString("dia"), rs.getString("hora"), rs.getString("minn"), rs.getString("estado"));
            }
            con.close();
            return citaC;
        } catch (SQLException e) {
            return null;
        }
    }
    
    public Cita busqCitaXEstado(Cita cita){
        Connection con = null;
        Cita citaC = null;
        try {
            con = ConexionMySQL.ConectarBasedeDatos1();
            CallableStatement statement = con.prepareCall("SELECT * FROM Citas WHERE Citas.idPac = '"+cita.getIdPac()+"' AND Citas.idMed='"+cita.getIdMed()+"' AND Citas.dia='"+cita.getDia()+"' AND Citas.hora='"+cita.getHora()+"' AND Citas.minn='"+cita.getMinn()+"' AND Citas.estado='"+cita.getEstado()+"'");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                citaC = new Cita(rs.getString("idPac"), rs.getString("idMed"), rs.getString("dia"), rs.getString("hora"), rs.getString("minn"), rs.getString("estado"));
            }
            con.close();
            return citaC;
        } catch (SQLException e) {
            return null;
        }
    }
    public List<Cita> getCitasXMedico(String cedula_med){
        Connection con = null;
        List<Cita> citas = new ArrayList();
        try {
            con = ConexionMySQL.ConectarBasedeDatos1();
            CallableStatement statement = con.prepareCall("SELECT * FROM Citas WHERE Citas.idMed = '"+cedula_med+"'");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Cita cita;
                cita = new Cita(rs.getString("idPac"), rs.getString("idMed"), rs.getString("dia"), rs.getString("hora"), rs.getString("minn"), rs.getString("estado"));
                citas.add(cita);
            }
            con.close();
            return citas;
        } catch (SQLException e) {
            return null;
        }
    }
    
    public void deleteCitas(Cita cita){
        Connection con = null;
        try{
            con = ConexionMySQL.ConectarBasedeDatos1();
            Statement statement = con.createStatement();
        
            statement.executeUpdate("DELETE FROM Citas WHERE Citas.dia='"+cita.getDia()+"' AND Citas.idPac='"+cita.getIdPac()+"' AND Citas.hora='"+cita.getHora()+"' AND Citas.minn= '"+cita.getMinn()+"' AND Citas.estado='Pendiente'");
            con.close();
        }catch (SQLException e) {
            e.getSQLState();
        }
    }
    public void updateCitas(Cita cita){
        Connection con = null;
        try{
            con = ConexionMySQL.ConectarBasedeDatos1();
            Statement statement = con.createStatement();
        
            statement.executeUpdate("UPDATE Citas SET Citas.estado='Listo' WHERE Citas.dia='"+cita.getDia()+"' AND Citas.idPac='"+cita.getIdPac()+"' AND Citas.hora='"+cita.getHora()+"' AND Citas.minn= '"+cita.getMinn()+"' AND Citas.estado='"+cita.getEstado()+"'");
            con.close();
        }catch (SQLException e) {
            e.getSQLState();
        }
    }
}
