/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ipt.proyecto.controlador;

import com.pe.ipt.proyecto.modelo.ListaClientesModel;
import com.pe.ipt.proyectocore.be.Cliente;
import com.pe.ipt.proyectocore.bl.ClienteBL;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dikas
 */
public class ListaClientesServlet extends SecureServlet {

    @Override
    protected void processRequestSecure(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        ListaClientesModel modelo = new ListaClientesModel();
        
        ClienteBL bl = new ClienteBL();
        try {
            List<Cliente> data = bl.listar(null);
            modelo.setData(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        request.setAttribute("modelo", modelo);
       
        vista("ListaClientes", request, response);
        
    }

}
