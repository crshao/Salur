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
    @BindView(R.id.b)
    Button b2;
    @BindView(R.id.c)
    Button b3;
    @BindView(R.id.d)
    Button b4;

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
    @OnClick(R.id.b)
    void mlg1(){ startActivity(new Intent(this , ProfilPantiDiponegoro.class)); }
    @OnClick(R.id.c)
    void mlg2(){
        startActivity(new Intent(this , ProfilPantiIbnuhajar.class));
    }
    @OnClick(R.id.d)
    void mlg3(){
        startActivity(new Intent(this , ProfilPanti10Nopember.class));
    }
}
