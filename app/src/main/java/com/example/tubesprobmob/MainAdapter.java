package com.example.tubesprobmob;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    List<MainData>dataList;

    Context context;
    public MainAdapter(List<MainData> dataList, Context context){
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_schedule,parent,false);
        MainAdapter.ViewHolder viewHolder = new MainAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MainData data = dataList.get(position);
        holder.matkul.setText(data.getJudulMatkul());
        holder.kelas.setText(data.getKodeMatkul());
        holder.jam.setText(data.getHariJam());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView matkul,kelas,jam;
        ImageView detail;
        CardView relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            matkul = itemView.findViewById(R.id.namaMatkul);
            kelas = itemView.findViewById(R.id.kelas);
            jam = itemView.findViewById(R.id.harijam);
            detail = itemView.findViewById(R.id.detail);
            relativeLayout = itemView.findViewById(R.id.rel);
            relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, scheduleDetail.class);
                    i.putExtra("id", dataList.get(getAdapterPosition()).getID());
                    i.setFlags(FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                }
            });
        }
    }
}
