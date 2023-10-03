package Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.PeriodicSync;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.itamoto.R;

import Model.EditProfile;
import Model.ShowEditProfile;
import Other.ApiInterface;
import Other.PrefManager;
import Other.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {
ImageView image_back,edit_profile_btn,profile_img,camera_btn;
ApiInterface apiInterface ;
RetrofitClient retrofitClient;
TextView text_address,text_number,text_name,text_firstname,text_Lastname;
EditProfile editProfile;
 private  PrefManager prefManager;
    private static final int PICK_IMAGE_REQUEST = 1;
    private static final int PERMISSION_REQUEST_CODE = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        edit_profile_btn = findViewById(R.id.edit_profile_btn);
        image_back = findViewById(R.id.image_back);
        profile_img = findViewById( R.id.profile_img);
        camera_btn = findViewById( R.id.camera_btn);
        text_number = findViewById( R.id.text_number );
        text_address = findViewById( R.id.text_address );
        text_firstname = findViewById( R.id.text_firstname );
        text_Lastname = findViewById( R.id.text_Lastname );
        prefManager = new PrefManager(this);
        apiInterface = RetrofitClient.getClient().create( ApiInterface.class );

        showProfile();

        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this,MainActivity.class));
            }
        });
        camera_btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }

        } );
        edit_profile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this,EditProfileActivity.class));
            }
        });

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    PERMISSION_REQUEST_CODE);
        }

    }

    private void showProfile() {
        String UserId = prefManager.getUserId();
        String FirstName = text_firstname.toString().trim();
        String LastName = text_Lastname.toString().trim();
        String Mobile = text_number.toString().trim();
        String Address = text_address.toString().trim();
        Call<ShowEditProfile> call = apiInterface.showProfile( UserId,Mobile ,Address,FirstName,LastName);
        call.enqueue( new Callback<ShowEditProfile>() {
            @Override
            public void onResponse(Call<ShowEditProfile> call, Response<ShowEditProfile> response) {
                if(response.body().getMessage().equals( " profile  Show successfully" )){
                    text_number.setText(response.body().mobile);
                    text_address.setText(response.body().address);
                    text_firstname.setText(response.body().firstName);
                    text_Lastname.setText(response.body().lastName);
                }
            }

            @Override
            public void onFailure(Call<ShowEditProfile> call, Throwable t) {

            }
        } );
    }

    public void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            Uri imageUri = data.getData();

            // Load the image into an ImageView
            profile_img.setImageURI(imageUri);
            String imagePath = imageUri.toString();


            // Perform other operations with the image as needed
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, you can perform gallery-related operations
            } else {
                // Permission denied, handle accordingly or show a message
            }
        }
    }
}

