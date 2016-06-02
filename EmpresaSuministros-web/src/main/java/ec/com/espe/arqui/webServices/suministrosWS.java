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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author rdne1
 */
@WebService(serviceName = "suministrosWS")
@ViewScoped
@ManagedBean
public class suministrosWS {

    @EJB
    private ClienteServicio clienteServicio;
    @EJB
    private ProductoServicio productoServicio;
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "registrarAlumno")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtenerListadoClientes")
    public List<Cliente> obtenerListadoClientes() {
        //TODO write your implementation code here:
        return clienteServicio.obtenerTodas();
    }
    
    @WebMethod(operationName = "busquedaProductos")
    public List<Producto> busquedaProductos(@WebParam(name = "cadenaB") String cadenaB) {
        //TODO write your implementation code here:
        List<Producto> productosEncontrados = new ArrayList<>();
        
        List<Producto> productos = productoServicio.obtenerTodas();
        
        
        for(Producto prod: productos)
        {
            if(prod.getDescripcion().contains(cadenaB.toUpperCase()))
            {
                productosEncontrados.add(prod);
            }
        }
        
        return productosEncontrados;
    }
    
}
