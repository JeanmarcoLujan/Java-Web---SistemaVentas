/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ipt.proyecto.modelo;

import com.pe.ipt.proyectocore.be.Boleta;
import com.pe.ipt.proyectocore.be.Cliente;
import com.pe.ipt.proyectocore.be.Producto;
import com.pe.ipt.proyectocore.be.Venta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dikas
 */
public class VentaBoletaModel {
    
    private String numero;
    private String cliente;
    private List<Cliente> clientes;
    private String total;
    private String producto;
    private List<Producto> productos;
    private String cantidad;
    private ArrayList<Boleta.DetalleVentaProducto> detalle;
    
    public VentaBoletaModel() {
        numero = "";
        cliente = "";
        clientes = new ArrayList<>();
        total = "0";
        producto = "";
        productos = new ArrayList<>();
        cantidad = "1";
        detalle = new ArrayList<>();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public ArrayList<Venta.DetalleVentaProducto> getDetalle() {
        return detalle;
    }

    public void setDetalle(ArrayList<Venta.DetalleVentaProducto> detalle) {
        this.detalle = detalle;
    }
    
}
