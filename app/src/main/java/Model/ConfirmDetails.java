package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConfirmDetails {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("route_id")
    @Expose
    private String routeId;
    @SerializedName("passenger_id")
    @Expose
    private String passengerId;
    @SerializedName("from_to")
    @Expose
    private String fromTo;
    @SerializedName("to_from")
    @Expose
    private String toFrom;
    @SerializedName("vehicle_type")
    @Expose
    private String vehicleType;
    @SerializedName("route_date")
    @Expose
    private String routeDate;
    @SerializedName("start_time")
    @Expose
    private String startTime;
    @SerializedName("end_time")
    @Expose
    private String endTime;
    @SerializedName("time_duration")
    @Expose
    private String timeDuration;
    @SerializedName("route_distance")
    @Expose
    private String routeDistance;
    @SerializedName("meal_id")
    @Expose
    private String mealId;
    @SerializedName("drop_id")
    @Expose
    private String dropId;
    @SerializedName("ticket_fare")
    @Expose
    private Object ticketFare;
    @SerializedName("meal")
    @Expose
    private Object meal;
    @SerializedName("total_amt")
    @Expose
    private Object totalAmt;
    @SerializedName("discount")
    @Expose
    private Object discount;
    @SerializedName("payment_status")
    @Expose
    private String paymentStatus;
    @SerializedName("booking_id")
    @Expose
    private Object bookingId;
    @SerializedName("transaction_id")
    @Expose
    private Object transactionId;
    @SerializedName("point")
    @Expose
    private Object point;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("strotime")
    @Expose
    private String strotime;
    @SerializedName("result")
    @Expose
    private String result;
    private final static long serialVersionUID = 2931791965013207556L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public String getFromTo() {
        return fromTo;
    }

    public void setFromTo(String fromTo) {
        this.fromTo = fromTo;
    }

    public String getToFrom() {
        return toFrom;
    }

    public void setToFrom(String toFrom) {
        this.toFrom = toFrom;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getRouteDate() {
        return routeDate;
    }

    public void setRouteDate(String routeDate) {
        this.routeDate = routeDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(String timeDuration) {
        this.timeDuration = timeDuration;
    }

    public String getRouteDistance() {
        return routeDistance;
    }

    public void setRouteDistance(String routeDistance) {
        this.routeDistance = routeDistance;
    }

    public String getMealId() {
        return mealId;
    }

    public void setMealId(String mealId) {
        this.mealId = mealId;
    }

    public String getDropId() {
        return dropId;
    }

    public void setDropId(String dropId) {
        this.dropId = dropId;
    }

    public Object getTicketFare() {
        return ticketFare;
    }

    public void setTicketFare(Object ticketFare) {
        this.ticketFare = ticketFare;
    }

    public Object getMeal() {
        return meal;
    }

    public void setMeal(Object meal) {
        this.meal = meal;
    }

    public Object getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(Object totalAmt) {
        this.totalAmt = totalAmt;
    }

    public Object getDiscount() {
        return discount;
    }

    public void setDiscount(Object discount) {
        this.discount = discount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Object getBookingId() {
        return bookingId;
    }

    public void setBookingId(Object bookingId) {
        this.bookingId = bookingId;
    }

    public Object getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Object transactionId) {
        this.transactionId = transactionId;
    }

    public Object getPoint() {
        return point;
    }

    public void setPoint(Object point) {
        this.point = point;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStrotime() {
        return strotime;
    }

    public void setStrotime(String strotime) {
        this.strotime = strotime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
