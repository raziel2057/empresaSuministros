/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.espe.arqui.webServices;

import ec.com.espe.arqui.modelo.Cliente;
import ec.com.espe.arqui.modelo.DetalleFactura;
import ec.com.espe.arqui.modelo.Factura;
import ec.com.espe.arqui.servicios.DetalleFacturaServicio;
import ec.com.espe.arqui.servicios.FacturaServicio;
import java.math.BigDecimal;
import java.util.Date;
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
@WebService(serviceName = "facturaWS")
@ViewScoped
@ManagedBean
public class facturaWS {

    @EJB
    private FacturaServicio facturaServicio;
    
    @EJB
    private DetalleFacturaServicio detalleFacturaServicio;
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "guardarFactura")
    public Boolean guardarFactura(@WebParam(name = "codigoCliente") String codigoCliente, @WebParam(name = "detalleFactura") List<DetalleFactura> detalleFactura) {
        
        try
        {
            BigDecimal totalFactura = BigDecimal.valueOf(0);

            for(DetalleFactura det : detalleFactura)
            {
                totalFactura = totalFactura.add(det.getCostoTotal());
            }

            Factura factura = new Factura();
            factura.setCodigo("");
            factura.setCodigoCliente(codigoCliente);
            factura.setFecha(new Date());
            factura.setTotal(totalFactura);

            this.facturaServicio.crearFactura(factura);

            List<Factura> facturas = this.facturaServicio.obtenerTodas();


            for(int i=0;i<detalleFactura.size();i++)
            {
               detalleFactura.get(i).setCodigoFactura(facturas.get(facturas.size()-1).getCodigo());
               detalleFacturaServicio.crearDetalle(detalleFactura.get(i));
            }
            
            return true;
        }
        catch(Exception e)
        {
            return false;
        }

       
    }
}
