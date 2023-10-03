package Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.itamoto.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.SearchResultAdapter;
import Model.BookTicket;
import Model.ChooseSeat;
import Model.SearchResult;
import Other.ApiInterface;
import Other.PrefManager;
import Other.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchResultActivity extends AppCompatActivity {
    MaterialButton booknow_btn;
    ImageView image_back;
    ApiInterface apiInterface;
    SearchResultAdapter adapter;
    RecyclerView rv_search_result;
    ArrayList<SearchResult> searchResults = new ArrayList<>();
    private BookTicket bookTicket;
    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        bookTicket = (BookTicket) getIntent().getSerializableExtra("book");
        Log.e("jjhnjhhj", String.valueOf(bookTicket));
        image_back = findViewById(R.id.image_back);
        rv_search_result = findViewById(R.id.rv_search_result);
        apiInterface = RetrofitClient.getClient().create(ApiInterface.class);

        prefManager = new PrefManager(this);
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SearchResultActivity.this, MainActivity.class));
            }
        });

        searchResult();

    }


    private void searchResult() {
        Log.e("bhghgh",  bookTicket.startPoint);
        Log.e("bhghgh",  bookTicket.endPoint);
        Log.e("bhghgh",  bookTicket.journeyDate);
        Log.e("bhghgh",  bookTicket.vehicleType);

        String Id = prefManager.getUserId();
        String StartPoint = "6";
        String EndPoint = "7";
        String JourneyDate =bookTicket.journeyDate;
        String Vehicle = "1";
        String From = bookTicket.startPoint;
        String To = bookTicket.endPoint;
        Log.e("idddd", "searchResult: "+Id);

        Call<List<SearchResult>> call = apiInterface.getResult(Id, StartPoint, EndPoint, JourneyDate, Vehicle,From,To);
        call.enqueue(new Callback<List<SearchResult>>() {
            @Override
            public void onResponse(Call<List<SearchResult>> call, Response<List<SearchResult>> response) {


                if (response.isSuccessful()) {
                    List<SearchResult> searchResults = response.body();
                    if (searchResults != null) {
                        rv_search_result.setHasFixedSize(true);
                        rv_search_result.setLayoutManager(new LinearLayoutManager(SearchResultActivity.this, RecyclerView.VERTICAL, false));
                        rv_search_result.setAdapter(new SearchResultAdapter(searchResults, SearchResultActivity.this));
                        Log.e("ckecckkkkggd", "onResponse: "+bookTicket.journeyDate );
                        Log.e("fjkggnglk", "onResponse: "+bookTicket.vehicleType );




                    }
                }
            }

            @Override
            public void onFailure(Call<List<SearchResult>> call, Throwable t) {
                Log.e("hvghb", t.getMessage());
            }
        });
    }
}
