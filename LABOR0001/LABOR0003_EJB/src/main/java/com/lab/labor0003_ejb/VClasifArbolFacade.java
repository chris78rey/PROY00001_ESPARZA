/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.labor0003_ejb;

import com.lab.labor0002_domain.VClasifArbol;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrador
 */
@Stateless
public class VClasifArbolFacade extends AbstractFacade<VClasifArbol>  {

    @PersistenceContext(unitName = "com.lab_LABOR0003_EJB_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VClasifArbolFacade() {
        super(VClasifArbol.class);
    }
    
}
