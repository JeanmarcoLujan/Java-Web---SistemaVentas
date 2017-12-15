/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ipt.proyecto.modelo;

import com.pe.ipt.proyectocore.be.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dikas
 */
public class ListaProductosModel {
    
    private List<Producto> data;

    public ListaProductosModel() {
        data = new ArrayList<>();
    }
    
    public List<Producto> getData() {
        return data;
    }

    public void setData(List<Producto> data) {
        this.data = data;
    }
    
}
