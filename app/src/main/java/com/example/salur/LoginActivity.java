package com.example.salur;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import retrofit2.Call;

import android.os.Bundle;

import com.example.salur.API.ApiService;
import com.example.salur.Manager.TokenManager;
import com.example.salur.Models.AccessToken;

public class LoginActivity extends AppCompatActivity {
    private final static String TAG = "LoginActivity";

//    UserAccess userAccess1, userAccess2;
    Call<AccessToken> call;
    ApiService service;
    TokenManager tokenManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }
}
