/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.labor0002_domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "TABLA1")
@NamedQueries({
    @NamedQuery(name = "Tabla1.findAll", query = "SELECT t FROM Tabla1 t")})
public class Tabla1 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "C1")
    private BigDecimal c1;
    @Column(name = "C2")
    private String c2;

    public Tabla1() {
    }

    public Tabla1(BigDecimal c1) {
        this.c1 = c1;
    }

    public BigDecimal getC1() {
        return c1;
    }

    public void setC1(BigDecimal c1) {
        this.c1 = c1;
    }

    public String getC2() {
        return c2;
    }

    public void setC2(String c2) {
        this.c2 = c2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (c1 != null ? c1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabla1)) {
            return false;
        }
        Tabla1 other = (Tabla1) object;
        if ((this.c1 == null && other.c1 != null) || (this.c1 != null && !this.c1.equals(other.c1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lab.labor0002_domain.Tabla1[ c1=" + c1 + " ]";
    }
    
}
