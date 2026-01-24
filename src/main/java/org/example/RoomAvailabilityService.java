package org.example;

public class RoomAvailabilityService {
    private final RoomRepository roomRepository;

    public RoomAvailabilityService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
}
