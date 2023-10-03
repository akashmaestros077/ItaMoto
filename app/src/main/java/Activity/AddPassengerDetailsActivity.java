package Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.itamoto.R;

public class AddPassengerDetailsActivity extends AppCompatActivity {
ImageView image_back ;
TextView text_add_more;
MaterialButton save_btn;
Spinner sp_pickup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_passenger_details);

        image_back = findViewById(R.id.image_back);
        text_add_more = findViewById(R.id.text_add_more);
        save_btn = findViewById(R.id.save_btn);
        sp_pickup = findViewById(R.id.sp_pickup);

        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddPassengerDetailsActivity.this,ChooseSeatActivity.class));
            }
        });
        text_add_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddPassengerDetailsActivity.this,PickupLocationActivity.class));
            }
        });
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddPassengerDetailsActivity.this,ConfirmDetailsAndPayActivity.class));
            }
        });


    }
}