package com.mycompany.pro2_be.resources;

import com.mycompany.pro2_be.Antecedente;
import com.mycompany.pro2_be.Persona;
import com.mycompany.pro2_be.Service;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.ws.rs.DELETE;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/personas")
public class Personas {
    String location="D:\\Pictures\\ImagenesProyecto";
    String docs="D:\\Pictures\\ImagenesProyecto";
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON) 
    public void create(Persona p) {  
        try {
            Service.instance().personasCREATE(p);
        } catch (Exception ex) {
            throw new NotAcceptableException(); 
        }
    }
    
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA) 
    @Path("{cedula}/imagen")
    public void addImage(@PathParam("cedula") String cedula, @FormDataParam("imagen") InputStream in) {  
        try{
                OutputStream out = new FileOutputStream(new File(location + cedula));
                in.transferTo(out);
                out.close();
            } catch (Exception ex) {
                throw new NotAcceptableException(); 
            }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> read() { 
        return Service.instance().personasREAD();
    }     
    
    /*@GET
    @Path("{cedula}")
    @Produces({MediaType.APPLICATION_JSON})
    public Persona read(@PathParam("cedula_med") String cedula_med) {
        try {
            return Service.instance().personasREAD(cedula_med);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }*/
    
    @GET
    @Path("/{cedula_med}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Persona> read(@PathParam("cedula_med") String cedula_med) {
        try {
            return Service.instance().personasMedicosREAD(cedula_med);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }

    @GET
    @Path("{cedula}/imagen")
    @Produces("image/png")
    public Response getImge(@PathParam("cedula") String cedula) throws IOException {
        File file = new File(location+cedula);
        Response.ResponseBuilder response = Response.ok((Object) file);
        return response.build();
    }   
    
    @PUT
    @Path("{cedula}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("cedula") String cedula, Persona p) {  
        try {
            Service.instance().personasUPDATE(p);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }

    @DELETE
    @Path("{cedula}")
    public void delete(@PathParam("cedula") String cedula) {
        try {
            Service.instance().personasDELETE(cedula);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }

    @GET
    @Path("/{nombre}/busqueda")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> busqNombre(@PathParam("nombre") String nombre) {
        try {
            return Service.instance().personaBusqN(nombre);
        } catch (Exception ex) {
            throw new NotFoundException();
        }
    }
 

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("{cedula}/pdf")
    public void addPdf(@PathParam("cedula") String cedula, @FormDataParam("pdf") InputStream in) {
        try{
                OutputStream out = new FileOutputStream(new File(docs + cedula));
                in.transferTo(out);
                out.close();
            } catch (Exception ex) {
                throw new NotAcceptableException();
            }
    }


    @GET
    @Path("{cedula}/pdf")
    @Produces("application/pdf")
    public Response getPdf(@PathParam("cedula") String cedula) throws IOException {
        File file = new File(docs+cedula);
        Response.ResponseBuilder response = Response.ok((Object) file);
        return response.build();
    }    


    @GET
    @Path("{id}/antecedentes")
    @Produces({MediaType.APPLICATION_JSON})
    public Antecedente getAnte(@PathParam("id") String id) throws IOException {
        try{
            return Service.instance().anteREAD(id);
        }catch (Exception ex){
            throw new NotFoundException();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}/antecedentes")
    public void createAnte(Antecedente p) {
        try {
            Service.instance().anteCREATE(p);
        } catch (Exception ex) {
            throw new NotAcceptableException();
        }
    }
    
  
}
