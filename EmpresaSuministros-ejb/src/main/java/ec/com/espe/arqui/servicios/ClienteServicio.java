/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.espe.arqui.servicios;

import ec.com.espe.arqui.dao.ClienteDAO;
import ec.com.espe.arqui.exception.ValidacionException;
import ec.com.espe.arqui.modelo.Cliente;
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
public class ClienteServicio {
    @EJB
    private ClienteDAO clienteDAO;
    


    public List<Cliente> obtenerTodas() {
        return this.clienteDAO.findAll();
    }

    public Cliente obtenerPorID(String codigoCliente) {
        return this.clienteDAO.findById(codigoCliente, false);
    }

    public void crearCliente(Cliente cliente) throws ValidacionException {

        this.clienteDAO.insert(cliente);
        this.clienteDAO.flush();
    }

    public void actualiarCliente(Cliente cliente) {
        this.clienteDAO.update(cliente);
    }

    public void eliminarCliente(String codigoCliente) {
        try {
            Cliente clienteTmp = this.obtenerPorID(codigoCliente);
            this.clienteDAO.remove(clienteTmp);
        } catch (Exception e) {
            throw new ValidacionException("El cliente " + codigoCliente + " está asociado a otra tabla");
        }
    }
}
