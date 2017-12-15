/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ipt.proyectocore.be;

import java.math.BigDecimal;

/**
 *
 * @author Dikas
 */
public class Factura extends Venta{
    
    private BigDecimal totalSinIGV;
    private BigDecimal igv;

    public BigDecimal getTotalSinIGV() {
        return totalSinIGV;
    }

    public void setTotalSinIGV(BigDecimal totalSinIGV) {
        this.totalSinIGV = totalSinIGV;
    }

    public BigDecimal getIgv() {
        return igv;
    }

    public void setIgv(BigDecimal igv) {
        this.igv = igv;
    }
    
    public void calcularIgv(){
        this.igv = this.total.multiply(new BigDecimal("1.18"));
        this.totalSinIGV = this.total.add(igv.multiply(new BigDecimal("-1")));
    }
    
    
}
