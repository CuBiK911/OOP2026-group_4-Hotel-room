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
      /*  System.out.println("Connecting to Supabase...");
        try (Connection connection = DatabaseConnection.getConnection()) {
            System.out.println("Connected successfully!");
            String sql = "SELECT CURRENT_TIMESTAMP";
            try (PreparedStatement stmt = connection.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Database time: " + rs.getTimestamp(1));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while connecting to database:");
            e.printStackTrace();
        }*/
        RoomRepository roomRepo = new RoomRepository() {
            List<rooms> Room = new ArrayList<>();

              {
                    Room.add(new rooms() {{
                        setRoomId(1);
                        setRoomNumber(101);
                        setRoomType("Single");
                        setPricePerNight(50.0);
                    }});
                    Room.add(new rooms() {{
                        setRoomId(2);
                        setRoomNumber(102);
                        setRoomType("Double");
                        setPricePerNight(80.0);
                    }});
                }

            @Override
            public List<rooms> findAvailableRooms(LocalDate checkIn, LocalDate checkOut) {
                //  all rooms are always available
                return Room;
            }
        };

        ReservationRepository reservationRepo = new ReservationRepository() {
            @Override
            public void save(reservationss reservation) {
                System.out.println("Reservation saved: "
                        + reservation.getRoom().getRoomNumber()
                        + " for guest " + reservation.getGuest().getName());
            }

            @Override
            public reservationss findById(int id) {
                return null;
            }


            @Override
            public void cancel(int reservationId) {
                System.out.println("Reservation " + reservationId + " cancelled");
            }
        };

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
        );

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




        System.out.println("Available rooms:");
        List<rooms> availableRooms = availabilityService.findAvailableRooms(
                reservation.getCheckIn(),
                reservation.getCheckOut()
        );

        for (rooms r : availableRooms) {
            System.out.println("- " + r.getRoomNumber() + " (" + r.getRoomType() + ")");
        }


        try {
            reservationService.createReservation(reservation, payment);
        } catch (Exception e) {
            System.out.println("Error creating reservation: " + e.getMessage());
        }

        // Cancel reservation
        reservationService.cancelReservation(reservation.getReservationId());

    }
}