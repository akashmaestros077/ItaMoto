package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SeatAvailable {

    @SerializedName("seat_no")
    @Expose
    public Integer seatNo;
    @SerializedName("status")
    @Expose
    public String status;

    public Integer getSeatNo() {
        return seatNo;
    }

    public String getStatus() {
        return status;
    }
}
