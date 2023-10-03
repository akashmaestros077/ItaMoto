package Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.itamoto.R;

public class WalletActivity extends AppCompatActivity {
ImageView image_back ;
TextView text_addmny;
ProgressBar progresssBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        image_back = findViewById(R.id.image_back);
        progresssBar = findViewById(R.id.progresssBar);
        text_addmny = findViewById(R.id.text_addmny);

        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progresssBar.setVisibility(View.VISIBLE);
                finish();
            }
        });
        text_addmny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progresssBar.setVisibility(View.VISIBLE);
                startActivity(new Intent(WalletActivity.this, MyRewardsActivity.class));
            }
        });
    }
}