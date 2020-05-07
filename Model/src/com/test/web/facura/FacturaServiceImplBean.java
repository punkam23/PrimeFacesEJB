package com.test.web.facura;

import javax.annotation.Resource;

import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless(name = "FacturaServiceImpl", mappedName = "Application18-Model-FacturaServiceImpl")
@Local
public class FacturaServiceImplBean implements FacturaService{
    @Resource
    SessionContext sessionContext;

    public FacturaServiceImplBean() {
    }

    @Override
    public Integer insertarFactura(FacturaBO factura) {
        // TODO Implement this method
        return null;
    }
}
