package com.example.salur.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.example.salur.Home;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeHolder> {
    private Context context;
    private ArrayList<HomePostData> homePostData;


    @NonNull
    @Override
    public HomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class HomeHolder extends RecyclerView.ViewHolder {
        public HomeHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
