package com.example.salur;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.sql.BatchUpdateException;

public class ProfilPanti10Nopember extends AppCompatActivity {

    @BindView(R.id.don1)
    Button donate;
    @BindView(R.id.don)
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_panti10_nopember);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.don1)
    void donate()
    {
        startActivity(new Intent(this, Donate.class));
    }
    @OnClick(R.id.don)
    void rel()
    {
        startActivity(new Intent(this, Relawan.class));
    }
}
