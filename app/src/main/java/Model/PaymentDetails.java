package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymentDetails {
    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private PaymentData data;

    public String getResult() {
        return result;
    }

    public String getStatus() {
        return status;
    }

    public PaymentData getData() {
        return data;
    }

    private class PaymentData {
        @SerializedName("id")
        @Expose
        public String id;
        @SerializedName("route_id")
        @Expose
        public String routeId;
        @SerializedName("passenger_id")
        @Expose
        public String passengerId;
        @SerializedName("meal_id")
        @Expose
        public String mealId;
        @SerializedName("discount_percentage")
        @Expose
        public String discountPercentage;
        @SerializedName("offer_code")
        @Expose
        public String offerCode;
        @SerializedName("points")
        @Expose
        public String points;
        @SerializedName("ticket_fare")
        @Expose
        public Integer ticketFare;
        @SerializedName("user_id")
        @Expose
        public String userId;
        @SerializedName("meal")
        @Expose
        public String meal;
    }
}
