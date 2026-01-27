package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GuestRepositoryImpl  {

   /* private final Connection connection;

    public GuestRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(guests guest) {
        String sql = "INSERT INTO guests (name, email, phone) VALUES (?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, guest.getName());
            ps.setString(2, guest.getEmail());
            ps.setString(3, guest.getPhone());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to save guest", e);
        }
    }*/
}
