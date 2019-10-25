package com.example.salur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.salur.API.ApiService;
import com.example.salur.API.RetrofitBuilder;
import com.example.salur.Manager.TokenManager;
import com.example.salur.Models.AccessToken;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Reg_P extends AppCompatActivity {

    private final static String TAG = "RegisterPanti(Reg_P)";

    @BindView(R.id.reg)
    Button b1;

    @BindView(R.id.pname)
    EditText nama;

    @BindView(R.id.pemail)
    EditText email;

    @BindView(R.id.pusername)
    EditText username;

    @BindView(R.id.ppassword)
    EditText password;

    TokenManager tokenManager;
    Call<AccessToken> call;
    ApiService apiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg__p);
        ButterKnife.bind(this);

        tokenManager = TokenManager.getInstance(getSharedPreferences("Panti", MODE_PRIVATE));
        apiService = RetrofitBuilder.createService(ApiService.class);


    }
    @OnClick(R.id.reg)
    void lol(){
        String txtNama = nama.getText().toString();
        String txtEmail = email.getText().toString();
        String txtUsername = username.getText().toString();
        String txtPassword = password.getText().toString();

        call = apiService.register(txtNama, txtEmail, txtUsername, txtPassword);

        call.enqueue(new Callback<AccessToken>() {
            @Override
            public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                Log.w(TAG, "onResponse: " + response.body());

                if(response.isSuccessful())
                {
                    if(response.code() == 200)
                    {
                        tokenManager.saveToken(response.body());
                        startActivity(new Intent(Reg_P.this, LoginActivity.class));
                        finish();
                    }
                }
                else
                {
                    if(response.code() == 401)
                    {
                        Toast.makeText(Reg_P.this, "Email sudah terdaftar, silahkan login pada halaman Login", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<AccessToken> call, Throwable t) {
                Log.w(TAG, t.getMessage());
            }
        });

    }
}
