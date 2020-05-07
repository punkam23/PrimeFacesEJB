package com.test.web.view;

import com.test.web.producto.ProductoBO;
import com.test.web.producto.ProductoServiceImplBean;

import javax.ejb.EJB;

public class FacturaServlet {
    @EJB
    private  productoServiceImplBean;
    private ProductoBO productoBO;
    
    public ProductoServlet() {
        productoBO = new ProductoBO();
    }
}
