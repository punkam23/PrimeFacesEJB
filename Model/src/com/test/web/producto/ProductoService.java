package com.test.web.producto;

public interface ProductoService {
    public Integer insertarProducto(ProductoBO producto);

    public Integer modificarProducto(ProductoBO producto);

    public Integer eliminarProducto(Integer id) throws Exception;

    public ProductoBO consultarProducto(Integer id) throws Exception;
}
