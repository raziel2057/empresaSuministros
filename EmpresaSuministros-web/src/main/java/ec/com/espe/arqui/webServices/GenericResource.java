/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.espe.arqui.webServices;

import ec.com.espe.arqui.modelo.Cliente;
import ec.com.espe.arqui.modelo.Producto;
import ec.com.espe.arqui.servicios.ClienteServicio;
import ec.com.espe.arqui.servicios.ProductoServicio;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author rdne1
 */
@Path("generic")
@RequestScoped
public class GenericResource {
    
    @EJB
    private ClienteServicio clienteServicio;
    
    @EJB
    private ProductoServicio productoServicio;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of ec.com.espe.arqui.webServices.GenericResource
     * @param cadenaB
     * @return an instance of java.lang.String
     */
    @Path("{cadenaB}")
    @GET
    @Produces({"application/xml", "application/json"})
    public List<Producto> getJson( @PathParam("cadenaB") String cadenaB) {
        //TODO return proper representation object
        List<Producto> productosEncontrados = new ArrayList<>();
        
        List<Producto> productos = productoServicio.obtenerTodas();
        
        System.out.println("cadena "+cadenaB);
        for(Producto prod: productos)
        {
            if(prod.getDescripcion().contains(cadenaB.toUpperCase()))
            {
                productosEncontrados.add(prod);
            }
        }
        
        return productosEncontrados;
    }
    
    @POST
    @Consumes({"application/json"})
    @Path("create/")
    public void create(String param1){
        System.out.println("param1 = " + param1);
        
    }

    /*@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente getJsonFirst() {
        //TODO return proper representation object
        return clienteServicio.obtenerTodas().get(0);
    }*/

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
