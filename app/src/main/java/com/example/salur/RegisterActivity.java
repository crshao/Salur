package com.example.salur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {
    private final static String TAG = "RegisterActivity";

    @BindView(R.id.pan)
    Button panti;

    @BindView(R.id.don)
    Button donat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.pan)
    void pan(){
        startActivity(new Intent(RegisterActivity.this, Reg_P.class));
    }
    @OnClick(R.id.don)
    void don(){
        startActivity(new Intent(RegisterActivity.this, Reg_D.class));
    }
}
