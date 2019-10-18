package com.example.salur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;

public class Reg_P1 extends AppCompatActivity {

    @BindView(R.id.next)
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg__p1);
    }

    @OnClick(R.id.next)
    void ulol(){
        startActivity(new Intent(this, Reg_P2.class));
    }

}
