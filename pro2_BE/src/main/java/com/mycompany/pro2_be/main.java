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
//        List<Cita> citas = conn.getCitasXMedico("1");
//        System.out.println(citas.toString());
        Cita cita = new Cita("11", "1", "Jueves", "9", "30", "Pendiente", "Se atencio la consulta");
        System.out.println(conn.getCitasXPacientes("14").toString());
        
        
        //System.out.println(horarios);
    }
}
