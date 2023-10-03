package Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.itamoto.R;

import Model.ContactUs;
import Other.ApiInterface;
import Other.PrefManager;
import Other.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContactUsActivity extends AppCompatActivity {
EditText edit_name;
EditText edit_email;
EditText edit_msg;
MaterialButton send_msg_btn;
ApiInterface apiInterface;
ImageView image_back ;
ProgressBar progresssBar;
PrefManager prefManager;
RetrofitClient retrofitClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        edit_name = findViewById(R.id.edit_name);
        edit_email = findViewById(R.id.edit_email);
        edit_msg = findViewById(R.id.edit_msg);
        send_msg_btn = findViewById(R.id.send_msg_btn);
        image_back = findViewById(R.id.image_back);
        progresssBar = findViewById(R.id.progresssBar);
        apiInterface = RetrofitClient.getClient().create(ApiInterface.class);
        prefManager = new PrefManager(this);

        send_msg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progresssBar.setVisibility(View.VISIBLE);
                String id = prefManager.getUserId();
                String name = edit_name.getText().toString().trim();
                String email = edit_email.getText().toString().trim();
                String msg = edit_msg.getText().toString().trim();

                Call<ContactUs> call = apiInterface.contact(id,name,email,msg);
                call.enqueue(new Callback<ContactUs>() {
                    @Override
                    public void onResponse(Call<ContactUs> call, Response<ContactUs> response) {
                        progresssBar.setVisibility(View.GONE);
                        if(edit_name.getText().toString().equals("")){
                            Toast.makeText(ContactUsActivity.this,"Please Enter Name",Toast.LENGTH_SHORT).show();
                        }
                       else if(edit_email.getText().toString().equals("")){
                            Toast.makeText(ContactUsActivity.this,"Please Enter Email",Toast.LENGTH_SHORT).show();
                        }
                       else if(edit_msg.getText().toString().equals("")){
                            Toast.makeText(ContactUsActivity.this,"Please Enter Msg",Toast.LENGTH_SHORT).show();
                        }
                       Toast.makeText(ContactUsActivity.this,""+response.body().getResult(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ContactUs> call, Throwable t) {

                    }
                });
            }
        });
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
    }
}