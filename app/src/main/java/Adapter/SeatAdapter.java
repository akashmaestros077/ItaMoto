package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itamoto.R;

import java.util.List;

import Model.ChooseSeat;
import Model.SearchResult;

public class SeatAdapter extends RecyclerView.Adapter<SeatAdapter.MyViewHolder> {

    List<ChooseSeat> chooseSeats;

    public SeatAdapter(List<ChooseSeat> chooseSeats) {
        this.chooseSeats = chooseSeats;
    }

    @NonNull
    @Override
    public SeatAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.seat_layout, parent, false);
        return new SeatAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ChooseSeat chooseSeat = chooseSeats.get(position);



    }

    @Override
    public int getItemCount() {
        return chooseSeats.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }}
