package com.example.salur;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

import android.os.Bundle;

public class Profil_P extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil__p);
        ButterKnife.bind(this);
    }


}
