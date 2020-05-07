package com.test.web.helper;

import com.test.web.detalle.DetalleBO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnectionTest {
    public DBConnectionTest() {
            super();
        }

        public static void main(String[] args) throws SQLException {
            DBConnectionTest dBConnectionTest = new DBConnectionTest();
            try {
                Connection connection = DBConnection.getInstance().getConnection();
                PreparedStatement stmt = connection.prepareStatement("SELECT   P.PONo, P.fecha," + 
                    "         L.StockNo, L.LineNo, L.Quantity, A.Price" + 
                    " FROM   factura P," + 
                    "         detalle L," + 
                    "         articulo A" + 
                    " WHERE   P.PONo = L.PONo" + 
                    "  AND    P.PONo = ?" + 
                    "  AND   L.StockNo = A.StockNo");
                stmt.setLong(1, Long.parseLong("1001"));
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    DetalleBO detalle = new DetalleBO();
                }           
                rs.close();
                stmt.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
