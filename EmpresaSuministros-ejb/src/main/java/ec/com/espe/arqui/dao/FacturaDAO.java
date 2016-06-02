/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.espe.arqui.dao;

import ec.com.espe.arqui.common.dao.DefaultGenericDAOImple;
import ec.com.espe.arqui.modelo.Factura;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author rdne1
 */
@LocalBean
@Stateless 
public class FacturaDAO extends DefaultGenericDAOImple<Factura, String> {
    public FacturaDAO() {
        super(Factura.class);
    }
}
