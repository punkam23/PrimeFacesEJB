package com.test.web.detalle;

import java.io.Serializable;

public class DetalleBO implements Serializable{
    Integer idDetalleFactura;
    Integer idFactura;
    Integer idProducto;
    Integer cantidad;
    Double monto;

    public DetalleBO() {
        setCantidad(0);
        setMonto(0.0);
    }

    public void setIdDetalleFactura(Integer idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    public Integer getIdDetalleFactura() {
        return idDetalleFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Double getMonto() {
        return monto;
    }
}
