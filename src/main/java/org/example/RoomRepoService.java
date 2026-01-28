package org.example;

import java.time.LocalDate;
import java.util.List;

public interface RoomRepoService {
    List<rooms> findAvailableRooms(LocalDate checkIn, LocalDate checkOut);
}
