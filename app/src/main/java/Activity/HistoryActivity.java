package Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.itamoto.R;

import java.util.Stack;

import fragment.CanceledJourneyFragment;
import fragment.CompletedJourneyFragment;
import fragment.HomeFragment;
import fragment.UpcomingJourneyFragment;

public class HistoryActivity extends AppCompatActivity {


    ImageView image_back;
    TextView text_upcom,text_completed,text_cancel;
    RelativeLayout rl_upcome,rl_completed,rl_cancel;
    ProgressBar progresabar ;
    FrameLayout history_fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        image_back = findViewById(R.id.image_back);
        text_upcom = findViewById(R.id.text_upcom);
        text_completed = findViewById(R.id.text_completed);
        text_cancel = findViewById(R.id.text_cancel);
        rl_upcome = findViewById(R.id.rl_upcome);
        rl_completed = findViewById(R.id.rl_completed);
        rl_cancel = findViewById(R.id.rl_cancel);
        progresabar = findViewById(R.id.progresabar);
        history_fragment = findViewById(R.id.history_fragment);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.history_fragment, new UpcomingJourneyFragment()).addToBackStack(null).commit();

        }


        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }

        });

        text_upcom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progresabar.setVisibility(View.GONE);

                text_upcom.setVisibility(View.GONE);
                text_completed.setVisibility(View.VISIBLE);
                text_cancel.setVisibility(View.VISIBLE);

                rl_upcome.setVisibility(View.VISIBLE);
                rl_completed.setVisibility(View.GONE);
                rl_cancel.setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction().replace(R.id.history_fragment, new UpcomingJourneyFragment()).addToBackStack(null).commit();



            }
        });
        text_completed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progresabar.setVisibility(View.GONE);

                text_upcom.setVisibility(View.VISIBLE);
                text_completed.setVisibility(View.GONE);
                text_cancel.setVisibility(View.VISIBLE);

                rl_upcome.setVisibility(View.GONE);
                rl_completed.setVisibility(View.VISIBLE);
                rl_cancel.setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction().replace(R.id.history_fragment, new CompletedJourneyFragment()).addToBackStack(null).commit();

            }
        });
        text_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progresabar.setVisibility(View.GONE);

                text_upcom.setVisibility(View.VISIBLE);
                text_completed.setVisibility(View.VISIBLE);
                text_cancel.setVisibility(View.GONE);

                rl_upcome.setVisibility(View.GONE);
                rl_completed.setVisibility(View.GONE);
                rl_cancel.setVisibility(View.VISIBLE);
                getSupportFragmentManager().beginTransaction().replace(R.id.history_fragment, new CanceledJourneyFragment()).addToBackStack(null).commit();

            }
        });

    }
}