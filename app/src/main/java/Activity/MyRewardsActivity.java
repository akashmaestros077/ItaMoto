package Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.itamoto.R;

public class MyRewardsActivity extends AppCompatActivity {
ImageView image_back;
ProgressBar progresssBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_rewards);
        image_back = findViewById(R.id.image_back);
        progresssBar = findViewById(R.id.progresssBar);


        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progresssBar.setVisibility(View.VISIBLE);
                startActivity(new Intent(MyRewardsActivity.this,WalletActivity.class));
                finish();
            }
        });
    }
}