package com.test.web.view;

import com.test.web.producto.ProductoBO;

import com.test.web.producto.ProductoServiceImplBean;

import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class ProductoServlet {
   
    @EJB
    private ProductoServiceImplBean productoServiceImplBean;
    private ProductoBO productoBO;
    
    public ProductoServlet() {
        productoBO = new ProductoBO();
    }

    public void setProductoTO(ProductoBO productoBO) {
        this.productoBO = productoBO;
    }

    public ProductoBO getProductoBO() {
        return productoBO;
    }

    public void buscarProducto() {
        try {
            productoBO = productoServiceImplBean.consultarProducto(productoBO.getIdProducto());
            if (productoBO == null) {
                productoBO = new ProductoBO();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El producto no existe"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al buscar"));
        }
    }

    public void insertarProducto() {
        try {
            ProductoBO p = productoServiceImplBean.consultarProducto(productoBO.getIdProducto());
            if (p == null) {
                productoServiceImplBean.insertarProducto(productoBO);
                productoBO = new ProductoBO();
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage("El producto se insertó correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage("El id del producto ya ha sido insertado"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al insertar"));
        }
    }

    public void modificarProducto() {
        try {
            ProductoBO p = productoServiceImplBean.consultarProducto(productoBO.getIdProducto());
            if (p != null) {
                productoServiceImplBean.modificarProducto(productoBO);
                productoBO = new ProductoBO();
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage("El producto se modificó correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El producto no existe"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al modificar"));
        }
    }

    public void eliminarProducto() {
        try {
            ProductoBO p = productoServiceImplBean.consultarProducto(productoBO.getIdProducto());
            if (p != null) {
                productoServiceImplBean.eliminarProducto(productoBO.getIdProducto());
                productoBO = new ProductoBO();
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage("El producto se eliminó correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El producto no existe"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al eliminar"));
        }
    }
}
