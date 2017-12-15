/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ipt.proyectocore.dao;

import com.pe.ipt.proyectocore.be.Cliente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dikas
 */
public class ClienteDAO extends BaseDAO<Cliente>{

    @Override
    public Cliente insertar(Cliente e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente actualizar(Cliente e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente eliminar(Cliente e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente buscar(Cliente e) throws Exception {
        Cliente rpta = null;
        try {
            cn = obtenerConexion();
            cl = cn.prepareCall("{CALL PA_BUSCAR_CLIENTE_DNI(?)}");
            cl.setString(1, e.getDocumento());
            rs = cl.executeQuery();
            
            if(rs.next()){
                
                String ruc = rs.getString("ruc");
                String razonSocial = rs.getString("razonSocial");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String documento = rs.getString("documento");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String ciudad = rs.getString("ciudad");
                LocalDate fechaNacimiento = rs.getDate("fechaNacimiento").toLocalDate();
                
                rpta = new Cliente(documento, ruc);
                rpta.setRazonSocial(razonSocial);
                rpta.setNombre(nombre);
                rpta.setApellido(apellido);
                rpta.setDireccion(direccion);
                rpta.setTelefono(telefono);
                rpta.setCiudad(ciudad);
                rpta.setFechaNacimiento(fechaNacimiento);
                
            }
            
        } finally{
            cerrar(cn, cl, rs);
        }
        return rpta;
    }

    @Override
    public List<Cliente> listar(Object e) throws Exception {
        List<Cliente> rpta = new ArrayList<>();
        try {
            cn = obtenerConexion();
            cl = cn.prepareCall("{CALL PA_LISTAR_CLIENTE()}");
            rs = cl.executeQuery();
            
            while(rs.next()){
                
                String ruc = rs.getString("ruc");
                String razonSocial = rs.getString("razonSocial");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String documento = rs.getString("documento");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String ciudad = rs.getString("ciudad");
                LocalDate fechaNacimiento = rs.getDate("fechaNacimiento").toLocalDate();
                
                Cliente c = new Cliente(documento, ruc);
                c.setRazonSocial(razonSocial);
                c.setNombre(nombre);
                c.setApellido(apellido);
                c.setDireccion(direccion);
                c.setTelefono(telefono);
                c.setCiudad(ciudad);
                c.setFechaNacimiento(fechaNacimiento);
                
                rpta.add(c);
                
            }
            
        } finally{
            cerrar(cn, cl, rs);
        }
        return rpta;
    }
    
}
