package com.example.salur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Prof_C_P extends AppCompatActivity {

    @BindView(R.id.don)
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof__p_c);
        ButterKnife.bind(this);
    }
    void mlg(){
        startActivity(new Intent(this , Donate.class));
    }
}
