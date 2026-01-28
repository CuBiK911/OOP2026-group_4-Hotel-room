package org.example;

public interface ReservationRepository {

    void save(reservationss reservation);
    void cancel(int reservationId);

}
