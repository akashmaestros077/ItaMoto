package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StartPoinEndPoint {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("points")
    @Expose
    public String points;
    @SerializedName("status")
    @Expose
    public String status;

    public String getId() {
        return id;
    }

    public String getPoints() {
        return points;
    }

    public String getStatus() {
        return status;
    }
}
