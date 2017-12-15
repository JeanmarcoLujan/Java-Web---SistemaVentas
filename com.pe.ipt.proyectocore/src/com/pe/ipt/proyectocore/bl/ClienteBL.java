/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ipt.proyectocore.bl;

import com.pe.ipt.proyectocore.be.Cliente;
import com.pe.ipt.proyectocore.dao.ClienteDAO;
import java.util.List;

/**
 *
 * @author Dikas
 */
public class ClienteBL extends BaseBL<Cliente>{

    private ClienteDAO dao = new ClienteDAO();
    
    @Override
    public Cliente insertar(Cliente e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente actualizar(Cliente e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente eliminar(Cliente e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente buscar(Cliente e) throws Exception {
        return dao.buscar(e);
    }

    @Override
    public List<Cliente> listar(Object e) throws Exception {
        return dao.listar(e);
    }
    
}
