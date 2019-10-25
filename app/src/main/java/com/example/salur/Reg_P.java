package com.example.salur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Reg_P extends AppCompatActivity {

    @BindView(R.id.reg)
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg__p);
        ButterKnife.bind(this);


    }
    @OnClick(R.id.reg)
    void lol(){
        startActivity(new Intent(this, Reg_P1.class));
    }
}
