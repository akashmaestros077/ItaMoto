package Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.itamoto.R;

import Model.ConfirmDetails;
import Model.PayNow;
import Model.PaymentDetails;
import Other.ApiInterface;
import Other.PrefManager;
import Other.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;

public class PaymentActivity extends AppCompatActivity {
MaterialButton payNow_btn;
ProgressBar progressBar;
ApiInterface apiInterface;
RetrofitClient retrofitClient;
private PrefManager prefManager;
ConfirmDetails confirmDetails;
TextView ticket_fare,meal,offer_code,point,total_ammount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        payNow_btn = findViewById(R.id.payNow_btn);
        progressBar = findViewById(R.id.progressBar);
        ticket_fare = findViewById(R.id.ticket_fare);
        meal = findViewById(R.id.meal);
        offer_code = findViewById(R.id.offer_code);
        point = findViewById(R.id.point);
        total_ammount = findViewById(R.id.total_ammount);

        confirmDetails = getIntent().getParcelableExtra("paymenrt");

        prefManager = new PrefManager(this);

        paymentDetails();

        apiInterface = RetrofitClient.getClient().create(ApiInterface.class);


        payNow_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                payNow();
                startActivity(new Intent(PaymentActivity.this,BookingDoneActivity.class));
            }
        });
    }

    private void paymentDetails() {
        String user_id = prefManager.getUserId();
        String route_id = "1";

        Call<PaymentDetails> call = apiInterface.payment(user_id,route_id);
        call.enqueue(new Callback<PaymentDetails>() {
            @Override
            public void onResponse(Call<PaymentDetails> call, Response<PaymentDetails> response) {
                if(response.isSuccessful()){
                    ticket_fare.setText(confirmDetails.getTicketFare().toString());
                    meal.setText(confirmDetails.getMeal().toString());


                }
            }

            @Override
            public void onFailure(Call<PaymentDetails> call, Throwable t) {

            }
        });
    }

    private void payNow() {
        String user_id = prefManager.getUserId();
        String route_id = "13";
        String PassengerId = "31";
        String ticket_fare = "1000";
        String meal = "200";
        String total_amt = "5000";
        String transaction_id = "20230523010890000867733905552562556";
        String payment_status = "1";
        Call<PayNow> call = apiInterface.payNow(user_id, route_id, PassengerId, ticket_fare, meal, total_amt, transaction_id, payment_status);

        call.enqueue(new Callback<PayNow>() {
            @Override
            public void onResponse(Call<PayNow> call, Response<PayNow> response) {
                if(response.isSuccessful()){
                    Toast.makeText(PaymentActivity.this,""+response.body().getResult(),Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(PaymentActivity.this,""+response.body().getResult(),Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<PayNow> call, Throwable t) {

            }

        });
    }}