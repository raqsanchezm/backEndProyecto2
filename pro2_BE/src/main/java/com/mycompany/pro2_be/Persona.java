package com.mycompany.pro2_be;


    public class Persona{
        String cedula;
        String nombre;
        String sexo;
        String telefono;
        String correo;
        String edad;

    
    
    public Persona(String cedula, String nombre, String sexo, String telefono, String correo, String edad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.sexo = sexo;
        this.telefono = telefono;
        this.correo = correo;
        this.edad = edad;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
  
    
    public Persona() {
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String Sexo) {
        this.sexo = Sexo;
    }
    
    
}
