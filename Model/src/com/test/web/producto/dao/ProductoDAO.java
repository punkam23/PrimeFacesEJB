package com.test.web.producto.dao;

import com.test.web.helper.DBConnection;
import com.test.web.producto.ProductoBO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import oracle.jdbc.OracleTypes;

public class ProductoDAO {
    private final static String INSERTAR_PRODUCTO="{CALL FACT_OWNER.SERVICIO_PRUEBA.INSERTAR_PRODUCTO(?,?,?,?,?)}";
        private final static String MODIFICAR_PRODUCTO="{CALL FACT_OWNER.SERVICIO_PRUEBA.MODIFICAR_PRODUCTO(?,?,?,?,?)}";
        private final static String ELIMINAR_PRODUCTO="{CALL FACT_OWNER.SERVICIO_PRUEBA.ELIMINAR_PRODUCTO(?,?)}";
        private final static String CONSULTAR_PRODUCTO="{CALL FACT_OWNER.SERVICIO_PRUEBA.CONSULTAR_PRODUCTO(?,?,?)}";
        
        public ProductoDAO() {
        }
        
        public Integer insertarProducto(ProductoBO producto)
        {
            Integer result = -1;
            Connection connection = DBConnection.getInstance().getConnection();
            try {
                CallableStatement st = connection.prepareCall(INSERTAR_PRODUCTO);
                st.setInt(1, producto.getIdProducto());
                st.setString(2, producto.getNombre());
                st.setInt(3, producto.getCantidad());
                st.setDouble(4, producto.getMonto());
                st.registerOutParameter(5,Types.NUMERIC);
                st.execute();
                
                result=st.getInt(5);
                
                if(result!=0){
                        throw new  Exception();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return result;
        }

        public Integer modificarProducto(ProductoBO producto) {
            Integer result = -1;
            Connection connection = DBConnection.getInstance().getConnection();
            try {
                CallableStatement st = connection.prepareCall(MODIFICAR_PRODUCTO);
                st.setInt(1, producto.getIdProducto());
                st.setString(2, producto.getNombre());
                st.setInt(3, producto.getCantidad());
                st.setDouble(4, producto.getMonto());
                st.registerOutParameter(5,Types.NUMERIC);
                st.execute();
                
                result=st.getInt(5);
                
                if(result!=0){
                        throw new  Exception();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return result;
        }

        public Integer eliminarProducto(Integer id) {
            Integer result = -1;
            Connection connection = DBConnection.getInstance().getConnection();
            try {
                CallableStatement st = connection.prepareCall(ELIMINAR_PRODUCTO);
                st.setInt(1, id);
                st.registerOutParameter(2,Types.NUMERIC);
                st.execute();
                
                result=st.getInt(2);
                
                if(result!=0){
                        throw new  Exception();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return result;
        }

        public ProductoBO consultarProducto(Integer id) {
            Integer result = -1;
            ProductoBO productoBO = null;
            ResultSet resultSet = null;
            Connection connection = DBConnection.getInstance().getConnection();
            try {
                CallableStatement st = connection.prepareCall(CONSULTAR_PRODUCTO);
                st.setInt(1, id);
                st.registerOutParameter(2,Types.NUMERIC);
                st.registerOutParameter(3,OracleTypes.CURSOR);
                st.execute();
                
                result=st.getInt(2);
                
                if(result!=0){
                        throw new  Exception();
                }
                resultSet=(ResultSet)st.getObject(3);
                
                //se recorre el result set con los datos del prducto 
                if(resultSet.next()){
                    productoBO = new ProductoBO();
                    productoBO.setIdProducto(resultSet.getInt("ID"));
                    productoBO.setNombre(resultSet.getString("NOMBRE"));
                    productoBO.setCantidad(resultSet.getInt("CANTIDAD"));
                    productoBO.setMonto(resultSet.getDouble("MONTO"));
                }//fin if
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return productoBO;
        }
}
