/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ipt.proyectocore.dao;

import com.pe.ipt.proyectocore.be.Empleado;
import java.util.List;

/**
 *
 * @author Dikas
 */
public class EmpleadoDAO extends BaseDAO<Empleado>{
    
    public Empleado buscar(Integer codigo, String clave) throws Exception{
        Empleado rpta = null;
        
        try {
            cn = obtenerConexion();
            cl = cn.prepareCall("{CALL PA_BUSCAR_EMPLEADO_LOGIN(?,?)}");
            cl.setInt(1, codigo);
            cl.setString(2, clave);
            rs = cl.executeQuery();
            if (rs.next()) {
                rpta = new Empleado(rs.getString("documento"));
                rpta.setNombre(rs.getString("nombre"));
                rpta.setApellido(rs.getString("apellido"));
                rpta.setCodigo(rs.getInt("codigo"));
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return rpta;
    }

    @Override
    public Empleado insertar(Empleado e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado actualizar(Empleado e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado eliminar(Empleado e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado buscar(Empleado e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empleado> listar(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
