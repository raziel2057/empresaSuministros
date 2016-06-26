/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.espe.arqui.webServices;

import ec.com.espe.arqui.modelo.DetalleFactura;
import ec.com.espe.arqui.modelo.Factura;
import ec.com.espe.arqui.modelo.Producto;
import ec.com.espe.arqui.servicios.DetalleFacturaServicio;
import ec.com.espe.arqui.servicios.FacturaServicio;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author rdne1
 */
@Path("factura")
@RequestScoped
public class GenerarFacturaRestFul {

    @EJB
    private FacturaServicio facturaServicio;
    
    @EJB
    private DetalleFacturaServicio detalleFacturaServicio;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenerarFactura
     */
    public GenerarFacturaRestFul() {
    }

    @POST
    //@Produces({"application/xml", "application/json"})
    @Consumes({"application/json"})
    @Path("create/")
    public String consultaPOST(final MyJaxBean input){
        
        try
        {
            System.out.println("cosigo cliente: "+input.codigoCliente);
            BigDecimal totalFactura = BigDecimal.valueOf(0);

            for(DetalleFactura det : input.detalleFactura)
            {
                totalFactura = totalFactura.add(det.getCostoTotal());
                System.out.println(det.getProducto().getDescripcion());
            }

            Factura factura = new Factura();
            factura.setCodigo("");
            factura.setCodigoCliente(input.codigoCliente);
            factura.setFecha(new Date());
            factura.setTotal(totalFactura);

            this.facturaServicio.crearFactura(factura);

            List<Factura> facturas = this.facturaServicio.obtenerTodas();


            for(int i=0;i<input.detalleFactura.size();i++)
            {
               input.detalleFactura.get(i).setCodigoFactura(facturas.get(facturas.size()-1).getCodigo());
               detalleFacturaServicio.crearDetalle(input.detalleFactura.get(i));
            }
            
            return "Si";
        }
        catch(Exception e)
        {
            return "No";
        }
        
    }
}
