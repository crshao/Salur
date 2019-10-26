package com.example.salur;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Relawan extends AppCompatActivity {
    @BindView(R.id.now)
    Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relawan);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.now)
    void lol (){
        startActivity(new Intent(this, Home.class));
        finish();
    }
}
