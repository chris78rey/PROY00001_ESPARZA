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
import javax.persistence.Table;

/**
 *
 * @author christian_ruiz
 */
@Entity
@Table(name = "V_CLASIF_ARBOL")
public class VClasifArbol implements Serializable {

    private static final long serialVersionUID = 1L;

    public VClasifArbol() {
    }

    @Column(name = "ID")
    @Id
    @Basic(optional = false)
    private BigDecimal id;

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return this.id;
    }

    @Basic(optional = true)
    @Column(name = "ID_PADRE")
    private BigDecimal idPadre;

    public void setIdPadre(BigDecimal idPadre) {
        this.idPadre = idPadre;
    }

    public BigDecimal getIdPadre() {
        return this.idPadre;
    }
    @Column(name = "NIVEL")
    @Basic(optional = true)
    private BigDecimal nivel;

    public void setNivel(BigDecimal nivel) {
        this.nivel = nivel;
    }

    public BigDecimal getNivel() {
        return this.nivel;
    }
    @Column(name = "S")
    @Basic(optional = true)
    private String s;

    public void setS(String s) {
        this.s = s;
    }

    public String getS() {
        return this.s;
    }
}
