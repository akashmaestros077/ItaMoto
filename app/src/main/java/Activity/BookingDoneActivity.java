package Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.gson.ToNumberStrategy;
import com.itamoto.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import Model.ViewPdf;
import Other.ApiInterface;
import Other.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookingDoneActivity extends AppCompatActivity {
MaterialButton back_to_home_btn,print_btn ;
ImageView image_back ;
ApiInterface apiInterface;
ProgressBar progressBar;
MaterialCardView ticket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_done);

        back_to_home_btn = findViewById(R.id.back_to_home_btn);
        image_back = findViewById(R.id.image_back);
        print_btn = findViewById( R.id.print_btn);
        progressBar = findViewById(R.id.progressBar);
        ticket = findViewById(R.id.ticket);


        View view = findViewById(R.id.ticket);



        apiInterface = RetrofitClient.getClient().create( ApiInterface.class );
        back_to_home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                startActivity(new Intent(BookingDoneActivity.this,MainActivity.class));
            }
        });
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookingDoneActivity.this,PaymentActivity.class));
            }
        });
        print_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = getBitmapFromView(ticket);
                Toast.makeText(BookingDoneActivity.this,"Ticket Saved To Gallry",Toast.LENGTH_SHORT).show();

                String bitmapPath = MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "palette", "share palette");
                Uri bitmapUri = Uri.parse(bitmapPath);

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("image/png");
                intent.putExtra(Intent.EXTRA_STREAM, bitmapUri);
                startActivity(Intent.createChooser(intent, "Share"));
                }

        });

    }

    public static Bitmap getBitmapFromView(View view) {
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        Drawable bgDrawable =view.getBackground();
        if (bgDrawable!=null)
            bgDrawable.draw(canvas);
        else
            canvas.drawColor(Color.WHITE);
        view.draw(canvas);
        return returnedBitmap;
    }
    }
