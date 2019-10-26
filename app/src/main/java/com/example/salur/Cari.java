package com.example.salur;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class Cari extends Fragment {
    @BindView(R.id.mlg)
    Button b1;

    @BindView(R.id.bdg)
    Button bdg;

    @BindView(R.id.jkt)
    Button jkt;

    @BindView(R.id.sby)
    Button sby;

    @BindView(R.id.a)
    Button b0;
    @BindView(R.id.b)
    Button b2;
    @BindView(R.id.c)
    Button b3;
    @BindView(R.id.d)
    Button b4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_cari,container,false);
        ButterKnife.bind(this, view);
        return view;
    }
    @OnClick(R.id.mlg)
    void mlg(){
        startActivity(new Intent(getActivity() , C_mlg.class));
    }

    @OnClick(R.id.sby)
    void sby()
    {
        startActivity(new Intent(getActivity(), C_SBY.class));
    }

    @OnClick(R.id.jkt)
    void jkt()
    {
        startActivity(new Intent(getActivity(), C_jkt.class));
    }

    @OnClick(R.id.bdg)
    void bdg()
    {
        startActivity(new Intent(getActivity(), C_bdg.class));
    }

    @OnClick(R.id.a)
    void mlg0(){
        startActivity(new Intent(getActivity() , Don1.class));
    }
    @OnClick(R.id.b)
    void mlg1(){ startActivity(new Intent(getActivity() , Don2.class)); }
    @OnClick(R.id.c)
    void mlg2(){
        startActivity(new Intent(getActivity() , Don3.class));
    }
    @OnClick(R.id.d)
    void mlg3(){
        startActivity(new Intent(getActivity() , Don4.class));
    }
}

