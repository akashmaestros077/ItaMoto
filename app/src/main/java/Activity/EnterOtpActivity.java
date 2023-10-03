package Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.google.android.material.button.MaterialButton;
import com.itamoto.R;

import Model.NewPassword;
import Model.OtpVerify;
import Model.SendOtp;
import Model.Vehical;
import Other.ApiInterface;
import Other.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EnterOtpActivity extends AppCompatActivity {
    MaterialButton verify_btn;
    PinView  pinview;
    ApiInterface apiInterface;
    RetrofitClient retrofitClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_otp);

        verify_btn = findViewById(R.id.verify_btn);
        pinview = findViewById(R.id.pinview);
        apiInterface = RetrofitClient.getClient().create(ApiInterface.class);

        verify_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (pinview.getText().toString().equals("")) {
                    Toast.makeText(EnterOtpActivity.this, "Please Enter OTP", Toast.LENGTH_SHORT).show();
                }
                verifyOtp();
            }

        });}

    private void verifyOtp() {
        String Otp = pinview.getText().toString().trim();

        Call<OtpVerify> call = apiInterface.verify(Otp);
        call.enqueue(new Callback<OtpVerify>() {

 @Override
            public void onResponse(Call<OtpVerify> call, Response<OtpVerify> response) {
                if (response.isSuccessful() && response.body() != null) {
                    OtpVerify otpVerify = response.body();
                    if (otpVerify.getMsg() != null && otpVerify.getMsg().equals("verify successfully")) {
                        Toast.makeText(EnterOtpActivity.this, "" + otpVerify.getMsg(), Toast.LENGTH_SHORT).show();
                        Log.e("messssaaagggge", "onResponse: " + otpVerify.getMsg());
                        startActivity(new Intent(EnterOtpActivity.this, NewPasswordActivity.class));
                    } else {
                        Toast.makeText(EnterOtpActivity.this, "" + otpVerify.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Handle the case where response is not successful or body is null
                }
            }



            @Override
            public void onFailure(Call<OtpVerify> call, Throwable t) {

            }
        });

    }
}