/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pro2_be;

import java.util.List;

/**
 *
 * @author gabri
 */
public class main {
    public static void main(String[] args) {
        ConexionBD conn = new ConexionBD();
        Medico med = conn.busqMedicoId("12", "12");
        System.out.println(med.toString());
        System.out.println(med.getHorario().toString());
        //System.out.println(horarios);
    }
}
