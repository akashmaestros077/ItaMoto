package Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.itamoto.R;

import Adapter.OnbordingAdapter;
import Model.LoginModel;
import Model.OnbordingModel;
import Other.ApiInterface;
import Other.PrefManager;
import Other.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
TextView text_signup,text_forgotPass;
MaterialButton login_btn;
ViewPager vp_onbording;
OnbordingAdapter onbordingAdapter;
OnbordingModel model;
ApiInterface apiInterface;
RetrofitClient retrofitClient;
EditText edit_number,edit_password;
PrefManager prefManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        text_signup = findViewById(R.id.text_signup);
        text_forgotPass = findViewById(R.id.text_forgotPass);
        login_btn = findViewById(R.id.login_btn);
        apiInterface = RetrofitClient.getClient().create(ApiInterface.class);
        edit_password = findViewById(R.id.edit_password);
        edit_number = findViewById(R.id.edit_number);
        prefManager = new PrefManager(this);



        text_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
            }
        });
        text_forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,ForgotPasswordActivity.class));
            }
        });
            login_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(edit_number.getText().toString().equals("")){

                        Toast.makeText(LoginActivity.this,"Please Enter Mobile Number",Toast.LENGTH_SHORT).show();
                    }
                    else if(edit_password.getText().toString().equals("")){
                        Toast.makeText(LoginActivity.this,"Please Enter Password",Toast.LENGTH_SHORT).show();
                    }
                    getLogin();
                }
            });

    }

    private void getLogin() {
        String Mobile = edit_number.getText().toString().trim();
        String Password = edit_password.getText().toString().trim();
        Call<LoginModel> call = apiInterface.login(Mobile,Password);
        call.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                if(response.body().getResult().equals("Login Successfull")){
                    prefManager.setUserId(response.body().id);
                    prefManager.setUserMobile(response.body().mobile);
                    prefManager.getUserPassword();
                    prefManager.setIsLoggedIn(true);

                    Log.e("jjj", "onResponse: "+response.body().id );
                    Toast.makeText(LoginActivity.this, ""+response.body().getResult(), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                }
                else {
                    Toast.makeText(LoginActivity.this, ""+response.body().getResult(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {

            }
        });
    }
}