/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ipt.proyecto.controlador;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dikas
 */
public class RptProductosRPTServlet extends ReportServlet {

    @Override
    protected void processRequestSecure(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String filtro = request.getParameter("filtro");
        Boolean estado = Boolean.parseBoolean(request.getParameter("estado"));

        String reporte = "RptProductos";
        Map parameters = new HashMap();
        parameters.put("pNombreProducto", filtro);
        parameters.put("pEstadoProducto", estado);

        try {
            ExportarPDF(reporte, parameters, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
