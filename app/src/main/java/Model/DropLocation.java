package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DropLocation {
    @SerializedName("location")
    @Expose
    public String location;

    public String getLocation() {
        return location;
    }
}
