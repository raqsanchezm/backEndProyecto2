/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pro2_be;

/**
 *
 * @author gabri
 */
public class main {
    public static void main(String[] args) {
        Medico med = new Medico();
        med.setCedula("118280548");
        med.setNombre("Gabriel");
        med.setPassword("hola23");
        med.setEspeci("General");
        med.setUbicacion("San Jose");
        med.setCosto("25000");
        med.setFrqCitas("15");
        System.out.println(med.toString());
        ConexionBD conn = new ConexionBD();
        conn.insertMed(med);
    }
}
