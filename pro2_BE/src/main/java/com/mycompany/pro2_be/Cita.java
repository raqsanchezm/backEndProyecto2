/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pro2_be;

/**
 *
 * @author gabri
 */
public class Cita {
    public String idPac;
    public String idMed;
    public String dia;
    public String hora;
    public String minn;

    public Cita(String idPac, String idMed, String dia, String hora, String minn) {
        this.idPac = idPac;
        this.idMed = idMed;
        this.dia = dia;
        this.hora = hora;
        this.minn = minn;
    }

    public Cita() {
    }
    
    

    public String getIdPac() {
        return idPac;
    }

    public void setIdPac(String idPac) {
        this.idPac = idPac;
    }

    public String getIdMed() {
        return idMed;
    }

    public void setIdMed(String idMed) {
        this.idMed = idMed;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMinn() {
        return minn;
    }

    public void setMinn(String minn) {
        this.minn = minn;
    }

    @Override
    public String toString() {
        return "Cita{" + "idPac=" + idPac + ", idMed=" + idMed + ", dia=" + dia + ", hora=" + hora + ", minn=" + minn + '}';
    }
    
}
