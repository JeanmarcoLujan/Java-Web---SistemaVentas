/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ipt.proyectocore.bl;

import java.util.List;

/**
 *
 * @author Dikas
 */
public abstract class BaseBL<E> {
    
    public abstract E insertar(E e) throws Exception;

    public abstract E actualizar(E e) throws Exception;

    public abstract E eliminar(E e) throws Exception;

    public abstract E buscar(E e) throws Exception;
    
    public abstract List<E> listar(Object e) throws Exception;
}
