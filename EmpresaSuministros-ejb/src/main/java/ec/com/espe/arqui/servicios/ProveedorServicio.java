/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.espe.arqui.servicios;

import ec.com.espe.arqui.dao.ProveedorDAO;
import ec.com.espe.arqui.exception.ValidacionException;
import ec.com.espe.arqui.modelo.Proveedor;
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
public class ProveedorServicio {
    @EJB
    private ProveedorDAO proveedorDAO;
    
    public List<Proveedor> obtenerTodas() {
        return this.proveedorDAO.findAll();
    }

    public Proveedor obtenerPorID(String codigoProveedor) {
        return this.proveedorDAO.findById(codigoProveedor, false);
    }

    public void crearProveedor(Proveedor proveedor) throws ValidacionException {

        this.proveedorDAO.insert(proveedor);
        this.proveedorDAO.flush();
    }

    public void actualiarProveedor(Proveedor proveedor) {
        this.proveedorDAO.update(proveedor);
    }

    public void eliminarProveedor(String codigoProveedor) {
        try {
            Proveedor proveedorTmp = this.obtenerPorID(codigoProveedor);
            this.proveedorDAO.remove(proveedorTmp);
        } catch (Exception e) {
            throw new ValidacionException("El proveedor " + codigoProveedor + " está asociado a otra tabla");
        }
    }
}
