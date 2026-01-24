package org.example;
import edu.aitu.oop3.db.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class rooms {
    private int id;
    private String roomNumber;
    private int capacity;
    private double price;

    public rooms(int id, String roomNumber, int capacity, double price) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.price = price;
    }

    public int getId() { return id; }
    public String getRoomNumber() { return roomNumber; }
    public int getCapacity() { return capacity; }
    public double getPrice() { return price; }




}
