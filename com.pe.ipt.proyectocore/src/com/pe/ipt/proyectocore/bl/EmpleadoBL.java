/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ipt.proyectocore.bl;

import com.pe.ipt.proyectocore.be.Empleado;
import com.pe.ipt.proyectocore.dao.EmpleadoDAO;
import java.util.List;

/**
 *
 * @author Dikas
 */
public class EmpleadoBL extends BaseBL<Empleado>{
    
    private final EmpleadoDAO dao = new EmpleadoDAO();
    
    public Empleado buscar(Integer codigo, String clave) throws Exception {
        clave = Empleado.encriptaClaveMD5(clave);
        return dao.buscar(codigo, clave);
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
