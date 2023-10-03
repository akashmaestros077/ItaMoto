package Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.itamoto.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.PassengerListAdapter;
import Adapter.SearchResultAdapter;
import Model.Addmeal;
import Model.ConfirmDetails;
import Model.HomeDrop;
import Model.JourneyDetails;
import Model.PassengerList;
import Model.SearchResult;
import Model.Term;
import Other.ApiInterface;
import Other.PrefManager;
import Other.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfirmDetailsAndPayActivity extends AppCompatActivity {
    ImageView image_back;
    MaterialButton confirm_btn;
    RecyclerView rv_passanger_list;
    ApiInterface apiInterface;
    PassengerListAdapter adapter;
    List<PassengerList> passengerLists = new ArrayList<>();
    RadioGroup radio_gp,radioGP;
    RadioButton rg_bike,option1,option2,option3,rg_texi,rg_not;
ProgressBar progressBar;
PrefManager prefManager;
TextView text_from,text_to,text_date,route_distance,start_time,end_time,duration,vehicle,ticket_prize,seat_no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_details_and_pay);

        image_back = findViewById(R.id.image_back);
        confirm_btn = findViewById(R.id.confirm_btn);
        rv_passanger_list = findViewById(R.id.rv_passanger_list);
        rg_bike = findViewById(R.id.rg_bike);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        rg_texi = findViewById(R.id.rg_texi);
        rg_not = findViewById(R.id.rg_not);
        radio_gp = findViewById(R.id.radio_gp);
        radioGP = findViewById(R.id.radioGP);
        text_from = findViewById(R.id.text_from);
        text_to = findViewById(R.id.text_to);
        text_date = findViewById(R.id.text_date);
        route_distance = findViewById(R.id.route_distance);
        start_time = findViewById(R.id.start_time);
        end_time = findViewById(R.id.end_time);
        duration = findViewById(R.id.duration);
        vehicle = findViewById(R.id.vehicle);
        ticket_prize = findViewById(R.id.ticket_prize);
        seat_no = findViewById(R.id.seat_no);




        progressBar = findViewById(R.id.progressBar);
        prefManager = new PrefManager(this);



        apiInterface = RetrofitClient.getClient().create(ApiInterface.class);

        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConfirmDetailsAndPayActivity.this, PickupLocationActivity.class));
            }
        });
        confirm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                getConfirmDetails();
               // startActivity(new Intent(ConfirmDetailsAndPayActivity.this, PaymentActivity.class));
            }
        });

        getPassengerList();
        getMealCat();
        getDrop();
        getJourneyDetails();


    }

    private void getJourneyDetails() {
        String UserId = prefManager.getUserId();
        String RouteId ="1";

        Call<JourneyDetails> call = apiInterface.journeyDetails(UserId,RouteId);
        call.enqueue(new Callback<JourneyDetails>() {
            @Override
            public void onResponse(Call<JourneyDetails> call, Response<JourneyDetails> response) {
                if (response.isSuccessful()){
                    text_from.setText(response.body().fromTo);
                    text_to.setText(response.body().toFrom);
                    text_date.setText(response.body().routeDate);
                    start_time.setText(response.body().startTime);
                    end_time.setText(response.body().endTime);
                    duration.setText(response.body().timeDuration);
                    vehicle.setText(response.body().vehicleType);
                    seat_no.setText(response.body().seatNo.toString());
                }
            }

            @Override
            public void onFailure(Call<JourneyDetails> call, Throwable t) {

            }
        });
    }

    private void getPassengerList() {
        String UserId = prefManager.getUserId();
        String Gender = "Male";
        Call<List<PassengerList>> call = apiInterface.getPassengerList(UserId,Gender);
        call.enqueue(new Callback<List<PassengerList>>() {
            @Override
            public void onResponse(Call<List<PassengerList>> call, Response<List<PassengerList>> response) {
                if (response.isSuccessful()) {
                    List<PassengerList> passengerLists1 = response.body();
                    if (passengerLists1 != null) {
                        rv_passanger_list.setHasFixedSize(true);
                        rv_passanger_list.setLayoutManager(new LinearLayoutManager( ConfirmDetailsAndPayActivity.this,RecyclerView.VERTICAL,false));
                        rv_passanger_list.setAdapter(new PassengerListAdapter( passengerLists1));



                    }
                }
            }

            @Override
            public void onFailure(Call<List<PassengerList>> call, Throwable t) {

            }
        });
    }
    private void getMealCat() {
        String RouteId = "1";

        final int OPTION_1_ID = R.id.option1;
        final int OPTION_2_ID = R.id.option2;
        final int OPTION_3_ID = R.id.option3;

        radio_gp.setOnCheckedChangeListener((radioGroup, checkedId) -> {
            Call<Addmeal> call;
            if (checkedId == OPTION_1_ID) {
                Toast.makeText(ConfirmDetailsAndPayActivity.this,"Veg",Toast.LENGTH_SHORT).show();
                call = apiInterface.meal(RouteId, "Option1");
            } else if (checkedId == OPTION_2_ID) {
                Toast.makeText(ConfirmDetailsAndPayActivity.this,"Non-Veg",Toast.LENGTH_SHORT).show();
                call = apiInterface.meal(RouteId, "Option2");
            } else if (checkedId == OPTION_3_ID) {
                Toast.makeText(ConfirmDetailsAndPayActivity.this,"No",Toast.LENGTH_SHORT).show();
                call = apiInterface.meal(RouteId, "Option3");
            } else {
                return;
            }

            call.enqueue(new Callback<Addmeal>() {
                @Override
                public void onResponse(Call<Addmeal> call, Response<Addmeal> response) {
                    // Handle successful response
                    if (response.isSuccessful()) {
                        Addmeal addMeal = response.body();
                        // Process the response data
                    } else {

                        // Handle error response
                    }
                }

                @Override
                public void onFailure(Call<Addmeal> call, Throwable t) {
                    // Handle failure
                }
            });
        });
    }
    private void getDrop() {
        String UserId = prefManager.getUserId();

        final int OPTION_1_ID = R.id.rg_bike;
        final int OPTION_2_ID = R.id.rg_texi;
        final int OPTION_3_ID = R.id.rg_not;

        radioGP.setOnCheckedChangeListener((radioGroup, checkedId) -> {
            Call<HomeDrop> call;
            if (checkedId == OPTION_1_ID) {
                Toast.makeText(ConfirmDetailsAndPayActivity.this,"Bike",Toast.LENGTH_SHORT).show();
                call = apiInterface.drop(UserId, "Option1");
            } else if (checkedId == OPTION_2_ID) {
                Toast.makeText(ConfirmDetailsAndPayActivity.this,"Texi",Toast.LENGTH_SHORT).show();
                call = apiInterface.drop(UserId, "Option2");
            } else if (checkedId == OPTION_3_ID) {
                Toast.makeText(ConfirmDetailsAndPayActivity.this,"No",Toast.LENGTH_SHORT).show();
                call = apiInterface.drop(UserId, "Option3");
            } else {
                return;
            }

            call.enqueue(new Callback<HomeDrop>() {
                @Override
                public void onResponse(Call<HomeDrop> call, Response<HomeDrop> response) {
                    // Handle successful response
                    if (response.isSuccessful()) {
                        HomeDrop drop = response.body();
                        // Process the response data
                    } else {

                        // Handle error response
                    }
                }


                @Override
                public void onFailure(Call<HomeDrop> call, Throwable t) {

                }
            });

        });
    }
    private void getConfirmDetails() {
        String UserId = prefManager.getUserId();
        String RouteId = "1";
        String PassengerId = "1";
        String FromTo = "Bhopal";
        String Tofrom = "Indore";
        String Vehicle_type = "Tata Sumo";
        String route_date = "28/6/2023";
        String start_time = "6am";
        String end_time = "8pm";
        String time_duration = "3hr";
        String route_distance = "300Km";
        String meal_id ="1";
        String drop_id = "1";

        Call<ConfirmDetails> call = apiInterface.confirmDetails(UserId,RouteId,PassengerId,FromTo,Tofrom,Vehicle_type,route_date,
                start_time,end_time,time_duration,route_distance,meal_id,drop_id);

        call.enqueue(new Callback<ConfirmDetails>() {
            @Override
            public void onResponse(Call<ConfirmDetails> call, Response<ConfirmDetails> response) {
                if(response.body().getResult().equals("Confirm & Insert Successfully")){
                    Toast.makeText(ConfirmDetailsAndPayActivity.this,""+response.body().getResult(),Toast.LENGTH_SHORT).show();
                    Log.e("checkkkkkkk", "onResponse: "+response.body().getResult() );

                    Intent intent = new Intent(ConfirmDetailsAndPayActivity.this,PaymentActivity.class);
                    intent.putExtra("paymenrt",ConfirmDetails.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(ConfirmDetailsAndPayActivity.this,""+response.body().getResult(),Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<ConfirmDetails> call, Throwable t) {

            }
        });
    }



}

