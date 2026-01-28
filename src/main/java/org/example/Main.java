package org.example;

import edu.aitu.oop3.db.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

        try (Connection connection = DatabaseConnection.getConnection()) {

            GuestRepository guestRepo1 = new GuestRepositoryImpl(connection);
            RoomRepository roomRepo1 = new RoomRepositoryImpl(connection);
            ReservationRepository reservationRepo1 = new ReservationRepositoryImpl(connection);
            PaymentRepository paymentRepo1 = new PaymentRepositoryImpl(connection);

            RoomRepoService roomRepo = new RoomRepoService() {
                private final List<rooms> Room = createMockRooms();

                private List<rooms> createMockRooms() {
                    List<rooms> list = new ArrayList<>();
                    rooms r1 = new rooms();
                    r1.setRoomId(1);
                    r1.setRoomNumber(101);
                    r1.setRoomType("Single");
                    r1.setPricePerNight(50.0);
                    list.add(r1);

                    rooms r2 = new rooms();
                    r2.setRoomId(2);
                    r2.setRoomNumber(102);
                    r2.setRoomType("Double");
                    r2.setPricePerNight(80.0);
                    list.add(r2);
                    return list;
                }


                @Override
                public List<rooms> findAvailableRooms(LocalDate checkIn, LocalDate checkOut) {
                    //  all rooms are always available
                    return new ArrayList<>(Room);
                }
            };

            ReservationRepository reservationRepo = new ReservationRepository() {
                @Override
                public void save(reservationss reservation) {
                    System.out.println("Reservation saved: " +
                            reservation.getRoom().getRoomNumber() +
                            " for guest " +
                            reservation.getGuest().getName());

                }


                @Override
                public void cancel(int reservationId) {
                    System.out.println("Reservation " + reservationId + " cancelled");
                }
            }; // missing getRoomNumber and getGuest in reservationss class

            PaymentRepository paymentRepo = new PaymentRepository() {
                @Override
                public void save(payments payment) {
                    System.out.println("Payment processed: $" + payment.getAmount());
                }
            };
            //functions(services) initialize
            RoomAvailabilityService availabilityService = new RoomAvailabilityService(roomRepo);
            PaymentService paymentService = new PaymentService(paymentRepo);
            ReservationService reservationService = new ReservationService(
                    reservationRepo, availabilityService, paymentService

            ); // just uncomment when ready

            // --- Test data ---
            guests guest = new guests();
            guest.setGuestId(1);
            guest.setName("John Doe");

            rooms room = new rooms();
            room.setRoomId(1);
            room.setRoomNumber(101);
            room.setRoomType("Single");
            room.setPricePerNight(50.0);

            reservationss reservation = new reservationss();
            reservation.setReservationId(1);
            reservation.setGuest(guest);
            reservation.setRoom(room);
            reservation.setCheckIn(LocalDate.now().plusDays(1));
            reservation.setCheckOut(LocalDate.now().plusDays(3));

            payments payment = new payments();
            payment.setReservation(reservation);
            payment.setAmount(room.getPricePerNight() * 2); // 2 nights, rooms class

            // Setters and getPricePerNight missing


            System.out.println("Available rooms:");
            List<rooms> availableRooms = availabilityService.searchAvailableRooms(
                    reservation.getCheckIn(),
                    reservation.getCheckOut()
            );

            for (rooms r : availableRooms) {
                System.out.println("- " + r.getRoomNumber() + " (" + r.getRoomType() + ")");
            }

            //getters and method missing

            try {
                reservationService.createReservation(reservation, payment);
            } catch (Exception e) {
                System.out.println("Error creating reservation: " + e.getMessage());
            }


            reservationService.cancelReservation(reservation.getReservationId());

        }
      catch (SQLException e) {
          System.err.println("Database operation failed:");
          e.printStackTrace();
          System.exit(1);
      }
    }
}