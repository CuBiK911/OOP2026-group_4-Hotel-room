package org.example;

import java.time.LocalDate;

public class reservationss {

    private int reservationId;
    private guests guest;
    private rooms room;
    private  LocalDate checkIn;
    private  LocalDate checkOut;
    private String Status;
    public reservationss() {
    }

    public int getReservationId() {
        return reservationId;
    }

    public guests getGuest() {
        return guest;
    }

    public rooms getRoom() {
        return room;
    }

    public  LocalDate getCheckIn() {
        return checkIn;
    }

    public  LocalDate getCheckOut() {
        return checkOut;
    }
    public  String getStatus() {
        return Status;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public void setGuest(guests guest) {
        this.guest = guest;
    }

    public void setRoom(rooms room) {
        this.room = room;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public int getRoomId() {
        return room.getRoomId();
    }
    public void setStatus(String Status) {
        this.Status = Status;

    }

}
