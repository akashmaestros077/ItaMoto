package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JourneyDetails {
    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("from_to")
    @Expose
    public String fromTo;
    @SerializedName("from_to_id")
    @Expose
    public String fromToId;
    @SerializedName("to_from")
    @Expose
    public String toFrom;
    @SerializedName("to_from_id")
    @Expose
    public String toFromId;
    @SerializedName("vehicle_type")
    @Expose
    public String vehicleType;
    @SerializedName("vehicle_type_id")
    @Expose
    public String vehicleTypeId;
    @SerializedName("route_date")
    @Expose
    public String routeDate;
    @SerializedName("start_time")
    @Expose
    public String startTime;
    @SerializedName("end_time")
    @Expose
    public String endTime;
    @SerializedName("time_duration")
    @Expose
    public String timeDuration;
    @SerializedName("route_distance")
    @Expose
    public String routeDistance;
    @SerializedName("seat_no")
    @Expose
    public List<String> seatNo;
    @SerializedName("data")
    @Expose
    public List<JourneyData> data;

    private class JourneyData {
        @SerializedName("id")
        @Expose
        public String id;
        @SerializedName("user_id")
        @Expose
        public String userId;
        @SerializedName("gender")
        @Expose
        public String gender;
        @SerializedName("first_name")
        @Expose
        public String firstName;
        @SerializedName("last_name")
        @Expose
        public String lastName;
        @SerializedName("age")
        @Expose
        public String age;
        @SerializedName("mobile_number")
        @Expose
        public String mobileNumber;
        @SerializedName("route_id")
        @Expose
        public String routeId;
        @SerializedName("seat_no")
        @Expose
        public String seatNo;
        @SerializedName("pickup_id")
        @Expose
        public String pickupId;
        @SerializedName("drop_id")
        @Expose
        public String dropId;
        @SerializedName("booking_id")
        @Expose
        public Object bookingId;
        @SerializedName("status")
        @Expose
        public String status;
    }
}
