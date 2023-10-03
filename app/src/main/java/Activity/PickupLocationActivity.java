package Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.itamoto.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.PassengerListAdapter;
import Adapter.SppinnerAdapter;
import Model.ChooseSeat;
import Model.DropLocation;
import Model.PassengerDetails;
import Model.PassengerList;
import Model.PickupLocation;
import Model.SearchResult;
import Model.StartPoinEndPoint;
import Model.Vehical;
import Other.ApiInterface;
import Other.PrefManager;
import Other.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;

public class PickupLocationActivity extends AppCompatActivity {
Spinner pickup_spinner,droploc_sppiner;
ApiInterface apiInterface;
RetrofitClient retrofitClient;
String selectedLocation ,gender = "",selectedDropLocation;
ArrayList<String > locationList = new ArrayList<>();
EditText edit_first_name,edit_last_name,edit_mobile,edit_age;
MaterialButton save_next_btn;
ProgressBar progresssBar;
TextView text_gender,text_name,text_age,text_number;
RecyclerView rv_passanger_list;

SearchResult searchResult;


ImageView img_male,img_female , img_children,male_select,female_select,children_select ,image_back;
private PrefManager prefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickup_location);
        pickup_spinner = findViewById(R.id.pickup_spinner);
        droploc_sppiner = findViewById(R.id.droploc_sppiner);
        edit_first_name = findViewById(R.id.edit_first_name);
        edit_last_name = findViewById(R.id.edit_last_name);
        edit_age = findViewById(R.id.edit_age);
        edit_mobile = findViewById(R.id.edit_mobile);
        save_next_btn = findViewById(R.id.save_next_btn);
        img_male = findViewById(R.id.img_male);
        img_female = findViewById(R.id.img_female);
        img_children = findViewById(R.id.img_children);
        male_select = findViewById(R.id.male_select);
        female_select = findViewById(R.id.female_select);
        children_select = findViewById(R.id.children_select);
        image_back = findViewById(R.id.image_back);
        progresssBar = findViewById(R.id.progresssBar);
        text_name = findViewById(R.id.text_name);
        text_gender = findViewById(R.id.text_gender);
        text_age = findViewById(R.id.text_age);
        text_number = findViewById(R.id.text_number);
        rv_passanger_list = findViewById(R.id.rv_passanger_list);

       searchResult = (SearchResult) getIntent().getSerializableExtra("book");

        prefManager = new PrefManager(this);


        apiInterface = RetrofitClient.getClient().create(ApiInterface.class);
        getPickupLocation();
        getDropLocation();


        image_back.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(PickupLocationActivity.this,ChooseSeatActivity.class) );
            }
        } );

        img_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                male_select.setVisibility(View.VISIBLE);
                female_select.setVisibility(View.GONE);
                children_select.setVisibility(View.GONE);
                gender = "male";
                Toast.makeText(PickupLocationActivity.this,"Male",Toast.LENGTH_SHORT).show();
            }
        });
        img_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                male_select.setVisibility(View.GONE);
                female_select.setVisibility(View.VISIBLE);
                children_select.setVisibility(View.GONE);
                gender ="female";
                Toast.makeText(PickupLocationActivity.this,"Female",Toast.LENGTH_SHORT).show();

            }
        });
        img_children.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                male_select.setVisibility(View.GONE);
                female_select.setVisibility(View.GONE);
                children_select.setVisibility(View.VISIBLE);
                gender ="children";
                Toast.makeText(PickupLocationActivity.this,"children",Toast.LENGTH_SHORT).show();

            }
        });




    }

    private void getDropLocation() {
        String UserId = prefManager.getUserId();
        String Drop = "7";
        String RouteDate = "2023-07-31";

        Call<List<DropLocation>> call = apiInterface.getDropLocation(Drop,UserId,RouteDate);
        call.enqueue(new Callback<List<DropLocation>>() {
            @Override
            public void onResponse(Call<List<DropLocation>> call, Response<List<DropLocation>> response) {

                if (response.isSuccessful()) {
                    List<DropLocation> locations = response.body();
                    List<String> locationList = new ArrayList<>();

                    if (locations != null) {
                        for (DropLocation DropLocation : locations) {
                            locationList.add(DropLocation.getLocation());
                        }

                        ArrayAdapter adapter = new ArrayAdapter(PickupLocationActivity.this, android.R.layout.simple_spinner_item, locationList);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        droploc_sppiner.setAdapter(adapter);

                        droploc_sppiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                selectedDropLocation = (String) parent.getItemAtPosition(position);
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }});



                    }
                }


            }

            @Override
            public void onFailure(Call<List<DropLocation>> call, Throwable t) {

            }
        });
    }


    private void getPickupLocation() {

        String Pickup = "6";
        String UserId = prefManager.getUserId();
        String RouteDate = "2023-07-31";

        Call<List<PickupLocation>> call = apiInterface.getPickupLocation(Pickup,UserId,RouteDate);
        call.enqueue(new Callback<List<PickupLocation>>() {
            @Override
            public void onResponse(Call<List<PickupLocation>> call, Response<List<PickupLocation>> response) {
                if (response.isSuccessful()) {
                            List<PickupLocation> locations = response.body();
                            List<String> locationList = new ArrayList<>();

                            if (locations != null) {
                                for (PickupLocation pickupLocation : locations) {
                                    locationList.add(pickupLocation.getLocation());
                                }

                                ArrayAdapter adapter = new ArrayAdapter(PickupLocationActivity.this, android.R.layout.simple_spinner_item, locationList);
                                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                pickup_spinner.setAdapter(adapter);

                                pickup_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        selectedLocation = (String) parent.getItemAtPosition(position);
                                        Log.e("loccccccc", "onItemSelected: " + selectedLocation);
                                        // Toast.makeText(PickupLocationActivity.this, "Selected: " + selectedLocation, Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {
                                        // Handle when no item is selected
                                    }
                                });


                            }
                }
            }

            @Override
            public void onFailure(Call<List<PickupLocation>> call, Throwable t) {
                // Handle failure scenario
            }
        });

        save_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progresssBar.setVisibility(View.VISIBLE);
                if (edit_first_name.getText().toString().equals("")){
                    Toast.makeText(PickupLocationActivity.this,"Please Enter First Name",Toast.LENGTH_SHORT).show();
                }
               else if (edit_last_name.getText().toString().equals("")){
                    Toast.makeText(PickupLocationActivity.this,"Please Enter Last Name",Toast.LENGTH_SHORT).show();
                }
               else if (edit_age.getText().toString().equals("")){
                    Toast.makeText(PickupLocationActivity.this,"Please Enter Age",Toast.LENGTH_SHORT).show();
                }
               else if (edit_mobile.getText().toString().equals("")){
                    Toast.makeText(PickupLocationActivity.this,"Please Enter Age",Toast.LENGTH_SHORT).show();
                }
                getPassengerDetails();

            }
        });
    }


    private void getPassengerDetails() {
        String UserId = prefManager.getUserId();
        String Gender = gender;
        Log.e("genderrrrrr", "getPassengerDetails: "+gender);
        String FirstName = edit_first_name.getText().toString().trim();
        String LastName = edit_last_name.getText().toString().trim();
        String Age = edit_age.getText().toString().trim();
        String Mobile = edit_mobile.getText().toString().trim();
        String RouteId = "234";
        String SeatNo = "65";
        String PickUpId ="123";
        String DropId = "087";
        Call<PassengerDetails> call  = apiInterface.getPassengerData(UserId,Gender,FirstName,LastName,Age,Mobile,RouteId,SeatNo,PickUpId,DropId);
        call.enqueue(new Callback<PassengerDetails>() {
            @Override
            public void onResponse(Call<PassengerDetails> call, Response<PassengerDetails> response) {
                progresssBar.setVisibility(View.GONE);

                if (response.body().getResult().equals("Save Successfully ")){
                    Toast.makeText(PickupLocationActivity.this,""+response.body().getResult(),Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(PickupLocationActivity.this,ConfirmDetailsAndPayActivity.class));
                }
                else {
                    Toast.makeText(PickupLocationActivity.this,""+response.body().getResult(),Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<PassengerDetails> call, Throwable t) {

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
                        rv_passanger_list.setLayoutManager(new LinearLayoutManager( PickupLocationActivity.this, RecyclerView.VERTICAL,false));
                        rv_passanger_list.setAdapter(new PassengerListAdapter( passengerLists1));



                    }
                }
            }

            @Override
            public void onFailure(Call<List<PassengerList>> call, Throwable t) {

            }
        });
    }




}


