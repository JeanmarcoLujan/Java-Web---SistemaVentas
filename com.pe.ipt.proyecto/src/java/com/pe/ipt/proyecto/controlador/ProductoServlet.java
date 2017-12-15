/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ipt.proyecto.controlador;

import com.pe.ipt.proyecto.modelo.ProductoModel;
import com.pe.ipt.proyectocore.be.Producto;
import com.pe.ipt.proyectocore.bl.ProductoBL;
import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dikas
 */
public class ProductoServlet extends SecureServlet {

    @Override
    protected void processRequestSecure(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductoModel modelo = new ProductoModel();
        request.setAttribute("modelo", modelo);
        
        String operacion = null;
        String id = null;
        
        try {
            operacion = request.getParameter("ope");
            if(operacion==null){
                operacion = request.getParameter("operacion");
            }
            id = request.getParameter("id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        modelo.setOperacion(operacion);
        
        if(operacion.compareTo("new")==0){
            if(request.getParameter("btnGrabar")==null){
                vista("Producto", request, response);
            }
            else{
                String nombre = request.getParameter("txtNombre");
                String unidad = request.getParameter("txtUnidad");
                String precio = request.getParameter("txtPrecio");
                
                Producto p = new Producto();
                p.setNombre(nombre);
                p.setUnidad(unidad);
                p.setPrecioUnitario(new BigDecimal(precio));
                
                ProductoBL bl = new ProductoBL();
                
                try {
                    bl.insertar(p);
                    response.sendRedirect("ListaProductos");
                } catch (Exception e) {
                    
                }
            }
        }else if (operacion.compareTo("upd")==0){
            if(request.getParameter("btnGrabar")==null){
                
                Producto p = new Producto();
                p.setCodigo(Integer.parseInt(id));
                
                ProductoBL bl = new ProductoBL();
                try {
                    p = bl.buscar(p);
                    
                    modelo.setCodigo(p.getCodigo().toString());
                    modelo.setNombre(p.getNombre());
                    modelo.setUnidad(p.getUnidad());
                    modelo.setPrecio(p.getPrecioUnitario().toString());
                    
                    request.setAttribute("modelo",modelo);
                    
                    vista("Producto", request, response);
                    
                } catch (Exception e) {
                }
            }
            else{
                String codigo = request.getParameter("txtCodigo");
                String nombre = request.getParameter("txtNombre");
                String unidad = request.getParameter("txtUnidad");
                String precio = request.getParameter("txtPrecio");
                
                Producto p = new Producto();
                p.setCodigo(Integer.parseInt(codigo));
                p.setNombre(nombre);
                p.setUnidad(unidad);
                p.setPrecioUnitario(new BigDecimal(precio));
                
                ProductoBL bl = new ProductoBL();
                
                try {
                    bl.actualizar(p);
                    response.sendRedirect("ListaProductos");
                } catch (Exception e) {
                    
                }
            }
        }else if (operacion.compareTo("del")==0){
            
            Producto p = new Producto();
            p.setCodigo(Integer.parseInt(id));
            
            ProductoBL bl = new ProductoBL();
            
            try {
                bl.eliminar(p);
                response.sendRedirect("ListaProductos");
            } catch (Exception e) {
            }
            
        }
        
        /*
        Producto producto = null;
        ProductoBL bl = new ProductoBL();
        
        if(request.getParameter("btnGrabar")!=null){
            String nombre = request.getParameter("txtNombre");
            String unidad = request.getParameter("txtUnidad");
            String precio = request.getParameter("txtPrecio");
            if(operacion.compareTo("new")==0){
                try {
                    producto = new Producto();
                    producto.setNombre(nombre);
                    producto.setUnidad(unidad);
                    producto.setPrecioUnitario(new BigDecimal(precio));
                    bl.insertar(producto);
                    response.sendRedirect("ListaProductos");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if(operacion.compareTo("upd")==0){
                try {
                    String codigo = request.getParameter("txtCodigo");
                    producto = new Producto();
                    producto.setCodigo(Integer.parseInt(codigo));
                    producto.setNombre(nombre);
                    producto.setUnidad(unidad);
                    producto.setPrecioUnitario(new BigDecimal(precio));
                    bl.actualizar(producto);
                    response.sendRedirect("ListaProductos");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else{
            producto = new Producto();
            if(operacion.compareTo("del")==0){
                try {
                    producto.setCodigo(Integer.parseInt(id));
                    producto = bl.eliminar(producto);
                    response.sendRedirect("ListaProductos");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if(operacion.compareTo("upd")==0){
                try {
                    producto.setCodigo(Integer.parseInt(id));
                    producto = bl.buscar(producto);
                    modelo.setCodigo(producto.getCodigo().toString());
                    modelo.setNombre(producto.getNombre());
                    modelo.setUnidad(producto.getUnidad());
                    modelo.setPrecio(producto.getPrecioUnitario().toString());
                    request.setAttribute("modelo", modelo);
                    vista("Producto", request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                vista("Producto", request, response);
            }
            
        }*/
        
    }

}
