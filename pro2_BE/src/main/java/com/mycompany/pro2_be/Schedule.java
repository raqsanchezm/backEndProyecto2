/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pro2_be;

/**
 *
 * @author Usuario
 */
public class Schedule {
    public String dia;
    public int horaIni;
    public int horaFin;

    public Schedule(String dia, int horaI, int horaF) {
        this.dia = dia;
        this.horaIni = horaI;
        this.horaFin = horaF;
    }

    public Schedule() {
    }

    public String getDia() {
        return dia;
    }

    public int getHoraIni() {
        return horaIni;
    }

    public int getHoraFin() {
        return horaFin;
    }
    
}
