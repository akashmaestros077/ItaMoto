package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContactUs {
    @SerializedName("result")
    @Expose
    public String result;

    public String getResult() {
        return result;
    }
}
