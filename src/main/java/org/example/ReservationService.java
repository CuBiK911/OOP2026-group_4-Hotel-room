package org.example;

import java.util.List;

public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final RoomAvailabilityService availabilityService;
    private final PaymentService paymentService;

    public ReservationService(ReservationRepository reservationRepository,
                              RoomAvailabilityService availabilityService,
                              PaymentService paymentService) {
        this.reservationRepository = reservationRepository;
        this.availabilityService = availabilityService;
        this.paymentService = paymentService;
    }

    public void createReservation(reservationss reservation, payments payment) {

        List<rooms> availableRooms = availabilityService.findAvailableRooms(
                reservation.getCheckIn(),
                reservation.getCheckOut()
        );

        boolean available = availableRooms.stream()
                .anyMatch(r -> r.getRoomId() == reservation.getRoom().getRoomId());

        if (!available) {
            throw new RuntimeException("Room not available");
        }

        reservationRepository.save(reservation);
        paymentService.processPayment(payment);
    }

    public void cancelReservation(int reservationId) {
        reservationRepository.cancel(reservationId);
    }
}
