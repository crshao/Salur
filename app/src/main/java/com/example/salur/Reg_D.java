package com.example.salur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;

public class Reg_D extends AppCompatActivity {

    @BindView(R.id.dnext)
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg__d);
    }
    @OnClick(R.id.dnext)
    void ulol(){
        startActivity(new Intent(this, LoginActivity.class));
    }
}