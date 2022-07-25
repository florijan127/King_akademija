package com.example.mini_web_shop.trigger;

import org.h2.api.Trigger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SmanjiKolicinu implements Trigger {

    @Override
    public void init(Connection conn, String schemaName,
                     String triggerName, String tableName, boolean before, int type)
            throws SQLException {}

    @Override
    public void fire(Connection conn, Object[] oldRow, Object[] newRow)
            throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "UPDATE PROIZVOD SET kolicina_pro = PROIZVOD.kolicina_pro - 1 WHERE id = ?;")
        ) {
            stmt.setObject(1, newRow[2]);
            stmt.executeUpdate();
        }
    }

    @Override
    public void close() throws SQLException {}

    @Override
    public void remove() throws SQLException {}
}