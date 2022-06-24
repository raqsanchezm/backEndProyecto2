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
        List<Persona> pacientes = conn.getPacXMedico("1");
        System.out.println(pacientes.toString());
        Cita cita = new Cita("11", "1", "Jueves", "9", "0");
        conn.insertCitas(cita);
        
        
        //System.out.println(horarios);
    }
}
