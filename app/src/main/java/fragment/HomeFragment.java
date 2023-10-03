package fragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.itamoto.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Activity.MainActivity;
import Activity.OnbordingActivity;
import Activity.SearchResultActivity;
import Adapter.OfferAdapter;
import Adapter.OnbordingAdapter;
import Adapter.SppinnerAdapter;
import Model.BookTicket;
import Model.OfferImage;
import Model.StartPoinEndPoint;
import Model.Vehical;
import Other.ApiInterface;
import Other.PrefManager;
import Other.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private ImageView image_Menu,calender_img,vehicle_img;
    MaterialButton search_btn;
    TextView edit_calander;
    ApiInterface apiInterface;
    RetrofitClient retrofitClient;
    Spinner sp_start,sp_end,sp_vehicle;
    ProgressBar progressBar;
    ArrayList<String > point = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    String selectedStartPoint = "SELECT";
    String selectedEndPoint;
    String selectedVehicle;
    String selectedDate;
    ViewPager vp_offerImage;
    OfferImage offerImage;
    OfferAdapter offerAdapter;
    ArrayList<OfferImage> offerImages;
    private PrefManager prefManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        image_Menu=view.findViewById(R.id.image_Menu);
        search_btn = view.findViewById(R.id.search_btn);
        sp_vehicle = view.findViewById(R.id.sp_vehicle);
        sp_start = view.findViewById(R.id.sp_start);
        sp_end = view.findViewById(R.id.sp_end);
        calender_img = view.findViewById(R.id.calender_img);
        edit_calander = view.findViewById(R.id.edit_calander);
        vehicle_img = view.findViewById(R.id.vehicle_img);
        vp_offerImage = view.findViewById(R.id.vp_offerImage);
        progressBar = view.findViewById(R.id.progressBar);
        apiInterface = RetrofitClient.getClient().create(ApiInterface.class);


        prefManager = new PrefManager(getActivity());
        image_Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.drawer_layout.openDrawer(GravityCompat.START);
            }
        });
        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                if(edit_calander.getText().toString().equals("")){
                    Toast.makeText(getActivity(),"Please Select a Date",Toast.LENGTH_SHORT).show();
                }
                bookTicket();


            }
        });
        calender_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
        vehicle_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        vehicleType();
        startPoint();
        endPoint();
        offerImage();

        return view;
    }



    private void endPoint() {
        Call<List<StartPoinEndPoint>>call = apiInterface.startEndPoint();
        call.enqueue(new Callback<List<StartPoinEndPoint>>() {
            @Override
            public void onResponse(Call<List<StartPoinEndPoint>> call, Response<List<StartPoinEndPoint>> response) {
                if (response.isSuccessful()) {
                    List<StartPoinEndPoint> startEndPoints = response.body();
                    List<String> pointNames = new ArrayList<>();
                    for (StartPoinEndPoint endPoint : startEndPoints) {
                        pointNames.add(endPoint.getPoints());
                    }
                    SppinnerAdapter adapter = new SppinnerAdapter(getActivity(), android.R.layout.simple_spinner_item, pointNames);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    sp_end.setAdapter(adapter);


                    sp_end.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            selectedEndPoint = (String) parent.getItemAtPosition(position);
                        //    Toast.makeText(getActivity(), "Selected: " + selectedEndPoint, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }});

                } else {
                    Log.e("endddddd", "Error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<StartPoinEndPoint>> call, Throwable t) {

            }
        });
    }


    private void startPoint() {
        Call<List<StartPoinEndPoint>> call = apiInterface.startEndPoint();
        call.enqueue(new Callback<List<StartPoinEndPoint>>() {
            @Override
            public void onResponse(Call<List<StartPoinEndPoint>> call, Response<List<StartPoinEndPoint>> response) {
                if (response.isSuccessful()) {
                    List<StartPoinEndPoint> startEndPoints = response.body();
                    List<String> pointNames = new ArrayList<>();
                    for (StartPoinEndPoint endPoint : startEndPoints) {
                        pointNames.add(endPoint.getPoints());
                    }

                    SppinnerAdapter adapter = new SppinnerAdapter(getActivity(), android.R.layout.simple_spinner_item, pointNames);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    sp_start.setAdapter(adapter);


                    sp_start.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            selectedStartPoint = (String) parent.getItemAtPosition(position);
                          //  Toast.makeText(getActivity(), "Selected: " + selectedStartPoint, Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }});

                    } else {
                    Log.e("starrrrrr", "Error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<StartPoinEndPoint>> call, Throwable t) {
                Log.e("API", "Failure: " + t.getMessage());
            }
        });


    }

    private void vehicleType() {

        Call<List<Vehical>> call = apiInterface.vehicle();
        call.enqueue(new Callback<List<Vehical>>() {
            @Override
            public void onResponse(Call<List<Vehical>> call, Response<List<Vehical>> response) {
                if (response.isSuccessful()) {
                    List<Vehical> vehicals = response.body();
                    List<String> vehicleTypes = new ArrayList<>();

                    for (Vehical vehical : vehicals) {
                        vehicleTypes.add(vehical.getVehicleType());
                    }

                    ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, vehicleTypes);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    sp_vehicle.setAdapter(adapter);


                    sp_vehicle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            selectedVehicle = (String) parent.getItemAtPosition(position);
                            Log.e("vehicleeee", "onItemSelected: "+selectedVehicle );
                           // Toast.makeText(getActivity(), "Selected: " + selectedVehicle, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }});

                } else {
                    Log.e("API", "Error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Vehical>> call, Throwable t) {
                Log.e("API", "Failure: " + t.getMessage());
            }
        });
    }
    private void showDatePickerDialog() {

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                new DatePickerDialog.OnDateSetListener() {
                  

                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // Here, you can handle the selected date
                        selectedDate = year + "/" + (month + 1) + "/" + dayOfMonth;
                        edit_calander.setText(selectedDate);
                    }
                }, year, month, day);

        datePickerDialog.show();
    }
    private void bookTicket() {
        String Id = prefManager.getUserId();
        String StartPoint = selectedStartPoint;
        String EndPoint = selectedEndPoint;
        String JourneyDate = selectedDate;
        String Vehicle = selectedVehicle;

        Log.e("useeeeeerrrrr", "bookTicket: "+prefManager.getUserId() );

        Call<BookTicket> call = apiInterface.bookTicket(Id,StartPoint,EndPoint,JourneyDate,Vehicle);
        call.enqueue(new Callback<BookTicket>() {
            @Override
            public void onResponse(Call<BookTicket> call, Response<BookTicket> response) {
                progressBar.setVisibility(View.GONE);

                Log.e("tag","Res "+response.body().getResult());

                if (response.body().getResult().equals("Searching")) {
                    Toast.makeText(getActivity(), "" + response.body().getResult(), Toast.LENGTH_SHORT).show();


                    Intent intent = new Intent(getActivity(), SearchResultActivity.class);
                    intent.putExtra("book",response.body());

                    Log.e("boooktickettt", "onResponse: "+response.body());
                    startActivity(intent);
                } else {
                    Log.e("API", "Error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<BookTicket> call, Throwable t) {

            }
        });
    }
    private void offerImage() {
        String Id= prefManager.getUserId();
        Call<List<OfferImage>> call = apiInterface.offerImg(Id);
        call.enqueue(new Callback<List<OfferImage>>() {
            @Override
            public void onResponse(Call<List<OfferImage>> call, Response<List<OfferImage>> response) {

                vp_offerImage.setAdapter(new OfferAdapter(getActivity(), response.body()));
                vp_offerImage.addOnPageChangeListener(offerImageViewPager);


            }
            public void onFailure(Call<List<OfferImage>> call, Throwable t) {

            }
        });}
        ViewPager.OnPageChangeListener offerImageViewPager = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        };

    }











