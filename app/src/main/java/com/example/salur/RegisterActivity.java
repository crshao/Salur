package com.example.salur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.panti)
    Button panti;
    @BindView(R.id.donat)
    Button donat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    @OnClick(R.id.panti)
    void pan(){
        startActivity(new Intent(this, Reg_P.class));
    }
    @OnClick(R.id.donat)
    void don(){
        startActivity(new Intent(this, Reg_D.class));
    }
}
