package com.example.salur;

import Models.UserAccess;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.salur.API.ApiService;
import com.example.salur.API.RetrofitBuilder;
import com.example.salur.Manager.TokenManager;
import com.example.salur.Models.AccessToken;

public class LoginActivity extends AppCompatActivity {
    private final static String TAG = "LoginActivity";

    UserAccess userAccess1, userAccess2;
    Call<AccessToken> call;
    ApiService service;
    TokenManager tokenManager;

    @BindView(R.id.masuk)
    Button masuk;
    @BindView(R.id.reg)
    Button reg;
    @BindView(R.id.username)
    TextView username;
    @BindView(R.id.pass)
    TextView pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        userAccess1 = UserAccess.getInstance(getSharedPreferences("panti", MODE_PRIVATE));
        userAccess2 = UserAccess.getInstance(getSharedPreferences("donatur", MODE_PRIVATE));

        service = RetrofitBuilder.createService(ApiService.class);
        tokenManager = TokenManager.getInstance(getSharedPreferences("prefs", MODE_PRIVATE));
    }

    @OnClick(R.id.masuk)
    void log(){
        String txtUsername = username.getText().toString();
        String txtPass = pass.getText().toString();

        call = service.login(txtUsername, txtPass);

        call.enqueue(new Callback<AccessToken>() {
            @Override
            public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                Log.w("Login", response.raw().toString());

                if(response.isSuccessful())
                {
                    if(response.code() == 200)
                    {
                        AccessToken accessToken = response.body();
                        tokenManager.saveToken(accessToken);
                        startActivity(new Intent(LoginActivity.this, Home.class));
                        finish();
                    }
                    else if(response.code() == 401)
                    {
                        Toast.makeText(getApplicationContext(), "Wrong Username/Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<AccessToken> call, Throwable t) {
                Log.w("Login", t.getMessage());
            }
        });

    }
    @OnClick(R.id.reg)
    void regist(){
        startActivity(new Intent(this, RegisterActivity.class));
    }
}
