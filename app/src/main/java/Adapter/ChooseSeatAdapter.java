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
import Model.ChooseSeat;
import Model.SearchResult;

public class ChooseSeatAdapter extends RecyclerView.Adapter<ChooseSeatAdapter.MyViewHolder> {

    private Context context;
    List<ChooseSeat.SeatData> chooseSeats;

    public ChooseSeatAdapter(List<ChooseSeat.SeatData> searchResults, Context context) {
        this.context = context;
        this.chooseSeats = chooseSeats;
    }

    @NonNull
    @Override
    public ChooseSeatAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.choose_seat, parent, false);
        return new ChooseSeatAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ChooseSeat.SeatData chooseSeat = chooseSeats.get(position);

        holder.start_point.setText((String) chooseSeat.getFrom());
        holder.end_point.setText((String) chooseSeat.getTo());
        holder.text_vehicle.setText((String) chooseSeat.getVehicleType());
        holder.date.setText(chooseSeat.getRouteDate());
        holder.end_time.setText(chooseSeat.getEndTime());


    }

    @Override
    public int getItemCount() {
        return chooseSeats.size();
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

