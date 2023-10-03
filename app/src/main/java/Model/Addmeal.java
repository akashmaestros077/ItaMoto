package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Addmeal {
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("data")
    @Expose
    public Mealdata data;

    public String getStatus() {
        return status;
    }

    public Mealdata getData() {
        return data;
    }

    private class Mealdata {
        @SerializedName("id")
        @Expose
        public String id;
        @SerializedName("route")
        @Expose
        public String route;
        @SerializedName("category")
        @Expose
        public String category;
        @SerializedName("meal")
        @Expose
        public String meal;
        @SerializedName("pricing")
        @Expose
        public String pricing;

        public String getId() {
            return id;
        }

        public String getRoute() {
            return route;
        }

        public String getCategory() {
            return category;
        }

        public String getMeal() {
            return meal;
        }

        public String getPricing() {
            return pricing;
        }
    }
}
