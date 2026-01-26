package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

public class ReservationRepositoryImpl {

    /* private final Connection connection;

    public ReservationRepositoryImpl(Connection connection) {
        this.connection = connection;
    }
   @Override
   public ReservationRepository findById(int id){return null;}
    @Override
    public void save(reservationss reservation) {
        String sql = "INSERT INTO reservations (guest_id, room_id, check_in, check_out, status) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, reservation.getGuest().getGuestId());
            ps.setInt(2, reservation.getRoom().getRoomId());
            ps.setDate(3, Date.valueOf(reservation.getCheckIn()));
            ps.setDate(4, Date.valueOf(reservation.getCheckOut()));
            ps.setString(5, reservation.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to save reservation", e);
        }
    }

    @Override
    public void delete(int reservationId) {
        String sql = "DELETE FROM reservations WHERE reservation_id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, reservationId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete reservation", e);
        }
    }*/
}
