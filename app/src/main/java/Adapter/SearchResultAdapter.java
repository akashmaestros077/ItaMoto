package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.itamoto.R;

import java.util.List;

import Activity.ChooseSeatActivity;
import Activity.PickupLocationActivity;
import Activity.SearchResultActivity;
import Model.BookTicket;
import Model.SearchResult;

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.MyViewHolder> {

   private Context context;
   BookTicket bookTicket;
    List<SearchResult> searchResults;

    public SearchResultAdapter(List<SearchResult> searchResults, Context context) {
        this.context = context;
        this.searchResults = searchResults;

        bookTicket = new BookTicket();
    }

    @NonNull
    @Override
    public SearchResultAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_result_list_layout, parent, false);
        return new SearchResultAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SearchResult searchResult = searchResults.get(position);

        holder.text_vehicle.setText(searchResult.getVehicleType());
        holder.start_point.setText(searchResult.getFrom());
        holder.end_point.setText(searchResult.getTo());
        holder.date.setText(searchResult.getStartTime());
        holder.end_time.setText(searchResult.getEndTime());
        holder.seat.setText(searchResult.getNoSeat());

        holder.booknow_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ChooseSeatActivity.class);
                intent.putExtra("book", searchResult);
                context.startActivity(intent);
            }
        });


    }


    @Override
    public int getItemCount() {
        return searchResults.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView text_vehicle;
        public TextView start_point;
        public TextView end_point;
        public TextView date;
        public TextView end_time;
        public TextView seat;
        public MaterialButton booknow_btn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text_vehicle = itemView.findViewById(R.id.text_vehicle);
            date = itemView.findViewById(R.id.date);
            start_point = itemView.findViewById(R.id.start_point);
            end_point = itemView.findViewById(R.id.end_point);
            booknow_btn = itemView.findViewById(R.id.booknow_btn);
            end_time = itemView.findViewById(R.id.end_time);
            seat = itemView.findViewById(R.id.seat);
        }
    }
}
