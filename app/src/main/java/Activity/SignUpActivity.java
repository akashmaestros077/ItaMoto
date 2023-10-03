package Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.itamoto.R;

import Model.SignupModel;
import Other.ApiInterface;
import Other.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
TextView text_login;
MaterialButton signup_btn;
ApiInterface apiInterface;
RetrofitClient retrofitClient;
EditText edit_first_name,edit_last_name,edit_number,edit_address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        text_login =findViewById(R.id.text_login);
        edit_first_name = findViewById(R.id.edit_first_name);
        edit_last_name = findViewById(R.id.edit_last_name);
        edit_number = findViewById(R.id.edit_number);
        edit_address = findViewById(R.id.edit_address);
        signup_btn = findViewById(R.id.signup_btn);
        apiInterface = RetrofitClient.getClient().create(ApiInterface.class);




        text_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
            }

        });

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit_first_name.getText().toString().equals("")){
                    Toast.makeText(SignUpActivity.this,"Please Enter Your First Name",Toast.LENGTH_SHORT).show();
                }

                else if (edit_last_name.getText().toString().equals("")){
                    Toast.makeText(SignUpActivity.this,"Please Enter Your Last Name",Toast.LENGTH_SHORT).show();
                }

                else if (edit_number.getText().toString().equals("")){
                    Toast.makeText(SignUpActivity.this,"Please Enter Your Mobile Number",Toast.LENGTH_SHORT).show();
                }
                else if (edit_address.getText().toString().equals("")){
                    Toast.makeText(SignUpActivity.this,"Please Enter Your Address",Toast.LENGTH_SHORT).show();
                }
                getSignup();

            }
        });
    }

    private void getSignup() {

        String First_name = edit_first_name.getText().toString().trim();
        String last_name = edit_last_name.getText().toString().trim();
        String Edit_number = edit_number.getText().toString().trim();
        String Address = edit_address.getText().toString().trim();

        Call<SignupModel> call = apiInterface.signup(First_name,last_name,Edit_number,Address);
        call.enqueue(new Callback<SignupModel>() {
            @Override
            public void onResponse(Call<SignupModel> call, Response<SignupModel> response) {
                if(response.body().getResult().equals("signup Successfull")){
                    Toast.makeText(SignUpActivity.this,""+response.body().getResult(),Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUpActivity.this, SetPasswordActivity.class));
                }
                else {
                    Toast.makeText(SignUpActivity.this,""+response.body().getResult(),Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<SignupModel> call, Throwable t) {

            }
        });



    }
}