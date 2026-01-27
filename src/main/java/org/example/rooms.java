package org.example;

public class rooms {

    private int RoomId;
    private int RoomNumber;
    private String roomType;
    private double pricePerNight;



    public int getRoomId() {
        return RoomId;
    }

    public int getRoomNumber() {
        return RoomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setRoomId(int roomId) {
        this.RoomId = roomId;
    }

    public void setRoomNumber(int roomNumber) {
        this.RoomNumber = roomNumber;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }
}
