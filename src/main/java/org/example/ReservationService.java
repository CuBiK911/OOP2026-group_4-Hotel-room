package org.example;
import edu.aitu.oop3.db.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final RoomAvailabilityService availabilityService;
    private final PaymentService paymentService;

    public ReservationService(
            ReservationRepository reservationRepository,
            RoomAvailabilityService availabilityService,
            PaymentService paymentService) {

        this.reservationRepository = reservationRepository;
        this.availabilityService = availabilityService;
        this.paymentService = paymentService;
    }



    public void createReservation(reservationss reservation, payments payment) {

        List<rooms> availableRooms = availabilityService.searchAvailableRooms(
                reservation.getCheckIn(),
                reservation.getCheckOut()
        );

        if (!availableRooms.contains(reservation.getRoom())) {
            throw new RoomNotAvailableException("Selected room is not available.");
        }

        reservation.setStatus("CONFIRMED");
        reservationRepository.save(reservation);
        paymentService.processPayment(payment);
    }


    public void cancelReservation(int reservationId) {
        reservationRepository.cancel(reservationId);
    }
}

