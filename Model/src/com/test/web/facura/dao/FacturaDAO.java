package com.test.web.facura.dao;

import com.test.web.facura.FacturaBO;

import com.test.web.helper.DBConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class FacturaDAO {
    private final static String INSERTAR_FACTURA="{CALL FACT_OWNER.SERVICIO_PRUEBA.INSERTAR_FACTURA(?,?,?,?,?,?)}";

        public FacturaDAO() {
        }
        public Integer insertarFactura(FacturaBO factura)
        {
            Integer result = -1;
            Connection connection = DBConnection.getInstance().getConnection();
            try {
                CallableStatement st = connection.prepareCall(INSERTAR_FACTURA);
                st.setInt(1, factura.getIdFactura());
                st.setString(2, factura.getNombreCliente());
                st.setTimestamp(3, new java.sql.Timestamp(factura.getFechaFactura().getTime()));
                st.setDouble(4, factura.getImpuesto());
                st.setDouble(5, factura.getTotal());
                st.registerOutParameter(6,Types.NUMERIC);
                st.execute();
                
                result=st.getInt(6);
                
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
}
