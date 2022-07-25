package com.example.mini_web_shop.trigger;

import org.h2.api.Trigger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeaktivirajKupon implements Trigger {

    @Override
    public void init(Connection conn, String schemaName,
                     String triggerName, String tableName, boolean before, int type)
            throws SQLException {}

    @Override
    public void fire(Connection conn, Object[] oldRow, Object[] newRow)
            throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "UPDATE POPUST_KODOVI SET iskoristen = 'TRUE' WHERE id_popust_kod = ?;")
        ) {
            stmt.setObject(1, newRow[4]);
            stmt.executeUpdate();
        }
    }

    @Override
    public void close() throws SQLException {}

    @Override
    public void remove() throws SQLException {}
}