package com.example.salur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;

public class Donate_K extends AppCompatActivity {
    @BindView(R.id.conf)
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate__k);
    }

    void mlg(){
        startActivity(new Intent(this , Home.class));
    }
}
