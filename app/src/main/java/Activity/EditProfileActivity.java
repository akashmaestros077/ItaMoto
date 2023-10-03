package Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.itamoto.R;

import Model.EditProfile;
import Model.ShowEditProfile;
import Other.ApiInterface;
import Other.PrefManager;
import Other.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfileActivity extends AppCompatActivity {
ImageView image_back ;
TextView save_profile_btn;
EditText first_name,last_name,edit_number,address;
ApiInterface apiInterface;
RetrofitClient retrofitClient;
private PrefManager prefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        image_back = findViewById(R.id.image_back);
        save_profile_btn = findViewById(R.id.save_profile_btn);
        first_name = findViewById(R.id.first_name);
        last_name = findViewById(R.id.last_name);
        edit_number = findViewById(R.id.edit_number);
        address = findViewById(R.id.address);

        prefManager = new PrefManager(this);
        apiInterface = RetrofitClient.getClient().create(ApiInterface.class);

        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EditProfileActivity.this,ProfileActivity.class));
            }
        });
        save_profile_btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(first_name.getText().toString().equals( "" )){
                    Toast.makeText(EditProfileActivity.this,"Please Enter First Name",Toast.LENGTH_SHORT).show();
                }
                else if(last_name.getText().toString().equals( "" )){
                    Toast.makeText(EditProfileActivity.this,"Please Enter Last Name",Toast.LENGTH_SHORT).show();
                }
                else if(edit_number.getText().toString().equals( "" )){
                    Toast.makeText(EditProfileActivity.this,"Please Enter Mobile Number",Toast.LENGTH_SHORT).show();
                }
                else if(address.getText().toString().equals( "" )){
                    Toast.makeText(EditProfileActivity.this,"Please Enter Address",Toast.LENGTH_SHORT).show();
                }
                editProfile();
            }
        } );
    }

    private void editProfile() {
        String UserId = prefManager.getUserId();
        String FirstName = first_name.getText().toString().trim();
        String LastName = last_name.getText().toString().trim();
        String Mobile = edit_number.getText().toString().trim();
        String Address = address.getText().toString().trim();
        Call<EditProfile> call = apiInterface.profile( UserId ,Mobile,Address,FirstName,LastName);
        call.enqueue( new Callback<EditProfile>() {
            @Override
            public void onResponse(Call<EditProfile> call, Response<EditProfile> response) {
                if (response.body().getMessage().equals( " profile  Update successfully" )){
                    Toast.makeText( EditProfileActivity.this,""+response.body().getMessage(),Toast.LENGTH_SHORT ).show();
                    startActivity( new Intent(EditProfileActivity.this,ProfileActivity.class) );

                }
                else{
                    Toast.makeText( EditProfileActivity.this,""+response.body().getMessage(),Toast.LENGTH_SHORT ).show();

                }
            }

            @Override
            public void onFailure(Call<EditProfile> call, Throwable t) {

            }
        } );



    }
    }
