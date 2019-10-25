package com.example.salur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Donate extends AppCompatActivity {
    @BindView(R.id.now)
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.now)
        void mlg(){
            startActivity(new Intent(this , Donate_K.class));
        }


}
