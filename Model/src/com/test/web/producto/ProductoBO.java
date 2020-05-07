package com.test.web.producto;

import java.io.Serializable;

public class ProductoBO implements Serializable {
    Integer idProducto;
    String nombre;
    Integer cantidad;
    Double monto;

    public ProductoBO() {
        setCantidad(0);
        setMonto(0.0);
        setNombre("");
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
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
