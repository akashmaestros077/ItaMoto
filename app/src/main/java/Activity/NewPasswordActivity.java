package Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.itamoto.R;

import Model.NewPassword;
import Other.ApiInterface;
import Other.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewPasswordActivity extends AppCompatActivity {
EditText new_password;
EditText confirm_password;
MaterialButton submit_btn;
ApiInterface apiInterface;
RetrofitClient retrofitClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password);

        new_password =findViewById(R.id.new_password);
        confirm_password = findViewById(R.id.confirm_password);
        submit_btn = findViewById(R.id.submit_btn);
        apiInterface = RetrofitClient.getClient().create(ApiInterface.class);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Password = new_password.getText().toString().trim();
                String COnfirmPassword = confirm_password.getText().toString().trim();
                Call <NewPassword> call = apiInterface.newPassword(Password,COnfirmPassword);
                call.enqueue(new Callback<NewPassword>() {
                    @Override
                    public void onResponse(Call<NewPassword> call, Response<NewPassword> response) {
                        if(new_password.getText().toString().equals("")){
                            Toast.makeText(NewPasswordActivity.this,"Please Enter New Password",Toast.LENGTH_SHORT).show();
                        }
                        else if(confirm_password.getText().toString().equals("")){
                        Toast.makeText(NewPasswordActivity.this,"Please Enter New Password",Toast.LENGTH_SHORT).show();
                        }
                        Toast.makeText(NewPasswordActivity.this,""+response.body().getMessage(),Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(NewPasswordActivity.this,LoginActivity.class));
                    }

                    @Override
                    public void onFailure(Call<NewPassword> call, Throwable t) {

                    }
                });

            }
        });



    }
}