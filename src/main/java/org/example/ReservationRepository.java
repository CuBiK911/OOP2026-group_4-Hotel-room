package org.example;

public interface ReservationRepository {

    void save(reservationss reservation);
    reservationss findById(int id);
    void cancel(int reservationId);

}
