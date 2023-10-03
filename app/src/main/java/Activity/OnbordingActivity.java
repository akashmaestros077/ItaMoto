package Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.itamoto.R;

import java.util.ArrayList;
import java.util.Arrays;

import Adapter.OnbordingAdapter;
import Model.OnbordingModel;

public class OnbordingActivity extends AppCompatActivity {
    ViewPager vp_onbording;
    OnbordingAdapter adapter;
    ArrayList<OnbordingModel> models = new ArrayList<>();
    MaterialButton next_btn ;
    int screen [] = {R.layout.onbordingscreen_one,R.layout.onbording_two,R.layout.onbordingscreen_three};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onbording);

        vp_onbording=findViewById(R.id.vp_onbording);
        next_btn = findViewById(R.id.next_btn);

        adapter = new OnbordingAdapter(OnbordingActivity.this, screen);
        vp_onbording.setAdapter(adapter);

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OnbordingActivity.this,LoginActivity.class));
            }
        });

    }
}