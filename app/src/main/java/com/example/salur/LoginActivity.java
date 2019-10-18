package com.example.salur;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.salur.API.ApiService;
import com.example.salur.Manager.TokenManager;
import com.example.salur.Models.AccessToken;

public class LoginActivity extends AppCompatActivity {
    private final static String TAG = "LoginActivity";

//    UserAccess userAccess1, userAccess2;
    Call<AccessToken> call;
    ApiService service;
    TokenManager tokenManager;
    @BindView(R.id.masuk)
    Button masuk;
    @BindView(R.id.reg)
    Button reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.masuk)
    void log(){
        startActivity(new Intent(this, Home.class));
    }
    @OnClick(R.id.reg)
    void regist(){
        startActivity(new Intent(this, RegisterActivity.class));
    }
}
