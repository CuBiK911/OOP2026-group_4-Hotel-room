package org.example;

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
}
