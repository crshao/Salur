package com.example.salur.API;

import com.example.salur.Models.AccessToken;
import com.example.salur.Models.HomePostData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;

public interface ApiService {

    @POST("login")
    @FormUrlEncoded
    Call<AccessToken> login(@Field("username") String username,
                            @Field("password") String password);

    @POST("register")
    @FormUrlEncoded
    Call<AccessToken> register(@Field("name") String nama,
                               @Field("email") String email,
                               @Field("username") String username,
                               @Field("password") String password);

    @POST("login/verify")
    @FormUrlEncoded
    Call<AccessToken> verify(@Field("login_pin") String pin,
                             @Field("username") String username);

    @GET("getPostData")
    Call<ArrayList<HomePostData>> getPostData();



}
