import java.time.LocalDate;

public class reservations {
    private int id;
    private int guestId;
    private int roomId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;

    public reservations(int guestId, int roomId,
                        LocalDate startDate, LocalDate endDate) {
        this.guestId = guestId;
        this.roomId = roomId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = "ACTIVE";
    }

    public int getRoomId() { return roomId; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
}
