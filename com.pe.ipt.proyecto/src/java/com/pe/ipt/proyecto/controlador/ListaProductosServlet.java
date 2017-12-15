/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ipt.proyecto.controlador;

import com.pe.ipt.proyecto.modelo.ListaProductosModel;
import com.pe.ipt.proyectocore.bl.ProductoBL;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dikas
 */
public class ListaProductosServlet extends SecureServlet {

    @Override
    protected void processRequestSecure(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        ListaProductosModel modelo = new ListaProductosModel();
        try {
            modelo.setData(new ProductoBL().listar(null));
        } catch (Exception e) {
        }
        request.setAttribute("modelo", modelo);
        vista("ListaProductos", request, response);
    }

    
}
