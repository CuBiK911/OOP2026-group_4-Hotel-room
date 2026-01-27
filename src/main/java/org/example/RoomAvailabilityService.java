package org.example;

import java.time.LocalDate;
import java.util.List;

public class RoomAvailabilityService {

    private final RoomRepository roomRepository;

    public RoomAvailabilityService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<rooms> searchAvailableRooms(LocalDate checkIn, LocalDate checkOut) {
        if (checkIn.isAfter(checkOut)) {
            throw new InvalidDateRangeException("Check-in date must be before check-out date.");
        }
>>>>>>> ab4b9cf03325a174a0e1da48c0147ee21bb0b84b
        return roomRepository.findAvailableRooms(checkIn, checkOut);
    }
}
