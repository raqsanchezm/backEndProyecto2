/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pro2_be.resources;

import com.mycompany.pro2_be.Medico;
import com.mycompany.pro2_be.Service;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Usuario
 */
@Path("/medicos")
public class Medicos {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Medico med){
        try{
            Service.instance().medicosCREATE(med);
         } catch (Exception ex){
             throw new NotAcceptableException();
         }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Medico> read(){
        return Service.instance().medicosREAD();
    }
    
    
    @GET
    @Path("{cedula}")
    @Produces({MediaType.APPLICATION_JSON})
    public Medico read(@PathParam("cedula")String cedula){
        try{
            return Service.instance().medicosREAD(cedula);
        }catch (Exception ex){
            throw new NotFoundException();
        }
   
    } 
    
    @PUT
    @Path("{cedula}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("cedula")String cedula, Medico med){
        try{
            Service.instance().medicosUPDATE(med);
        }catch(Exception ex){
            throw new NotFoundException();
        }
    }
}