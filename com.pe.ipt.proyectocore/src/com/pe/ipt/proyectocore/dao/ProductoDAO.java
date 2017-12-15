/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ipt.proyectocore.dao;

import com.pe.ipt.proyectocore.be.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dikas
 */
public class ProductoDAO extends BaseDAO<Producto>{

    @Override
    public Producto insertar(Producto e) throws Exception {
        try {
            cn = obtenerConexion();
            cl = cn.prepareCall("{CALL PA_INSERTAR_PRODUCTO(?,?,?,?)}");
            cl.setString(1, e.getNombre());
            cl.setString(2, e.getUnidad());
            cl.setBigDecimal(3, e.getPrecioUnitario());
            cl.setInt(4, 0);
            cl.executeUpdate();
            e.setCodigo(cl.getInt(4));
        }
        finally {
            cerrar(cn, cl);
        }
        return e;
    }

    @Override
    public Producto actualizar(Producto e) throws Exception {
        try {
            cn = obtenerConexion();
            cl = cn.prepareCall("{CALL PA_ACTUALIZAR_PRODUCTO(?,?,?,?)}");
            cl.setInt(1, e.getCodigo());
            cl.setString(2, e.getNombre());
            cl.setString(3, e.getUnidad());
            cl.setBigDecimal(4, e.getPrecioUnitario());
            cl.executeUpdate();
        }
        finally {
            cerrar(cn, cl);
        }
        return e;
    }

    @Override
    public Producto eliminar(Producto e) throws Exception {
        try {
            cn = obtenerConexion();
            cl = cn.prepareCall("{CALL PA_ELIMINAR_PRODUCTO(?)}");
            cl.setInt(1, e.getCodigo());
            cl.executeUpdate();
        }
        finally {
            cerrar(cn, cl);
        }
        return e;
    }

    @Override
    public Producto buscar(Producto e) throws Exception {
        Producto rpta = null;
        
        try {
            cn = obtenerConexion();
            cl = cn.prepareCall("{CALL PA_BUSCAR_PRODUCTO(?)}");
            cl.setInt(1, e.getCodigo());
            rs = cl.executeQuery();
            if (rs.next()) {
                rpta = new Producto();
                rpta.setCodigo(rs.getInt("codigo"));
                rpta.setNombre(rs.getString("nombre"));
                rpta.setUnidad(rs.getString("unidad"));
                rpta.setPrecioUnitario(rs.getBigDecimal("precioUnitario"));                
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return rpta;
    }

    @Override
    public List<Producto> listar(Object e) throws Exception {
        List<Producto> rpta = new ArrayList<>();
        
        try {
            cn = obtenerConexion();
            cl = cn.prepareCall("{CALL PA_LISTAR_PRODUCTO()}");
            rs = cl.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setCodigo(rs.getInt("codigo"));
                p.setNombre(rs.getString("nombre"));
                p.setUnidad(rs.getString("unidad"));
                p.setPrecioUnitario(rs.getBigDecimal("precioUnitario"));
                rpta.add(p);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return rpta;
    }
    
}
