package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OtpVerify {
    @SerializedName("msg")
    @Expose
    public String msg;

    public String getMsg() {
        return msg;
    }
}
