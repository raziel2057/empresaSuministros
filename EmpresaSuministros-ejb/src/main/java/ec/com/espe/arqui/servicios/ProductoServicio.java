/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.espe.arqui.servicios;

import ec.com.espe.arqui.dao.ProductoDAO;
import ec.com.espe.arqui.exception.ValidacionException;
import ec.com.espe.arqui.modelo.Producto;
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
public class ProductoServicio {
    @EJB
    private ProductoDAO productoDAO;
    
    public List<Producto> obtenerTodas() {
        return this.productoDAO.findAll();
    }

    public Producto obtenerPorID(String codigoProducto) {
        return this.productoDAO.findById(codigoProducto, false);
    }

    public void crearProducto(Producto producto) throws ValidacionException {

        this.productoDAO.insert(producto);
        this.productoDAO.flush();
    }

    public void actualiarProducto(Producto producto) {
        this.productoDAO.update(producto);
    }

    public void eliminarProducto(String codigoProducto) {
        try {
            Producto productoTmp = this.obtenerPorID(codigoProducto);
            this.productoDAO.remove(productoTmp);
        } catch (Exception e) {
            throw new ValidacionException("El producto " + codigoProducto + " está asociado a otra tabla");
        }
    }
}
