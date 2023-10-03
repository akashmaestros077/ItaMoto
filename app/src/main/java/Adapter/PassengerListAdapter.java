package Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itamoto.R;

import java.util.ArrayList;
import java.util.List;

import Model.PassengerList;

public class PassengerListAdapter extends RecyclerView.Adapter<PassengerListAdapter.MyViewHolder> {
    ArrayList<PassengerList> passengerLists;

    public PassengerListAdapter(List<PassengerList> passengerLists) {
        this.passengerLists = new ArrayList<>(passengerLists);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.passenger_list_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        PassengerList passengerList = passengerLists.get(position);

        holder.text_first_name.setText(passengerList.getFirstName());
        holder.text_last_name.setText(passengerList.getLastName());
        holder.text_age.setText(passengerList.getAge());
        holder.text_number.setText(passengerList.getMobileNumber());
        holder.text_gender.setText(passengerList.getGender());
    }

    @Override
    public int getItemCount() {
        return passengerLists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView text_first_name;
        public TextView text_age;
        public TextView text_number;
        public TextView text_last_name;

        public TextView text_gender;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text_first_name = itemView.findViewById(R.id.text_first_name);
            text_last_name = itemView.findViewById(R.id.text_last_name);
            text_age = itemView.findViewById(R.id.text_age);
            text_number = itemView.findViewById(R.id.text_number);
            text_gender = itemView.findViewById(R.id.text_gender);
        }
    }
}
