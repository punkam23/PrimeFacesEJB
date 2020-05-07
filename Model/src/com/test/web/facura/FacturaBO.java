package com.test.web.facura;

import java.io.Serializable;

import java.util.Date;

public class FacturaBO implements Serializable {
    Integer idFactura;
    String nombreCliente;
    Date fechaFactura;
    Double impuesto;
    Double total;

    public FacturaBO() {
        setNombreCliente("");
        setImpuesto(0.0);
        setTotal(0.0);
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }

    public Double getImpuesto() {
        return impuesto;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getTotal() {
        return total;
    }
}
