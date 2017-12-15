/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ipt.proyecto.controlador;

import com.pe.ipt.proyectocore.be.Empleado;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dikas
 */
@WebServlet(name = "SecureServlet", urlPatterns = {"/SecureServlet"})
public abstract class SecureServlet extends BaseServlet {
    
    public static final String SESION_NOMBREUSUARIO = "nombreusuario";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Empleado usuario = (Empleado)getSesion(InicioSesionServlet.SESION_USUARIO, request);
        if(usuario!=null){
            String nombreusuario = usuario.getNombre()+" "+usuario.getApellido();
            request.setAttribute(SecureServlet.SESION_NOMBREUSUARIO, nombreusuario);
            processRequestSecure(request, response);
        }else{
            response.sendRedirect("InicioSesion");
        }
    }
    
    protected abstract void processRequestSecure(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
    
}
