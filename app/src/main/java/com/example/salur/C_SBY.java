package com.example.salur;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class C_SBY extends AppCompatActivity {

    @BindView(R.id.a)
    Button b1;
    @BindView(R.id.b)
    Button b2;
    @BindView(R.id.c)
    Button b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_sby);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.a)
    void mlg(){
        startActivity(new Intent(this , ProfilPantiPenerusKasih.class));
    }
    @OnClick(R.id.b)
    void mlg1(){ startActivity(new Intent(this , ProfilPantiSantaYulia.class)); }
    @OnClick(R.id.c)
    void mlg2(){
        startActivity(new Intent(this , ProfilPantiAsuhanAmanah.class));
    }
}
