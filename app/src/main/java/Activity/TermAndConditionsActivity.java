package Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.itamoto.R;

import java.util.List;

import Model.Term;
import Other.ApiInterface;
import Other.RetrofitClient;
import fragment.HomeFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TermAndConditionsActivity extends AppCompatActivity {
TextView text_term_and_conditions;
ApiInterface apiInterface;
RetrofitClient retrofitClient;
ImageView image_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_and_conditions);
        apiInterface = RetrofitClient.getClient().create(ApiInterface.class);
        image_back = findViewById(R.id.image_back);
        text_term_and_conditions = findViewById(R.id.text_term_and_conditions);
        termConditions();


        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void termConditions() {

       Call<List<Term>> call = apiInterface.term_condition();
       call.enqueue(new Callback<List<Term>>() {

           @Override
           public void onResponse(Call<List<Term>> call, Response<List<Term>> response) {
               if (response.isSuccessful()) {
                   List<Term> termList = response.body();

                   for (Term term : termList) {
                       String id = term.getId();
                       String title = term.getTitle();
                       String content = term.getContent();

                       text_term_and_conditions.setText(Html.fromHtml(content));

                   }
               } else {

                   int errorCode = response.code();
                   String errorMessage = response.message();

               }



           }
           @Override
           public void onFailure(Call<List<Term>> call, Throwable t) {

           }
       });
    }
}