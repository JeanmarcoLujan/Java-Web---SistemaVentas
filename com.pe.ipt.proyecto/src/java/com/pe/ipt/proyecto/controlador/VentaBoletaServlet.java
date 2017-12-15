/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ipt.proyecto.controlador;

import com.pe.ipt.proyecto.modelo.VentaBoletaModel;
import com.pe.ipt.proyectocore.be.Boleta;
import com.pe.ipt.proyectocore.be.Cliente;
import com.pe.ipt.proyectocore.be.Empleado;
import com.pe.ipt.proyectocore.be.Producto;
import com.pe.ipt.proyectocore.bl.BoletaBL;
import com.pe.ipt.proyectocore.bl.ClienteBL;
import com.pe.ipt.proyectocore.bl.ProductoBL;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dikas
 */
public class VentaBoletaServlet extends SecureServlet {
    
    private List<Cliente> clientes;
    private List<Producto> productos;
    private VentaBoletaModel modelo = new VentaBoletaModel();
    
    @Override
    protected void processRequestSecure(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        if(request.getParameter("estado")!=null){
            if(request.getParameter("estado").compareTo("ini")==0){
                modelo = new VentaBoletaModel();
            }
        }
        
        try {
            if(clientes==null){
                ClienteBL clienteBl = new ClienteBL();
                clientes = clienteBl.listar(null);
            }
            if(productos==null){
                ProductoBL productoBl = new ProductoBL();
                productos = productoBl.listar(null);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        modelo.setClientes(clientes);
        modelo.setProductos(productos);
        
        
        if(request.getParameter("btnAgregar")!=null){
            String numero = request.getParameter("txtNumero");
            String cliente = request.getParameter("cmbCliente");
                        
            String producto = request.getParameter("cmbProducto");
            String cantidad = request.getParameter("txtCantidad");
            
            modelo.setNumero(numero);
            modelo.setCliente(cliente);
            /*
            modelo.setProducto(producto);
            modelo.setCantidad(cantidad);
            */
            Boleta.DetalleVentaProducto item = new Boleta.DetalleVentaProducto();
            item.setCantidad(new BigDecimal(cantidad));
            Producto p = new Producto();
            p.setCodigo(Integer.parseInt(producto));
            try {
                ProductoBL productoBl = new ProductoBL();
                p = productoBl.buscar(p);
            } catch (Exception e) {
                e.printStackTrace();
            }
            item.setProducto(p);
            item.calcularPrecioTotal();
            
            modelo.getDetalle().add(item);
            
            Boleta b =  new Boleta();
            b.setDetalle(modelo.getDetalle());
            b.calcularTotal();
            modelo.setTotal(b.getTotal().toString());

            
        }else if(request.getParameter("btnGrabar")!=null){
            Boleta b = new Boleta();
            
            String numero = request.getParameter("txtNumero");
            String dni = request.getParameter("cmbCliente");
            
            Cliente cliente = new Cliente(dni, "");
            
            try {
                ClienteBL clientebl = new ClienteBL();
                cliente = clientebl.buscar(cliente);
            } catch (Exception e) {
            }
            
            Empleado empleado = (Empleado) getSesion(InicioSesionServlet.SESION_USUARIO, request);
            
            b.setNumero(numero);
            b.setFecha(LocalDate.now());
            b.setCliente(cliente);
            b.setVendedor(empleado);
            b.setDetalle(modelo.getDetalle());
            b.calcularTotal();
            
            BoletaBL boletabl = new BoletaBL();
            try {
                boletabl.insertar(b);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            
        }
        
        
        request.setAttribute("modelo", modelo);
        vista("VentaBoleta", request, response);
    }

 
}
