package Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.itamoto.R;

import Other.PrefManager;

public class SplashScreenActivity extends AppCompatActivity {
    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        prefManager = new PrefManager(this);

        boolean isLoggedIn = prefManager.isLoggedIn();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isLoggedIn) {
                    Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(i);
                } else {
                    Intent i = new Intent(SplashScreenActivity.this, OnbordingActivity.class);
                    startActivity(i);
                }

                finish();
            }
        }, 5000);
    }
}
