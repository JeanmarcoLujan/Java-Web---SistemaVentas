/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ipt.proyectocore.bl;

import com.pe.ipt.proyectocore.be.Producto;
import com.pe.ipt.proyectocore.dao.ProductoDAO;
import java.util.List;

/**
 *
 * @author Dikas
 */
public class ProductoBL extends BaseBL<Producto>{

    private final ProductoDAO dao = new ProductoDAO();
    
    @Override
    public Producto insertar(Producto e) throws Exception {
        return dao.insertar(e);
    }

    @Override
    public Producto actualizar(Producto e) throws Exception {
        return dao.actualizar(e);
    }

    @Override
    public Producto eliminar(Producto e) throws Exception {
        return dao.eliminar(e);
    }

    @Override
    public Producto buscar(Producto e) throws Exception {
        return dao.buscar(e);
    }

    @Override
    public List<Producto> listar(Object e) throws Exception {
        return dao.listar(e);
    }
    
//    public String listarJSON(Object e) throws Exception {
//        return new Gson().toJson(dao.listar(e));
//    }
    
}
