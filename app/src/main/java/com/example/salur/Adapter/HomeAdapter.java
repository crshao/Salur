package com.example.salur.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.salur.Home;
import com.example.salur.Models.HomePostData;
import com.example.salur.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeHolder> {
    private Context context;
    private ArrayList<HomePostData> homePostData;

    public HomeAdapter(Context context, ArrayList<HomePostData> homePostData)
    {
        this.context = context;
        this.homePostData = homePostData;
    }


    @NonNull
    @Override
    public HomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeHolder(LayoutInflater.from(context).inflate(R.layout.test, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHolder holder, int position) {
        final HomePostData homeData = homePostData.get(position);
        //layout belum dibuat
        //layout belum dibuat
    }

    @Override
    public int getItemCount() {
        return homePostData.size();
    }

    public class HomeHolder extends RecyclerView.ViewHolder {
        //layout belum

        public HomeHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
