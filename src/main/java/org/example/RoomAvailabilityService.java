package org.example;

import java.time.LocalDate;
import java.util.List;

public class RoomAvailabilityService {
    private final RoomRepository roomRepository;

    public RoomAvailabilityService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<rooms> findAvailableRooms(LocalDate checkIn, LocalDate checkOut) {
        return roomRepository.findAvailableRooms(checkIn, checkOut);
    }
}
