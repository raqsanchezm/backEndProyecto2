/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pro2_be;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Medico {
    String cedula;
    String nombre;
    String password;
    String especi;
    String ubicacion;
    String costo;
    List<Schedule> horario;
    String frqCitas;
    String estado;

    public Medico(String cedula, String nombre, String password, String especi, String ubicacion, String costo, String frqCitas, String estado) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.password = password;
        this.especi = especi;
        this.ubicacion = ubicacion;
        this.costo = costo;
        this.frqCitas = frqCitas;
        this.estado = estado;
    }

    
    
    
    
    public Medico() {
    }

    public Medico(String cedula, String nombre, String password, String especi, String ubicacion, String costo, List<Schedule> horario, String frqCitas, String estado) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.password = password;
        this.especi = especi;
        this.ubicacion = ubicacion;
        this.costo = costo;
        this.horario = horario;
        this.frqCitas = frqCitas;
        this.estado = estado;
    }   

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEspeci() {
        return especi;
    }

    public void setEspeci(String especi) {
        this.especi = especi;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getFrqCitas() {
        return frqCitas;
    }

    public void setFrqCitas(String frqCitas) {
        this.frqCitas = frqCitas;
    }

    public List<Schedule> getHorario() {
        return horario;
    }

    public void setHorario(List<Schedule> horario) {
        this.horario = horario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Medico{" + "cedula=" + cedula + ", nombre=" + nombre + ", password=" + password + ", especi=" + especi + ", ubicacion=" + ubicacion + ", costo=" + costo + ", horario=" + horario + ", frqCitas=" + frqCitas + ", estado=" + estado + '}';
    }
    
}
