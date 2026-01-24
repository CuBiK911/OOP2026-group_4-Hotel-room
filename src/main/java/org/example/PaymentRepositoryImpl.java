package org.example;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.math.BigDecimal;
public class PaymentRepositoryImpl implements PaymentRepository {
    private final Connection connection;

    public PaymentRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(payments payment){
        String sql = "INSERT INTO payments (reservation_id, amount, payment_status) VALUES (?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, payment.getReservation().getRoomId());
            ps.setBigDecimal(2, BigDecimal.valueOf(payment.getAmount()));
            ps.setString(3, payment.getPaymentStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to save payment", e);
        }
    }
}