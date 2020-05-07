package com.test.web.detalle.dao;

import com.test.web.detalle.DetalleBO;
import com.test.web.helper.DBConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class DetalleDAO {
    public DetalleDAO() {
    }

    private final static String INSERTAR_DETALLE_FACTURA =
        "{CALL FACT_OWNER.SERVICIO_PRUEBA.INSERTAR_DETALLE_FACTURA(?,?,?,?,?,?)}";

    public Integer insertarDetalleFactura(DetalleBO detalle) {
        Integer result = -1;
        Connection connection = DBConnection.getInstance().getConnection();
        try {

            CallableStatement stmt = connection.prepareCall(INSERTAR_DETALLE_FACTURA);
            stmt.setInt(1, detalle.getIdDetalleFactura());
            stmt.setInt(2, detalle.getIdFactura());
            stmt.setInt(3, detalle.getIdProducto());
            stmt.setInt(4, detalle.getCantidad());
            stmt.setDouble(5, detalle.getMonto());
            stmt.registerOutParameter(6, Types.NUMERIC);
            stmt.execute();

            result = stmt.getInt(6);
            if (result != 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
