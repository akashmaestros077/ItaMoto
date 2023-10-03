package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ChooseSeat implements Serializable {

    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("data")
    @Expose
    public SeatData data;

    public String getMessage() {
        return message;
    }

    public SeatData getData() {
        return data;
    }

    public class SeatData {
        @SerializedName("id")
        @Expose
        public String id;
        @SerializedName("route_date")
        @Expose
        public String routeDate;
        @SerializedName("from_to")
        @Expose
        public String fromTo;
        @SerializedName("to_from")
        @Expose
        public String toFrom;
        @SerializedName("vehicle_type")
        @Expose
        public String vehicleType;
        @SerializedName("vehicle_sub_type")
        @Expose
        public Object vehicleSubType;
        @SerializedName("boarding")
        @Expose
        public Object boarding;
        @SerializedName("droping")
        @Expose
        public Object droping;
        @SerializedName("no_seat")
        @Expose
        public String noSeat;
        @SerializedName("prize")
        @Expose
        public String prize;
        @SerializedName("single_seat_prize")
        @Expose
        public String singleSeatPrize;
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
        @SerializedName("from")
        @Expose
        public String from;
        @SerializedName("to")
        @Expose
        public String to;

        public String getId() {
            return id;
        }

        public String getRouteDate() {
            return routeDate;
        }

        public String getFromTo() {
            return fromTo;
        }

        public String getToFrom() {
            return toFrom;
        }

        public String getVehicleType() {
            return vehicleType;
        }

        public Object getVehicleSubType() {
            return vehicleSubType;
        }

        public Object getBoarding() {
            return boarding;
        }

        public Object getDroping() {
            return droping;
        }

        public String getNoSeat() {
            return noSeat;
        }

        public String getPrize() {
            return prize;
        }

        public String getSingleSeatPrize() {
            return singleSeatPrize;
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

        public String getFrom() {
            return from;
        }

        public String getTo() {
            return to;
        }
    }
    }

