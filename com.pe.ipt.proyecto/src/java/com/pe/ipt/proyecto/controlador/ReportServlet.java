/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ipt.proyecto.controlador;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 *
 * @author Dikas
 */
@WebServlet(name = "ReportServlet", urlPatterns = {"/ReportServlet"})
public abstract class ReportServlet extends SecureServlet {

    private Connection obtenerConexion() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        return (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ipt_ventas", "root", "");
    }
    
    protected void ExportarPDF(String nombreReporte, Map parameters, HttpServletResponse response) throws Exception{
    
        try (ServletOutputStream outStream = response.getOutputStream()) {
            
            String reportFile = this.getServletContext().getRealPath("/WEB-INF/rpt/"+nombreReporte+".jasper");
            byte[] bytes = JasperRunManager.runReportToPdf(reportFile, parameters,obtenerConexion());
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            outStream.write(bytes, 0, bytes.length);
            outStream.flush();
        }
    
    }
    
    
    
}
