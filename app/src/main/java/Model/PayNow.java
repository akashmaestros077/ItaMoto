package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PayNow {
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("user_id")
    @Expose
    public String userId;
    @SerializedName("route_id")
    @Expose
    public String routeId;
    @SerializedName("passenger_id")
    @Expose
    public String passengerId;
    @SerializedName("from_to")
    @Expose
    public Object fromTo;
    @SerializedName("to_from")
    @Expose
    public Object toFrom;
    @SerializedName("vehicle_type")
    @Expose
    public Object vehicleType;
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
    @SerializedName("meal_id")
    @Expose
    public String mealId;
    @SerializedName("drop_id")
    @Expose
    public String dropId;
    @SerializedName("ticket_fare")
    @Expose
    public String ticketFare;
    @SerializedName("meal")
    @Expose
    public String meal;
    @SerializedName("total_amt")
    @Expose
    public String totalAmt;
    @SerializedName("discount")
    @Expose
    public String discount;
    @SerializedName("payment_status")
    @Expose
    public String paymentStatus;
    @SerializedName("booking_id")
    @Expose
    public String bookingId;
    @SerializedName("transaction_id")
    @Expose
    public String transactionId;
    @SerializedName("point")
    @Expose
    public String point;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("strotime")
    @Expose
    public String strotime;
    @SerializedName("seat_no")
    @Expose
    public String seatNo;
    @SerializedName("result")
    @Expose
    public String result;

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getRouteId() {
        return routeId;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public Object getFromTo() {
        return fromTo;
    }

    public Object getToFrom() {
        return toFrom;
    }

    public Object getVehicleType() {
        return vehicleType;
    }

    public String getRouteDate() {
        return routeDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getTimeDuration() {
        return timeDuration;
    }

    public String getRouteDistance() {
        return routeDistance;
    }

    public String getMealId() {
        return mealId;
    }

    public String getDropId() {
        return dropId;
    }

    public String getTicketFare() {
        return ticketFare;
    }

    public String getMeal() {
        return meal;
    }

    public String getTotalAmt() {
        return totalAmt;
    }

    public String getDiscount() {
        return discount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getPoint() {
        return point;
    }

    public String getStatus() {
        return status;
    }

    public String getStrotime() {
        return strotime;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public String getResult() {
        return result;
    }
}
