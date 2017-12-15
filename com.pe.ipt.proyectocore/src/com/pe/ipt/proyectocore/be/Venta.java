/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ipt.proyectocore.be;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Dikas
 */
public abstract class Venta implements DocumentoVenta{
    
    protected String numero;
    protected BigDecimal total;
    protected Cliente cliente;
    protected Empleado vendedor;
    protected LocalDate fecha;
    protected ArrayList<DetalleVentaProducto> detalle;

    public Venta() {
        detalle = new ArrayList<>();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    public Empleado getVendedor() {
        return vendedor;
    }

    public void setVendedor(Empleado vendedor) {
        this.vendedor = vendedor;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<DetalleVentaProducto> getDetalle() {
        return detalle;
    }

    public void setDetalle(ArrayList<DetalleVentaProducto> detalle) {
        this.detalle = detalle;
    }
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    
    @Override
    public void calcularTotal() {
        this.total = BigDecimal.ZERO;
               
        this.detalle.forEach((d) -> {
            this.total = this.total.add(d.getPrecioTotal());
        });
    }
    
        
    public static class DetalleVentaProducto{
    
        private BigDecimal cantidad;
        private BigDecimal precioTotal;
        private Producto producto;

        public Producto getProducto() {
            return producto;
        }

        public void setProducto(Producto producto) {
            this.producto = producto;
        }
        
        public BigDecimal getCantidad() {
            return cantidad;
        }

        public void setCantidad(BigDecimal cantidad) {
            this.cantidad = cantidad;
        }

        public BigDecimal getPrecioTotal() {
            return precioTotal;
        }

        public void setPrecioTotal(BigDecimal precioTotal) {
            this.precioTotal = precioTotal;
        }
        
        public void calcularPrecioTotal(){
            this.precioTotal = this.cantidad.multiply(this.producto.getPrecioUnitario());
        }
        
        
    }
    
    
}
