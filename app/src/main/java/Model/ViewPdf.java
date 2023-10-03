package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ViewPdf {
    @SerializedName("path")
    @Expose
    public String path;
    @SerializedName("msg")
    @Expose
    public String msg;

    public String getPath() {
        return path;
    }

    public String getMsg() {
        return msg;
    }
}
