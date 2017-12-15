/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ipt.proyectocore.be;

import java.util.ArrayList;

/**
 *
 * @author Dikas
 */
public class Cliente extends Persona{
    
    private String ruc;
    private String razonSocial;
    private ArrayList<Venta> ventas;
    
    
    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(ArrayList<Venta> ventas) {
        this.ventas = ventas;
    }
        
    public Cliente(String dni, String ruc) {
        super(dni);
        this.ruc = ruc;
        ventas = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Cliente{" + "documento=" + getDocumento() + ", nombre=" + getNombre() + ", apellido=" + getApellido() + ", ruc=" + ruc + ", razonSocial=" + razonSocial + '}';
    }

    
    
    
    
}
