/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.labor0003_ejb.personalizados;

import com.lab.labor0003_ejb.VClasifArbolFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrador
 */
@Stateless
public class SessionGeneral implements SessionGeneralRemote {

    @EJB
    private VClasifArbolFacade vClasifArbolFacade;
    @PersistenceContext(unitName = "com.lab_LABOR0003_EJB_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }
  
}
