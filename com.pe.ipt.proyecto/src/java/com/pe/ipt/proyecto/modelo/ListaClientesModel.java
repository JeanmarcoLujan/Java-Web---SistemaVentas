/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ipt.proyecto.modelo;

import com.pe.ipt.proyectocore.be.Cliente;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dikas
 */
public class ListaClientesModel {
    
    private List<Cliente> data;

    public ListaClientesModel() {
        data = new ArrayList<>();
    }
    
    public List<Cliente> getData() {
        return data;
    }

    public void setData(List<Cliente> data) {
        this.data = data;
    }
    
}
