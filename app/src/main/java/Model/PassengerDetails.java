package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class PassengerDetails implements Serializable {
    @SerializedName("data")
    @Expose
    public List<PassengerData> data;
    @SerializedName("result")
    @Expose
    public String result;

    public List<PassengerData> getData() {
        return data;
    }

    public String getResult() {
        return result;
    }

    public class PassengerData implements Serializable {
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

        public String getId() {
            return id;
        }

        public String getUserId() {
            return userId;
        }

        public String getGender() {
            return gender;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getAge() {
            return age;
        }

        public String getMobileNumber() {
            return mobileNumber;
        }

        public String getRouteId() {
            return routeId;
        }

        public String getSeatNo() {
            return seatNo;
        }

        public String getPickupId() {
            return pickupId;
        }

        public String getDropId() {
            return dropId;
        }

        public Object getBookingId() {
            return bookingId;
        }

        public String getStatus() {
            return status;
        }
    }
}
