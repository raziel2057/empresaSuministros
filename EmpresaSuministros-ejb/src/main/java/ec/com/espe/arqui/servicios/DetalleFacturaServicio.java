/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.espe.arqui.servicios;

import ec.com.espe.arqui.dao.DetalleFacturaDAO;
import ec.com.espe.arqui.exception.ValidacionException;
import ec.com.espe.arqui.modelo.DetalleFactura;
import ec.com.espe.arqui.modelo.DetalleFacturaPK;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author rdne1
 */
@LocalBean
@Stateless
public class DetalleFacturaServicio {
    @EJB
    private DetalleFacturaDAO detalleFacturaDAO;
    
    public List<DetalleFactura> obtenerTodas() {
        return this.detalleFacturaDAO.findAll();
    }

    public DetalleFactura obtenerPorID(DetalleFacturaPK codigoDetalle) {
        return this.detalleFacturaDAO.findById(codigoDetalle, false);
    }

    public void crearDetalle(DetalleFactura detalleFactura) throws ValidacionException {

        this.detalleFacturaDAO.insert(detalleFactura);
        //this.detalleFacturaDAO.flush();
    }

    public void actualiarDetalle(DetalleFactura detalleFactura) {
        this.detalleFacturaDAO.update(detalleFactura);
    }

    public void eliminarDetalle(DetalleFacturaPK codigoDetalle) {
        try {
            DetalleFactura detalleFacturaTmp = this.obtenerPorID(codigoDetalle);
            this.detalleFacturaDAO.remove(detalleFacturaTmp);
        } catch (Exception e) {
            throw new ValidacionException("El detalle está asociado a otra tabla");
        }
    }
}
