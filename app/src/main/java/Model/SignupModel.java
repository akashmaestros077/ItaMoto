package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignupModel {


    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("first_name")
    @Expose
    public String firstName;
    @SerializedName("last_name")
    @Expose
    public String lastName;
    @SerializedName("mobile")
    @Expose
    public String mobile;
    @SerializedName("national_id")
    @Expose
    public Object nationalId;
    @SerializedName("address")
    @Expose
    public String address;
    @SerializedName("img")
    @Expose
    public Object img;
    @SerializedName("password")
    @Expose
    public Object password;
    @SerializedName("confirm_password")
    @Expose
    public Object confirmPassword;
    @SerializedName("refer_code")
    @Expose
    public String referCode;
    @SerializedName("point")
    @Expose
    public String point;
    @SerializedName("otp")
    @Expose
    public Object otp;
    @SerializedName("otp_varify_status")
    @Expose
    public String otpVarifyStatus;
    @SerializedName("result")
    @Expose
    public String result;

    public String getId() {
        return id;
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

    public Object getNationalId() {
        return nationalId;
    }

    public String getAddress() {
        return address;
    }

    public Object getImg() {
        return img;
    }

    public Object getPassword() {
        return password;
    }

    public Object getConfirmPassword() {
        return confirmPassword;
    }

    public String getReferCode() {
        return referCode;
    }

    public String getPoint() {
        return point;
    }

    public Object getOtp() {
        return otp;
    }

    public String getOtpVarifyStatus() {
        return otpVarifyStatus;
    }

    public String getResult() {
        return result;
    }
}
