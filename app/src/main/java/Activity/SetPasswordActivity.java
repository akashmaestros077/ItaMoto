package Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.itamoto.R;

import Model.SetPassword;
import Other.ApiInterface;
import Other.PrefManager;
import Other.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SetPasswordActivity extends AppCompatActivity {
MaterialButton save_btn ;
EditText edit_password,edit_confirm_pas;
ApiInterface apiInterface;
RetrofitClient retrofitClient;
private PrefManager prefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_password);
        save_btn = findViewById(R.id.save_btn);
        edit_password = findViewById(R.id.edit_password);
        edit_confirm_pas = findViewById(R.id.edit_confirm_pas);

        prefManager = new PrefManager(this);
        apiInterface = RetrofitClient.getClient().create(ApiInterface.class);

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edit_password.getText().toString().equals("")){
                    Toast.makeText(SetPasswordActivity.this,"Please Enter Password",Toast.LENGTH_SHORT).show();
                }
                else if (edit_confirm_pas.getText().toString().equals("")){
                    Toast.makeText(SetPasswordActivity.this,"Please Re-Enter Password",Toast.LENGTH_SHORT).show();
                }
                setPassword();
            }
        });


    }

    private void setPassword() {

        String Id = prefManager.getUserId();
        String Password = edit_password.getText().toString().trim();
        String Confirm_pas = edit_confirm_pas.getText().toString().trim();

        Call<SetPassword> call = apiInterface.setPassword(Id,Password,Confirm_pas);
        call.enqueue(new Callback<SetPassword>() {
            @Override
            public void onResponse(Call<SetPassword> call, Response<SetPassword> response) {
                if(response.body().getMessage().equals("set password successfully")){

                    Toast.makeText(SetPasswordActivity.this,""+response.body().getMessage(),Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SetPasswordActivity.this,LoginActivity.class));
                }
                else {
                    Toast.makeText(SetPasswordActivity.this,""+response.body().getMessage(),Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<SetPassword> call, Throwable t) {

            }
        });

    }
}