/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ipt.proyecto.controlador;

import com.pe.ipt.proyecto.modelo.InicioSesionModel;
import com.pe.ipt.proyectocore.be.Empleado;
import com.pe.ipt.proyectocore.bl.EmpleadoBL;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dikas
 */
public class InicioSesionServlet extends BaseServlet{

    public static final String SESION_USUARIO = "usuario";
    
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InicioSesionModel modelo = new InicioSesionModel();
        request.setAttribute("modelo", modelo);
        boolean acceso = false;
        
        if(request.getParameter("btnIniciar")!=null){
            String codigo = request.getParameter("txtCodigo");
            String clave = request.getParameter("txtClave");
            String mensaje = "";
            Empleado usuario = null;
            try {
                usuario = new EmpleadoBL().buscar(Integer.parseInt(codigo), clave);            
            } catch (Exception e) {
                e.printStackTrace();
            }
            acceso = usuario!=null;
            if(acceso)
            {
                setSesion(InicioSesionServlet.SESION_USUARIO, usuario, request);
                String nombreUsuario = usuario.getNombre() + " " + usuario.getApellido();
            }else{
                mensaje="Error en las credenciales";
            }
            
            modelo.setCodigo(codigo);
            modelo.setClave("");
            modelo.setMensaje(mensaje);
            
            request.setAttribute("modelo", modelo);    
            
        }
        
        if(acceso){
            response.sendRedirect("Home");
        }
        else{
            vista("InicioSesion", request, response);
        }
    }

}
