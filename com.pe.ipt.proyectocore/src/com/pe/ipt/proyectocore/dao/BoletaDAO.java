/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ipt.proyectocore.dao;

import com.pe.ipt.proyectocore.be.Boleta;
import com.pe.ipt.proyectocore.be.Venta;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Dikas
 */
public class BoletaDAO extends BaseDAO<Venta>{

    @Override
    public Venta insertar(Venta e) throws Exception {
        
        cn = obtenerConexion();
        cn.setAutoCommit(false);
        try {
            cl = cn.prepareCall("{CALL PA_INSERTA_BOLETA(?,?,?,?,?)}");
            cl.setString(1, e.getNumero());
            cl.setString(2, e.getCliente().getDocumento());
            cl.setInt(3, e.getVendedor().getCodigo());
            cl.setDate(4, Date.valueOf(e.getFecha()));
            cl.setBigDecimal(5, e.getTotal());
            if(cl.executeUpdate() == 1){
                for(Boleta.DetalleVentaProducto d: e.getDetalle()){
                   cl = cn.prepareCall("{CALL PA_INSERTA_BOLETADETALLE(?,?,?,?)}");
                   cl.setString(1, e.getNumero());
                   cl.setInt(2, d.getProducto().getCodigo());
                   cl.setInt(3, d.getCantidad().intValue());
                   cl.setBigDecimal(4, d.getPrecioTotal());
                   cl.executeUpdate();
                }
                cn.commit();
            }
        } catch (SQLException ex) {
            cn.rollback();
            ex.printStackTrace();
        }finally{
            cerrar(cn, cl);
        }
        return e;
    }

    @Override
    public Venta actualizar(Venta e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Venta eliminar(Venta e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Venta buscar(Venta e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Venta> listar(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
