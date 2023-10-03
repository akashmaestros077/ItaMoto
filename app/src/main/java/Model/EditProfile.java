package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EditProfile {

    @SerializedName("user_id")
    @Expose
    public String userId;
    @SerializedName("first_name")
    @Expose
    public String firstName;
    @SerializedName("last_name")
    @Expose
    public String lastName;
    @SerializedName("mobile")
    @Expose
    public String mobile;
    @SerializedName("address")
    @Expose
    public String address;
    @SerializedName("img")
    @Expose
    public Object img;
    @SerializedName("path")
    @Expose
    public String path;
    @SerializedName("result")
    @Expose
    public String result;
    @SerializedName("message")
    @Expose
    public String message;

    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAddress() {
        return address;
    }

    public Object getImg() {
        return img;
    }

    public String getPath() {
        return path;
    }

    public String getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }
}
