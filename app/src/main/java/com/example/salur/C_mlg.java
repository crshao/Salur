package com.example.salur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class C_mlg extends AppCompatActivity {

    @BindView(R.id.a)
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_mlg);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.a)
    void mlg(){
        startActivity(new Intent(this , Prof_C_P.class));
    }
}
