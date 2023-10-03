package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OfferImage {

    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("img")
    @Expose
    public String img;
    @SerializedName("path")
    @Expose
    public String path;

    public String getTitle() {
        return title;
    }

    public String getImg() {
        return img;
    }

    public String getPath() {
        return path;
    }
}

