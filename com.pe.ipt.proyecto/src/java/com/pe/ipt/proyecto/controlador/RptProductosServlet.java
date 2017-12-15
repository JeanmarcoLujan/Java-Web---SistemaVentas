/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ipt.proyecto.controlador;

import com.pe.ipt.proyecto.modelo.RptProductosModel;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dikas
 */
public class RptProductosServlet extends SecureServlet {

    @Override
    protected void processRequestSecure(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        RptProductosModel modelo = new RptProductosModel();
        request.setAttribute("modelo", modelo);
        
        if(request.getParameter("btnMostrar")!=null){
            String filtro = request.getParameter("txtFiltro");
            Boolean estado = request.getParameter("chkEstado")==null?false:true;
            
            modelo.setFiltro(filtro);
            modelo.setEstado(estado);
            modelo.setMostrar(true);
        }
        
        vista("RptProductos", request, response);
        
    }

    
  
}
