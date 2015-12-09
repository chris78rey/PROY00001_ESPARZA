package com.lab.labor0005_web.jsfclasses;

import com.lab.labor0002_domain.VClasifArbol;
import com.lab.labor0005_web.jsfclasses.util.JsfUtil;
import com.lab.labor0005_web.jsfclasses.util.JsfUtil.PersistAction;
import com.lab.labor0005_web.sessionbean.VClasifArbolFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("vClasifArbolController")
@SessionScoped
public class VClasifArbolController implements Serializable {

    @EJB
    private com.lab.labor0005_web.sessionbean.VClasifArbolFacade ejbFacade;
    private List<VClasifArbol> items = null;
    private VClasifArbol selected;

    public VClasifArbolController() {
    }

    public VClasifArbol getSelected() {
        return selected;
    }

    public void setSelected(VClasifArbol selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private VClasifArbolFacade getFacade() {
        return ejbFacade;
    }

    public VClasifArbol prepareCreate() {
        selected = new VClasifArbol();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("VClasifArbolCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("VClasifArbolUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("VClasifArbolDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<VClasifArbol> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public VClasifArbol getVClasifArbol(java.math.BigDecimal id) {
        return getFacade().find(id);
    }

    public List<VClasifArbol> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<VClasifArbol> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = VClasifArbol.class)
    public static class VClasifArbolControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            VClasifArbolController controller = (VClasifArbolController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "vClasifArbolController");
            return controller.getVClasifArbol(getKey(value));
        }

        java.math.BigDecimal getKey(String value) {
            java.math.BigDecimal key;
            key = new java.math.BigDecimal(value);
            return key;
        }

        String getStringKey(java.math.BigDecimal value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof VClasifArbol) {
                VClasifArbol o = (VClasifArbol) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), VClasifArbol.class.getName()});
                return null;
            }
        }

    }

}
