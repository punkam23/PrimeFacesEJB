package com.test.web.detalle;

import javax.annotation.Resource;

import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless(name = "DetalleServiceImpl", mappedName = "Application18-Model-DetalleServiceImpl")
@Local
public class DetalleServiceImplBean implements DetalleService{
    @Resource
    SessionContext sessionContext;

    public DetalleServiceImplBean() {
    }

    @Override
    public Integer insertarDetalleFactura(DetalleBO detalle) {
        // TODO Implement this method
        return null;
    }
}
