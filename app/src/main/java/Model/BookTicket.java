package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BookTicket implements Serializable {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("user_id")
    @Expose
    public String userId;
    @SerializedName("start_point")
    @Expose
    public String startPoint;
    @SerializedName("end_point")
    @Expose
    public String endPoint;
    @SerializedName("journey_date")
    @Expose
    public String journeyDate;
    @SerializedName("vehicle_type")
    @Expose
    public String vehicleType;
    @SerializedName("status")
    @Expose
    public Object status;
    @SerializedName("strtotime")
    @Expose
    public Object strtotime;
    @SerializedName("result")
    @Expose
    public String result;

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public String getJourneyDate() {
        return journeyDate;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public Object getStatus() {
        return status;
    }

    public Object getStrtotime() {
        return strtotime;
    }

    public String getResult() {
        return result;
    }
}
