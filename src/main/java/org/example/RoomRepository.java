package org.example;

import java.util.List;
import java.time.LocalDate;
public interface RoomRepository {

    List<rooms> findAvailableRooms(LocalDate checkIn, LocalDate checkOut);

}
