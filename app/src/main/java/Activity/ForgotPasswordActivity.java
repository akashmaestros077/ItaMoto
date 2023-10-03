package Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.itamoto.R;

import java.util.Calendar;

import Model.SendOtp;
import Other.ApiInterface;
import Other.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPasswordActivity extends AppCompatActivity {
MaterialButton otp_btn ;
EditText edit_number ;
ApiInterface apiInterface;
RetrofitClient retrofitClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        otp_btn = findViewById(R.id.otp_btn);
        edit_number = findViewById(R.id.edit_number);
        apiInterface = RetrofitClient.getClient().create(ApiInterface.class);


        otp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit_number.getText().toString().equals("")){
                    Toast.makeText(ForgotPasswordActivity.this,"Please Enter Monile Number",Toast.LENGTH_SHORT).show();

                }
                getOtp();
            }
        });

    }

    private void getOtp() {
        String Mobile = edit_number.getText().toString().trim();
        Call<SendOtp> call = apiInterface.sendOtp(Mobile);
        call.enqueue(new Callback<SendOtp>() {
            @Override
            public void onResponse(Call<SendOtp> call, Response<SendOtp> response) {

               if(response.body().getMessage().equals("Send OTP successfully")) {

                    Toast.makeText(ForgotPasswordActivity.this,""+response.body().getMessage(),Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ForgotPasswordActivity.this,EnterOtpActivity.class));

                }
               else{
                   Toast.makeText(ForgotPasswordActivity.this,""+response.body().getMessage(),Toast.LENGTH_SHORT).show();

               }
            }

            @Override
            public void onFailure(Call<SendOtp> call, Throwable t) {

            }
        });
    }
}