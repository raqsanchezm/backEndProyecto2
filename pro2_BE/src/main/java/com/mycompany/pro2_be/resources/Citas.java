/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pro2_be.resources;

import com.mycompany.pro2_be.Cita;
import com.mycompany.pro2_be.Medico;
import com.mycompany.pro2_be.Service;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author gabri
 */
@Path("/citas")
public class Citas {
    @POST
    @Consumes(MediaType.APPLICATION_JSON) 
    public void create(Cita c) {  
        try {
            Service.instance().citasCREATE(c);
        } catch (Exception ex) {
            throw new NotAcceptableException(); 
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Medico> read(){
        return Service.instance().medicosREAD();
    }
    
    @GET
    @Path("/{cedula}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Cita> read(@PathParam("cedula")String cedula){
        try{
            return Service.instance().citasREAD(cedula);
        }catch (Exception ex){
            throw new NotFoundException();
        }
   
    } 
}
