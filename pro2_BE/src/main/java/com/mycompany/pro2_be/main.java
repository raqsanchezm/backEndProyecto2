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
        Cita cita = new Cita("13", "1", "Martes", "14", "30");
//        conn.insertCitas(cita);
        
        Cita cita2 = conn.busqCita(cita);
        System.out.println(cita2.toString());
        //System.out.println(horarios);
    }
}
