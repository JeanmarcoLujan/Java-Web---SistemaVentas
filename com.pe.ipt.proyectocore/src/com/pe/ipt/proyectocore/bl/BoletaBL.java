/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ipt.proyectocore.bl;

import com.pe.ipt.proyectocore.be.Venta;
import com.pe.ipt.proyectocore.dao.BoletaDAO;
import java.util.List;

/**
 *
 * @author Dikas
 */
public class BoletaBL extends BaseBL<Venta>{

    private BoletaDAO dao = new BoletaDAO();
    
    @Override
    public Venta insertar(Venta e) throws Exception {
        return dao.insertar(e);
    }

    @Override
    public Venta actualizar(Venta e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Venta eliminar(Venta e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Venta buscar(Venta e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Venta> listar(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
