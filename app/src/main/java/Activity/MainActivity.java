package Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.button.MaterialButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.itamoto.R;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import Model.ShowEditProfile;
import Other.ApiInterface;
import Other.PrefManager;
import Other.RetrofitClient;
import fragment.HomeFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

   RelativeLayout rl_profile;
    MaterialButton search_btn;
    LinearLayout ll_wallet,ll_refereran,ll_termsandConditions,ll_contact,ll_history,ll_logout;
    TextView text_user_name,address;
    ApiInterface apiInterface;
    private PrefManager prefManager;
    public static DrawerLayout drawer_layout;

    ShowEditProfile showEditProfile;

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawer_layout = findViewById(R.id.drawer_layout);
        rl_profile = findViewById(R.id.rl_profile);
        ll_wallet = findViewById(R.id.ll_wallet);
        ll_refereran = findViewById(R.id.ll_refereran);
        ll_termsandConditions = findViewById(R.id.ll_termsandConditions);
        ll_contact = findViewById(R.id.ll_contact);
        ll_history = findViewById(R.id.ll_history);
        ll_logout = findViewById(R.id.ll_logout);
        text_user_name = findViewById(R.id.text_user_name);
        address = findViewById(R.id.address);
        prefManager = new PrefManager(this);

        builder = new AlertDialog.Builder(this);
        apiInterface = RetrofitClient.getClient().create(ApiInterface.class);
        showProfile();



        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new HomeFragment()).addToBackStack(null).commit();

        }

        rl_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ProfileActivity.class));
                drawer_layout.closeDrawer(GravityCompat.START);

            }
        });
        ll_wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,WalletActivity.class));
                drawer_layout.closeDrawer(GravityCompat.START);

            }
        });
        ll_refereran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ReferAndEarnActivity.class));
                drawer_layout.closeDrawer(GravityCompat.START);

            }
        });
        ll_termsandConditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TermAndConditionsActivity.class));
                drawer_layout.closeDrawer(GravityCompat.START);

            }
        });
        ll_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ContactUsActivity.class));
                drawer_layout.closeDrawer(GravityCompat.START);

            }
        });
        ll_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HistoryActivity.class));
                drawer_layout.closeDrawer(GravityCompat.START);

            }
        });
        ll_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    builder.setMessage("Do you want to close application").setCancelable(false).setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    AlertDialog alertDialog = builder.create();
                    alertDialog.setTitle("Logout");
                    alertDialog.show();
                    prefManager.logout();

                    Toast.makeText(MainActivity.this,"Logout",Toast.LENGTH_SHORT).show();



                }



        });


    }
    private void showProfile() {
        String UserId = prefManager.getUserId();
        String FirstName = text_user_name.toString().trim();
        String LastName = text_user_name.toString().trim();
        String Mobile = text_user_name.toString().trim();
        String Address = address.toString().trim();
        Call<ShowEditProfile> call = apiInterface.showProfile( UserId,Mobile ,Address,FirstName,LastName);
        call.enqueue( new Callback<ShowEditProfile>() {
            @Override
            public void onResponse(Call<ShowEditProfile> call, Response<ShowEditProfile> response) {
                if(response.body().getMessage().equals( " profile  Show successfully" )){
                    address.setText(response.body().address);
                    text_user_name.setText(response.body().firstName);
                }
            }

            @Override
            public void onFailure(Call<ShowEditProfile> call, Throwable t) {

            }
        } );
    }



}