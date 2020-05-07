package com.test.web.producto;

import javax.annotation.Resource;

import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless(name = "ProductoServiceImpl", mappedName = "Application18-Model-ProductoServiceImpl")
@Local
public class ProductoServiceImplBean implements ProductoService {
    @Resource
    SessionContext sessionContext;

    public ProductoServiceImplBean() {
    }

    @Override
    public Integer insertarProducto(ProductoBO producto) {
        // TODO Implement this method
        return null;
    }

    @Override
    public Integer modificarProducto(ProductoBO producto) {
        // TODO Implement this method
        return null;
    }

    @Override
    public Integer eliminarProducto(Integer id) throws Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public ProductoBO consultarProducto(Integer id) throws Exception {
        // TODO Implement this method
        return null;
    }
}
