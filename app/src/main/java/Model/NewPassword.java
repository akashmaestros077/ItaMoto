package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewPassword {
    @SerializedName("message")
    @Expose
    public String message;

    public String getMessage() {
        return message;
    }
}
