package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.math.BigDecimal;

public class RoomRepositoryImpl {

   /* private final Connection connection;

    public RoomRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(rooms room) {
        String sql = "INSERT INTO rooms (room_number, room_type, price_per_night) VALUES (?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, room.getRoomNumber());
            ps.setString(2, room.getRoomType());
            ps.setBigDecimal(3, BigDecimal.valueOf(room.getPricePerNight()));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to save room", e);
        }
    }*/
}
