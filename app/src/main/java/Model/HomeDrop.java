package Model;

import com.google.gson.annotations.SerializedName;

import kotlin.jvm.internal.SerializedIr;

public class HomeDrop {

    @SerializedName("result")
    String result;

    public String getResult() {
        return result;
    }
}
