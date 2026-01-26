package org.example;

public class rooms {

    private int roomId;
    private String roomNumber;
    private String roomType;
    private double pricePerNight;



    public int getRoomId() {
        return roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }
}
