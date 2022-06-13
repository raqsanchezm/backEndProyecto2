/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pro2_be.resources;

import com.mycompany.pro2_be.Medico;
import com.mycompany.pro2_be.Service;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 *
 * @author Usuario
 */
@Path("/medicos")
public class Medicos {
    String location="C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Proyecto2\\Proyecto2\\src\\main\\webapp\\pics\\";
    
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
    
    @GET
    @Path("{cedula}/imagen")
    @Produces("image/jpg") 
    public Response getImage(@PathParam("cedula") String cedula) throws IOException{
        File file = new File(location+cedula);
        Response.ResponseBuilder response = Response.ok((Object) file);
        return response.build();
    }
    
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("{cedula}/imagen")
    public void addImage(@PathParam("cedula") String cedula, @FormDataParam("imagen") InputStream in){
        try{
            OutputStream out = new FileOutputStream(new File(location+cedula));
            in.transferTo(out);
            out.close();
        }catch(Exception ex){
            throw new NotAcceptableException();
        }       
    }
}
