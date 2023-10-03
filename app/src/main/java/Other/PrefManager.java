package Other;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Context context;

    //shared pref mode
    private int PRIVATE_MODE = 0;

    //shared preferences file name
    private static final String PREF_NAME = "Itamoto-app";



    private static final String USER_ID = "user_id";

    private static final String USER_MOBILE = "user_mobile";
    private static final String USER_PASSWORD = "user_password";
    private static final String IS_LOGGED_IN = "is_logged_in";

    public PrefManager(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = preferences.edit();
    }

    public void setUserId(String userId) {
        editor.putString(USER_ID, userId);
        editor.commit();
    }

    public String getUserId() {
        return preferences.getString(USER_ID, null);
    }

    public void setIsLoggedIn(boolean isLoggedIn) {
        editor.putBoolean(IS_LOGGED_IN, isLoggedIn);
        editor.commit();
    }

    public boolean isLoggedIn() {
        return preferences.getBoolean(IS_LOGGED_IN, false);
    }

    public void setUserMobile(String userMobile) {
        editor.putString(USER_MOBILE, userMobile);
        editor.commit();
    }

    public String getUserMobile() {
        return preferences.getString(USER_MOBILE, null);
    }

    public void setUserPassword(String password) {
        editor.putString(USER_PASSWORD, password);
        editor.commit();
    }

    public String getUserPassword() {
        return preferences.getString(USER_PASSWORD, null);
    }


    public void logout() {
        editor.clear();
        editor.apply();

    }
}
