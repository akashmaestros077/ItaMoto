package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SelectSeat {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("user_id")
    @Expose
    public String userId;
    @SerializedName("vehicle_id")
    @Expose
    public String vehicleId;
    @SerializedName("seat_no")
    @Expose
    public Object seatNo;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("vehicle_sub_type")
    @Expose
    public Object vehicleSubType;
    @SerializedName("vehicle_sub_type_image")
    @Expose
    public Object vehicleSubTypeImage;
    @SerializedName("pricing")
    @Expose
    public Object pricing;
    @SerializedName("journey_date")
    @Expose
    public Object journeyDate;
    @SerializedName("start_time")
    @Expose
    public Object startTime;
    @SerializedName("end_time")
    @Expose
    public Object endTime;
    @SerializedName("first_name")
    @Expose
    public Object firstName;
    @SerializedName("last_name")
    @Expose
    public Object lastName;
    @SerializedName("age")
    @Expose
    public Object age;
    @SerializedName("gender")
    @Expose
    public Object gender;
    @SerializedName("message")
    @Expose
    public String message;

}
