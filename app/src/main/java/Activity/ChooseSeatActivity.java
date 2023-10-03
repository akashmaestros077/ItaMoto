package Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.itamoto.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.ChooseSeatAdapter;
import Adapter.SearchResultAdapter;
import Adapter.SeatAdapter;
import Model.BookTicket;
import Model.ChooseSeat;
import Model.SearchResult;
import Model.SeatAvailable;
import Other.ApiInterface;
import Other.PrefManager;
import Other.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ChooseSeatActivity extends AppCompatActivity {
    MaterialButton confirm_btn;
    ImageView image_back;
    private BookTicket bookTicket;

    ApiInterface apiInterface;
    Retrofit retrofit;
    RecyclerView rv_choose_seat;
    SeatAdapter seatAdapter;
    TextView seat1select, seat2select, seat3select, seat4select, seat5select, seat6select, seat7select, seat8select, seat9select, seat10select;
    TextView seat1, seat2, seat3, seat4, seat5, seat6, seat7, seat8, seat9, seat10,start_point,end_point,
            date,route_distance,time,time_duration,text_vehicle,single_seat_prize;
    ArrayList<SeatAvailable> seatAvailables = new ArrayList<>();

  private   ProgressBar progresssBar;
   private PrefManager prefManager;

   private SearchResult searchResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_seat);
        confirm_btn = findViewById(R.id.confirm_btn);
        image_back = findViewById(R.id.image_back);
        rv_choose_seat = findViewById(R.id.rv_choose_seat);
        progresssBar = findViewById(R.id.progresssBar);
        start_point = findViewById(R.id.start_point);
        end_point = findViewById(R.id.end_point);
        date = findViewById(R.id.date);
        route_distance = findViewById(R.id.route_distance);
        time = findViewById(R.id.time);
        time_duration = findViewById(R.id.time_duration);
        text_vehicle = findViewById(R.id.text_vehicle);
        single_seat_prize = findViewById(R.id.single_seat_prize);


        searchResult = (SearchResult) getIntent().getSerializableExtra("book");

        apiInterface = RetrofitClient.getClient().create(ApiInterface.class);

        prefManager = new PrefManager(this);


        seat1 = findViewById(R.id.seat1);
        seat2 = findViewById(R.id.seat2);
        seat3 = findViewById(R.id.seat3);
        seat4 = findViewById(R.id.seat4);
        seat5 = findViewById(R.id.seat5);
        seat6 = findViewById(R.id.seat6);
        seat7 = findViewById(R.id.seat7);
        seat8 = findViewById(R.id.seat8);
        seat9 = findViewById(R.id.seat9);
        seat10 = findViewById(R.id.seat10);


        selectSeat();
        seatAvailable();
        chooseSeat();
        SeatBooked();


        seat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (seat1.isSelected()) {
                    // Seat is already booked
                    seat1.setBackgroundColor(getResources().getColor(R.color.red));
                } else {
                    // Seat is available
                    seat1.setBackgroundColor(getResources().getColor(R.color.blue));
                }
            }
        });

        seat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                seat2.setBackgroundColor(getResources().getColor(R.color.blue));
            }
        });

        seat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seat3.isSelected();

                seat3.setBackgroundColor(getResources().getColor(R.color.blue));
            }
        });

        seat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seat4.isSelected();
                seat4.setBackgroundColor(getResources().getColor(R.color.blue));

            }
        });

        seat5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seat5.isSelected();
                seat5.setBackgroundColor(getResources().getColor(R.color.blue));

            }
        });

        seat6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seat6.isSelected();
                seat6.setBackgroundColor(getResources().getColor(R.color.blue));

            }
        });

        seat7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seat7.isSelected();
                seat7.setBackgroundColor(getResources().getColor(R.color.blue));

            }
        });

        seat8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seat8.isSelected();
                SeatBooked();
                seat8.setBackgroundColor(getResources().getColor(R.color.blue));

            }
        });


        confirm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progresssBar.setVisibility(View.VISIBLE);
                Intent intent = new Intent(ChooseSeatActivity.this,PickupLocationActivity.class);
                intent.putExtra("confirm",ChooseSeat.SeatData.class);
                startActivity(intent);
            }
        });
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseSeatActivity.this, SearchResultActivity.class));
            }
        });

    }

    private void toggleSeatSelection(TextView seat8) {

    }

    private void chooseSeat() {
        String Id = "1";
        String UserId = prefManager.getUserId();
        String From = searchResult.getFrom();
        Log.e("kesfsfsgg", "chooseSeat: "+searchResult.from );
        String To = searchResult.getTo();
        String Vehicle = searchResult.vehicleType;
       String  RouteDate = searchResult.routeDate;
       String Prize = searchResult.getPrize();
       String  Time = searchResult.startTime;
       String Timeduration = searchResult.getTimeDuration();
       String Routedis = searchResult.getRouteDistance();

       Call<ChooseSeat.SeatData> call = apiInterface.chooseSeat(Id,UserId,From,To,Vehicle,RouteDate,
               Prize,Time,Timeduration,Routedis);
       call.enqueue(new Callback<ChooseSeat.SeatData>() {
           @Override
           public void onResponse(Call<ChooseSeat.SeatData> call, Response<ChooseSeat.SeatData> response) {
               start_point.setText(searchResult.getFrom());
               end_point.setText(searchResult.getTo());
               date.setText(searchResult.getRouteDate());
               time.setText(searchResult.getEndTime());
               text_vehicle.setText(searchResult.getVehicleType());
               single_seat_prize.setText(searchResult.getPrize());
               time_duration.setText(searchResult.getTimeDuration());

           }

           @Override
           public void onFailure(Call<ChooseSeat.SeatData> call, Throwable t) {

           }
       });

    }

    private void selectSeat() {

        if (seat1.isSelected()) {
            seat1.setBackgroundColor(getResources().getColor(R.color.blue));

        } else if (seat2.isSelected()) {
            seat2.setBackgroundColor(getResources().getColor(R.color.blue));

        } else if (seat3.isSelected()) {
            seat3.setBackgroundColor(getResources().getColor(R.color.blue));

        } else if (seat4.isSelected()) {
            seat4.setBackgroundColor(getResources().getColor(R.color.blue));

        } else if (seat5.isSelected()) {
            seat5.setBackgroundColor(getResources().getColor(R.color.blue));

        } else if (seat6.isSelected()) {
            seat5.setBackgroundColor(getResources().getColor(R.color.blue));

        } else if (seat7.isSelected()) {
            seat7.setBackgroundColor(getResources().getColor(R.color.blue));

        } else if (seat8.isSelected()) {
            seat8.setBackgroundColor(getResources().getColor(R.color.blue));
        }

    }


    private void seatAvailable() {
        String UserId = prefManager.getUserId();
        String RouteId = "1";

        Call<List<SeatAvailable>> call = apiInterface.seatAvailable(UserId, RouteId);
        call.enqueue(new Callback<List<SeatAvailable>>() {
            @Override
            public void onResponse(Call<List<SeatAvailable>> call, Response<List<SeatAvailable>> response) {


                }

            @Override
            public void onFailure(Call<List<SeatAvailable>> call, Throwable t) {

            }
        });
    }

    private void SeatBooked() {

        for (int a=0;a<seatAvailables.size();a++){
            SeatAvailable seatAvailable = seatAvailables.get(a);
            if (a==1){
                if (seatAvailable.getStatus().equalsIgnoreCase("Booked")){
                    if (seatAvailable.getStatus().equalsIgnoreCase("Booked")) {
                        seat1.setClickable(false);
                        seat1.setBackgroundColor(getResources().getColor(R.color.red));
                        seat1.setTextColor(getResources().getColor(R.color.white));
                    }
                }

            }
            if(a==2){
                if (seatAvailable.getStatus().equalsIgnoreCase("Booked")){
                    seat2.setClickable(false);
                    seat2.setBackgroundColor(getResources().getColor(R.color.red));
                    seat2.setTextColor(getResources().getColor(R.color.white));
                }
            }
            if (a==3){
                if (seatAvailable.getStatus().equalsIgnoreCase("Booked")){
                    seat3.setClickable(false);
                    seat3.setBackgroundColor(getResources().getColor(R.color.red));
                    seat3.setTextColor(getResources().getColor(R.color.white));
                }
            }
            if (a==4){
                if (seatAvailable.getStatus().equalsIgnoreCase("Booked")){
                    seat4.setClickable(false);
                    seat4.setBackgroundColor(getResources().getColor(R.color.red));
                    seat4.setTextColor(getResources().getColor(R.color.white));
                }
            }
            if (a==5){
                if (seatAvailable.getStatus().equalsIgnoreCase("Booked")){
                    seat5.setClickable(false);
                    seat5.setBackgroundColor(getResources().getColor(R.color.red));
                    seat5.setTextColor(getResources().getColor(R.color.white));
                }
            }
            if (a==6){
                if (seatAvailable.getStatus().equalsIgnoreCase("Booked")){
                    seat6.setClickable(false);
                    seat6.setBackgroundColor(getResources().getColor(R.color.red));
                    seat6.setTextColor(getResources().getColor(R.color.white));
                }
            }
            if (a==7){
                if (seatAvailable.getStatus().equalsIgnoreCase("Booked")){
                    seat7.setClickable(false);
                    seat7.setBackgroundColor(getResources().getColor(R.color.red));
                    seat7.setTextColor(getResources().getColor(R.color.white));
                }
            }
            if (a==8){
                if (seatAvailable.getStatus().equalsIgnoreCase("Booked")){
                    seat8.setClickable(false);
                    seat8.setBackgroundColor(getResources().getColor(R.color.red));
                    seat8.setTextColor(getResources().getColor(R.color.white));
                }
            }

        }

    }

    }


