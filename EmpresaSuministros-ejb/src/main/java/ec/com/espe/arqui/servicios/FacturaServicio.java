/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.espe.arqui.servicios;

import ec.com.espe.arqui.dao.FacturaDAO;
import ec.com.espe.arqui.exception.ValidacionException;
import ec.com.espe.arqui.modelo.Factura;
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
public class FacturaServicio {
    @EJB
    private FacturaDAO facturaDAO;
    
    public List<Factura> obtenerTodas() {
        return this.facturaDAO.findAll();
    }

    public Factura obtenerPorID(String codigoFactura) {
        return this.facturaDAO.findById(codigoFactura, false);
    }

    public void crearFactura(Factura factura) throws ValidacionException {

        this.facturaDAO.insert(factura);
        this.facturaDAO.flush();
    }

    public void actualiarFactura(Factura factura) {
        this.facturaDAO.update(factura);
    }

    public void eliminarFactura(String codigoFactura) {
        try {
            Factura facturaTmp = this.obtenerPorID(codigoFactura);
            this.facturaDAO.remove(facturaTmp);
        } catch (Exception e) {
            throw new ValidacionException("La factura " + codigoFactura + " está asociada a otra tabla");
        }
    }
    
}
