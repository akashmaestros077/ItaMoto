package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vehical {


    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("vehicle_type")
    @Expose
    public String vehicleType;

    public String getId() {
        return id;
    }

    public String getVehicleType() {
        return vehicleType;
    }
}

